package sgu.hrm.module_soyeulylich.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import sgu.hrm.module_heso_luong_ngach.models.NgachCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.NgachVienChuc;
import sgu.hrm.module_heso_luong_ngach.repositories.NgachCongChucRepository;
import sgu.hrm.module_heso_luong_ngach.repositories.NgachVienChucRepository;
import sgu.hrm.module_security.IAuthenticationFacade;
import sgu.hrm.module_utilities.enums.PheDuyet;
import sgu.hrm.module_soyeulylich.models.request.ReqDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.request.ReqSoYeuLyLich;
import sgu.hrm.module_soyeulylich.repository.SoYeuLyLichRepository;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
// import sgu.hrm.models.CoQuanToChucDonViTuyenDung;
import sgu.hrm.module_utilities.models.ChucDanhDang;
import sgu.hrm.module_utilities.models.ChucVu;
import sgu.hrm.module_utilities.models.CoQuanToChucDonVi;
import sgu.hrm.module_utilities.models.DanToc;
import sgu.hrm.module_utilities.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.module_utilities.models.DoiTuongChinhSach;
import sgu.hrm.module_utilities.models.HocHam;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;
import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.module_utilities.models.ViTriViecLam;
import sgu.hrm.module_utilities.repositories.CapBacLoaiQuanHamQuanDoiRepository;
import sgu.hrm.module_utilities.repositories.ChucDanhDangRepository;
import sgu.hrm.module_utilities.repositories.ChucVuRepository;
import sgu.hrm.module_utilities.repositories.CoQuanToChucDonViRepository;
import sgu.hrm.module_utilities.repositories.DanTocRepository;
import sgu.hrm.module_utilities.repositories.DanhHieuNhaNuocPhongTangRepository;
import sgu.hrm.module_utilities.repositories.DoiTuongChinhSachRepository;
import sgu.hrm.module_utilities.repositories.HocHamRepository;
import sgu.hrm.module_utilities.repositories.NhomMauRepository;
import sgu.hrm.module_utilities.repositories.ThanhPhanGiaDinhRepository;
import sgu.hrm.module_utilities.repositories.TrinhDoChuyenMonRepository;
import sgu.hrm.module_utilities.repositories.TrinhDoGiaoDucPhoThongRepository;
import sgu.hrm.module_utilities.repositories.ViTriViecLamRepository;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor // tự tạo constructor với filed là final hoặc annotation not null
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoYeuLyLichService implements ISoYeuLyLichService {
    final SoYeuLyLichRepository soYeuLyLichRepository;
    final DanTocRepository danTocRepository;
    final ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository;
    final CoQuanToChucDonViRepository coQuanToChucDonViRepository;
    final CapBacLoaiQuanHamQuanDoiRepository capBacLoaiQuanHamQuanDoiRepository;
    final DoiTuongChinhSachRepository doiTuongChinhSachRepository;
    final TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository;
    final TrinhDoChuyenMonRepository trinhDoChuyenMonRepository;
    final HocHamRepository hocHamRepository;
    final DanhHieuNhaNuocPhongTangRepository danhHieuNhaNuocPhongTangRepository;
    final NhomMauRepository nhomMauRepository;
    final ChucVuRepository chucVuRepository;
    final ChucDanhDangRepository chucDanhDangRepository;
    final NgachCongChucRepository ngachCongChucRepository;
    final NgachVienChucRepository ngachVienChucRepository;
    final ViTriViecLamRepository viTriViecLamRepository;
    final IAuthenticationFacade facadeEmployee;

    @Override
    public SoYeuLyLich xemThongTinSoYeuLyLich() {
        try {
            return facadeEmployee.getSoYeuLyLich();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public SoYeuLyLich capNhatSoYeuLyLich(ReqSoYeuLyLich reqSoYeuLyLich) {
        try {
            SoYeuLyLich soYeuLyLich = facadeEmployee.getSoYeuLyLich();
            if (soYeuLyLich != null) {
                SoYeuLyLich syllNew = mapToSoYeuLyLich(reqSoYeuLyLich);
                syllNew.setId(soYeuLyLich.getId());
                syllNew.setCreate_at(soYeuLyLich.getCreate_at());
                syllNew.setPheDuyet(PheDuyet.CHO_PHE_DUYET);
                syllNew.setUpdate_at();
                return soYeuLyLichRepository.save(syllNew);
            }
            return null;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public List<SoYeuLyLich> xemDanhSachSoYeuLyLich() {
        try {
            return soYeuLyLichRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public SoYeuLyLich xemSoYeuLyLichTheoSoCCCDHoacID(String q) {
        try {
            SoYeuLyLich resSoYeuLyLichSoCCCD = soYeuLyLichRepository.findFirstBySoCCCD(q).orElse(null);
            SoYeuLyLich resSoYeuLyLichId = null;
            Pattern UUID_REGEX = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
            if (UUID_REGEX.matcher(q).matches()) {
                resSoYeuLyLichId = soYeuLyLichRepository.findById(UUID.fromString(q)).orElse(null);
            }
            return resSoYeuLyLichSoCCCD != null ? resSoYeuLyLichSoCCCD : resSoYeuLyLichId;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public SoYeuLyLich xemSoYeuLyLichTheoId(String id) {
        try {
            return soYeuLyLichRepository.findById(UUID.fromString(id)).orElse(null);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public List<SoYeuLyLich> pheDuyetSoYeuLyLich(List<ReqDSSoYeuLyLich> reqDSSoYeuLyLich) {
        try {
            List<SoYeuLyLich> soYeuLyLiches = reqDSSoYeuLyLich.stream().flatMap(c -> c.soYeuLyLichs().stream().map(t -> {
                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findById(t).orElse(null);
                if (soYeuLyLich != null) {
                    soYeuLyLich.setPheDuyet(c.pheDuyet());
                    soYeuLyLich.setUpdate_at();
                }
                return soYeuLyLich;
            })).toList();
            return soYeuLyLichRepository.saveAll(soYeuLyLiches);
//            return soYeuLyLiches;
//            SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findById(UUID.fromString(id)).orElse(null);
//            if (soYeuLyLich != null) {
//                soYeuLyLich.setTrangThai(reqDSSoYeuLyLich.trang_thai());
//                soYeuLyLich.setUpdate_at();
//                soYeuLyLichRepository.save(soYeuLyLich);
//                return true;
//            }
//            return false;
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

    private SoYeuLyLich mapToSoYeuLyLich(ReqSoYeuLyLich reqSoYeuLyLich) {
        DanToc danToc = danTocRepository.findById(reqSoYeuLyLich.danToc()).orElse(null);
        ThanhPhanGiaDinh thanhPhanGiaDinh = thanhPhanGiaDinhRepository.findById(reqSoYeuLyLich.thanhPhanGiaDinh()).orElse(null);
        CoQuanToChucDonVi coQuanToChucDonViTuyenDung = coQuanToChucDonViRepository.findById(reqSoYeuLyLich.coQuanToChucDonViTuyenDung()).orElse(null);
        CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoiRepository.findById(reqSoYeuLyLich.capBacLoaiQuanHamQuanDoi()).orElse(null);
        DoiTuongChinhSach doiTuongChinhSach = doiTuongChinhSachRepository.findById(reqSoYeuLyLich.doiTuongChinhSach()).orElse(null);
        TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong = trinhDoGiaoDucPhoThongRepository.findById(reqSoYeuLyLich.trinhDoGiaoDucPhoThong()).orElse(null);
        TrinhDoChuyenMon trinhDoChuyenMon = trinhDoChuyenMonRepository.findById(reqSoYeuLyLich.trinhDoChuyenMon()).orElse(null);
        HocHam hocHam = hocHamRepository.findById(reqSoYeuLyLich.hocHam()).orElse(null);
        DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang = danhHieuNhaNuocPhongTangRepository.findById(reqSoYeuLyLich.danhHieuNhaNuocPhongTang()).orElse(null);
        NhomMau nhomMau = nhomMauRepository.findById(reqSoYeuLyLich.nhomMau()).orElse(null);
        ChucVu chucVu = chucVuRepository.findById(reqSoYeuLyLich.chucVuHienTai()).orElse(null);
        ChucVu chucVuKiemNhiem = chucVuRepository.findById(reqSoYeuLyLich.chucVuKiemNhiem()).orElse(null);
        NgachCongChuc ngachCongChuc = ngachCongChucRepository.findById(reqSoYeuLyLich.ngachNgheNghiep()).orElse(null);
        NgachVienChuc ngachVienChuc = ngachVienChucRepository.findById(reqSoYeuLyLich.ngachNgheNghiep()).orElse(null);
        ViTriViecLam viTriViecLam = viTriViecLamRepository.findById(reqSoYeuLyLich.viTriViecLam()).orElse(null);
        ChucDanhDang chucDanhDangHienTai = chucDanhDangRepository.findById(reqSoYeuLyLich.chucVuDangHienTai()).orElse(null);
        ChucDanhDang chucDanhDangKiemNhiem = chucDanhDangRepository.findById(reqSoYeuLyLich.chucVuDangKiemNhiem()).orElse(null);
        return SoYeuLyLich.builder()
                .hoVaTen(reqSoYeuLyLich.hovaten())
                .gioiTinh(reqSoYeuLyLich.gioiTinh())
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
                .ngayBoNhiemNgach(reqSoYeuLyLich.ngayBoNhiemNgachNgheNghiep())
                .ngayHuongLuongNgach(reqSoYeuLyLich.ngayHuongLuongNgachNgheNghiep())
                .phanTramHuongLuongNgach(reqSoYeuLyLich.phanTramHuongLuongNgachNgheNghiep())
                .phuCapThamNienVuotKhungNgach(reqSoYeuLyLich.phuCapThamNienVuotKhungNgachNgheNghiep())
                .ngayHuongPCTNVKNgach(reqSoYeuLyLich.ngayHuongPCTNVKNgachNgheNghiep())
                .phuCapChucVu(reqSoYeuLyLich.phuCapChucVu())
                .phuCapKiemNhiem(reqSoYeuLyLich.phuCapKiemNhiem())
                .phuCapKhac(reqSoYeuLyLich.phuCapKhac())
                .viTriViecLam(viTriViecLam)
                .ngayHuongLuongTheoViTriViecLam(reqSoYeuLyLich.ngayHuongLuongTheoViTriViecLam())
                .phamTramHuongLuong(reqSoYeuLyLich.phamTramHuongLuong())
                .phuCapThamNienVuotKhung(reqSoYeuLyLich.phuCapThamNienVuotKhung())
                .ngayHuongPCTNVK(reqSoYeuLyLich.ngayHuongPCTNVK())
                .tinhTrangSucKhoe(reqSoYeuLyLich.tinhTrangSucKhoe())
                .chieuCao(reqSoYeuLyLich.chieuCao())
                .canNang(reqSoYeuLyLich.canNang())
                .nhomMau(nhomMau)
                .build();
    }
}
