package com.example.demotask.repos;

import com.example.demotask.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends JpaRepository<UsersModel, Long> {

    UsersModel findByUserName(String asdf);
}
