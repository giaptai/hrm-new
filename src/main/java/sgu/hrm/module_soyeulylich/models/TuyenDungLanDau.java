//package sgu.hrm.module_soyeulylich.models;
//
//import jakarta.persistence.Column;
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
////import sgu.hrm.module_utilities.models.DonVi;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@SuperBuilder
//@NoArgsConstructor
//@AllArgsConstructor
//@MappedSuperclass
//@EqualsAndHashCode(callSuper = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class TuyenDungLanDau extends ThongTinNgach{
//    @Column(name = "ngay_duoc_tuyen_dung_lan_dau", columnDefinition = "datetime")
//    LocalDateTime ngayDuocTuyenDungLanDau;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "coquan_tochuc_donvi_fk"), name = "coquan_tochuc_donvi", columnDefinition = "INTEGER")
//    DonVi coQuanToChucDonViTuyenDung;
//}
