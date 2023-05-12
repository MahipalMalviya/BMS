package com.mahipal.assignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahipal.feature_one.model.Venue
import com.mahipal.assignment.repository.ShowTimesRepository
import com.mahipal.common_ui.viewmodel.AppScoped
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@AppScoped
class MainViewModel @Inject constructor(private val showTimesRepository: ShowTimesRepository) :
    ViewModel() {

    private val _progressData = MutableLiveData<Boolean>().apply {
        value = false
    }
    val progressData: LiveData<Boolean>
        get() = _progressData

    private val _error = MutableLiveData<String>().apply {
        value = ""
    }
    val error: LiveData<String>
        get() = _error

    private val _venueList = MutableLiveData<List<Venue>>().apply {
        value = listOf()
    }
    val venueList: LiveData<List<Venue>>
        get() = _venueList

    fun getShowTimes() {
        showTimesRepository.getShowTimes()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { _progressData.postValue(true) }
            .doAfterTerminate { _progressData.postValue(false) }
            .subscribe({
                _venueList.postValue(it.venues)
            },{
                _error.postValue("Something went wrong")
                it.printStackTrace()
            })
    }
}