package com.afterbitestudio.eurojackpot.core.dispatcher

import com.afterbitestudio.eurojackpot.core.AppDispatchers
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class AppDispatchersImpl : AppDispatchers {

    override val Default: CoroutineContext
        get() = Dispatchers.Default
    override val Main: CoroutineContext
        get() = Dispatchers.Main
    override val IO: CoroutineContext
        get() = Dispatchers.IO
}
