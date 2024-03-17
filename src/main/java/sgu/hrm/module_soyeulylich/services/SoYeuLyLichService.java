package sgu.hrm.module_soyeulylich.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import sgu.hrm.module_cauhinh.models.NgachCongChuc;
import sgu.hrm.module_cauhinh.models.NgachVienChuc;
import sgu.hrm.module_cauhinh.repositories.NgachCongChucRepository;
import sgu.hrm.module_cauhinh.repositories.NgachVienChucRepository;
import sgu.hrm.module_security.IAuthenticationFacade;
import sgu.hrm.module_soyeulylich.models.ChucVuHienTai;
import sgu.hrm.module_soyeulylich.models.HocVan;
import sgu.hrm.module_soyeulylich.models.NgachNhanVien;
import sgu.hrm.module_soyeulylich.models.NghiaVuQuanSu;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.SucKhoe;
import sgu.hrm.module_soyeulylich.models.ThongTinTuyenDung;
import sgu.hrm.module_soyeulylich.models.ViecLam;
import sgu.hrm.module_soyeulylich.repository.HocVanRepository;
import sgu.hrm.module_soyeulylich.repository.NgachRepository;
import sgu.hrm.module_soyeulylich.repository.NghiaVuQuanSuRepository;
import sgu.hrm.module_soyeulylich.repository.SucKhoeRepository;
import sgu.hrm.module_soyeulylich.repository.ThongTinTuyenDungRepository;
import sgu.hrm.module_soyeulylich.repository.ViecLamRepository;
import sgu.hrm.enums.PheDuyet;
import sgu.hrm.module_soyeulylich.dto.request.ReqDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.dto.request.ReqSoYeuLyLich;
import sgu.hrm.module_soyeulylich.repository.SoYeuLyLichRepository;
import sgu.hrm.module_cauhinh.models.CapBacLoaiQuanHamQuanDoi;
// import sgu.hrm.models.CoQuanToChucDonViTuyenDung;
import sgu.hrm.module_cauhinh.models.ChucDanhDang;
import sgu.hrm.module_cauhinh.models.ChucVu;
import sgu.hrm.module_cauhinh.models.CoQuanToChucDonVi;
import sgu.hrm.module_cauhinh.models.DanToc;
import sgu.hrm.module_cauhinh.models.DanhHieuNhaNuoc;
import sgu.hrm.module_cauhinh.models.DoiTuongChinhSach;
//import sgu.hrm.module_utilities.models.DonVi;
import sgu.hrm.module_cauhinh.models.HocHam;
import sgu.hrm.module_cauhinh.models.NhomMau;
import sgu.hrm.module_cauhinh.models.ThanhPhanGiaDinh;
import sgu.hrm.module_cauhinh.models.TrinhDoChuyenMon;
import sgu.hrm.module_cauhinh.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.module_cauhinh.models.ViTriViecLam;
import sgu.hrm.module_cauhinh.repositories.CapBacLoaiQuanHamQuanDoiRepository;
import sgu.hrm.module_cauhinh.repositories.ChucDanhDangRepository;
import sgu.hrm.module_cauhinh.repositories.ChucVuRepository;
import sgu.hrm.module_cauhinh.repositories.CoQuanToChucDonViRepository;
import sgu.hrm.module_cauhinh.repositories.DanTocRepository;
import sgu.hrm.module_cauhinh.repositories.DanhHieuNhaNuocPhongTangRepository;
import sgu.hrm.module_cauhinh.repositories.DoiTuongChinhSachRepository;
//import sgu.hrm.module_utilities.repositories.DonViRepository;
import sgu.hrm.module_cauhinh.repositories.HocHamRepository;
import sgu.hrm.module_cauhinh.repositories.NhomMauRepository;
import sgu.hrm.module_cauhinh.repositories.ThanhPhanGiaDinhRepository;
import sgu.hrm.module_cauhinh.repositories.TrinhDoChuyenMonRepository;
import sgu.hrm.module_cauhinh.repositories.TrinhDoGiaoDucPhoThongRepository;
import sgu.hrm.module_cauhinh.repositories.ViTriViecLamRepository;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor // tự tạo constructor với filed là final hoặc annotation not null
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoYeuLyLichService implements ISoYeuLyLichService {
    final SoYeuLyLichRepository soYeuLyLichRepository;
    final HocVanRepository hocVanRepository;
    final NgachRepository ngachRepository;
    final NghiaVuQuanSuRepository nghiaVuQuanSuRepository;
    final SucKhoeRepository sucKhoeRepository;
    final ThongTinTuyenDungRepository thongTinTuyenDungRepository;
    final ViecLamRepository viecLamRepository;

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
    //    final DonViRepository donViRepository;
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
                SoYeuLyLich syllNew = mapToSoYeuLyLich(soYeuLyLich, reqSoYeuLyLich);
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
//            return null;
            return resSoYeuLyLichSoCCCD != null ? resSoYeuLyLichSoCCCD : resSoYeuLyLichId;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public SoYeuLyLich xemSoYeuLyLichTheoId(UUID id) {
        try {
//            if(UUID.)
            return soYeuLyLichRepository.findById(id).orElse(null);
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

    @Override
    public SoYeuLyLich capNhatTheoId(UUID id, ReqSoYeuLyLich req) {
        try {
            SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findById(id).orElse(null);
            if (soYeuLyLich != null) {
                SoYeuLyLich syllNew = mapToSoYeuLyLich(soYeuLyLich, req);
                return soYeuLyLichRepository.save(syllNew);
            }
            return null;
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

    private SoYeuLyLich mapToSoYeuLyLich(SoYeuLyLich syll, ReqSoYeuLyLich req) {
        ReqSoYeuLyLich.ReqThongTinTuyenDung tuyenDung = req.thongTinTuyenDung();
        ReqSoYeuLyLich.ReqQuanSu reqQuanSu = req.quanSu();
        ReqSoYeuLyLich.ReqHocVan reqHocVan = req.hocVan();
        ReqSoYeuLyLich.ReqChucVu reqChucVu = req.chucVu();
        ReqSoYeuLyLich.ReqNgachNhanVien reqNgach = req.ngach();
        ReqSoYeuLyLich.ReqViecLam reqViecLam = req.viecLam();
        ReqSoYeuLyLich.ReqSucKhoe reqSucKhoe = req.sucKhoe();
        /////////////////////////////////////////////////////
        DanToc danToc = danTocRepository.findById(req.danToc()).orElse(null);
        ThanhPhanGiaDinh thanhPhanGiaDinh = thanhPhanGiaDinhRepository.findById(req.thanhPhanGiaDinh()).orElse(null);
//        DonVi donVi = donViRepository.findById(tuyenDung.coQuanToChucDonViTuyenDung()).orElse(null); //coQuanToChucDonViTuyenDung
        CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(tuyenDung.coQuanToChucDonViTuyenDung()).orElse(null); //coQuanToChucDonViTuyenDung

        CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoiRepository.findById(reqQuanSu.capBacLoaiQuanHamQuanDoi()).orElse(null);
        DoiTuongChinhSach doiTuongChinhSach = doiTuongChinhSachRepository.findById(req.doiTuongChinhSach()).orElse(null);
        TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong = trinhDoGiaoDucPhoThongRepository.findById(reqHocVan.trinhDoGiaoDucPhoThong()).orElse(null);
        TrinhDoChuyenMon trinhDoChuyenMon = trinhDoChuyenMonRepository.findById(reqHocVan.trinhDoChuyenMon()).orElse(null);
        HocHam hocHam = hocHamRepository.findById(reqHocVan.hocHam()).orElse(null);
        DanhHieuNhaNuoc danhHieuNhaNuocPhongTang = danhHieuNhaNuocPhongTangRepository.findById(reqHocVan.danhHieuNhaNuocPhongTang()).orElse(null);
        NhomMau nhomMau = nhomMauRepository.findById(reqSucKhoe.nhomMau()).orElse(null);
        ChucVu chucVu = chucVuRepository.findById(reqChucVu.chucVuHienTai()).orElse(null);
        ChucVu chucVuKiemNhiem = chucVuRepository.findById(req.chucVuKiemNhiem()).orElse(null);
        NgachCongChuc ngachCongChuc = ngachCongChucRepository.findById(reqNgach.ngach()).orElse(null);
        NgachVienChuc ngachVienChuc = ngachVienChucRepository.findById(reqNgach.ngach()).orElse(null);
        ViTriViecLam viTriViecLam = viTriViecLamRepository.findById(reqViecLam.viTriViecLam()).orElse(null);
        ChucDanhDang chucDanhDangHienTai = chucDanhDangRepository.findById(req.chucVuDangHienTai()).orElse(null);
        ChucDanhDang chucDanhDangKiemNhiem = chucDanhDangRepository.findById(req.chucVuDangKiemNhiem()).orElse(null);
        //table
        ThongTinTuyenDung thongTinTuyenDung = thongTinTuyenDungRepository.findById(syll.getId()).orElse(null);
        if (thongTinTuyenDung != null) {
            thongTinTuyenDung.setNgheNghiepTruocKhiTuyenDung(tuyenDung.ngheNghiepTruocKhiTuyenDung());
            thongTinTuyenDung.setNgayDuocTuyenDungLanDau(tuyenDung.ngayDuocTuyenDungLanDau());
            thongTinTuyenDung.setCoQuanToChucDonViTuyenDung(donVi);
            thongTinTuyenDung.setNgayVaoCoQuanHienDangCongTac(tuyenDung.ngayVaoCoQuanHienDangCongTac());
            thongTinTuyenDung.setNgayVaoDangCongSanVietNam(tuyenDung.ngayVaoDangCongSanVietNam());
            thongTinTuyenDung.setNgayChinhThuc(tuyenDung.ngayChinhThuc());
            thongTinTuyenDung.setNgayThamGiaToChucChinhTriXaHoiDauTien(tuyenDung.ngayThamGiaToChucChinhTriXaHoiDauTien());
            thongTinTuyenDung.setCongViecChinhDuocGiao(tuyenDung.congViecChinhDuocGiao());
            thongTinTuyenDung.setSoTruongCongTac(tuyenDung.soTruongCongTac());
            thongTinTuyenDung.setCongViecLamLauNhat(tuyenDung.congViecLamLauNhat());
            thongTinTuyenDung.setUpdate_at();
        } else
            thongTinTuyenDung = new ThongTinTuyenDung(tuyenDung.ngheNghiepTruocKhiTuyenDung(), tuyenDung.ngayDuocTuyenDungLanDau(), donVi,
                    tuyenDung.ngayVaoCoQuanHienDangCongTac(), tuyenDung.ngayVaoDangCongSanVietNam(), tuyenDung.ngayChinhThuc(), tuyenDung.ngayThamGiaToChucChinhTriXaHoiDauTien(),
                    tuyenDung.congViecChinhDuocGiao(), tuyenDung.soTruongCongTac(), tuyenDung.soTruongCongTac(), syll);
        NghiaVuQuanSu quanSu = nghiaVuQuanSuRepository.findById(syll.getId()).orElse(null);
        if (quanSu != null) {
            quanSu.setNgayNhapNgu(reqQuanSu.ngayNhapNgu());
            quanSu.setNgayXuatNgu(reqQuanSu.ngayXuatNgu());
            quanSu.setCapBacLoaiQuanHamQuanDoi(capBacLoaiQuanHamQuanDoi);
            quanSu.setUpdate_at();
        } else
            quanSu = new NghiaVuQuanSu(reqQuanSu.ngayNhapNgu(), reqQuanSu.ngayXuatNgu(), capBacLoaiQuanHamQuanDoi, syll);
        HocVan hocVan = hocVanRepository.findById(syll.getId()).orElse(null);
        if (hocVan != null) {
            hocVan.setTrinhDoGiaoDucPhoThong(trinhDoGiaoDucPhoThong);
            hocVan.setTrinhDoChuyenMon(trinhDoChuyenMon);
            hocVan.setHocHam(hocHam);
            hocVan.setDanhHieuNhaNuocPhongTang(danhHieuNhaNuocPhongTang);
            hocVan.setUpdate_at();
        } else hocVan = new HocVan(trinhDoGiaoDucPhoThong, trinhDoChuyenMon, hocHam, danhHieuNhaNuocPhongTang, syll);
        ChucVuHienTai chucVuHienTai = chucVu != null ? ChucVuHienTai.builder()
                .soYeuLyLich(syll)
                .chucVu(chucVu)
                .ngayBoNhiem(reqChucVu.ngayBoNhiem())
                .ngayBoNhiemLai(reqChucVu.ngayBoNhiemLai())
                .duocQuyHoacChucDanh(reqChucVu.duocQuyHoacChucDanh())
                .build() : null;
        NgachNhanVien ngach = ngachRepository.findById(syll.getId()).orElse(null);
        if (ngach != null) {
            if (ngachCongChuc != null) {
                ngach.setNgachCongChuc(ngachCongChuc);
                ngach.setNgachVienChuc(null);
            } else {
                ngach.setNgachVienChuc(ngachVienChuc);
                ngach.setNgachCongChuc(null);
            }
            ngach.setNgayBoNhiemNgach(reqNgach.ngayBoNhiemNgach());
            ngach.setNgayHuongLuongNgach(reqNgach.ngayHuongLuongNgach());
            ngach.setPhanTramHuongLuongNgach(reqNgach.phanTramHuongLuongNgach());
            ngach.setPhuCapThamNienVuotKhungNgach(reqNgach.phuCapThamNienVuotKhungNgach());
            ngach.setNgayHuongPCTNVKNgach(reqNgach.ngayHuongPCTNVKNgach());
            ngach.setUpdate_at();
        } else
            ngach = new NgachNhanVien(ngachCongChuc, ngachVienChuc, reqNgach.ngayBoNhiemNgach(), reqNgach.ngayHuongLuongNgach(),
                    reqNgach.phanTramHuongLuongNgach(), reqNgach.phuCapThamNienVuotKhungNgach(), reqNgach.ngayHuongPCTNVKNgach(), syll);
        ViecLam viecLam = viecLamRepository.findById(syll.getId()).orElse(null);
        if (viecLam != null) {
            viecLam.setViTriViecLam(viTriViecLam);
            viecLam.setNgayHuongLuongTheoViTriViecLam(reqViecLam.ngayHuongLuongViTriViecLam());
            viecLam.setPhamTramHuongLuong(reqViecLam.phamTramHuongLuong());
            viecLam.setPhuCapThamNienVuotKhung(reqViecLam.phuCapThamNienVuotKhung());
            viecLam.setNgayHuongPCTNVK(reqViecLam.ngayHuongPCTNVK());
        } else viecLam = new ViecLam(viTriViecLam, reqViecLam.ngayHuongLuongViTriViecLam(),
                reqViecLam.phamTramHuongLuong(), reqViecLam.phuCapThamNienVuotKhung(), reqViecLam.ngayHuongPCTNVK(), syll);

        SucKhoe sucKhoe = sucKhoeRepository.findById(syll.getId()).orElse(null);
        if (sucKhoe != null) {
            sucKhoe.setTinhTrangSucKhoe(reqSucKhoe.tinhTrangSucKhoe());
            sucKhoe.setChieuCao(reqSucKhoe.chieuCao());
            sucKhoe.setCanNang(reqSucKhoe.canNang());
            sucKhoe.setNhomMau(nhomMau);
            sucKhoe.setUpdate_at();
        } else
            sucKhoe = new SucKhoe(reqSucKhoe.tinhTrangSucKhoe(), reqSucKhoe.chieuCao(), reqSucKhoe.canNang(), nhomMau, syll);
        syll.setHoVaTen(req.hovaten());
        syll.setGioiTinh(req.gioiTinh());
        syll.setCacTenGoiKhac(req.cacTenGoiKhac());
        syll.setSinhNgay(req.sinhNgay());
        syll.setNoiSinh(req.noiSinh());
        syll.setQueQuan(req.queQuan());
        syll.setDanToc(danToc);
        syll.setSoCCCD(req.soCCCD());
        syll.setNgayCapCCCD(req.ngayCapCCCD());
        syll.setSoDienThoai(req.soDienThoai());
        syll.setSoBHXH(req.soBHXH());
        syll.setSoBHYT(req.soBHYT());
        syll.setNoiOHienNay(req.noiOHienNay());
        syll.setThanhPhanGiaDinh(thanhPhanGiaDinh);
        syll.setThongTinTuyenDung(thongTinTuyenDung);
        syll.setQuanSu(quanSu);
        syll.setDoiTuongChinhSach(doiTuongChinhSach);
        syll.setHocVan(hocVan);
        syll.setChucVuHienTai(chucVuHienTai);
        syll.setChucVuKiemNhiem(chucVuKiemNhiem);
        syll.setChucVuDangHienTai(chucDanhDangHienTai);
        syll.setChucVuDangKiemNhiem(chucDanhDangKiemNhiem);
        syll.setTienLuong(req.tienLuong());
        syll.setNgach(ngach);
        syll.setPhuCapChucVu(req.phuCapChucVu());
        syll.setPhuCapKiemNhiem(req.phuCapKiemNhiem());
        syll.setPhuCapKhac(req.phuCapKhac());
        syll.setViecLam(viecLam);
        syll.setSucKhoe(sucKhoe);
        syll.setPheDuyet(PheDuyet.CHO_PHE_DUYET);
        syll.setUpdate_at();
        return syll;
    }

//    private SoYeuLyLich mapToSoYeuLyLich2(ReqSoYeuLyLich reqSoYeuLyLich) {
//        DanToc danToc = danTocRepository.findById(reqSoYeuLyLich.danToc()).orElse(null);
//        ThanhPhanGiaDinh thanhPhanGiaDinh = thanhPhanGiaDinhRepository.findById(reqSoYeuLyLich.thanhPhanGiaDinh()).orElse(null);
//        CoQuanToChucDonVi coQuanToChucDonViTuyenDung = coQuanToChucDonViRepository.findById(reqSoYeuLyLich.coQuanToChucDonViTuyenDung()).orElse(null);
//        CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoiRepository.findById(reqSoYeuLyLich.capBacLoaiQuanHamQuanDoi()).orElse(null);
//        DoiTuongChinhSach doiTuongChinhSach = doiTuongChinhSachRepository.findById(reqSoYeuLyLich.doiTuongChinhSach()).orElse(null);
//        TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong = trinhDoGiaoDucPhoThongRepository.findById(reqSoYeuLyLich.hocVan().getTrinhDoGiaoDucPhoThong().getId()).orElse(null);
//        TrinhDoChuyenMon trinhDoChuyenMon = trinhDoChuyenMonRepository.findById(reqSoYeuLyLich.hocVan().getTrinhDoChuyenMon().getId()).orElse(null);
//        HocHam hocHam = hocHamRepository.findById(reqSoYeuLyLich.hocVan().getHocHam().getId()).orElse(null);
//        DanhHieuNhaNuoc danhHieuNhaNuocPhongTang = danhHieuNhaNuocPhongTangRepository.findById(reqSoYeuLyLich.hocVan().getDanhHieuNhaNuocPhongTang().getId()).orElse(null);
//        NhomMau nhomMau = nhomMauRepository.findById(reqSoYeuLyLich.nhomMau()).orElse(null);
//        ChucVu chucVu = chucVuRepository.findById(reqSoYeuLyLich.chucVuHienTai()).orElse(null);
//        ChucVu chucVuKiemNhiem = chucVuRepository.findById(reqSoYeuLyLich.chucVuKiemNhiem()).orElse(null);
//        NgachCongChuc ngachCongChuc = ngachCongChucRepository.findById(reqSoYeuLyLich.ngachNgheNghiep()).orElse(null);
//        NgachVienChuc ngachVienChuc = ngachVienChucRepository.findById(reqSoYeuLyLich.ngachNgheNghiep()).orElse(null);
//        ViTriViecLam viTriViecLam = viTriViecLamRepository.findById(reqSoYeuLyLich.viTriViecLam()).orElse(null);
//        ChucDanhDang chucDanhDangHienTai = chucDanhDangRepository.findById(reqSoYeuLyLich.chucVuDangHienTai()).orElse(null);
//        ChucDanhDang chucDanhDangKiemNhiem = chucDanhDangRepository.findById(reqSoYeuLyLich.chucVuDangKiemNhiem()).orElse(null);
//        return SoYeuLyLich.builder()
////                .hoVaTen(reqSoYeuLyLich.hovaten())
////                .gioiTinh(reqSoYeuLyLich.gioiTinh())
////                .cacTenGoiKhac(reqSoYeuLyLich.cacTenGoiKhac())
////                .sinhNgay(reqSoYeuLyLich.sinhNgay())
////                .noiSinh(reqSoYeuLyLich.noiSinh())
////                .queQuan(reqSoYeuLyLich.queQuan())
////                .danToc(danToc)
////                .soCCCD(reqSoYeuLyLich.soCCCD())
////                .ngayCapCCCD(reqSoYeuLyLich.ngayCapCCCD())
////                .soDienThoai(reqSoYeuLyLich.soDienThoai())
////                .soBHXH(reqSoYeuLyLich.soBHXH())
////                .soBHYT(reqSoYeuLyLich.soBHYT())
////                .noiOHienNay(reqSoYeuLyLich.noiOHienNay())
////                .thanhPhanGiaDinh(thanhPhanGiaDinh)
////                .ngheNghiepTruocKhiTuyenDung(reqSoYeuLyLich.ngheNghiepTruocKhiTuyenDung())
////                .ngayDuocTuyenDungLanDau(reqSoYeuLyLich.ngayDuocTuyenDungLanDau())
////                .coQuanToChucDonViTuyenDung(null)
////                .ngayVaoCoQuanHienDangCongTac(reqSoYeuLyLich.ngayVaoCoQuanHienDangCongTac())
////                .ngayVaoDangCongSanVietNam(reqSoYeuLyLich.ngayVaoDangCongSanVietNam())
////                .ngayChinhThuc(reqSoYeuLyLich.ngayChinhThuc())
////                .ngayThamGiaToChucChinhTriXaHoiDauTien(reqSoYeuLyLich.ngayThamGiaToChucChinhTriXaHoiDauTien())
////                .ngayNhapNgu(reqSoYeuLyLich.ngayNhapNgu())
////                .ngayXuatNgu(reqSoYeuLyLich.ngayXuatNgu())
////                .capBacLoaiQuanHamQuanDoi(capBacLoaiQuanHamQuanDoi)
//                .doiTuongChinhSach(doiTuongChinhSach)
////                .trinhDoGiaoDucPhoThong(trinhDoGiaoDucPhoThong)
////                .trinhDoChuyenMon(trinhDoChuyenMon)
////                .hocHam(hocHam)
////                .danhHieuNhaNuocPhongTang(danhHieuNhaNuocPhongTang)
////                .chucVuHienTai(chucVu)
////                .ngayBoNhiem(reqSoYeuLyLich.ngayBoNhiem())
////                .ngayBoNhiemLai(reqSoYeuLyLich.ngayBoNhiemLai())
////                .duocQuyHoacChucDanh(reqSoYeuLyLich.duocQuyHoacChucDanh())
//                .chucVuKiemNhiem(chucVuKiemNhiem)
//                .chucVuDangHienTai(chucDanhDangHienTai)
//                .chucVuDangKiemNhiem(chucDanhDangKiemNhiem)
////                .congViecChinhDuocGiao(reqSoYeuLyLich.congViecChinhDuocGiao())
////                .soTruongCongTac(reqSoYeuLyLich.soTruongCongTac())
////                .congViecLamLauNhat(reqSoYeuLyLich.congViecLamLauNhat())
//                .tienLuong(reqSoYeuLyLich.tienLuong())
////                .ngachVienChuc(ngachVienChuc)
////                .ngachCongChuc(ngachCongChuc)
////                .ngayBoNhiemNgach(reqSoYeuLyLich.ngayBoNhiemNgachNgheNghiep())
////                .ngayHuongLuongNgach(reqSoYeuLyLich.ngayHuongLuongNgachNgheNghiep())
////                .phanTramHuongLuongNgach(reqSoYeuLyLich.phanTramHuongLuongNgachNgheNghiep())
////                .phuCapThamNienVuotKhungNgach(reqSoYeuLyLich.phuCapThamNienVuotKhungNgachNgheNghiep())
////                .ngayHuongPCTNVKNgach(reqSoYeuLyLich.ngayHuongPCTNVKNgachNgheNghiep())
//                .phuCapChucVu(reqSoYeuLyLich.phuCapChucVu())
//                .phuCapKiemNhiem(reqSoYeuLyLich.phuCapKiemNhiem())
//                .phuCapKhac(reqSoYeuLyLich.phuCapKhac())
////                .viTriViecLam(viTriViecLam)
////                .ngayHuongLuongTheoViTriViecLam(reqSoYeuLyLich.ngayHuongLuongTheoViTriViecLam())
////                .phamTramHuongLuong(reqSoYeuLyLich.phamTramHuongLuong())
////                .phuCapThamNienVuotKhung(reqSoYeuLyLich.phuCapThamNienVuotKhung())
////                .ngayHuongPCTNVK(reqSoYeuLyLich.ngayHuongPCTNVK())
////                .tinhTrangSucKhoe(reqSoYeuLyLich.tinhTrangSucKhoe())
////                .chieuCao(reqSoYeuLyLich.chieuCao())
////                .canNang(reqSoYeuLyLich.canNang())
////                .nhomMau(nhomMau)
//                .build();
//    }

}
