package sgu.hrm.module_taikhoan.controller;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_taikhoan.models.request.ReqEmail;
import sgu.hrm.module_taikhoan.models.request.ReqMatKhau;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoan;
import sgu.hrm.module_taikhoan.service.ITaiKhoanService;

import java.util.List;


@RestController
public class AdminTaiKhoanController {

    private final ITaiKhoanService taiKhoanService;

    public AdminTaiKhoanController(ITaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }

    @GetMapping("/nhan-vien/tai-khoan")
    public ResponseEntity<ResDTO<List<ResTaiKhoan>>> getAllTaiKhoan() {
        List<ResTaiKhoan> resTaiKhoans = taiKhoanService.xemDanhSachTaiKhoan().stream().map(ResTaiKhoan::mapToResTaiKhoan).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resTaiKhoans), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/tai-khoan/tim-kiem")
    public ResponseEntity<ResDTO<ResTaiKhoan>> getTaiKhoanBySoCCCD(@RequestParam(name = "q") String number) {
        ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoanService.xemTaiKhoanTheoSoCCCDOrUsername(number));
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resTaiKhoan), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/tai-khoan/{id}")
    public ResponseEntity<ResDTO<ResTaiKhoan>> getTaiKhoanBySoCCCD(@PathVariable(name = "id") int id) {
        ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoanService.xemTaiKhoanTheoId(id));
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resTaiKhoan), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/nhan-vien/them")
    public ResponseEntity<ResDTO<ResTaiKhoan>> addTaiKhoan(@RequestBody ReqTaiKhoan reqTaiKhoan) {
        ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoanService.themTaiKhoan(reqTaiKhoan));
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resTaiKhoan), HttpStatus.OK);
    }
}
