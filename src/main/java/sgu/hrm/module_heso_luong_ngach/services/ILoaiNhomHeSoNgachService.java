package sgu.hrm.module_heso_luong_ngach.services;

import sgu.hrm.module_heso_luong_ngach.models.HeSoLuongCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.HeSoLuongVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.LoaiCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.LoaiVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.NgachCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.NgachVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.NhomCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.NhomVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.request.ReqHeSoLuong;
import sgu.hrm.module_heso_luong_ngach.models.request.ReqLoai;
import sgu.hrm.module_heso_luong_ngach.models.request.ReqNgach;
import sgu.hrm.module_heso_luong_ngach.models.request.ReqNhom;

import java.util.List;

public interface ILoaiNhomHeSoNgachService {
    interface ILoaiCongChucService {
        List<LoaiCongChuc> xemLoaiCongChuc();

        LoaiCongChuc themLoaiCongChuc(ReqLoai loai);

        LoaiCongChuc suaLoaiCongChuc(int id, ReqLoai loai);

        boolean xoaLoaiCongChuc(int id);
    }

    interface ILoaiVienChucService {
        List<LoaiVienChuc> xemLoaiVienChuc();

        LoaiVienChuc themLoaiVienChuc(ReqLoai loai);

        LoaiVienChuc suaLoaiVienChuc(int id, ReqLoai loai);

        boolean xoaLoaiVienChuc(int id);

    }

    interface INhomCongChucService {
        List<NhomCongChuc> xemNhomCongChuc();

        NhomCongChuc themNhomCongChuc(ReqNhom nhom);

        NhomCongChuc suaNhomCongChuc(int id, ReqNhom nhom);

        boolean xoaNhomCongChuc(int id);

    }

    interface INhomVienChucService {
        List<NhomVienChuc> xemNhomVienChuc();

        NhomVienChuc themNhomVienChuc(ReqNhom nhom);

        NhomVienChuc suaNhomVienChuc(int id, ReqNhom nhom);

        boolean xoaNhomVienChuc(int id);
    }

    interface IHeSoLuongCongChucService {
        List<HeSoLuongCongChuc> xemHeSoLuongCongChuc();

        HeSoLuongCongChuc themHeSoLuongCongChuc(ReqHeSoLuong luong);

        HeSoLuongCongChuc suaHeSoLuongCongChuc(int id, ReqHeSoLuong luong);

        boolean xoaHeSoLuongCongChuc(int id);
    }

    interface IHeSoLuongVienChucService {
        List<HeSoLuongVienChuc> xemHeSoLuongVienChuc();

        HeSoLuongVienChuc themHeSoLuongVienChuc(ReqHeSoLuong luong);

        HeSoLuongVienChuc suaHeSoLuongVienChuc(int id, ReqHeSoLuong luong);

        boolean xoaHeSoLuongVienChuc(int id);
    }

    interface INgachVienChucService {
        List<NgachVienChuc> xemNgachVienChuc();

        NgachVienChuc themNgachVienChuc(ReqNgach req);

        NgachVienChuc suaNgachVienChuc(String id, ReqNgach req);

        boolean xoaNgachVienChuc(String id);
    }

    interface INgachCongChucService {
        List<NgachCongChuc> xemNgachCongChuc();

        NgachCongChuc themNgachCongChuc(ReqNgach req);

        NgachCongChuc suaNgachCongChuc(String id, ReqNgach req);

        boolean xoaNgachCongChuc(String id);
    }
}
