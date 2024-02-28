//package sgu.hrm.module_soyeulylich.models;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.ForeignKey;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//import jakarta.persistence.Table;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.experimental.FieldDefaults;
//
//import lombok.experimental.SuperBuilder;
//import sgu.hrm.module_congchuc_vienchuc.models.NgachCongChuc;
//import sgu.hrm.module_congchuc_vienchuc.models.NgachVienChuc;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@SuperBuilder
//@NoArgsConstructor
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class NgachNgheNghiep {
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "ngach_cong_chuc_fk"), name = "ngach_cong_chuc", referencedColumnName = "id", columnDefinition = "varchar(6)")
//    NgachCongChuc ngachCongChuc;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "ngach_vien_chuc_fk"), name = "ngach_vien_chuc", referencedColumnName = "id", columnDefinition = "varchar(10)")
//    NgachVienChuc ngachVienChuc;
//
//    @Column(name = "ngay_bo_nhiem_ngach_nghe_nghiep", columnDefinition = "datetime")
//    LocalDateTime ngayBoNhiemNgachNgheNghiep;
//
//    @Column(name = "ngay_huong_luong_ngach_nghe_nghiep", columnDefinition = "datetime")
//    LocalDateTime ngayHuongLuongNgachNgheNghiep;
//
//    @Column(name = "phan_tram_huong_luong_ngach_nghe_nghiep", columnDefinition = "double")
//    double phanTramHuongLuongNgachNgheNghiep;
//
//    @Column(name = "phu_cap_tham_nien_vuot_khung_ngach_nghe_nghiep", columnDefinition = "float")
//    float phuCapThamNienVuotKhungNgachNgheNghiep;
//
//    @Column(name = "ngay_huong_PCTNVK_ngach_nghe_nghiep", columnDefinition = "datetime")
//    LocalDateTime ngayHuongPCTNVKNgachNgheNghiep;
//}
