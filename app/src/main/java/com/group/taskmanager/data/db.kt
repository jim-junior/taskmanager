package com.group.taskmanager.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Task::class, Subtask::class, Resource::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun subtaskDao(): SubtaskDao
    abstract fun resourceDao(): ResourceDao
}