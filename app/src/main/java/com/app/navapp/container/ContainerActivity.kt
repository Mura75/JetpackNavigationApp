package com.app.navapp.container

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.navapp.R

class ContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_container, ContainerFragment.newInstance())
                .commitNow()
        }
    }
}