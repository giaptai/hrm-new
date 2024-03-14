//package sgu.hrm.module_soyeulylich.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
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
//import sgu.hrm.module_taikhoan.models.TaiKhoan;
//import sgu.hrm.module_utilities.enums.PheDuyet;
//
//import java.util.UUID;
//
///**
// * xung đột khi khai báo biến
// * khi dùng columnDefinition trong annotation
// **/
//
//@Entity
//@Table(name = "so_yeu_ly_lich")
//@Getter
//@Setter
//@SuperBuilder
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class SoYeuLyLich2 extends HoSoCongViec {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "id", columnDefinition = "BINARY(16)")
//    UUID id;
//
//    @Column(name = "phe_duyet")
//    @Enumerated(EnumType.ORDINAL)
//    PheDuyet pheDuyet;
//
//    @OneToOne(mappedBy = "soYeuLyLich")
//    @JsonIgnore
//    TaiKhoan taiKhoan;
//}
