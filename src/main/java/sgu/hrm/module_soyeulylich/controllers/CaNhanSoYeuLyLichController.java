package sgu.hrm.module_soyeulylich.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.request.ReqSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.response.ResSoYeuLyLich;
import sgu.hrm.module_soyeulylich.services.ISoYeuLyLichService;


@RestController
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Employee so-yeu-ly-lich", description = "The Employee API. Contains all the operations that can be performed on a employee.")
@RequestMapping(value = "/ca-nhan")
public class CaNhanSoYeuLyLichController {

    private final ISoYeuLyLichService soYeuLyLichService;

    public CaNhanSoYeuLyLichController(ISoYeuLyLichService soYeuLyLichService) {
        this.soYeuLyLichService = soYeuLyLichService;
    }

    @GetMapping("/so-yeu-ly-lich")
    public ResponseEntity<ResDTO<SoYeuLyLich>> so_yeu_ly_lich() {
//        return new ResponseEntity<>(soYeuLyLichService.xemThongTinSoYeuLyLich(), HttpStatus.OK);
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                soYeuLyLichService.xemThongTinSoYeuLyLich()), ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/so-yeu-ly-lich-het")
    public ResponseEntity<SoYeuLyLich> so_yeu_ly_lich_het() {
        return new ResponseEntity<>(soYeuLyLichService.xemThongTinSoYeuLyLich(), HttpStatus.OK);
    }

    @PatchMapping("/so-yeu-ly-lich")
    public ResponseEntity<ResDTO<SoYeuLyLich>> so_yeu_ly_lich_cap_nhat(@RequestBody ReqSoYeuLyLich reqSoYeuLyLich) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                soYeuLyLichService.capNhatSoYeuLyLich(reqSoYeuLyLich)), ResEnum.THANH_CONG.getStatusCode());
    }
}