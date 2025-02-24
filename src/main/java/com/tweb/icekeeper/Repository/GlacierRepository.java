package com.tweb.icekeeper.Repository;

import com.tweb.icekeeper.Model.Glacier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GlacierRepository extends JpaRepository<Glacier, Long> {

    // Trova tutti i ghiacciai per nome
    List<Glacier> findByName(String name);

    // Trova tutti i ghiacciai in base alla posizione
    List<Glacier> findByLocation(String location);

    Optional<Glacier> getGlacierById(long id);

    List<Glacier> findByCondition(String condition);
}
