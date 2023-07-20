package ui.base

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<T>(initialValue: T) : ViewModel() {

    private val _state: MutableStateFlow<T> = MutableStateFlow(initialValue)
    val state: StateFlow<T> = _state.asStateFlow()

    fun updateState(f: (T) -> T) = _state.update(f)
}