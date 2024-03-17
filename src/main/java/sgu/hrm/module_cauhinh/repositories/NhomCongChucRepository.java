package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgu.hrm.module_cauhinh.models.NhomCongChuc;
@Repository
public interface NhomCongChucRepository extends JpaRepository<NhomCongChuc, Integer> {
    @Query
    NhomCongChuc findByName(String name);
}
