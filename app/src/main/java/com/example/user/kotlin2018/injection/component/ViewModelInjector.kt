package com.example.user.kotlin2018.injection.component

import com.example.user.kotlin2018.injection.module.NetworkModule
import com.example.user.kotlin2018.ui.post.PostListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    /**
     * Injects required dependencies into the specified PostListViewModel
     * @param postListViewModel: PostListViewModel in which to inject the dependencies
     */

    fun inject(postListViewModel: PostListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}