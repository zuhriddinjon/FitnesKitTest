package uz.instat.fitneskittest.framework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.instat.fitneskittest.busines.interactors.UiState
import uz.instat.fitneskittest.busines.local.LessonsHistoryLocal
import uz.instat.fitneskittest.busines.local.VisitsHistoryLocal
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepo: MainRepo
) : ViewModel() {

    private var _lessonState: MutableLiveData<UiState<List<LessonsHistoryLocal>>> =
        MutableLiveData()
    val lessonState: LiveData<UiState<List<LessonsHistoryLocal>>> = _lessonState

    fun getLessons() {
        viewModelScope.launch {
            _lessonState.postValue(UiState.Loading())
            mainRepo.getLessons().collectLatest {
                _lessonState.postValue(it)
            }
        }
    }


    private var _visitState: MutableLiveData<UiState<List<VisitsHistoryLocal>>> =
        MutableLiveData()
    val visitState: LiveData<UiState<List<VisitsHistoryLocal>>> = _visitState

    fun getVisits() {
        viewModelScope.launch {
            _visitState.postValue(UiState.Loading())
            mainRepo.getVisits().collectLatest {
                _visitState.postValue(it)
            }
        }

    }

}