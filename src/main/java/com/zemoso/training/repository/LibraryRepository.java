package com.zemoso.training.repository;

import com.zemoso.training.entity.UserLibrary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LibraryRepository extends JpaRepository<UserLibrary, UUID> {
}
