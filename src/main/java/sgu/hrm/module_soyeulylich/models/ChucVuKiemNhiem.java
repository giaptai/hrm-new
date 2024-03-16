//package sgu.hrm.module_soyeulylich.models;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.ForeignKey;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.MappedSuperclass;
//import jakarta.persistence.MapsId;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.experimental.FieldDefaults;
//import lombok.experimental.SuperBuilder;
//import sgu.hrm.module_utilities.models.ChucVu;
//
//import java.time.LocalDateTime;
//
////@Entity
////@Table(name = "chuc_vu_kiem_nhiem")
//@Getter
//@Setter
//@SuperBuilder
//@NoArgsConstructor
//@AllArgsConstructor
//@MappedSuperclass
//@EqualsAndHashCode(callSuper = false)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class ChucVuKiemNhiem {
////    @Id
////    @Column(name = "so_yeu_ly_lich_id")
////    int id;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "chuc_vu_fk"), name = "chuc_vu_kiemnhiem", referencedColumnName = "id", columnDefinition = "integer")
//    ChucVu chucVu;
//
//    @Column(name = "ngay_bo_nhiem", columnDefinition = "datetime")
//    LocalDateTime ngayBoNhiem;
//
//    @Column(name = "ngay_bo_nhiem_lai", columnDefinition = "datetime")
//    LocalDateTime ngayBoNhiemLai;
//
////    @OneToOne
////    @MapsId
////    @JoinColumn(name = "so_yeu_ly_lich_id")
////    SoYeuLyLich soYeuLyLich;
//}
