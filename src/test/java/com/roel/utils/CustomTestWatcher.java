package com.roel.utils;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class CustomTestWatcher extends TestWatcher {
    private Throwable throwable;

    @Override
    protected void failed(Throwable e, Description description) {
        this.throwable = e;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}

