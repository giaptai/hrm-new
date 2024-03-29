package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import sgu.hrm.module_cauhinh.models.MoiQuanHe;

import java.util.Optional;

@Repository
public interface MoiQuanHeRepository extends JpaRepository<MoiQuanHe, Integer> {
    @Query
    Optional<MoiQuanHe> findByName(String name);
}
