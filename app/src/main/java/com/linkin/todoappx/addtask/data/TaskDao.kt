package com.linkin.todoappx.addtask.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.linkin.todoappx.addtask.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM  TaskEntity")
    fun getTask() : Flow<List<TaskEntity>>

    @Insert
    suspend fun addTask(item : TaskEntity)
    @Update
    suspend fun update(item: TaskEntity)

    @Delete
    suspend fun delete(taskEntity: TaskEntity)


}