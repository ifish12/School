package com.cs616.defects.model;

import android.graphics.Color;

/**
 * Created by ian on 15-10-28.
 */
public class SeverityColor {

    private static final int ALPHA = 128;

    public static int get(Severity s) {
        switch (s) {
            case SHOWSTOPPER:
                return Color.argb(ALPHA, 171, 70, 64);
            case MAJOR:
                return Color.argb(ALPHA, 247, 202, 136);
            case MINOR:
                return Color.argb(ALPHA, 161, 181, 108);
            case TRIVIAL:
                return Color.WHITE;
            default:
                return Color.WHITE;
        }
    }

    private SeverityColor() {}
}
