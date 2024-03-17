package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_cauhinh.models.CapBacLoaiQuanHamQuanDoi;

import java.util.Optional;

@Repository
public interface CapBacLoaiQuanHamQuanDoiRepository extends JpaRepository<CapBacLoaiQuanHamQuanDoi, Integer> {
    @Query
    Optional<CapBacLoaiQuanHamQuanDoi> findByName(String name);
}
