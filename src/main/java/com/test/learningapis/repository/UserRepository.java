package com.test.learningapis.repository;

import org.springframework.stereotype.Repository;

import com.test.learningapis.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {}
