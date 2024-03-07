package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.TinHoc;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TinHocRepository extends JpaRepository<TinHoc, Integer> {
    @Query(value = "SELECT c FROM TinHoc c WHERE c.soYeuLyLich.id = ?1")
    List<TinHoc> listTinHoc(UUID id);

    @Query(value = "SELECT c FROM TinHoc c WHERE c.soYeuLyLich.id = ?1")
    List<TinHoc> getAllBySyll(UUID id);

    @Query(value = "SELECT c FROM TinHoc c WHERE c.id = ?1 AND c.soYeuLyLich.id = ?2")
    Optional<TinHoc> findByIdAndSyll(int id, UUID id1);
}
