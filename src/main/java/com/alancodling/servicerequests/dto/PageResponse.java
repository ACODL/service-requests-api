package com.alancodling.servicerequests.dto;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Our own stable JSON shape for paginated lists (instead of serializing Spring's Page).
 * Generic: PageResponse<ServiceRequestResponse>, PageResponse<SomethingElse>, ...
 */
public record PageResponse<T>(
        List<T> content,
        int page,
        int size,
        long totalElements,
        int totalPages
) {
    /** Generic static factory: the <T> before the return type declares the method's own type parameter. */
    public static <T> PageResponse<T> from(Page<T> page) {
        return new PageResponse<>(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages());
    }
}
