package com.cy.cblog.ui.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cy.cblog.databinding.FragmentTabBinding
import com.cy.cblog.frame.CFragment

/**
 * class
 * @author Cyong
 * @date 2020/6/22 10:18
 */
class PlaceholderFragment:CFragment() {
    private lateinit var pageViewModel: PageViewModel
    private lateinit var binding:FragmentTabBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER)?:1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabBinding.inflate(layoutInflater)

//        binding.scrollingLayout.largeText.movementMethod = ScrollingMovementMethod.getInstance()
        pageViewModel.text.observe(viewLifecycleOwner , Observer {
            binding.scrollingLayout.largeText.text = it
        })
        return binding.root
    }


    companion object{
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

}