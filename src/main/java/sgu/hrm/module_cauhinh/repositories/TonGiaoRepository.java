package sgu.hrm.module_cauhinh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_cauhinh.models.TonGiao;

import java.util.Optional;

@Repository
public interface TonGiaoRepository extends JpaRepository<TonGiao, Integer> {
    @Query
    Optional<TonGiao> findByName(String name);
}
