package sgu.hrm.module_soyeulylich.controllers;

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
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.request.ReqDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.request.ReqSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.response.ResSoYeuLyLich;
import sgu.hrm.module_soyeulylich.services.ISoYeuLyLichService;

import java.util.List;


@RestController
@RequestMapping(value = "/ca-nhan")
public class CaNhanSoYeuLyLichController {

    private final ISoYeuLyLichService soYeuLyLichService;

    public CaNhanSoYeuLyLichController(ISoYeuLyLichService soYeuLyLichService) {
        this.soYeuLyLichService = soYeuLyLichService;
    }

    //EMPLOYEE --- EMPLOYEE --- EMPLOYEE
    @GetMapping("/so-yeu-ly-lich")
    public ResponseEntity<ResDTO<ResSoYeuLyLich>> so_yeu_ly_lich() {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResSoYeuLyLich.mapToResSoYeuLyLich(soYeuLyLichService.xemThongTinSoYeuLyLich())), HttpStatus.OK);
    }

    @GetMapping("/so-yeu-ly-lich-het")
    public ResponseEntity<SoYeuLyLich> so_yeu_ly_lich_het() {
        return new ResponseEntity<>(soYeuLyLichService.xemThongTinSoYeuLyLich(), HttpStatus.OK);
    }

    @PatchMapping("/so-yeu-ly-lich")
    public ResponseEntity<ResDTO<ResSoYeuLyLich>> so_yeu_ly_lich_cap_nhat(@RequestBody ReqSoYeuLyLich reqSoYeuLyLich) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResSoYeuLyLich.mapToResSoYeuLyLich(soYeuLyLichService.capNhatSoYeuLyLich(reqSoYeuLyLich))), HttpStatus.ACCEPTED);
    }
}