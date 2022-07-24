package com.alphanication.quotexml.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alphanication.quotexml.databinding.FragmentSplashScreenBinding
import com.alphanication.quotexml.utils.hide
import com.alphanication.quotexml.utils.show
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {

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

    private fun showStartViews() = CoroutineScope(Dispatchers.Main).launch {
        binding.apply {
            tvImpossible.show()

            delay(TV_OR_DELAYS)
            tvOr.show()
            tvImpossible.hide()

            delay(TV_I_AM_POSSIBLE_DELAYS)
            tvIAmPossible.show()
            ivIAmPossible.show()
            tvOr.hide()
        }
    }

    companion object {
        private const val TV_OR_DELAYS = 1000L
        private const val TV_I_AM_POSSIBLE_DELAYS = 800L
    }
}