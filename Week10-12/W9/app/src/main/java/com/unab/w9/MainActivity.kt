package com.unab.w9

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var idArticle_txt: EditText
    private lateinit var descriptionA_txt:EditText
    private lateinit var priceA_txt:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        idArticle_txt = findViewById(R.id.txtIdProduct)
        descriptionA_txt = findViewById(R.id.txtDescription)
        priceA_txt = findViewById(R.id.txtPrice)
    }

    fun CreateArticle(V: View){

        val dbStore = ConnectionDB(this,"Store",null,1)
        val connDB: SQLiteDatabase = dbStore.writableDatabase

        val idArticle = idArticle_txt.text.toString()
        val descriptionA = descriptionA_txt.text.toString()
        val priceA = priceA_txt.text.toString()

        if(idArticle.isNotEmpty() && descriptionA.isNotEmpty() && priceA.isNotEmpty()){

            val saveA = ContentValues()
            saveA.put("id_Article", idArticle)
            saveA.put("description", descriptionA)
            saveA.put("price", priceA)

            connDB.insert("article",null, saveA)
            connDB.close()

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

            idArticle_txt.setText("")
            descriptionA_txt.setText("")
            priceA_txt.setText("")

        } else{
            Toast.makeText(this, "Los campos no deben estar vacios", Toast.LENGTH_SHORT).show()
        }
    }

    fun ReadArticle(V: View){

        val dbStore = ConnectionDB(this,"Store",null,1)
        val connDB: SQLiteDatabase = dbStore.writableDatabase

        val idArticle = idArticle_txt.text.toString()

        if (idArticle.isNotEmpty()) {

            val rowList = connDB.rawQuery(" select description, price from article where id_Article = $idArticle ", null )
            if(rowList.moveToFirst()) {

                descriptionA_txt.setText(rowList.getString(0))
                priceA_txt.setText(rowList.getString(1))

            } else{

                Toast.makeText(this, "No existe el articulo", Toast.LENGTH_SHORT).show()
            }
        } else{

            Toast.makeText(this, "Debe ingresar un codigo", Toast.LENGTH_SHORT).show()
        }
    }

    fun UpdateArticle(V: View){

        val dbStore = ConnectionDB(this,"Store",null,1)
        val connDB: SQLiteDatabase = dbStore.writableDatabase

        val idArticle = idArticle_txt.text.toString()
        val descriptionA = descriptionA_txt.text.toString()
        val priceA = priceA_txt.text.toString()

        if (idArticle.isNotEmpty() && descriptionA.isNotEmpty() && priceA.isNotEmpty()){

            val saveA = ContentValues()
            saveA.put("description", descriptionA)
            saveA.put("price", priceA)

            val amount: Int = connDB.update("article", saveA,"id_Article = $idArticle",null)
            connDB.close()

            if (amount == 1){

                Toast.makeText(this,"Modificacion correcta", Toast.LENGTH_SHORT).show()

            } else{

                Toast.makeText(this,"No existe el articulo",Toast.LENGTH_SHORT).show()
            }

            idArticle_txt.setText("")
            descriptionA_txt.setText("")
            priceA_txt.setText("")

        }else{

            Toast.makeText(this,"Debe llenar todos los campos",Toast.LENGTH_SHORT).show()
        }
    }

    fun DeleteArticle(V: View){

        val dbStore = ConnectionDB(this,"Store",null,1)
        val connDB: SQLiteDatabase = dbStore.writableDatabase

        val idArticle = idArticle_txt.text.toString()

        if(idArticle.isNotEmpty()){

            val amount: Int = connDB.delete("article", "id_Article = $idArticle", null)
            connDB.close()

            idArticle_txt.setText("")
            descriptionA_txt.setText("")
            priceA_txt.setText("")

            if(amount==1){

                Toast.makeText(this,"Articulo Eliminado", Toast.LENGTH_LONG).show()

            } else{

                Toast.makeText(this,"No existe el articulo", Toast.LENGTH_LONG).show()
            }

        } else{

            Toast.makeText(this,"Debes ingresar un codigo", Toast.LENGTH_LONG).show()
        }
    }

    fun ClearTBox(V: View){

        idArticle_txt.setText("")
        descriptionA_txt.setText("")
        priceA_txt.setText("")
    }

    fun Next(V: View){

        val activityShared: Intent = Intent(applicationContext, SharedPreferenceApp::class.java)
        startActivity(Intent(activityShared))
    }
}


