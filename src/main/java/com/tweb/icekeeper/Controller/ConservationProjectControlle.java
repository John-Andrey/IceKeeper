package com.tweb.icekeeper.Controller;

import com.tweb.icekeeper.Model.ConservationProject;
import com.tweb.icekeeper.Service.ConservationProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ConservationProjectControlle {

    @Autowired
    private ConservationProjectService conservationProjectService;

    @GetMapping
    public List<ConservationProject> getAllConservationProjects() {
        return conservationProjectService.getAllConservationProjects();
    }

    @GetMapping("/{id}")
    public ConservationProject getConservationProjectById(@PathVariable Long id) {
        return conservationProjectService.getConservationProjectById(id);
    }

    @PostMapping
    public ConservationProject createConservationProject(@RequestBody ConservationProject conservationProject) {
        return conservationProjectService.createConservationProject(conservationProject);

    }

    @PutMapping("/{id}")
    public ConservationProject updateConservationProject(@PathVariable Long id, @RequestBody ConservationProject projectDetails) {
        return conservationProjectService.updateConservationProject(id, projectDetails);

    }

    @DeleteMapping("/{id}")
    public void deleteConservationProject(@PathVariable Long id) {
        conservationProjectService.deleteConservationProject(id);
    }
}
