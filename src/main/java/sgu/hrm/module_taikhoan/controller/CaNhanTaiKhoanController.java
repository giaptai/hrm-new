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
import sgu.hrm.module_taikhoan.models.request.ReqEmail;
import sgu.hrm.module_taikhoan.models.request.ReqMatKhau;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoan;
import sgu.hrm.module_taikhoan.service.ITaiKhoanService;

import java.util.List;


@RestController
@Tag(name = "Employee tai-khoan", description = "Nhân viên")
@SecurityRequirement(name = "Bearer Authentication")
public class CaNhanTaiKhoanController {

    private final ITaiKhoanService taiKhoanService;

    public CaNhanTaiKhoanController(ITaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }

    //thong-tin-ca-nhan
    @GetMapping("/ca-nhan/tai-khoan")
    @Transactional
    public ResponseEntity<ResDTO<ResTaiKhoan>> thong_tin_ca_nhan() {
        ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoanService.xemThongTinTaiKhoan());
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resTaiKhoan), HttpStatus.OK);
    }

    //doi-mat-khau
    @PatchMapping("/ca-nhan/tai-khoan/doi-mat-khau")
    @Transactional
    public ResponseEntity<ResDTO<Boolean>> doi_mat_khau(@RequestBody ReqMatKhau reqMatKhau) {
        boolean doiMk = taiKhoanService.doiMatKhau(reqMatKhau.matkhau());
        if (doiMk) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.DOI_MAT_KHAU_THANH_CONG, true), ResEnum.DOI_MAT_KHAU_THANH_CONG.getStatusCode());
        }
        return new ResponseEntity<>(ResDTO.response(ResEnum.DOI_MAT_KHAU_THAT_BAI, false), ResEnum.DOI_MAT_KHAU_THAT_BAI.getStatusCode());
    }

    @PatchMapping("/ca-nhan/tai-khoan/doi-email")
    @Transactional
    public ResponseEntity<ResDTO<Boolean>> doi_email(@RequestBody ReqEmail email) {
        boolean doiEm = taiKhoanService.doiEmail(email.email());
        if (doiEm) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.DOI_EMAIL_THANH_CONG, true), ResEnum.DOI_EMAIL_THANH_CONG.getStatusCode());
        }
        return new ResponseEntity<>(ResDTO.response(ResEnum.DOI_EMAIL_THAT_BAI, false), ResEnum.DOI_EMAIL_THAT_BAI.getStatusCode());
    }
}
