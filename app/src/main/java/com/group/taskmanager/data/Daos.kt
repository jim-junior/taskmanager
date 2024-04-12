package com.group.taskmanager.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks(): List<Task>

    @Transaction
    @Query("SELECT * FROM tasks WHERE id = :taskId")
    suspend fun getTaskWithSubtasks(taskId: Long): TaskWithSubtasksAndResources

    @Transaction
    @Query("SELECT * FROM tasks")
    suspend fun getAllTasksWithSubtasks(): List<TaskWithSubtasksAndResources>

}

@Dao
interface SubtaskDao {
    @Insert
    suspend fun insertSubtask(subtask: Subtask)

    @Update
    suspend fun updateSubtask(subtask: Subtask)

    @Delete
    suspend fun deleteSubtask(subtask: Subtask)

    @Query("SELECT * FROM subtasks")
    suspend fun getAllSubtasks(): List<Subtask>
}

@Dao
interface ResourceDao {
    @Insert
    suspend fun insertResource(resource: Resource)

    @Update
    suspend fun updateResource(resource: Resource)

    @Delete
    suspend fun deleteResource(resource: Resource)

    @Query("SELECT * FROM resources")
    suspend fun getAllResources(): List<Resource>
}