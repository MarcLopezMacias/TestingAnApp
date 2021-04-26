package cat.itb.testingAnApp;

import androidx.test.espresso.contrib.RecyclerViewActions;
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
import static cat.itb.testingAnApp.LoginRegisterTest.PASSWORD_TO_BE_TYPED;
import static cat.itb.testingAnApp.LoginRegisterTest.USERNAME_TO_BE_TYPED;

@RunWith(AndroidJUnit4.class)
public class NavigationTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    // ACTIVITY 3

    // Nº 1

    @Test
    public void fromLoginToGradeList() {
        testLoginOrRegister();
    }

    // CTRL + C --> CTRL + V DE L'ACTIVITAT ANTERIOR
    // PERQUE NO PUC FER EL METODE ESTATIC I CRIDAR-LO DES D'AQUI

    @Test
    public void testLoginOrRegister() {
        usernameAndPasswordAreVisible();
        inputUsername();
        inputPassword();
        clickLoginOrRegisterButton();
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
    public void clickLoginOrRegisterButton() {
        onView(withId(R.id.loginButton)).perform(click());
    }

    @Test
    public void checkFragmentChanged() {
        onView(withId(R.id.mainListFragment)).check(matches(isDisplayed()));
    }

    // Nº 2

    @Test
    public void fromGradeListToGradeItem() {
        // PRIMER HEM DE FER LOG-IN
        fromLoginToGradeList();

        // I DESPRES FER CLICK A LA GRADE
        clickOnGradeItem();
    }

    @Test
    public void clickOnGradeItem() {
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    // Nº 3

    @Test
    public void fromGradeItemToGradeList() {
        fromLoginToGradeList();
        clickOnGradeItem();
        pressBack();
        checkFragmentChanged();
    }

}
