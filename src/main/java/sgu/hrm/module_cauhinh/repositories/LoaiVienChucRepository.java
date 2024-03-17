package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_cauhinh.models.LoaiVienChuc;
@Repository
public interface LoaiVienChucRepository extends JpaRepository<LoaiVienChuc, Integer> {
    @Query
    LoaiVienChuc findByLoai(String loai);
}
