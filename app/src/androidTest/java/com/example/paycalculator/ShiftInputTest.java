package com.example.paycalculator;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.content.Intent;

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


public class ShiftInputTest
{
    @Rule
    public ActivityScenarioRule<ShiftInput> activityActivityScenarioRule = new ActivityScenarioRule<ShiftInput>(ShiftInput.class);


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.paycalculator", appContext.getPackageName());
    }

    @Test
    public void testAll0000()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("0000")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("0000")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("0000")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("0000")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("0000")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("0000")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("0000")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("0000")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("0000")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("0000")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("0000")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("0000")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("0000")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_0000)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("0000")));
    }

    @Test
    public void testAll0630()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("0630")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("0630")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("0630")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("0630")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("0630")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("0630")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("0630")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("0630")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("0630")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("0630")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("0630")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("0630")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("0630")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_0630)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("0630")));
    }

    @Test
    public void testAll0700()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("0700")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("0700")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("0700")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("0700")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("0700")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("0700")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("0700")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("0700")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("0700")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("0700")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("0700")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("0700")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("0700")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("0700")));
    }

    @Test
    public void testAll0730()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("0730")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("0730")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("0730")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("0730")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("0730")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("0730")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("0730")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("0730")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("0730")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("0730")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("0730")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("0730")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("0730")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_0730)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("0730")));
    }

    @Test
    public void testAll0800()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("0800")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("0800")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("0800")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("0800")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("0800")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("0800")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("0800")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("0800")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("0800")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("0800")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("0800")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("0800")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("0800")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_0800)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("0800")));
    }

    @Test
    public void testAll0830()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("0830")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("0830")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("0830")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("0830")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("0830")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("0830")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("0830")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("0830")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("0830")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("0830")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("0830")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("0830")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("0830")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_0830)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("0830")));
    }

    @Test
    public void testAll0900()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("0900")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("0900")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("0900")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("0900")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("0900")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("0900")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("0900")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("0900")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("0900")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("0900")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("0900")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("0900")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("0900")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_0900)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("0900")));
    }

    @Test
    public void testAll1000()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("1000")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("1000")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("1000")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("1000")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("1000")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("1000")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("1000")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("1000")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("1000")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("1000")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("1000")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("1000")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("1000")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_1000)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("1000")));
    }

    @Test
    public void testAll1100()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("1100")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("1100")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("1100")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("1100")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("1100")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("1100")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("1100")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("1100")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("1100")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("1100")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("1100")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("1100")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("1100")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_1100)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("1100")));
    }

    @Test
    public void testAll1200()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("1200")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("1200")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("1200")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("1200")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("1200")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("1200")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("1200")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("1200")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("1200")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("1200")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("1200")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("1200")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("1200")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_1200)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("1200")));
    }

    @Test
    public void testAll1530()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("1530")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("1530")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("1530")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("1530")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("1530")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("1530")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("1530")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("1530")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("1530")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("1530")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("1530")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("1530")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("1530")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_1530)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("1530")));
    }

    @Test
    public void testAll1600()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("1600")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("1600")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("1600")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("1600")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("1600")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("1600")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("1600")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("1600")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("1600")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("1600")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("1600")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("1600")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("1600")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_1600)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("1600")));
    }

    @Test
    public void testAll1700()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("1700")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("1700")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("1700")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("1700")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("1700")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("1700")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("1700")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("1700")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("1700")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("1700")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("1700")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("1700")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("1700")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_1700)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("1700")));
    }

    @Test
    public void testAll1800()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("1800")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("1800")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("1800")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("1800")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("1800")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("1800")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("1800")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("1800")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("1800")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("1800")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("1800")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("1800")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("1800")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_1800)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("1800")));
    }

    @Test
    public void testAll2000()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("2000")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("2000")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("2000")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("2000")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("2000")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("2000")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("2000")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("2000")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("2000")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("2000")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("2000")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("2000")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("2000")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_2000)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("2000")));
    }

    @Test
    public void testAllClose()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("----")));

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("----")));

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("----")));

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("----")));

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("----")));

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("----")));

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("----")));

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("----")));

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("----")));

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("----")));

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("----")));

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("----")));

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("----")));

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_close)).
                perform(click());
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("----")));
    }

    @Test
    public void testClear()
    {
        onView(withId(R.id.btn_mondayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_tuesdayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_wednesdayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_thursdayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_fridayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_saturdayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_sundayone)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_mondaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_tuesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_wednesdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_thursdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_fridaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_saturdaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_sundaytwo)).
                perform(click());
        onView(withId(R.id.btn_0700)).
                perform(click());

        onView(withId(R.id.btn_clear)).
                perform(click());


        onView(withId(R.id.btn_mondayone)).
                check(matches(withText("----")));
        onView(withId(R.id.btn_tuesdayone)).
                check(matches(withText("----")));
        onView(withId(R.id.btn_wednesdayone)).
                check(matches(withText("----")));
        onView(withId(R.id.btn_thursdayone)).
                check(matches(withText("----")));
        onView(withId(R.id.btn_fridayone)).
                check(matches(withText("----")));
        onView(withId(R.id.btn_saturdayone)).
                check(matches(withText("----")));
        onView(withId(R.id.btn_sundayone)).
                check(matches(withText("----")));
        onView(withId(R.id.btn_mondaytwo)).
                check(matches(withText("----")));
        onView(withId(R.id.btn_tuesdaytwo)).
                check(matches(withText("----")));
        onView(withId(R.id.btn_wednesdaytwo)).
                check(matches(withText("----")));
        onView(withId(R.id.btn_thursdaytwo)).
                check(matches(withText("----")));
        onView(withId(R.id.btn_fridaytwo)).
                check(matches(withText("----")));
        onView(withId(R.id.btn_saturdaytwo)).
                check(matches(withText("----")));
        onView(withId(R.id.btn_sundaytwo)).
                check(matches(withText("----")));
        
    }
}