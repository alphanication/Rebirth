package com.example.quotes.ui.mainquote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

//import com.alphanication.rebirth.ui.base.BaseFragment

class MainQuoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.example.quotes.R.layout.fragment_main_quote, container, false)
    }
}