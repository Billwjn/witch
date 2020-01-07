package com.wjn.base.repository;

import com.wjn.base.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * 仓储接口的统一接口。
 *
 * @param <T> 实体类型参数。
 * @author wujianong
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, String>, JpaSpecificationExecutor<T>, QueryByExampleExecutor<T> {
}
