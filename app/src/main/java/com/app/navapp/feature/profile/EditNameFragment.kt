package com.app.navapp.feature.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.app.navapp.R

class EditNameFragment : Fragment() {

    private lateinit var toolbar: Toolbar
    private lateinit var etName: EditText
    private lateinit var buttonDone: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        etName = view.findViewById(R.id.etName)
        buttonDone = view.findViewById(R.id.buttonDone)

        buttonDone.setOnClickListener {
            val name = etName.text.toString()
            setFragmentResult(REQUEST_KEY, Bundle().apply { putString("name", name) })
            findNavController().popBackStack(R.id.profileFragment, false)
        }
    }

    companion object {

        const val REQUEST_KEY = "EDIT_NAME_REQUEST_KEY"

        @JvmStatic
        fun newInstance() =
            EditNameFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}