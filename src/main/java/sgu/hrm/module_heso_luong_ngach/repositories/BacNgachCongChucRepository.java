package sgu.hrm.module_heso_luong_ngach.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_heso_luong_ngach.models.BacNgachCongChuc;

@Repository
public interface BacNgachCongChucRepository extends JpaRepository<BacNgachCongChuc, Integer> {
    @Query
    BacNgachCongChuc findByName(String name);
}
