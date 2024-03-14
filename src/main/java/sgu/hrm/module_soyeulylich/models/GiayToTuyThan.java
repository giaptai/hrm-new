package sgu.hrm.module_soyeulylich.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GiayToTuyThan{
    @Column(name = "so_cccd", columnDefinition = "varchar(12) default ''")
    String soCCCD;

    @Column(name = "ngay_cap_cccd", columnDefinition = "datetime")
    LocalDateTime ngayCapCCCD;

    @Column(name = "so_dien_thoai", columnDefinition = "varchar(12) default ''")
    String soDienThoai;
}
