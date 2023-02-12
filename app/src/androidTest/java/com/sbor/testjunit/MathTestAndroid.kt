package com.sbor.testjunit

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class MathTestAndroid {
    @Rule
    @JvmField
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun simpleDivide() {
        runBlocking {
            Espresso.onView(withId(R.id.et_a)).perform(ViewActions.typeText("8"))
            Espresso.onView(withId(R.id.et_a)).perform(ViewActions.closeSoftKeyboard())
            delay(1000)
            Espresso.onView(withId(R.id.et_b)).perform(ViewActions.typeText("4"))
            Espresso.onView(withId(R.id.et_b)).perform(ViewActions.closeSoftKeyboard())
            delay(1000)
            Espresso.onView(withId(R.id.equals_btn)).perform(ViewActions.click())
            delay(1000)
            Espresso.onView(withId(R.id.tv_result)).check(ViewAssertions.matches(ViewMatchers.withText("2")))
            delay(1000)

        }
    }
}