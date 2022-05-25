package com.example.paycalculator;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
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
public class InformationScreenTest
{
    @Rule
    public ActivityScenarioRule<Information> activityActivityScenarioRule = new ActivityScenarioRule<Information>(Information.class);

    @Test
    public void useAppContext()
    {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.paycalculator", appContext.getPackageName());
    }

    @Test
    public void testSelectOrderly() throws InterruptedException
    {
        onView(withId(R.id.rad_orderly))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectSecurity() throws InterruptedException
    {
        onView(withId(R.id.rad_security))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectSupervisor() throws InterruptedException
    {
        onView(withId(R.id.rad_supervisor))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectGrade0() throws InterruptedException
    {
        onView(withId(R.id.rad_gradeZero))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectGrade1() throws InterruptedException
    {
        onView(withId(R.id.rad_gradeOne))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectGrade2() throws InterruptedException
    {
        onView(withId(R.id.rad_gradeTwo))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectGrade3() throws InterruptedException
    {
        onView(withId(R.id.rad_gradeThree))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectKiwisaver0() throws InterruptedException
    {
        onView(withId(R.id.rad_kiwiZero))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectKiwisaver3() throws InterruptedException
    {
        onView(withId(R.id.rad_kiwiThree))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectKiwisaver4() throws InterruptedException
    {
        onView(withId(R.id.rad_kiwiFour))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectKiwisaver6() throws InterruptedException
    {
        onView(withId(R.id.rad_kiwiSix))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectKiwisaver8() throws InterruptedException
    {
        onView(withId(R.id.rad_kiwiEight))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectUnionYes() throws InterruptedException
    {
        onView(withId(R.id.rad_unionYes))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectUnionNo() throws InterruptedException
    {
        onView(withId(R.id.rad_unionNo))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectStudentLoanYes() throws InterruptedException
    {
        onView(withId(R.id.rad_loanYes))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectStudentLoanNo() throws InterruptedException
    {
        onView(withId(R.id.rad_loanNo))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectParkingCardYes() throws InterruptedException
    {
        onView(withId(R.id.rad_parkingYes))
                .perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void testSelectParkingCardNo() throws InterruptedException
    {
        onView(withId(R.id.rad_parkingNo))
                .perform(click());
        Thread.sleep(1000);
    }
}