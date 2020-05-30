package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
}
