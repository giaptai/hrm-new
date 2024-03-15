package sgu.hrm.module_utilities.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sgu.hrm.module_response.ResDTO;

import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_utilities.PhanTrang;
import sgu.hrm.module_utilities.models.BacLuong;
import sgu.hrm.module_utilities.models.BoCoQuan;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.CapNhomChucDanhDang;
import sgu.hrm.module_utilities.models.ChucDanhDang;
import sgu.hrm.module_utilities.models.ChucVu;
import sgu.hrm.module_utilities.models.CoQuanToChucDonVi;
import sgu.hrm.module_utilities.models.DanToc;
import sgu.hrm.module_utilities.models.DanhHieuNhaNuoc;
import sgu.hrm.module_utilities.models.DoiTuongChinhSach;
import sgu.hrm.module_utilities.models.DonVi;
import sgu.hrm.module_utilities.models.HinhThucKhenThuong;
import sgu.hrm.module_utilities.models.HocHam;
import sgu.hrm.module_utilities.models.LoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.MoiQuanHe;
import sgu.hrm.module_utilities.models.NhomChucDanhDang;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
import sgu.hrm.module_utilities.models.TonGiao;
import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;
import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.module_utilities.models.ViTriViecLam;
import sgu.hrm.module_utilities.models.request.ReqUtilities;
import sgu.hrm.module_utilities.models.response.ResCapBacLoaiHamQuanDoi;
import sgu.hrm.module_utilities.models.response.ResCapNhomChucDanhDang;
import sgu.hrm.module_utilities.models.response.ResChucDanhDang;
import sgu.hrm.module_utilities.services.IUtilitiesService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UtilitiesController {
    private final IUtilitiesService<BacLuong, ReqUtilities> bacLuongService;
    private final IUtilitiesService<CapBacLoaiQuanHamQuanDoi, ReqUtilities> capBacLoaiQuanHamQuanDoiService;
    private final IUtilitiesService<CapNhomChucDanhDang, ReqUtilities> capNhomChucDanhDangService;
    private final IUtilitiesService<ChucDanhDang, ReqUtilities> chucDanhDangService;
    private final IUtilitiesService<ChucVu, ReqUtilities> chucVuService;
    private final IUtilitiesService<CoQuanToChucDonVi, ReqUtilities> coQuanToChucDonViService;
    private final IUtilitiesService<BoCoQuan, ReqUtilities> boCoQuanService;
    private final IUtilitiesService<DonVi, ReqUtilities> donViService;
    private final IUtilitiesService<DanhHieuNhaNuoc, ReqUtilities> danhHieuNhaNuocPhongTangService;
    private final IUtilitiesService<DanToc, ReqUtilities> danTocService;
    private final IUtilitiesService<DoiTuongChinhSach, ReqUtilities> doiTuongChinhSachService;
    private final IUtilitiesService<HinhThucKhenThuong, ReqUtilities> hinhThucKhenThuongService;
    private final IUtilitiesService<HocHam, ReqUtilities> hocHamService;
    private final IUtilitiesService<LoaiQuanHamQuanDoi, ReqUtilities> loaiQuanHamQuanDoiService;
    private final IUtilitiesService<MoiQuanHe, ReqUtilities> moiQuanHeService;
    private final IUtilitiesService<NhomChucDanhDang, ReqUtilities> nhomChucDanhDangService;
    private final IUtilitiesService<NhomMau, ReqUtilities> nhomMauService;
    private final IUtilitiesService<ThanhPhanGiaDinh, ReqUtilities> thanhPhanGiaDinhService;
    private final IUtilitiesService<TonGiao, ReqUtilities> tonGiaoService;
    private final IUtilitiesService<TrinhDoChuyenMon, ReqUtilities> trinhDoChuyenMonService;
    private final IUtilitiesService<TrinhDoGiaoDucPhoThong, ReqUtilities> trinhDoGiaoDucPhoThongService;
    private final IUtilitiesService<ViTriViecLam, ReqUtilities> viTriViecLamService;

    @RestController
    class BacLuongController {
        @GetMapping("/bac-luong")
        public ResponseEntity<ResDTO<List<BacLuong>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, bacLuongService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/bac-luong/{id}")
        public ResponseEntity<ResDTO<BacLuong>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, bacLuongService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/bac-luong")
        public ResponseEntity<ResDTO<BacLuong>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, bacLuongService.them(utilities)), HttpStatus.OK);
        }

        // khong co requestbody van ok, van hieu do la request body
        @PatchMapping("/bac-luong/{id}")
        public ResponseEntity<ResDTO<BacLuong>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, bacLuongService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/bac-luong/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, bacLuongService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class CapBacLoaiQuanHamQuanDoiController {
        @GetMapping("/cap-bac-loai-quan-ham-quan-doi")
        public ResponseEntity<ResDTO<List<ResCapBacLoaiHamQuanDoi>>> getAllCapBacLoaiQuanHamQuanDoi() {
            List<ResCapBacLoaiHamQuanDoi> resCapBacLoaiHamQuanDois = capBacLoaiQuanHamQuanDoiService.xemDS().stream().map(ResCapBacLoaiHamQuanDoi::mapToResCapBacLoaiHamQuanDoi).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resCapBacLoaiHamQuanDois), HttpStatus.OK);
        }

        @GetMapping("/cap-bac-loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<ResCapBacLoaiHamQuanDoi>> getCapBacLoaiQuanHamQuanDoiById(@PathVariable int id) {
            ResCapBacLoaiHamQuanDoi resCapBacLoaiHamQuanDoi = ResCapBacLoaiHamQuanDoi.mapToResCapBacLoaiHamQuanDoi(capBacLoaiQuanHamQuanDoiService.xemTheoId(id).orElse(null));
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resCapBacLoaiHamQuanDoi), HttpStatus.OK);
        }

        @PostMapping("/cap-bac-loai-quan-ham-quan-doi")
        public ResponseEntity<ResDTO<ResCapBacLoaiHamQuanDoi>> addCapBacLoaiQuanHamQuanDoi(@RequestBody ReqUtilities utilities) {
            ResCapBacLoaiHamQuanDoi resCapBacLoaiHamQuanDoi = ResCapBacLoaiHamQuanDoi.mapToResCapBacLoaiHamQuanDoi(capBacLoaiQuanHamQuanDoiService.them(utilities));
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, resCapBacLoaiHamQuanDoi), HttpStatus.OK);
        }

        @PatchMapping("/cap-bac-loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<ResCapBacLoaiHamQuanDoi>> editCapBacLoaiQuanHamQuanDoi(@PathVariable int id, @RequestBody ReqUtilities luong) {
            ResCapBacLoaiHamQuanDoi resCapBacLoaiHamQuanDoi = ResCapBacLoaiHamQuanDoi.mapToResCapBacLoaiHamQuanDoi(capBacLoaiQuanHamQuanDoiService.sua(id, luong));
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, resCapBacLoaiHamQuanDoi), HttpStatus.OK);
        }

        @DeleteMapping("/cap-bac-loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<Boolean>> delCapBacLoaiQuanHamQuanDoi(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, capBacLoaiQuanHamQuanDoiService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class CapNhomChucDanhDangController {
        @GetMapping("/cap-nhom-chuc-danh-dang")
        public ResponseEntity<ResDTO<List<ResCapNhomChucDanhDang>>> getAll() {
            List<ResCapNhomChucDanhDang> resCapNhomChucDanhDangs = capNhomChucDanhDangService.xemDS().stream().map(ResCapNhomChucDanhDang::mapToResCapNhomChucDanhDang).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resCapNhomChucDanhDangs), HttpStatus.OK);
        }

        @GetMapping("/cap-nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<ResCapNhomChucDanhDang>> getById(@PathVariable int id) {
            ResCapNhomChucDanhDang resCapNhomChucDanhDang = ResCapNhomChucDanhDang.mapToResCapNhomChucDanhDang(capNhomChucDanhDangService.xemTheoId(id).orElse(null));
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resCapNhomChucDanhDang), HttpStatus.OK);
        }

        @PostMapping("/cap-nhom-chuc-danh-dang")
        public ResponseEntity<ResDTO<ResCapNhomChucDanhDang>> add(@RequestBody ReqUtilities utilities) {
            ResCapNhomChucDanhDang resCapNhomChucDanhDang = ResCapNhomChucDanhDang.mapToResCapNhomChucDanhDang(capNhomChucDanhDangService.them(utilities));
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, resCapNhomChucDanhDang), HttpStatus.OK);
        }

        // khong co requestbody van ok, van hieu do la request body
        @PatchMapping("/cap-nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<ResCapNhomChucDanhDang>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            ResCapNhomChucDanhDang resCapNhomChucDanhDang = ResCapNhomChucDanhDang.mapToResCapNhomChucDanhDang(capNhomChucDanhDangService.sua(id, luong));
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, resCapNhomChucDanhDang), HttpStatus.OK);
        }

        @DeleteMapping("/cap-nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, capNhomChucDanhDangService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class ChucDanhDangController {
        @GetMapping("/chuc-danh-dang")
        public ResponseEntity<ResDTO<List<ResChucDanhDang>>> getAll() {
            List<ResChucDanhDang> resChucDanhDangs = chucDanhDangService.xemDS().stream().map(ResChucDanhDang::mapToResChucDanhDang).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resChucDanhDangs), HttpStatus.OK);
        }

        @GetMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<ResChucDanhDang>> getById(@PathVariable int id) {
            ResChucDanhDang resChucDanhDang = ResChucDanhDang.mapToResChucDanhDang(chucDanhDangService.xemTheoId(id).orElse(null));
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resChucDanhDang), HttpStatus.OK);
        }

        @PostMapping("/chuc-danh-dang")
        public ResponseEntity<ResDTO<ResChucDanhDang>> add(@RequestBody ReqUtilities utilities) {
            ResChucDanhDang resChucDanhDang = ResChucDanhDang.mapToResChucDanhDang(chucDanhDangService.them(utilities));
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, resChucDanhDang), HttpStatus.OK);
        }

        @PatchMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<ResChucDanhDang>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            ResChucDanhDang resChucDanhDang = ResChucDanhDang.mapToResChucDanhDang(chucDanhDangService.sua(id, luong));
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, resChucDanhDang), HttpStatus.OK);
        }

        @DeleteMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, chucDanhDangService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class ChucVuController {
        @GetMapping("/chuc-vu")
        public ResponseEntity<ResDTO<List<ChucVu>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, chucVuService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/chuc-vu/{id}")
        public ResponseEntity<ResDTO<ChucVu>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, chucVuService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/chuc-vu")
        public ResponseEntity<ResDTO<ChucVu>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, chucVuService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/chuc-vu/{id}")
        public ResponseEntity<ResDTO<ChucVu>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, chucVuService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/chuc-vu/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, chucVuService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class CoQuanToChucDonViController {
        @GetMapping("/coquan-tochuc-donvi")
        public ResponseEntity<ResDTO<List<CoQuanToChucDonVi>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, coQuanToChucDonViService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/coquan-tochuc-donvi/{id}")
        public ResponseEntity<ResDTO<CoQuanToChucDonVi>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, coQuanToChucDonViService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/coquan-tochuc-donvi")
        public ResponseEntity<ResDTO<CoQuanToChucDonVi>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, coQuanToChucDonViService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/coquan-tochuc-donvi/{id}")
        public ResponseEntity<ResDTO<CoQuanToChucDonVi>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, coQuanToChucDonViService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/coquan-tochuc-donvi/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, coQuanToChucDonViService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class BoCoQuanController {
        @GetMapping("/bo-coquan")
        public ResponseEntity<ResDTO<List<BoCoQuan>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, boCoQuanService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/bo-coquan/{id}")
        public ResponseEntity<ResDTO<BoCoQuan>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, boCoQuanService.xemTheoId(id).orElse(null)), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/bo-coquan")
        public ResponseEntity<ResDTO<BoCoQuan>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, boCoQuanService.them(utilities)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/bo-coquan/{id}")
        public ResponseEntity<ResDTO<BoCoQuan>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, boCoQuanService.sua(id, luong)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/bo-coquan/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, boCoQuanService.xoa(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    class DonViController {
        @GetMapping("/don-vi")
        public ResponseEntity<ResDTO<List<DonVi>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, donViService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/don-vi/{id}")
        public ResponseEntity<ResDTO<DonVi>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, donViService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/don-vi")
        public ResponseEntity<ResDTO<DonVi>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, donViService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/don-vi/{id}")
        public ResponseEntity<ResDTO<DonVi>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, donViService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/don-vi/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, donViService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class DanhHieuNhaNuocPhongTangController {
        @GetMapping("/danh-hieu-nha-nuoc-phong")
        public ResponseEntity<ResDTO<List<DanhHieuNhaNuoc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danhHieuNhaNuocPhongTangService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/danh-hieu-nha-nuoc-phong/{id}")
        public ResponseEntity<ResDTO<DanhHieuNhaNuoc>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danhHieuNhaNuocPhongTangService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/danh-hieu-nha-nuoc-phong")
        public ResponseEntity<ResDTO<DanhHieuNhaNuoc>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, danhHieuNhaNuocPhongTangService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/danh-hieu-nha-nuoc-phong/{id}")
        public ResponseEntity<ResDTO<DanhHieuNhaNuoc>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, danhHieuNhaNuocPhongTangService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/danh-hieu-nha-nuoc-phong/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, danhHieuNhaNuocPhongTangService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class DanTocController {
        private PhanTrang<DanToc> phanTrang = new PhanTrang<>();

        @GetMapping("/dan-toc")
        public ResponseEntity<ResDTO<List<DanToc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danTocService.xemDS()), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/dan-toc/{id}")
        public ResponseEntity<ResDTO<DanToc>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danTocService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/dan-toc")
        public ResponseEntity<ResDTO<DanToc>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, danTocService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/dan-toc/{id}")
        public ResponseEntity<ResDTO<DanToc>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, danTocService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/dan-toc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, danTocService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class DoiTuongChinhSachController {
        @GetMapping("/doi-tuong-chinh-sach")
        public ResponseEntity<ResDTO<List<DoiTuongChinhSach>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, doiTuongChinhSachService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/doi-tuong-chinh-sach/{id}")
        public ResponseEntity<ResDTO<DoiTuongChinhSach>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, doiTuongChinhSachService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/doi-tuong-chinh-sach")
        public ResponseEntity<ResDTO<DoiTuongChinhSach>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, doiTuongChinhSachService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/doi-tuong-chinh-sach/{id}")
        public ResponseEntity<ResDTO<DoiTuongChinhSach>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, doiTuongChinhSachService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/doi-tuong-chinh-sach/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, doiTuongChinhSachService.xoa(id)), HttpStatus.OK);
        }
    }

    //
    @RestController
    class HinhThucKhenThuongController {
        @GetMapping("/hinh-thuc-khen-thuong")
        public ResponseEntity<ResDTO<List<HinhThucKhenThuong>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, hinhThucKhenThuongService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/hinh-thuc-khen-thuong/{id}")
        public ResponseEntity<ResDTO<HinhThucKhenThuong>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, hinhThucKhenThuongService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/hinh-thuc-khen-thuong")
        public ResponseEntity<ResDTO<HinhThucKhenThuong>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, hinhThucKhenThuongService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/hinh-thuc-khen-thuong/{id}")
        public ResponseEntity<ResDTO<HinhThucKhenThuong>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, hinhThucKhenThuongService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/hinh-thuc-khen-thuong/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, hinhThucKhenThuongService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class HocHamController {
        @GetMapping("/hoc-ham")
        public ResponseEntity<ResDTO<List<HocHam>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, hocHamService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/hoc-ham/{id}")
        public ResponseEntity<ResDTO<HocHam>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, hocHamService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/hoc-ham")
        public ResponseEntity<ResDTO<HocHam>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, hocHamService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/hoc-ham/{id}")
        public ResponseEntity<ResDTO<HocHam>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, hocHamService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/hoc-ham/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, hocHamService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class LoaiQuanHamQuanDoiController {
        @GetMapping("/loai-quan-ham-quan-doi")
        public ResponseEntity<ResDTO<List<LoaiQuanHamQuanDoi>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, loaiQuanHamQuanDoiService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<LoaiQuanHamQuanDoi>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, loaiQuanHamQuanDoiService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/loai-quan-ham-quan-doi")
        public ResponseEntity<ResDTO<LoaiQuanHamQuanDoi>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, loaiQuanHamQuanDoiService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<LoaiQuanHamQuanDoi>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, loaiQuanHamQuanDoiService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, loaiQuanHamQuanDoiService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class MoiQuanHeController {
        @GetMapping("/moi-quan-he")
        public ResponseEntity<ResDTO<List<MoiQuanHe>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, moiQuanHeService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/moi-quan-he/{id}")
        public ResponseEntity<ResDTO<MoiQuanHe>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, moiQuanHeService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/moi-quan-he")
        public ResponseEntity<ResDTO<MoiQuanHe>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, moiQuanHeService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/moi-quan-he/{id}")
        public ResponseEntity<ResDTO<MoiQuanHe>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, moiQuanHeService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/moi-quan-he/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, moiQuanHeService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class NhomChucDanhDangController {
        @GetMapping("/nhom-chuc-danh-dang")
        public ResponseEntity<ResDTO<List<NhomChucDanhDang>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomChucDanhDangService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<NhomChucDanhDang>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomChucDanhDangService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/nhom-chuc-danh-dang")
        public ResponseEntity<ResDTO<NhomChucDanhDang>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, nhomChucDanhDangService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<NhomChucDanhDang>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, nhomChucDanhDangService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, nhomChucDanhDangService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class NhomMauController {
        @GetMapping("/nhom-mau")
        public ResponseEntity<ResDTO<List<NhomMau>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomMauService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/nhom-mau/{id}")
        public ResponseEntity<ResDTO<NhomMau>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomMauService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/nhom-mau")
        public ResponseEntity<ResDTO<NhomMau>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, nhomMauService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/nhom-mau/{id}")
        public ResponseEntity<ResDTO<NhomMau>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, nhomMauService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/nhom-mau/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, nhomMauService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class ThanhPhanGiaDinhController {
        @GetMapping("/thanh-phan-gia-dinh")
        public ResponseEntity<ResDTO<List<ThanhPhanGiaDinh>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, thanhPhanGiaDinhService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/thanh-phan-gia-dinh/{id}")
        public ResponseEntity<ResDTO<ThanhPhanGiaDinh>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, thanhPhanGiaDinhService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/thanh-phan-gia-dinh")
        public ResponseEntity<ResDTO<ThanhPhanGiaDinh>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, thanhPhanGiaDinhService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/thanh-phan-gia-dinh/{id}")
        public ResponseEntity<ResDTO<ThanhPhanGiaDinh>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, thanhPhanGiaDinhService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/thanh-phan-gia-dinh/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, thanhPhanGiaDinhService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class TonGiaoController {
        @GetMapping("/ton-giao")
        public ResponseEntity<ResDTO<List<TonGiao>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tonGiaoService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/ton-giao/{id}")
        public ResponseEntity<ResDTO<TonGiao>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tonGiaoService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/ton-giao")
        public ResponseEntity<ResDTO<TonGiao>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, tonGiaoService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/ton-giao/{id}")
        public ResponseEntity<ResDTO<TonGiao>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, tonGiaoService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/ton-giao/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, tonGiaoService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class TrinhDoChuyenMonController {
        @GetMapping("/trinh-do-chuyen-mon")
        public ResponseEntity<ResDTO<List<TrinhDoChuyenMon>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, trinhDoChuyenMonService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/trinh-do-chuyen-mon/{id}")
        public ResponseEntity<ResDTO<TrinhDoChuyenMon>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, trinhDoChuyenMonService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/trinh-do-chuyen-mon")
        public ResponseEntity<ResDTO<TrinhDoChuyenMon>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, trinhDoChuyenMonService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/trinh-do-chuyen-mon/{id}")
        public ResponseEntity<ResDTO<TrinhDoChuyenMon>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, trinhDoChuyenMonService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/trinh-do-chuyen-mon/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, trinhDoChuyenMonService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class TrinhDoGiaoDucPhoThongController {
        @GetMapping("/trinh-do-giao-duc-pho-thong")
        public ResponseEntity<ResDTO<List<TrinhDoGiaoDucPhoThong>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, trinhDoGiaoDucPhoThongService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/trinh-do-giao-duc-pho-thong/{id}")
        public ResponseEntity<ResDTO<TrinhDoGiaoDucPhoThong>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, trinhDoGiaoDucPhoThongService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/trinh-do-giao-duc-pho-thong")
        public ResponseEntity<ResDTO<TrinhDoGiaoDucPhoThong>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, trinhDoGiaoDucPhoThongService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/trinh-do-giao-duc-pho-thong/{id}")
        public ResponseEntity<ResDTO<TrinhDoGiaoDucPhoThong>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, trinhDoGiaoDucPhoThongService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/trinh-do-giao-duc-pho-thong/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, trinhDoGiaoDucPhoThongService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class ViTriViecLamController {
        @GetMapping("/vi-tri-viec-lam")
        public ResponseEntity<ResDTO<List<ViTriViecLam>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, viTriViecLamService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/vi-tri-viec-lam/{id}")
        public ResponseEntity<ResDTO<ViTriViecLam>> getById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, viTriViecLamService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/vi-tri-viec-lam")
        public ResponseEntity<ResDTO<ViTriViecLam>> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, viTriViecLamService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/vi-tri-viec-lam/{id}")
        public ResponseEntity<ResDTO<ViTriViecLam>> edit(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, viTriViecLamService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/vi-tri-viec-lam/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, viTriViecLamService.xoa(id)), HttpStatus.OK);
        }
    }
}
