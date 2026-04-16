package com.vogella.junit5;

public class Utility {

    public static String getDatabaseConnection(String url) {
        return "https:///production/" + url;
    }
}

