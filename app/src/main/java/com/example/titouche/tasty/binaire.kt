package com.example.titouche.tasty

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_binaire.*
import kotlinx.android.synthetic.main.content_binaire.*
import kotlinx.android.synthetic.main.content_resto.*
import org.jetbrains.anko.toast

class binaire : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binaire)
        setSupportActionBar(toolbar)

        fabOffreBinaire.setOnClickListener({view ->
            val intent = Intent(this,
                    PanierActivity::class.java)
            startActivity(intent)
        })

        logoOffreBinaire.setOnClickListener({view ->
            val intent = Intent(this,
                    MainActivity::class.java)
            startActivity(intent)
        })

        buttonOffre1.setOnClickListener({view->
            toast("Ajouté")
        })

        buttonOffre2.setOnClickListener({view->
            toast("Ajouté")
        })

        buttonOffre3.setOnClickListener({view->
            toast("Ajouté")
        })
    }

}
