package com.twelvesixty.peak;

import com.twelvesixty.peak.model.MessageBoard;
import com.twelvesixty.peak.model.Messages;
import com.twelvesixty.peak.model.User;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessagesTest {
    Messages m = new Messages();
    MessageBoard messageBoard = new MessageBoard();
    User message = new User();

    @Test
    public void getSetIdTest() {
        m.setId(123);

        assertEquals(m.getId(), 123);
    }

    @Test
    public void getSetMessageBoard() {
        MessageBoard  fakeMessageBoard = new MessageBoard();
        m.setMessageBoard(fakeMessageBoard);
        assertEquals(m.getMessageBoard(), fakeMessageBoard);
    }

    @Test
    public void getSetMessageAuthor() {
        User fakeMessageAuthor = new User();
        m.setMessageAuthor(fakeMessageAuthor);
        assertEquals(m.getMessageAuthor(), fakeMessageAuthor);
    }

    @Test
    public void getSetConstructorTest() {
        Messages fakeMessage = new Messages(messageBoard, message);

        assertEquals(fakeMessage.getMessageBoard(),messageBoard);
        assertEquals(fakeMessage.getMessageAuthor(),message);
    }

}