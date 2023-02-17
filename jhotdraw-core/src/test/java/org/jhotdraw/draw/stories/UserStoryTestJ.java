package org.jhotdraw.draw.stories;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.FillerWord;
import com.tngtech.jgiven.junit.SimpleScenarioTest;
import org.junit.Test;


public class UserStoryTestJ extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {

    @Test
    public void edit_text_field_when_new_text_is_added() {
        given().old_text_need_change();

            when().new_text_is_entered();

            then().old_text_is_replaced();
    }

    @Test
    public void add_text_to_the_canvas() {
        given().text_to_write_to_canvas();

            when().user_types_text_in_text_field();

            then().text_is_set_on_the_canvas();
    }

}


