package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface BanThanCoLamViecChoCheDoCuRepository extends JpaRepository<BanThanCoLamViecChoCheDoCu, Integer> {
    //JPQL
    @Query(value = "SELECT c FROM BanThanCoLamViecChoCheDoCu c WHERE c.soYeuLyLich.id = ?1")
    List<BanThanCoLamViecChoCheDoCu> listBanThanCoLamViecChoCheDoCu(UUID id);

    //EMPLOYEE
    //READ ALL
    @Query(value = "SELECT c FROM BanThanCoLamViecChoCheDoCu c WHERE c.soYeuLyLich.id = ?1")
    List<BanThanCoLamViecChoCheDoCu> getAllBySyll(UUID uuid);

    //READ SPECIFIC
    @Query(value = "SELECT c FROM BanThanCoLamViecChoCheDoCu c WHERE c.id = ?1 AND c.soYeuLyLich.id = ?2")
    BanThanCoLamViecChoCheDoCu findByIdAndSyll(int id, UUID uuid);

    //UPDATE
    @Transactional
    @Modifying
    @Query(value = "UPDATE BanThanCoLamViecChoCheDoCu c SET c.batDau = ?1, c.ketThuc = ?2, c.chucDanhDonViDiaDiem =?3 WHERE c.id = ?4 AND c.soYeuLyLich.id = ?5")
    void updateByIdAndSyll(LocalDateTime l1, LocalDateTime l2, String l3, int id, UUID uuid);
}
