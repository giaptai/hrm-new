package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sgu.hrm.module_soyeulylich_chitiet.models.LyLuanChinhTri;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LyLuanChinhTriRepository extends JpaRepository<LyLuanChinhTri, Integer> {
//    @Query(nativeQuery = true, value = "")
//    List<LyLuanChinhTri> findAllByLoaiSoYeuLyLichChiTiet();

    @Query(value = "SELECT c FROM LyLuanChinhTri c WHERE c.soYeuLyLich.id = ?1")
    List<LyLuanChinhTri> listLyLuanChinhTri(UUID id);

    @Query(value = "SELECT c FROM LyLuanChinhTri c WHERE c.soYeuLyLich.id = ?1")
    List<LyLuanChinhTri> getAllBySyll(UUID id);

    @Query(value = "SELECT c FROM LyLuanChinhTri c WHERE c.id = ?1 AND c.soYeuLyLich.id = ?2")
    Optional<LyLuanChinhTri> findByIdAndSyll(int id, UUID id1);

    @Transactional
    @Modifying
    @Query(value = "UPDATE LyLuanChinhTri c SET c.batDau = ?1, c.ketThuc = ?2, c.tenCoSoDaoTao =?3, c.hinhThucDaoTao =?4, c.vanBangDuocCap =?5 WHERE c.id = ?6 AND c.soYeuLyLich.id = ?7")
    void updateByIdAndSyll(LocalDateTime batDau, LocalDateTime ketThuc, String tenCoSoDaoTao, String hinhThucDaoTao, String vanBangDuocCap, int id, UUID id1);
}
