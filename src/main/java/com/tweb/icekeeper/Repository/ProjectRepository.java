package com.tweb.icekeeper.Repository;

import com.tweb.icekeeper.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByUsersId(Long userId);
}
