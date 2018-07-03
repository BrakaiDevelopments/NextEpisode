package com.example.brakai.nextepisode.extensions

import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.EditText

fun String.isValidEmail(): Boolean
        = this.isNotEmpty() &&
        Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isValidPassword(): Boolean
        = this.matches("^(?=.*[a-zA-Z])(?=.*\\d).{8,}\$".toRegex())

fun EditText.onChange(cb: (String) -> Unit) {
    this.addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) { cb(s.toString()) }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}