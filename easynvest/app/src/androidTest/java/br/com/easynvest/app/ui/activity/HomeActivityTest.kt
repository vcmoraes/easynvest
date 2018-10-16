package br.com.easynvest.app.ui.activity

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import android.view.View
import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import br.com.easynvest.app.R

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.annotation.IdRes
import androidx.test.espresso.ViewInteraction
import org.hamcrest.Matchers.not


@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun homeActivityTest() {
        buttonTestDisabled()
        inputValueTest()
        inputDateTest()
        inputPercentTest()
        buttonTestEnabled()
    }

    private fun inputValueTest() {
        val textInputEditTextValue = onDescendantWithId(R.id.input_layout_value, EditText::class.java)
        textInputEditTextValue.check(matches(isDisplayed()))
        textInputEditTextValue.perform(click())
        textInputEditTextValue.perform(replaceText(" 100000"))
        textInputEditTextValue.check(matches(withText(" 1.000,00")))
    }

    private fun inputDateTest() {
        val textInputEditTextDate = onDescendantWithId(R.id.input_layout_date_investiment, EditText::class.java)
        textInputEditTextDate.check(matches(isDisplayed()))
        textInputEditTextDate.perform(click())

        val buttonOk = onView(withText("OK"))
        buttonOk.perform(click())
    }

    private fun inputPercentTest() {
        val textInputEditTextPercent = onDescendantWithId(R.id.input_layout_percent, EditText::class.java)
        textInputEditTextPercent.check(matches(isDisplayed()))
        textInputEditTextPercent.perform(replaceText("125"), closeSoftKeyboard())
        textInputEditTextPercent.check(matches(withText("125")))
        textInputEditTextPercent.perform(pressImeActionButton())
    }

    private fun buttonTestDisabled() {
        val button = onView(withId(R.id.btn_simulate))
        button.check(matches(not(isEnabled())))
    }

    private fun buttonTestEnabled() {
        val button = onView(withId(R.id.btn_simulate))
        button.check(matches(isEnabled()))
    }

    private fun onDescendantWithId(@IdRes id: Int, clazz: Class<out View>): ViewInteraction {
        return onView(allOf(isDescendantOfA(withId(id)), isAssignableFrom(clazz)))
    }
}
