package sgu.hrm.module_security;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.response.ResDTO;
import sgu.hrm.response.ResEnum;
import sgu.hrm.module_taikhoan.dto.request.ReqTaiKhoanLogin;
import sgu.hrm.module_taikhoan.dto.resopnse.ResTaiKhoanLogin;
import sgu.hrm.module_taikhoan.service.ITaiKhoanService;

@RestController
@Tag(name = "Login", description = "The login API")
@RequiredArgsConstructor
public class SercurityController {

    private final ITaiKhoanService taiKhoanService;

    @GetMapping("/tu-choi")
    public ResDTO<String> getDenied() throws RuntimeException {
        return ResDTO.response(ResEnum.TRUY_CAP_BI_CAM, null);
    }

    @PostMapping("/dang-nhap")
    public ResponseEntity<ResDTO<ResTaiKhoanLogin>> dangNhap(@RequestBody ReqTaiKhoanLogin reqTaiKhoanLogin) {
        ResTaiKhoanLogin taiKhoan = taiKhoanService.dangNhap(reqTaiKhoanLogin);
        if (taiKhoan != null) {
            return new ResponseEntity<>(ResDTO.response(
                    ResEnum.DANG_NHAP_THANH_CONG, taiKhoanService.dangNhap(reqTaiKhoanLogin)),
                    ResEnum.DANG_NHAP_THANH_CONG.getStatusCode());
        }
        return new ResponseEntity<>(ResDTO.response(
                ResEnum.DANG_NHAP_THAT_BAI, null),
                ResEnum.DANG_NHAP_THAT_BAI.getStatusCode());
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
