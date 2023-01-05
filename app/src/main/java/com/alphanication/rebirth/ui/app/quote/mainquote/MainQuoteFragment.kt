package com.alphanication.rebirth.ui.app.quote.mainquote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.alphanication.rebirth.R
import com.alphanication.rebirth.databinding.FragmentMainQuoteBinding
import com.alphanication.rebirth.domain.models.Quote
import com.alphanication.rebirth.ui.base.BaseFragment
import com.alphanication.rebirth.utils.show
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
        viewModel.quote.observe(viewLifecycleOwner) { showQuote(it) }
        viewModel.error.observe(viewLifecycleOwner) {
            it.message?.let { message -> showError(message) }
        }
    }

    private fun showQuote(quote: Quote) {
        binding.apply {
            tvQuoteDivider.show()
            tvAuthor.text = resources.getString(R.string.author_c) +
                    quote.quoteAuthor.ifEmpty { resources.getString(R.string.anonymous) }
            tvQuote.text = quote.quoteText
        }
    }
}