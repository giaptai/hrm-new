package sgu.hrm.module_soyeulylich.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;

import sgu.hrm.module_soyeulylich.models.request.ReqDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.response.ResSoYeuLyLich;

import sgu.hrm.module_soyeulylich.services.ISoYeuLyLichService;

import java.util.List;


@RestController
@RequestMapping(value = "/nhan-vien")
@Tag(name = "Admin so-yeu-ly-lich", description = "The Admin API. Contains all the operations that can be performed on a Admin.")
@SecurityRequirement(name = "Bearer Authentication")
public class AdminSoYeuLyLichController {

    private final ISoYeuLyLichService soYeuLyLichService;

    public AdminSoYeuLyLichController(ISoYeuLyLichService soYeuLyLichService) {
        this.soYeuLyLichService = soYeuLyLichService;
    }

    @GetMapping("/so-yeu-ly-lich")
    public ResponseEntity<ResDTO<List<ResSoYeuLyLich>>> getAllSoYeuLyLich() {
        List<ResSoYeuLyLich> resSoYeuLyLichs = soYeuLyLichService.xemDanhSachSoYeuLyLich().stream().map(ResSoYeuLyLich::mapToResSoYeuLyLich).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resSoYeuLyLichs), HttpStatus.ACCEPTED);
    }

//    @GetMapping("/so-yeu-ly-lich/tim-kiem")
//    public ResponseEntity<ResDTO<ResSoYeuLyLich>> getSoYeuLyLichSoCCCDOrId(@RequestParam(name = "q") String q) {
//        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
//                ResSoYeuLyLich.mapToResSoYeuLyLich(soYeuLyLichService.xemSoYeuLyLichTheoSoCCCDHoacID(q))), HttpStatus.OK);
//    }

    @GetMapping("/so-yeu-ly-lich/{id}")
    public ResponseEntity<ResDTO<ResSoYeuLyLich>> getSoYeuLyLichById(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResSoYeuLyLich.mapToResSoYeuLyLich(soYeuLyLichService.xemSoYeuLyLichTheoId(id))), HttpStatus.OK);
    }

    @PatchMapping("/so-yeu-ly-lich/phe-duyet")
    @Transactional
    public ResponseEntity<ResDTO<List<ResSoYeuLyLich>>> editSoYeuLyLich(@PathVariable(name = "id", required = false) String id,
                                                                        @RequestBody List<ReqDSSoYeuLyLich> reqDSSoYeuLyLich) {
        List<ResSoYeuLyLich> resSoYeuLyLichs = soYeuLyLichService.pheDuyetSoYeuLyLich(reqDSSoYeuLyLich).stream().map(ResSoYeuLyLich::mapToResSoYeuLyLich).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resSoYeuLyLichs), HttpStatus.OK);
    }
}