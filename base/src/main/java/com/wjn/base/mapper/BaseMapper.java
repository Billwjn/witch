package com.wjn.base.mapper;

import com.wjn.base.dto.BaseDto;
import com.wjn.base.entity.BaseEntity;
import org.mapstruct.Mapper;

import java.util.List;

public interface BaseMapper<TEntity extends BaseEntity , TDto extends BaseDto> {

    /**
     * 将数据传输对象转换为实体。
     *
     * @param dto 数据传输对象。
     * @return 实体。
     */

    TEntity dtoToEntity(TDto dto);

    /**
     * 将多个数据传输对象转换为实体列表。
     *
     * @param dtos 数据传输对象列表。
     * @return 实体列表。
     */
    List<TEntity> dtosToEntities(List<TDto> dtos);

    /**
     * 将实体转换为数据传输对象。
     *
     * @param entity 实体。
     * @return 数据传输对象。
     */
    TDto entityToDto(TEntity entity);

    /**
     * 将多个实体转换为数据传输对象列表。
     *
     * @param entities 实体列表。
     * @return 数据传输对象列表。
     */
    List<TDto> entitiesToDtos(List<TEntity> entities);
}
