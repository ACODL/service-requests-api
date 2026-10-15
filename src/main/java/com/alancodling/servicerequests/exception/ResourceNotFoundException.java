package com.alancodling.servicerequests.exception;

/** -> 404. Thrown when a request doesn't exist OR is soft-deleted (callers can't tell the difference). */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id) {
        super("Service request " + id + " not found");
    }
}
