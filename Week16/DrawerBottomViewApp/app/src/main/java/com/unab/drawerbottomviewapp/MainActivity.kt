package com.unab.drawerbottomviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toogle: ActionBarDrawerToggle
    private lateinit var dlView: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dlView = findViewById(R.id.dl_View)
        navView = findViewById(R.id.nav_View)
        toogle = ActionBarDrawerToggle(this,dlView,R.string.open_drawer,R.string.close_drawer)

        toogle?.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId) {

                R.id.navHome -> {
                    supportFragmentManager.beginTransaction().apply {

                        replace(R.id.fcv_View, HomeFragment())
                        commit()
                    }

                }

                R.id.navCamera -> {
                    supportFragmentManager.beginTransaction().apply {

                        replace(R.id.fcv_View, CameraFragment())
                        commit()
                    }

                }

                R.id.navGalley -> {
                    supportFragmentManager.beginTransaction().apply {

                        replace(R.id.fcv_View, GalleryFragment())
                        commit()
                    }
                }

                R.id.navMessage -> {
                    supportFragmentManager.beginTransaction().apply {

                        replace(R.id.fcv_View, MessageFragment())
                        commit()
                    }
                }
            }

            dlView.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toogle.onOptionsItemSelected(item))
        {
            return true

        } else
        {
            return super.onOptionsItemSelected(item)
        }
    }
}