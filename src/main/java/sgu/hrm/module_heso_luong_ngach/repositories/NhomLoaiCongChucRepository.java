package sgu.hrm.module_heso_luong_ngach.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_heso_luong_ngach.models.NhomLoaiCongChuc;
@Repository
public interface NhomLoaiCongChucRepository extends JpaRepository<NhomLoaiCongChuc, Integer> {
}
