package com.cy.cblog.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cy.cblog.databinding.FragmentHomeBinding
import com.cy.cblog.frame.CFragment
import com.cy.home.ui.home.HomeViewModel

class HomeFragment : CFragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(
            HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textHome.text = it
        })
        return binding.root
    }
}