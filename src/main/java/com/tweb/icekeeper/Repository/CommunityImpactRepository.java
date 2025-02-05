package com.tweb.icekeeper.Repository;

import com.tweb.icekeeper.Model.CommunityImpact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CommunityImpactRepository extends JpaRepository<CommunityImpact, Long> {

    // Trova tutti gli impatti comunitari associati a un determinato progetto
    List<CommunityImpact> findByProjectId(Long projectId);
}
