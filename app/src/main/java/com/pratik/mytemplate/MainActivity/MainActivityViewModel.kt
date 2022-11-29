package com.pratik.mytemplate.MainActivity

import android.util.Log
import androidx.lifecycle.*
import com.pratik.mytemplate.ViewModelFactory.ViewModelAssistedFactory
import com.pratik.mytemplate.core.data.bitcoin.model.convert
import com.pratik.mytemplate.core.data.network.networkHandler.onError
import com.pratik.mytemplate.core.data.network.networkHandler.onException
import com.pratik.mytemplate.core.data.network.networkHandler.onSuccess
import com.pratik.mytemplate.core.data.scenario_example.model.convert
import com.pratik.mytemplate.core.domain.bitcoin.model.Bitcoin
import com.pratik.mytemplate.core.domain.bitcoin.usecase.GetBitcoinUseCase
import com.pratik.mytemplate.core.domain.scenario_example.model.SampleResponse
import com.pratik.mytemplate.core.domain.scenario_example.usecase.GetSomethingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val handle: SavedStateHandle ,
                                                private val getSomethingUseCase: GetSomethingUseCase,
                                                private val getBitcoinUseCase: GetBitcoinUseCase

):ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    var isLoading:LiveData<Boolean> = _isLoading

    private val _errorOrException = MutableLiveData<Pair<Int?,String?>>()
    var errorOrException:LiveData<Pair<Int?,String?>> = _errorOrException

    private val _getSomething = MutableLiveData<SampleResponse?>()
    var getSomething: LiveData<SampleResponse?> = _getSomething

    private val _getBitcoin = MutableLiveData<Bitcoin?>()
    var getBitcoin: LiveData<Bitcoin?> = _getBitcoin

    fun getBitcoin(){
        viewModelScope.launch(Dispatchers.IO) {
            val res = getBitcoinUseCase.invoke()
            res.onSuccess {
                Log.d("BITCOIN",it.convert().toString())
            }.onError { code, message ->
                Log.e("Error","$code : $message")
            }.onException {
                Log.e("Exception" , it.message.toString())
                //No internet connection
            }
        }
    }
    fun getSomething(param:String){
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            val res = getSomethingUseCase.invoke()
            res.onSuccess {
                _isLoading.postValue(false)
                _getSomething.postValue(it.convert())
            }.onError { code, message ->
                _isLoading.postValue(false)
                _errorOrException.postValue(Pair(code,message))
            }.onException {
                _isLoading.postValue(false)
                _errorOrException.postValue(Pair(null,it.message))
            }
        }
    }

}

class MainActivityViewModelFactory @Inject constructor(private val getSomethingUseCase: GetSomethingUseCase,
                                                       private val getBitcoinUseCase: GetBitcoinUseCase
) : ViewModelAssistedFactory<MainActivityViewModel> {
    override fun create(handle: SavedStateHandle): MainActivityViewModel {
        return MainActivityViewModel(handle, getSomethingUseCase,getBitcoinUseCase)
    }
}