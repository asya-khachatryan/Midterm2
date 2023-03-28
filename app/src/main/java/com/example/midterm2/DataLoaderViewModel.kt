package com.example.midterm2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.midterm2.data.Datasource
import com.example.midterm2.data.User
import kotlinx.coroutines.launch

class DataLoaderViewModel : ViewModel() {

    private val _userList: MutableLiveData<List<User>> = MutableLiveData()
    val userList: LiveData<List<User>> = _userList


    fun loadUsers() {
        viewModelScope.launch {
            _userList.postValue(Datasource().loadUsers())

        }
    }


}