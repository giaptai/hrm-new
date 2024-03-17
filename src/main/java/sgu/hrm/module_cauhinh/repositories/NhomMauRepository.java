package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgu.hrm.module_cauhinh.models.NhomMau;

import java.util.Optional;


@Repository
public interface NhomMauRepository extends JpaRepository<NhomMau, Integer> {
    @Query
    Optional<NhomMau> findByName(String name);
}
