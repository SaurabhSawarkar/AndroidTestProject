package com.example.myapplication.extension

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.TextView

fun TextView.spannableBold(spannable: String, normal: String?) {
    normal?.let {
        val boldStyle = StyleSpan(Typeface.BOLD)
        val startIndex = 0
        val endIndex = spannable.length

        val sb = SpannableStringBuilder( spannable + normal)
        sb.setSpan(boldStyle, startIndex, endIndex, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        this.text = sb
    }
}