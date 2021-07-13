package com.e.dxy.dao;

import com.e.dxy.domain.UserDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserDomain, Integer> {

    @Query(value = "select b from UserDomain b where b.username like %:username%")
    Page<UserDomain> searchByUsername(Pageable pageable, @Param("username") String username);
}
