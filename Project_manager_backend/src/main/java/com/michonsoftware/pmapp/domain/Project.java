package com.michonsoftware.pmapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private String projectIdentifier;
    private String projectDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate createdOn;
    private LocalDate updatedOn;

    @PrePersist
    protected void projectCreatedOn() {
        this.createdOn = LocalDate.now();
    }

    @PreUpdate
    protected void projectUpdatedOn() {
        this.updatedOn = LocalDate.now();
    }
}
