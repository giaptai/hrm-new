//package sgu.hrm.module_soyeulylich.models;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
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
//import sgu.hrm.module_utilities.enums.GioiTinh;
//import sgu.hrm.module_utilities.models.ChucDanhDang;
//import sgu.hrm.module_utilities.models.DanToc;
//import sgu.hrm.module_utilities.models.DanhHieuNhaNuoc;
//import sgu.hrm.module_utilities.models.DoiTuongChinhSach;
//import sgu.hrm.module_utilities.models.HocHam;
//import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
//import sgu.hrm.module_utilities.models.TonGiao;
//import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;
//import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;
//import sgu.hrm.module_utilities.models.response.DateTimeObject;
//
//import java.time.LocalDateTime;
//
////@Entity
////@Table(name = "thong_tin_co_ban")
//@Getter
//@Setter
//@SuperBuilder
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class ThongTinCoBan extends DateTimeObject {
//    @Id
//    @Column(name = "so_yeu_ly_lich_id")
//    int id;
//
//    @Column(name = "ho_va_ten", columnDefinition = "varchar(50) default ''")
//    String hoVaTen;
//
//    @Column(name = "gioi_tinh")
//    @Enumerated(EnumType.ORDINAL)
//    GioiTinh gioiTinh;
//
//    @Column(name = "cac_ten_goi_khac", columnDefinition = "varchar(50) default ''")
//    String cacTenGoiKhac;
//
//    @Column(name = "sinh_ngay", columnDefinition = "datetime")
//    LocalDateTime sinhNgay;
//
//    @Column(name = "noi_sinh", columnDefinition = "varchar(100) default ''")
//    String noiSinh;
//
//    @Column(name = "que_quan", columnDefinition = "varchar(100) default ''")
//    String queQuan;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "dan_toc_fk"), name = "dan_toc", referencedColumnName = "id", columnDefinition = "int")
//    DanToc danToc;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "ton_giao_fk"), name = "ton_giao", referencedColumnName = "id", columnDefinition = "int")
//    TonGiao tonGiao;
//
//    @Column(name = "so_cccd", columnDefinition = "varchar(12) default ''")
//    String soCCCD;
//
//    @Column(name = "ngay_cap_cccd", columnDefinition = "datetime")
//    LocalDateTime ngayCapCCCD;
//
//    @Column(name = "so_dien_thoai", columnDefinition = "varchar(12) default ''")
//    String soDienThoai;
//
//    @Column(name = "so_bhxh", columnDefinition = "varchar(10) default ''")
//    String soBHXH;
//
//    @Column(name = "so_bhyt", columnDefinition = "varchar(15) default ''")
//    String soBHYT;
//
//    @Column(name = "noi_o_hien_nay", columnDefinition = "varchar(100) default ''")
//    String noiOHienNay;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "thanh_phan_gia_dinh_fk"), name = "thanh_phan_gia_dinh", referencedColumnName = "id", columnDefinition = "INTEGER")
//    ThanhPhanGiaDinh thanhPhanGiaDinh;
//
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "so_yeu_ly_lich_id")
//    SoYeuLyLich soYeuLyLich;
//}
