package com.sitronics.tn.tndocument2.service;

import com.sitronics.tn.tndocument2.model.Document;
import com.sitronics.tn.tndocument2.repository.DocumentRepository;
import com.sitronics.tn.tndocument2.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository repository;

    public Document get(int id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Document not found: id = " + id));
    }

    public List<Document> getAll() {
        return repository.findAll();
    }

    public Document createOrUpdate(Document document) {
        return repository.save(document);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Document> findByStartDateBetween(@Nullable LocalDateTime startDate, @Nullable LocalDateTime endDate){
       return repository.findByCreatedBetween(startDate, endDate);
    }
}
