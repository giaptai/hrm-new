package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_cauhinh.models.HeSoLuongVienChuc;

@Repository
public interface HeSoLuongVienChucRepository extends JpaRepository<HeSoLuongVienChuc, Integer> {
}
