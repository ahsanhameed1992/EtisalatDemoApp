package com.etisalat.demo.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.etisalat.demo.data.models.Post
import com.etisalat.demo.data.models.PostDao


@Database(entities = arrayOf(Post::class), version = 1, exportSchema = false)
public abstract class DemoDatabase : RoomDatabase() {

    abstract val postDao: PostDao

    companion object {
        const val VERSION = 1
    }

}