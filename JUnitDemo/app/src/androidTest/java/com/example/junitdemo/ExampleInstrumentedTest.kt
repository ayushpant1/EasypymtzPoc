package com.example.junitdemo

import android.content.Context
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.junitdemo.espressopackage.EspressoActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    var stringToBeTyped: String = "ayush"

    @Rule
    @JvmField
    public var mActivityRule = ActivityTestRule(EspressoActivity::class.java)

    @Test
    fun buttonShouldUpdateText() {
        onView(withId(R.id.inputField)).perform(typeText(stringToBeTyped), closeSoftKeyboard())
        onView(withId(R.id.changeText)).perform(click())
        onView(withId(R.id.inputField)).check(matches(withText(stringToBeTyped)))
    }

}