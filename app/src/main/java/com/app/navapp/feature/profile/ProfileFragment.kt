package com.app.navigation.feature.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.app.navapp.R
import com.app.navapp.feature.profile.EditNameFragment

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var tvSettings: TextView
    private lateinit var tvFaq: TextView
    private lateinit var tvAbout: TextView
    private lateinit var tvMyItems: TextView
    private lateinit var tvName: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvName = view.findViewById(R.id.tvName)
        tvSettings = view.findViewById(R.id.tvSettings)
        tvFaq = view.findViewById(R.id.tvFaq)
        tvAbout = view.findViewById(R.id.tvAbout)
        tvMyItems = view.findViewById(R.id.tvMyItems)

        tvSettings.setOnClickListener {

        }
        tvFaq.setOnClickListener {

        }
        tvAbout.setOnClickListener {

        }
        tvMyItems.setOnClickListener {

        }

        setFragmentResultListener(EditNameFragment.REQUEST_KEY) { _, bundle ->
            val name = bundle.getString("name")
            tvName.setText(name)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ProfileFragment().apply {

            }
    }
}