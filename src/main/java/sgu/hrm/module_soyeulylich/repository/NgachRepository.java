package sgu.hrm.module_soyeulylich.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgu.hrm.module_soyeulylich.models.NgachNhanVien;

import java.util.UUID;

@Repository
public interface NgachRepository extends JpaRepository<NgachNhanVien, UUID> {
}
