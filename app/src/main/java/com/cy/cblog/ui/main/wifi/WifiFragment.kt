package com.cy.cblog.ui.main.wifi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cy.cblog.databinding.FragmentWifiBinding
import com.cy.cblog.frame.CFragment

/**
 * class
 * @author Cyong
 * @date 2020/6/17 9:58
 */
class WifiFragment: CFragment() {

    private lateinit var wifiViewModel: WifiViewModel

    private lateinit var binding:FragmentWifiBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        wifiViewModel = ViewModelProvider(this).get(
            WifiViewModel::class.java)

        binding = FragmentWifiBinding.inflate(layoutInflater)
        wifiViewModel.text.observe(viewLifecycleOwner , Observer {
            binding.textWifi.text = it
        })
        return binding.root
    }

}