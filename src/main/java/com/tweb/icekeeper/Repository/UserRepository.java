package com.tweb.icekeeper.Repository;

import com.tweb.icekeeper.Model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUsername(String username);
    // List<User> findAll(); // non per forza , già integrata all'interno di  JpaRepository come anche il metodo save()
    Optional<User> findByEmail(String email, String password);
}
