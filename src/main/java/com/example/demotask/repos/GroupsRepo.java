package com.example.demotask.repos;

import com.example.demotask.models.GroupsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepo extends JpaRepository<GroupsModel, Long> {
}
