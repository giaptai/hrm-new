package sgu.hrm.module_congchuc_vienchuc.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sgu.hrm.module_congchuc_vienchuc.models.BacNgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.BacNgachVienChuc;
import sgu.hrm.module_congchuc_vienchuc.models.NgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.NgachVienChuc;
import sgu.hrm.module_congchuc_vienchuc.models.response.ResNgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.response.ResNgachVienChuc;
import sgu.hrm.module_congchuc_vienchuc.repositories.BacNgachCongChucRepository;
import sgu.hrm.module_congchuc_vienchuc.repositories.BacNgachVienChucRepository;
import sgu.hrm.module_congchuc_vienchuc.repositories.NgachCongChucRepository;
import sgu.hrm.module_congchuc_vienchuc.repositories.NgachVienChucRepository;
import sgu.hrm.module_heso_luong.models.HeSoLuongCongChuc;
import sgu.hrm.module_heso_luong.models.HeSoLuongVienChuc;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // create constructor ig field i set final or @not null
public class CongChucVienChucService implements
        ICongChucVienChucService.IBacNgachCongChucService,
        ICongChucVienChucService.IBacNgachVienChucService,
        ICongChucVienChucService.INgachCongChucService,
        ICongChucVienChucService.INgachVienChucService {

    private final BacNgachCongChucRepository bacNgachCongChucRepository;
    private final BacNgachVienChucRepository bacNgachVienChucRepository;
    private final NgachCongChucRepository ngachCongChucRepository;
    private final NgachVienChucRepository ngachVienChucRepository;

    @Override
    public ResDTO<List<BacNgachCongChuc>> xemBacNgachCongChuc() {
//        return bacNgachCongChucRepository.findAll().stream().map(BacNgachCongChuc::getName).toList();
//        return bacNgachCongChucRepository.findAll().stream().map(bacNgachCongChuc -> (bacNgachCongChuc.getName());
//        return bacNgachCongChucRepository.findAll();
        return ResDTO.response(ResEnum.THANH_CONG, bacNgachCongChucRepository.findAll());
    }

    @Override
    public ResDTO<List<BacNgachVienChuc>> xemBacNgachVienChuc() {
//        return bacNgachVienChucRepository.findAll();
        //return bacNgachVienChucRepository.findAll().stream().map(bacNgachVienChuc -> new CongChucVienChucDTO(bacNgachVienChuc.getName())).toList();
        return ResDTO.response(ResEnum.THANH_CONG, bacNgachVienChucRepository.findAll());
    }

    @Override
    public ResDTO<List<ResNgachCongChuc>> xemNgachCongChuc() {
//        return ngachCongChucRepository.findAll();
        return ResDTO.response(ResEnum.THANH_CONG, ngachCongChucRepository.findAll().stream().map(this::mapToResNgachCongChuc).toList());
    }

    @Override
    public ResDTO<List<ResNgachVienChuc>> xemNgachVienChuc() {
//        return ngachVienChucRepository.findAll();
        return ResDTO.response(ResEnum.THANH_CONG, ngachVienChucRepository.findAll().stream().map(this::mapToResNgachVienChuc).toList());
    }

    private ResNgachCongChuc mapToResNgachCongChuc(NgachCongChuc t) {
        return new ResNgachCongChuc(
                t.getId(),
                t.getName(),
                Optional.ofNullable(t.getHeSoLuongCongChuc()).map(HeSoLuongCongChuc::getHeSo).orElse(0.0f),
                t.getHeSoLuongCongChuc() != null ? t.getHeSoLuongCongChuc().getBacLuong().getName(): "",
                t.getHeSoLuongCongChuc() != null ? t.getHeSoLuongCongChuc().getNhomLoaiCongChuc().getName(): "",
                t.isTrangThai(),
                t.getCreate_at(),
                t.getUpdate_at()
        );
    }

    private ResNgachVienChuc mapToResNgachVienChuc(NgachVienChuc v) {
        return new ResNgachVienChuc(
                v.getId(),
                v.getName(),
                Optional.ofNullable(v.getHeSoLuongVienChuc()).map(HeSoLuongVienChuc::getHeSo).orElse(0.0f),
                v.getHeSoLuongVienChuc() != null ? v.getHeSoLuongVienChuc().getBacLuong().getName(): "",
                v.getHeSoLuongVienChuc() != null ? v.getHeSoLuongVienChuc().getNhomLoaiVienChuc().getName(): "",
                v.isTrangThai(),
                v.getCreate_at(),
                v.getUpdate_at()
        );
    }
}
