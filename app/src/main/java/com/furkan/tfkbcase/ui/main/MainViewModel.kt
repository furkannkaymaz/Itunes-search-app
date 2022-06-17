package com.furkan.tfkbcase.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkan.tfkbcase.data.api.Resource
import com.furkan.tfkbcase.data.model.SongModel
import com.furkan.tfkbcase.data.repository.SongsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataRepository: SongsRepo) : ViewModel() {

    private val _getData: MutableLiveData<SongModel> = MutableLiveData()
    val getData: LiveData<SongModel?>
        get() = _getData

    private val _error : MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String>
        get() = _error

    fun getData(searchQuery: String, offset: Int, limit: Int) = viewModelScope.launch {

        val response = dataRepository.getData(searchQuery, offset, limit)

        when(response){
            is Resource.Success ->{
                _getData.postValue(response.data!!)

            }
            is Resource.Error ->{
                _error.postValue(response.message!!)
            }
        }
    }
}