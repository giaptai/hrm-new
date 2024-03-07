package sgu.hrm.module_soyeulylich.models.request;

import sgu.hrm.module_utilities.enums.GioiTinh;
import sgu.hrm.module_utilities.enums.TinhTrangSucKhoe;

import java.time.LocalDateTime;

public record ReqSoYeuLyLich(
        String hovaten,

        GioiTinh gioiTinh,

        String cacTenGoiKhac,

        LocalDateTime sinhNgay,

        String noiSinh,

        String queQuan,

        int danToc, //DanToc danToc,

        String soCCCD,

        LocalDateTime ngayCapCCCD,

        String soDienThoai,

        String soBHXH,

        String soBHYT,

        String noiOHienNay,

        int thanhPhanGiaDinh, //ThanhPhanGiaDinh thanhPhanGiaDinh,

        String ngheNghiepTruocKhiTuyenDung,

        LocalDateTime ngayDuocTuyenDungLanDau,

        int coQuanToChucDonViTuyenDung, //CoQuanToChucDonVi coQuanToChucDonViTuyenDung,

        LocalDateTime ngayVaoCoQuanHienDangCongTac,

        LocalDateTime ngayVaoDangCongSanVietNam,

        LocalDateTime ngayChinhThuc,

        LocalDateTime ngayThamGiaToChucChinhTriXaHoiDauTien,

        LocalDateTime ngayNhapNgu,

        LocalDateTime ngayXuatNgu,

        int capBacLoaiQuanHamQuanDoi, //CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi,

        int doiTuongChinhSach, //DoiTuongChinhSach doiTuongChinhSach,

        int trinhDoGiaoDucPhoThong, //TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong,

        int trinhDoChuyenMon, //TrinhDoChuyenMon trinhDoChuyenMon,

        int hocHam, //HocHam hocHam,

        int danhHieuNhaNuocPhongTang, //DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang,

        int chucVuHienTai, //ChucVu chucVuHienTai

        LocalDateTime ngayBoNhiem,

        LocalDateTime ngayBoNhiemLai,

        String duocQuyHoacChucDanh,

        int chucVuKiemNhiem, //ChucVu chucVuKiemNhiem

        int chucVuDangHienTai, //ChucDanhDang chucVuDangHienTai;

        int chucVuDangKiemNhiem, ////ChucDanhDang chucVuDangKiemNhiem;

        String congViecChinhDuocGiao,

        String soTruongCongTac,

        String congViecLamLauNhat,

        double tienLuong,

        String ngachNgheNghiep, //NgachCongChuc ngachCongChuc;  NgachVienChuc ngachVienChuc;

        LocalDateTime ngayBoNhiemNgachNgheNghiep,

        LocalDateTime ngayHuongLuongNgachNgheNghiep,

        float phanTramHuongLuongNgachNgheNghiep,

        float phuCapThamNienVuotKhungNgachNgheNghiep,

        LocalDateTime ngayHuongPCTNVKNgachNgheNghiep,

        double phuCapChucVu,

        double phuCapKiemNhiem,

        double phuCapKhac,

        int viTriViecLam,

        LocalDateTime ngayHuongLuongTheoViTriViecLam,

        float phamTramHuongLuong,

        double phuCapThamNienVuotKhung,

        LocalDateTime ngayHuongPCTNVK,

        TinhTrangSucKhoe tinhTrangSucKhoe, //enum,

        float chieuCao,

        float canNang,

        int nhomMau //NhomMau nhomMau
) {
}
