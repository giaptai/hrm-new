package sgu.hrm.module_soyeulylich_chitiet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import sgu.hrm.models.DateTimeObject;


@Entity
@Table(name = "loai_so_yeu_ly_lich_chitiet")
@Getter
//@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoaiSoYeuLyLichChiTiet extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(length = 65, unique = true)
    String name;

    public LoaiSoYeuLyLichChiTiet(String name) {
        super();
        this.name = name;
    }

//    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
//    List<BanThanCoLamViecChoCheDoCu> banThanCoLamViecChoCheDoCus;
//
//    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
//    List<KhenThuong> khenThuongs;
//
//    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
//    List<KienThucAnNinhQuocPhong> kienThucAnNinhQuocPhongs;
//
//    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
//    List<KyLuat> kyLuats;
//
//    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
//    List<LamViecONuocNgoai> lamViecONuocNgoais;
//
//    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
//    List<LuongBanThan> luongBanThans;
//
//    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
//    List<LyLuanChinhTri> lyLuanChinhTris;
//
//    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
//    List<NghiepVuChuyenNganh> nghiepVuChuyenNganhs;
//
//    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
//    List<NgoaiNgu> ngoaiNgus;
//
//    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
//    List<PhuCapKhac> phuCapKhacs;
//
//    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
//    List<QuanHeGiaDinh> quanHeGiaDinhs;
//
//    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
//    List<QuaTrinhCongTac> quaTrinhCongTacs;
//
//    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
//    List<TinHoc> tinHocs;
}