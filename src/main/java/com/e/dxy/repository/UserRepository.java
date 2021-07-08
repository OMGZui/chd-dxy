package com.e.dxy.repository;

import com.e.dxy.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    @Query(value = "select b from UserModel b where b.username like %:username%")
    Page<UserModel> searchByUsername(Pageable pageable, @Param("username") String username);

}
