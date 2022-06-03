package com.furkan.tfkbcase.ui.main

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

    private val _getData: MutableLiveData<Resource<SongModel>> = MutableLiveData()
    val getData: LiveData<Resource<SongModel>?>
        get() = _getData

    fun getData(searchQuery: String, offset: Int, limit: Int) = viewModelScope.launch {
        val response = dataRepository.getData(searchQuery, offset, limit)
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                _getData.postValue(Resource.Success(resultResponse))
            }
        }

    }
}