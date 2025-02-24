package com.tweb.icekeeper.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tweb.icekeeper.Model.UserAction;

@Repository
public interface UserActionRepository extends JpaRepository<UserAction, Long> {
    // You can define custom query methods here if needed
}