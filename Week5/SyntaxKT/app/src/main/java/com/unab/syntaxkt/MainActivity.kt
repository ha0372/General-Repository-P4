package com.unab.syntaxkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TiposDevariblesExDe()
        principal()
    }

    fun Ejer1(){

        var name = "carlos"
        var lastname = "henriquez"
        println(name +" "+ lastname)

        name = "nelson"
        lastname = "calles"
        println(name +" "+ lastname)

        val yearB = 2000
        var yearA = Calendar.getInstance().get(Calendar.YEAR)
        println(yearA - yearB)
    }

    private fun TiposDevariblesExDe(){
        //tipo entero

        var enteroExplicito:Int = 45
        var enteroDeducido = 45
        println(enteroDeducido.javaClass)

        var longExplicito:Long = 454545L
        var longDeducido = 454545L
        println(longDeducido.javaClass)

        var doubleExplicito:Double = 45.45
        var doubleDeducido = 45.45
        println(doubleDeducido.javaClass)

        var flotanteExplicito:Float = 45.45F
        var flotanteDeducido = 45.45F
        println(flotanteDeducido.javaClass)

        var stringExplicito:String = "45"
        var stringDeducido = "45"
        println(stringDeducido.javaClass)

    }

    private fun Operadores() {

        val num1= 4
        val num2= 6

        //Suma
        var suma:Int= num1 + num2
        println("Suma: "+suma)

        //Resta
        var resta:Int = num1 - num2
        println("Resta: "+resta)

        //Multiplicación
        var multiplicar:Int = num1 * num2
        println("Multiplicar: "+multiplicar)

        //División
        var dividir:Int = num1 / num2
        println("Dividir: "+dividir)


        //Boolean (boot)
        val boolean1: Boolean = true
        val boolean2 = false
        println(boolean1 == boolean2)
        println(boolean1 && boolean2)

    }

    fun principal () {

        println("Hola Mundo")

        saluda(nombre = "C", apellido = "Z")

        var saludo = retornarSaludo(nombre = "Z", apellido = "Z")
        println(saludo)

        var suma = suma(13.4, num2 = 74.1F)
        println(suma)
    }

    fun  saluda(nombre:String,apellido:String){
        println(nombre+ " "+apellido)
    }

    fun retornarSaludo(nombre: String, apellido: String):String{

        return  (nombre+" "+apellido)
    }

    var resSuma = suma(num1=1.5,num2=2.235f)
    var redon = Redondeo(num=25.55)

    fun suma(num1:Double,num2:Float): Double {

        var resultado = num1+num2
        println(resultado.javaClass)
        return resultado
    }

    fun Redondeo(num:Double):Double{

        var redondeo = Math.ceil(num)

        return redondeo
    }

    fun Mostrar(num:Double){

        println(String.format("$%.2f",num))
    }

    private fun sentencialIF()
    {
        val miNum1 = 12
        val miNum2 = 8
        val miNum3 = 45
        val miNum4 = 50
        val miNum5 = 6

        if(miNum1 <=10){
            println("$miNum1 es menor o igual que 10")
        }else
        {
            println("$miNum1 es mayor que 10")
        }
    }

    private fun sentenciaWhen() {
        val pais = "El salvador"
        when (pais) {
            "El salvador" -> {
                println("El idioma de $pais es el español")
            }
            "Brasil" -> {
                println("El idioma de $pais es el portuges")
            }
            "EstadosUnidos" -> {
                println("El idioma de $pais es el Ingles ")
            }
            else ->{
                println("No se encontro el pais, entonces no sabemos el idioma ")
            }
        }

        val edad =20

        when(edad)
        {
            0,1,2 ->{
                println("Eres bebe")
            }
            in 3 ..10 ->{
                println("Eres niño")
            }
            in 11 ..17->{
                println("Eres adolesente")
            }
            in 18 ..30 ->{
                println("Eres adulto joven")
            }
            in 31 ..69 ->{
                println("Eres adulto")
            }
            in 70 ..99 ->{
                println("Eres  anciano")
            }
            else->{
                println("ya es hora de morirse xd")
            }
        }



    }
    private fun buclefor()
    {
        val miArreglo = listOf("h","l", "ls")

        for (miString in miArreglo)
        {
            println(miString)
        }

        for(x in 0 ..10)
        {
            println(x)
        }

        for (x in 0 until 10)
        {
            println(x)
        }
        for (x in 0 ..10 step 2)
        {
            println(x)
        }
        for (x in 10 downTo 0 step 3)
        {
            println(x)
        }

    }
    fun mostrar(num:Double)
    {
        println(String.format("$%.2f",num))

    }
}