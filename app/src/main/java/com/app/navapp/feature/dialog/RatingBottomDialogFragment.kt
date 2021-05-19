package com.app.navapp.feature.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.app.navapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class RatingBottomDialogFragment : BottomSheetDialogFragment() {

    private lateinit var ratingBar: RatingBar
    private lateinit var textView: TextView

    private var rating: Int = 0
    private var text: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rating = requireArguments().getInt("rating")
        text = requireArguments().getString("text", "")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rating_bottom_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ratingBar = view.findViewById(R.id.ratingBar)
        textView = view.findViewById(R.id.textView)

        ratingBar.rating = rating.toFloat()
        textView.text = text
    }
}