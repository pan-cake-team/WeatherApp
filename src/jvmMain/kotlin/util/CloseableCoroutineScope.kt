package util

import kotlinx.coroutines.*
import java.io.Closeable
import kotlin.coroutines.CoroutineContext

internal class CloseableCoroutineScope(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : CoroutineScope, Closeable {
    override val coroutineContext: CoroutineContext = dispatcher + SupervisorJob()
    override fun close() = coroutineContext.cancel()
}