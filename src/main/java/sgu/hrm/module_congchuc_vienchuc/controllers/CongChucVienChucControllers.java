package sgu.hrm.module_congchuc_vienchuc.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgu.hrm.module_congchuc_vienchuc.models.BacNgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.BacNgachVienChuc;
import sgu.hrm.module_congchuc_vienchuc.models.NgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.NgachVienChuc;
import sgu.hrm.module_congchuc_vienchuc.models.response.ResNgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.response.ResNgachVienChuc;
import sgu.hrm.module_congchuc_vienchuc.services.ICongChucVienChucService;

import sgu.hrm.module_response.ResDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor // tao constructor if field set final or @not null
@RequestMapping(value = "/bac-ngach")
public class CongChucVienChucControllers {
    private final ICongChucVienChucService.IBacNgachCongChucService bacNgachCongChucService;
    private final ICongChucVienChucService.IBacNgachVienChucService bacNgachVienChucService;
    private final ICongChucVienChucService.INgachCongChucService ngachCongChucService;
    private final ICongChucVienChucService.INgachVienChucService ngachVienChucService;

    @GetMapping("/bac-ngach-cong-chuc")
    public ResDTO<List<BacNgachCongChuc>> getAllBacNgachCongChuc() {
        return bacNgachCongChucService.xemBacNgachCongChuc();
    }

    @GetMapping("/bac-ngach-vien-chuc")
    public ResDTO<List<BacNgachVienChuc>> getAllBacNgachVienChuc() {
        return bacNgachVienChucService.xemBacNgachVienChuc();
    }

    @GetMapping("/ngach-cong-chuc")
    public ResDTO<List<ResNgachCongChuc>> getAllNgachCongChuc() {
        return ngachCongChucService.xemNgachCongChuc();
    }

    @GetMapping("/ngach-vien-chuc")
    public ResDTO<List<ResNgachVienChuc>> getAllNgachVienChuc() {
        return ngachVienChucService.xemNgachVienChuc();
    }
}
