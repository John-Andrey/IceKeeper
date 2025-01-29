package com.tweb.icekeeper.Repository;


import com.tweb.icekeeper.Model.GlacierLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface GlacierLikeRepository extends JpaRepository<GlacierLike, Long> {
    Optional<GlacierLike> findByUserIdAndGlacierId(Long userId, Long glacierId);

    public long countByGlacierId(Long glacierId);
}
