package sgu.hrm.module_soyeulylich_chitiet.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_kafka.KafkaConsumers;
import sgu.hrm.module_kafka.KafkaProducers;
import sgu.hrm.module_soyeulylich.dto.request.ReqDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.dto.request.ReqSoYeuLyLich;
import sgu.hrm.module_soyeulylich.dto.response.ResSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.services.ISoYeuLyLichService;
import sgu.hrm.response.ResDTO;
import sgu.hrm.response.ResEnum;
import sgu.hrm.module_soyeulylich_chitiet.dto.request.ReqNgoaiNguNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.dto.request.ReqQuaTrinhCongTacNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.dto.request.ReqKhenThuongNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.dto.request.ReqKyLuatNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.dto.request.ReqLamViecONuocNgoaiNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.dto.request.ReqLyLuanChinhTriNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.dto.request.ReqNghiepVuChuyenNganhNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.dto.response.ResTinHoc;
import sgu.hrm.module_soyeulylich_chitiet.services.ISoYeuLyLichChiTietServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor // create constructor if field set final or @not null
@RequestMapping(value = "")
public class AdminSoYeuLyLichChiTietController {
    private final ISoYeuLyLichService soYeuLyLichService;
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
    private final KafkaProducers producers;
    private final KafkaConsumers consumers;

    @RestController
    @RequestMapping(value = "/nhan-vien")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class AdminSoYeuLyLichController {
        @GetMapping("/so-yeu-ly-lich")
        public ResponseEntity<ResDTO<List<ResSoYeuLyLich>>> getAll() {
            List<ResSoYeuLyLich> resSoYeuLyLichs = soYeuLyLichService.xemDanhSachSoYeuLyLich().stream().map(ResSoYeuLyLich::mapToResSoYeuLyLich).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resSoYeuLyLichs), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/so-yeu-ly-lich/tim-kiem")
        public ResponseEntity<ResDTO<SoYeuLyLich>> getBySoCCCDOrId(@RequestParam(name = "q") String q) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, soYeuLyLichService.xemSoYeuLyLichTheoSoCCCDHoacID(q)), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/so-yeu-ly-lich/{id}")
        public ResponseEntity<ResDTO<ResSoYeuLyLich>> getById(@PathVariable(name = "id") UUID id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                    ResSoYeuLyLich.mapToResSoYeuLyLich(soYeuLyLichService.xemSoYeuLyLichTheoId(id))), ResEnum.THANH_CONG.getStatusCode());
        }

        @jakarta.transaction.Transactional
        @PatchMapping("/so-yeu-ly-lich/{id}")
        public ResponseEntity<ResDTO<ResSoYeuLyLich>> editById(@PathVariable(name = "id") UUID id, @RequestBody ReqSoYeuLyLich lyLich) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG,
                    ResSoYeuLyLich.mapToResSoYeuLyLich(soYeuLyLichService.capNhatTheoId(id, lyLich))), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @jakarta.transaction.Transactional
        @PatchMapping("/so-yeu-ly-lich/phe-duyet")
        public ResponseEntity<ResDTO<List<ResSoYeuLyLich>>> edit(@PathVariable(name = "id", required = false) String id,
                                                                 @RequestBody List<ReqDSSoYeuLyLich> reqDSSoYeuLyLich) {
            List<ResSoYeuLyLich> resSoYeuLyLichs = soYeuLyLichService.pheDuyetSoYeuLyLich(reqDSSoYeuLyLich).stream().map(ResSoYeuLyLich::mapToResSoYeuLyLich).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.PHE_DUYET_THANH_CONG, resSoYeuLyLichs), ResEnum.PHE_DUYET_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @RequestMapping(value = "/danh-sach-phe-duyet")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class PheDuyetController {
        @GetMapping("/ngoai-ngu")
        public ResponseEntity<ResDTO<Map<String, List<?>>>> ds_ngoaingu() {
            Map<String, List<?>> ddd = new HashMap<>();
            producers.run();
            List<ResNgoaiNgu> ngoaiNgus = consumers.ngoaiNguConsumer();
            List<ResKhenThuong> khenThuongs = consumers.khenThuongConsumer();
            System.out.println("CON : GFGGH");
            List<ResKyLuat> kyLuats = consumers.kyLuatConsumer();
            ddd.put("ngoai_ngu", ngoaiNgus);
            ddd.put("khen_thuong", khenThuongs);
            ddd.put("ky_luat", kyLuats);
            return new ResponseEntity<>(ResDTO.response(ResEnum.KAFKA_THANH_CONG, ddd), ResEnum.KAFKA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class BanThanCoLamViecChoCheDoCuController {
        @GetMapping("/nhan-vien/{id}/lam-viec-cho-che-do-cu")
        public ResponseEntity<ResDTO<List<ResBanThanCoLamViecChoCheDoCu>>> nhanvien_lam_viec_cho_che_do_cu(@PathVariable String id) {
            List<ResBanThanCoLamViecChoCheDoCu> ls = banThanCoLamViecChoCheDoCuSefvice.xemDanhSach(id).stream().map(ResBanThanCoLamViecChoCheDoCu::maptoResBanThanCoLamViecChoCheDoCu).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ls), HttpStatus.ACCEPTED);
        }

        @GetMapping("/nhan-vien/lam-viec-cho-che-do-cu")
        public ResponseEntity<ResDTO<List<ResBanThanCoLamViecChoCheDoCu>>> ds_nhanvien_lam_viec_cho_che_do_cu() {
            List<ResBanThanCoLamViecChoCheDoCu> ls = banThanCoLamViecChoCheDoCuSefvice.xemDanhSachEmployee().stream().map(ResBanThanCoLamViecChoCheDoCu::maptoResBanThanCoLamViecChoCheDoCu).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ls), HttpStatus.ACCEPTED);
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class KhenThuongController {
        @GetMapping("/nhan-vien/{id}/khen-thuong")
        public ResponseEntity<ResDTO<List<ResKhenThuong>>> nhanvien_khen_thuong(@PathVariable String id) {
            List<ResKhenThuong> kt = khenThuongSefvice.xemDanhSach(id).stream().map(ResKhenThuong::maptoResKhenThuong).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, kt), HttpStatus.ACCEPTED);
        }

        @GetMapping("/nhan-vien/khen-thuong")
        public ResponseEntity<ResDTO<List<ResKhenThuong>>> ds_nhanvien_khen_thuong() {
            List<ResKhenThuong> kt = khenThuongSefvice.xemDanhSachEmployee().stream().map(ResKhenThuong::maptoResKhenThuong).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, kt), HttpStatus.ACCEPTED);
        }

        @Transactional
        @PostMapping("/nhan-vien/khen-thuong")
        public ResponseEntity<ResDTO<List<ResKhenThuong>>> nhanvien_khenthuong(@RequestBody List<ReqKhenThuongNhanVien> nhanVien) {
            List<ResKhenThuong> kt = khenThuongSefvice.khenThuongNhanVien(nhanVien).stream().map(ResKhenThuong::maptoResKhenThuong).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, kt), HttpStatus.ACCEPTED);
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class KienThucAnNinhQuocPhongController {
        @GetMapping("/nhan-vien/{id}/kien-thuc-an-ninh-quoc-phong")
        public ResponseEntity<ResDTO<List<ResKienThucAnNinhQuocPhong>>> nhanvien_kien_thuc_an_ninh_quoc_phong(@PathVariable String id) {
            List<ResKienThucAnNinhQuocPhong> res = kienThucAnNinhQuocPhongSefvice.xemDanhSach(id).stream().map(ResKienThucAnNinhQuocPhong::mapToResKienThucAnNinhQuocPhong).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, res), HttpStatus.OK);
        }

        @GetMapping("/nhan-vien/kien-thuc-an-ninh-quoc-phong")
        public ResponseEntity<ResDTO<List<ResKienThucAnNinhQuocPhong>>> ds_nhanvien_kien_thuc_an_ninh_quoc_phong() {
            List<ResKienThucAnNinhQuocPhong> res = kienThucAnNinhQuocPhongSefvice.xemDanhSachEmployee().stream().map(ResKienThucAnNinhQuocPhong::mapToResKienThucAnNinhQuocPhong).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, res), HttpStatus.OK);
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class KyLuatController {
        @GetMapping("/nhan-vien/{id}/ky-luat")
        public ResponseEntity<ResDTO<List<ResKyLuat>>> nhanvien_ky_luat(@PathVariable String id) {
            List<ResKyLuat> kl = kyLuatSefvice.xemDanhSach(id).stream().map(ResKyLuat::mapToResKyLuat).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, kl), HttpStatus.OK);
        }

        @GetMapping("/nhan-vien/ky-luat")
        public ResponseEntity<ResDTO<List<ResKyLuat>>> ds_nhanvien_ky_luat() {
            List<ResKyLuat> kl = kyLuatSefvice.xemDanhSachEmployee().stream().map(ResKyLuat::mapToResKyLuat).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, kl), HttpStatus.OK);
        }

        @Transactional
        @PostMapping("/nhan-vien/ky-luat")
        public ResponseEntity<ResDTO<List<ResKyLuat>>> nhanvien_kyluat(@RequestBody List<ReqKyLuatNhanVien> nhanVien) {
            List<ResKyLuat> kl = kyLuatSefvice.kyLuatNhanVien(nhanVien).stream().map(ResKyLuat::mapToResKyLuat).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, kl), HttpStatus.OK);
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class LamViecONuocNgoaiController {
        @GetMapping("/nhan-vien/{id}/lam-viec-o-nuoc-ngoai")
        public ResponseEntity<ResDTO<List<ResLamViecONuocNgoai>>> nhanvien_lam_viec_o_nuoc_ngoai(@PathVariable String id) {
            List<ResLamViecONuocNgoai> nc = lamViecONuocNgoaiSefvice.xemDanhSach(id).stream().map(ResLamViecONuocNgoai::mapToResLamViecONuocNgoai).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nc), HttpStatus.OK);
        }

        @GetMapping("/nhan-vien/lam-viec-o-nuoc-ngoai")
        public ResponseEntity<ResDTO<List<ResLamViecONuocNgoai>>> ds_nhanvien_lam_viec_o_nuoc_ngoai() {
            List<ResLamViecONuocNgoai> nc = lamViecONuocNgoaiSefvice.xemDanhSachEmployee().stream().map(ResLamViecONuocNgoai::mapToResLamViecONuocNgoai).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nc), HttpStatus.OK);
        }

        @PostMapping("/nhan-vien/lam-viec-o-nuoc-ngoai")
        public ResponseEntity<ResDTO<List<ResLamViecONuocNgoai>>> nhanvien_lamvieconuocngoai(@RequestBody List<ReqLamViecONuocNgoaiNhanVien> nhanVien) {
            List<ResLamViecONuocNgoai> nc = lamViecONuocNgoaiSefvice.lamViecONUocNgoaiNhanVien(nhanVien).stream().map(ResLamViecONuocNgoai::mapToResLamViecONuocNgoai).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nc), HttpStatus.OK);
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class LuongBanThanController {
        @GetMapping("/nhan-vien/{id}/luong-ban-than")
        public ResponseEntity<ResDTO<List<ResLuongBanThan>>> nhanvien_luong_ban_than(@PathVariable String id) {
            List<ResLuongBanThan> luong = luongBanThanSefvice.xemDanhSach(id).stream()
                    .map(ResLuongBanThan::mapToResLuongBanThan).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, luong), HttpStatus.OK);
        }

        @GetMapping("/nhan-vien/luong-ban-than")
        public ResponseEntity<ResDTO<List<ResLuongBanThan>>> ds_nhanvien_luong_ban_than() {
            List<ResLuongBanThan> luong = luongBanThanSefvice.xemDanhSachEmployee().stream()
                    .map(ResLuongBanThan::mapToResLuongBanThan).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, luong), HttpStatus.OK);
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class LyLuanChinhTriController {
        @GetMapping("/nhan-vien/{id}/ly-luan-chinh-tri")
        public ResponseEntity<ResDTO<List<ResLyLuanChinhTri>>> nhanvien_ly_luan_chinh_tri(@PathVariable String id) {
            List<ResLyLuanChinhTri> tri = lyLuanChinhTriSefvice.xemDanhSach(id).stream().map(ResLyLuanChinhTri::mapToResLyLuanChinhTri).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tri), HttpStatus.OK);
        }

        @GetMapping("/nhan-vien/ly-luan-chinh-tri")
        public ResponseEntity<ResDTO<List<ResLyLuanChinhTri>>> ds_nhanvien_ly_luan_chinh_tri() {
            List<ResLyLuanChinhTri> tri = lyLuanChinhTriSefvice.xemDanhSachEmployee().stream().map(ResLyLuanChinhTri::mapToResLyLuanChinhTri).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tri), HttpStatus.OK);
        }

        @PostMapping("/nhan-vien/ly-luan-chinh-tri")
        public ResponseEntity<ResDTO<List<ResLyLuanChinhTri>>> ds_nhanvien_lyluanchinhtri(@RequestBody List<ReqLyLuanChinhTriNhanVien> nhanVien) {
            List<ResLyLuanChinhTri> tri = lyLuanChinhTriSefvice.lyLuanChinhTriNhanVien(nhanVien).stream().map(ResLyLuanChinhTri::mapToResLyLuanChinhTri).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tri), HttpStatus.OK);
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class NghiepVuChuyenNganhController {
        @GetMapping("/nhan-vien/{id}/nghiep-vu-chuyen-nganh")
        public ResponseEntity<ResDTO<List<ResNghiepVuChuyenNganh>>> nhanvien_nghiep_vu_chuyen_nganh(@PathVariable String id) {
            List<ResNghiepVuChuyenNganh> vu = nghiepVuChuyenNganhSefvice.xemDanhSach(id).stream().map(ResNghiepVuChuyenNganh::mapToResNghiepVuChuyenNganh).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, vu), HttpStatus.OK);
        }

        @GetMapping("/nhan-vien/nghiep-vu-chuyen-nganh")
        public ResponseEntity<ResDTO<List<ResNghiepVuChuyenNganh>>> ds_nhanvien_nghiep_vu_chuyen_nganh() {
            List<ResNghiepVuChuyenNganh> vu = nghiepVuChuyenNganhSefvice.xemDanhSachEmployee().stream().map(ResNghiepVuChuyenNganh::mapToResNghiepVuChuyenNganh).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, vu), HttpStatus.OK);
        }

        @PostMapping("/nhan-vien/nghiep-vu-chuyen-nganh")
        public ResponseEntity<ResDTO<List<ResNghiepVuChuyenNganh>>> ds_nhanvien_nghiepvuchuyennganh(@RequestBody List<ReqNghiepVuChuyenNganhNhanVien> nhanVien) {
            List<ResNghiepVuChuyenNganh> tri = nghiepVuChuyenNganhSefvice.nghiepVuChuyenNganhNhanVien(nhanVien).stream().map(ResNghiepVuChuyenNganh::mapToResNghiepVuChuyenNganh).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tri), HttpStatus.OK);
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class NgoaiNguController {
        @GetMapping("/nhan-vien/{id}/ngoai-ngu")
        public ResponseEntity<ResDTO<List<ResNgoaiNgu>>> nhanvien_ngoai_ngu(@PathVariable String id) {
            List<ResNgoaiNgu> ngu = ngoaiNguSefvice.xemDanhSach(id).stream().map(ResNgoaiNgu::mapToResNgoaiNgu).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ngu), HttpStatus.OK);
        }

        @GetMapping("/nhan-vien/ngoai-ngu")
        public ResponseEntity<ResDTO<List<ResNgoaiNgu>>> ds_nhanvien_ngoai_ngu() {
            List<ResNgoaiNgu> ngu = ngoaiNguSefvice.xemDanhSachEmployee().stream().map(ResNgoaiNgu::mapToResNgoaiNgu).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ngu), HttpStatus.OK);
        }

        @PostMapping("/nhan-vien/ngoai-ngu")
        public ResponseEntity<ResDTO<List<ResNgoaiNgu>>> ds_nhanvien_ngoaingu(@RequestBody List<ReqNgoaiNguNhanVien> nhanVien) {
            List<ResNgoaiNgu> ngu = ngoaiNguSefvice.ngoaiNguNhanVien(nhanVien).stream().map(ResNgoaiNgu::mapToResNgoaiNgu).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ngu), HttpStatus.OK);
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class PhuCapKhacController {
        @GetMapping("/nhan-vien/{id}/phu-cap-khac")
        public ResponseEntity<ResDTO<List<ResPhuCapKhac>>> nhanvien_phu_cap_khac(@PathVariable String id) {
            List<ResPhuCapKhac> khac = phuCapKhacSefvice.xemDanhSach(id).stream().map(ResPhuCapKhac::mapToResPhuCapKhac).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, khac), HttpStatus.OK);
        }

        @GetMapping("/nhan-vien/phu-cap-khac")
        public ResponseEntity<ResDTO<List<ResPhuCapKhac>>> ds_nhanvien_phu_cap_khac() {
            List<ResPhuCapKhac> khac = phuCapKhacSefvice.xemDanhSachEmployee().stream().map(ResPhuCapKhac::mapToResPhuCapKhac).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, khac), HttpStatus.OK);
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class QuanHeGiaDinhController {
        @GetMapping("/nhan-vien/{id}/quan-he-gia-dinh")
        public ResponseEntity<ResDTO<List<ResQuanHeGiaDinh>>> nhanvien_quan_he_gia_dinh(@PathVariable String id) {
            List<ResQuanHeGiaDinh> gia = quanHeGiaDinhSefvice.xemDanhSach(id).stream().map(ResQuanHeGiaDinh::mapToResQuanHeGiaDinh).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, gia), HttpStatus.OK);
        }

        @GetMapping("/nhan-vien/quan-he-gia-dinh")
        public ResponseEntity<ResDTO<List<ResQuanHeGiaDinh>>> ds_nhanvien_quan_he_gia_dinh() {
            List<ResQuanHeGiaDinh> gia = quanHeGiaDinhSefvice.xemDanhSachEmployee().stream().map(ResQuanHeGiaDinh::mapToResQuanHeGiaDinh).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, gia), HttpStatus.OK);
        }
    }


    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class QuaTrinhCongTacController {
        @GetMapping("/nhan-vien/{id}/qua-trinh-cong-tac")
        public ResponseEntity<ResDTO<List<ResQuaTrinhCongTac>>> nhanvien_qua_trinh_cong_tac(@PathVariable String id) {
            List<ResQuaTrinhCongTac> tac = quaTrinhCongTacSefvice.xemDanhSach(id).stream().map(ResQuaTrinhCongTac::mapToResQuaTrinhCongTac).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tac), HttpStatus.OK);
        }

        @GetMapping("/nhan-vien/qua-trinh-cong-tac")
        public ResponseEntity<ResDTO<List<ResQuaTrinhCongTac>>> ds_nhanvien_qua_trinh_cong_tac() {
            List<ResQuaTrinhCongTac> tac = quaTrinhCongTacSefvice.xemDanhSachEmployee().stream().map(ResQuaTrinhCongTac::mapToResQuaTrinhCongTac).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tac), HttpStatus.OK);
        }

        @Transactional
        @PostMapping("/nhan-vien/chuyen-cong-tac")
        public ResponseEntity<ResDTO<List<ResQuaTrinhCongTac>>> chuyenCongTac(@RequestBody List<ReqQuaTrinhCongTacNhanVien> congtac) {
            List<ResQuaTrinhCongTac> tac = quaTrinhCongTacSefvice.chuyenCongTacNhanVien(congtac).stream().map(ResQuaTrinhCongTac::mapToResQuaTrinhCongTac).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tac), HttpStatus.OK);
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Admin ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class TinHocController {
        @GetMapping("/nhan-vien/{id}/tin-hoc")
        public ResponseEntity<ResDTO<List<ResTinHoc>>> nhanvien_tin_hoc(@PathVariable String id) {
            List<ResTinHoc> tin = tinHocSefvice.xemDanhSach(id).stream().map(ResTinHoc::mapToResTinHoc).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tin), HttpStatus.OK);
        }

        @GetMapping("/nhan-vien/tin-hoc")
        public ResponseEntity<ResDTO<List<ResTinHoc>>> nhanvien_tin_hoc() {
            List<ResTinHoc> tin = tinHocSefvice.xemDanhSachEmployee().stream().map(ResTinHoc::mapToResTinHoc).toList();
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, tin), HttpStatus.OK);
        }
    }
}
