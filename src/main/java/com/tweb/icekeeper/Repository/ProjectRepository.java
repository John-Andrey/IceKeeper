package com.tweb.icekeeper.Repository;

import com.tweb.icekeeper.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Trova tutti i progetti per titolo
    List<Project> findByTitle(String name);
    List<Project> findByName(String name);
    List<Project> findByDescriptionContaining(String keyword);
    List<Project> findByUsersId(Long userId);
}
