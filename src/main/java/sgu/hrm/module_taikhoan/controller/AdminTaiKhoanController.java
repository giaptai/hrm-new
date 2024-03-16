package sgu.hrm.module_taikhoan.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqEmail;
import sgu.hrm.module_taikhoan.models.request.ReqMatKhau;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoan;
import sgu.hrm.module_taikhoan.service.ITaiKhoanService;

import java.util.List;


@RestController
@Tag(name = "Admin tai-khoan", description = "Quản lý")
@SecurityRequirement(name = "Bearer Authentication")
public class AdminTaiKhoanController {

    private final ITaiKhoanService taiKhoanService;

    public AdminTaiKhoanController(ITaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }

    @GetMapping("/nhan-vien/tai-khoan")
    public ResponseEntity<ResDTO<List<ResTaiKhoan>>> getAllTaiKhoan() {
        List<ResTaiKhoan> resTaiKhoans = taiKhoanService.xemDanhSachTaiKhoan().stream().map(ResTaiKhoan::mapToResTaiKhoan).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resTaiKhoans), ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/nhan-vien/tai-khoan/tim-kiem")
    public ResponseEntity<ResDTO<ResTaiKhoan>> getTaiKhoanBySoCCCD(@RequestParam(name = "q") String number) {
        TaiKhoan taiKhoan = taiKhoanService.xemTaiKhoanTheoSoCCCDOrUsername(number);
        if (taiKhoan != null) {
            ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoanService.xemTaiKhoanTheoSoCCCDOrUsername(number));
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resTaiKhoan), ResEnum.THANH_CONG.getStatusCode());
        }
        return new ResponseEntity<>(ResDTO.response(ResEnum.HONG_TIM_THAY, null), ResEnum.HONG_TIM_THAY.getStatusCode());
    }

    @GetMapping("/nhan-vien/tai-khoan/{id}")
    public ResponseEntity<ResDTO<ResTaiKhoan>> getTaiKhoanBySoCCCD(@PathVariable(name = "id") int id) {
        TaiKhoan taiKhoan = taiKhoanService.xemTaiKhoanTheoId(id);
        if (taiKhoan != null) {
            ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoanService.xemTaiKhoanTheoId(id));
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resTaiKhoan), ResEnum.THANH_CONG.getStatusCode());
        }
        return new ResponseEntity<>(ResDTO.response(ResEnum.HONG_TIM_THAY, null), ResEnum.HONG_TIM_THAY.getStatusCode());
    }

    @Transactional(Transactional.TxType.NEVER)
    @PostMapping("/nhan-vien/tai-khoan")
    public ResponseEntity<ResDTO<ResTaiKhoan>> addTaiKhoan(@RequestBody ReqTaiKhoan reqTaiKhoan) {
        TaiKhoan taiKhoan = taiKhoanService.themTaiKhoan(reqTaiKhoan);
        if (taiKhoan != null) {
            ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoan);
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, resTaiKhoan), ResEnum.TAO_THANH_CONG.getStatusCode());
        } else
            return new ResponseEntity<>(ResDTO.response(ResEnum.TRUNG_DU_LIEU, null), ResEnum.TRUNG_DU_LIEU.getStatusCode());
    }
}
