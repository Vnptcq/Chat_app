package com.hayuta14.identity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hayuta14.identity.dto.request.RoleRequest;
import com.hayuta14.identity.dto.response.RoleResponse;
import com.hayuta14.identity.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
