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

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KinhNghiem extends SucKhoe {
    @Column(name = "so_truong_cong_tac", columnDefinition = "varchar(150) default 'Không'")
    String soTruongCongTac;

    @Column(name = "cong_viec_lam_lau_nhat", columnDefinition = "varchar(150) default ''")
    String congViecLamLauNhat;
}
