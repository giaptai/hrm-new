package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sgu.hrm.module_soyeulylich_chitiet.models.LuongBanThan;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LuongBanThanRepository extends JpaRepository<LuongBanThan, Integer> {
    @Query(value = "SELECT c FROM LuongBanThan c WHERE c.soYeuLyLich.id = ?1")
    List<LuongBanThan> listLuongBanThan(UUID id);

    @Query(value = "SELECT c FROM LuongBanThan c WHERE c.soYeuLyLich.id = ?1")
    List<LuongBanThan> getAllBySyll(UUID id);

    @Query(value = "SELECT c FROM LuongBanThan c WHERE c.id = ?1 AND c.soYeuLyLich.id = ?2")
    Optional<LuongBanThan> findByIdAndSyll(int id, UUID id1);

    @Transactional
    @Modifying
    @Query(value = "UPDATE LuongBanThan c SET c.batDau = ?1, c.ketThuc = ?2, c.maSo =?3, c.bacLuong =?4, c.heSoLuong =?5, c.tienLuongTheoViTri =?6 WHERE c.id = ?7 AND c.soYeuLyLich.id = ?8")
    void updateByIdAndSyll(LocalDateTime batDau, LocalDateTime ketThuc, String maSo, String bacLuong, float heSoLuong, float tienLuongTheoViTri, int id, UUID id1);
}
