package sgu.hrm.module_heso_luong.services;

import sgu.hrm.module_heso_luong.models.HeSoLuongCongChuc;
import sgu.hrm.module_heso_luong.models.HeSoLuongVienChuc;
import sgu.hrm.module_heso_luong.models.LoaiCongChuc;
import sgu.hrm.module_heso_luong.models.LoaiVienChuc;
import sgu.hrm.module_heso_luong.models.NhomLoaiCongChuc;
import sgu.hrm.module_heso_luong.models.NhomLoaiVienChuc;
import sgu.hrm.module_heso_luong.models.response.ResHeSoLuongCongChuc;
import sgu.hrm.module_heso_luong.models.response.ResHeSoLuongVienChuc;
import sgu.hrm.module_response.ResDTO;

import java.util.List;

public interface IHeSoLuongService {
    interface ILoaiCongChucService {
        ResDTO<List<LoaiCongChuc>> xemLoaiCongChuc();

        ResDTO<LoaiCongChuc> themLoaiCongChuc();

        ResDTO<LoaiCongChuc> suaLoaiCongChuc();
    }

    interface ILoaiVienChucService {
        ResDTO<List<LoaiVienChuc>> xemLoaiVienChuc();

        ResDTO<LoaiVienChuc> themLoaiVienChuc();

        ResDTO<LoaiVienChuc> suaLoaiVienChuc();
    }

    interface INhomLoaiCongChucService {
        ResDTO<List<NhomLoaiCongChuc>> xemNhomLoaiCongChuc();

        ResDTO<NhomLoaiCongChuc> themNhomLoaiCongChuc();

        ResDTO<NhomLoaiCongChuc> suaNhomLoaiCongChuc();
    }

    interface INhomLoaiVienChucService {
        ResDTO<List<NhomLoaiVienChuc>> xemNhomLoaiVienChuc();

        ResDTO<NhomLoaiVienChuc> themNhomLoaiVienChuc();

        ResDTO<NhomLoaiVienChuc> suaNhomLoaiVienChuc();
    }

    interface IHeSoLuongCongChucService {
        ResDTO<List<ResHeSoLuongCongChuc>> xemHeSoLuongCongChuc();

        ResDTO<HeSoLuongCongChuc> themHeSoLuongCongChuc();

        ResDTO<HeSoLuongCongChuc> suaHeSoLuongCongChuc();
    }

    interface IHeSoLuongVienChucService {
        ResDTO<List<ResHeSoLuongVienChuc>> xemHeSoLuongVienChuc();

        ResDTO<HeSoLuongVienChuc> themHeSoLuongVienChuc();

        ResDTO<HeSoLuongVienChuc> suaHeSoLuongVienChuc();
    }
}
