package com.alancodling.servicerequests.mapper;

import com.alancodling.servicerequests.domain.ServiceRequest;
import com.alancodling.servicerequests.dto.CreateServiceRequestDto;
import com.alancodling.servicerequests.dto.ServiceRequestResponse;
import com.alancodling.servicerequests.dto.UpdateServiceRequestDto;
import org.springframework.stereotype.Component;

/**
 * Hand-written entity <-> DTO mapping. Pure field copying, no business rules
 * (defaults and status are the service's job).
 */
@Component
public class ServiceRequestMapper {

    public ServiceRequest toEntity(CreateServiceRequestDto dto) {
        return new ServiceRequest(
                dto.title(),
                dto.description(),
                dto.category(),
                dto.priority(),
                dto.address(),
                dto.latitude(),
                dto.longitude(),
                dto.reporterEmail());
    }

    /** PUT semantics: every editable field is overwritten, including with null. */
    public void applyUpdate(ServiceRequest entity, UpdateServiceRequestDto dto) {
        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setCategory(dto.category());
        entity.setPriority(dto.priority());
        entity.setAddress(dto.address());
        entity.setLatitude(dto.latitude());
        entity.setLongitude(dto.longitude());
    }

    public ServiceRequestResponse toResponse(ServiceRequest entity) {
        return new ServiceRequestResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getCategory(),
                entity.getStatus(),
                entity.getPriority(),
                entity.getAddress(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getResolvedAt());
    }
}
