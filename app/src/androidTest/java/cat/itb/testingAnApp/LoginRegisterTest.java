package cat.itb.testingAnApp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

// ACTIVITY 2

@RunWith(AndroidJUnit4.class)
public class LoginRegisterTest {

    final static String USERNAME_TO_BE_TYPED = "Username";
    final static String PASSWORD_TO_BE_TYPED = "Password";

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testLoginOrRegister() {
        usernameAndPasswordAreVisible();
        inputUsername();
        inputPassword();
        fromLoginToList();
        checkFragmentChanged();
    }

    @Test
    public void usernameAndPasswordAreVisible() {
        onView(withId(R.id.username_login_edittext)).check(matches(isDisplayed()));
        onView(withId(R.id.password_login_edittext)).check(matches(isDisplayed()));
    }

    @Test
    public void inputUsername() {
        onView(withId(R.id.username_login_edittext)).perform(typeText(USERNAME_TO_BE_TYPED));
        pressBack();
    }

    @Test
    public void inputPassword() {
        onView(withId(R.id.password_login_edittext)).perform(typeText(PASSWORD_TO_BE_TYPED));
        pressBack();
    }

    @Test
    public void fromLoginToList() {
        onView(withId(R.id.loginButton)).perform(click());
    }

    @Test
    public void checkFragmentChanged() {
        onView(withId(R.id.mainListFragment)).check(matches(isDisplayed()));
    }

}
