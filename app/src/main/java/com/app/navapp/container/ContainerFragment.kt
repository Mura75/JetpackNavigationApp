package com.app.navapp.container

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.navapp.R
import com.app.navigation.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContainerFragment : Fragment() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBottomNavigation(view)
    }

    private fun initBottomNavigation(view: View) {
        bottomNavigationView = view.findViewById(R.id.bottomNavigationView)
        val graphsIds = listOf(
            R.navigation.nav_graph_list,
            R.navigation.nav_graph_push,
            R.navigation.nav_graph_profile
        )
        bottomNavigationView.setupWithNavController(
            navGraphIds = graphsIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.main_nav_host_container,
            intent = requireActivity().intent
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ContainerFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}