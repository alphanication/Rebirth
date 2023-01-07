package com.alphanication.rebirth.ui.base

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alphanication.rebirth.domain.repository.NetworkMonitor
import javax.inject.Inject

abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    fun showError(message: String) {
        /** Воробей Е. А., 07.01.2023
         * Strategical exception handler выставлен на уровне interceptor'a retrofit */
        if (networkMonitor.isConnected()) Toast.makeText(
            requireContext(),
            message,
            Toast.LENGTH_SHORT
        ).show()
    }
}