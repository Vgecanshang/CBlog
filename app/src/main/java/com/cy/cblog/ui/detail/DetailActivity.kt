package com.cy.cblog.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cy.cblog.R
import com.cy.cblog.databinding.ActivityDetailBinding
import com.cy.cblog.frame.CActivity
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception

/**
 * class
 * @author Cyong
 * @date 2020/6/17 10:57
 */
class DetailActivity : CActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        detailViewModel = ViewModelProvider(this).get(
            DetailViewModel::class.java
        )
        detailViewModel.text.observe(this, Observer {
            binding.scrollingLayout.largeText.text = "我是ViewModel设置的" + it
        })

        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener {
            val scanBar = Snackbar.make(it, "写留言", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
//            scanBar.view.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent))
//            scanBar.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary))
            scanBar.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.detail_options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        println("onOptionsItemSelected item.id=" + item.itemId)
        return when (item.itemId) {
            R.id.options_get -> {
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.options_share -> {
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onMenuOpened(featureId: Int, menu: Menu?): Boolean {
        //通过反射，设置Menu的图标一直显示
        if (menu?.javaClass == MenuBuilder::class.java) {
            try {
                val method =
                    menu.javaClass.getDeclaredMethod("setOptionalIconsVisible", Boolean::class.java)
                method.isAccessible = true
                method.invoke(menu, true)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return super.onMenuOpened(featureId, menu)
    }

}