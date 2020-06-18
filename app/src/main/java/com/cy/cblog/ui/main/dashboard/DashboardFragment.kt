package com.cy.cblog.ui.main.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cy.cblog.R
import com.cy.cblog.databinding.FragmentDashboardBinding
import com.cy.cblog.frame.CFragment
import com.cy.cblog.ui.detail.DetailActivity
import com.cy.cblog.ui.main.MainActivity
import com.cy.cblog.ui.setting.SettingActivity
import com.cy.home.ui.dashboard.DashboardViewModel

class DashboardFragment : CFragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var binding:FragmentDashboardBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel = ViewModelProvider(this).get(
            DashboardViewModel::class.java)
        binding = FragmentDashboardBinding.inflate(layoutInflater)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textDashboard.text = it
        })

        binding.buttonDetail.setOnClickListener{
            startActivity(Intent(activity , DetailActivity::class.java))
        }

        setHasOptionsMenu(true)//Fragment需要调用此方法才会触发onCreateOptionsMenu 启用menu

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        Toast.makeText(activity , item.title , Toast.LENGTH_SHORT).show()
        return when (item.itemId) {
            R.id.options_setting -> {
                startActivity(Intent(activity , SettingActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}