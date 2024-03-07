package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.KyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.PhuCapKhac;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PhuCapKhacRepository extends JpaRepository<PhuCapKhac, Integer> {
    @Query(value = "SELECT c FROM PhuCapKhac c WHERE c.soYeuLyLich.id = ?1")
    List<PhuCapKhac> listPhuCapKhac(UUID id);

    @Query(value = "SELECT c FROM PhuCapKhac c WHERE c.soYeuLyLich.id = ?1")
    List<PhuCapKhac> getAllBySyll(UUID id);

    @Query(value = "SELECT c FROM PhuCapKhac c WHERE c.id = ?1 AND c.soYeuLyLich.id = ?2")
    Optional<PhuCapKhac> findByIdAndSyll(int id, UUID id1);
}
