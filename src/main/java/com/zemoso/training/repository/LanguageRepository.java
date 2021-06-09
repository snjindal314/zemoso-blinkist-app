package com.zemoso.training.repository;

import com.zemoso.training.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LanguageRepository extends JpaRepository<Language, UUID> {
}
