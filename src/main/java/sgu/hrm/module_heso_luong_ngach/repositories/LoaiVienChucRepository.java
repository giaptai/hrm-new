package sgu.hrm.module_heso_luong_ngach.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_heso_luong_ngach.models.LoaiVienChuc;
@Repository
public interface LoaiVienChucRepository extends JpaRepository<LoaiVienChuc, Integer> {
}
