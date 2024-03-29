package sgu.hrm.module_soyeulylich.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import sgu.hrm.module_cauhinh.models.ChucDanhDang;
import sgu.hrm.module_cauhinh.models.ChucVu;
import sgu.hrm.module_cauhinh.models.DanToc;
import sgu.hrm.module_cauhinh.models.TonGiao;
import sgu.hrm.module_cauhinh.dto.response.DateTimeObject;
import sgu.hrm.module_cauhinh.models.DoiTuongChinhSach;
import sgu.hrm.enums.GioiTinh;

import sgu.hrm.enums.PheDuyet;
import sgu.hrm.module_cauhinh.models.ThanhPhanGiaDinh;

import java.time.LocalDateTime;

import java.util.UUID;

/**
 * xung đột khi khai báo biến
 * khi dùng columnDefinition trong annotation
 **/

@Entity
@Table(name = "so_yeu_ly_lich")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoYeuLyLich extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "BINARY(16)")
    UUID id;

    @Column(name = "ho_va_ten", columnDefinition = "varchar(50) default ''")
    String hoVaTen;

    @Column(name = "gioi_tinh")
    @Enumerated(EnumType.ORDINAL)
    GioiTinh gioiTinh;

    @Column(name = "cac_ten_goi_khac", columnDefinition = "varchar(50) default ''")
    String cacTenGoiKhac;

    @Column(name = "sinh_ngay", columnDefinition = "datetime")
    LocalDateTime sinhNgay;

    @Column(name = "noi_sinh", columnDefinition = "varchar(100) default ''")
    String noiSinh;

    @Column(name = "que_quan", columnDefinition = "varchar(100) default ''")
    String queQuan;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "dan_toc_fk"), name = "dan_toc", referencedColumnName = "id", columnDefinition = "int")
    DanToc danToc;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "ton_giao_fk"), name = "ton_giao", referencedColumnName = "id", columnDefinition = "int")
    TonGiao tonGiao;

    @Column(name = "so_cccd", columnDefinition = "varchar(12) default ''")
    String soCCCD;

    @Column(name = "ngay_cap_cccd", columnDefinition = "datetime")
    LocalDateTime ngayCapCCCD;

    @Column(name = "so_dien_thoai", columnDefinition = "varchar(12) default ''")
    String soDienThoai;

    @Column(name = "so_bhxh", columnDefinition = "varchar(10) default ''")
    String soBHXH;

    @Column(name = "so_bhyt", columnDefinition = "varchar(15) default ''")
    String soBHYT;

    @Column(name = "noi_o_hien_nay", columnDefinition = "varchar(100) default ''")
    String noiOHienNay;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "thanh_phan_gia_dinh_fk"), name = "thanh_phan_gia_dinh", referencedColumnName = "id", columnDefinition = "INTEGER")
    ThanhPhanGiaDinh thanhPhanGiaDinh;

//    @Column(name = "nghe_nghiep_truoc_khi_duoc_tuyen_dung", columnDefinition = "varchar(100) default 'Không nghề nghiệp'")
//    String ngheNghiepTruocKhiTuyenDung;
//
//    @Column(name = "ngay_duoc_tuyen_dung_lan_dau", columnDefinition = "datetime")
//    LocalDateTime ngayDuocTuyenDungLanDau;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "coquan_tochuc_donvi_fk"), name = "coquan_tochuc_donvi", columnDefinition = "INTEGER")
//    CoQuanToChucDonVi coQuanToChucDonViTuyenDung;
//
//    @Column(name = "ngay_vao_co_quan_hien_dang_cong_tac", columnDefinition = "datetime")
//    LocalDateTime ngayVaoCoQuanHienDangCongTac;

//    @Column(name = "ngay_vao_dang_cong_san_viet_nam", columnDefinition = "datetime")
//    LocalDateTime ngayVaoDangCongSanVietNam;
//
//    @Column(name = "ngay_chinh_thuc", columnDefinition = "datetime")
//    LocalDateTime ngayChinhThuc;
//
//    @Column(name = "ngay_tham_gia_to_chuc_chinh_tri_xa_hoi_dau_tien", columnDefinition = "datetime")
//    LocalDateTime ngayThamGiaToChucChinhTriXaHoiDauTien;

    @OneToOne(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    ThongTinTuyenDung thongTinTuyenDung;

//    @Column(name = "ngay_nhap_ngu", columnDefinition = "datetime")
//    LocalDateTime ngayNhapNgu;
//
//    @Column(name = "ngay_xuat_ngu", columnDefinition = "datetime")
//    LocalDateTime ngayXuatNgu;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "cap_bac_loai_quan_ham_quan_doi_fk"), name = "quan_ham_cao_nhat", referencedColumnName = "id", columnDefinition = "integer")
//    CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi;

    @OneToOne(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    NghiaVuQuanSu quanSu;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "doi_tuong_chinh_sach_fk"), name = "doi_tuong_chinh_sach", referencedColumnName = "id", columnDefinition = "integer")
    DoiTuongChinhSach doiTuongChinhSach;

//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "trinh_do_giao_duc_pho_thong_fk"), name = "trinh_do_giao_duc_pho_thong", referencedColumnName = "id", columnDefinition = "integer")
//    TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "trinh_do_chuyen_mon_fk"), name = "trinh_do_chuyen_mon_cao_nhat", referencedColumnName = "id", columnDefinition = "integer")
//    TrinhDoChuyenMon trinhDoChuyenMon;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "hoc_ham_fk"), name = "hoc_ham", referencedColumnName = "id", columnDefinition = "integer")
//    HocHam hocHam;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "danh_hieu_nha_nuoc_phong_tang_fk"), name = "danh_hieu_nha_nuoc_phong_tang", referencedColumnName = "id", columnDefinition = "integer")
//    DanhHieuNhaNuoc danhHieuNhaNuocPhongTang;

    @OneToOne(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    HocVan hocVan;

//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "chuc_vu_fk"), name = "chuc_vu", referencedColumnName = "id", columnDefinition = "integer")
//    ChucVu chucVuHienTai;
//
//    @Column(name = "ngay_bo_nhiem", columnDefinition = "datetime")
//    LocalDateTime ngayBoNhiem;
//
//    @Column(name = "ngay_bo_nhiem_lai", columnDefinition = "datetime")
//    LocalDateTime ngayBoNhiemLai;
//
//    @Column(name = "duoc_quy_hoach_chuc_danh", columnDefinition = "varchar(50) default ''")
//    String duocQuyHoacChucDanh;

    @OneToOne(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    ChucVuHienTai chucVuHienTai;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "chuc_vu_kiem_nhiem_fk"), name = "chuc_vu_kiem_nhiem", referencedColumnName = "id", columnDefinition = "integer")
    ChucVu chucVuKiemNhiem;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "chuc_vu_dang_hien_tai_fk"), referencedColumnName = "id", name = "chuc_vu_dang_hien_tai", columnDefinition = "integer")
    ChucDanhDang chucVuDangHienTai;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "chuc_vu_dang_kiem_nhiem_fk"), referencedColumnName = "id", name = "chuc_vu_dang_kiem_nhiem", columnDefinition = "integer")
    ChucDanhDang chucVuDangKiemNhiem;

//    @Column(name = "cong_viec_chinh_duoc_giao", columnDefinition = "varchar(150) default ''")
//    String congViecChinhDuocGiao;
//
//    @Column(name = "so_truong_cong_tac", columnDefinition = "varchar(150) default 'Không'")
//    String soTruongCongTac;
//
//    @Column(name = "cong_viec_lam_lau_nhat", columnDefinition = "varchar(150) default ''")
//    String congViecLamLauNhat;

    @Column(name = "tien_luong", columnDefinition = "double default 1.0")
    double tienLuong;

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

    @OneToOne(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    NgachNhanVien ngach;

    @Column(name = "phu_cap_chuc_vu", columnDefinition = "double default 0.0")
    double phuCapChucVu;

    @Column(name = "phu_cap_kiem_nhiem", columnDefinition = "double default 0.0")
    double phuCapKiemNhiem;

    @Column(name = "phu_cap_khac", columnDefinition = "double default 0.0")
    double phuCapKhac;

    //    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "vi_tri_viec_lam_fk"), name = "vi_tri_viec_lam", referencedColumnName = "id", columnDefinition = "INTEGER")
//    ViTriViecLam viTriViecLam;
//
//    @Column(name = "ngay_huong_luong_vi_tri_viec_lam", columnDefinition = "datetime")
//    LocalDateTime ngayHuongLuongTheoViTriViecLam;
//
//    @Column(name = "phan_tram_huong_luong", columnDefinition = "double default 1.0")
//    float phamTramHuongLuong;
//
//    @Column(name = "phu_cap_tham_nien_vuot_khung", columnDefinition = "double default 0.0")
//    double phuCapThamNienVuotKhung;
//
//    @Column(name = "ngay_huong_PCTNVK", columnDefinition = "datetime")
//    LocalDateTime ngayHuongPCTNVK;

    @OneToOne(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    ViecLam viecLam;

    @OneToOne(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    SucKhoe sucKhoe;

//    @Column(name = "tinh_trang_suc_khoe")
//    @Enumerated(EnumType.ORDINAL)
//    TinhTrangSucKhoe tinhTrangSucKhoe;
//
//    @Column(name = "chieu_cao", columnDefinition = "float default 0.0")
//    float chieuCao;
//
//    @Column(name = "can_nang", columnDefinition = "float default 0.0")
//    float canNang;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "nhom_mau_fk"), name = "nhom_mau", referencedColumnName = "id", columnDefinition = "INTEGER")
//    NhomMau nhomMau;

    @Column(name = "phe_duyet")
    @Enumerated(EnumType.ORDINAL)
    PheDuyet pheDuyet;
/*
    // liên kết 2 chiều
    // tai sao list thi lay ok ma set thi méo lấy
    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    List<LyLuanChinhTri> lyLuanChinhTris;

    //liên kết 2 chiều
    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    List<NghiepVuChuyenNganh> nghiepVuChuyenNganhs;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    List<KienThucAnNinhQuocPhong> kienThucAnNinhQuocPhongs;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    List<TinHoc> tinHocs;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    List<NgoaiNgu> ngoaiNgus;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    List<QuaTrinhCongTac> quaTrinhCongTacs;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    List<BanThanCoLamViecChoCheDoCu> banThanCoLamViecChoCheDoCus;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    List<LamViecONuocNgoai> lamViecONuocNgoais;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    List<KhenThuong> khenThuongs;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    List<KyLuat> kyLuats;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    List<QuanHeGiaDinh> quanHeGiaDinhs;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    List<LuongBanThan> luongBanThans;

    @OneToMany(mappedBy = "soYeuLyLich", fetch = FetchType.LAZY)
    List<PhuCapKhac> phuCapKhacs;

//    @OneToOne(mappedBy = "soYeuLyLich")
//    @JoinColumn(name = "taikhoan", columnDefinition = "INTEGER")
//    @JsonIgnore
//    TaiKhoan taiKhoan;
*/
}
