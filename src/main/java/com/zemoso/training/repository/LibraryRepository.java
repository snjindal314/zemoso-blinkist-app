package com.zemoso.training.repository;

import com.zemoso.training.entity.UserLibrary;
import com.zemoso.training.entity.UserLibraryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LibraryRepository extends JpaRepository<UserLibrary, UserLibraryId > {

    List<UserLibrary> findByUserLibraryIdUserUserId(UUID userId);
}
