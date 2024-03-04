package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_utilities.models.DoiTuongChinhSach;

import java.util.Optional;

@Repository
public interface DoiTuongChinhSachRepository extends JpaRepository<DoiTuongChinhSach, Integer> {
    @Query
    Optional<DoiTuongChinhSach> findByName(String name);
}
