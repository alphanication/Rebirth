package com.alphanication.rebirth.ui.mainquote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alphanication.rebirth.R
import com.alphanication.rebirth.ui.base.BaseFragment

class MainQuoteFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_quote, container, false)
    }
}