package sgu.hrm.module_heso_luong_ngach.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_heso_luong_ngach.models.LoaiCongChuc;
@Repository
public interface LoaiCongChucRepository extends JpaRepository<LoaiCongChuc, String> {
}
