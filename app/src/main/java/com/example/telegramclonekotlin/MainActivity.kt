package com.example.telegramclonekotlin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawer_layout: DrawerLayout
    lateinit var imageView: ImageView
    lateinit var title: TextView
    lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawer_layout = findViewById(R.id.drawer_layout)
        imageView = findViewById(R.id.imageMenu)
        title = findViewById(R.id.textTitle)
        imageView.setOnClickListener { drawer_layout.openDrawer(GravityCompat.START) }
        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        navigationView.itemIconTintList = null

        val navController = Navigation.findNavController(this, R.id.navHostFragment)
        NavigationUI.setupWithNavController(navigationView, navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            title.text = destination.label
        }

        appBarConfiguration = AppBarConfiguration.Builder(R.id.menuProfile)
            .setDrawerLayout(drawer_layout)
            .build()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.navHostFragment)
        return NavigationUI.navigateUp(
            navController,
            appBarConfiguration
        ) || super.onSupportNavigateUp()
    }
}