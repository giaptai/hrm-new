package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sgu.hrm.module_utilities.models.LoaiPhuCap;

import java.util.Optional;

@Repository
public interface LoaiPhuCapRepository extends JpaRepository<LoaiPhuCap, Integer> {
    @Query
    Optional<LoaiPhuCap> findByName(String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE LoaiPhuCap b SET b.name=?2 WHERE b.id=?1")
    int update(int id, String name);
}
