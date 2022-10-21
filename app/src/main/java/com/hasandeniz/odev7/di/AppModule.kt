package com.hasandeniz.odev7.di

import android.content.Context
import androidx.room.Room
import com.hasandeniz.odev7.data.datasource.IsDataSource
import com.hasandeniz.odev7.data.repo.IsRepository
import com.hasandeniz.odev7.room.IslerDao
import com.hasandeniz.odev7.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideIsRepository(ids:IsDataSource) : IsRepository{
        return IsRepository(ids)
    }

    @Provides
    @Singleton
    fun provideIsDataSource(idao:IslerDao) : IsDataSource{
        return IsDataSource(idao)
    }

    @Provides
    @Singleton
    fun provideIslerDao(@ApplicationContext context: Context) : IslerDao{
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"isler.sqlite").createFromAsset("isler.sqlite").build()
        return vt.getIslerDao()
    }
}