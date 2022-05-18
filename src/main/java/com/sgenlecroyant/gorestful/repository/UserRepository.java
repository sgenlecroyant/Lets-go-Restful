package com.sgenlecroyant.gorestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgenlecroyant.gorestful.entity.User;

@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{

}
