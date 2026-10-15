package com.alancodling.servicerequests.dto;

import com.alancodling.servicerequests.domain.Category;
import com.alancodling.servicerequests.domain.Priority;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * PUT body: full replacement of the editable details.
 * Differs from the create DTO: reporterEmail is the resident's contact info, so staff can't edit it.
 */
public record UpdateServiceRequestDto(
        @NotBlank @Size(min = 5, max = 100) String title,
        @Size(max = 1000) String description,
        @NotNull Category category,
        Priority priority,
        @NotBlank @Size(max = 255) String address,
        @DecimalMin("-90.0") @DecimalMax("90.0") Double latitude,
        @DecimalMin("-180.0") @DecimalMax("180.0") Double longitude
) {
}
