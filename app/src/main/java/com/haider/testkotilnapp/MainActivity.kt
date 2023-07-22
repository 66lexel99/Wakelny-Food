
// MainActivity codes:

package com.haider.testkotilnapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar



class MainActivity : AppCompatActivity() {

    // ... Your other code ...

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ... Your other code ...
        val toolbar = findViewById<Toolbar>(R.id.appBar)

        // Set up the navigation drawer
        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        val navigationListView = navigationView.findViewById<ListView>(R.id.navigationListView)
        val menuItems = arrayOf("Home", "Categories", "Orders", "Contacts") // Add more items as needed
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, menuItems)
        navigationListView.adapter = adapter

        // Set the app bar title here
        toolbar.setTitle(R.string.food_app)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        // Set up the ActionBarDrawerToggle
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Handle the menu item clicks
        navigationListView.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    // Handle "Home" click
                }
                1 -> {
                    // Handle "Categories" click
                    // Replace the current fragment with the CategoriesFragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, CategoriesFragment())
                        .commit()

                    // Close the navigation drawer after handling the click
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                2 -> {
                    // Handle "Orders" click
                }
                3 -> {
                    // Handle "Contacts" click
                }
                // Add more cases for additional menu items
            }
        }
    }


}