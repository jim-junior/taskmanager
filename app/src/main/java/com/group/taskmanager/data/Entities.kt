package com.group.taskmanager.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "resources")
data class Resource(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val taskId: Long, // Foreign key to link with Task
    val resourceUri: String, // URL, filepath, or note content
    val type: String // Optional: To distinguish resource types (URL, file, note)
)


@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val title: String,

    @ColumnInfo(name = "start_date")
    val startDate: Long,

    @ColumnInfo(name = "end_date")
    val endDate: Long,

    val completed: Boolean,

    val description: String,

    @Ignore
    val resources: List<Resource> // List of resources attached to the task
)


@Entity(tableName = "subtasks")
data class Subtask(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val title: String,


    val description: String,

    val taskId: Long, // Foreign key to link with Task
)


data class TaskWithSubtasksAndResources(
    @Embedded val task: Task,
    @Relation(
        parentColumn = "id",
        entityColumn = "taskId"
    )
    val subtasks: List<Subtask>,
    @Relation(
        parentColumn = "id",
        entityColumn = "taskId"
    )
    val resources: List<Resource>
)