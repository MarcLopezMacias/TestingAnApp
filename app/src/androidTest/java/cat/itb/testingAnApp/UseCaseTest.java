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
import static androidx.test.espresso.action.ViewActions.openLinkWithText;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static cat.itb.testingAnApp.LoginRegisterTest.PASSWORD_TO_BE_TYPED;
import static cat.itb.testingAnApp.LoginRegisterTest.USERNAME_TO_BE_TYPED;

@RunWith(AndroidJUnit4.class)
public class UseCaseTest {

    private static final String STUDENT_TO_BE_TYPED = "MARC LOPEZ MACIAS";
    private static final String MODULE_TO_BE_TYPED = "69";
    private static final String GRADE_TO_BE_TYPED = "10";
    private static final String DATE_TO_BE_TYPED = "24/06/1969";

    private static final String EMPTY = "";
    private static final String NEW_GRADE_TO_BE_TYPED = "5";

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    // ACTIVITY 4

    // CASE 1 - ADD GRADE

    @Test
    public void addGradeTest() {
        doLogin();
        addGrade();
    }

    // DO LOG IN

    @Test
    public void doLogin() {
        checkIsLoginFragment();
        usernameAndPasswordAreVisible();
        inputUsername();
        inputPassword();
        clickLoginOrRegisterButton();
        checkIsGradeListFragment();
    }

    @Test
    public void checkIsLoginFragment() {
        onView(withId(R.id.loginFragment)).check(matches(isDisplayed()));
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
    public void checkIsGradeListFragment() {
        onView(withId(R.id.mainListFragment)).check(matches(isDisplayed()));
    }

    // ADD GRADE

    @Test
    public void addGrade() {
        clickAddButton();
        checkIsGradeItemFragment();
        inputGradeData();
        saveData();
        goBack();
    }

    @Test
    public void clickAddButton() {
        onView(withId(R.id.addButton)).perform(click());

    }

    @Test
    public void checkIsGradeItemFragment() {
        onView(withId(R.id.detailFragment)).check(matches(isDisplayed()));
    }

    @Test
    public void inputGradeData() {
        onView(withId(R.id.student_name_detail)).perform(typeText(STUDENT_TO_BE_TYPED));
        pressBack();
        onView(withId(R.id.module_name_detail)).perform(typeText(MODULE_TO_BE_TYPED));
        pressBack();
        onView(withId(R.id.grade_detail)).perform(typeText(GRADE_TO_BE_TYPED));
        pressBack();
        onView(withId(R.id.date_detail)).perform(typeText(DATE_TO_BE_TYPED));
        pressBack();
        onView(withId(R.id.assistanceCheckBox)).perform(click());
    }

    @Test
    public void saveData() {
        onView(withId(R.id.update_button_detail)).perform(click());
        pressBack();
    }

    @Test
    public void goBack() {
        onView(withId(R.id.go_back_button)).perform(click());
    }

    // CASE 2 - EDIT GRADE

    @Test
    public void editGradeTest() {
        doLogin();
        editGrade();
    }

    @Test
    public void editGrade() {
        goToGrade();
        modifyData();
        saveData();
        goBack();
    }

    @Test
    public void goToGrade() {
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.detailFragment)).check(matches(isDisplayed()));
    }

    @Test
    public void modifyData() {
        onView(withId(R.id.grade_detail)).perform(replaceText(NEW_GRADE_TO_BE_TYPED));
        onView(withId(R.id.assistanceCheckBox)).perform(click());
    }

    // CASE 3

    @Test
    public void deleteGradeTest() {
        doLogin();
        deleteGrade();
    }

    @Test
    public void deleteGrade() {
        goToGrade();
        deleteGradeItem();
    }

    @Test
    public void deleteGradeItem() {
        onView(withId(R.id.delete_button)).perform(click());
    }
}
