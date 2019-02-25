package com.michonsoftware.pmapp.controller;

import com.michonsoftware.pmapp.domain.Project;
import com.michonsoftware.pmapp.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Project> createProject (@RequestBody Project project){
        Project project1 = projectService.saveProject(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }

}
