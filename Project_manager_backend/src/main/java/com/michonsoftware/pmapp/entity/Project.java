package com.michonsoftware.pmapp.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project name is necessary")
    private String projectName;

    @NotBlank(message = "Project identifier is necessary")
    @Size(min = 4, max = 5, message = "Project identifier to be 4 to 5 characters")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;

    @NotBlank(message = "Project description is necessary")
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
