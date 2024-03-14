package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgu.hrm.module_utilities.models.DanhHieuNhaNuoc;

import java.util.Optional;

@Repository
public interface DanhHieuNhaNuocPhongTangRepository extends JpaRepository<DanhHieuNhaNuoc, Integer> {
    @Query
    Optional<DanhHieuNhaNuoc> findByName(String name);
}
