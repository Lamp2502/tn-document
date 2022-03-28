package com.sitronics.tn.tndocument2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sitronics.tn.tndocument2.HasId;
import com.sitronics.tn.tndocument2.model.Customer;
import com.sitronics.tn.tndocument2.model.Status;
import com.sitronics.tn.tndocument2.model.Supplier;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto implements HasId {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // https://stackoverflow.com/a/28025008/548473
    protected Integer id;

    @NotBlank
    @Size(min = 2, max = 64)
    //  @NoHtml
    protected String name;

    @NotBlank
    @Size(max = 64)
    @Column(name = "number")
    private String number;

    @NotBlank
    @Size(max = 128)
    @Column(name = "content")
    private String content;

    //private Contract contract;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "customer")
    @Enumerated(EnumType.STRING)
    private Customer customer;

    @Column(name = "supplier")
    @Enumerated(EnumType.STRING)
    private Supplier supplier;

    @Column(name = "amount")
    private Long amount;

    @CreatedDate
    //  @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @LastModifiedDate
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "modified", nullable = false, updatable = false)
    private LocalDateTime modified;
}
