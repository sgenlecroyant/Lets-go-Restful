package com.sgenlecroyant.gorestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgenlecroyant.gorestful.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
