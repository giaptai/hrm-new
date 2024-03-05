package sgu.hrm.module_soyeulylich_chitiet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_response.ResDTO;

import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;
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
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResTinHoc;
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
    public ResponseEntity<ResDTO<List<ResBanThanCoLamViecChoCheDoCu>>> lam_viec_cho_che_do_cu() {
        List<ResBanThanCoLamViecChoCheDoCu> ls = banThanCoLamViecChoCheDoCuSefvice.xemDanhSachThongTin().stream().map(ResBanThanCoLamViecChoCheDoCu::maptoResBanThanCoLamViecChoCheDoCu).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ls), HttpStatus.OK);
    }

    @GetMapping("/ca-nhan/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResDTO<ResBanThanCoLamViecChoCheDoCu>> id_lam_viec_cho_che_do_cu(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResBanThanCoLamViecChoCheDoCu.maptoResBanThanCoLamViecChoCheDoCu(banThanCoLamViecChoCheDoCuSefvice.xemThongTin(id))), HttpStatus.OK);
    }

    @PostMapping("/ca-nhan/lam-viec-cho-che-do-cu")
    @Transactional
    public ResponseEntity<ResDTO<ResBanThanCoLamViecChoCheDoCu>> them_lam_viec_cho_che_do_cu(@RequestBody ReqBanThanCoLamViecChoCheDoCu cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResBanThanCoLamViecChoCheDoCu.maptoResBanThanCoLamViecChoCheDoCu(banThanCoLamViecChoCheDoCuSefvice.themThongTin(cu))), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResDTO<ResBanThanCoLamViecChoCheDoCu>> sua_lam_viec_cho_che_do_cu(@PathVariable int id, @RequestBody ReqBanThanCoLamViecChoCheDoCu cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResBanThanCoLamViecChoCheDoCu.maptoResBanThanCoLamViecChoCheDoCu(banThanCoLamViecChoCheDoCuSefvice.suaThongTin(id, cu))), HttpStatus.OK);
    }

    @DeleteMapping("/ca-nhan/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResDTO<Boolean>> xoa_lam_viec_cho_che_do_cu(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, banThanCoLamViecChoCheDoCuSefvice.xoaThongTin(id)), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/{id}/lam-viec-cho-che-do-cu")
    public ResponseEntity<ResDTO<List<ResBanThanCoLamViecChoCheDoCu>>> nhanvien_lam_viec_cho_che_do_cu(@PathVariable String id) {
        List<ResBanThanCoLamViecChoCheDoCu> ls = banThanCoLamViecChoCheDoCuSefvice.xemDanhSach(id).stream().map(ResBanThanCoLamViecChoCheDoCu::maptoResBanThanCoLamViecChoCheDoCu).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ls), HttpStatus.ACCEPTED);
    }


    //==============================================================================================
    @GetMapping("/ca-nhan/khen-thuong")
    public ResponseEntity<ResDTO<List<ResKhenThuong>>> khen_thuong() {
        List<ResKhenThuong> res = khenThuongSefvice.xemDanhSachThongTin().stream().map(ResKhenThuong::maptoResKhenThuong).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, res), HttpStatus.OK);
    }

    @GetMapping("/ca-nhan/khen-thuong/{id}")
    public ResponseEntity<ResDTO<ResKhenThuong>> id_khen_thuong(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResKhenThuong.maptoResKhenThuong(khenThuongSefvice.xemThongTin(id))), HttpStatus.OK);
    }

    @PostMapping("/ca-nhan/khen-thuong")
    public ResponseEntity<ResDTO<ResKhenThuong>> them_khen_thuong(@RequestBody ReqKhenThuong cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResKhenThuong.maptoResKhenThuong(khenThuongSefvice.themThongTin(cu))), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/khen-thuong/{id}")
    public ResponseEntity<ResDTO<ResKhenThuong>> sua_khen_thuong(@PathVariable int id, @RequestBody ReqKhenThuong cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResKhenThuong.maptoResKhenThuong(khenThuongSefvice.suaThongTin(id, cu))), HttpStatus.OK);
    }

    @DeleteMapping("/ca-nhan/khen-thuong/{id}")
    public ResponseEntity<ResDTO<Boolean>> xoa_khen_thuong(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, khenThuongSefvice.xoaThongTin(id)), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/{id}/khen-thuong")
    public ResponseEntity<ResDTO<List<ResKhenThuong>>> nhanvien_khen_thuong(@PathVariable String id) {
        List<ResKhenThuong> kt = khenThuongSefvice.xemDanhSach(id).stream().map(ResKhenThuong::maptoResKhenThuong).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, kt), HttpStatus.ACCEPTED);
    }

    @PostMapping("/nhan-vien/khen-thuong")
    @Transactional
    public ResDTO<?> nhanvien_khenthuong(@RequestBody List<ReqKhenThuongNhanVien> nhanVien) {
        return khenThuongSefvice.khenThuongNhanVien(nhanVien);
    }

    //    =================================================
    @GetMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<ResDTO<List<ResKienThucAnNinhQuocPhong>>> kien_thuc_an_ninh_quoc_phong() {
        List<ResKienThucAnNinhQuocPhong> res = kienThucAnNinhQuocPhongSefvice.xemDanhSachThongTin().stream().map(ResKienThucAnNinhQuocPhong::mapToResKienThucAnNinhQuocPhong).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, res), HttpStatus.OK);
    }

    @GetMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResDTO<ResKienThucAnNinhQuocPhong>> id_kien_thuc_an_ninh_quoc_phong(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ResKienThucAnNinhQuocPhong.mapToResKienThucAnNinhQuocPhong(kienThucAnNinhQuocPhongSefvice.xemThongTin(id))), HttpStatus.OK);
    }

    @PostMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<ResDTO<ResKienThucAnNinhQuocPhong>> them_kien_thuc_an_ninh_quoc_phong(@RequestBody ReqKienThucAnNinhQuocPhong cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ResKienThucAnNinhQuocPhong.mapToResKienThucAnNinhQuocPhong(kienThucAnNinhQuocPhongSefvice.themThongTin(cu))), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResDTO<ResKienThucAnNinhQuocPhong>> sua_kien_thuc_an_ninh_quoc_phong(@PathVariable int id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ResKienThucAnNinhQuocPhong.mapToResKienThucAnNinhQuocPhong(kienThucAnNinhQuocPhongSefvice.suaThongTin(id, cu))), HttpStatus.OK);
    }

    @DeleteMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResDTO<Boolean>> xoa_kien_thuc_an_ninh_quoc_phong(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, kienThucAnNinhQuocPhongSefvice.xoaThongTin(id)), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/{id}/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<ResDTO<List<ResKienThucAnNinhQuocPhong>>> nhanvien_kien_thuc_an_ninh_quoc_phong(@PathVariable String id) {
        List<ResKienThucAnNinhQuocPhong> res = kienThucAnNinhQuocPhongSefvice.xemDanhSach(id).stream().map(ResKienThucAnNinhQuocPhong::mapToResKienThucAnNinhQuocPhong).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, res), HttpStatus.OK);
    }

    //    =================================================
    @GetMapping("/ca-nhan/ky-luat")
    public ResponseEntity<ResDTO<List<ResKyLuat>>> ky_luat() {
        List<ResKyLuat> kl = kyLuatSefvice.xemDanhSachThongTin().stream().map(ResKyLuat::mapToResKyLuat).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, kl), HttpStatus.OK);
    }

    @GetMapping("/ca-nhan/ky-luat/{id}")
    public ResponseEntity<ResDTO<ResKyLuat>> id_ky_luat(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ResKyLuat.mapToResKyLuat(kyLuatSefvice.xemThongTin(id))), HttpStatus.OK);
    }

    @PostMapping("/ca-nhan/ky-luat")
    public ResponseEntity<ResDTO<ResKyLuat>> them_ky_luat(@RequestBody ReqKyLuat cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ResKyLuat.mapToResKyLuat(kyLuatSefvice.themThongTin(cu))), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/ky-luat/{id}")
    public ResponseEntity<ResDTO<ResKyLuat>> sua_ky_luat(@PathVariable int id, @RequestBody ReqKyLuat cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ResKyLuat.mapToResKyLuat(kyLuatSefvice.suaThongTin(id, cu))), HttpStatus.OK);
    }

    @DeleteMapping("/ca-nhan/ky-luat/{id}")
    public ResponseEntity<ResDTO<Boolean>> xoa_ky_luat(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, kyLuatSefvice.xoaThongTin(id)), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/{id}/ky-luat")
    public ResponseEntity<ResDTO<List<ResKyLuat>>> nhanvien_ky_luat(@PathVariable String id) {
        List<ResKyLuat> kl = kyLuatSefvice.xemDanhSach(id).stream().map(ResKyLuat::mapToResKyLuat).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, kl), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/nhan-vien/ky-luat")
    public ResDTO<?> nhanvien_kyluat(@RequestBody List<ReqKyLuatNhanVien> nhanVien) {
        return kyLuatSefvice.kyLuatNhanVien(nhanVien);
    }

    //========================================================
    @GetMapping("/ca-nhan/lam-viec-o-nuoc-ngoai")
    public ResponseEntity<ResDTO<List<ResLamViecONuocNgoai>>> lam_viec_o_nuoc_ngoai() {
        List<ResLamViecONuocNgoai> nc = lamViecONuocNgoaiSefvice.xemDanhSachThongTin().stream().map(ResLamViecONuocNgoai::mapToResLamViecONuocNgoai).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nc), HttpStatus.OK);
    }

    @GetMapping("/ca-nhan/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<ResDTO<ResLamViecONuocNgoai>> id_lam_viec_o_nuoc_ngoai(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ResLamViecONuocNgoai.mapToResLamViecONuocNgoai(lamViecONuocNgoaiSefvice.xemThongTin(id))), HttpStatus.OK);
    }

    @PostMapping("/ca-nhan/lam-viec-o-nuoc-ngoai")
    public ResponseEntity<ResDTO<ResLamViecONuocNgoai>> them_lam_viec_o_nuoc_ngoai(@RequestBody ReqLamViecONuocNgoai cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ResLamViecONuocNgoai.mapToResLamViecONuocNgoai(lamViecONuocNgoaiSefvice.themThongTin(cu))), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<ResDTO<ResLamViecONuocNgoai>> sua_lam_viec_o_nuoc_ngoai(@PathVariable int id, @RequestBody ReqLamViecONuocNgoai cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ResLamViecONuocNgoai.mapToResLamViecONuocNgoai(lamViecONuocNgoaiSefvice.suaThongTin(id, cu))), HttpStatus.OK);
    }

    @DeleteMapping("/ca-nhan/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<ResDTO<Boolean>> xoa_lam_viec_o_nuoc_ngoai(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, lamViecONuocNgoaiSefvice.xoaThongTin(id)), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/{id}/lam-viec-o-nuoc-ngoai")
    public ResponseEntity<ResDTO<List<ResLamViecONuocNgoai>>> nhanvien_lam_viec_o_nuoc_ngoai(@PathVariable String id) {
        List<ResLamViecONuocNgoai> nc = lamViecONuocNgoaiSefvice.xemDanhSach(id).stream().map(ResLamViecONuocNgoai::mapToResLamViecONuocNgoai).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nc), HttpStatus.OK);
    }
    //========================================================

    @GetMapping("/ca-nhan/luong-ban-than")
    public ResponseEntity<ResDTO<List<ResLuongBanThan>>> luong_ban_than() {
        List<ResLuongBanThan> luong = luongBanThanSefvice.xemDanhSachThongTin().stream().map(ResLuongBanThan::mapToResLuongBanThan).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, luong), HttpStatus.OK);
    }

    @GetMapping("/ca-nhan/luong-ban-than/{id}")
    public ResponseEntity<ResDTO<ResLuongBanThan>> id_luong_ban_than(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResLuongBanThan.mapToResLuongBanThan(luongBanThanSefvice.xemThongTin(id))), HttpStatus.OK);
    }

    @PostMapping("/ca-nhan/luong-ban-than")
    public ResponseEntity<ResDTO<ResLuongBanThan>> them_luong_ban_than(@RequestBody ReqLuongBanThan cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResLuongBanThan.mapToResLuongBanThan(luongBanThanSefvice.themThongTin(cu))), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/luong-ban-than/{id}")
    public ResponseEntity<ResDTO<ResLuongBanThan>> sua_luong_ban_than(@PathVariable int id, @RequestBody ReqLuongBanThan cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResLuongBanThan.mapToResLuongBanThan(luongBanThanSefvice.suaThongTin(id, cu))), HttpStatus.OK);
    }

    @DeleteMapping("/ca-nhan/luong-ban-than/{id}")
    public ResponseEntity<ResDTO<Boolean>> xoa_luong_ban_than(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                luongBanThanSefvice.xoaThongTin(id)), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/{id}/luong-ban-than")
    public ResponseEntity<ResDTO<List<ResLuongBanThan>>> nhanvien_luong_ban_than(@PathVariable String id) {
        List<ResLuongBanThan> luong = luongBanThanSefvice.xemDanhSach(id).stream()
                .map(ResLuongBanThan::mapToResLuongBanThan).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, luong), HttpStatus.OK);
    }
    //========================================================

    @GetMapping("/ca-nhan/ly-luan-chinh-tri")
    public ResponseEntity<ResDTO<List<ResLyLuanChinhTri>>> ly_luan_chinh_tri() {
        List<ResLyLuanChinhTri> tri = lyLuanChinhTriSefvice.xemDanhSachThongTin().stream().map(ResLyLuanChinhTri::mapToResLyLuanChinhTri).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tri), HttpStatus.OK);
    }

    @GetMapping("/ca-nhan/ly-luan-chinh-tri/{id}")
    public ResponseEntity<ResDTO<ResLyLuanChinhTri>> id_ly_luan_chinh_tri(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResLyLuanChinhTri.mapToResLyLuanChinhTri(lyLuanChinhTriSefvice.xemThongTin(id))), HttpStatus.OK);
    }

    @PostMapping("/ca-nhan/ly-luan-chinh-tri")
    public ResponseEntity<ResDTO<ResLyLuanChinhTri>> them_ly_luan_chinh_tri(@RequestBody ReqLyLuanChinhTri cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResLyLuanChinhTri.mapToResLyLuanChinhTri(lyLuanChinhTriSefvice.themThongTin(cu))), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/ly-luan-chinh-tri/{id}")
    public ResponseEntity<ResDTO<ResLyLuanChinhTri>> sua_ly_luan_chinh_tri(@PathVariable int id, @RequestBody ReqLyLuanChinhTri cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResLyLuanChinhTri.mapToResLyLuanChinhTri(lyLuanChinhTriSefvice.suaThongTin(id, cu))), HttpStatus.OK);
    }

    @DeleteMapping("/ca-nhan/ly-luan-chinh-tri/{id}")
    public ResponseEntity<ResDTO<Boolean>> xoa_ly_luan_chinh_tri(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, lyLuanChinhTriSefvice.xoaThongTin(id)), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/{id}/ly-luan-chinh-tri")
    public ResponseEntity<ResDTO<List<ResLyLuanChinhTri>>> nhanvien_ly_luan_chinh_tri(@PathVariable String id) {
        List<ResLyLuanChinhTri> tri = lyLuanChinhTriSefvice.xemDanhSach(id).stream().map(ResLyLuanChinhTri::mapToResLyLuanChinhTri).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tri), HttpStatus.OK);
    }

    //========================================================
    @GetMapping("/ca-nhan/nghiep-vu-chuyen-nganh")
    public ResponseEntity<ResDTO<List<ResNghiepVuChuyenNganh>>> nghiep_vu_chuyen_nganh() {
        List<ResNghiepVuChuyenNganh> vu = nghiepVuChuyenNganhSefvice.xemDanhSachThongTin().stream().map(ResNghiepVuChuyenNganh::mapToResNghiepVuChuyenNganh).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, vu), HttpStatus.OK);
    }

    @GetMapping("/ca-nhan/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<ResDTO<ResNghiepVuChuyenNganh>> id_nghiep_vu_chuyen_nganh(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResNghiepVuChuyenNganh.mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganhSefvice.xemThongTin(id))), HttpStatus.OK);
    }

    @PostMapping("/ca-nhan/nghiep-vu-chuyen-nganh")
    public ResponseEntity<ResDTO<ResNghiepVuChuyenNganh>> them_nghiep_vu_chuyen_nganh(@RequestBody ReqNghiepVuChuyenNganh cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResNghiepVuChuyenNganh.mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganhSefvice.themThongTin(cu))), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<ResDTO<ResNghiepVuChuyenNganh>> sua_nghiep_vu_chuyen_nganh(@PathVariable int id, @RequestBody ReqNghiepVuChuyenNganh cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResNghiepVuChuyenNganh.mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganhSefvice.suaThongTin(id, cu))), HttpStatus.OK);
    }

    @DeleteMapping("/ca-nhan/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<ResDTO<Boolean>> xoa_nghiep_vu_chuyen_nganh(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nghiepVuChuyenNganhSefvice.xoaThongTin(id)), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/{id}/nghiep-vu-chuyen-nganh")
    public ResponseEntity<ResDTO<List<ResNghiepVuChuyenNganh>>> nhanvien_nghiep_vu_chuyen_nganh(@PathVariable String id) {
        List<ResNghiepVuChuyenNganh> vu = nghiepVuChuyenNganhSefvice.xemDanhSach(id).stream().map(ResNghiepVuChuyenNganh::mapToResNghiepVuChuyenNganh).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, vu), HttpStatus.OK);
    }

    //    ==========================================NGOAI NGU
    @GetMapping("/ca-nhan/ngoai-ngu")
    public ResponseEntity<ResDTO<List<ResNgoaiNgu>>> ngoai_ngu() {
        List<ResNgoaiNgu> ngu = ngoaiNguSefvice.xemDanhSachThongTin().stream().map(ResNgoaiNgu::mapToResNgoaiNgu).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ngu), HttpStatus.OK);
    }

    @GetMapping("/ca-nhan/ngoai-ngu/{id}")
    public ResponseEntity<ResDTO<ResNgoaiNgu>> id_ngoai_ngu(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResNgoaiNgu.mapToResNgoaiNgu(ngoaiNguSefvice.xemThongTin(id))), HttpStatus.OK);
    }

    @PostMapping("/ca-nhan/ngoai-ngu")
    public ResponseEntity<ResDTO<ResNgoaiNgu>> them_ngoai_ngu(@RequestBody ReqNgoaiNgu cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResNgoaiNgu.mapToResNgoaiNgu(ngoaiNguSefvice.themThongTin(cu))), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/ngoai-ngu/{id}")
    public ResponseEntity<ResDTO<ResNgoaiNgu>> sua_ngoai_ngu(@PathVariable int id, @RequestBody ReqNgoaiNgu cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResNgoaiNgu.mapToResNgoaiNgu(ngoaiNguSefvice.suaThongTin(id, cu))), HttpStatus.OK);
    }

    @DeleteMapping("/ca-nhan/ngoai-ngu/{id}")
    public ResponseEntity<ResDTO<Boolean>> xoa_ngoai_ngu(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ngoaiNguSefvice.xoaThongTin(id)), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/{id}/ngoai-ngu")
    public ResponseEntity<ResDTO<List<ResNgoaiNgu>>> nhanvien_ngoai_ngu(@PathVariable String id) {
        List<ResNgoaiNgu> ngu = ngoaiNguSefvice.xemDanhSach(id).stream().map(ResNgoaiNgu::mapToResNgoaiNgu).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ngu), HttpStatus.OK);
    }

    //===========================================================
    @GetMapping("/ca-nhan/phu-cap-khac")
    public ResponseEntity<ResDTO<List<ResPhuCapKhac>>> phu_cap_khac() {
        List<ResPhuCapKhac> khac = phuCapKhacSefvice.xemDanhSachThongTin().stream().map(ResPhuCapKhac::mapToResPhuCapKhac).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, khac), HttpStatus.OK);
    }

    @GetMapping("/ca-nhan/phu-cap-khac/{id}")
    public ResponseEntity<ResDTO<ResPhuCapKhac>> id_phu_cap_khac(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResPhuCapKhac.mapToResPhuCapKhac(phuCapKhacSefvice.xemThongTin(id))), HttpStatus.OK);
    }

    @PostMapping("/ca-nhan/phu-cap-khac")
    public ResponseEntity<ResDTO<ResPhuCapKhac>> them_phu_cap_khac(@RequestBody ReqPhuCapKhac cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResPhuCapKhac.mapToResPhuCapKhac(phuCapKhacSefvice.themThongTin(cu))), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/phu-cap-khac/{id}")
    public ResponseEntity<ResDTO<ResPhuCapKhac>> sua_phu_cap_khac(@PathVariable int id, @RequestBody ReqPhuCapKhac cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResPhuCapKhac.mapToResPhuCapKhac(phuCapKhacSefvice.suaThongTin(id, cu))), HttpStatus.OK);
    }

    @DeleteMapping("/ca-nhan/phu-cap-khac/{id}")
    public ResponseEntity<ResDTO<Boolean>> xoa_phu_cap_khac(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                phuCapKhacSefvice.xoaThongTin(id)), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/{id}/phu-cap-khac")
    public ResponseEntity<ResDTO<List<ResPhuCapKhac>>> nhanvien_phu_cap_khac(@PathVariable String id) {
        List<ResPhuCapKhac> khac = phuCapKhacSefvice.xemDanhSach(id).stream().map(ResPhuCapKhac::mapToResPhuCapKhac).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, khac), HttpStatus.OK);
    }

    //=======================================================
    @GetMapping("/ca-nhan/quan-he-gia-dinh")
    public ResponseEntity<ResDTO<List<ResQuanHeGiaDinh>>> quan_he_gia_dinh() {
        List<ResQuanHeGiaDinh> gia = quanHeGiaDinhSefvice.xemDanhSachThongTin().stream().map(ResQuanHeGiaDinh::mapToResQuanHeGiaDinh).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, gia), HttpStatus.OK);
    }

    @GetMapping("/ca-nhan/quan-he-gia-dinh/{id}")
    public ResponseEntity<ResDTO<ResQuanHeGiaDinh>> id_quan_he_gia_dinh(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResQuanHeGiaDinh.mapToResQuanHeGiaDinh(quanHeGiaDinhSefvice.xemThongTin(id))), HttpStatus.OK);
    }

    @PostMapping("/ca-nhan/quan-he-gia-dinh")
    public ResponseEntity<ResDTO<ResQuanHeGiaDinh>> them_quan_he_gia_dinh(@RequestBody ReqQuanHeGiaDinh cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResQuanHeGiaDinh.mapToResQuanHeGiaDinh(quanHeGiaDinhSefvice.themThongTin(cu))), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/quan-he-gia-dinh/{id}")
    public ResponseEntity<ResDTO<ResQuanHeGiaDinh>> sua_quan_he_gia_dinh(@PathVariable int id, @RequestBody ReqQuanHeGiaDinh cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResQuanHeGiaDinh.mapToResQuanHeGiaDinh(quanHeGiaDinhSefvice.suaThongTin(id, cu))), HttpStatus.OK);

    }

    @DeleteMapping("/ca-nhan/quan-he-gia-dinh/{id}")
    public ResponseEntity<ResDTO<Boolean>> xoa_quan_he_gia_dinh(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, quanHeGiaDinhSefvice.xoaThongTin(id)), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/{id}/quan-he-gia-dinh")
    public ResponseEntity<ResDTO<List<ResQuanHeGiaDinh>>> nhanvien_quan_he_gia_dinh(@PathVariable String id) {
        List<ResQuanHeGiaDinh> gia = quanHeGiaDinhSefvice.xemDanhSach(id).stream().map(ResQuanHeGiaDinh::mapToResQuanHeGiaDinh).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, gia), HttpStatus.OK);
    }
    //=======================================================

    @GetMapping("/ca-nhan/qua-trinh-cong-tac")
    public ResponseEntity<ResDTO<List<ResQuaTrinhCongTac>>> qua_trinh_cong_tac() {
        List<ResQuaTrinhCongTac> tac = quaTrinhCongTacSefvice.xemDanhSachThongTin().stream().map(ResQuaTrinhCongTac::mapToResQuaTrinhCongTac).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tac), HttpStatus.OK);
    }

    @GetMapping("/ca-nhan/qua-trinh-cong-tac/{id}")
    public ResponseEntity<ResDTO<ResQuaTrinhCongTac>> id_qua_trinh_cong_tac(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResQuaTrinhCongTac.mapToResQuaTrinhCongTac(quaTrinhCongTacSefvice.xemThongTin(id))), HttpStatus.OK);
    }

    @PostMapping("/ca-nhan/qua-trinh-cong-tac")
    public ResponseEntity<ResDTO<ResQuaTrinhCongTac>> them_qua_trinh_cong_tac(@RequestBody ReqQuaTrinhCongTac cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResQuaTrinhCongTac.mapToResQuaTrinhCongTac(quaTrinhCongTacSefvice.themThongTin(cu))), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/qua-trinh-cong-tac/{id}")
    public ResponseEntity<ResDTO<ResQuaTrinhCongTac>> sua_qua_trinh_cong_tac(@PathVariable int id, @RequestBody ReqQuaTrinhCongTac cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResQuaTrinhCongTac.mapToResQuaTrinhCongTac(quaTrinhCongTacSefvice.suaThongTin(id, cu))), HttpStatus.OK);
    }

    @DeleteMapping("/ca-nhan/qua-trinh-cong-tac/{id}")
    public ResponseEntity<ResDTO<Boolean>> xoa_qua_trinh_cong_tac(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, quaTrinhCongTacSefvice.xoaThongTin(id)), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/{id}/qua-trinh-cong-tac")
    public ResponseEntity<ResDTO<List<ResQuaTrinhCongTac>>> nhanvien_qua_trinh_cong_tac(@PathVariable String id) {
        List<ResQuaTrinhCongTac> tac = quaTrinhCongTacSefvice.xemDanhSach(id).stream().map(ResQuaTrinhCongTac::mapToResQuaTrinhCongTac).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tac), HttpStatus.OK);
    }
    //=======================================================

    @GetMapping("/ca-nhan/tin-hoc")
    public ResponseEntity<ResDTO<List<ResTinHoc>>> tin_hoc() {
        List<ResTinHoc> tin = tinHocSefvice.xemDanhSachThongTin().stream().map(ResTinHoc::mapToResTinHoc).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tin), HttpStatus.OK);
    }

    @GetMapping("/ca-nhan/tin-hoc/{id}")
    public ResponseEntity<ResDTO<ResTinHoc>> id_tin_hoc(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResTinHoc.mapToResTinHoc(tinHocSefvice.xemThongTin(id))), HttpStatus.OK);
    }

    @PostMapping("/ca-nhan/tin-hoc")
    public ResponseEntity<ResDTO<ResTinHoc>> them_tin_hoc(@RequestBody ReqTinHoc cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResTinHoc.mapToResTinHoc(tinHocSefvice.themThongTin(cu))), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/tin-hoc/{id}")
    public ResponseEntity<ResDTO<ResTinHoc>> sua_tin_hoc(@PathVariable int id, @RequestBody ReqTinHoc cu) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResTinHoc.mapToResTinHoc(tinHocSefvice.suaThongTin(id, cu))), HttpStatus.OK);
    }

    @DeleteMapping("/ca-nhan/tin-hoc/{id}")
    public ResponseEntity<ResDTO<Boolean>> xoa_tin_hoc(@PathVariable int id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tinHocSefvice.xoaThongTin(id)), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/{id}/tin-hoc")
    public ResponseEntity<ResDTO<List<ResTinHoc>>> nhanvien_tin_hoc(@PathVariable String id) {
        List<ResTinHoc> tin = tinHocSefvice.xemDanhSach(id).stream().map(ResTinHoc::mapToResTinHoc).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tin), HttpStatus.OK);
    }
}
