package com.etisalat.demo.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*


class UserViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val title = view.title
    val veil = view.item_user_veilLayout
    val mView = view
}
