package sgu.hrm.module_soyeulylich.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgu.hrm.module_soyeulylich.models.HocVan;

import java.util.UUID;

@Repository
public interface HocVanRepository extends JpaRepository<HocVan, UUID> {
}
