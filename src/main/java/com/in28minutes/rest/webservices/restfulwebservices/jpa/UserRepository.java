package com.in28minutes.rest.webservices.restfulwebservices.jpa;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This is a repository class that communicates with the database
// and performs CRUD operations on the User entity.

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
