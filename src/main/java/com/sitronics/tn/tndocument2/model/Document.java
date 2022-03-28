package com.sitronics.tn.tndocument2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sitronics.tn.tndocument2.HasId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.util.ProxyUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)  // https://stackoverflow.com/a/6084701/548473
@Table(name = "documents")
public class Document implements Persistable<Integer>, HasId, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // https://stackoverflow.com/a/28025008/548473
    private Integer id;

    @NotBlank
    @Size(min = 2, max = 64)
    @Column(name = "name", nullable = false)
    //@NoHtml
    private String name;

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
  //  @NotNull
   // @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @LastModifiedDate
   // @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "modified", nullable = false, updatable = false)
    private LocalDateTime modified;

    // doesn't work for hibernate lazy proxy
    public int id() {
        Assert.notNull(id, "Entity must have id");
        return id;
    }

    @JsonIgnore
    @Override
    public boolean isNew() {
        return id == null;
    }

    // https://stackoverflow.com/questions/1638723
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(ProxyUtils.getUserClass(o))) {
            return false;
        }
        Document document = (Document) o;
        return id != null && id.equals(document.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number, content, status, customer, supplier, amount, created, modified);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", customer=" + customer +
                ", supplier=" + supplier +
                ", amount=" + amount +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
