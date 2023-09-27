package ru.lm359.shotclockbanking.controller.exception;

import java.util.Date;

public class AppError {
    private int status;
    private String message;
    private Date date;

    public AppError(int status, String message) {
        this.status = status;
        this.message = message;
        this.date=new Date();
    }
}
