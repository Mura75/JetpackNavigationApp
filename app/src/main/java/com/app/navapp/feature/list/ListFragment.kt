package com.app.navigation.feature.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.navapp.R
import com.app.navapp.feature.details.DetailsFragment
import com.app.navigation.feature.list.dummy.DataItem
import com.app.navigation.feature.list.dummy.DummyContent

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var toolbar: Toolbar
    private lateinit var list: RecyclerView

    private var columnCount = 1

    private var dataItem: DataItem? = null

    private var title: String = "List"

    private var path: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        columnCount = arguments?.getInt(COLUMN_COUNT, 1) ?: 1
        dataItem = arguments?.getParcelable(ITEM)
        path = arguments?.getString(TITLE, "") ?: "List"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = view.findViewById(R.id.list)
        toolbar = view.findViewById(R.id.toolbar)

        toolbar.title = title
        with(list) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }

            adapter = ItemRecyclerViewAdapter(
                values = DummyContent.ITEMS,
                itemClick = { item ->

                }
            )

        }
    }

    companion object {

        const val ITEM = "item"
        const val COLUMN_COUNT = "column_count"
        const val TITLE = "title"

        @JvmStatic
        fun newInstance() =
            ListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}