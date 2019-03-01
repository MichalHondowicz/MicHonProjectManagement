package com.michonsoftware.pmapp.services;

import com.michonsoftware.pmapp.domain.Project;
import com.michonsoftware.pmapp.exceptions.ProjectIdException;
import com.michonsoftware.pmapp.exceptions.ProjectNotFoundException;
import com.michonsoftware.pmapp.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project saveProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception ex) {
            throw new ProjectIdException(project.getProjectIdentifier().toUpperCase());
        }
    }

    @Override
    public Project findByProjectIdentifier(String projectId) {

        Project project = projectRepository.findByProjectIdentifier(projectId);

        if (project == null) {
            throw new ProjectNotFoundException(projectId);
        }
        return project;
    }
}
