package com.alancodling.servicerequests.domain;

/** Triage priority. Defaults to MEDIUM when the client doesn't send one (set by the service). */
public enum Priority {
    LOW,
    MEDIUM,
    HIGH
}
