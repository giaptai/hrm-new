package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;

@Repository
public interface ThanhPhanGiaDinhRepository extends JpaRepository<ThanhPhanGiaDinh, Integer> {
    @Query
    ThanhPhanGiaDinh findByName(String name);
}
