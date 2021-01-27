package com.example.junitdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.junitdemo.espressopackage.EspressoActivity
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
private const val MESSAGE = "This is a test"
private const val PACKAGE_NAME = "com.example.junitdemo"


class SimpleIntentTest {

    /* Instantiate an ActivityScenarioRule object. */
    @get:Rule
    var activityRule: ActivityScenarioRule<EspressoActivity> = ActivityScenarioRule(EspressoActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun verifyMessageSentToMessageActivity() {

        // Types a message into a EditText element.
        onView(withId(R.id.inputField))
            .perform(typeText(MESSAGE), closeSoftKeyboard())

        // Clicks a button to send the message to another
        // activity through an explicit intent.
        onView(withId(R.id.switchActivity)).perform(click())

        // Verifies that the DisplayMessageActivity received an intent
        // with the correct package name and message.
        intended(allOf(
            hasComponent(hasShortClassName(".espressopackage.EspressoSecondActivity")),
            toPackage(PACKAGE_NAME),
            hasExtra(EspressoActivity.EXTRA_MESSAGE, MESSAGE)))

    }

}