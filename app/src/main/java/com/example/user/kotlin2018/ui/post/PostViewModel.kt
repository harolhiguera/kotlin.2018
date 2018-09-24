package com.example.user.kotlin2018.ui.post

import android.arch.lifecycle.MutableLiveData
import com.example.user.kotlin2018.base.BaseViewModel
import com.example.user.kotlin2018.model.Post

class PostViewModel: BaseViewModel() {

    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post){
        postTitle.value = post.title
        postBody.value = post.body
    }
    fun getPostTitle(): MutableLiveData<String>{
        return postTitle
    }
    fun getPostBody(): MutableLiveData<String>{
        return postBody
    }
}