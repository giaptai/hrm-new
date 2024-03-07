package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sgu.hrm.module_soyeulylich_chitiet.models.KhenThuong;
import sgu.hrm.module_utilities.models.HinhThucKhenThuong;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface KhenThuongRepository extends JpaRepository<KhenThuong, Integer> {
    @Query(value = "SELECT c FROM KhenThuong c WHERE c.soYeuLyLich.id = ?1")
    List<KhenThuong> listKhenThuong(UUID id);

    //EMPLOYEE
    //READ ALL
    @Query(value = "SELECT c FROM KhenThuong c WHERE c.soYeuLyLich.id = ?1")
    List<KhenThuong> getAllBySyll(UUID uuid);

    //READ SPECIFIC
    @Query(value = "SELECT c FROM KhenThuong c WHERE c.id = ?1 AND c.soYeuLyLich.id = ?2")
    Optional<KhenThuong> findByIdAndSyll(int id, UUID uuid);

    //UPDATE
    @Transactional
    @Modifying
    @Query(value = "UPDATE KhenThuong c SET c.nam = ?1, c.xepLoaiChuyenMon = ?2, c.xepLoaiThiDua =?3, c.hinhThucKhenThuong =?4, c.lyDo = ?5 WHERE c.id = ?6 AND c.soYeuLyLich.id = ?7")
    void updateByIdAndSyll(LocalDateTime nam, String l2, String l3, HinhThucKhenThuong l4, String l5, int id, UUID uuid);
}
