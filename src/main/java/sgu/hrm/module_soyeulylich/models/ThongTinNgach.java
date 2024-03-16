//package sgu.hrm.module_soyeulylich.models;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.ForeignKey;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.MappedSuperclass;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.experimental.FieldDefaults;
//import lombok.experimental.SuperBuilder;
//import sgu.hrm.module_heso_luong_ngach.models.NgachCongChuc;
//import sgu.hrm.module_heso_luong_ngach.models.NgachVienChuc;
//import sgu.hrm.module_utilities.enums.TinhTrangSucKhoe;
//import sgu.hrm.module_utilities.models.NhomMau;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@SuperBuilder
//@NoArgsConstructor
//@AllArgsConstructor
//@MappedSuperclass
//@EqualsAndHashCode(callSuper = false)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class ThongTinNgach{
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "ngach_cong_chuc_fk"), name = "ngach_cong_chuc", referencedColumnName = "id", columnDefinition = "varchar(6)")
//    NgachCongChuc ngachCongChuc;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "ngach_vien_chuc_fk"), name = "ngach_vien_chuc", referencedColumnName = "id", columnDefinition = "varchar(10)")
//    NgachVienChuc ngachVienChuc;
//
//    @Column(name = "ngay_bo_nhiem_ngach", columnDefinition = "datetime")
//    LocalDateTime ngayBoNhiemNgach;
//
//    @Column(name = "ngay_huong_luong_ngach", columnDefinition = "datetime")
//    LocalDateTime ngayHuongLuongNgach;
//
//    @Column(name = "phan_tram_huong_luong_ngach", columnDefinition = "float default 1.0")
//    float phanTramHuongLuongNgach;
//
//    @Column(name = "phu_cap_tham_nien_vuot_khung_ngach", columnDefinition = "double default 0.0")
//    double phuCapThamNienVuotKhungNgach;
//
//    @Column(name = "ngay_huong_PCTNVK_ngach", columnDefinition = "datetime")
//    LocalDateTime ngayHuongPCTNVKNgach;
//}
