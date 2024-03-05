package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.NgoaiNgu;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NgoaiNguRepository extends JpaRepository<NgoaiNgu, Integer> {
    @Query(value = "SELECT c FROM NgoaiNgu c WHERE c.soYeuLyLich.id = ?1")
    List<NgoaiNgu> listNgoaiNgu(UUID id);

    @Query(value = "SELECT c FROM NgoaiNgu c WHERE c.soYeuLyLich.id = ?1")
    List<NgoaiNgu> getAllBySyll(UUID id);
    @Query(value = "SELECT c FROM NgoaiNgu c WHERE c.id = ?1 AND c.soYeuLyLich.id = ?2")
    Optional<NgoaiNgu> findByIdAndSyll(int id, UUID id1);
}
