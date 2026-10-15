package com.alancodling.servicerequests.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

/**
 * JPA entity: one instance = one row in the service_requests table.
 *
 * Notes:
 * - Column names: Spring Boot's default naming strategy turns camelCase fields into
 *   snake_case columns automatically (reporterEmail -> reporter_email), so we don't
 *   need @Column(name = ...) unless a column name differs from the field name.
 * - Timestamps are set by the SERVICE using an injected Clock (not by JPA callbacks),
 *   so they can be controlled and asserted in unit tests.
 * - equals/hashCode are intentionally NOT overridden. Default object identity is safe
 *   for entities; generating them from all fields (e.g. Lombok @Data) causes bugs.
 */
@Entity
@Table(name = "service_requests")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // the DB auto-increments the id
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING) // store "POTHOLE", never the ordinal 0
    @Column(nullable = false, length = 30)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Priority priority;

    @Column(nullable = false)
    private String address;

    private Double latitude;

    private Double longitude;

    private String reporterEmail;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    private Instant resolvedAt;

    private Instant deletedAt; // null = active, non-null = soft-deleted

    /** Required by JPA: Hibernate creates an empty instance, then fills the fields. */
    protected ServiceRequest() {
    }

    /** Creation constructor. Status, priority default, and timestamps are set by the service. */
    public ServiceRequest(String title, String description, Category category, Priority priority,
                          String address, Double latitude, Double longitude, String reporterEmail) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.reporterEmail = reporterEmail;
    }

    // ---- Getters ----

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Category getCategory() { return category; }
    public Status getStatus() { return status; }
    public Priority getPriority() { return priority; }
    public String getAddress() { return address; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public String getReporterEmail() { return reporterEmail; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public Instant getResolvedAt() { return resolvedAt; }
    public Instant getDeletedAt() { return deletedAt; }

    // ---- Setters (only for fields that are allowed to change; no setId, no setReporterEmail) ----

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(Category category) { this.category = category; }
    public void setStatus(Status status) { this.status = status; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public void setAddress(String address) { this.address = address; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
    public void setResolvedAt(Instant resolvedAt) { this.resolvedAt = resolvedAt; }
    public void setDeletedAt(Instant deletedAt) { this.deletedAt = deletedAt; }
}
