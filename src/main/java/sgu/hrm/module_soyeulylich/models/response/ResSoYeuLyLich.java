package sgu.hrm.module_soyeulylich.models.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import sgu.hrm.module_congchuc_vienchuc.models.NgachVienChuc;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
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
import sgu.hrm.module_utilities.models.ViTriViecLam;

import java.time.LocalDateTime;
import java.util.Optional;

@Builder
public record ResSoYeuLyLich(
        String hovaten,

        String gioiTinh,

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

        String ngachNgheNghiep,

        String maSoNgachNgheNghiep,

        LocalDateTime ngayBoNhiemNgachNgheNghiep,

        String bacLuong, //BacLuong bacLuong,

        float heSoLuongNgachNgheNghiep,

        LocalDateTime ngayHuongLuongNgachNgheNghiep,

        double phanTramHuongLuongNgachNgheNghiep,

        float phuCapThamNienVuotKhungNgachNgheNghiep,

        LocalDateTime ngayHuongPCTNVKNgachNgheNghiep,

        float phuCapChucVu,

        float phuCapKiemNhiem,

        float phuCapKhac,

        String viTriViecLam,

        String maSoViTriViecLam,

        double bacLuongTriViecLam,

        double luongTheoMucTien,

        LocalDateTime ngayHuongLuongTheoViTriViecLam,

        double phamTramHuongLuong,

        double phuCapThamNienVuotKhung,

        LocalDateTime ngayHuongPCTNVK,

        String tinhTrangSucKhoe, //TinhTrangSucKhoe tinhTrangSucKhoe,

        double chieuCao,

        double canNang,

        String nhomMau, //NhomMau nhomMau,

        double luongThucNhan,
        boolean trangThai,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResSoYeuLyLich mapToResSoYeuLyLich(SoYeuLyLich soYeuLyLich) {
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
                .coQuanToChucDonViTuyenDung(soYeuLyLich.getCoQuanToChucDonViTuyenDung() != null ? soYeuLyLich.getCoQuanToChucDonViTuyenDung().getName() : "")
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
                .chucVuKiemNhiem(Optional.ofNullable(soYeuLyLich.getChucVuKiemNhiem()).map(ChucVu::getName).orElse(""))
                .chucVuDangHienTai(Optional.ofNullable(soYeuLyLich.getChucVuDangHienTai()).map(ChucDanhDang::getName).orElse(""))
                .chucVuDangKiemNhiem(Optional.ofNullable(soYeuLyLich.getChucVuDangKiemNhiem()).map(ChucDanhDang::getName).orElse(""))
                .congViecChinhDuocGiao(soYeuLyLich.getCongViecChinhDuocGiao())
                .soTruongCongTac(soYeuLyLich.getSoTruongCongTac())
                .congViecLamLauNhat(soYeuLyLich.getCongViecLamLauNhat())
                .tienLuong(soYeuLyLich.getTienLuong())
                .ngachNgheNghiep(soYeuLyLich.getNgachCongChuc() != null ? soYeuLyLich.getNgachCongChuc().getName() : (Optional.ofNullable(soYeuLyLich.getNgachVienChuc()).map(NgachVienChuc::getName).orElse("")))
                .maSoNgachNgheNghiep(soYeuLyLich.getNgachCongChuc() != null ? soYeuLyLich.getNgachCongChuc().getId() : (Optional.ofNullable(soYeuLyLich.getNgachVienChuc()).map(NgachVienChuc::getId).orElse("")))
                .ngayBoNhiemNgachNgheNghiep(soYeuLyLich.getNgayBoNhiemNgachNgheNghiep())
                .bacLuong(soYeuLyLich.getNgachCongChuc() != null ? soYeuLyLich.getNgachCongChuc().getHeSoLuongCongChuc().getBacLuong().getName() : (Optional.ofNullable(soYeuLyLich.getNgachVienChuc()).map(ngachVienChuc -> ngachVienChuc.getHeSoLuongVienChuc().getBacLuong().getName()).orElse("")))
                .heSoLuongNgachNgheNghiep(soYeuLyLich.getNgachCongChuc() != null ? soYeuLyLich.getNgachCongChuc().getHeSoLuongCongChuc().getHeSo() : (Optional.ofNullable(soYeuLyLich.getNgachVienChuc()).map(ngachVienChuc -> ngachVienChuc.getHeSoLuongVienChuc().getHeSo()).orElse(0.0f)))
                .ngayHuongLuongNgachNgheNghiep(soYeuLyLich.getNgayHuongLuongNgachNgheNghiep())
                .phanTramHuongLuongNgachNgheNghiep(soYeuLyLich.getPhanTramHuongLuongNgachNgheNghiep())
                .phuCapThamNienVuotKhungNgachNgheNghiep(soYeuLyLich.getPhuCapThamNienVuotKhungNgachNgheNghiep())
                .ngayHuongPCTNVKNgachNgheNghiep(soYeuLyLich.getNgayHuongPCTNVKNgachNgheNghiep())
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
                .trangThai(soYeuLyLich.isTrangThai())
                .create_at(soYeuLyLich.getCreate_at())
                .update_at(soYeuLyLich.getUpdate_at())
                .build();
    }
}
