package com.michonsoftware.pmapp.services;

import com.michonsoftware.pmapp.entity.Project;

import java.util.List;

public interface ProjectService {

    Project saveProject(Project project);

    Project findByProjectIdentifier(String projectId);

    List<Project> findAllProjects();

    void deleteProjectByIdentifier(String projectIdentifier);

}
