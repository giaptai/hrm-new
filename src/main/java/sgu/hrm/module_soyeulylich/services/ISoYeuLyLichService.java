package sgu.hrm.module_soyeulylich.services;

import sgu.hrm.module_congchuc_vienchuc.models.NgachVienChuc;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_soyeulylich.models.request.ReqDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.request.ReqSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.response.ResDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.response.ResSoYeuLyLich;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.ChucDanhDang;
import sgu.hrm.module_utilities.models.ChucVu;
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
import sgu.hrm.module_utilities.models.ViTriViecLam;;import java.util.Optional;

public interface ISoYeuLyLichService {
    ResDTO<?> xemThongTinSoYeuLyLich();

    public ResDTO<ResSoYeuLyLich> capNhatSoYeuLyLich(ReqSoYeuLyLich reqSoYeuLyLich);

    public ResDTO<?> xemDanhSachSoYeuLyLich();

    ResDTO<ResSoYeuLyLich> xemSoYeuLyLichTheoSoCCCDHoacID(String q);

    ResDTO<?> xemSoYeuLyLichTheoId(String id);

    ResDTO<?> pheDuyetSoYeuLyLich(String id, ReqDSSoYeuLyLich reqDSSoYeuLyLich);

    static ResSoYeuLyLich mapToResSoYeuLyLich(SoYeuLyLich soYeuLyLich) {
        return ResSoYeuLyLich.builder()
                .hovaten(soYeuLyLich.getHovaten())
                .gioiTinh(Optional.ofNullable(soYeuLyLich.getGioiTinh()).map(GioiTinh::getName).orElse(""))
                .cacTenGoiKhac(soYeuLyLich.getCacTenGoiKhac())
                .sinhNgay(soYeuLyLich.getSinhNgay())
                .noiSinh(soYeuLyLich.getNoiSinh())
                .queQuan(soYeuLyLich.getQueQuan())
                .danToc(Optional.ofNullable(soYeuLyLich.getDanToc()).map(DanToc::getName).orElse(""))
                .soCCCD(soYeuLyLich.getSoCCCD())
                .ngayCapCCCD(soYeuLyLich.getNgayCapCCCD())
                .soDienThoai(soYeuLyLich.getSoDienThoai())
                .soBHXH(soYeuLyLich.getSoBHXH())
                .soBHYT(soYeuLyLich.getSoBHYT())
                .noiOHienNay(soYeuLyLich.getNoiOHienNay())
                .thanhPhanGiaDinh(Optional.ofNullable(soYeuLyLich.getThanhPhanGiaDinh()).map(ThanhPhanGiaDinh::getName).orElse(""))
                .ngheNghiepTruocKhiTuyenDung(soYeuLyLich.getNgheNghiepTruocKhiTuyenDung())
                .ngayDuocTuyenDungLanDau(soYeuLyLich.getNgayDuocTuyenDungLanDau())
                .coQuanToChucDonViTuyenDung(soYeuLyLich.getCoQuanToChucDonViTuyenDung() != null ? soYeuLyLich.getCoQuanToChucDonViTuyenDung() : "")
                .ngayVaoCoQuanHienDangCongTac(soYeuLyLich.getNgayVaoCoQuanHienDangCongTac())
                .ngayVaoDangCongSanVietNam(soYeuLyLich.getNgayVaoDangCongSanVietNam())
                .ngayChinhThuc(soYeuLyLich.getNgayChinhThuc())
                .ngayThamGiaToChucChinhTriXaHoiDauTien(soYeuLyLich.getNgayThamGiaToChucChinhTriXaHoiDauTien())
                .ngayNhapNgu(soYeuLyLich.getNgayXuatNgu())
                .ngayXuatNgu(soYeuLyLich.getNgayNhapNgu())
                .capBacLoaiQuanHamQuanDoi(Optional.ofNullable(soYeuLyLich.getCapBacLoaiQuanHamQuanDoi()).map(CapBacLoaiQuanHamQuanDoi::getName).orElse(""))
                .doiTuongChinhSach(Optional.ofNullable(soYeuLyLich.getDoiTuongChinhSach()).map(DoiTuongChinhSach::getName).orElse(""))
                .trinhDoGiaoDucPhoThong(Optional.ofNullable(soYeuLyLich.getTrinhDoGiaoDucPhoThong()).map(TrinhDoGiaoDucPhoThong::getName).orElse(""))
                .trinhDoChuyenMon(Optional.ofNullable(soYeuLyLich.getTrinhDoChuyenMon()).map(TrinhDoChuyenMon::getName).orElse(""))
                .hocHam(Optional.ofNullable(soYeuLyLich.getHocHam()).map(HocHam::getName).orElse(""))
                .danhHieuNhaNuocPhongTang(Optional.ofNullable(soYeuLyLich.getDanhHieuNhaNuocPhongTang()).map(DanhHieuNhaNuocPhongTang::getName).orElse(""))
                .chucVuHienTai(Optional.ofNullable(soYeuLyLich.getChucVuHienTai()).map(ChucVu::getName).orElse(""))
                .ngayBoNhiem(soYeuLyLich.getNgayBoNhiem())
                .ngayBoNhiemLai(soYeuLyLich.getNgayBoNhiemLai())
                .duocQuyHoacChucDanh(soYeuLyLich.getDuocQuyHoacChucDanh())
                .chucVuKiemNhiem(soYeuLyLich.getChucVuKiemNhiem())
                .chucVuDangHienTai(Optional.ofNullable(soYeuLyLich.getChucVuDangHienTai()).map(ChucDanhDang::getName).orElse(""))
                .chucVuDangKiemNhiem(Optional.ofNullable(soYeuLyLich.getChucVuDangKiemNhiem()).map(ChucDanhDang::getName).orElse(""))
                .congViecChinhDuocGiao(soYeuLyLich.getCongViecChinhDuocGiao())
                .soTruongCongTac(soYeuLyLich.getSoTruongCongTac())
                .congViecLamLauNhat(soYeuLyLich.getCongViecLamLauNhat())
                .tienLuong(soYeuLyLich.getTienLuong())
//                .ngachNgheNghiep(soYeuLyLich.getNgachCongChuc() != null ? soYeuLyLich.getNgachCongChuc().getName() : (Optional.ofNullable(soYeuLyLich.getNgachVienChuc()).map(NgachVienChuc::getName).orElse("")))
//                .maSoNgachNgheNghiep(soYeuLyLich.getNgachCongChuc() != null ? soYeuLyLich.getNgachCongChuc().getId() : (Optional.ofNullable(soYeuLyLich.getNgachVienChuc()).map(NgachVienChuc::getId).orElse("")))
//                .ngayBoNhiemNgachNgheNghiep(soYeuLyLich.getNgayBoNhiemNgachNgheNghiep())
//                .bacLuong(soYeuLyLich.getNgachCongChuc() != null ? soYeuLyLich.getNgachCongChuc().getHeSoLuongCongChuc().getBacLuong().getName() : (Optional.ofNullable(soYeuLyLich.getNgachVienChuc()).map(ngachVienChuc -> ngachVienChuc.getHeSoLuongVienChuc().getBacLuong().getName()).orElse("")))
//                .heSoLuongNgachNgheNghiep(soYeuLyLich.getNgachCongChuc() != null ? soYeuLyLich.getNgachCongChuc().getHeSoLuongCongChuc().getHeSo() : (Optional.ofNullable(soYeuLyLich.getNgachVienChuc()).map(ngachVienChuc -> ngachVienChuc.getHeSoLuongVienChuc().getHeSo()).orElse(0.0f)))
//                .ngayHuongLuongNgachNgheNghiep(soYeuLyLich.getNgayHuongLuongNgachNgheNghiep())
//                .phanTramHuongLuongNgachNgheNghiep(soYeuLyLich.getPhanTramHuongLuongNgachNgheNghiep())
//                .phuCapThamNienVuotKhungNgachNgheNghiep(soYeuLyLich.getPhuCapThamNienVuotKhungNgachNgheNghiep())
//                .ngayHuongPCTNVKNgachNgheNghiep(soYeuLyLich.getNgayHuongPCTNVKNgachNgheNghiep())
                .phuCapChucVu(soYeuLyLich.getPhuCapChucVu())
                .phuCapKiemNhiem(soYeuLyLich.getPhuCapKiemNhiem())
                .phuCapKhac(soYeuLyLich.getPhuCapKhac())
                .viTriViecLam(Optional.ofNullable(soYeuLyLich.getViTriViecLam()).map(ViTriViecLam::getName).orElse(""))
                .maSoViTriViecLam(Optional.ofNullable(soYeuLyLich.getViTriViecLam()).map(lam -> String.valueOf(lam.getId())).orElse(""))
                .bacLuongTriViecLam(Optional.ofNullable(soYeuLyLich.getViTriViecLam()).map(ViTriViecLam::getBacLuong).orElse(0))
                .luongTheoMucTien(Optional.ofNullable(soYeuLyLich.getViTriViecLam()).map(ViTriViecLam::getTienLuong).orElse(0.0))
                .ngayHuongLuongTheoViTriViecLam(soYeuLyLich.getNgayHuongLuongTheoViTriViecLam())
                .phamTramHuongLuong(soYeuLyLich.getPhamTramHuongLuong())
                .phuCapThamNienVuotKhung(soYeuLyLich.getPhuCapThamNienVuotKhung())
                .ngayHuongPCTNVK(soYeuLyLich.getNgayHuongPCTNVK())
                .tinhTrangSucKhoe(Optional.ofNullable(soYeuLyLich.getTinhTrangSucKhoe()).map(TinhTrangSucKhoe::getTitle).orElse(""))
                .chieuCao(soYeuLyLich.getChieuCao())
                .canNang(soYeuLyLich.getCanNang())
                .nhomMau(Optional.ofNullable(soYeuLyLich.getNhomMau()).map(NhomMau::getName).orElse(""))
//                .luongThucNhan(tinhLuongThucNhan(soYeuLyLich.getTienLuong(), soYeuLyLich.getNgachCongChuc().getHeSoLuongCongChuc().getHeSo(), soYeuLyLich.getPhanTramHuongLuongNgachNgheNghiep(), soYeuLyLich.getPhuCapThamNienVuotKhungNgachNgheNghiep(),
//                        soYeuLyLich.getPhuCapChucVu(), soYeuLyLich.getPhuCapKiemNhiem(), soYeuLyLich.getPhuCapKhac(),
//                        soYeuLyLich.getViTriViecLam().getTienLuong(), soYeuLyLich.getPhamTramHuongLuong(), soYeuLyLich.getPhuCapThamNienVuotKhung()))
                .build();
    }

    static ResDSSoYeuLyLich RES_DS_SO_YEU_LY_LICH(SoYeuLyLich soYeuLyLich) {
        return new ResDSSoYeuLyLich(
                soYeuLyLich.getId(),
                soYeuLyLich.getHovaten(),
                soYeuLyLich.getSinhNgay() != null ? soYeuLyLich.getSinhNgay() : null,
                soYeuLyLich.getChucVuHienTai() != null ? soYeuLyLich.getChucVuHienTai().getName() : null,
                soYeuLyLich.getTrinhDoChuyenMon() != null ? soYeuLyLich.getTrinhDoChuyenMon().getName() : null,
                soYeuLyLich.getNgachCongChuc() != null ? soYeuLyLich.getNgachCongChuc().getName() : (soYeuLyLich.getNgachVienChuc() != null ? soYeuLyLich.getNgachVienChuc().getName() : null),
                soYeuLyLich.getDanToc() != null ? soYeuLyLich.getDanToc().getName() : null,
                soYeuLyLich.getCreate_at(),
                soYeuLyLich.getUpdate_at(),
                soYeuLyLich.isTrangThai()
        );
    }
}
