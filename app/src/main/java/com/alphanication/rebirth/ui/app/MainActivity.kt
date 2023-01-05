package com.alphanication.rebirth.ui.app

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alphanication.rebirth.R
import com.alphanication.rebirth.ui.utils.StrategicalExceptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        strategicalExceptionHandler()
    }

    private fun strategicalExceptionHandler() {
        errorCallback = {
            when (it) {
                StrategicalExceptions.NETWORK_DISABLE -> showErrorNetwork()
            }
        }
    }

    private fun showErrorNetwork() {
        Toast.makeText(applicationContext, resources.getString(R.string.network_error), Toast.LENGTH_SHORT).show()
    }

    companion object {
        private var errorCallback: ((StrategicalExceptions) -> Unit)? = null
        private val uiPoster = Handler(Looper.getMainLooper())

        fun onError(strategicalException: StrategicalExceptions) {
            uiPoster.post {
                errorCallback?.invoke(strategicalException)
            }
        }
    }
}