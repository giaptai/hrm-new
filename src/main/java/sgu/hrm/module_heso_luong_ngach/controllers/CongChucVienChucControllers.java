package sgu.hrm.module_heso_luong_ngach.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgu.hrm.module_heso_luong_ngach.models.BacNgachCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.BacNgachVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.response.ResNgachCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.response.ResNgachVienChuc;
import sgu.hrm.module_heso_luong_ngach.services.ICongChucVienChucService;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;

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
    public ResponseEntity<ResDTO<List<BacNgachCongChuc>>> getAllBacNgachCongChuc() {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                bacNgachCongChucService.xemBacNgachCongChuc()), HttpStatus.OK);
    }

    @GetMapping("/bac-ngach-vien-chuc")
    public ResponseEntity<ResDTO<List<BacNgachVienChuc>>> getAllBacNgachVienChuc() {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                bacNgachVienChucService.xemBacNgachVienChuc()), HttpStatus.OK);
    }

    @GetMapping("/ngach-cong-chuc")
    public ResponseEntity<ResDTO<List<ResNgachCongChuc>>> getAllNgachCongChuc() {
        List<ResNgachCongChuc> chucs = ngachCongChucService.xemNgachCongChuc().stream().map(ResNgachCongChuc::mapToResNgachCongChuc).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                chucs), HttpStatus.OK);
    }

    @GetMapping("/ngach-vien-chuc")
    public ResponseEntity<ResDTO<List<ResNgachVienChuc>>> getAllNgachVienChuc() {
        List<ResNgachVienChuc> viens = ngachVienChucService.xemNgachVienChuc().stream().map(ResNgachVienChuc::mapToResNgachVienChuc).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                viens), HttpStatus.OK);
    }
}
