package com.unab.drawerbottomviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomActivity : AppCompatActivity() {

    private  lateinit var btnvMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom)

        var homeF = HomeFragment()
        var messageF = MessageFragment()
        var perfilF = PerfilFragment()

        SetFragmentNow(homeF)

        btnvMenu = findViewById(R.id.bnv_Menu)

        btnvMenu.setOnNavigationItemReselectedListener{
            when(it.itemId){
                R.id.myHome->{
                    SetFragmentNow(homeF)
                }
                R.id.myMessage->{
                    SetFragmentNow(messageF)
                }
                R.id.myPerfil->{
                    SetFragmentNow(perfilF)
                }
            }
        }
    }

    private fun SetFragmentNow(fragmnet: Fragment) = supportFragmentManager.beginTransaction().apply {

        replace(R.id.fl_vista, fragmnet)
        commit()
    }
}