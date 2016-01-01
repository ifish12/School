package com.cs406.xml;

/**
 * Created by Veliraydra on 16/05/2015.
 */
public class TagNameException extends Exception{

    public TagNameException(String received, String expected){
        super("Invalid tagname. Received: " + received + " . Expected: " + expected);
    }
}
