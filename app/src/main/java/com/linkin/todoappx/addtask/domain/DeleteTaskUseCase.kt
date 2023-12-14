package com.linkin.todoappx.addtask.domain

import com.linkin.todoappx.addtask.data.TaskRepository
import com.linkin.todoappx.addtask.ui.model.TaskModel
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(taskModel: TaskModel) {
        taskRepository.delete(taskModel)
    }
}
