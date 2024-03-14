package sgu.hrm.module_soyeulylich.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgu.hrm.module_soyeulylich.models.NghiaVuQuanSu;

import java.util.UUID;

@Repository
public interface NghiaVuQuanSuRepository extends JpaRepository<NghiaVuQuanSu, UUID> {
}
