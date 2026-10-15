package com.alancodling.servicerequests.repository;

import com.alancodling.servicerequests.domain.Category;
import com.alancodling.servicerequests.domain.ServiceRequest;
import com.alancodling.servicerequests.domain.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * An interface with no implementation: Spring Data generates it at startup.
 * JpaRepository<ServiceRequest, Long> = entity type + id type, and gives us
 * save, findById, findAll, delete, count, ... for free.
 *
 * SOFT DELETE RULE: the service must only use methods that exclude deleted rows.
 * Avoid the inherited findById/findAll in service code, because they include deleted rows.
 */
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {

    /** Derived query: Spring Data writes the SQL from the method name. */
    Optional<ServiceRequest> findByIdAndDeletedAtIsNull(Long id);

    /**
     * Explicit JPQL query (queries entities and fields, not tables and columns).
     * A null filter means "don't filter on this", which handles all 4 combinations in one query.
     */
    @Query("""
            SELECT r FROM ServiceRequest r
            WHERE r.deletedAt IS NULL
              AND (:status IS NULL OR r.status = :status)
              AND (:category IS NULL OR r.category = :category)
            """)
    Page<ServiceRequest> search(@Param("status") Status status,
                                @Param("category") Category category,
                                Pageable pageable);
}
