package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_cauhinh.models.ViTriViecLam;

import java.util.Optional;

@Repository
public interface ViTriViecLamRepository extends JpaRepository<ViTriViecLam, Integer> {
    @Query
    Optional<ViTriViecLam> findByName(String name);
}
