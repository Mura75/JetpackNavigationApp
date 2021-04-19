package com.app.navigation.feature.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.app.navapp.Notifier
import com.app.navapp.R

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var buttonPush: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonPush = view.findViewById(R.id.buttonPush)
        buttonPush.setOnClickListener {
            createPush()
        }
    }

    private fun createPush() {
        val args = Bundle().apply {
            putString("text", "hello new navigation")
            putInt("rating", (1..5).random())
        }

        val pendingIntent = findNavController()
            .createDeepLink()
            .setDestination(R.id.ratingBottomDialogFragment)
            .setArguments(args)
            .createPendingIntent()

        Notifier.postNotification(
            id = 10,
            context = requireContext(),
            intent = pendingIntent
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}