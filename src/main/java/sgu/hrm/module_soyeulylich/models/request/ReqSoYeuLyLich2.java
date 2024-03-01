package sgu.hrm.module_soyeulylich.models.request;

import java.time.LocalDateTime;

public record ReqSoYeuLyLich2(
        String hovaten,

        int gioiTinh,

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

        int coQuanToChucDonViTuyenDung, //CoQuanToChucDonViTuyenDung coQuanToChucDonViTuyenDung,

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

        double phanTramHuongLuongNgachNgheNghiep,

        float phuCapThamNienVuotKhungNgachNgheNghiep,

        LocalDateTime ngayHuongPCTNVKNgachNgheNghiep,

        float phuCapChucVu,

        float phuCapKiemNhiem,

        float phuCapKhac,

        int viTriViecLam,

        LocalDateTime ngayHuongLuongTheoViTriViecLam,

        double phamTramHuongLuong,

        double phuCapThamNienVuotKhung,

        LocalDateTime ngayHuongPCTNVK,

        int tinhTrangSucKhoe, //TinhTrangSucKhoe tinhTrangSucKhoe,

        double chieuCao,

        double canNang,

        int nhomMau //NhomMau nhomMau
) {
}
