package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_cauhinh.models.TrinhDoGiaoDucPhoThong;

import java.util.Optional;

@Repository
public interface TrinhDoGiaoDucPhoThongRepository extends JpaRepository<TrinhDoGiaoDucPhoThong, Integer> {
    @Query
    Optional<TrinhDoGiaoDucPhoThong> findByName(String name);
}
