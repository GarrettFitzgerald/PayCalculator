package com.example.paycalculator;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import android.content.Context;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;



import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginScreenTest
{
    @Rule
    public ActivityScenarioRule<LogInScreen> activityActivityScenarioRule = new ActivityScenarioRule<>(LogInScreen.class);


    @Test
    public void AuseAppContext()
    {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.paycalculator", appContext.getPackageName());
    }

    @Test
    public void BtestClearButton()
    {
        onView(withId(R.id.edt_username))
                .perform(replaceText("fitsha"));
        onView(withId(R.id.btn_clear))
                .perform(click());
        onView(withId(R.id.edt_username))
                .check(matches(withText("")));
    }

    @Test
    public void CcreateAccount()
    {
        onView(withId(R.id.btn_signup))
                .perform(click());
        onView(withId(R.id.edt_firstname))
                .perform(replaceText("Shannon"));
        onView(withId(R.id.edt_lastname))
                .perform(replaceText("Fitzgerald"));
        onView(withId(R.id.edt_passwordenter))
                .perform(replaceText("q1w2e3"));
        onView(withId(R.id.edt_passwordconfirm))
                .perform(replaceText("q1w2e3"));
        onView(withId(R.id.btn_confirm))
                .perform(click());
        onView(withId(R.id.edt_username))
                .perform(replaceText("fitsha"));
        onView(withId(R.id.edt_password))
                .perform(replaceText("q1w2e3"));
        onView(withId(R.id.btn_login))
                .perform(click());
    }

    @Test
    public void DdeleteAccount()
    {
        onView(withId(R.id.btn_delete))
                .perform(click());
        onView(withId(R.id.edt_userdelete))
                .perform(typeText("fitsha"));
        onView(withId(R.id.btn_deleteuser))
                .perform(click());
    }

    @Test
    public void EcreateAccountNoDetails()
    {
        onView(withId(R.id.btn_signup))
                .perform(click());
        onView(withId(R.id.btn_confirm))
                .perform(click());
    }
}