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
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NgayKetNapDang extends KinhNghiem{
    @Column(name = "ngay_vao_dang_cong_san_viet_nam", columnDefinition = "datetime")
    LocalDateTime ngayVaoDangCongSanVietNam;

    @Column(name = "ngay_chinh_thuc", columnDefinition = "datetime")
    LocalDateTime ngayChinhThuc;
}
