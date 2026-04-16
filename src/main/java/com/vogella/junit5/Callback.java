package com.vogella.junit5;

public interface Callback {
    void onSuccess(String message);

    void onFailure(String error);
}

