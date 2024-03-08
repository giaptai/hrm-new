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
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.CapNhomChucDanhDang;
import sgu.hrm.module_utilities.models.ChucDanhDang;
import sgu.hrm.module_utilities.models.ChucVu;
import sgu.hrm.module_utilities.models.CoQuanToChucDonVi;
import sgu.hrm.module_utilities.models.DanToc;
import sgu.hrm.module_utilities.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.module_utilities.models.DoiTuongChinhSach;
import sgu.hrm.module_utilities.enums.GioiTinh;
import sgu.hrm.module_utilities.models.HinhThucKhenThuong;
import sgu.hrm.module_utilities.models.HocHam;
import sgu.hrm.module_utilities.models.LoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.MoiQuanHe;
import sgu.hrm.module_utilities.models.NhomChucDanhDang;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
import sgu.hrm.module_utilities.enums.TinhTrangSucKhoe;
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
    private final IUtilitiesService<DanhHieuNhaNuocPhongTang, ReqUtilities> danhHieuNhaNuocPhongTangService;
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
        public ResponseEntity<ResDTO<List<BacLuong>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, bacLuongService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/bac-luong/{id}")
        public ResponseEntity<ResDTO<BacLuong>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, bacLuongService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/bac-luong")
        public ResponseEntity<ResDTO<BacLuong>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, bacLuongService.them(utilities)), HttpStatus.OK);
        }

        // khong co requestbody van ok, van hieu do la request body
        @PatchMapping("/bac-luong/{id}")
        public ResponseEntity<ResDTO<BacLuong>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, bacLuongService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/bac-luong/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
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
        public ResponseEntity<ResDTO<List<ResCapNhomChucDanhDang>>> getAllBacLuong() {
            List<ResCapNhomChucDanhDang> resCapNhomChucDanhDangs = capNhomChucDanhDangService.xemDS().stream().map(ResCapNhomChucDanhDang::mapToResCapNhomChucDanhDang).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resCapNhomChucDanhDangs), HttpStatus.OK);
        }

        @GetMapping("/cap-nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<ResCapNhomChucDanhDang>> getBacLuongById(@PathVariable int id) {
            ResCapNhomChucDanhDang resCapNhomChucDanhDang = ResCapNhomChucDanhDang.mapToResCapNhomChucDanhDang(capNhomChucDanhDangService.xemTheoId(id).orElse(null));
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resCapNhomChucDanhDang), HttpStatus.OK);
        }

        @PostMapping("/cap-nhom-chuc-danh-dang")
        public ResponseEntity<ResDTO<ResCapNhomChucDanhDang>> addBacLuong(@RequestBody ReqUtilities utilities) {
            ResCapNhomChucDanhDang resCapNhomChucDanhDang = ResCapNhomChucDanhDang.mapToResCapNhomChucDanhDang(capNhomChucDanhDangService.them(utilities));
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, resCapNhomChucDanhDang), HttpStatus.OK);
        }

        // khong co requestbody van ok, van hieu do la request body
        @PatchMapping("/cap-nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<ResCapNhomChucDanhDang>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            ResCapNhomChucDanhDang resCapNhomChucDanhDang = ResCapNhomChucDanhDang.mapToResCapNhomChucDanhDang(capNhomChucDanhDangService.sua(id, luong));
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, resCapNhomChucDanhDang), HttpStatus.OK);
        }

        @DeleteMapping("/cap-nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, capNhomChucDanhDangService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class ChucDanhDangController {
        @GetMapping("/chuc-danh-dang")
        public ResponseEntity<ResDTO<List<ResChucDanhDang>>> getAllBacLuong() {
            List<ResChucDanhDang> resChucDanhDangs = chucDanhDangService.xemDS().stream().map(ResChucDanhDang::mapToResChucDanhDang).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resChucDanhDangs), HttpStatus.OK);
        }

        @GetMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<ResChucDanhDang>> getBacLuongById(@PathVariable int id) {
            ResChucDanhDang resChucDanhDang = ResChucDanhDang.mapToResChucDanhDang(chucDanhDangService.xemTheoId(id).orElse(null));
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resChucDanhDang), HttpStatus.OK);
        }

        @PostMapping("/chuc-danh-dang")
        public ResponseEntity<ResDTO<ResChucDanhDang>> addBacLuong(@RequestBody ReqUtilities utilities) {
            ResChucDanhDang resChucDanhDang = ResChucDanhDang.mapToResChucDanhDang(chucDanhDangService.them(utilities));
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, resChucDanhDang), HttpStatus.OK);
        }

        @PatchMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<ResChucDanhDang>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            ResChucDanhDang resChucDanhDang = ResChucDanhDang.mapToResChucDanhDang(chucDanhDangService.sua(id, luong));
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, resChucDanhDang), HttpStatus.OK);
        }

        @DeleteMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, chucDanhDangService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class ChucVuController {
        @GetMapping("/chuc-vu")
        public ResponseEntity<ResDTO<List<ChucVu>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, chucVuService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/chuc-vu/{id}")
        public ResponseEntity<ResDTO<ChucVu>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, chucVuService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/chuc-vu")
        public ResponseEntity<ResDTO<ChucVu>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, chucVuService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/chuc-vu/{id}")
        public ResponseEntity<ResDTO<ChucVu>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, chucVuService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/chuc-vu/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, chucVuService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class CoQuanToChucDonViController {
        @GetMapping("/coquan-tochuc-donvi")
        public ResponseEntity<ResDTO<List<CoQuanToChucDonVi>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, coQuanToChucDonViService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/coquan-tochuc-donvi/{id}")
        public ResponseEntity<ResDTO<CoQuanToChucDonVi>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, coQuanToChucDonViService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/coquan-tochuc-donvi")
        public ResponseEntity<ResDTO<CoQuanToChucDonVi>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, coQuanToChucDonViService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/coquan-tochuc-donvi/{id}")
        public ResponseEntity<ResDTO<CoQuanToChucDonVi>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, coQuanToChucDonViService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/coquan-tochuc-donvi/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, coQuanToChucDonViService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class DanhHieuNhaNuocPhongTangController {
        @GetMapping("/danh-hieu-nha-nuoc-phong")
        public ResponseEntity<ResDTO<List<DanhHieuNhaNuocPhongTang>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danhHieuNhaNuocPhongTangService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/danh-hieu-nha-nuoc-phong/{id}")
        public ResponseEntity<ResDTO<DanhHieuNhaNuocPhongTang>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danhHieuNhaNuocPhongTangService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/danh-hieu-nha-nuoc-phong")
        public ResponseEntity<ResDTO<DanhHieuNhaNuocPhongTang>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, danhHieuNhaNuocPhongTangService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/danh-hieu-nha-nuoc-phong/{id}")
        public ResponseEntity<ResDTO<DanhHieuNhaNuocPhongTang>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, danhHieuNhaNuocPhongTangService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/danh-hieu-nha-nuoc-phong/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, danhHieuNhaNuocPhongTangService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class DanTocController {
        private PhanTrang<DanToc> phanTrang = null;

        @GetMapping("/dan-toc")
        public ResponseEntity<ResDTO<List<DanToc>>> getAllBacLuong(@RequestParam(name = "page", required = false) Optional<String> page) {
            page.ifPresentOrElse(
                    (value) -> phanTrang = new PhanTrang<>(page.get()),
                    () -> phanTrang = null
            );
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danTocService.xemDS(phanTrang)), HttpStatus.OK);
        }

        @GetMapping("/dan-toc/{id}")
        public ResponseEntity<ResDTO<DanToc>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danTocService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/dan-toc")
        public ResponseEntity<ResDTO<DanToc>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, danTocService.them(utilities)), HttpStatus.OK);
        }

        @PatchMapping("/dan-toc/{id}")
        public ResponseEntity<ResDTO<DanToc>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, danTocService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/dan-toc/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, danTocService.xoa(id)), HttpStatus.OK);
        }
    }
}
