package com.example.tutorial.View

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorial.Data.Tasks
import com.example.tutorial.Data.TasksDAO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val tasksDAO: TasksDAO
): ViewModel() {
    private val _tasks = MutableStateFlow<List<Tasks>>(emptyList())
    val tasks: StateFlow<List<Tasks>> = _tasks.asStateFlow()

    fun addNewTask(task: String) {
        viewModelScope.launch {
            tasksDAO.addTask(Tasks(task = task))
        }
    }

    fun completeTask(taskId: Int, complete: Boolean) {
        viewModelScope.launch {
            tasksDAO.updateCompleteTask(taskId, complete)
        }
    }

    fun editTask(taskId: Int, newTask: String) {
        viewModelScope.launch {
            tasksDAO.updateTask(taskId, newTask)
        }
    }

    fun deleteTask(taskId: Int) {
        viewModelScope.launch {
            tasksDAO.deleteTask(taskId)
        }
    }

    init {
        viewModelScope.launch {
            tasksDAO.getAllTasks().collect { list ->
                _tasks.value = list
            }
        }
    }
}
