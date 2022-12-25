package com.example.quotes.ui.base

import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    fun showError(message: String) =
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}