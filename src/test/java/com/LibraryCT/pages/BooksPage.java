package com.LibraryCT.pages;

import com.LibraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BooksPage {
    public BooksPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchField;


    @FindBy(xpath = "//tbody//td[3]")
    public WebElement nameOfBook;

    @FindBy(xpath = "//tbody//td[4]")
    public WebElement author;

    @FindBy(xpath = "//tbody//td[5]")
    public WebElement category;

    @FindBy(xpath = "//tbody//td[6]")
    public WebElement year;


    public List<String> getBookInfoFromUI() {
        List<String> list = new ArrayList<>();

        list.add(nameOfBook.getText());
        list.add(author.getText());
        list.add(category.getText());
        list.add(year.getText());

        return list;
    }


    @FindBy(xpath = "//div[text()='Showing 1 to 1 of 1 entries']")
    public WebElement oneOfOne;

}
