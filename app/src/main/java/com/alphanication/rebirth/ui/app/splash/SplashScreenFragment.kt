package com.alphanication.rebirth.ui.app.splash

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alphanication.rebirth.R

private const val SPLASH_SCREEN_DELAY_MS = 800L

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_splash_screen, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startMainQuoteScreen()
    }

    private fun startMainQuoteScreen() {
        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashScreenFragment_to_mainQuoteFragment)
        }, SPLASH_SCREEN_DELAY_MS)
    }
}