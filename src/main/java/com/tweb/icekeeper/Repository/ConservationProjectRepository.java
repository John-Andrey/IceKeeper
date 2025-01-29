package com.tweb.icekeeper.Repository;

import com.tweb.icekeeper.Model.ConservationProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConservationProjectRepository extends JpaRepository<ConservationProject, Long> {

    // Trova tutti i progetti di conservazione per nome
    List<ConservationProject> findByTitle(String title);
}
