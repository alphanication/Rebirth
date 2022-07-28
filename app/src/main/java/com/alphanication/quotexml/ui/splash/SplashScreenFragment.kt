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
import com.alphanication.quotexml.di.MainCoroutineScope
import com.alphanication.quotexml.utils.hide
import com.alphanication.quotexml.utils.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {

    @Inject
    @MainCoroutineScope
    lateinit var mainCoroutineScope: CoroutineScope

    private lateinit var binding: FragmentSplashScreenBinding

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

    private fun startMainScreen() = mainCoroutineScope.launch {
        delay(START_MAIN_SCREEN_DELAY)
        findNavController().navigate(R.id.action_splashScreenFragment_to_mainQuoteFragment)
    }

    private fun showStartViews() = mainCoroutineScope.launch {
        binding.apply {
            tvImpossible.show()

            delay(TV_OR_DELAY)
            tvOr.show()
            tvImpossible.hide()

            delay(TV_I_AM_POSSIBLE_DELAY)
            tvIAmPossible.show()
            tvOr.hide()

            startMainScreen()
        }
    }

    companion object {
        private const val TV_OR_DELAY = 1000L
        private const val TV_I_AM_POSSIBLE_DELAY = 800L
        private const val START_MAIN_SCREEN_DELAY = 800L
    }
}