package com.unab.w9

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class SharedPreferenceApp : AppCompatActivity() {

    private lateinit var name_txt: EditText
    private lateinit var lastName_txt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference_app)

        name_txt = findViewById(R.id.txtName)
        lastName_txt = findViewById(R.id.txtLastName)

        var pref = getSharedPreferences("dataPerson", Context.MODE_PRIVATE)
        var nameP = pref.getString("nombre", "")
        var lastNameP = pref.getString("apellido", "")

        name_txt.setText(nameP)
        lastName_txt.setText(lastNameP)
    }

    fun Save(V: View){

        var pref = getSharedPreferences("dataPerson", Context.MODE_PRIVATE)
        var editor = pref.edit()

        editor.putString("nombre", name_txt.text.toString())
        editor.putString("apellido", lastName_txt.text.toString())
        editor.commit()
        Toast.makeText(this, "Se ha guardado exitosamente", Toast.LENGTH_SHORT).show()
    }
}