package com.example.titouche.tasty

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_reservation.*

class Reservation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)
        setSupportActionBar(toolbar)

        buttonReservationPanier.setOnClickListener({ view ->
            val intent = Intent(this,
                    PanierActivity::class.java)
            startActivity(intent)
        })

        logoReservation.setOnClickListener({view ->
            val intent = Intent(this,
                    MainActivity::class.java)
            startActivity(intent)
        })
    }

}
