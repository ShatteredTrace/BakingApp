package com.kirsch.lennard.bakingapp;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.kirsch.lennard.bakingapp.Activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityScreenTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickRecyclerViewItem_OpensDetailActivity(){
      onView(withId(R.id.recycler_recipe_main)).perform(RecyclerViewActions.scrollToPosition(3));
      onView(withId(R.id.recycler_recipe_main)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));

      onView(withId(R.id.recipe_list_fragment_recycler)).check(matches(isDisplayed()));
      onView(withId(R.id.recipe_list_fragment_recycler)).perform(actionOnItemAtPosition(1, click()));

      onView(withId(R.id.recipe_detail_instruction_textview)).check(matches(isDisplayed()));
    }
}