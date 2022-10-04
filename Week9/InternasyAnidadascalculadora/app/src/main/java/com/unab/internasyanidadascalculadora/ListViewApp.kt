package com.unab.internasyanidadascalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class ListViewApp : AppCompatActivity() {
    //Creacion de variables
    private var lvLLenguajes:ListView?=null
    private var tvSeleccion:TextView?=null

    private val Lenguajes = arrayOf("Kotlin","Java","C++","C#","php","VB.net")
    private val posicion = arrayOf("1","6","3","2","4","5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listviewapp)

        lvLLenguajes=findViewById(R.id.lv_Lenguajes)
        tvSeleccion=findViewById(R.id.tv_Seleccion)



        var adaptador:ArrayAdapter<String> = ArrayAdapter <String>(this,R.layout.activity_items,Lenguajes)
        lvLLenguajes?.adapter=adaptador

        lvLLenguajes?.onItemClickListener = object : AdapterView.OnItemClickListener{



            override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                tvSeleccion?.text="La posicion del lenguaje ${lvLLenguajes?.getItemAtPosition(position)} es ${posicion[position]}"
            }

        }

    }
}