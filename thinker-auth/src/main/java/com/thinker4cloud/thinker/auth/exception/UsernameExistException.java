package com.thinker4cloud.thinker.auth.exception;

/**
 * Created by dev@panjunye.com on 2019/03/29.
 */

public class UsernameExistException extends Error {
    public UsernameExistException() {
    }

    public UsernameExistException(String message) {
        super(message);
    }

    public UsernameExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameExistException(Throwable cause) {
        super(cause);
    }

    public UsernameExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
