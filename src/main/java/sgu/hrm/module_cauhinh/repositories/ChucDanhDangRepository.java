package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_cauhinh.models.ChucDanhDang;

import java.util.Optional;

@Repository
public interface ChucDanhDangRepository extends JpaRepository<ChucDanhDang, Integer> {
    @Query
    Optional<ChucDanhDang> findByName(String name);
}
