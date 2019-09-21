package com.etisalat.demo.data.models


import androidx.lifecycle.LiveData
import androidx.room.*
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
interface PostDao {

    @Query("SELECT * FROM Post")
    fun findAll(): Flowable<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: Post): Long

    @Query("DELETE FROM Post")
    fun deleteTable()

}