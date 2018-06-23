package com.example.titouche.tasty

import android.app.Fragment
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    lateinit var res: Restaurant
    private var content: FrameLayout? = null
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                val fragment = EntreeListFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val fragment = PlatListFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val fragment = DessertListFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        res = intent.getSerializableExtra("resto") as Restaurant

        content = findViewById<FrameLayout>(R.id.frameLayout)
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        val fragment = EntreeListFragment.Companion.newInstance()
        addFragment(fragment)
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun addFragment(fragment: android.support.v4.app.Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.frameLayout, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }


}
