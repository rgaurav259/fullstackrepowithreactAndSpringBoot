package com.example.fullstack.fullstackbackend.Repository;

import com.example.fullstack.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
