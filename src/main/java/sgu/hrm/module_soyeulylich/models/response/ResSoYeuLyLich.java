package sgu.hrm.module_soyeulylich.models.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.LocalDateTime;

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

        String chucVuDangHienTai,

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
}
