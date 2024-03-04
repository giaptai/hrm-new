package sgu.hrm.module_utilities.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.function.EntityResponse;
import sgu.hrm.module_response.ResDTO;

import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_utilities.models.BacLuong;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.CapNhomChucDanhDang;
import sgu.hrm.module_utilities.models.ChucDanhDang;
import sgu.hrm.module_utilities.models.ChucVu;
import sgu.hrm.module_utilities.models.CoQuanToChucDonVi;
import sgu.hrm.module_utilities.models.DanToc;
import sgu.hrm.module_utilities.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.module_utilities.models.DoiTuongChinhSach;
import sgu.hrm.module_utilities.models.GioiTinh;
import sgu.hrm.module_utilities.models.HinhThucKhenThuong;
import sgu.hrm.module_utilities.models.HocHam;
import sgu.hrm.module_utilities.models.LoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.NhomChucDanhDang;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
import sgu.hrm.module_utilities.models.TinhTrangSucKhoe;
import sgu.hrm.module_utilities.models.TonGiao;
import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;
import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.module_utilities.models.ViTriViecLam;
import sgu.hrm.module_utilities.models.request.ReqCapBacQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.request.ReqUtilities;
import sgu.hrm.module_utilities.services.IUtilitiesService;

import java.util.List;

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
    private final IUtilitiesService<GioiTinh, ReqUtilities> gioiTinhService;
    private final IUtilitiesService<HinhThucKhenThuong, ReqUtilities> hinhThucKhenThuongService;
    private final IUtilitiesService<HocHam, ReqUtilities> hocHamService;
    private final IUtilitiesService<LoaiQuanHamQuanDoi, ReqUtilities> loaiQuanHamQuanDoiService;
    private final IUtilitiesService<NhomChucDanhDang, ReqUtilities> nhomChucDanhDangService;
    private final IUtilitiesService<NhomMau, ReqUtilities> nhomMauService;
    private final IUtilitiesService<ThanhPhanGiaDinh, ReqUtilities> thanhPhanGiaDinhService;
    private final IUtilitiesService<TinhTrangSucKhoe, ReqUtilities> tinhTrangSucKhoeService;
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
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, bacLuongService.them(utilities.name())), HttpStatus.OK);
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
        public ResponseEntity<ResDTO<List<CapBacLoaiQuanHamQuanDoi>>> getAllCapBacLoaiQuanHamQuanDoi() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, capBacLoaiQuanHamQuanDoiService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/cap-bac-loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<CapBacLoaiQuanHamQuanDoi>> getCapBacLoaiQuanHamQuanDoiById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, capBacLoaiQuanHamQuanDoiService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/cap-bac-loai-quan-ham-quan-doi")
        public ResponseEntity<ResDTO<CapBacLoaiQuanHamQuanDoi>> addCapBacLoaiQuanHamQuanDoi(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, capBacLoaiQuanHamQuanDoiService.themCapBacLoaiQuanHamQuanDoi(utilities.name(), utilities.loaiQuanHamQuanDoi())), HttpStatus.OK);
        }

        @PatchMapping("/cap-bac-loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<CapBacLoaiQuanHamQuanDoi>> editCapBacLoaiQuanHamQuanDoi(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, capBacLoaiQuanHamQuanDoiService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/cap-bac-loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<Boolean>> delCapBacLoaiQuanHamQuanDoi(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, capBacLoaiQuanHamQuanDoiService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class CapNhomChucDanhDangController {
        @GetMapping("/cap-nhom-chuc-danh-dang")
        public ResponseEntity<ResDTO<List<CapNhomChucDanhDang>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, capNhomChucDanhDangService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/cap-nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<CapNhomChucDanhDang>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, capNhomChucDanhDangService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/cap-nhom-chuc-danh-dang")
        public ResponseEntity<ResDTO<CapNhomChucDanhDang>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, capNhomChucDanhDangService.them(utilities.name())), HttpStatus.OK);
        }

        // khong co requestbody van ok, van hieu do la request body
        @PatchMapping("/cap-nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<CapNhomChucDanhDang>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, capNhomChucDanhDangService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/cap-nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, capNhomChucDanhDangService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class ChucDanhDangController {
        @GetMapping("/chuc-danh-dang")
        public ResponseEntity<ResDTO<List<ChucDanhDang>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, chucDanhDangService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<ChucDanhDang>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, chucDanhDangService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/chuc-danh-dang")
        public ResponseEntity<ResDTO<ChucDanhDang>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, chucDanhDangService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<ChucDanhDang>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, chucDanhDangService.sua(id, luong)), HttpStatus.OK);
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
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, chucVuService.them(utilities.name())), HttpStatus.OK);
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
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, coQuanToChucDonViService.them(utilities.name())), HttpStatus.OK);
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
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, danhHieuNhaNuocPhongTangService.them(utilities.name())), HttpStatus.OK);
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
        @GetMapping("/dan-toc")
        public ResponseEntity<ResDTO<List<DanToc>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danTocService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/dan-toc/{id}")
        public ResponseEntity<ResDTO<DanToc>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, danTocService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/dan-toc")
        public ResponseEntity<ResDTO<DanToc>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, danTocService.them(utilities.name())), HttpStatus.OK);
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

    @RestController
    class DoiTuongChinhSachController {
        @GetMapping("/doi-tuong-chinh-sach")
        public ResponseEntity<ResDTO<List<DoiTuongChinhSach>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, doiTuongChinhSachService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/doi-tuong-chinh-sach/{id}")
        public ResponseEntity<ResDTO<DoiTuongChinhSach>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, doiTuongChinhSachService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/doi-tuong-chinh-sach")
        public ResponseEntity<ResDTO<DoiTuongChinhSach>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, doiTuongChinhSachService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/doi-tuong-chinh-sach/{id}")
        public ResponseEntity<ResDTO<DoiTuongChinhSach>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, doiTuongChinhSachService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/doi-tuong-chinh-sach/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, doiTuongChinhSachService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class GioiTinhController {
        @GetMapping("/gioi-tinh")
        public ResponseEntity<ResDTO<List<GioiTinh>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, gioiTinhService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/gioi-tinh/{id}")
        public ResponseEntity<ResDTO<GioiTinh>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, gioiTinhService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/gioi-tinh")
        public ResponseEntity<ResDTO<GioiTinh>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, gioiTinhService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/gioi-tinh/{id}")
        public ResponseEntity<ResDTO<GioiTinh>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, gioiTinhService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/gioi-tinh/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, gioiTinhService.xoa(id)), HttpStatus.OK);
        }
    }

    //
    @RestController
    class HinhThucKhenThuongController {
        @GetMapping("/hinh-thuc-khen-thuong")
        public ResponseEntity<ResDTO<List<HinhThucKhenThuong>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, hinhThucKhenThuongService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/hinh-thuc-khen-thuong/{id}")
        public ResponseEntity<ResDTO<HinhThucKhenThuong>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, hinhThucKhenThuongService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/hinh-thuc-khen-thuong")
        public ResponseEntity<ResDTO<HinhThucKhenThuong>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, hinhThucKhenThuongService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/hinh-thuc-khen-thuong/{id}")
        public ResponseEntity<ResDTO<HinhThucKhenThuong>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, hinhThucKhenThuongService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/hinh-thuc-khen-thuong/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, hinhThucKhenThuongService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class HocHamController {
        @GetMapping("/hoc-ham")
        public ResponseEntity<ResDTO<List<HocHam>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, hocHamService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/hoc-ham/{id}")
        public ResponseEntity<ResDTO<HocHam>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, hocHamService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/hoc-ham")
        public ResponseEntity<ResDTO<HocHam>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, hocHamService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/hoc-ham/{id}")
        public ResponseEntity<ResDTO<HocHam>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, hocHamService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/hoc-ham/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, hocHamService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class LoaiQuanHamQuanDoiController {
        @GetMapping("/loai-quan-ham-quan-doi")
        public ResponseEntity<ResDTO<List<LoaiQuanHamQuanDoi>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, loaiQuanHamQuanDoiService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<LoaiQuanHamQuanDoi>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, loaiQuanHamQuanDoiService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/loai-quan-ham-quan-doi")
        public ResponseEntity<ResDTO<LoaiQuanHamQuanDoi>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, loaiQuanHamQuanDoiService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<LoaiQuanHamQuanDoi>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, loaiQuanHamQuanDoiService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, loaiQuanHamQuanDoiService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class NhomChucDanhDangController {
        @GetMapping("/nhom-chuc-danh-dang")
        public ResponseEntity<ResDTO<List<NhomChucDanhDang>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomChucDanhDangService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<NhomChucDanhDang>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomChucDanhDangService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/nhom-chuc-danh-dang")
        public ResponseEntity<ResDTO<NhomChucDanhDang>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, nhomChucDanhDangService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<NhomChucDanhDang>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, nhomChucDanhDangService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/nhom-chuc-danh-dang/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, nhomChucDanhDangService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class NhomMauController {
        @GetMapping("/nhom-mau")
        public ResponseEntity<ResDTO<List<NhomMau>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomMauService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/nhom-mau/{id}")
        public ResponseEntity<ResDTO<NhomMau>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomMauService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/nhom-mau")
        public ResponseEntity<ResDTO<NhomMau>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, nhomMauService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/nhom-mau/{id}")
        public ResponseEntity<ResDTO<NhomMau>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, nhomMauService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/nhom-mau/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, nhomMauService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class ThanhPhanGiaDinhController {
        @GetMapping("/thanh-phan-gia-dinh")
        public ResponseEntity<ResDTO<List<ThanhPhanGiaDinh>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, thanhPhanGiaDinhService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/thanh-phan-gia-dinh/{id}")
        public ResponseEntity<ResDTO<ThanhPhanGiaDinh>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, thanhPhanGiaDinhService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/thanh-phan-gia-dinh")
        public ResponseEntity<ResDTO<ThanhPhanGiaDinh>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, thanhPhanGiaDinhService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/thanh-phan-gia-dinh/{id}")
        public ResponseEntity<ResDTO<ThanhPhanGiaDinh>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, thanhPhanGiaDinhService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/thanh-phan-gia-dinh/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, thanhPhanGiaDinhService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class TinhTrangSucKhoeController {
        @GetMapping("/tinh-trang-suc-khoe")
        public ResponseEntity<ResDTO<List<TinhTrangSucKhoe>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tinhTrangSucKhoeService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/tinh-trang-suc-khoe/{id}")
        public ResponseEntity<ResDTO<TinhTrangSucKhoe>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tinhTrangSucKhoeService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/tinh-trang-suc-khoe")
        public ResponseEntity<ResDTO<TinhTrangSucKhoe>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, tinhTrangSucKhoeService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/tinh-trang-suc-khoe/{id}")
        public ResponseEntity<ResDTO<TinhTrangSucKhoe>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, tinhTrangSucKhoeService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/tinh-trang-suc-khoe/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, tinhTrangSucKhoeService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class TonGiaoController {
        @GetMapping("/ton-giao")
        public ResponseEntity<ResDTO<List<TonGiao>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tonGiaoService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/ton-giao/{id}")
        public ResponseEntity<ResDTO<TonGiao>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tonGiaoService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/ton-giao")
        public ResponseEntity<ResDTO<TonGiao>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, tonGiaoService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/ton-giao/{id}")
        public ResponseEntity<ResDTO<TonGiao>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, tonGiaoService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/ton-giao/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, tonGiaoService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class TrinhDoChuyenMonController {
        @GetMapping("/trinh-do-chuyen-mon")
        public ResponseEntity<ResDTO<List<TrinhDoChuyenMon>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, trinhDoChuyenMonService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/trinh-do-chuyen-mon/{id}")
        public ResponseEntity<ResDTO<TrinhDoChuyenMon>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, trinhDoChuyenMonService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/trinh-do-chuyen-mon")
        public ResponseEntity<ResDTO<TrinhDoChuyenMon>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, trinhDoChuyenMonService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/trinh-do-chuyen-mon/{id}")
        public ResponseEntity<ResDTO<TrinhDoChuyenMon>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, trinhDoChuyenMonService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/trinh-do-chuyen-mon/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, trinhDoChuyenMonService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class TrinhDoGiaoDucPhoThongController {
        @GetMapping("/trinh-do-giao-duc-pho-thong")
        public ResponseEntity<ResDTO<List<TrinhDoGiaoDucPhoThong>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, trinhDoGiaoDucPhoThongService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/trinh-do-giao-duc-pho-thong/{id}")
        public ResponseEntity<ResDTO<TrinhDoGiaoDucPhoThong>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, trinhDoGiaoDucPhoThongService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/trinh-do-giao-duc-pho-thong")
        public ResponseEntity<ResDTO<TrinhDoGiaoDucPhoThong>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, trinhDoGiaoDucPhoThongService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/trinh-do-giao-duc-pho-thong/{id}")
        public ResponseEntity<ResDTO<TrinhDoGiaoDucPhoThong>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, trinhDoGiaoDucPhoThongService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/trinh-do-giao-duc-pho-thong/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, trinhDoGiaoDucPhoThongService.xoa(id)), HttpStatus.OK);
        }
    }

    @RestController
    class ViTriViecLamController {
        @GetMapping("/vi-tri-viec-lam")
        public ResponseEntity<ResDTO<List<ViTriViecLam>>> getAllBacLuong() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, viTriViecLamService.xemDS()), HttpStatus.OK);
        }

        @GetMapping("/vi-tri-viec-lam/{id}")
        public ResponseEntity<ResDTO<ViTriViecLam>> getBacLuongById(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, viTriViecLamService.xemTheoId(id).orElse(null)), HttpStatus.OK);
        }

        @PostMapping("/vi-tri-viec-lam")
        public ResponseEntity<ResDTO<ViTriViecLam>> addBacLuong(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, viTriViecLamService.them(utilities.name())), HttpStatus.OK);
        }

        @PatchMapping("/vi-tri-viec-lam/{id}")
        public ResponseEntity<ResDTO<ViTriViecLam>> editBacLuong(@PathVariable int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, viTriViecLamService.sua(id, luong)), HttpStatus.OK);
        }

        @DeleteMapping("/vi-tri-viec-lam/{id}")
        public ResponseEntity<ResDTO<Boolean>> delBacLuong(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, viTriViecLamService.xoa(id)), HttpStatus.OK);
        }
    }
}
