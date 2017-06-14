package com.akvelon.mobilecenterandroiddemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.xamarin.testcloud.espresso.Factory;
import com.xamarin.testcloud.espresso.ReportHelper;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by ruslan on 6/13/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginScreenTest {

    private String btnTwitter;
    private String btnFacebook;

    @Rule
    public ReportHelper reportHelper = Factory.getReportHelper();

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(
            LoginActivity.class);

    @Before
    public void initValidString() {
        btnFacebook = "LOGIN VIA FACEBOOK";
        btnTwitter = "LOGIN VIA TWITTER";
    }

    @After
    public void TearDown(){
        reportHelper.label("Stopping App");
    }

    @Test
    public void checkFacebookButton() {
        reportHelper.label("check facebook button");
        onView(withId(R.id.login_facebook_button)).check(matches(withText(btnFacebook)));
    }
    @Test
    public void checkTwitterButton() {
        reportHelper.label("check twitter button");
        onView(withId(R.id.login_twitter_button)).check(matches(withText(btnTwitter)));
    }

}
