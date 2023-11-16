package com.linkin.todoappx.addtask.domain

import com.linkin.todoappx.addtask.data.TaskRepository
import com.linkin.todoappx.addtask.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {

    operator fun invoke(): Flow<List<TaskModel>> = taskRepository.tasks


}