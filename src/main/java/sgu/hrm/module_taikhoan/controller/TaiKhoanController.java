package sgu.hrm.module_taikhoan.controller;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_taikhoan.models.request.ReqEmail;
import sgu.hrm.module_taikhoan.models.request.ReqMatKhau;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoan;
import sgu.hrm.module_taikhoan.service.ITaiKhoanService;


@RestController
public class TaiKhoanController {

    private final ITaiKhoanService taiKhoanService;

    public TaiKhoanController(ITaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }

    //thong-tin-ca-nhan
    @GetMapping("/ca-nhan/tai-khoan")
    @Transactional
    public ResDTO<ResTaiKhoan> thong_tin_ca_nhan() {
        return taiKhoanService.xemThongTinTaiKhoan();
    }

    //doi-mat-khau
    @PatchMapping("/ca-nhan/tai-khoan/doi-mat-khau")
    @Transactional
    public ResDTO<?> doi_mat_khau(@RequestBody ReqMatKhau reqMatKhau) {
        return taiKhoanService.doiMatKhau(reqMatKhau.matkhau());
    }

    @PatchMapping("/ca-nhan/tai-khoan/doi-email")
    @Transactional
    public ResDTO<?> doi_email(@RequestBody ReqEmail email) {
        return taiKhoanService.doiEmail(email.email());
    }

    /* ADMIN | ADMIN | ADMIN */
    @GetMapping("/nhan-vien/tai-khoan")
    public ResDTO<?> getAllTaiKhoan() {
        return taiKhoanService.xemDanhSachTaiKhoan();
    }

    @GetMapping("/nhan-vien/tai-khoan/tim-kiem")
    public ResDTO<ResTaiKhoan> getTaiKhoanBySoCCCD(@RequestParam(name = "q") String number) {
        return taiKhoanService.xemTaiKhoanTheoSoCCCDOrUsername(number);
    }

    @GetMapping("/nhan-vien/tai-khoan/{id}")
    public ResDTO<ResTaiKhoan> getTaiKhoanBySoCCCD(@PathVariable(name = "id") int id) {
        return taiKhoanService.xemTaiKhoanTheoId(id);
    }

    @PostMapping("/nhan-vien/them")
    @Transactional
    public ResDTO<?> addTaiKhoan(@RequestBody ReqTaiKhoan reqTaiKhoan) {
        return taiKhoanService.themTaiKhoan(reqTaiKhoan);
    }
}
