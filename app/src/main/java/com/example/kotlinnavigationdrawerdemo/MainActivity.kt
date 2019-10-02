package com.example.kotlinnavigationdrawerdemo

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configure action bar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Hello Toolbar"

        // Initialize the action bar drawer toggle instance
        val drawerToggle:ActionBarDrawerToggle = object : ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.drawer_open, R.string.drawer_close)
        {
            override fun onDrawerClosed(view: View){
                super.onDrawerClosed(view)
                //toast("Drawer closed")
            }

            override fun onDrawerOpened(drawerView: View){
                super.onDrawerOpened(drawerView)
                //toast("Drawer opened")
            }
        }


        // Configure the drawer layout to add listener and show icon on toolbar
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()


        // Set navigation view navigation item selected listener
        navigation_view.setNavigationItemSelectedListener{
            when (it.itemId){
                R.id.action_home ->{
                    toast("Home clicked")
                }

                R.id.action_about ->{
                    toast("About clicked")
                }

                R.id.action_contact ->{
                    toast("Contact clicked")
                }

                R.id.action_close ->{
                    toast("Close clicked")
                    finish()
                }
            }
            // Close the drawer
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }

    // Extension function to show toast message easily
    private fun Context.toast(message:String){
        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }

    private fun navigateFragment(fragmentTonavigate: Fragment)
    {

    }
}
