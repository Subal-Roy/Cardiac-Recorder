package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.anything;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest


public class MainActivityTest {

    @Rule
    public androidx.test.ext.junit.rules.ActivityScenarioRule<com.example.cardiacrecorder.MainActivity> activityRule =
            new androidx.test.ext.junit.rules.ActivityScenarioRule<>(com.example.cardiacrecorder.MainActivity.class);

    /**
     * UI Test for Welcome Screen
     */

    @Test
    public void testSplash() {
        onView(withId(R.id.splash)).check(matches(isDisplayed()));
    }

    public static class HomeTest {
        @Rule
        public androidx.test.ext.junit.rules.ActivityScenarioRule<Home> activityRule =
                new androidx.test.ext.junit.rules.ActivityScenarioRule<>(Home.class);

        /**
         * UI Test for data insertion
         */

        @Test
        public void testadd(){
            onView(withId(R.id.fab)).perform(click());
            onView(withId(R.id.add)).check(matches(isDisplayed()));

            onView(withId(R.id.addSystolic)).perform(androidx.test.espresso.action.ViewActions.typeText("120"));
            onView(withId(R.id.addSystolic)).perform(androidx.test.espresso.action.ViewActions.clearText());
            onView(withId(R.id.addSystolic)).perform(androidx.test.espresso.action.ViewActions.typeText("130"));
            pressBack();

            onView(withId(R.id.addDiastolic)).perform(androidx.test.espresso.action.ViewActions.typeText("75"));
            pressBack();

            onView(withId(R.id.addHeartRate)).perform(androidx.test.espresso.action.ViewActions.typeText("55"));
            pressBack();

            /*onView(withId(R.id.date)).perform(androidx.test.espresso.action.ViewActions.typeText("27-07-2022"));
            pressBack();*/

            onView(withId(R.id.time)).perform(androidx.test.espresso.action.ViewActions.typeText("01:30 PM"));
            pressBack();

            onView(withId(R.id.addComment)).perform(androidx.test.espresso.action.ViewActions.typeText("normal"));
            pressBack();

            onView(withId(R.id.addRecord)).perform(click());
            onView(withId(R.id.home)).check(matches(isDisplayed()));
        }


    }
}




