package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_cauhinh.models.ChucVu;

import java.util.Optional;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, Integer> {
    @Query
    Optional<ChucVu> findByName(String name);
}
