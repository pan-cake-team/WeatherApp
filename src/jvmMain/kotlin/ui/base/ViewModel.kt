package ui.base

import util.CloseableCoroutineScope

abstract class ViewModel {
    internal val viewModelScope = CloseableCoroutineScope()
}