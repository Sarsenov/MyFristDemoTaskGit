package com.example.demotask.repos;

import com.example.demotask.models.ContactsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsRepo extends JpaRepository<ContactsModel, Long> {
}
