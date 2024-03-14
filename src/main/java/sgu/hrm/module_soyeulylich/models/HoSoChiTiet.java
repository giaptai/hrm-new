package sgu.hrm.module_soyeulylich.models;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.KhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.KienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.KyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.LamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.LuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.LyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.NghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.NgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.PhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.QuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.QuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.TinHoc;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoSoChiTiet {
     //liên kết 2 chiều
    // tai sao list thi lay ok ma set thi méo lấy
    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    Set<LyLuanChinhTri> lyLuanChinhTris;

    //liên kết 2 chiều
    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    Set<NghiepVuChuyenNganh> nghiepVuChuyenNganhs;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    Set<KienThucAnNinhQuocPhong> kienThucAnNinhQuocPhongs;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    Set<TinHoc> tinHocs;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    Set<NgoaiNgu> ngoaiNgus;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    Set<QuaTrinhCongTac> quaTrinhCongTacs;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    Set<BanThanCoLamViecChoCheDoCu> banThanCoLamViecChoCheDoCus;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    Set<LamViecONuocNgoai> lamViecONuocNgoais;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    Set<KhenThuong> khenThuongs;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    Set<KyLuat> kyLuats;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    Set<QuanHeGiaDinh> quanHeGiaDinhs;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    Set<LuongBanThan> luongBanThans;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    Set<PhuCapKhac> phuCapKhacs;
}
