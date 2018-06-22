package com.example.titouche.tasty

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class LocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        var fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        val mapFragment = MapFragment()
        fragmentTransaction.replace(R.id.locationHolder, mapFragment)
        fragmentTransaction.commit()
    }
}
