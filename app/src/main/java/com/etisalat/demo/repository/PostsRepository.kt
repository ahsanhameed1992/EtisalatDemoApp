package com.etisalat.demo.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.etisalat.demo.api.UsersApiService
import com.etisalat.demo.data.models.Post
import com.etisalat.demo.data.models.PostDao
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.ArrayList
import javax.inject.Inject
import javax.inject.Singleton
import io.reactivex.CompletableObserver
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action


@Singleton
class PostsRepository @Inject
constructor( private val service: UsersApiService,private val postDao: PostDao) {

    private val disposables = CompositeDisposable()
    var responseLiveData: MutableLiveData<List<Post>>? = MutableLiveData()

    init {
        Timber.d("Injection PostsRepository")
        findAllPostsFromDB()
    }

    fun loadPostsFromServer() : MutableLiveData<List<Post>>? {
        disposables.add(service.fetchPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> responseLiveData?.setValue(result)
                            deleteAllPostsFromDB()
                           savePostDB(result)
                        },
                        { throwable -> throwable.printStackTrace() }
                ))

        return responseLiveData
    }

    private fun savePostDB(posts:List<Post>){
        for (post:Post in posts){
            addPostDB(post)
        }
    }

    private fun findAllPostsFromDB() {
        disposables.add(postDao.findAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> responseLiveData?.setValue(result)
                        },
                        { throwable -> throwable.printStackTrace() }
                ))
    }

    private fun addPostDB(post: Post) {
        Completable.fromAction { postDao.insert(post) }.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(object : CompletableObserver {
                    override fun onSubscribe(d: Disposable) {}

                    override fun onComplete() {
                       Timber.i("Data inserted Successfully")
                    }
                    override fun onError(e: Throwable) {
                        Timber.i("Data insertion failed")
                    }
                })
    } private fun deleteAllPostsFromDB() {
        Completable.fromAction { postDao.deleteTable() }.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(object : CompletableObserver {
                    override fun onSubscribe(d: Disposable) {}

                    override fun onComplete() {
                       Timber.i("Data deleted Successfully")
                    }
                    override fun onError(e: Throwable) {
                        Timber.i("Data deletion failed")
                    }
                })
    }

}
