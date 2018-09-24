package com.example.user.kotlin2018.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.user.kotlin2018.model.Post
import com.example.user.kotlin2018.model.PostDao


@Database(entities = arrayOf(Post::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}
