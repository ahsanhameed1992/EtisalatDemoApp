package com.etisalat.demo.view.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.etisalat.demo.R
import com.etisalat.demo.factory.AppViewModelFactory
import com.etisalat.demo.data.models.Post
import com.etisalat.demo.view.adapter.PostsAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(){

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java) }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        main_recyclerView.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        viewModel.getPostsData()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.postData?.observe(this, Observer<List<Post>> { usersList ->
                main_recyclerView.adapter = PostsAdapter(this,usersList)

        })
    }

}
