package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgu.hrm.module_cauhinh.models.NhomVienChuc;
@Repository
public interface NhomVienChucRepository extends JpaRepository<NhomVienChuc, Integer> {
    @Query
    NhomVienChuc findByName(String name);
}
