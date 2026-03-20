package com.example.tutorial.Data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): TasksDatabase = Room.databaseBuilder(
        context,
        TasksDatabase::class.java,
        "todo"
    ).build()

    @Provides
    @Singleton
    fun provideDao(database: TasksDatabase): TasksDAO {
        return database.taskDao()
    }
}
