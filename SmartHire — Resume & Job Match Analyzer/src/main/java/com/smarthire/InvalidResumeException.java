package com.smarthire.exception;

/** Thrown when an uploaded file is not a usable PDF resume. The message is safe to show users. */
public class InvalidResumeException extends RuntimeException {
    public InvalidResumeException(String message) { super(message); }
}
