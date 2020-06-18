package com.cy.cblog.ui.main.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cy.cblog.databinding.FragmentNotificationsBinding
import com.cy.cblog.frame.CFragment
import com.cy.home.ui.notifications.NotificationsViewModel

class NotificationsFragment : CFragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var binding:FragmentNotificationsBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel = ViewModelProvider(this).get(
            NotificationsViewModel::class.java)
        binding = FragmentNotificationsBinding.inflate(layoutInflater)

        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textNotifications.text = it
        })
        return binding.root
    }
}