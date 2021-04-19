package com.app.navigation.feature.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.navapp.R

class FaqFragment : Fragment(R.layout.fragment_faq) {

    companion object {
        @JvmStatic
        fun newInstance() =
            FaqFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}