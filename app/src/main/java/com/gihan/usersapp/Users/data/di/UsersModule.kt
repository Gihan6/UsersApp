package com.gihan.usersapp.Users.data.di

import android.content.Context
import androidx.room.Room
import com.gihan.usersapp.Users.data.database.LikesDAO
import com.gihan.usersapp.Users.data.database.LikesDataBase
import com.gihan.usersapp.Users.data.remoteDatabase.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object  UsersModule {
    @Provides
    fun provideRoomDB(db: LikesDataBase): LikesDAO {
        return db.dao
    }

    @Singleton
    @Provides
    fun provideRoomDataBase(@ApplicationContext context: Context): LikesDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            LikesDataBase::class.java,
            "likesDatabase"
        ).fallbackToDestructiveMigration().build()
    }
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()

    }

}


