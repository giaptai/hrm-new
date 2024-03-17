package sgu.hrm.module_cauhinh.services;

import sgu.hrm.module_cauhinh.models.HeSoLuongCongChuc;
import sgu.hrm.module_cauhinh.models.HeSoLuongVienChuc;
import sgu.hrm.module_cauhinh.models.LoaiCongChuc;
import sgu.hrm.module_cauhinh.models.LoaiVienChuc;
import sgu.hrm.module_cauhinh.models.NgachCongChuc;
import sgu.hrm.module_cauhinh.models.NgachVienChuc;
import sgu.hrm.module_cauhinh.models.NhomCongChuc;
import sgu.hrm.module_cauhinh.models.NhomVienChuc;
import sgu.hrm.module_cauhinh.dto.request.ReqHeSoLuong;
import sgu.hrm.module_cauhinh.dto.request.ReqLoai;
import sgu.hrm.module_cauhinh.dto.request.ReqNgach;
import sgu.hrm.module_cauhinh.dto.request.ReqNhom;

import java.util.List;

public interface ILoaiNhomHeSoNgachService {
    interface ILoaiCongChucService {
        List<LoaiCongChuc> xemLoaiCongChuc();

        LoaiCongChuc xemTheoId(int id);

        LoaiCongChuc themLoaiCongChuc(ReqLoai loai);

        LoaiCongChuc suaLoaiCongChuc(int id, ReqLoai loai);

        boolean xoaLoaiCongChuc(int id);
    }

    interface ILoaiVienChucService {
        List<LoaiVienChuc> xemLoaiVienChuc();
        LoaiVienChuc xemTheoId(int id);
        LoaiVienChuc themLoaiVienChuc(ReqLoai loai);

        LoaiVienChuc suaLoaiVienChuc(int id, ReqLoai loai);

        boolean xoaLoaiVienChuc(int id);

    }

    interface INhomCongChucService {
        List<NhomCongChuc> xemNhomCongChuc();
        NhomCongChuc xemTheoId(int id);
        NhomCongChuc themNhomCongChuc(ReqNhom nhom);

        NhomCongChuc suaNhomCongChuc(int id, ReqNhom nhom);

        boolean xoaNhomCongChuc(int id);

    }

    interface INhomVienChucService {
        List<NhomVienChuc> xemNhomVienChuc();
        NhomVienChuc xemTheoId(int id);
        NhomVienChuc themNhomVienChuc(ReqNhom nhom);

        NhomVienChuc suaNhomVienChuc(int id, ReqNhom nhom);

        boolean xoaNhomVienChuc(int id);
    }

    interface IHeSoLuongCongChucService {
        List<HeSoLuongCongChuc> xemHeSoLuongCongChuc();
        HeSoLuongCongChuc xemTheoId(int id);
        HeSoLuongCongChuc themHeSoLuongCongChuc(ReqHeSoLuong luong);

        HeSoLuongCongChuc suaHeSoLuongCongChuc(int id, ReqHeSoLuong luong);

        boolean xoaHeSoLuongCongChuc(int id);
    }

    interface IHeSoLuongVienChucService {
        List<HeSoLuongVienChuc> xemHeSoLuongVienChuc();
        HeSoLuongVienChuc xemTheoId(int id);
        HeSoLuongVienChuc themHeSoLuongVienChuc(ReqHeSoLuong luong);

        HeSoLuongVienChuc suaHeSoLuongVienChuc(int id, ReqHeSoLuong luong);

        boolean xoaHeSoLuongVienChuc(int id);
    }

    interface INgachVienChucService {
        List<NgachVienChuc> xemNgachVienChuc();
        NgachVienChuc xemTheoId(String id);
        NgachVienChuc themNgachVienChuc(ReqNgach req);

        NgachVienChuc suaNgachVienChuc(String id, ReqNgach req);

        boolean xoaNgachVienChuc(String id);
    }

    interface INgachCongChucService {
        List<NgachCongChuc> xemNgachCongChuc();
        NgachCongChuc xemTheoId(String id);
        NgachCongChuc themNgachCongChuc(ReqNgach req);

        NgachCongChuc suaNgachCongChuc(String id, ReqNgach req);

        boolean xoaNgachCongChuc(String id);
    }
}
