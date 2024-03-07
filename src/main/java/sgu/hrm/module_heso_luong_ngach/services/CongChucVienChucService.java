package sgu.hrm.module_heso_luong_ngach.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sgu.hrm.module_heso_luong_ngach.models.BacNgachCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.BacNgachVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.NgachCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.NgachVienChuc;
import sgu.hrm.module_heso_luong_ngach.repositories.BacNgachCongChucRepository;
import sgu.hrm.module_heso_luong_ngach.repositories.BacNgachVienChucRepository;
import sgu.hrm.module_heso_luong_ngach.repositories.NgachCongChucRepository;
import sgu.hrm.module_heso_luong_ngach.repositories.NgachVienChucRepository;

import java.util.List;

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
    public List<BacNgachCongChuc> xemBacNgachCongChuc() {
        return bacNgachCongChucRepository.findAll();
    }

    @Override
    public List<BacNgachVienChuc> xemBacNgachVienChuc() {
        return bacNgachVienChucRepository.findAll();
    }

    @Override
    public List<NgachCongChuc> xemNgachCongChuc() {
        return ngachCongChucRepository.findAll();
    }

    @Override
    public List<NgachVienChuc> xemNgachVienChuc() {
        return ngachVienChucRepository.findAll();
    }
}
