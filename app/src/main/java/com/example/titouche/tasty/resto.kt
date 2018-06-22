package com.example.titouche.tasty

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_resto.*
import kotlinx.android.synthetic.main.content_resto.*

class resto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resto)
        setSupportActionBar(toolbar)

        //Menu
        imageViewMenu.setOnClickListener({view ->
            val intent = Intent(this,
                    MenuActivity::class.java)
            startActivity(intent)
        })
        buttonMenu.setOnClickListener({view ->
            val intent = Intent(this,
                    MenuActivity::class.java)
            startActivity(intent)
        })
        //Menu Special
        imageViewSpecial.setOnClickListener({view ->
            val intent = Intent(this,
                    MenuSpecialActivity::class.java)
            startActivity(intent)
        })
        buttonMenuSpecial.setOnClickListener({view ->
            val intent = Intent(this,
                    MenuSpecialActivity::class.java)
            startActivity(intent)
        })
        //OffreBinaire
        imageViewOffre.setOnClickListener({view ->
            val intent = Intent(this,
                    binaire::class.java)
            startActivity(intent)
        })
        buttonOffre.setOnClickListener({view ->
            val intent = Intent(this,
                    binaire::class.java)
            startActivity(intent)
        })

        //Reservation
        imageViewReservation.setOnClickListener({view ->
            val intent = Intent(this,
                    Reservation::class.java)
            startActivity(intent)
        })
        buttonReservationPanier.setOnClickListener({ view ->
            val intent = Intent(this,
                    Reservation::class.java)
            startActivity(intent)
        })
        //Main Activity
        logo.setOnClickListener({view ->
            val intent = Intent(this,
                    MainActivity::class.java)
            startActivity(intent)
        })
        //Location
        buttonLocation.setOnClickListener({view ->
            val intent = Intent(this,
                    LocationActivity::class.java)
            startActivity(intent)
        })
        //Panier
        buttonPanier.setOnClickListener({view ->
            val intent = Intent(this,
                    PanierActivity::class.java)
            startActivity(intent)
        })



    }

}
