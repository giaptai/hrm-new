package sgu.hrm.module_heso_luong.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_heso_luong.models.HeSoLuongCongChuc;
import sgu.hrm.module_heso_luong.models.HeSoLuongVienChuc;
import sgu.hrm.module_heso_luong.models.LoaiCongChuc;
import sgu.hrm.module_heso_luong.models.LoaiVienChuc;
import sgu.hrm.module_heso_luong.models.NhomLoaiCongChuc;
import sgu.hrm.module_heso_luong.models.NhomLoaiVienChuc;
import sgu.hrm.module_heso_luong.models.response.ResHeSoLuongCongChuc;
import sgu.hrm.module_heso_luong.models.response.ResHeSoLuongVienChuc;
import sgu.hrm.module_heso_luong.services.IHeSoLuongService;
import sgu.hrm.module_response.ResDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor // create constructor if field set final or @not null
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HeSoLuongController {
    final IHeSoLuongService.ILoaiCongChucService loaiCongChucService;
    final IHeSoLuongService.ILoaiVienChucService loaiVienChucService;
    final IHeSoLuongService.INhomLoaiCongChucService nhomLoaiCongChucService;
    final IHeSoLuongService.INhomLoaiVienChucService nhomLoaiVienChucService;
    final IHeSoLuongService.IHeSoLuongCongChucService heSoLuongCongChucService;
    final IHeSoLuongService.IHeSoLuongVienChucService heSoLuongVienChucService;

    ///LOAI
    @GetMapping("/loai-cong-chuc")
    public ResDTO<List<LoaiCongChuc>> getAllLoaiCongChuc() {
        return loaiCongChucService.xemLoaiCongChuc();
    }
    @GetMapping("/loai-vien-chuc")
    public ResDTO<List<LoaiVienChuc>> getAllLoaiVienChuc() {
        return loaiVienChucService.xemLoaiVienChuc();
    }
    ///NHOM LOAI
    @GetMapping("/nhom-loai-cong-chuc")
    public ResDTO<List<NhomLoaiCongChuc>> getAllNhomLoaiCongChuc() {
        return nhomLoaiCongChucService.xemNhomLoaiCongChuc();
    }
    @GetMapping("/nhom-loai-vien-chuc")
    public ResDTO<List<NhomLoaiVienChuc>> getAllNhomLoaiVienChuc() {
        return nhomLoaiVienChucService.xemNhomLoaiVienChuc();
    }

    /// HE SO
    @GetMapping("/he-so-luong-cong-chuc")
    public ResDTO<List<ResHeSoLuongCongChuc>> getAllHeSoLuongCongChuc() {
        return heSoLuongCongChucService.xemHeSoLuongCongChuc();
    }
    @GetMapping("/he-so-luong-vien-chuc")
    public ResDTO<List<ResHeSoLuongVienChuc>> getAllHeSoLuongVienChuc() {
        return heSoLuongVienChucService.xemHeSoLuongVienChuc();
    }
}
