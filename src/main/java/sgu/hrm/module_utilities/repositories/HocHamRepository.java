package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgu.hrm.module_utilities.models.HocHam;
@Repository
public interface HocHamRepository extends JpaRepository<HocHam, Integer> {
    @Query
    HocHam findByName(String name);
}
