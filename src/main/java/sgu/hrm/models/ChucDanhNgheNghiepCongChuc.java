//package sgu.hrm.models;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import lombok.experimental.FieldDefaults;
//
//@Entity
//@Table(name = "chuc_danh_nghe_nghiep_cong_chuc")
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class ChucDanhNgheNghiepCongChuc extends DateTimeObject {
//    @Id
//    @Column(columnDefinition = "varchar(6)")
//    String id;
//
//    @Column(length = 100, unique = true)
//    String name;
//
//    @ManyToOne
//    @JoinColumn(name = "bac_ngach_cong_chuc", referencedColumnName = "id", columnDefinition = "tinyint")
//    BacNgachCongChuc bacNgachCongChuc;
//}