package com.cs616.defects.model;

/**
 * Created by ian on 15-10-03.
 */
public enum Status {
    CREATED("CREATED"),
    ACCEPTED("ACCEPTED"),
    FIXED("FIXED"),
    REOPENED("REOPENED"),
    CLOSED("CLOSED");


    private String text;

    Status(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Status fromString(String text) {
        if (text != null) {
            for (Status b : Status.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }
}
