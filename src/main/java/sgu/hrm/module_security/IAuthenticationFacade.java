package sgu.hrm.module_security;

import org.springframework.security.core.Authentication;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_taikhoan.models.TaiKhoan;


public interface IAuthenticationFacade {
    Authentication getAuthentication();

    TaiKhoan getTaiKhoan();

    SoYeuLyLich getSoYeuLyLich();
}
