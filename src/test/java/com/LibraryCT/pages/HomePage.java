package com.LibraryCT.pages;

import com.LibraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user_count")
    public WebElement usersCount;

    @FindBy(id = "book_count")
    public WebElement booksCount;


    @FindBy(id = "borrowed_books")
    public WebElement borrowedBooksCount;


}
