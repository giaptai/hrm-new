package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_cauhinh.models.DanToc;

import java.util.Optional;

@Repository
public interface DanTocRepository extends JpaRepository<DanToc, Integer> {
    @Query
    public Optional<DanToc> findByName(String name);
}
