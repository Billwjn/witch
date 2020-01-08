package com.wjn.admin.repository;

import com.wjn.admin.entity.Admin;
import com.wjn.base.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends BaseRepository<Admin> {
    @Query(value = "select * from witch_admin where username = ?1" , nativeQuery = true)
    Admin fingAdminByUsername(String username);
}
