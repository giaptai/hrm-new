package sgu.hrm.module_soyeulylich.models.request;

import sgu.hrm.module_soyeulylich.models.response.ResSoYeuLyLich;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqTinHoc;

import java.time.LocalDateTime;
import java.util.List;

public record ReqSoYeuLyLich(
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

        String congVienChinhDuocGiao,

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

        String nhomMau //NhomMau nhomMau
) {
}