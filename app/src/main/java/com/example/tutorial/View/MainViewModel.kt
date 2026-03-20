package com.example.tutorial.View

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorial.Data.Tasks
import com.example.tutorial.Data.TasksDAO
import com.example.tutorial.Data.datastore.DataStoreUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val tasksDAO: TasksDAO,
    private val dataStore: DataStoreUtil
): ViewModel() {
    val switchState: StateFlow<Boolean> = dataStore.darkTheme
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily, false)

    fun saveSwitchState(value: Boolean) {
        viewModelScope.launch {
            dataStore.setDarkTheme(value)
        }
    }

    /*Ниже прочий код который показывать смысла нет*/

    private val _tasks = MutableStateFlow<List<Tasks>>(emptyList())
    val tasks: StateFlow<List<Tasks>> = _tasks.asStateFlow()

    fun addNewTask(task: String) {
        viewModelScope.launch {
            tasksDAO.addTask(task)
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
