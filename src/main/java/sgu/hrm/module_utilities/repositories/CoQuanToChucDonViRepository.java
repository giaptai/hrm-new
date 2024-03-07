package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_utilities.models.CoQuanToChucDonVi;

import java.util.Optional;

@Repository
public interface CoQuanToChucDonViRepository extends JpaRepository<CoQuanToChucDonVi, Integer> {
    @Query
    Optional<CoQuanToChucDonVi> findByName(String name);
}
