package com.app.navapp.feature.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.app.navapp.R
import com.app.navigation.feature.list.ListFragment
import com.app.navigation.feature.list.dummy.DataItem

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var toolbar: Toolbar
    private lateinit var tvName: TextView
    private lateinit var tvPath: TextView
    private lateinit var buttonSubItems: Button

    private var dataItem: DataItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataItem = arguments?.getParcelable(ITEM)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        tvName = view.findViewById(R.id.tvName)
        tvPath = view.findViewById(R.id.tvPath)
        buttonSubItems = view.findViewById(R.id.buttonSubItems)

        dataItem?.let {
            toolbar.title = it.content
            tvName.text = it.details
        }

        buttonSubItems.setOnClickListener {

        }
    }

    companion object {

        const val ITEM = "item"
        const val TITLE = "title"

        @JvmStatic
        fun newInstance() =
            DetailsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}