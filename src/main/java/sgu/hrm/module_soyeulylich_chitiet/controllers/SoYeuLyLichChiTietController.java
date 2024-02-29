package sgu.hrm.module_soyeulylich_chitiet.controllers;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_response.ResDTO;

import sgu.hrm.module_soyeulylich_chitiet.models.LoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKhenThuongNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKyLuatNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqTinHoc;
import sgu.hrm.module_soyeulylich_chitiet.services.ISoYeuLyLichChiTietServices;

import java.util.List;

@RestController
@RequiredArgsConstructor // create constructor if field set final or @not null
@RequestMapping(value = "")
public class SoYeuLyLichChiTietController {
    private final ISoYeuLyLichChiTietServices.ILoaiSoYeuLyLichChiTietSefvice loaiSoYeuLyLichChiTietSefvice;
    private final ISoYeuLyLichChiTietServices.IBanThanCoLamViecChoCheDoCuSefvice banThanCoLamViecChoCheDoCuSefvice;
    private final ISoYeuLyLichChiTietServices.IKhenThuongSefvice khenThuongSefvice;
    private final ISoYeuLyLichChiTietServices.IKienThucAnNinhQuocPhongSefvice kienThucAnNinhQuocPhongSefvice;
    private final ISoYeuLyLichChiTietServices.IKyLuatSefvice kyLuatSefvice;
    private final ISoYeuLyLichChiTietServices.ILamViecONuocNgoaiSefvice lamViecONuocNgoaiSefvice;
    private final ISoYeuLyLichChiTietServices.ILuongBanThanSefvice luongBanThanSefvice;
    private final ISoYeuLyLichChiTietServices.ILyLuanChinhTriSefvice lyLuanChinhTriSefvice;
    private final ISoYeuLyLichChiTietServices.INghiepVuChuyenNganhSefvice nghiepVuChuyenNganhSefvice;
    private final ISoYeuLyLichChiTietServices.INgoaiNguSefvice ngoaiNguSefvice;
    private final ISoYeuLyLichChiTietServices.IPhuCapKhacSefvice phuCapKhacSefvice;
    private final ISoYeuLyLichChiTietServices.IQuanHeGiaDinhSefvice quanHeGiaDinhSefvice;
    private final ISoYeuLyLichChiTietServices.IQuaTrinhCongTacSefvice quaTrinhCongTacSefvice;
    private final ISoYeuLyLichChiTietServices.ITinHocSefvice tinHocSefvice;

    @GetMapping("/loai-so-yeu-ly-lich-chi-tiet")
    public ResDTO<List<LoaiSoYeuLyLichChiTiet>> xemLoaiSoYeuLyLichChiTiet() {
        return loaiSoYeuLyLichChiTietSefvice.xemLoaiSoYeuLyLichChiTiet();
    }

    @PostMapping("/loai-so-yeu-ly-lich-chi-tiet/them")
    public ResDTO<LoaiSoYeuLyLichChiTiet> addLoaiSoYeuLyLichChiTiet(@RequestBody ReqLoaiSoYeuLyLichChiTiet chiTiet) {
        return loaiSoYeuLyLichChiTietSefvice.themLoaiSoYeuLyLichChiTiet(chiTiet);
    }

    @PatchMapping("/loai-so-yeu-ly-lich-chi-tiet/sua")
    public ResDTO<LoaiSoYeuLyLichChiTiet> editLoaiSoYeuLyLichChiTiet(@RequestBody LoaiSoYeuLyLichChiTiet chiTiet) {
        return loaiSoYeuLyLichChiTietSefvice.suaLoaiSoYeuLyLichChiTiet(chiTiet);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /* EMPLOYEE EMPLOYEE EMPLOYEE EMPLOYEE */
    @GetMapping("/ca-nhan/lam-viec-cho-che-do-cu")
    public ResDTO<List<?>> lam_viec_cho_che_do_cu() {
        return banThanCoLamViecChoCheDoCuSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/ca-nhan/lam-viec-cho-che-do-cu/{id}")
    public ResDTO<?> id_lam_viec_cho_che_do_cu(@PathVariable int id) {
        return banThanCoLamViecChoCheDoCuSefvice.xemThongTin(id);
    }

    @PostMapping("/ca-nhan/lam-viec-cho-che-do-cu/them")
    public ResDTO<?> them_lam_viec_cho_che_do_cu(@RequestBody ReqBanThanCoLamViecChoCheDoCu cu) {
        return banThanCoLamViecChoCheDoCuSefvice.themThongTin(cu);
    }

    @PatchMapping("/ca-nhan/lam-viec-cho-che-do-cu/{id}/sua")
    public ResDTO<?> sua_lam_viec_cho_che_do_cu(@PathVariable int id, @RequestBody ReqBanThanCoLamViecChoCheDoCu cu) {
        return banThanCoLamViecChoCheDoCuSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/ca-nhan/lam-viec-cho-che-do-cu/{id}/xoa")
    public ResDTO<?> xoa_lam_viec_cho_che_do_cu(@PathVariable int id) {
        return banThanCoLamViecChoCheDoCuSefvice.xoaThongTin(id);
    }

    @GetMapping("/nhan-vien/{id}/lam-viec-cho-che-do-cu")
    public ResDTO<?> nhanvien_lam_viec_cho_che_do_cu(@PathVariable String id) {
        return banThanCoLamViecChoCheDoCuSefvice.xemDanhSach(id);
    }

    //==============================================================================================
    @GetMapping("/ca-nhan/khen-thuong")
    public ResDTO<List<?>> khen_thuong() {
        return khenThuongSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/ca-nhan/khen-thuong/{id}")
    public ResDTO<?> id_khen_thuong(@PathVariable int id) {
        return khenThuongSefvice.xemThongTin(id);
    }

    @PostMapping("/ca-nhan/khen-thuong/them")
    public ResDTO<?> them_khen_thuong(@RequestBody ReqKhenThuong cu) {
        return khenThuongSefvice.themThongTin(cu);
    }

    @PatchMapping("/ca-nhan/khen-thuong/{id}/sua")
    public ResDTO<?> sua_khen_thuong(@PathVariable int id, @RequestBody ReqKhenThuong cu) {
        return khenThuongSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/ca-nhan/khen-thuong/{id}/xoa")
    public ResDTO<?> xoa_khen_thuong(@PathVariable int id) {
        return khenThuongSefvice.xoaThongTin(id);
    }

    @GetMapping("/nhan-vien/{id}/khen-thuong")
    public ResDTO<?> nhanvien_khen_thuong(@PathVariable String id) {
        return khenThuongSefvice.xemDanhSach(id);
    }

    @PostMapping("/nhan-vien/khen-thuong")
    @Transactional
    public ResDTO<?> nhanvien_khenthuong(@RequestBody List<ReqKhenThuongNhanVien> nhanVien) {
        return khenThuongSefvice.khenThuongNhanVien(nhanVien);
    }

    //    =================================================
    @GetMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong")
    public ResDTO<List<?>> kien_thuc_an_ninh_quoc_phong() {
        return kienThucAnNinhQuocPhongSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResDTO<?> id_kien_thuc_an_ninh_quoc_phong(@PathVariable int id) {
        return kienThucAnNinhQuocPhongSefvice.xemThongTin(id);
    }

    @PostMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/them")
    public ResDTO<?> them_kien_thuc_an_ninh_quoc_phong(@RequestBody ReqKienThucAnNinhQuocPhong cu) {
        return kienThucAnNinhQuocPhongSefvice.themThongTin(cu);
    }

    @PatchMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/{id}/sua")
    public ResDTO<?> sua_kien_thuc_an_ninh_quoc_phong(@PathVariable int id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
        return kienThucAnNinhQuocPhongSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/{id}/xoa")
    public ResDTO<?> xoa_kien_thuc_an_ninh_quoc_phong(@PathVariable int id) {
        return kienThucAnNinhQuocPhongSefvice.xoaThongTin(id);
    }

    @GetMapping("/nhan-vien/{id}/kien-thuc-an-ninh-quoc-phong")
    public ResDTO<?> nhanvien_kien_thuc_an_ninh_quoc_phong(@PathVariable String id) {
        return kienThucAnNinhQuocPhongSefvice.xemDanhSach(id);
    }

    //    =================================================
    @GetMapping("/ca-nhan/ky-luat")
    public ResDTO<List<?>> ky_luat() {
        return kyLuatSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/ca-nhan/ky-luat/{id}")
    public ResDTO<?> id_ky_luat(@PathVariable int id) {
        return kyLuatSefvice.xemThongTin(id);
    }

    @PostMapping("/ca-nhan/ky-luat/them")
    public ResDTO<?> them_ky_luat(@RequestBody ReqKyLuat cu) {
        return kyLuatSefvice.themThongTin(cu);
    }

    @PatchMapping("/ca-nhan/ky-luat/{id}/sua")
    public ResDTO<?> sua_ky_luat(@PathVariable int id, @RequestBody ReqKyLuat cu) {
        return kyLuatSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/ca-nhan/ky-luat/{id}/xoa")
    public ResDTO<?> xoa_ky_luat(@PathVariable int id) {
        return kyLuatSefvice.xoaThongTin(id);
    }

    @GetMapping("/nhan-vien/{id}/ky-luat")
    public ResDTO<?> nhanvien_ky_luat(@PathVariable String id) {
        return kyLuatSefvice.xemDanhSach(id);
    }
    @PostMapping("/nhan-vien/ky-luat")
    @Transactional
    public ResDTO<?> nhanvien_kyluat(@RequestBody List<ReqKyLuatNhanVien> nhanVien) {
        return kyLuatSefvice.kyLuatNhanVien(nhanVien);
    }
    //========================================================
    @GetMapping("/ca-nhan/lam-viec-o-nuoc-ngoai")
    public ResDTO<List<?>> lam_viec_o_nuoc_ngoai() {
        return lamViecONuocNgoaiSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/ca-nhan/lam-viec-o-nuoc-ngoai/{id}")
    public ResDTO<?> id_lam_viec_o_nuoc_ngoai(@PathVariable int id) {
        return lamViecONuocNgoaiSefvice.xemThongTin(id);
    }

    @PostMapping("/ca-nhan/lam-viec-o-nuoc-ngoai/them")
    public ResDTO<?> them_lam_viec_o_nuoc_ngoai(@RequestBody ReqLamViecONuocNgoai cu) {
        return lamViecONuocNgoaiSefvice.themThongTin(cu);
    }

    @PatchMapping("/ca-nhan/lam-viec-o-nuoc-ngoai/{id}/sua")
    public ResDTO<?> sua_lam_viec_o_nuoc_ngoai(@PathVariable int id, @RequestBody ReqLamViecONuocNgoai cu) {
        return lamViecONuocNgoaiSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/ca-nhan/lam-viec-o-nuoc-ngoai/{id}/xoa")
    public ResDTO<?> xoa_lam_viec_o_nuoc_ngoai(@PathVariable int id) {
        return lamViecONuocNgoaiSefvice.xoaThongTin(id);
    }

    @GetMapping("/nhan-vien/{id}/lam-viec-o-nuoc-ngoai")
    public ResDTO<?> nhanvien_lam_viec_o_nuoc_ngoai(@PathVariable String id) {
        return lamViecONuocNgoaiSefvice.xemDanhSach(id);
    }
    //========================================================

    @GetMapping("/ca-nhan/luong-ban-than")
    public ResDTO<List<?>> luong_ban_than() {
        return luongBanThanSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/ca-nhan/luong-ban-than/{id}")
    public ResDTO<?> id_luong_ban_than(@PathVariable int id) {
        return luongBanThanSefvice.xemThongTin(id);
    }

    @PostMapping("/ca-nhan/luong-ban-than/them")
    public ResDTO<?> them_luong_ban_than(@RequestBody ReqLuongBanThan cu) {
        return luongBanThanSefvice.themThongTin(cu);
    }

    @PatchMapping("/ca-nhan/luong-ban-than/{id}/sua")
    public ResDTO<?> sua_luong_ban_than(@PathVariable int id, @RequestBody ReqLuongBanThan cu) {
        return luongBanThanSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/ca-nhan/luong-ban-than/{id}/xoa")
    public ResDTO<?> xoa_luong_ban_than(@PathVariable int id) {
        return luongBanThanSefvice.xoaThongTin(id);
    }

    @GetMapping("/nhan-vien/{id}/luong-ban-than")
    public ResDTO<?> nhanvien_luong_ban_than(@PathVariable String id) {
        return luongBanThanSefvice.xemDanhSach(id);
    }
    //========================================================

    @GetMapping("/ca-nhan/ly-luan-chinh-tri")
    public ResDTO<List<?>> ly_luan_chinh_tri() {
        return lyLuanChinhTriSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/ca-nhan/ly-luan-chinh-tri/{id}")
    public ResDTO<?> id_ly_luan_chinh_tri(@PathVariable int id) {
        return lyLuanChinhTriSefvice.xemThongTin(id);
    }

    @PostMapping("/ca-nhan/ly-luan-chinh-tri/them")
    public ResDTO<?> them_ly_luan_chinh_tri(@RequestBody ReqLyLuanChinhTri cu) {
        return lyLuanChinhTriSefvice.themThongTin(cu);
    }

    @PatchMapping("/ca-nhan/ly-luan-chinh-tri/{id}/sua")
    public ResDTO<?> sua_ly_luan_chinh_tri(@PathVariable int id, @RequestBody ReqLyLuanChinhTri cu) {
        return lyLuanChinhTriSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/ca-nhan/ly-luan-chinh-tri/{id}/xoa")
    public ResDTO<?> xoa_ly_luan_chinh_tri(@PathVariable int id) {
        return lyLuanChinhTriSefvice.xoaThongTin(id);
    }

    @GetMapping("/nhan-vien/{id}/ly-luan-chinh-tri")
    public ResDTO<?> nhanvien_ly_luan_chinh_tri(@PathVariable String id) {
        return lyLuanChinhTriSefvice.xemDanhSach(id);
    }

    //========================================================
    @GetMapping("/ca-nhan/nghiep-vu-chuyen-nganh")
    public ResDTO<List<?>> nghiep_vu_chuyen_nganh() {
        return nghiepVuChuyenNganhSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/ca-nhan/nghiep-vu-chuyen-nganh/{id}")
    public ResDTO<?> id_nghiep_vu_chuyen_nganh(@PathVariable int id) {
        return nghiepVuChuyenNganhSefvice.xemThongTin(id);
    }

    @PostMapping("/ca-nhan/nghiep-vu-chuyen-nganh/them")
    public ResDTO<?> them_nghiep_vu_chuyen_nganh(@RequestBody ReqNghiepVuChuyenNganh cu) {
        return nghiepVuChuyenNganhSefvice.themThongTin(cu);
    }

    @PatchMapping("/ca-nhan/nghiep-vu-chuyen-nganh/{id}/sua")
    public ResDTO<?> sua_nghiep_vu_chuyen_nganh(@PathVariable int id, @RequestBody ReqNghiepVuChuyenNganh cu) {
        return nghiepVuChuyenNganhSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/ca-nhan/nghiep-vu-chuyen-nganh/{id}/xoa")
    public ResDTO<?> xoa_nghiep_vu_chuyen_nganh(@PathVariable int id) {
        return nghiepVuChuyenNganhSefvice.xoaThongTin(id);
    }

    @GetMapping("/nhan-vien/{id}/nghiep-vu-chuyen-nganh")
    public ResDTO<?> nhanvien_nghiep_vu_chuyen_nganh(@PathVariable String id) {
        return nghiepVuChuyenNganhSefvice.xemDanhSach(id);
    }

    //    ==========================================
    @GetMapping("/ca-nhan/ngoai-ngu")
    public ResDTO<List<?>> ngoai_ngu() {
        return ngoaiNguSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/ca-nhan/ngoai-ngu/{id}")
    public ResDTO<?> id_ngoai_ngu(@PathVariable int id) {
        return ngoaiNguSefvice.xemThongTin(id);
    }

    @PostMapping("/ca-nhan/ngoai-ngu/them")
    public ResDTO<?> them_ngoai_ngu(@RequestBody ReqNgoaiNgu cu) {
        return ngoaiNguSefvice.themThongTin(cu);
    }

    @PatchMapping("/ca-nhan/ngoai-ngu/{id}/sua")
    public ResDTO<?> sua_ngoai_ngu(@PathVariable int id, @RequestBody ReqNgoaiNgu cu) {
        return ngoaiNguSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/ca-nhan/ngoai-ngu/{id}/xoa")
    public ResDTO<?> xoa_ngoai_ngu(@PathVariable int id) {
        return ngoaiNguSefvice.xoaThongTin(id);
    }

    @GetMapping("/nhan-vien/{id}/ngoai-ngu")
    public ResDTO<?> nhanvien_ngoai_ngu(@PathVariable String id) {
        return ngoaiNguSefvice.xemDanhSach(id);
    }

    //===========================================================
    @GetMapping("/ca-nhan/phu-cap-khac")
    public ResDTO<List<?>> phu_cap_khac() {
        return phuCapKhacSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/ca-nhan/phu-cap-khac/{id}")
    public ResDTO<?> id_phu_cap_khac(@PathVariable int id) {
        return phuCapKhacSefvice.xemThongTin(id);
    }

    @PostMapping("/ca-nhan/phu-cap-khac/them")
    public ResDTO<?> them_phu_cap_khac(@RequestBody ReqPhuCapKhac cu) {
        return phuCapKhacSefvice.themThongTin(cu);
    }

    @PatchMapping("/ca-nhan/phu-cap-khac/{id}/sua")
    public ResDTO<?> sua_phu_cap_khac(@PathVariable int id, @RequestBody ReqPhuCapKhac cu) {
        return phuCapKhacSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/ca-nhan/phu-cap-khac/{id}/xoa")
    public ResDTO<?> xoa_phu_cap_khac(@PathVariable int id) {
        return phuCapKhacSefvice.xoaThongTin(id);
    }

    @GetMapping("/nhan-vien/{id}/phu-cap-khac")
    public ResDTO<?> nhanvien_phu_cap_khac(@PathVariable String id) {
        return phuCapKhacSefvice.xemDanhSach(id);
    }

    //=======================================================
    @GetMapping("/ca-nhan/quan-he-gia-dinh")
    public ResDTO<List<?>> quan_he_gia_dinh() {
        return quanHeGiaDinhSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/ca-nhan/quan-he-gia-dinh/{id}")
    public ResDTO<?> id_quan_he_gia_dinh(@PathVariable int id) {
        return quanHeGiaDinhSefvice.xemThongTin(id);
    }

    @PostMapping("/ca-nhan/quan-he-gia-dinh/them")
    public ResDTO<?> them_quan_he_gia_dinh(@RequestBody ReqQuanHeGiaDinh cu) {
        return quanHeGiaDinhSefvice.themThongTin(cu);
    }

    @PatchMapping("/ca-nhan/quan-he-gia-dinh/{id}/sua")
    public ResDTO<?> sua_quan_he_gia_dinh(@PathVariable int id, @RequestBody ReqQuanHeGiaDinh cu) {
        return quanHeGiaDinhSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/ca-nhan/quan-he-gia-dinh/{id}/xoa")
    public ResDTO<?> xoa_quan_he_gia_dinh(@PathVariable int id) {
        return quanHeGiaDinhSefvice.xoaThongTin(id);
    }

    @GetMapping("/nhan-vien/{id}/quan-he-gia-dinh")
    public ResDTO<?> nhanvien_quan_he_gia_dinh(@PathVariable String id) {
        return quanHeGiaDinhSefvice.xemDanhSach(id);
    }
    //=======================================================

    @GetMapping("/ca-nhan/qua-trinh-cong-tac")
    public ResDTO<List<?>> qua_trinh_cong_tac() {
        return quaTrinhCongTacSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/ca-nhan/qua-trinh-cong-tac/{id}")
    public ResDTO<?> id_qua_trinh_cong_tac(@PathVariable int id) {
        return quaTrinhCongTacSefvice.xemThongTin(id);
    }

    @PostMapping("/ca-nhan/qua-trinh-cong-tac/them")
    public ResDTO<?> them_qua_trinh_cong_tac(@RequestBody ReqQuaTrinhCongTac cu) {
        return quaTrinhCongTacSefvice.themThongTin(cu);
    }

    @PatchMapping("/ca-nhan/qua-trinh-cong-tac/{id}/sua")
    public ResDTO<?> sua_qua_trinh_cong_tac(@PathVariable int id, @RequestBody ReqQuaTrinhCongTac cu) {
        return quaTrinhCongTacSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/ca-nhan/qua-trinh-cong-tac/{id}/xoa")
    public ResDTO<?> xoa_qua_trinh_cong_tac(@PathVariable int id) {
        return quaTrinhCongTacSefvice.xoaThongTin(id);
    }

    @GetMapping("/nhan-vien/{id}/qua-trinh-cong-tac")
    public ResDTO<?> nhanvien_qua_trinh_cong_tac(@PathVariable String id) {
        return quaTrinhCongTacSefvice.xemDanhSach(id);
    }
    //=======================================================

    @GetMapping("/ca-nhan/tin-hoc")
    public ResDTO<List<?>> tin_hoc() {
        return tinHocSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/ca-nhan/tin-hoc/{id}")
    public ResDTO<?> id_tin_hoc(@PathVariable int id) {
        return tinHocSefvice.xemThongTin(id);
    }

    @PostMapping("/ca-nhan/tin-hoc/them")
    public ResDTO<?> them_tin_hoc(@RequestBody ReqTinHoc cu) {
        return tinHocSefvice.themThongTin(cu);
    }

    @PatchMapping("/ca-nhan/tin-hoc/{id}/sua")
    public ResDTO<?> sua_tin_hoc(@PathVariable int id, @RequestBody ReqTinHoc cu) {
        return tinHocSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/ca-nhan/tin-hoc/{id}/xoa")
    public ResDTO<?> xoa_tin_hoc(@PathVariable int id) {
        return tinHocSefvice.xoaThongTin(id);
    }

    @GetMapping("/nhan-vien/{id}/tin-hoc")
    public ResDTO<?> nhanvien_tin_hoc(@PathVariable String id) {
        return tinHocSefvice.xemDanhSach(id);
    }
}
