package sgu.hrm.module_security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_taikhoan.models.TaiKhoan;

import java.util.Optional;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public TaiKhoan getTaiKhoan() {
        Authentication authentication = getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return (TaiKhoan) authentication.getPrincipal();
        } else return null;
    }

    @Override
    public SoYeuLyLich getSoYeuLyLich() {
        return Optional.ofNullable(getTaiKhoan()).map(TaiKhoan::getSoYeuLyLich).orElse(null);
    }
}

