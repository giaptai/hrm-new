package sgu.hrm.module_security;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoanLogin;
import sgu.hrm.module_taikhoan.service.ITaiKhoanService;

@RestController
@RequiredArgsConstructor
public class SercurityController {

    private final ITaiKhoanService taiKhoanService;

    @GetMapping("/tu-choi")
    public ResDTO<String> getDenied() throws RuntimeException {
        return ResDTO.response(ResEnum.TRUY_CAP_BI_CAM, null);
    }

    @PostMapping("/dang-nhap")
    public ResDTO<?> dangNhap(@RequestBody ReqTaiKhoanLogin reqTaiKhoanLogin) {
        return taiKhoanService.dangNhap(reqTaiKhoanLogin);
    }

    @GetMapping("/dang-xuat")
    public ResDTO<String> getLogout(HttpServletResponse response) throws Exception {
        try {
            return ResDTO.response(ResEnum.DANG_XUAT_THANH_CONG, "Thoát thành công !!!");
        } catch (Exception e) {
            return ResDTO.response(ResEnum.DANG_XUAT_THANH_CONG, null);
        }
    }
}
