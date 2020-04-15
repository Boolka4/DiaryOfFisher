package com.diary.fisher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupViews()
    }

    private fun setupViews() {
        // Finding the Navigation Controller
        val navController = findNavController(R.id.fragNavHost)

        // Setting Navigation Controller with the BottomNavigationView
        bottomNavView.setupWithNavController(navController)

        // Setting Up ActionBar with Navigation Controller
        setupActionBarWithNavController(navController)
    }
}
