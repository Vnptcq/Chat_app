package com.hayuta14.identity.mapper;

import org.mapstruct.Mapper;

import com.hayuta14.identity.dto.request.PermissionRequest;
import com.hayuta14.identity.dto.response.PermissionResponse;
import com.hayuta14.identity.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
