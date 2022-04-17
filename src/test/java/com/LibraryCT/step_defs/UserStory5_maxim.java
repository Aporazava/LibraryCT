package com.LibraryCT.step_defs;

import com.LibraryCT.pages.BooksPage;
import com.LibraryCT.pages.HomePage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.DB_Utility;
import com.LibraryCT.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.List;

public class UserStory5_maxim {
    LoginPage lp = new LoginPage();
    HomePage hp = new HomePage();
    BooksPage bp = new BooksPage();

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        lp.loginAsLibrarian();
    }

    @When("I navigate to {string} page")
    public void i_navigate_to_page(String tabName) {
        hp.clickTabFromNavigationBar(tabName);
    }

    @When("I open book {string}")
    public void i_open_book(String bookName) {
        bp.searchField.sendKeys(bookName + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOf(bp.oneOfOne));
    }

    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {

        DB_Utility.runQuery("select b.name, b.author, bc.name, b.year from books b\n" +
                "inner join book_categories bc on b.book_category_id = bc.id where b.name='Chordeiles minor'");
        List<String> bookInfoFromDB = DB_Utility.getRowDataAsList(1);


        Assert.assertEquals(bookInfoFromDB, bp.getBookInfoFromUI());

    }


}
