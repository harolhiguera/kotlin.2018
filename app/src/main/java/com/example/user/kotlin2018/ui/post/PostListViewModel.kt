package com.example.user.kotlin2018.ui.post

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.example.user.kotlin2018.R
import com.example.user.kotlin2018.base.BaseViewModel
import com.example.user.kotlin2018.model.Post
import com.example.user.kotlin2018.network.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListViewModel: BaseViewModel() {

    @Inject
    lateinit var postApi: PostApi

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    var errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPost() }

    val postListAdapter: PostListAdapter = PostListAdapter()


    init {
        loadPost()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }


    private fun loadPost(){
        subscription = postApi.getPost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrievePostListStart() }
                .doOnTerminate { onRetrievePostListFinish() }
                .subscribe(
                        { result -> onRetrievePostListSuccess(result)},
                        { onRetrievePostListError() }
                )
    }


    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(postList: List<Post>){
        postListAdapter.updatePostList(postList)
    }

    private fun onRetrievePostListError(){
        errorMessage.value = R.string.post_error
    }
}