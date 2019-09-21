package com.etisalat.demo.api

import com.etisalat.demo.data.models.Post
import io.reactivex.Observable
import retrofit2.http.GET


interface UsersApiService {

    @GET("/posts")
    fun fetchPosts(): Observable<List<Post>>

}
