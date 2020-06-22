package com.cy.cblog.ui.tab

import android.os.Bundle
import android.view.MenuItem
import com.cy.cblog.databinding.ActivityTabBinding
import com.cy.cblog.frame.CActivity
import com.google.android.material.snackbar.Snackbar

/**
 * Tab页
 * @author Cyong
 * @date 2020/6/22 10:01
 */
class TabActivity:CActivity() {

    private lateinit var binding: ActivityTabBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragment()
        binding.fab.setOnClickListener {
            Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            //setDisplayHomeAsUpEnabled后监听返回按钮事件
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initFragment(){
        val sectionsPagerAdapter = SectionsPagerAdapter(this , supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }
}