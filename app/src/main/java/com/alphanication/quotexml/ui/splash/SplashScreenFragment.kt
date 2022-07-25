package com.alphanication.quotexml.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alphanication.quotexml.R
import com.alphanication.quotexml.databinding.FragmentSplashScreenBinding
import com.alphanication.quotexml.utils.hide
import com.alphanication.quotexml.utils.show
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding
    private val mainScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showStartViews()
    }

    private fun startMainScreen() = mainScope.launch {
        delay(START_MAIN_SCREEN_DELAY)
        findNavController().navigate(R.id.action_splashScreenFragment_to_mainQuoteFragment)
    }

    private fun showStartViews() = mainScope.launch {
        binding.apply {
            tvImpossible.show()

            delay(TV_OR_DELAYS)
            tvOr.show()
            tvImpossible.hide()

            delay(TV_I_AM_POSSIBLE_DELAYS)
            tvIAmPossible.show()
            tvOr.hide()

            startMainScreen()
        }
    }

    companion object {
        private const val TV_OR_DELAYS = 1000L
        private const val TV_I_AM_POSSIBLE_DELAYS = 800L
        private const val START_MAIN_SCREEN_DELAY = 800L
    }
}