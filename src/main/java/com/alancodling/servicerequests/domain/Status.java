package com.alancodling.servicerequests.domain;

/**
 * Workflow status. The allowed transitions between these values are a business
 * rule, so they are enforced in ServiceRequestService, not here.
 */
public enum Status {
    OPEN,
    IN_PROGRESS,
    RESOLVED,
    CLOSED
}
