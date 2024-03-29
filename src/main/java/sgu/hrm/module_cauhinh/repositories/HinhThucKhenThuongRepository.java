package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_cauhinh.models.HinhThucKhenThuong;

import java.util.Optional;

@Repository
public interface HinhThucKhenThuongRepository extends JpaRepository<HinhThucKhenThuong, Integer> {
    @Query
    Optional<HinhThucKhenThuong> findByName(String name);
}
