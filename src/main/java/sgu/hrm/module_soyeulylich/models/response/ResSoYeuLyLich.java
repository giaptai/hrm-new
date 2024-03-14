package sgu.hrm.module_soyeulylich.models.response;

import lombok.Builder;
import sgu.hrm.module_heso_luong_ngach.models.HeSoLuongCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.NgachVienChuc;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_utilities.enums.GioiTinh;
import sgu.hrm.module_utilities.enums.TinhTrangSucKhoe;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.ChucDanhDang;
import sgu.hrm.module_utilities.models.ChucVu;
import sgu.hrm.module_utilities.models.DanToc;
import sgu.hrm.module_utilities.models.DanhHieuNhaNuoc;
import sgu.hrm.module_utilities.models.DoiTuongChinhSach;
import sgu.hrm.module_utilities.models.HocHam;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;
import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.module_utilities.models.ViTriViecLam;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Builder
public record ResSoYeuLyLich(
        UUID id,
        String hoVaTen,

        GioiTinh gioiTinh,

        String cacTenGoiKhac,

        LocalDateTime sinhNgay,

        String noiSinh,

        String queQuan,

        String danToc, //DanToc danToc,

        String soCCCD,

        LocalDateTime ngayCapCCCD,

        String soDienThoai,

        String soBHXH,

        String soBHYT,

        String noiOHienNay,

        String thanhPhanGiaDinh, //ThanhPhanGiaDinh thanhPhanGiaDinh,

        String ngheNghiepTruocKhiTuyenDung,

        LocalDateTime ngayDuocTuyenDungLanDau,

        String coQuanToChucDonViTuyenDung, //CoQuanToChucDonViTuyenDung coQuanToChucDonViTuyenDung,

        LocalDateTime ngayVaoCoQuanHienDangCongTac,

        LocalDateTime ngayVaoDangCongSanVietNam,

        LocalDateTime ngayChinhThuc,

        LocalDateTime ngayThamGiaToChucChinhTriXaHoiDauTien,

        LocalDateTime ngayNhapNgu,

        LocalDateTime ngayXuatNgu,

        String capBacLoaiQuanHamQuanDoi, //CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi,

        String doiTuongChinhSach, //DoiTuongChinhSach doiTuongChinhSach,

        String trinhDoGiaoDucPhoThong, //TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong,

        String trinhDoChuyenMon, //TrinhDoChuyenMon trinhDoChuyenMon,

        String hocHam, //HocHam hocHam,

        String danhHieuNhaNuocPhongTang, //DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang,

        String chucVuHienTai,

        LocalDateTime ngayBoNhiem,

        LocalDateTime ngayBoNhiemLai,

        String duocQuyHoacChucDanh,

        String chucVuKiemNhiem,

        String chucVuDangHienTai, //ChucDanhDang chucDanhDang

        String chucVuDangKiemNhiem,

        String congViecChinhDuocGiao,

        String soTruongCongTac,

        String congViecLamLauNhat,

        double tienLuong,

        String ngach,

        String maSoNgach,

        LocalDateTime ngayBoNhiemNgach,

        String bacLuong, //BacLuong bacLuong,

        float heSoLuongNgach,

        LocalDateTime ngayHuongLuongNgach,

        float phanTramHuongLuongNgach,

        double phuCapThamNienVuotKhungNgach,

        LocalDateTime ngayHuongPCTNVKNgach,

        double phuCapChucVu,

        double phuCapKiemNhiem,

        double phuCapKhac,

        String viTriViecLam,

        String maSoViTriViecLam,

        String bacLuongTriViecLam,

        double luongTheoMucTien,

        LocalDateTime ngayHuongLuongTheoViTriViecLam,

        float phamTramHuongLuong,

        double phuCapThamNienVuotKhung,

        LocalDateTime ngayHuongPCTNVK,

        TinhTrangSucKhoe tinhTrangSucKhoe, //TinhTrangSucKhoe tinhTrangSucKhoe,

        float chieuCao,
        float canNang,
        String nhomMau, //NhomMau nhomMau,
        boolean trangThai,
        String pheDuyet,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResSoYeuLyLich mapToResSoYeuLyLich(SoYeuLyLich soYeuLyLich) {
//        String bacLuongName = Optional.ofNullable(soYeuLyLich.getNgachCongChuc())
//                .map(nagcCongChuc -> nagcCongChuc.getHeSoLuongCongChuc())
//                .map(heSoLuong -> Optional.ofNullable(heSoLuong.getBacLuong())
//                        .map(bacLuong -> bacLuong.getName())
//                        .orElse(""))
//                .orElseGet(() ->
//                        Optional.ofNullable(soYeuLyLich.getNgachVienChuc())
//                                .map(ngachVienChuc -> ngachVienChuc.getHeSoLuongVienChuc())
//                                .map(heSoLuong -> Optional.ofNullable(heSoLuong.getBacLuong())
//                                        .map(bacLuong -> bacLuong.getName())
//                                        .orElse(""))
//                                .orElse("")
//                );

        return ResSoYeuLyLich.builder()
                .id(soYeuLyLich.getId())
//                .hoVaTen(soYeuLyLich.getHoVaTen())
//                .gioiTinh(soYeuLyLich.getGioiTinh())
//                .cacTenGoiKhac(soYeuLyLich.getCacTenGoiKhac())
//                .sinhNgay(soYeuLyLich.getSinhNgay())
//                .noiSinh(soYeuLyLich.getNoiSinh())
//                .queQuan(soYeuLyLich.getQueQuan())
//                .danToc(Optional.ofNullable(soYeuLyLich.getDanToc()).map(DanToc::getName).orElse(""))
//                .soCCCD(soYeuLyLich.getSoCCCD())
//                .ngayCapCCCD(soYeuLyLich.getNgayCapCCCD())
//                .soDienThoai(soYeuLyLich.getSoDienThoai())
//                .soBHXH(soYeuLyLich.getSoBHXH())
//                .soBHYT(soYeuLyLich.getSoBHYT())
//                .noiOHienNay(soYeuLyLich.getNoiOHienNay())
//                .thanhPhanGiaDinh(Optional.ofNullable(soYeuLyLich.getThanhPhanGiaDinh()).map(ThanhPhanGiaDinh::getName).orElse(""))
//                .ngheNghiepTruocKhiTuyenDung(soYeuLyLich.getNgheNghiepTruocKhiTuyenDung())
//                .ngayDuocTuyenDungLanDau(soYeuLyLich.getNgayDuocTuyenDungLanDau())
//                .coQuanToChucDonViTuyenDung(soYeuLyLich.getCoQuanToChucDonViTuyenDung() != null ? soYeuLyLich.getCoQuanToChucDonViTuyenDung().getName() : "")
//                .ngayVaoCoQuanHienDangCongTac(soYeuLyLich.getNgayVaoCoQuanHienDangCongTac())
//                .ngayVaoDangCongSanVietNam(soYeuLyLich.getNgayVaoDangCongSanVietNam())
//                .ngayChinhThuc(soYeuLyLich.getNgayChinhThuc())
//                .ngayThamGiaToChucChinhTriXaHoiDauTien(soYeuLyLich.getNgayThamGiaToChucChinhTriXaHoiDauTien())
//                .ngayNhapNgu(soYeuLyLich.getNgayXuatNgu())
//                .ngayXuatNgu(soYeuLyLich.getNgayNhapNgu())
//                .capBacLoaiQuanHamQuanDoi(Optional.ofNullable(soYeuLyLich.getCapBacLoaiQuanHamQuanDoi()).map(CapBacLoaiQuanHamQuanDoi::getName).orElse(""))
                .doiTuongChinhSach(Optional.ofNullable(soYeuLyLich.getDoiTuongChinhSach()).map(DoiTuongChinhSach::getName).orElse(""))
//                .trinhDoGiaoDucPhoThong(Optional.ofNullable(soYeuLyLich.getTrinhDoGiaoDucPhoThong()).map(TrinhDoGiaoDucPhoThong::getName).orElse(""))
//                .trinhDoChuyenMon(Optional.ofNullable(soYeuLyLich.getTrinhDoChuyenMon()).map(TrinhDoChuyenMon::getName).orElse(""))
//                .hocHam(Optional.ofNullable(soYeuLyLich.getHocHam()).map(HocHam::getName).orElse(""))
//                .danhHieuNhaNuocPhongTang(Optional.ofNullable(soYeuLyLich.getDanhHieuNhaNuocPhongTang()).map(DanhHieuNhaNuoc::getName).orElse(""))
                .chucVuHienTai(Optional.ofNullable(soYeuLyLich.getChucVuHienTai().getChucVu()).map(ChucVu::getName).orElse(""))
//                .ngayBoNhiem(soYeuLyLich.getNgayBoNhiem())
//                .ngayBoNhiemLai(soYeuLyLich.getNgayBoNhiemLai())
//                .duocQuyHoacChucDanh(soYeuLyLich.getDuocQuyHoacChucDanh())
                .chucVuKiemNhiem(Optional.ofNullable(soYeuLyLich.getChucVuKiemNhiem()).map(ChucVu::getName).orElse(""))
                .chucVuDangHienTai(Optional.ofNullable(soYeuLyLich.getChucVuDangHienTai()).map(ChucDanhDang::getName).orElse(""))
                .chucVuDangKiemNhiem(Optional.ofNullable(soYeuLyLich.getChucVuDangKiemNhiem()).map(ChucDanhDang::getName).orElse(""))
//                .congViecChinhDuocGiao(soYeuLyLich.getCongViecChinhDuocGiao())
//                .soTruongCongTac(soYeuLyLich.getSoTruongCongTac())
//                .congViecLamLauNhat(soYeuLyLich.getCongViecLamLauNhat())
                .tienLuong(soYeuLyLich.getTienLuong())
//                .ngach(soYeuLyLich.getNgachCongChuc() != null ? soYeuLyLich.getNgachCongChuc().getName() : (Optional.ofNullable(soYeuLyLich.getNgachVienChuc()).map(NgachVienChuc::getName).orElse("")))
//                .maSoNgach(soYeuLyLich.getNgachCongChuc() != null ? soYeuLyLich.getNgachCongChuc().getId() : (Optional.ofNullable(soYeuLyLich.getNgachVienChuc()).map(NgachVienChuc::getId).orElse("")))
//                .ngayBoNhiemNgach(soYeuLyLich.getNgayBoNhiemNgach())
//                .bacLuong(bacLuongName)
//                .heSoLuongNgach(soYeuLyLich.getNgachCongChuc() != null ? Optional.ofNullable(soYeuLyLich.getNgachCongChuc().getHeSoLuongCongChuc()).map(HeSoLuongCongChuc::getHeSo).orElse(0.0f) : (Optional.ofNullable(soYeuLyLich.getNgachVienChuc()).map(ngachVienChuc -> ngachVienChuc.getHeSoLuongVienChuc().getHeSo()).orElse(0.0f)))
//                .ngayHuongLuongNgach(soYeuLyLich.getNgayHuongLuongNgach())
//                .phanTramHuongLuongNgach(soYeuLyLich.getPhanTramHuongLuongNgach())
//                .phuCapThamNienVuotKhungNgach(soYeuLyLich.getPhuCapThamNienVuotKhungNgach())
//                .ngayHuongPCTNVKNgach(soYeuLyLich.getNgayHuongPCTNVKNgach())
                .phuCapChucVu(soYeuLyLich.getPhuCapChucVu())
                .phuCapKiemNhiem(soYeuLyLich.getPhuCapKiemNhiem())
                .phuCapKhac(soYeuLyLich.getPhuCapKhac())
//                .viTriViecLam(Optional.ofNullable(soYeuLyLich.getViTriViecLam()).map(ViTriViecLam::getName).orElse(""))
//                .maSoViTriViecLam(Optional.ofNullable(soYeuLyLich.getViTriViecLam()).map(lam -> String.valueOf(lam.getId())).orElse(""))
//                .bacLuongTriViecLam(soYeuLyLich.getViTriViecLam() != null ? soYeuLyLich.getViTriViecLam().getBacLuong().getName() : "")
//                .luongTheoMucTien(Optional.ofNullable(soYeuLyLich.getViTriViecLam()).map(ViTriViecLam::getTienLuong).orElse(0.0))
//                .ngayHuongLuongTheoViTriViecLam(soYeuLyLich.getNgayHuongLuongTheoViTriViecLam())
//                .phamTramHuongLuong(soYeuLyLich.getPhamTramHuongLuong())
//                .phuCapThamNienVuotKhung(soYeuLyLich.getPhuCapThamNienVuotKhung())
//                .ngayHuongPCTNVK(soYeuLyLich.getNgayHuongPCTNVK())
//                .tinhTrangSucKhoe(soYeuLyLich.getTinhTrangSucKhoe())
//                .chieuCao(soYeuLyLich.getChieuCao())
//                .canNang(soYeuLyLich.getCanNang())
//                .nhomMau(Optional.ofNullable(soYeuLyLich.getNhomMau()).map(NhomMau::getName).orElse(""))
                .trangThai(soYeuLyLich.isTrangThai())
                .pheDuyet(soYeuLyLich.getPheDuyet().getName())
                .create_at(soYeuLyLich.getCreate_at())
                .update_at(soYeuLyLich.getUpdate_at())
                .build();
    }
}
