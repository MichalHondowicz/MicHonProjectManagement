package com.michonsoftware.pmapp.services;

import com.michonsoftware.pmapp.entity.Project;

public interface ProjectService {

    Project saveProject(Project project);

    Project findByProjectIdentifier(String projectId);

    Iterable<Project> findAllProjects();

    void deleteProjectByIdentifier(String projectIdentifier);

}
