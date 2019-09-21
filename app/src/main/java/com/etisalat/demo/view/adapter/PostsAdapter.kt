package com.etisalat.demo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.etisalat.demo.R
import com.etisalat.demo.data.models.Post
import com.etisalat.demo.view.ui.main.MainActivity
import com.etisalat.demo.view.viewholder.UserViewHolder
import android.content.Intent
import com.etisalat.demo.utils.Constants
import com.etisalat.demo.view.ui.details.DetailsActivity


class PostsAdapter(var context: MainActivity, var mPostList: List<Post>): RecyclerView.Adapter<UserViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false)
        return UserViewHolder(view)
    }
    override fun getItemCount(): Int {
        return mPostList.size
    }
    override fun onBindViewHolder(holder:UserViewHolder, position: Int) {
        holder.veil.veil()
        holder.title?.text = mPostList[position].title
        holder.mView.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(Constants.EXTRA_POST_TITLE, mPostList[position].title)
            intent.putExtra(Constants.EXTRA_POST_BODY, mPostList[position].body)
            context.startActivity(intent)
        })

    }

}