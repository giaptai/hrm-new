package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgu.hrm.module_cauhinh.models.HocHam;

import java.util.Optional;

@Repository
public interface HocHamRepository extends JpaRepository<HocHam, Integer> {
    @Query
    Optional<HocHam> findByName(String name);
}
