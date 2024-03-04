package sgu.hrm.module_soyeulylich.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import sgu.hrm.module_congchuc_vienchuc.models.NgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.NgachVienChuc;
import sgu.hrm.module_congchuc_vienchuc.repositories.NgachCongChucRepository;
import sgu.hrm.module_congchuc_vienchuc.repositories.NgachVienChucRepository;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_soyeulylich.models.request.ReqDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.request.ReqSoYeuLyLich;
import sgu.hrm.module_soyeulylich.repository.SoYeuLyLichRepository;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.response.ResSoYeuLyLich;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
// import sgu.hrm.models.CoQuanToChucDonViTuyenDung;
import sgu.hrm.module_utilities.models.ChucDanhDang;
import sgu.hrm.module_utilities.models.ChucVu;
import sgu.hrm.module_utilities.models.CoQuanToChucDonVi;
import sgu.hrm.module_utilities.models.DanToc;
import sgu.hrm.module_utilities.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.module_utilities.models.DoiTuongChinhSach;
import sgu.hrm.module_utilities.models.GioiTinh;
import sgu.hrm.module_utilities.models.HocHam;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
import sgu.hrm.module_utilities.models.TinhTrangSucKhoe;
import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;
import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.module_utilities.models.ViTriViecLam;
import sgu.hrm.module_utilities.repositories.BacLuongRepository;
import sgu.hrm.module_utilities.repositories.CapBacLoaiQuanHamQuanDoiRepository;
import sgu.hrm.module_utilities.repositories.ChucDanhDangRepository;
import sgu.hrm.module_utilities.repositories.ChucVuRepository;
import sgu.hrm.module_utilities.repositories.CoQuanToChucDonViRepository;
import sgu.hrm.module_utilities.repositories.DanTocRepository;
import sgu.hrm.module_utilities.repositories.DanhHieuNhaNuocPhongTangRepository;
import sgu.hrm.module_utilities.repositories.DoiTuongChinhSachRepository;
import sgu.hrm.module_utilities.repositories.GioiTinhRepository;
import sgu.hrm.module_utilities.repositories.HocHamRepository;
import sgu.hrm.module_utilities.repositories.NhomMauRepository;
import sgu.hrm.module_utilities.repositories.ThanhPhanGiaDinhRepository;
import sgu.hrm.module_utilities.repositories.TinhTrangSucKhoeRepository;
import sgu.hrm.module_utilities.repositories.TrinhDoChuyenMonRepository;
import sgu.hrm.module_utilities.repositories.TrinhDoGiaoDucPhoThongRepository;
import sgu.hrm.module_utilities.repositories.ViTriViecLamRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor // tự tạo constructor với filed là final hoặc annotation not null
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoYeuLyLichService implements ISoYeuLyLichService {
    final SoYeuLyLichRepository soYeuLyLichRepository;
    final GioiTinhRepository gioiTinhRepository;
    final DanTocRepository danTocRepository;
    final ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository;
    final CoQuanToChucDonViRepository coQuanToChucDonViRepository;
    final CapBacLoaiQuanHamQuanDoiRepository capBacLoaiQuanHamQuanDoiRepository;
    final DoiTuongChinhSachRepository doiTuongChinhSachRepository;
    final TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository;
    final TrinhDoChuyenMonRepository trinhDoChuyenMonRepository;
    final HocHamRepository hocHamRepository;
    final DanhHieuNhaNuocPhongTangRepository danhHieuNhaNuocPhongTangRepository;
    final TinhTrangSucKhoeRepository tinhTrangSucKhoeRepository;
    final NhomMauRepository nhomMauRepository;
    final ChucVuRepository chucVuRepository;
    final ChucDanhDangRepository chucDanhDangRepository;
    final NgachCongChucRepository ngachCongChucRepository;
    final NgachVienChucRepository ngachVienChucRepository;
    final ViTriViecLamRepository viTriViecLamRepository;

    @Override
    public ResDTO<?> xemThongTinSoYeuLyLich() {
        try {
            SoYeuLyLich soYeuLyLich = get_Info_SoYeuLyLich();
            return soYeuLyLich != null ?
                    ResDTO.response(ResEnum.THANH_CONG, ISoYeuLyLichService.mapToResSoYeuLyLich(soYeuLyLich)) :
                    ResDTO.response(ResEnum.HONG_TIM_THAY, "");
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<ResSoYeuLyLich> capNhatSoYeuLyLich(ReqSoYeuLyLich reqSoYeuLyLich) {
        try {
            SoYeuLyLich soYeuLyLich = get_Info_SoYeuLyLich();
            if (soYeuLyLich != null) {
                SoYeuLyLich syllNew = mapToSoYeuLyLich(reqSoYeuLyLich);
                syllNew.setId(soYeuLyLich.getId());
                syllNew.setCreate_at(soYeuLyLich.getCreate_at());
                syllNew.setUpdate_at();
                soYeuLyLichRepository.save(syllNew);
                return ResDTO.response(ResEnum.THANH_CONG, ISoYeuLyLichService.mapToResSoYeuLyLich(syllNew));
            } else return ResDTO.response(ResEnum.HONG_TIM_THAY, null);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<?> xemDanhSachSoYeuLyLich() {
        try {
            List<ResSoYeuLyLich> soYeuLyLichs = soYeuLyLichRepository.findAll().stream().map(ISoYeuLyLichService::mapToResSoYeuLyLich).toList();
            return ResDTO.response(ResEnum.THANH_CONG, soYeuLyLichs);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<ResSoYeuLyLich> xemSoYeuLyLichTheoSoCCCDHoacID(String q) {
        try {
            SoYeuLyLich resSoYeuLyLichSoCCCD = soYeuLyLichRepository.findFirstBySoCCCD(q).orElse(null);
            SoYeuLyLich resSoYeuLyLichId = null;
            Pattern UUID_REGEX = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
            if (UUID_REGEX.matcher(q).matches()) {
                resSoYeuLyLichId = soYeuLyLichRepository.findById(UUID.fromString(q)).orElse(null);
            }
            return ResDTO.response(ResEnum.THANH_CONG, (resSoYeuLyLichSoCCCD != null ? ISoYeuLyLichService.mapToResSoYeuLyLich(resSoYeuLyLichSoCCCD) :
                    resSoYeuLyLichId != null ? ISoYeuLyLichService.mapToResSoYeuLyLich(resSoYeuLyLichId) : null));
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<?> xemSoYeuLyLichTheoId(String id) {
        try {
            SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findById(UUID.fromString(id)).orElse(null);
            return ResDTO.response(ResEnum.THANH_CONG, soYeuLyLich != null ? ISoYeuLyLichService.mapToResSoYeuLyLich(soYeuLyLich) : null);
        } catch (IllegalArgumentException e) {
            return ResDTO.response(ResEnum.KHONG_HOP_LE, "");
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<?> pheDuyetSoYeuLyLich(String id, ReqDSSoYeuLyLich reqDSSoYeuLyLich) {
        try {
            SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findById(UUID.fromString(id)).orElse(null);
            if (soYeuLyLich != null) {
                soYeuLyLich.setTrangThai(reqDSSoYeuLyLich.trang_thai());
                soYeuLyLich.setUpdate_at();
                soYeuLyLichRepository.save(soYeuLyLich);
                // ISoYeuLyLichService.RES_DS_SO_YEU_LY_LICH(soYeuLyLich)
                return ResDTO.response(ResEnum.THANH_CONG, ISoYeuLyLichService.mapToResSoYeuLyLich(soYeuLyLich));

            }
            return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private double tinhLuongThucNhan(double tienLuong, float heSoLuongNgachNgheNghiep, double phanTramHuongLuongNgachNgheNghiep,
                                     float phuCapThamNienVuotKhungNgachNgheNghiep, float phuCapChucVu, float phuCapKiemNhiem, float phuCapKhac,
                                     double luongTheoMucTien, double phamTramHuongLuong, double phuCapThamNienVuotKhung
    ) {

        return (tienLuong * (heSoLuongNgachNgheNghiep * phanTramHuongLuongNgachNgheNghiep + phuCapThamNienVuotKhungNgachNgheNghiep)
                + phuCapChucVu + phuCapKiemNhiem + phuCapKhac) + (luongTheoMucTien * (phamTramHuongLuong + phuCapThamNienVuotKhung));
    }

    private SoYeuLyLich get_Info_SoYeuLyLich() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return Optional.ofNullable((TaiKhoan) authentication.getPrincipal()).map(
                    TaiKhoan::getSoYeuLyLich
            ).orElse(null);
        } else return null;
    }

    private SoYeuLyLich mapToSoYeuLyLich(ReqSoYeuLyLich reqSoYeuLyLich) {
        GioiTinh gioiTinh = gioiTinhRepository.findById(reqSoYeuLyLich.gioiTinh()).orElse(null);
        DanToc danToc = danTocRepository.findById(reqSoYeuLyLich.danToc()).orElse(null);
        ThanhPhanGiaDinh thanhPhanGiaDinh = thanhPhanGiaDinhRepository.findById(reqSoYeuLyLich.thanhPhanGiaDinh()).orElse(null);
        CoQuanToChucDonVi coQuanToChucDonViTuyenDung = coQuanToChucDonViRepository.findById(reqSoYeuLyLich.coQuanToChucDonViTuyenDung()).orElse(null);
        CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoiRepository.findById(reqSoYeuLyLich.capBacLoaiQuanHamQuanDoi()).orElse(null);
        DoiTuongChinhSach doiTuongChinhSach = doiTuongChinhSachRepository.findById(reqSoYeuLyLich.doiTuongChinhSach()).orElse(null);
        TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong = trinhDoGiaoDucPhoThongRepository.findById(reqSoYeuLyLich.trinhDoGiaoDucPhoThong()).orElse(null);
        TrinhDoChuyenMon trinhDoChuyenMon = trinhDoChuyenMonRepository.findById(reqSoYeuLyLich.trinhDoChuyenMon()).orElse(null);
        HocHam hocHam = hocHamRepository.findById(reqSoYeuLyLich.hocHam()).orElse(null);
        DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang = danhHieuNhaNuocPhongTangRepository.findById(reqSoYeuLyLich.danhHieuNhaNuocPhongTang()).orElse(null);
//        BacLuong bacLuong = bacLuongRepository.findById(reqSoYeuLyLich.bacLuong()).orElse(null);
        TinhTrangSucKhoe tinhTrangSucKhoe = tinhTrangSucKhoeRepository.findById(reqSoYeuLyLich.tinhTrangSucKhoe()).orElse(null);
        NhomMau nhomMau = nhomMauRepository.findById(reqSoYeuLyLich.nhomMau()).orElse(null);
        ChucVu chucVu = chucVuRepository.findById(reqSoYeuLyLich.chucVuHienTai()).orElse(null);
        ChucVu chucVuKiemNhiem = chucVuRepository.findById(reqSoYeuLyLich.chucVuKiemNhiem()).orElse(null);
        NgachCongChuc ngachCongChuc = ngachCongChucRepository.findById(reqSoYeuLyLich.ngachNgheNghiep()).orElse(null);
        NgachVienChuc ngachVienChuc = ngachVienChucRepository.findById(reqSoYeuLyLich.ngachNgheNghiep()).orElse(null);
        ViTriViecLam viTriViecLam = viTriViecLamRepository.findById(reqSoYeuLyLich.viTriViecLam()).orElse(null);
        ChucDanhDang chucDanhDangHienTai = chucDanhDangRepository.findById(reqSoYeuLyLich.chucVuDangHienTai()).orElse(null);
        ChucDanhDang chucDanhDangKiemNhiem = chucDanhDangRepository.findById(reqSoYeuLyLich.chucVuDangKiemNhiem()).orElse(null);
        SoYeuLyLich soYeuLyLich = SoYeuLyLich.builder()
                .hovaten(reqSoYeuLyLich.hovaten())
                .gioiTinh(gioiTinh)
                .cacTenGoiKhac(reqSoYeuLyLich.cacTenGoiKhac())
                .sinhNgay(reqSoYeuLyLich.sinhNgay())
                .noiSinh(reqSoYeuLyLich.noiSinh())
                .queQuan(reqSoYeuLyLich.queQuan())
                .danToc(danToc)
                .soCCCD(reqSoYeuLyLich.soCCCD())
                .ngayCapCCCD(reqSoYeuLyLich.ngayCapCCCD())
                .soDienThoai(reqSoYeuLyLich.soDienThoai())
                .soBHXH(reqSoYeuLyLich.soBHXH())
                .soBHYT(reqSoYeuLyLich.soBHYT())
                .noiOHienNay(reqSoYeuLyLich.noiOHienNay())
                .thanhPhanGiaDinh(thanhPhanGiaDinh)
                .ngheNghiepTruocKhiTuyenDung(reqSoYeuLyLich.ngheNghiepTruocKhiTuyenDung())
                .ngayDuocTuyenDungLanDau(reqSoYeuLyLich.ngayDuocTuyenDungLanDau())
                .coQuanToChucDonViTuyenDung(coQuanToChucDonViTuyenDung)
                .ngayVaoCoQuanHienDangCongTac(reqSoYeuLyLich.ngayVaoCoQuanHienDangCongTac())
                .ngayVaoDangCongSanVietNam(reqSoYeuLyLich.ngayVaoDangCongSanVietNam())
                .ngayChinhThuc(reqSoYeuLyLich.ngayChinhThuc())
                .ngayThamGiaToChucChinhTriXaHoiDauTien(reqSoYeuLyLich.ngayThamGiaToChucChinhTriXaHoiDauTien())
                .ngayNhapNgu(reqSoYeuLyLich.ngayNhapNgu())
                .ngayXuatNgu(reqSoYeuLyLich.ngayXuatNgu())
                .capBacLoaiQuanHamQuanDoi(capBacLoaiQuanHamQuanDoi)
                .doiTuongChinhSach(doiTuongChinhSach)
                .trinhDoGiaoDucPhoThong(trinhDoGiaoDucPhoThong)
                .trinhDoChuyenMon(trinhDoChuyenMon)
                .hocHam(hocHam)
                .danhHieuNhaNuocPhongTang(danhHieuNhaNuocPhongTang)
                .chucVuHienTai(chucVu)
                .ngayBoNhiem(reqSoYeuLyLich.ngayBoNhiem())
                .ngayBoNhiemLai(reqSoYeuLyLich.ngayBoNhiemLai())
                .duocQuyHoacChucDanh(reqSoYeuLyLich.duocQuyHoacChucDanh())
                .chucVuKiemNhiem(chucVuKiemNhiem)
                .chucVuDangHienTai(chucDanhDangHienTai)
                .chucVuDangKiemNhiem(chucDanhDangKiemNhiem)
                .congViecChinhDuocGiao(reqSoYeuLyLich.congViecChinhDuocGiao())
                .soTruongCongTac(reqSoYeuLyLich.soTruongCongTac())
                .congViecLamLauNhat(reqSoYeuLyLich.congViecLamLauNhat())
                .tienLuong(reqSoYeuLyLich.tienLuong())
                .ngachVienChuc(ngachVienChuc)
                .ngachCongChuc(ngachCongChuc)
                .ngayBoNhiemNgachNgheNghiep(reqSoYeuLyLich.ngayBoNhiemNgachNgheNghiep())
                .ngayHuongLuongNgachNgheNghiep(reqSoYeuLyLich.ngayHuongLuongNgachNgheNghiep())
                .phanTramHuongLuongNgachNgheNghiep(reqSoYeuLyLich.phanTramHuongLuongNgachNgheNghiep())
                .phuCapThamNienVuotKhungNgachNgheNghiep(reqSoYeuLyLich.phuCapThamNienVuotKhungNgachNgheNghiep())
                .ngayHuongPCTNVKNgachNgheNghiep(reqSoYeuLyLich.ngayHuongPCTNVKNgachNgheNghiep())
                .phuCapChucVu(reqSoYeuLyLich.phuCapChucVu())
                .phuCapKiemNhiem(reqSoYeuLyLich.phuCapKiemNhiem())
                .phuCapKhac(reqSoYeuLyLich.phuCapKhac())
                .viTriViecLam(viTriViecLam)
                .ngayHuongLuongTheoViTriViecLam(reqSoYeuLyLich.ngayHuongLuongTheoViTriViecLam())
                .phamTramHuongLuong(reqSoYeuLyLich.phamTramHuongLuong())
                .phuCapThamNienVuotKhung(reqSoYeuLyLich.phuCapThamNienVuotKhung())
                .ngayHuongPCTNVK(reqSoYeuLyLich.ngayHuongPCTNVK())
                .tinhTrangSucKhoe(tinhTrangSucKhoe)
                .chieuCao(reqSoYeuLyLich.chieuCao())
                .canNang(reqSoYeuLyLich.canNang())
                .nhomMau(nhomMau)
                .build();
        soYeuLyLich.setUpdate_at();
        return soYeuLyLich;
    }

//    private SoYeuLyLich mapToSoYeuLyLich(ReqSoYeuLyLich reqSoYeuLyLich) {
//        GioiTinh gioiTinh = gioiTinhRepository.findByName(reqSoYeuLyLich.gioiTinh());
//        DanToc danToc = danTocRepository.findByName(reqSoYeuLyLich.danToc());
//        ThanhPhanGiaDinh thanhPhanGiaDinh = thanhPhanGiaDinhRepository.findByName(reqSoYeuLyLich.thanhPhanGiaDinh());
//        CoQuanToChucDonVi coQuanToChucDonViTuyenDung = coQuanToChucDonViRepository.findById(reqSoYeuLyLich.coQuanToChucDonViTuyenDung()).orElse(null);
//        CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoiRepository.findByName(reqSoYeuLyLich.capBacLoaiQuanHamQuanDoi());
//        DoiTuongChinhSach doiTuongChinhSach = doiTuongChinhSachRepository.findByName(reqSoYeuLyLich.doiTuongChinhSach());
//        TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong = trinhDoGiaoDucPhoThongRepository.findByName(reqSoYeuLyLich.trinhDoGiaoDucPhoThong());
//        TrinhDoChuyenMon trinhDoChuyenMon = trinhDoChuyenMonRepository.findByName(reqSoYeuLyLich.trinhDoChuyenMon());
//        HocHam hocHam = hocHamRepository.findByName(reqSoYeuLyLich.hocHam());
//        DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang = danhHieuNhaNuocPhongTangRepository.findByName(reqSoYeuLyLich.danhHieuNhaNuocPhongTang());
//        BacLuong bacLuong = bacLuongRepository.findByName(reqSoYeuLyLich.bacLuong());
//        TinhTrangSucKhoe tinhTrangSucKhoe = tinhTrangSucKhoeRepository.findByTitle(reqSoYeuLyLich.tinhTrangSucKhoe());
//        NhomMau nhomMau = nhomMauRepository.findByName(reqSoYeuLyLich.nhomMau());
//        ChucVu chucVu = chucVuRepository.findByName(reqSoYeuLyLich.chucVuHienTai());
//        ChucVu chucVuKiemNhiem = chucVuRepository.findByName(reqSoYeuLyLich.chucVuKiemNhiem());
//        NgachCongChuc ngachCongChuc = ngachCongChucRepository.findByName(reqSoYeuLyLich.ngachNgheNghiep());
//        NgachVienChuc ngachVienChuc = ngachVienChucRepository.findByName(reqSoYeuLyLich.ngachNgheNghiep());
//        ViTriViecLam viTriViecLam = viTriViecLamRepository.findByName(reqSoYeuLyLich.viTriViecLam());
//        ChucDanhDang chucDanhDangHienTai = chucDanhDangRepository.findByName(reqSoYeuLyLich.chucVuDangHienTai());
//        ChucDanhDang chucDanhDangKiemNhiem = chucDanhDangRepository.findByName(reqSoYeuLyLich.chucVuDangKiemNhiem());
//        SoYeuLyLich soYeuLyLich = SoYeuLyLich.builder()
//                .hovaten(reqSoYeuLyLich.hovaten())
//                .gioiTinh(gioiTinh)
//                .cacTenGoiKhac(reqSoYeuLyLich.cacTenGoiKhac())
//                .sinhNgay(reqSoYeuLyLich.sinhNgay())
//                .noiSinh(reqSoYeuLyLich.noiSinh())
//                .queQuan(reqSoYeuLyLich.queQuan())
//                .danToc(danToc)
//                .soCCCD(reqSoYeuLyLich.soCCCD())
//                .ngayCapCCCD(reqSoYeuLyLich.ngayCapCCCD())
//                .soDienThoai(reqSoYeuLyLich.soDienThoai())
//                .soBHXH(reqSoYeuLyLich.soBHXH())
//                .soBHYT(reqSoYeuLyLich.soBHYT())
//                .noiOHienNay(reqSoYeuLyLich.noiOHienNay())
//                .thanhPhanGiaDinh(thanhPhanGiaDinh)
//                .ngheNghiepTruocKhiTuyenDung(reqSoYeuLyLich.ngheNghiepTruocKhiTuyenDung())
//                .ngayDuocTuyenDungLanDau(reqSoYeuLyLich.ngayDuocTuyenDungLanDau())
//                .coQuanToChucDonViTuyenDung(coQuanToChucDonViTuyenDung)
//                .ngayVaoCoQuanHienDangCongTac(reqSoYeuLyLich.ngayVaoCoQuanHienDangCongTac())
//                .ngayVaoDangCongSanVietNam(reqSoYeuLyLich.ngayVaoDangCongSanVietNam())
//                .ngayChinhThuc(reqSoYeuLyLich.ngayChinhThuc())
//                .ngayThamGiaToChucChinhTriXaHoiDauTien(reqSoYeuLyLich.ngayThamGiaToChucChinhTriXaHoiDauTien())
//                .ngayNhapNgu(reqSoYeuLyLich.ngayNhapNgu())
//                .ngayXuatNgu(reqSoYeuLyLich.ngayXuatNgu())
//                .capBacLoaiQuanHamQuanDoi(capBacLoaiQuanHamQuanDoi)
//                .doiTuongChinhSach(doiTuongChinhSach)
//                .trinhDoGiaoDucPhoThong(trinhDoGiaoDucPhoThong)
//                .trinhDoChuyenMon(trinhDoChuyenMon)
//                .hocHam(hocHam)
//                .danhHieuNhaNuocPhongTang(danhHieuNhaNuocPhongTang)
//                .chucVuHienTai(chucVu)
//                .ngayBoNhiem(reqSoYeuLyLich.ngayBoNhiem())
//                .ngayBoNhiemLai(reqSoYeuLyLich.ngayBoNhiemLai())
//                .duocQuyHoacChucDanh(reqSoYeuLyLich.duocQuyHoacChucDanh())
//                .chucVuKiemNhiem(chucVuKiemNhiem)
//                .chucVuDangHienTai(chucDanhDangHienTai)
//                .chucVuDangKiemNhiem(chucDanhDangKiemNhiem)
//                .congViecChinhDuocGiao(reqSoYeuLyLich.congViecChinhDuocGiao())
//                .soTruongCongTac(reqSoYeuLyLich.soTruongCongTac())
//                .congViecLamLauNhat(reqSoYeuLyLich.congViecLamLauNhat())
//                .tienLuong(reqSoYeuLyLich.tienLuong())
//                .ngachVienChuc(ngachVienChuc)
//                .ngachCongChuc(ngachCongChuc)
////                .maSoNgachNgheNghiep(reqSoYeuLyLich.maSoNgachNgheNghiep())
//                .ngayBoNhiemNgachNgheNghiep(reqSoYeuLyLich.ngayBoNhiemNgachNgheNghiep())
////                .bacLuong(bacLuong)
////                .heSoLuongNgachNgheNghiep(reqSoYeuLyLich.heSoLuongNgachNgheNghiep())
//                .ngayHuongLuongNgachNgheNghiep(reqSoYeuLyLich.ngayHuongLuongNgachNgheNghiep())
//                .phanTramHuongLuongNgachNgheNghiep(reqSoYeuLyLich.phanTramHuongLuongNgachNgheNghiep())
//                .phuCapThamNienVuotKhungNgachNgheNghiep(reqSoYeuLyLich.phuCapThamNienVuotKhungNgachNgheNghiep())
//                .ngayHuongPCTNVKNgachNgheNghiep(reqSoYeuLyLich.ngayHuongPCTNVKNgachNgheNghiep())
//                .phuCapChucVu(reqSoYeuLyLich.phuCapChucVu())
//                .phuCapKiemNhiem(reqSoYeuLyLich.phuCapKiemNhiem())
//                .phuCapKhac(reqSoYeuLyLich.phuCapKhac())
//                .viTriViecLam(viTriViecLam)
////                .maSoViTriViecLam(reqSoYeuLyLich.maSoViTriViecLam())
////                .bacLuongTriViecLam(reqSoYeuLyLich.bacLuongTriViecLam())
////                .luongTheoMucTien(reqSoYeuLyLich.luongTheoMucTien())
//                .ngayHuongLuongTheoViTriViecLam(reqSoYeuLyLich.ngayHuongLuongTheoViTriViecLam())
//                .phamTramHuongLuong(reqSoYeuLyLich.phamTramHuongLuong())
//                .phuCapThamNienVuotKhung(reqSoYeuLyLich.phuCapThamNienVuotKhung())
//                .ngayHuongPCTNVK(reqSoYeuLyLich.ngayHuongPCTNVK())
//                .tinhTrangSucKhoe(tinhTrangSucKhoe)
//                .chieuCao(reqSoYeuLyLich.chieuCao())
//                .canNang(reqSoYeuLyLich.canNang())
//                .nhomMau(nhomMau)
//                .build();
//        soYeuLyLich.setUpdate_at();
//        return soYeuLyLich;
//    }
}
