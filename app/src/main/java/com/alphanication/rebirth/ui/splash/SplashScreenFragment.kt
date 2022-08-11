package com.alphanication.rebirth.ui.splash

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alphanication.rebirth.R
import com.alphanication.rebirth.navigation.DeepLinks
import com.alphanication.rebirth.ui.base.BaseFragment

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : BaseFragment() {

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
            findNavController().navigate(Uri.parse(DeepLinks.QOUTES_DEEP_LINK))
        }, SPLASH_SCREEN_DELAY_MS)
    }

    companion object {
        private const val SPLASH_SCREEN_DELAY_MS = 800L
    }
}