package com.proofit.techtask.exception;

import java.io.IOException;

public class DataNotReceivedException extends IOException {
    public DataNotReceivedException(String message) {
        super(message);
    }
}
