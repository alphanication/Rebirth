package com.alphanication.rebirth.ui.app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alphanication.rebirth.R
import com.alphanication.rebirth.domain.repository.StrategicalExceptionHandler
import com.alphanication.rebirth.ui.utils.StrategicalExceptions
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}