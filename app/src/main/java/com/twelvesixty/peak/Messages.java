package com.twelvesixty.peak;

public class Messages {
    private long id;
    private MessageBoard messageBoard;
    private User messageAuthor;

    public Messages () {}

    public Messages (long id, MessageBoard messageBoard, User messageAuthor) {
        this.id = id;
        this.messageBoard = messageBoard;
        this.messageAuthor = messageAuthor;
    }

    ////////////////////// -- getters

    public long getId() {
        return id;
    }

    public MessageBoard getMessageBoard() {
        return messageBoard;
    }

    public User getMessageAuthor() {
        return messageAuthor;
    }

    ////////////////////// -- setters

    public void setId(long id) {
        this.id = id;
    }

    public void setMessageBoard(MessageBoard messageBoard) {
        this.messageBoard = messageBoard;
    }

    public void setMessageAuthor(User messageAuthor) {
        this.messageAuthor = messageAuthor;
    }
}