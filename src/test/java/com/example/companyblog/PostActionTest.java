package com.example.companyblog;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PostActionTest {
    @Test
    public void shouldSendUserToInputPageByDefault() {
        PostAction action = new PostAction();

        String page = action.execute();

        assertThat(page, is("input"));
    }
}
