package com.cy.cblog.ui.main

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.view.menu.MenuBuilder
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cy.cblog.R
import com.cy.cblog.databinding.ActivityMainBinding
import com.cy.cblog.frame.CActivity
import java.lang.Exception

/**
 * MainActivity
 * @author Cyong
 * @date 2020/6/16 16:32
 */
class MainActivity : CActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications , R.id.navigation_wifi))
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }


    override fun onMenuOpened(featureId: Int, menu: Menu?): Boolean {
        //通过反射，设置Fragment下的Menu的图标一直显示
        if(menu?.javaClass == MenuBuilder::class.java){
            try {
                val method = menu.javaClass.getDeclaredMethod("setOptionalIconsVisible" , Boolean::class.java)
                method.isAccessible = true
                method.invoke(menu , true)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
        return super.onMenuOpened(featureId, menu)
    }
}