package sgu.hrm.module_cauhinh.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgu.hrm.module_cauhinh.services.ILoaiNhomHeSoNgachService;
import sgu.hrm.response.ResDTO;

import sgu.hrm.response.ResEnum;
import sgu.hrm.module_cauhinh.PhanTrang;
import sgu.hrm.module_cauhinh.dto.request.ReqHeSoLuong;
import sgu.hrm.module_cauhinh.dto.request.ReqLoai;
import sgu.hrm.module_cauhinh.dto.request.ReqNgach;
import sgu.hrm.module_cauhinh.dto.request.ReqNhom;
import sgu.hrm.module_cauhinh.models.BacLuong;
//import sgu.hrm.module_utilities.models.BoCoQuan;
import sgu.hrm.module_cauhinh.models.CapBacLoaiQuanHamQuanDoi;
//import sgu.hrm.module_utilities.models.CapNhomChucDanhDang;
import sgu.hrm.module_cauhinh.models.ChucDanhDang;
import sgu.hrm.module_cauhinh.models.ChucVu;
import sgu.hrm.module_cauhinh.models.CoQuanToChucDonVi;
import sgu.hrm.module_cauhinh.models.DanToc;
import sgu.hrm.module_cauhinh.models.DanhHieuNhaNuoc;
import sgu.hrm.module_cauhinh.models.DoiTuongChinhSach;
//import sgu.hrm.module_utilities.models.DonVi;
import sgu.hrm.module_cauhinh.models.HeSoLuongCongChuc;
import sgu.hrm.module_cauhinh.models.HeSoLuongVienChuc;
import sgu.hrm.module_cauhinh.models.HinhThucKhenThuong;
import sgu.hrm.module_cauhinh.models.HocHam;
//import sgu.hrm.module_utilities.models.LoaiQuanHamQuanDoi;
import sgu.hrm.module_cauhinh.models.LoaiCongChuc;
import sgu.hrm.module_cauhinh.models.LoaiPhuCap;
import sgu.hrm.module_cauhinh.models.LoaiVienChuc;
import sgu.hrm.module_cauhinh.models.MoiQuanHe;
//import sgu.hrm.module_utilities.models.NhomChucDanhDang;
import sgu.hrm.module_cauhinh.models.NgachCongChuc;
import sgu.hrm.module_cauhinh.models.NgachVienChuc;
import sgu.hrm.module_cauhinh.models.NhomCongChuc;
import sgu.hrm.module_cauhinh.models.NhomMau;
import sgu.hrm.module_cauhinh.models.NhomVienChuc;
import sgu.hrm.module_cauhinh.models.ThanhPhanGiaDinh;
import sgu.hrm.module_cauhinh.models.TonGiao;
import sgu.hrm.module_cauhinh.models.TrinhDoChuyenMon;
import sgu.hrm.module_cauhinh.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.module_cauhinh.models.ViTriViecLam;
import sgu.hrm.module_cauhinh.dto.request.ReqUtilities;
import sgu.hrm.module_cauhinh.dto.response.ResCapBacLoaiHamQuanDoi;
//import sgu.hrm.module_utilities.models.response.ResCapNhomChucDanhDang;
import sgu.hrm.module_cauhinh.dto.response.ResChucDanhDang;
import sgu.hrm.module_cauhinh.services.IUtilitiesService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UtilitiesController {
    private final IUtilitiesService<BacLuong, ReqUtilities> bacLuongService;
    private final IUtilitiesService<CapBacLoaiQuanHamQuanDoi, ReqUtilities> capBacLoaiQuanHamQuanDoiService;
    //    private final IUtilitiesService<CapNhomChucDanhDang, ReqUtilities> capNhomChucDanhDangService;
    private final IUtilitiesService<ChucDanhDang, ReqUtilities> chucDanhDangService;
    private final IUtilitiesService<ChucVu, ReqUtilities> chucVuService;
    private final IUtilitiesService<CoQuanToChucDonVi, ReqUtilities> coQuanToChucDonViService;
    //    private final IUtilitiesService<BoCoQuan, ReqUtilities> boCoQuanService;
//    private final IUtilitiesService<DonVi, ReqUtilities> donViService;
    private final IUtilitiesService<DanhHieuNhaNuoc, ReqUtilities> danhHieuNhaNuocPhongTangService;
    private final IUtilitiesService<DanToc, ReqUtilities> danTocService;
    private final IUtilitiesService<DoiTuongChinhSach, ReqUtilities> doiTuongChinhSachService;
    private final IUtilitiesService<HinhThucKhenThuong, ReqUtilities> hinhThucKhenThuongService;
    private final IUtilitiesService<HocHam, ReqUtilities> hocHamService;
    private final IUtilitiesService<LoaiPhuCap, ReqUtilities> loaiPhuCapService;
    //    private final IUtilitiesService<LoaiQuanHamQuanDoi, ReqUtilities> loaiQuanHamQuanDoiService;
    private final IUtilitiesService<MoiQuanHe, ReqUtilities> moiQuanHeService;
    //    private final IUtilitiesService<NhomChucDanhDang, ReqUtilities> nhomChucDanhDangService;
    private final IUtilitiesService<NhomMau, ReqUtilities> nhomMauService;
    private final IUtilitiesService<ThanhPhanGiaDinh, ReqUtilities> thanhPhanGiaDinhService;
    private final IUtilitiesService<TonGiao, ReqUtilities> tonGiaoService;
    private final IUtilitiesService<TrinhDoChuyenMon, ReqUtilities> trinhDoChuyenMonService;
    private final IUtilitiesService<TrinhDoGiaoDucPhoThong, ReqUtilities> trinhDoGiaoDucPhoThongService;
    private final IUtilitiesService<ViTriViecLam, ReqUtilities> viTriViecLamService;
    //LOAI-NHOM-HESO-NGACH
    private final ILoaiNhomHeSoNgachService.ILoaiCongChucService congChucService;
    private final ILoaiNhomHeSoNgachService.ILoaiVienChucService vienChucService;
    private final ILoaiNhomHeSoNgachService.INhomCongChucService nhomCongChucService;
    private final ILoaiNhomHeSoNgachService.INhomVienChucService nhomVienChucService;
    private final ILoaiNhomHeSoNgachService.IHeSoLuongCongChucService heSoLuongCongChucService;
    private final ILoaiNhomHeSoNgachService.IHeSoLuongVienChucService heSoLuongVienChucService;
    private final ILoaiNhomHeSoNgachService.INgachCongChucService ngachCongChucService;
    private final ILoaiNhomHeSoNgachService.INgachVienChucService ngachVienChucService;

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class BacLuongController {
        @GetMapping("/bac-luong")
        public ResponseEntity<ResDTO<List<BacLuong>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, bacLuongService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/bac-luong/{id}")
        public ResponseEntity<ResDTO<BacLuong>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, bacLuongService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/bac-luong")
        public ResponseEntity<ResDTO<BacLuong>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, bacLuongService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        // khong co requestbody van ok, van hieu do la request body
        @PatchMapping("/bac-luong/{id}")
        public ResponseEntity<ResDTO<BacLuong>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, bacLuongService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/bac-luong/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, bacLuongService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class CapBacLoaiQuanHamQuanDoiController {
        @GetMapping("/cap-bac-loai-quan-ham-quan-doi")
        public ResponseEntity<ResDTO<List<ResCapBacLoaiHamQuanDoi>>> getAll() {
            List<ResCapBacLoaiHamQuanDoi> resCapBacLoaiHamQuanDois = capBacLoaiQuanHamQuanDoiService.xemDS().stream().map(ResCapBacLoaiHamQuanDoi::mapToResCapBacLoaiHamQuanDoi).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resCapBacLoaiHamQuanDois), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/cap-bac-loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<ResCapBacLoaiHamQuanDoi>> getById(@PathVariable int id) {
            ResCapBacLoaiHamQuanDoi resCapBacLoaiHamQuanDoi = ResCapBacLoaiHamQuanDoi.mapToResCapBacLoaiHamQuanDoi(capBacLoaiQuanHamQuanDoiService.xemTheoId(id).orElse(null));
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resCapBacLoaiHamQuanDoi), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/cap-bac-loai-quan-ham-quan-doi")
        public ResponseEntity<ResDTO<ResCapBacLoaiHamQuanDoi>> add(@RequestBody ReqUtilities utilities) {
            ResCapBacLoaiHamQuanDoi resCapBacLoaiHamQuanDoi = ResCapBacLoaiHamQuanDoi.mapToResCapBacLoaiHamQuanDoi(capBacLoaiQuanHamQuanDoiService.them(utilities));
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, resCapBacLoaiHamQuanDoi), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/cap-bac-loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<ResCapBacLoaiHamQuanDoi>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            ResCapBacLoaiHamQuanDoi resCapBacLoaiHamQuanDoi = ResCapBacLoaiHamQuanDoi.mapToResCapBacLoaiHamQuanDoi(capBacLoaiQuanHamQuanDoiService.sua(id, luong));
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, resCapBacLoaiHamQuanDoi), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/cap-bac-loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, capBacLoaiQuanHamQuanDoiService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

//    @RestController
//    class CapNhomChucDanhDangController {
//        @GetMapping("/cap-nhom-chuc-danh-dang")
//        public ResponseEntity<ResDTO<List<ResCapNhomChucDanhDang>>> getAll() {
//            List<ResCapNhomChucDanhDang> resCapNhomChucDanhDangs = capNhomChucDanhDangService.xemDS().stream().map(ResCapNhomChucDanhDang::mapToResCapNhomChucDanhDang).toList();
//            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resCapNhomChucDanhDangs), HttpStatus.OK);
//        }
//
//        @GetMapping("/cap-nhom-chuc-danh-dang/{id}")
//        public ResponseEntity<ResDTO<ResCapNhomChucDanhDang>> getById(@PathVariable int id) {
//            ResCapNhomChucDanhDang resCapNhomChucDanhDang = ResCapNhomChucDanhDang.mapToResCapNhomChucDanhDang(capNhomChucDanhDangService.xemTheoId(id).orElse(null));
//            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resCapNhomChucDanhDang), HttpStatus.OK);
//        }
//
//        @PostMapping("/cap-nhom-chuc-danh-dang")
//        public ResponseEntity<ResDTO<ResCapNhomChucDanhDang>> add(@RequestBody ReqUtilities utilities) {
//            ResCapNhomChucDanhDang resCapNhomChucDanhDang = ResCapNhomChucDanhDang.mapToResCapNhomChucDanhDang(capNhomChucDanhDangService.them(utilities));
//            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, resCapNhomChucDanhDang), HttpStatus.OK);
//        }
//
//        // khong co requestbody van ok, van hieu do la request body
//        @PatchMapping("/cap-nhom-chuc-danh-dang/{id}")
//        public ResponseEntity<ResDTO<ResCapNhomChucDanhDang>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
//            ResCapNhomChucDanhDang resCapNhomChucDanhDang = ResCapNhomChucDanhDang.mapToResCapNhomChucDanhDang(capNhomChucDanhDangService.sua(id, luong));
//            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, resCapNhomChucDanhDang), HttpStatus.OK);
//        }
//
//        @DeleteMapping("/cap-nhom-chuc-danh-dang/{id}")
//        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, capNhomChucDanhDangService.xoa(id)), HttpStatus.OK);
//        }
//    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class ChucDanhDangController {
        @GetMapping("/chuc-danh-dang")
        public ResponseEntity<ResDTO<List<ResChucDanhDang>>> getAll() {
            List<ResChucDanhDang> resChucDanhDangs = chucDanhDangService.xemDS().stream().map(ResChucDanhDang::mapToResChucDanhDang).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resChucDanhDangs), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<ResChucDanhDang>> getById(@PathVariable int id) {
            ResChucDanhDang resChucDanhDang = ResChucDanhDang.mapToResChucDanhDang(chucDanhDangService.xemTheoId(id).orElse(null));
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resChucDanhDang), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/chuc-danh-dang")
        public ResponseEntity<ResDTO<ResChucDanhDang>> add(@RequestBody ReqUtilities utilities) {
            ResChucDanhDang resChucDanhDang = ResChucDanhDang.mapToResChucDanhDang(chucDanhDangService.them(utilities));
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, resChucDanhDang), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<ResChucDanhDang>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            ResChucDanhDang resChucDanhDang = ResChucDanhDang.mapToResChucDanhDang(chucDanhDangService.sua(id, luong));
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, resChucDanhDang), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, chucDanhDangService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class ChucVuController {
        @GetMapping("/chuc-vu")
        public ResponseEntity<ResDTO<List<ChucVu>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, chucVuService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/chuc-vu/{id}")
        public ResponseEntity<ResDTO<ChucVu>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, chucVuService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/chuc-vu")
        public ResponseEntity<ResDTO<ChucVu>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, chucVuService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/chuc-vu/{id}")
        public ResponseEntity<ResDTO<ChucVu>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, chucVuService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/chuc-vu/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, chucVuService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class CoQuanToChucDonViController {
        @GetMapping("/coquan-tochuc-donvi")
        public ResponseEntity<ResDTO<List<CoQuanToChucDonVi>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, coQuanToChucDonViService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/coquan-tochuc-donvi/{id}")
        public ResponseEntity<ResDTO<CoQuanToChucDonVi>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, coQuanToChucDonViService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/coquan-tochuc-donvi")
        public ResponseEntity<ResDTO<CoQuanToChucDonVi>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, coQuanToChucDonViService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/coquan-tochuc-donvi/{id}")
        public ResponseEntity<ResDTO<CoQuanToChucDonVi>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, coQuanToChucDonViService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/coquan-tochuc-donvi/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, coQuanToChucDonViService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

//    @RestController
//    class BoCoQuanController {
//        @GetMapping("/bo-coquan")
//        public ResponseEntity<ResDTO<List<BoCoQuan>>> getAll() {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, boCoQuanService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
//        }
//
//        @GetMapping("/bo-coquan/{id}")
//        public ResponseEntity<ResDTO<BoCoQuan>> getById(@PathVariable int id) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, boCoQuanService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
//        }
//
//        @PostMapping("/bo-coquan")
//        public ResponseEntity<ResDTO<BoCoQuan>> add(@RequestBody ReqUtilities utilities) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, boCoQuanService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
//        }
//
//        @PatchMapping("/bo-coquan/{id}")
//        public ResponseEntity<ResDTO<BoCoQuan>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, boCoQuanService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
//        }
//
//        @DeleteMapping("/bo-coquan/{id}")
//        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, boCoQuanService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
//        }
//    }

//    @RestController
//    class DonViController {
//        @GetMapping("/don-vi")
//        public ResponseEntity<ResDTO<List<DonVi>>> getAll() {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, donViService.xemDS()), HttpStatus.OK);
//        }
//
//        @GetMapping("/don-vi/{id}")
//        public ResponseEntity<ResDTO<DonVi>> getById(@PathVariable int id) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, donViService.xemTheoId(id).orElse(null)), HttpStatus.OK);
//        }
//
//        @PostMapping("/don-vi")
//        public ResponseEntity<ResDTO<DonVi>> add(@RequestBody ReqUtilities utilities) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, donViService.them(utilities)), HttpStatus.OK);
//        }
//
//        @PatchMapping("/don-vi/{id}")
//        public ResponseEntity<ResDTO<DonVi>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, donViService.sua(id, luong)), HttpStatus.OK);
//        }
//
//        @DeleteMapping("/don-vi/{id}")
//        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, donViService.xoa(id)), HttpStatus.OK);
//        }
//    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class DanhHieuNhaNuocPhongTangController {
        @GetMapping("/danh-hieu-nha-nuoc-phong")
        public ResponseEntity<ResDTO<List<DanhHieuNhaNuoc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danhHieuNhaNuocPhongTangService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/danh-hieu-nha-nuoc-phong/{id}")
        public ResponseEntity<ResDTO<DanhHieuNhaNuoc>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danhHieuNhaNuocPhongTangService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/danh-hieu-nha-nuoc-phong")
        public ResponseEntity<ResDTO<DanhHieuNhaNuoc>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, danhHieuNhaNuocPhongTangService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/danh-hieu-nha-nuoc-phong/{id}")
        public ResponseEntity<ResDTO<DanhHieuNhaNuoc>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, danhHieuNhaNuocPhongTangService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/danh-hieu-nha-nuoc-phong/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, danhHieuNhaNuocPhongTangService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class DanTocController {
        private PhanTrang<DanToc> phanTrang = new PhanTrang<>();

        @GetMapping("/dan-toc")
        public ResponseEntity<ResDTO<List<DanToc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danTocService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/dan-toc/{id}")
        public ResponseEntity<ResDTO<DanToc>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danTocService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/dan-toc")
        public ResponseEntity<ResDTO<DanToc>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, danTocService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/dan-toc/{id}")
        public ResponseEntity<ResDTO<DanToc>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, danTocService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/dan-toc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, danTocService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class DoiTuongChinhSachController {
        @GetMapping("/doi-tuong-chinh-sach")
        public ResponseEntity<ResDTO<List<DoiTuongChinhSach>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, doiTuongChinhSachService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/doi-tuong-chinh-sach/{id}")
        public ResponseEntity<ResDTO<DoiTuongChinhSach>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, doiTuongChinhSachService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/doi-tuong-chinh-sach")
        public ResponseEntity<ResDTO<DoiTuongChinhSach>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, doiTuongChinhSachService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/doi-tuong-chinh-sach/{id}")
        public ResponseEntity<ResDTO<DoiTuongChinhSach>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, doiTuongChinhSachService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/doi-tuong-chinh-sach/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, doiTuongChinhSachService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    //
    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class HinhThucKhenThuongController {
        @GetMapping("/hinh-thuc-khen-thuong")
        public ResponseEntity<ResDTO<List<HinhThucKhenThuong>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, hinhThucKhenThuongService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/hinh-thuc-khen-thuong/{id}")
        public ResponseEntity<ResDTO<HinhThucKhenThuong>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, hinhThucKhenThuongService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/hinh-thuc-khen-thuong")
        public ResponseEntity<ResDTO<HinhThucKhenThuong>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, hinhThucKhenThuongService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/hinh-thuc-khen-thuong/{id}")
        public ResponseEntity<ResDTO<HinhThucKhenThuong>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, hinhThucKhenThuongService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/hinh-thuc-khen-thuong/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, hinhThucKhenThuongService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class HocHamController {
        @GetMapping("/hoc-ham")
        public ResponseEntity<ResDTO<List<HocHam>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, hocHamService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/hoc-ham/{id}")
        public ResponseEntity<ResDTO<HocHam>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, hocHamService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/hoc-ham")
        public ResponseEntity<ResDTO<HocHam>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, hocHamService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/hoc-ham/{id}")
        public ResponseEntity<ResDTO<HocHam>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, hocHamService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/hoc-ham/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, hocHamService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class LoaiPhuCapController {
        @GetMapping("/loai-phu-cap")
        public ResponseEntity<ResDTO<List<LoaiPhuCap>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, loaiPhuCapService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/loai-phu-cap/{id}")
        public ResponseEntity<ResDTO<LoaiPhuCap>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, loaiPhuCapService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/loai-phu-cap")
        public ResponseEntity<ResDTO<LoaiPhuCap>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, loaiPhuCapService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/loai-phu-cap/{id}")
        public ResponseEntity<ResDTO<LoaiPhuCap>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, loaiPhuCapService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/loai-phu-cap/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, loaiPhuCapService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

//    @RestController
//    class LoaiQuanHamQuanDoiController {
//        @GetMapping("/loai-quan-ham-quan-doi")
//        public ResponseEntity<ResDTO<List<LoaiQuanHamQuanDoi>>> getAll() {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, loaiQuanHamQuanDoiService.xemDS()), HttpStatus.OK);
//        }
//
//        @GetMapping("/loai-quan-ham-quan-doi/{id}")
//        public ResponseEntity<ResDTO<LoaiQuanHamQuanDoi>> getById(@PathVariable int id) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, loaiQuanHamQuanDoiService.xemTheoId(id).orElse(null)), HttpStatus.OK);
//        }
//
//        @PostMapping("/loai-quan-ham-quan-doi")
//        public ResponseEntity<ResDTO<LoaiQuanHamQuanDoi>> add(@RequestBody ReqUtilities utilities) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, loaiQuanHamQuanDoiService.them(utilities)), HttpStatus.OK);
//        }
//
//        @PatchMapping("/loai-quan-ham-quan-doi/{id}")
//        public ResponseEntity<ResDTO<LoaiQuanHamQuanDoi>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, loaiQuanHamQuanDoiService.sua(id, luong)), HttpStatus.OK);
//        }
//
//        @DeleteMapping("/loai-quan-ham-quan-doi/{id}")
//        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, loaiQuanHamQuanDoiService.xoa(id)), HttpStatus.OK);
//        }
//    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class MoiQuanHeController {
        @GetMapping("/moi-quan-he")
        public ResponseEntity<ResDTO<List<MoiQuanHe>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, moiQuanHeService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/moi-quan-he/{id}")
        public ResponseEntity<ResDTO<MoiQuanHe>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, moiQuanHeService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/moi-quan-he")
        public ResponseEntity<ResDTO<MoiQuanHe>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, moiQuanHeService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/moi-quan-he/{id}")
        public ResponseEntity<ResDTO<MoiQuanHe>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, moiQuanHeService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/moi-quan-he/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, moiQuanHeService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

//    @RestController
//    class NhomChucDanhDangController {
//        @GetMapping("/nhom-chuc-danh-dang")
//        public ResponseEntity<ResDTO<List<NhomChucDanhDang>>> getAll() {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomChucDanhDangService.xemDS()), HttpStatus.OK);
//        }
//
//        @GetMapping("/nhom-chuc-danh-dang/{id}")
//        public ResponseEntity<ResDTO<NhomChucDanhDang>> getById(@PathVariable int id) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomChucDanhDangService.xemTheoId(id).orElse(null)), HttpStatus.OK);
//        }
//
//        @PostMapping("/nhom-chuc-danh-dang")
//        public ResponseEntity<ResDTO<NhomChucDanhDang>> add(@RequestBody ReqUtilities utilities) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, nhomChucDanhDangService.them(utilities)), HttpStatus.OK);
//        }
//
//        @PatchMapping("/nhom-chuc-danh-dang/{id}")
//        public ResponseEntity<ResDTO<NhomChucDanhDang>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, nhomChucDanhDangService.sua(id, luong)), HttpStatus.OK);
//        }
//
//        @DeleteMapping("/nhom-chuc-danh-dang/{id}")
//        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
//            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, nhomChucDanhDangService.xoa(id)), HttpStatus.OK);
//        }
//    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class NhomMauController {
        @GetMapping("/nhom-mau")
        public ResponseEntity<ResDTO<List<NhomMau>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomMauService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/nhom-mau/{id}")
        public ResponseEntity<ResDTO<NhomMau>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomMauService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/nhom-mau")
        public ResponseEntity<ResDTO<NhomMau>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, nhomMauService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/nhom-mau/{id}")
        public ResponseEntity<ResDTO<NhomMau>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, nhomMauService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/nhom-mau/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, nhomMauService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class ThanhPhanGiaDinhController {
        @GetMapping("/thanh-phan-gia-dinh")
        public ResponseEntity<ResDTO<List<ThanhPhanGiaDinh>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, thanhPhanGiaDinhService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/thanh-phan-gia-dinh/{id}")
        public ResponseEntity<ResDTO<ThanhPhanGiaDinh>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, thanhPhanGiaDinhService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/thanh-phan-gia-dinh")
        public ResponseEntity<ResDTO<ThanhPhanGiaDinh>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, thanhPhanGiaDinhService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/thanh-phan-gia-dinh/{id}")
        public ResponseEntity<ResDTO<ThanhPhanGiaDinh>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, thanhPhanGiaDinhService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/thanh-phan-gia-dinh/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, thanhPhanGiaDinhService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class TonGiaoController {
        @GetMapping("/ton-giao")
        public ResponseEntity<ResDTO<List<TonGiao>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tonGiaoService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/ton-giao/{id}")
        public ResponseEntity<ResDTO<TonGiao>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tonGiaoService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/ton-giao")
        public ResponseEntity<ResDTO<TonGiao>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, tonGiaoService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/ton-giao/{id}")
        public ResponseEntity<ResDTO<TonGiao>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, tonGiaoService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/ton-giao/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, tonGiaoService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class TrinhDoChuyenMonController {
        @GetMapping("/trinh-do-chuyen-mon")
        public ResponseEntity<ResDTO<List<TrinhDoChuyenMon>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, trinhDoChuyenMonService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/trinh-do-chuyen-mon/{id}")
        public ResponseEntity<ResDTO<TrinhDoChuyenMon>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, trinhDoChuyenMonService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/trinh-do-chuyen-mon")
        public ResponseEntity<ResDTO<TrinhDoChuyenMon>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, trinhDoChuyenMonService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/trinh-do-chuyen-mon/{id}")
        public ResponseEntity<ResDTO<TrinhDoChuyenMon>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, trinhDoChuyenMonService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/trinh-do-chuyen-mon/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, trinhDoChuyenMonService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class TrinhDoGiaoDucPhoThongController {
        @GetMapping("/trinh-do-giao-duc-pho-thong")
        public ResponseEntity<ResDTO<List<TrinhDoGiaoDucPhoThong>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, trinhDoGiaoDucPhoThongService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/trinh-do-giao-duc-pho-thong/{id}")
        public ResponseEntity<ResDTO<TrinhDoGiaoDucPhoThong>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, trinhDoGiaoDucPhoThongService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/trinh-do-giao-duc-pho-thong")
        public ResponseEntity<ResDTO<TrinhDoGiaoDucPhoThong>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, trinhDoGiaoDucPhoThongService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/trinh-do-giao-duc-pho-thong/{id}")
        public ResponseEntity<ResDTO<TrinhDoGiaoDucPhoThong>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, trinhDoGiaoDucPhoThongService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/trinh-do-giao-duc-pho-thong/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, trinhDoGiaoDucPhoThongService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class ViTriViecLamController {
        @GetMapping("/vi-tri-viec-lam")
        public ResponseEntity<ResDTO<List<ViTriViecLam>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, viTriViecLamService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/vi-tri-viec-lam/{id}")
        public ResponseEntity<ResDTO<ViTriViecLam>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, viTriViecLamService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/vi-tri-viec-lam")
        public ResponseEntity<ResDTO<ViTriViecLam>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, viTriViecLamService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/vi-tri-viec-lam/{id}")
        public ResponseEntity<ResDTO<ViTriViecLam>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, viTriViecLamService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/vi-tri-viec-lam/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, viTriViecLamService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class LoaiCongChucController {
        @GetMapping("/loai-cong-chuc")
        public ResponseEntity<ResDTO<List<LoaiCongChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, congChucService.xemLoaiCongChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/loai-cong-chuc")
        public ResponseEntity<ResDTO<LoaiCongChuc>> add(@RequestBody ReqLoai loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, congChucService.themLoaiCongChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/loai-cong-chuc/{id}")
        public ResponseEntity<ResDTO<LoaiCongChuc>> edit(@PathVariable int id, @RequestBody ReqLoai loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, congChucService.suaLoaiCongChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/loai-cong-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, congChucService.xoaLoaiCongChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class LoaiVienChucController {
        @GetMapping("/loai-vien-chuc")
        public ResponseEntity<ResDTO<List<LoaiVienChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, vienChucService.xemLoaiVienChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/loai-vien-chuc")
        public ResponseEntity<ResDTO<LoaiVienChuc>> add(@RequestBody ReqLoai loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, vienChucService.themLoaiVienChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/loai-vien-chuc/{id}")
        public ResponseEntity<ResDTO<LoaiVienChuc>> edit(@PathVariable int id, @RequestBody ReqLoai loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, vienChucService.suaLoaiVienChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/loai-vien-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, vienChucService.xoaLoaiVienChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class NhomCongChucController {
        @GetMapping("/nhom-cong-chuc")
        public ResponseEntity<ResDTO<List<NhomCongChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomCongChucService.xemNhomCongChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/nhom-cong-chuc")
        public ResponseEntity<ResDTO<NhomCongChuc>> add(@RequestBody ReqNhom loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, nhomCongChucService.themNhomCongChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/nhom-cong-chuc/{id}")
        public ResponseEntity<ResDTO<NhomCongChuc>> edit(@PathVariable int id, @RequestBody ReqNhom loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, nhomCongChucService.suaNhomCongChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/nhom-cong-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, nhomCongChucService.xoaNhomCongChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class NhomVienChucController {
        @GetMapping("/nhom-vien-chuc")
        public ResponseEntity<ResDTO<List<NhomVienChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomVienChucService.xemNhomVienChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/nhom-vien-chuc")
        public ResponseEntity<ResDTO<NhomVienChuc>> add(@RequestBody ReqNhom loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, nhomVienChucService.themNhomVienChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/nhom-vien-chuc/{id}")
        public ResponseEntity<ResDTO<NhomVienChuc>> edit(@PathVariable int id, @RequestBody ReqNhom loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, nhomVienChucService.suaNhomVienChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/nhom-vien-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, nhomVienChucService.xoaNhomVienChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class HeSoLuongCongChucController {
        @GetMapping("/he-so-luong-cong-chuc")
        public ResponseEntity<ResDTO<List<HeSoLuongCongChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, heSoLuongCongChucService.xemHeSoLuongCongChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/he-so-luong-cong-chuc")
        public ResponseEntity<ResDTO<HeSoLuongCongChuc>> add(@RequestBody ReqHeSoLuong loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, heSoLuongCongChucService.themHeSoLuongCongChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/he-so-luong-cong-chuc/{id}")
        public ResponseEntity<ResDTO<HeSoLuongCongChuc>> edit(@PathVariable int id, @RequestBody ReqHeSoLuong loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, heSoLuongCongChucService.suaHeSoLuongCongChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/he-so-luong-cong-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, heSoLuongCongChucService.xoaHeSoLuongCongChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class HeSoLuongVienChucController {
        @GetMapping("/he-so-luong-vien-chuc")
        public ResponseEntity<ResDTO<List<HeSoLuongVienChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, heSoLuongVienChucService.xemHeSoLuongVienChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/he-so-luong-vien-chuc")
        public ResponseEntity<ResDTO<HeSoLuongVienChuc>> add(@RequestBody ReqHeSoLuong loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, heSoLuongVienChucService.themHeSoLuongVienChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/he-so-luong-vien-chuc/{id}")
        public ResponseEntity<ResDTO<HeSoLuongVienChuc>> edit(@PathVariable int id, @RequestBody ReqHeSoLuong loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, heSoLuongVienChucService.suaHeSoLuongVienChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/he-so-luong-vien-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, heSoLuongVienChucService.xoaHeSoLuongVienChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class NgachCongChucController {
        @GetMapping("/ngach-cong-chuc")
        public ResponseEntity<ResDTO<List<NgachCongChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ngachCongChucService.xemNgachCongChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/ngach-cong-chuc")
        public ResponseEntity<ResDTO<NgachCongChuc>> add(@RequestBody ReqNgach loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, ngachCongChucService.themNgachCongChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/ngach-cong-chuc/{id}")
        public ResponseEntity<ResDTO<NgachCongChuc>> edit(@PathVariable String id, @RequestBody ReqNgach loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, ngachCongChucService.suaNgachCongChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/ngach-cong-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable String id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, ngachCongChucService.xoaNgachCongChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cau hinh ", description = "Cấu hình")
    class NgachVienChucController {
        @GetMapping("/ngach-vien-chuc")
        public ResponseEntity<ResDTO<List<NgachVienChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ngachVienChucService.xemNgachVienChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/ngach-vien-chuc")
        public ResponseEntity<ResDTO<NgachVienChuc>> add(@RequestBody ReqNgach loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, ngachVienChucService.themNgachVienChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/ngach-vien-chuc/{id}")
        public ResponseEntity<ResDTO<NgachVienChuc>> edit(@PathVariable String id, @RequestBody ReqNgach loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, ngachVienChucService.suaNgachVienChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/ngach-vien-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable String id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, ngachVienChucService.xoaNgachVienChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }
}
