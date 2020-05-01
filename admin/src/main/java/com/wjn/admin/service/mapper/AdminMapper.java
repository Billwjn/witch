package com.wjn.admin.service.mapper;

import com.wjn.admin.entity.Admin;
import com.wjn.api.dto.AdminDto;
import com.wjn.base.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AdminMapper extends BaseMapper<Admin, AdminDto> {
}
