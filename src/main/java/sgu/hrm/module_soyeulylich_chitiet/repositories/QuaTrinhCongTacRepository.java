package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.QuaTrinhCongTac;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuaTrinhCongTacRepository extends JpaRepository<QuaTrinhCongTac, Integer> {
    @Query(value = "SELECT c FROM QuaTrinhCongTac c WHERE c.soYeuLyLich.id = ?1")
    List<QuaTrinhCongTac> listQuaTrinhCongTac(UUID id);
    @Query(value = "SELECT c FROM QuaTrinhCongTac c WHERE c.soYeuLyLich.id = ?1")
    List<QuaTrinhCongTac> getAllBySyll(UUID id);
    @Query(value = "SELECT c FROM QuaTrinhCongTac c WHERE c.id = ?1 AND c.soYeuLyLich.id = ?2")
    Optional<QuaTrinhCongTac> findByIdAndSyll(int id, UUID id1);
}
