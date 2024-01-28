package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.models.TrinhDoChuyenMon;
import sgu.hrm.models.TrinhDoGiaoDucPhoThong;

@Repository
public interface TrinhDoGiaoDucPhoThongRepository extends JpaRepository<TrinhDoGiaoDucPhoThong, Integer> {
    @Query
    TrinhDoGiaoDucPhoThong findByName(String name);
}
