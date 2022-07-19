package com.example.diceapp

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun generates_random() {
        val dice = Dice(6)
        val rollNumber = dice.roll()

        assertTrue("The value is not in the range 1 and 6",rollNumber in 1..6)
    }
}