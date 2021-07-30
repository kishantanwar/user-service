package com.epam.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.user.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {

}
