package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_cauhinh.models.LoaiCongChuc;
@Repository
public interface LoaiCongChucRepository extends JpaRepository<LoaiCongChuc, Integer> {
    @Query
    LoaiCongChuc findByLoai(String loai);
}
