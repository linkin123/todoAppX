package com.linkin.todoappx.addtask.ui

import com.linkin.todoappx.addtask.ui.model.TaskModel

sealed interface TaskUiState {

    object  Loading:TaskUiState
    data class Error(val throable: Throwable): TaskUiState
    data class Success(val tasks: List<TaskModel>): TaskUiState
}