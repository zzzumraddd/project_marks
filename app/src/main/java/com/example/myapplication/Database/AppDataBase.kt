package com.example.myapplication.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.DAO.UsersDao
import com.example.myapplication.Entity.Guruh
import com.example.myapplication.Entity.User

@Database(entities = [User::class, Guruh::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun getUsersDao(): UsersDao

    companion object{
        var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase{
            if(instance==null){
                instance = Room.databaseBuilder(context, AppDataBase::class.java, "app_db").allowMainThreadQueries().build()
            }
            return instance!!
        }
    }
   
}