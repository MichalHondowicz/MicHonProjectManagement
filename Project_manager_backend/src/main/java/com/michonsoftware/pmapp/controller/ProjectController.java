package com.michonsoftware.pmapp.controller;

import com.michonsoftware.pmapp.domain.Project;
import com.michonsoftware.pmapp.services.ProjectService;
import com.michonsoftware.pmapp.services.ValidationErrorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/projects")
@CrossOrigin
public class ProjectController {

    private final ProjectService projectService;
    private final ValidationErrorService validationErrorService;

    public ProjectController(ProjectService projectService, ValidationErrorService validationErrorService) {
        this.projectService = projectService;
        this.validationErrorService = validationErrorService;
    }

    @PostMapping
    public ResponseEntity<?> createProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> errorMap = validationErrorService.validationErrorService(result);
        if (errorMap != null) return errorMap;

        Project project1 = projectService.saveProject(project);
        return new ResponseEntity<>(project1, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId) {
        Project project = projectService.findByProjectIdentifier(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping
    public Iterable<Project> getAllProjects() {
        return projectService.findAllProjects();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId) {
        projectService.deleteProjectByIdentifier(projectId);
        return new ResponseEntity<>("Project with ID: " + projectId + " has been deleted", HttpStatus.OK);
    }

}
