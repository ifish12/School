package com.cs616.defects.model;

/**
 * Created by ian on 15-10-08.
 */
public enum Severity {
    TRIVIAL("TRIVIAL"),
    MINOR("MINOR"),
    MAJOR("MAJOR"),
    SHOWSTOPPER("SHOWSTOPPER");

    private String text;

    Severity(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Severity fromString(String text) {
        if (text != null) {
            for (Severity b : Severity.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }

}
