package com.michonsoftware.pmapp.services;

import com.michonsoftware.pmapp.entity.Project;
import com.michonsoftware.pmapp.exceptions.ProjectIdException;
import com.michonsoftware.pmapp.exceptions.ProjectNotFoundException;
import com.michonsoftware.pmapp.repositories.ProjectRepository;
import org.springframework.stereotype.Service;


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
        return projectRepository
                .findByProjectIdentifier(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
    }

    @Override
    public Iterable<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProjectByIdentifier(String projectIdentifier) {
        Project project = projectRepository
                .findByProjectIdentifier(projectIdentifier)
                .orElseThrow(() -> new ProjectNotFoundException(projectIdentifier));
        projectRepository.delete(project);
    }

}
