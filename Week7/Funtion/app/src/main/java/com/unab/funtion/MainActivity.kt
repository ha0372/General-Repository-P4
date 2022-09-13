package com.unab.funtion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.jvm.internal.Intrinsics

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrays()
        securityNull()
    }


    fun arrays(){
        val name = "Carlos"
        val lastname = "Jimenez"
        val departament = "Chalatenango"
        val age = "32"

        //crear el arreglo

        var myArray = arrayListOf<String>()

        //anadir los datos

        myArray.add(name)
        myArray.add(lastname)
        myArray.add(departament)
        myArray.add(age)

        println(myArray)

        //anadir conjunto de datos

        myArray.addAll(listOf("Estudiantes", "Programacion IV"))
        println(myArray)

        // acceso a datos
        var myDepart = myArray[2]
        println(myDepart)
        println(myArray[5])

        //modificar

        myArray[0] = "Kem"
        println(myArray[0])

        // eliminar datos

        myArray.removeAt(2)
        println(myArray)

        myArray.forEach{
            println(it)
        }

        // otras operaciones
        println(myArray.count())
        myArray.clear()
        println(myArray.count())
    }

    fun securityNull(){

        // seguridad contra nulos

        var mtString:String = "Programacion IV 13/09/20022"

        //mtString = null esto daria un error de compilacion
        println(mtString)

        //variable seguridad nulla
        var mySecurityNull:String? = "valor de seguridad nula"

        mySecurityNull = null

        println(mySecurityNull)

        mySecurityNull = "le volvemos a dar un valor"
        println(mySecurityNull)

        if(mySecurityNull != null){

            println(mySecurityNull.toString())
        }else{

            println(mySecurityNull.toString())
        }

        println(mySecurityNull?.length)
        mySecurityNull?.let {
            println(it.toString())
        }?: run {

        }
    }

    fun funciones(){

        decirHola()
        DecirNombre("Nelson",20)
        DecirNombre("Calvito", 22)

        println(sumarNumeros(9,8))
    }

    fun decirHola(){
        println("Hola estudiantes")
    }

    //funcioconparamtros

    fun DecirNombre(nombre:String, edad:Int){

        println("Hola tu nombre es $nombre y tienes $edad")
    }

    fun sumarNumeros(num:Int, num2:Int):Int{

        val suma = num + num2

        return suma
    }

    fun clases(){

        var st = Estudiante("N",27,arrayOf(Estudiante.lengua.JAVA, Estudiante.lengua.PYTHON))

        println(st.nombre)
        st.edad = 22

        var perosna2 = Estudiante("Antonio", edad = 23, arrayOf(Estudiante.lengua.JAVA,Estudiante.lengua.PHP))
        println(perosna2.codigo())

        println("${perosna2.amigo?.first()?.nombre} es amigo de ${perosna2.nombre}")
    }

}

