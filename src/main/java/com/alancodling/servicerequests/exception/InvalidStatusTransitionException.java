package com.alancodling.servicerequests.exception;

import com.alancodling.servicerequests.domain.Status;

/** -> 409. The requested status change isn't allowed from the current status. */
public class InvalidStatusTransitionException extends RuntimeException {

    private final Status from;
    private final Status to;

    public InvalidStatusTransitionException(Status from, Status to) {
        super("Cannot change status from " + from + " to " + to);
        this.from = from;
        this.to = to;
    }

    public Status getFrom() { return from; }
    public Status getTo() { return to; }
}
