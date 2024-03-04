package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sgu.hrm.module_soyeulylich_chitiet.models.LamViecONuocNgoai;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LamViecONuocNgoaiRepository extends JpaRepository<LamViecONuocNgoai, Integer> {
    @Query(value = "SELECT c FROM LamViecONuocNgoai c WHERE c.soYeuLyLich.id = ?1")
    List<LamViecONuocNgoai> listLamViecONuocNgoai(UUID id);

    @Query(value = "SELECT c FROM LamViecONuocNgoai c WHERE c.soYeuLyLich.id = ?1")
    List<LamViecONuocNgoai> getAllBySyll(UUID id);

    @Query(value = "SELECT c FROM LamViecONuocNgoai c WHERE c.id = ?1 AND c.soYeuLyLich.id = ?2")
    Optional<LamViecONuocNgoai> findByIdAndSyll(int id, UUID id1);

    @Transactional
    @Modifying
    @Query(value = "UPDATE LamViecONuocNgoai c SET c.batDau = ?1, c.ketThuc = ?2, c.toChucDiaChiCongViec =?3 WHERE c.id = ?4 AND c.soYeuLyLich.id = ?5")
    void updateByIdAndSyll(LocalDateTime batDau, LocalDateTime ketThuc, String toChucDiaChiCongViec, int id, UUID id1);
}
