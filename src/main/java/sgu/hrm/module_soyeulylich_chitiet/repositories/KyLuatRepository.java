package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sgu.hrm.module_soyeulylich_chitiet.models.KyLuat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface KyLuatRepository extends JpaRepository<KyLuat, Integer> {
    @Query(value = "SELECT c FROM KyLuat c WHERE c.soYeuLyLich.id = ?1")
    List<KyLuat> listKyLuat(UUID id);

    //EMPLOYEE
    //READ ALL
    @Query(value = "SELECT c FROM KyLuat c WHERE c.soYeuLyLich.id = ?1")
    List<KyLuat> getAllBySyll(UUID uuid);

    //READ SPECIFIC
    @Query(value = "SELECT c FROM KyLuat c WHERE c.id = ?1 AND c.soYeuLyLich.id = ?2")
    Optional<KyLuat> findByIdAndSyll(int id, UUID uuid);

    //UPDATE
    @Transactional
    @Modifying
    @Query(value = "UPDATE KyLuat c SET c.batDau = ?1, c.ketThuc = ?2, c.hinhThuc =?3, c.hanhViViPhamChinh =?4, c.coQuanQuyetDinh =?5 WHERE c.id = ?6 AND c.soYeuLyLich.id = ?7")
    void updateByIdAndSyll(LocalDateTime l1, LocalDateTime l2, String l3, String l4, String l5, int id, UUID uuid);
}
