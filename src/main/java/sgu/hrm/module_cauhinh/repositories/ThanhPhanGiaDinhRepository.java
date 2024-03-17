package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_cauhinh.models.ThanhPhanGiaDinh;

import java.util.Optional;

@Repository
public interface ThanhPhanGiaDinhRepository extends JpaRepository<ThanhPhanGiaDinh, Integer> {
    @Query
    Optional<ThanhPhanGiaDinh> findByName(String name);
}
