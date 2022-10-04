package com.unab.internasyanidadascalculadora

import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var etn_Valor1:EditText?=null
    lateinit var  etn_Valor2:EditText
    lateinit var tv_Resultado:TextView
    lateinit var rb_Suma:RadioButton
    lateinit var rb_Resta:RadioButton
    lateinit var rb_Dividir:RadioButton
    lateinit var rb_Multiplicar:RadioButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // claseAnidadasyInternas()
        etn_Valor1 = findViewById(R.id.etn_Valor1)
        etn_Valor2 = findViewById(R.id.etn_Valor2)
        tv_Resultado = findViewById(R.id.tv_Resultado)
        rb_Suma = findViewById(R.id.rb_Suma)
        rb_Resta = findViewById(R.id.rb_Resta)
        rb_Dividir = findViewById(R.id.rb_Dividir)
        rb_Multiplicar = findViewById(R.id.rb_Multiplicar)
    }
    fun calcular(vi:View){
        val valor1_String = etn_Valor1?.text.toString()
        val valor2_String = etn_Valor2.text.toString()

        val valor1_Int = valor1_String.toInt()
        val valor2_Int = Integer.parseInt(valor2_String)

        if(rb_Suma.isChecked==true){
             val suma = valor1_Int+valor2_Int

            var resultado = suma.toString()
            tv_Resultado.setText(resultado)

        }else if(rb_Resta.isChecked == true){

            val suma= valor1_Int-valor2_Int
            var resultado = suma.toString()
            tv_Resultado.setText(resultado)

        }else if(rb_Dividir.isChecked == true){

            val suma = valor1_Int/valor2_Int
            var resultado = suma.toString()
            tv_Resultado.setText(resultado)

        }else if(rb_Multiplicar.isChecked == true){

            if(valor1_Int != 0 && valor2_Int != 0){

                val suma = valor1_Int*valor2_Int
                var resultado = suma.toString()
                tv_Resultado.setText(resultado)

            }else{

                Toast.makeText(this, " No se puede dividir por un valo 0",Toast.LENGTH_LONG).show()
            }
        }




       // val suma = valor1_Int+valor2_Int
        //val resultado = suma.toString()
        //tv_Resultado.setText(resultado)


    }
   private fun claseAnidadasyInternas(){
       val miclaseanidada = miClaseAnidadayInterna.miclaseanidada()
       val sumardosnum = miclaseanidada.suma(5,6)
       println("El resultado de la suma es $sumardosnum")

       // clase interna
       val miclaseinterna1 = miClaseAnidadayInterna().miclaseinterna()
       val sumardos = miclaseinterna1.sumardos(5)
       println("El resultado de la suma dos es $sumardos")
   }

    fun btnSiguiente(Vistas:View){
        val ventanaSiguiente:Intent = Intent(applicationContext,ListViewApp::class.java)
        startActivity(ventanaSiguiente)
    }
}