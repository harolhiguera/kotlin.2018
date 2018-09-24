package com.example.user.kotlin2018.network

import com.example.user.kotlin2018.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */

interface PostApi {

    /**
     * Get the list of the posts from the API
     */
    @GET("/posts")
    fun getPost(): Observable<List<Post>>


}