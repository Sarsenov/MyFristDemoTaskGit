package com.example.demotask.repos;

import com.example.demotask.models.TelbookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelbookRepo extends JpaRepository<TelbookModel, Long> {
}
