package dev.pikadroid.compose.unstyled

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals

import org.junit.Test

class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("dev.pikadroid.compose.unstyled.test", appContext.packageName)
    }
}