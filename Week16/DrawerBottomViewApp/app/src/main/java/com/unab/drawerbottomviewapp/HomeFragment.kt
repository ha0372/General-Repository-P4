package com.unab.drawerbottomviewapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var btnAc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAc = view.findViewById(R.id.btnReturn)
        btnAc.setOnClickListener{

            val windows: Intent = Intent(context, BottomActivity::class.java)
            startActivity(windows)
        }
    }

    companion object {

    }
}