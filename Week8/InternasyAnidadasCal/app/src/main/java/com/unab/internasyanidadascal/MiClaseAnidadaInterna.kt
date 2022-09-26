package com.unab.internasyanidadascal

class MiClaseAnidadaInterna {

    private val uno = 1
    private fun retornaruno():Int{
        return  uno
    }
    class miclaseanidada
    {
        fun suma(n1:Int, n2:Int):Int
        {
            return  n1 + n2
        }
    }
    inner class miclaseinterna(){
        fun sumardos(num:Int):Int{
            return  num + uno + retornaruno()
        }
    }

}