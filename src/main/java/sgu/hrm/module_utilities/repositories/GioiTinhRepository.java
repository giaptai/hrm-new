package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_utilities.models.GioiTinh;

import java.util.Optional;

@Repository
public interface GioiTinhRepository extends JpaRepository<GioiTinh, Integer> {
    @Query
    Optional<GioiTinh> findByName(String name);
}
