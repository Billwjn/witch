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
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
        if (StringUtils.isEmpty(dto.getCreator())){
            throw new RuntimeException("获取不到当前登陆人,请重新登录");
        }
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
        StringBuilder sb = new StringBuilder();
        String name = entity.getClass().getName();
        String substring = name.substring(name.lastIndexOf(".")+1);
        sb.append(substring);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmSS");
        sb.append(simpleDateFormat.format(date));
        entity.setCode(sb.toString());
        entity.setDr(0);
        entity.setTs(date);
        entity.setCreateTime(date);
    }

    /**
     * 根据id查询详情
     * @param id
     * @return
     */
    public TDto findOneById(String id){
        Optional<TEntity> optionalTEntity = repository.findById(id);
        return mapper.entityToDto(optionalTEntity.get());
    }

    /**
     * 根据id删除
     * @param id
     */
    public void delete(String id){
        Optional<TEntity> optionalTEntity = repository.findById(id);
        TEntity entity = optionalTEntity.get();
        entity.setDr(1);
        repository.deleteById(id);
        repository.save(entity);
    }
}
