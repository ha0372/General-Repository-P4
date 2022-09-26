package com.unab.internasyanidadascal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var etn_valor1:EditText? = null
    lateinit var etn_valor2:EditText
    lateinit var tv_Resultado:TextView

    lateinit var rSum:RadioButton
    lateinit var rRes:RadioButton
    lateinit var rMul:RadioButton
    lateinit var rDiv:RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etn_valor1 = findViewById(R.id.txtNum1)
        etn_valor2 = findViewById(R.id.txtNum2)
        tv_Resultado = findViewById(R.id.lblMostrar)

        rSum = findViewById(R.id.rbtnSum)
        rRes = findViewById(R.id.rbtnRes)
        rMul = findViewById(R.id.rbtnMult)
        rDiv = findViewById(R.id.rbtnDiv)
    }

    fun calcular(vi:View){

        var valor1 = etn_valor1?.text.toString()
        var valor2 = etn_valor2.text.toString()

        var num1 = valor1.toInt()
        var num2 = Integer.parseInt(valor2)

        if(rSum.isChecked == true){

            var r = num1 + num2
            var resultado = r.toString()
            tv_Resultado.setText(resultado)

        }else if(rRes.isChecked == true){

            var r = num1 - num2
            var resultado = r.toString()
            tv_Resultado.setText(resultado)

        }else if(rMul.isChecked == true){

            var r = num1 * num2
            var resultado = r.toString()
            tv_Resultado.setText(resultado)

        }else if(rDiv.isChecked == true){

            if(num1 != 0 && num2 != 0){

                var r = num1 / num2
                var resultado = r.toString()
                tv_Resultado.setText(resultado)

            }else{

                Toast.makeText(this, "No se puede dividir por un valor 0",Toast.LENGTH_LONG).show()
            }
        }


        /*var r = num1 + num2

        var resultado = r.toString()
        tv_Resultado.setText(resultado)*/
    }

    private fun claseAnidadasyInternas(){
        val miclaseanidada = MiClaseAnidadaInterna.miclaseanidada()
        val sumardosnum = miclaseanidada.suma(5,6)
        println("El resultado de la suma es $sumardosnum")

        // clase interna
        val miclaseinterna1 = MiClaseAnidadaInterna().miclaseinterna()
        val sumardos = miclaseinterna1.sumardos(5)
        println("El resultado de la suma dos es $sumardos")
    }
}