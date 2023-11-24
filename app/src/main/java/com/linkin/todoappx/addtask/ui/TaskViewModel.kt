package com.linkin.todoappx.addtask.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linkin.todoappx.addtask.domain.AddTaskUseCase
import com.linkin.todoappx.addtask.domain.GetTaskUseCase
import com.linkin.todoappx.addtask.ui.TaskUiState.Error
import com.linkin.todoappx.addtask.ui.TaskUiState.Loading
import com.linkin.todoappx.addtask.ui.TaskUiState.Success
import com.linkin.todoappx.addtask.ui.model.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(

    private val addTaskUseCase: AddTaskUseCase,
    getTaskUseCase: GetTaskUseCase
) : ViewModel() {

    val uiState: StateFlow<TaskUiState> = getTaskUseCase().map(::Success)
        .catch { Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    /*    private val _task = mutableStateListOf<TaskModel>()
        val task: List<TaskModel> = _task


     */
    fun onDialogClose() {
        _showDialog.value = false
    }

    fun onTaskCreated(task: String) {
        _showDialog.value = false

        viewModelScope.launch {
            addTaskUseCase(TaskModel(task = task))
        }
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

    fun onCheckBoxSelected(taskModel: TaskModel) {
        /*
        val index = _task.indexOf(taskModel)
        _task[index] = _task[index].let {
            it.copy(selected = !it.selected)
        }

         */
    }

    fun onItemRemove(taskModel: TaskModel) {
        /*
        _task.removeIf {
            it.id == taskModel.id
        }

         */
    }


}