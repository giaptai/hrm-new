//package sgu.hrm.module_heso_luong_ngach.controllers;
//
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import sgu.hrm.module_heso_luong_ngach.models.LoaiCongChuc;
//import sgu.hrm.module_heso_luong_ngach.models.LoaiVienChuc;
//import sgu.hrm.module_heso_luong_ngach.models.NhomCongChuc;
//import sgu.hrm.module_heso_luong_ngach.models.NhomVienChuc;
//import sgu.hrm.module_heso_luong_ngach.models.response.ResHeSoLuongCongChuc;
//import sgu.hrm.module_heso_luong_ngach.models.response.ResHeSoLuongVienChuc;
//import sgu.hrm.module_heso_luong_ngach.services.ILoaiNhomHeSoNgachService;
//import sgu.hrm.module_response.ResDTO;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor // create constructor if field set final or @not null
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class HeSoLuongController {
//    final ILoaiNhomHeSoNgachService.ILoaiCongChucService loaiCongChucService;
//    final ILoaiNhomHeSoNgachService.ILoaiVienChucService loaiVienChucService;
//    final ILoaiNhomHeSoNgachService.INhomLoaiCongChucService nhomLoaiCongChucService;
//    final ILoaiNhomHeSoNgachService.INhomLoaiVienChucService nhomLoaiVienChucService;
//    final ILoaiNhomHeSoNgachService.IHeSoLuongCongChucService heSoLuongCongChucService;
//    final ILoaiNhomHeSoNgachService.IHeSoLuongVienChucService heSoLuongVienChucService;
//
//    ///LOAI
//    @GetMapping("/loai-cong-chuc")
//    public ResDTO<List<LoaiCongChuc>> getAllLoaiCongChuc() {
//        return loaiCongChucService.xemLoaiCongChuc();
//    }
//    @GetMapping("/loai-vien-chuc")
//    public ResDTO<List<LoaiVienChuc>> getAllLoaiVienChuc() {
//        return loaiVienChucService.xemLoaiVienChuc();
//    }
//    ///NHOM LOAI
//    @GetMapping("/nhom-cong-chuc")
//    public ResDTO<List<NhomCongChuc>> getAllNhomLoaiCongChuc() {
//        return nhomLoaiCongChucService.xemNhomLoaiCongChuc();
//    }
//    @GetMapping("/nhom-vien-chuc")
//    public ResDTO<List<NhomVienChuc>> getAllNhomLoaiVienChuc() {
//        return nhomLoaiVienChucService.xemNhomLoaiVienChuc();
//    }
//
//    /// HE SO
//    @GetMapping("/he-so-luong-cong-chuc")
//    public ResDTO<List<ResHeSoLuongCongChuc>> getAllHeSoLuongCongChuc() {
//        return heSoLuongCongChucService.xemHeSoLuongCongChuc();
//    }
//    @GetMapping("/he-so-luong-vien-chuc")
//    public ResDTO<List<ResHeSoLuongVienChuc>> getAllHeSoLuongVienChuc() {
//        return heSoLuongVienChucService.xemHeSoLuongVienChuc();
//    }
//}
