package com.sitronics.tn.tndocument2.controller;

import com.sitronics.tn.tndocument2.model.Document;
import com.sitronics.tn.tndocument2.service.DocumentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sitronics.tn.tndocument2.util.DateTimeUtil.parseLocalDateTime;


@Tag(name = "Document controller")
@RestController
@RequestMapping(value = DocumentController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentController {
    static final String REST_URL = "/documents";
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DocumentService service;

    @GetMapping("/{id}")
    public Document get(@PathVariable int id) {
        log.info("get {} for user ", id);
        return service.get(id);
    }

    @GetMapping
    public List<Document> getAll() {
        log.info("getAll documents for user ");
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Document createOrUpdate(Document document) {
        log.info("create {} for user", document);
        return service.createOrUpdate(document);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete document {} for user", id);
        service.delete(id);
    }

    /**
     * <ol>Filter separately
     * <li>by date</li>
     * <li>by time for every date</li>
     * </ol>
     */

    @GetMapping("/filter")
    public List<Document> getByCreatedBetween(@RequestParam @Nullable String startDate, @RequestParam @Nullable String endDate){
        return service.findByStartDateBetween(parseLocalDateTime(startDate), parseLocalDateTime(endDate));
    }
}
