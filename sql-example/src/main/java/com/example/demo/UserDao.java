package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    @Transactional
    @Query(value = "select * from users u where u.userName = ?1", nativeQuery = true)
    User findUserByUserNameQuery(String userName);

    User findByUserNameOrAge(String username, int age);

    void deleteById(Long id);

    Long countByUserName(String userName);

    List<User> findByUserNameLike(String userName);

    User findByUserNameIgnoreCase(String userName);
}

