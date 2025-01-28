package com.tweb.icekeeper.Service;

import com.tweb.icekeeper.Model.ConservationProject;
import com.tweb.icekeeper.Repository.ConservationProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConservationProjectService {
    @Autowired
    private ConservationProjectRepository conservationProjectRepository;

    // Metodo per ottenere tutti i progetti di conservazione
    public List<ConservationProject> getAllConservationProjects() {
        return conservationProjectRepository.findAll();
    }

    // Metodo per ottenere un progetto di conservazione per ID
    public ConservationProject getConservationProjectById(Long id) {
        return conservationProjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

    }

    // Metodo per creare un nuovo progetto di conservazione
    public ConservationProject createConservationProject(ConservationProject conservationProject) {
        return conservationProjectRepository.save(conservationProject);
    }

    // Metodo per aggiornare un progetto di conservazione
    public ConservationProject updateConservationProject(Long id, ConservationProject projectDetails) {
        ConservationProject project = getConservationProjectById(id);
        project.setTitle(projectDetails.getTitle());
        project.setDescription(projectDetails.getDescription());
        project.setStartDate(projectDetails.getStartDate());
        project.setEndDate(projectDetails.getEndDate());
        project.setStatus(projectDetails.getStatus());
        project.setParticipants(projectDetails.getParticipants());
        return conservationProjectRepository.save(project);
    }
        // Metodo per eliminare un progetto di conservazione
    public void deleteConservationProject(Long id) {
        conservationProjectRepository.deleteById(id);
    }
}
