package com.alancodling.servicerequests.dto;

import com.alancodling.servicerequests.domain.Category;
import com.alancodling.servicerequests.domain.Priority;
import com.alancodling.servicerequests.domain.Status;

import java.time.Instant;

/**
 * What every endpoint returns for a single request.
 * Deliberately excludes:
 * - deletedAt: internal bookkeeping
 * - reporterEmail: a resident's personal info. With no auth yet, anyone could call GET,
 *   so returning it would leak PII.
 */
public record ServiceRequestResponse(
        Long id,
        String title,
        String description,
        Category category,
        Status status,
        Priority priority,
        String address,
        Double latitude,
        Double longitude,
        Instant createdAt,
        Instant updatedAt,
        Instant resolvedAt
) {
}
