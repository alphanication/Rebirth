@file:Suppress("NOTHING_TO_INLINE")

package com.alphanication.rebirth.utils

import android.view.View

inline fun View.show() {
    visibility = View.VISIBLE
}

inline fun View.invisible() {
    visibility = View.INVISIBLE
}

inline fun View.hide() {
    visibility = View.GONE
}

inline fun View.visible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}