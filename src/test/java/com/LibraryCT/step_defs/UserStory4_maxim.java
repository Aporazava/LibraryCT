package com.LibraryCT.step_defs;

import com.LibraryCT.utilities.DB_Utility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserStory4_maxim {

    @When("I execute a query to find the most popular user")
    public void i_execute_a_query_to_find_the_most_popular_user() {
        DB_Utility.runQuery("select full_name, count(*) from users u left outer  join  book_borrow bb on u.id = bb.user_id group by full_name order by 2 DESC");
    }

    @Then("verify {string} is the user who reads the most")
    public void verify_test_student_number_is_the_user_who_reads_the_most(String name) {
        Assert.assertEquals(name, DB_Utility.getFirstData());
    }
}
