package com.kam.blog.repositories;

import com.kam.blog.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUserName(String userName);
    
    @Transactional
    @Modifying
    @Query("update User set userName = :newName where id = :id")
    void update(@Param("newName") String newName,
                @Param("id") Long id);

}
