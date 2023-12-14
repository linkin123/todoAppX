package com.linkin.todoappx.addtask.data

import com.linkin.todoappx.addtask.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    val tasks: Flow<List<TaskModel>> =
        taskDao.getTask().map { items ->  items.map { TaskModel(it.id, it.task, it.selected) } }

    suspend fun add(taskModel: TaskModel) {
        taskDao.addTask(taskModel.toData())
    }

    suspend fun update(taskModel: TaskModel) {
        taskDao.update(taskModel.toData())
    }

    suspend fun delete(taskModel: TaskModel) {
        taskDao.delete(taskModel.toData())
    }

}

private fun TaskModel.toData(): TaskEntity {
    return TaskEntity(id, task, selected)
}
