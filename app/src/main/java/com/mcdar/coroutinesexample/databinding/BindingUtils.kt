package com.mcdar.coroutinesexample.databinding

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mcdar.coroutinesexample.R


@BindingAdapter("android:imageUrl")
fun ImageView.setImageUrl(url: String?) {
    if (url == null || url.isEmpty()) {
        return
    }
    Glide.with(this.context)
        .load(url)
        .into(this)
}

@BindingAdapter(value = ["android:firstName", "android:lastName"], requireAll = false)
fun TextView.setName(firstName: String, lastName: String) {
    this.text = this.context.getString(R.string.employee_name).format(firstName, lastName)
}

@BindingAdapter("android:visibility")
fun ProgressBar.setVisibility(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}
