package com.alancodling.servicerequests.dto;

import com.alancodling.servicerequests.domain.Status;
import jakarta.validation.constraints.NotNull;

/** PATCH /status body. Only one field, on purpose. */
public record StatusUpdateDto(@NotNull Status status) {
}
