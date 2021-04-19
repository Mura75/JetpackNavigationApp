package com.app.navapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.app.navigation.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Notifier.init(this)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val res = when (item.itemId) {
                R.id.nav_graph_list -> { R.navigation.nav_graph_list }
                R.id.nav_graph_push -> { R.navigation.nav_graph_push }
                else -> { R.navigation.nav_graph_profile }
            }
            val navHostFragment = NavHostFragment.create(res)
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_nav_host_container, navHostFragment)
                .commitNow()
            true
        }
        bottomNavigationView.selectedItemId = R.id.nav_graph_list
    }
}