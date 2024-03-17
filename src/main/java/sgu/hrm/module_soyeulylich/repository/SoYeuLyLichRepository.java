package sgu.hrm.module_soyeulylich.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SoYeuLyLichRepository extends JpaRepository<SoYeuLyLich, UUID> {
    @Query
    Optional<SoYeuLyLich> findFirstBySoCCCD(String soCCCD);

    //using JPQL
    @Query(value = "UPDATE SoYeuLyLich syll SET syll.trangThai = ?1 WHERE syll.id = ?2")
    abstract SoYeuLyLich updateTrangThaiSoYeuLyLich(boolean check, UUID id);

//    @Query(value = "UPDATE SoYeuLyLich syll SET syll.coQuanToChucDonViTuyenDung = ?1 WHERE syll.id = ?2")
//    abstract SoYeuLyLich upadtecoQuanToChucDonVi(CoQuanToChucDonVi co, UUID id);
}
