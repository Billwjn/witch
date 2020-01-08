package com.wjn.base.service;

import com.wjn.base.dto.BaseDto;
import com.wjn.base.entity.BaseEntity;
import com.wjn.base.mapper.BaseMapper;
import com.wjn.base.repository.BaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.Assert;

import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
public class BaseService<TDto extends BaseDto , TEntity extends BaseEntity , TMapper extends BaseMapper<TEntity,TDto> , TRepository extends BaseRepository<TEntity>> {
    @Autowired
    protected TRepository repository;

    @Autowired
    protected TMapper mapper;

    /**
     * 无条件查询所有方法
     *
     * @author wujianong
     */
    public List<TDto> findAll(){
        Specification<TEntity> specification = (Specification<TEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.equal(root.get("dr"), "0");
            return predicate;
        };
        List<TEntity> entities = repository.findAll(specification);
        return mapper.entitiesToDtos(entities);
    }

    /**
     * 保存方法
     *
     * @author wujianong
     */
    public TDto create(TDto dto){
        Assert.notNull(dto, "dto 参数不能为空");
        TEntity entity = mapper.dtoToEntity(dto);
        //设置默认值
        setDefaultValues(entity);
        TEntity tEntity = repository.save(entity);
        return mapper.entityToDto(tEntity);
    }

    /**
     * 设置默认值
     *
     * @author wujianong
     */
    public void setDefaultValues(TEntity entity){
        String s = UUID.randomUUID().toString();
        String id = s.replace("-", "");
        entity.setId(id);
        Date date = new Date();
        entity.setTs(date);
        entity.setCreateTime(date);
    }
}
