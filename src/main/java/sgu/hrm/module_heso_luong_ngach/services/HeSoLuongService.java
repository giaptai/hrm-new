package sgu.hrm.module_heso_luong_ngach.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;
import sgu.hrm.module_heso_luong_ngach.models.HeSoLuongCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.HeSoLuongVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.LoaiCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.LoaiVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.NhomLoaiCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.NhomLoaiVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.response.ResHeSoLuongCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.response.ResHeSoLuongVienChuc;
import sgu.hrm.module_heso_luong_ngach.repositories.HeSoLuongCongChucRepository;
import sgu.hrm.module_heso_luong_ngach.repositories.HeSoLuongVienChucRepository;
import sgu.hrm.module_heso_luong_ngach.repositories.LoaiCongChucRepository;
import sgu.hrm.module_heso_luong_ngach.repositories.LoaiVienChucRepository;
import sgu.hrm.module_heso_luong_ngach.repositories.NhomLoaiCongChucRepository;
import sgu.hrm.module_heso_luong_ngach.repositories.NhomLoaiVienChucRepository;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;

import java.util.List;

@Service
@RequiredArgsConstructor // constructor field final or @not null
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HeSoLuongService implements IHeSoLuongService.ILoaiCongChucService,
        IHeSoLuongService.ILoaiVienChucService,
        IHeSoLuongService.INhomLoaiCongChucService,
        IHeSoLuongService.INhomLoaiVienChucService,
        IHeSoLuongService.IHeSoLuongCongChucService,
        IHeSoLuongService.IHeSoLuongVienChucService {

    final LoaiCongChucRepository loaiCongChucRepository;
    final LoaiVienChucRepository loaiVienChucRepository;
    final NhomLoaiCongChucRepository nhomLoaiCongChucRepository;
    final NhomLoaiVienChucRepository nhomLoaiVienChucRepository;
    final HeSoLuongCongChucRepository heSoLuongCongChucRepository;
    final HeSoLuongVienChucRepository heSoLuongVienChucRepository;

    @Override
    public ResDTO<List<LoaiCongChuc>> xemLoaiCongChuc() {
        return ResDTO.response(ResEnum.THANH_CONG, loaiCongChucRepository.findAll());
    }

    @Override
    public ResDTO<LoaiCongChuc> themLoaiCongChuc() {
        return null;
    }

    @Override
    public ResDTO<LoaiCongChuc> suaLoaiCongChuc() {
        return null;
    }

    /////
    @Override
    public ResDTO<List<LoaiVienChuc>> xemLoaiVienChuc() {
        return ResDTO.response(ResEnum.THANH_CONG, loaiVienChucRepository.findAll());
    }

    @Override
    public ResDTO<LoaiVienChuc> themLoaiVienChuc() {
        return null;
    }

    @Override
    public ResDTO<LoaiVienChuc> suaLoaiVienChuc() {
        return null;
    }

    ////
    @Override
    public ResDTO<List<NhomLoaiCongChuc>> xemNhomLoaiCongChuc() {
        return ResDTO.response(ResEnum.THANH_CONG, nhomLoaiCongChucRepository.findAll());
    }

    @Override
    public ResDTO<NhomLoaiCongChuc> themNhomLoaiCongChuc() {
        return null;
    }

    @Override
    public ResDTO<NhomLoaiCongChuc> suaNhomLoaiCongChuc() {
        return null;
    }

    /////
    @Override
    public ResDTO<List<NhomLoaiVienChuc>> xemNhomLoaiVienChuc() {
        return ResDTO.response(ResEnum.THANH_CONG, nhomLoaiVienChucRepository.findAll());

    }

    @Override
    public ResDTO<NhomLoaiVienChuc> themNhomLoaiVienChuc() {
        return null;
    }

    @Override
    public ResDTO<NhomLoaiVienChuc> suaNhomLoaiVienChuc() {
        return null;
    }

    /////
    @Override
    public ResDTO<List<ResHeSoLuongCongChuc>> xemHeSoLuongCongChuc() {
        List<ResHeSoLuongCongChuc> chucs = heSoLuongCongChucRepository.findAll().stream().map(this::mapToResHeSoLuongCongChuc).toList();
        return ResDTO.response(ResEnum.THANH_CONG, chucs);
    }

    @Override
    public ResDTO<HeSoLuongCongChuc> themHeSoLuongCongChuc() {
        return null;
    }

    @Override
    public ResDTO<HeSoLuongCongChuc> suaHeSoLuongCongChuc() {
        return null;
    }

    //////
    @Override
    public ResDTO<List<ResHeSoLuongVienChuc>> xemHeSoLuongVienChuc() {
        List<ResHeSoLuongVienChuc> viens = heSoLuongVienChucRepository.findAll().stream().map(this::mapToResHeSoLuongVienChuc).toList();
        return ResDTO.response(ResEnum.THANH_CONG, viens);
    }

    @Override
    public ResDTO<HeSoLuongVienChuc> themHeSoLuongVienChuc() {
        return null;
    }

    @Override
    public ResDTO<HeSoLuongVienChuc> suaHeSoLuongVienChuc() {
        return null;
    }

    private ResHeSoLuongCongChuc mapToResHeSoLuongCongChuc(HeSoLuongCongChuc chuc) {
        return ResHeSoLuongCongChuc.builder()
                .id(chuc.getId())
                .heSo(chuc.getHeSo())
                .bacLuong(chuc.getBacLuong().getName())
                .nhomLoaiCongChuc(chuc.getNhomLoaiCongChuc().getName())
                .trangThai(chuc.isTrangThai())
                .create_at(chuc.getCreate_at())
                .update_at(chuc.getUpdate_at())
                .build();
    }

    private ResHeSoLuongVienChuc mapToResHeSoLuongVienChuc(HeSoLuongVienChuc vien) {
        return ResHeSoLuongVienChuc.builder()
                .id(vien.getId())
                .heSo(vien.getHeSo())
                .bacLuong(vien.getBacLuong().getName())
                .nhomLoaiVienChuc(vien.getNhomLoaiVienChuc().getName())
                .trangThai(vien.isTrangThai())
                .create_at(vien.getCreate_at())
                .update_at(vien.getUpdate_at())
                .build();
    }
}
