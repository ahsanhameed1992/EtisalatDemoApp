package com.etisalat.demo.view.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.etisalat.demo.data.models.Post
import com.etisalat.demo.repository.PostsRepository
import timber.log.Timber
import java.util.ArrayList
import javax.inject.Inject


class MainActivityViewModel @Inject
constructor(private val serRepository: PostsRepository) : ViewModel() {

    var postData: LiveData<List<Post>>? = null

    init {
        Timber.d("Injection MainActivityViewModel")
        postData = serRepository.responseLiveData
    }

    fun getPostsData(): MutableLiveData<List<Post>>? {
        return serRepository.loadPostsFromServer()
    }
}
