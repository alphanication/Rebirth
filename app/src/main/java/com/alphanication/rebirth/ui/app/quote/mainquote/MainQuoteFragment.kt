package com.alphanication.rebirth.ui.app.quote.mainquote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alphanication.rebirth.databinding.FragmentMainQuoteBinding
import com.alphanication.rebirth.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainQuoteFragment : BaseFragment() {

    private val viewModel: MainQuoteVM by viewModels()
    private lateinit var binding: FragmentMainQuoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainQuoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDataListeners()
        initUi()
    }

    private fun initUi() {
        binding.tvQuote.setOnClickListener { viewModel.getQuote() }
    }

    private fun initDataListeners() {
        viewModel.quote.observe(viewLifecycleOwner) {
            binding.tvAuthor.text = it.quoteAuthor
            binding.tvQuote.text = it.quoteText
        }
        viewModel.error.observe(viewLifecycleOwner) {
            it.message?.let { message -> showError(message) }
        }
    }
}