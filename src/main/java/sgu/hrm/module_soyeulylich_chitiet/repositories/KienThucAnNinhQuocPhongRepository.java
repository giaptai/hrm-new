package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sgu.hrm.module_soyeulylich_chitiet.models.KienThucAnNinhQuocPhong;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface KienThucAnNinhQuocPhongRepository extends JpaRepository<KienThucAnNinhQuocPhong, Integer> {
    @Query(value = "SELECT c FROM KienThucAnNinhQuocPhong c WHERE c.soYeuLyLich.id = ?1")
    List<KienThucAnNinhQuocPhong> listKienThucAnNinhQuocPhong(UUID id);

    //EMPLOYEE
    //READ ALL
    @Query(value = "SELECT c FROM KienThucAnNinhQuocPhong c WHERE c.soYeuLyLich.id = ?1")
    List<KienThucAnNinhQuocPhong> getAllBySyll(UUID uuid);

    //READ SPECIFIC
    @Query(value = "SELECT c FROM KienThucAnNinhQuocPhong c WHERE c.id = ?1 AND c.soYeuLyLich.id = ?2")
    Optional<KienThucAnNinhQuocPhong> findByIdAndSyll(int id, UUID uuid);

    //UPDATE
    @Transactional
    @Modifying
    @Query(value = "UPDATE KienThucAnNinhQuocPhong c SET c.batDau = ?1, c.ketThuc = ?2, c.tenCoSoDaoTao =?3, c.chungChiDuocCap =?4 WHERE c.id = ?5 AND c.soYeuLyLich.id = ?6")
    void updateByIdAndSyll(LocalDateTime l1, LocalDateTime l2, String l3, String l4, int id, UUID uuid);
}
