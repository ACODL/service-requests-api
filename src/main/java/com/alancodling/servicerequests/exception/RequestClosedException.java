package com.alancodling.servicerequests.exception;

/** -> 409. CLOSED is terminal: details can no longer be edited. */
public class RequestClosedException extends RuntimeException {

    public RequestClosedException(Long id) {
        super("Service request " + id + " is CLOSED and can no longer be edited");
    }
}
