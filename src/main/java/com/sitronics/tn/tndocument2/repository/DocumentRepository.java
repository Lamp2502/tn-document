package com.sitronics.tn.tndocument2.repository;

import com.sitronics.tn.tndocument2.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

    List<Document> findByCreatedBetween(LocalDateTime created, LocalDateTime endDate);
}
