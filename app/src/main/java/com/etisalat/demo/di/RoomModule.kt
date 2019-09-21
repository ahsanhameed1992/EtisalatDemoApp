package com.etisalat.demo.di

import android.app.Application
import androidx.annotation.NonNull
import dagger.Provides
import com.etisalat.demo.repository.DemoDatabase
import androidx.room.Room
import com.etisalat.demo.DemoApplication
import com.etisalat.demo.data.models.PostDao
import com.etisalat.demo.repository.PostsRepository
import dagger.Module
import javax.inject.Singleton


@Module
class RoomModule {


    @Singleton
    @Provides
    fun provideDatabase(application: DemoApplication): DemoDatabase {
        return Room.databaseBuilder(application, DemoDatabase::class.java, "demo.db").build()
    }

    @Singleton
    @Provides
    internal fun providesPostDao(demoDatabase: DemoDatabase): PostDao {
        return demoDatabase.postDao
    }


}