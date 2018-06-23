package com.example.titouche.tasty

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.activity_resto.*
import kotlinx.android.synthetic.main.content_resto.*

class resto : AppCompatActivity() {
    lateinit var res: Restaurant

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resto)
        setSupportActionBar(toolbar)
        res = intent.getSerializableExtra("resto") as Restaurant

        Glide.with(this).load(RetrofitService.baseUrl+res.image).into(this.header_image)
        restoName.setText(res.nom)

        //Menu
        imageViewMenu.setOnClickListener({view ->
            val intent = Intent(this,
                    MenuActivity::class.java)
            intent.putExtra("resto", res)
            startActivity(intent)
        })
        buttonMenu.setOnClickListener({view ->
            val intent = Intent(this,
                    MenuActivity::class.java)
            intent.putExtra("resto", res)
            startActivity(intent)
        })
        //Menu Special
        imageViewSpecial.setOnClickListener({view ->
            val intent = Intent(this,
                    MenuSpecialActivity::class.java)
            intent.putExtra("resto", res)
            startActivity(intent)
        })
        buttonMenuSpecial.setOnClickListener({view ->
            val intent = Intent(this,
                    MenuSpecialActivity::class.java)
            intent.putExtra("resto", res)
            startActivity(intent)
        })
        //OffreBinaire
        imageViewOffre.setOnClickListener({view ->
            val intent = Intent(this,
                    binaire::class.java)
            intent.putExtra("resto", res)
            startActivity(intent)
        })
        buttonOffre.setOnClickListener({view ->
            val intent = Intent(this,
                    binaire::class.java)
            intent.putExtra("resto", res)
            startActivity(intent)
        })

        //Reservation
        imageViewReservation.setOnClickListener({view ->
            val intent = Intent(this,
                    Reservation::class.java)
            intent.putExtra("resto", res)
            startActivity(intent)
        })
        buttonReservationPanier.setOnClickListener({ view ->
            val intent = Intent(this,
                    Reservation::class.java)
            intent.putExtra("resto", res)
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
            intent.putExtra("resto", res)
            startActivity(intent)
        })
        //Panier
        buttonPanier.setOnClickListener({view ->
            val intent = Intent(this,
                    PanierActivity::class.java)
            intent.putExtra("resto", res)
            startActivity(intent)
        })



    }

}
