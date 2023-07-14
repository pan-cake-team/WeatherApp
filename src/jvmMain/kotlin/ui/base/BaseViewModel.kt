package ui.base

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<T,K>(initialValue: T, init2: K) : ViewModel() {

    private val _state: MutableStateFlow<T> = MutableStateFlow(initialValue)
    val state: StateFlow<T> = _state.asStateFlow()

    private val _exception: Channel<Exception> = Channel()
    val exception: Flow<Exception> = _exception.receiveAsFlow()

    val onException: (Exception) -> Unit = { viewModelScope.launch { _exception.send(it) } }

    fun updateHourlyState(f: (T) -> T) = _state.update(f)


    private val _state2: MutableStateFlow<K> = MutableStateFlow(init2)
    val state2: StateFlow<K> = _state2.asStateFlow()

    private val _exception2: Channel<Exception> = Channel()
    val exception2: Flow<Exception> = _exception2.receiveAsFlow()

    val onException2: (Exception) -> Unit = { viewModelScope.launch { _exception.send(it) } }

    fun updateDailyState(f: (K) -> K) = _state2.update(f)
}