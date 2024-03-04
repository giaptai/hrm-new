package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;

import java.util.Optional;

@Repository
public interface TrinhDoChuyenMonRepository extends JpaRepository<TrinhDoChuyenMon, Integer> {
    @Query
    Optional<TrinhDoChuyenMon> findByName(String name);
}
