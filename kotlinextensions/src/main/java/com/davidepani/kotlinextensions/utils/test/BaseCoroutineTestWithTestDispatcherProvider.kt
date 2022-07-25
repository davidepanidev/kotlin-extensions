package com.davidepani.kotlinextensions.utils.test

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import org.junit.Rule

/**
 * Base test class which assigns the same [TestDispatcher] to the Main dispatcher
 * and among all the dispatchers provided by the [testDispatcherProvider] attribute
 * and the [kotlinx.coroutines.test.runTest] method.
 */
@OptIn(ExperimentalCoroutinesApi::class)
abstract class BaseCoroutineTestWithTestDispatcherProvider(
    private val dispatcher: TestDispatcher
) {

    /**
     * Sets the Main dispatcher to the test dispatcher provided as input.
     */
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule(dispatcher = dispatcher)

    /**
     * DispatcherProvider to be provided as dependency to mocked classes.
     */
    protected val testDispatcherProvider = TestDispatcherProvider(testDispatcher = dispatcher)

}