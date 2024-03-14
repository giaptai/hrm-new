package sgu.hrm.module_soyeulylich_chitiet.services;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.KhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.KienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.KyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.LamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.LoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.LuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.LyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.NghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.NgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.PhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.QuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.QuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.TinHoc;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNgoaiNguNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuaTrinhCongTacNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKhenThuongNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKyLuatNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLamViecONuocNgoaiNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLyLuanChinhTriNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNghiepVuChuyenNganhNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqTinHoc;

import java.util.ArrayList;
import java.util.List;

public interface ISoYeuLyLichChiTietServices<T, H> {
    List<T> xemDanhSachThongTin();

    T xemThongTin(int id);

    T themThongTin(H cu);

    T suaThongTin(int id, H cu);

    default List<T> suaDanhSachThongTin(List<H> cu) {
        return new ArrayList<>();
    }

    boolean xoaThongTin(int id);

    List<T> xemDanhSach(String id);

    List<T> xemDanhSachEmployee();

    interface ILoaiSoYeuLyLichChiTietSefvice {
        ResDTO<List<LoaiSoYeuLyLichChiTiet>> xemLoaiSoYeuLyLichChiTiet();

        ResDTO<LoaiSoYeuLyLichChiTiet> themLoaiSoYeuLyLichChiTiet(ReqLoaiSoYeuLyLichChiTiet reqLoaiSoYeuLyLichChiTiet);

        ResDTO<LoaiSoYeuLyLichChiTiet> suaLoaiSoYeuLyLichChiTiet(LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet);

    }

    abstract class IBanThanCoLamViecChoCheDoCuSefvice implements ISoYeuLyLichChiTietServices<BanThanCoLamViecChoCheDoCu, ReqBanThanCoLamViecChoCheDoCu> {
    }

    abstract class IKhenThuongSefvice implements ISoYeuLyLichChiTietServices<KhenThuong, ReqKhenThuong> {
        public abstract List<KhenThuong> khenThuongNhanVien(List<ReqKhenThuongNhanVien> vien);
    }

    abstract class IKienThucAnNinhQuocPhongSefvice implements ISoYeuLyLichChiTietServices<KienThucAnNinhQuocPhong, ReqKienThucAnNinhQuocPhong> {
    }

    abstract class IKyLuatSefvice implements ISoYeuLyLichChiTietServices<KyLuat, ReqKyLuat> {
        public abstract List<KyLuat> kyLuatNhanVien(List<ReqKyLuatNhanVien> vien);
    }

    abstract class ILamViecONuocNgoaiSefvice implements ISoYeuLyLichChiTietServices<LamViecONuocNgoai, ReqLamViecONuocNgoai> {
        public abstract List<LamViecONuocNgoai> lamViecONUocNgoaiNhanVien(List<ReqLamViecONuocNgoaiNhanVien> vien);
    }

    abstract class ILuongBanThanSefvice implements ISoYeuLyLichChiTietServices<LuongBanThan, ReqLuongBanThan> {
    }

    abstract class ILyLuanChinhTriSefvice implements ISoYeuLyLichChiTietServices<LyLuanChinhTri, ReqLyLuanChinhTri> {
        public abstract List<LyLuanChinhTri> lyLuanChinhTriNhanVien(List<ReqLyLuanChinhTriNhanVien> vien);
    }

    abstract class INghiepVuChuyenNganhSefvice implements ISoYeuLyLichChiTietServices<NghiepVuChuyenNganh, ReqNghiepVuChuyenNganh> {
        public abstract List<NghiepVuChuyenNganh> nghiepVuChuyenNganhNhanVien(List<ReqNghiepVuChuyenNganhNhanVien> vien);
    }

    abstract class INgoaiNguSefvice implements ISoYeuLyLichChiTietServices<NgoaiNgu, ReqNgoaiNgu> {
        public abstract List<NgoaiNgu> ngoaiNguNhanVien(List<ReqNgoaiNguNhanVien> vien);
    }

    abstract class IPhuCapKhacSefvice implements ISoYeuLyLichChiTietServices<PhuCapKhac, ReqPhuCapKhac> {
    }

    abstract class IQuanHeGiaDinhSefvice implements ISoYeuLyLichChiTietServices<QuanHeGiaDinh, ReqQuanHeGiaDinh> {
    }

    abstract class IQuaTrinhCongTacSefvice implements ISoYeuLyLichChiTietServices<QuaTrinhCongTac, ReqQuaTrinhCongTac> {
        public abstract List<QuaTrinhCongTac> chuyenCongTacNhanVien(List<ReqQuaTrinhCongTacNhanVien> vien);
    }

    abstract class ITinHocSefvice implements ISoYeuLyLichChiTietServices<TinHoc, ReqTinHoc> {
    }
}
