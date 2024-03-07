package sgu.hrm.module_taikhoan.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sgu.hrm.module_kafka.KafkaConsumers;
import sgu.hrm.module_kafka.KafkaProducers;
import sgu.hrm.module_security.IAuthenticationFacade;
import sgu.hrm.module_utilities.enums.PheDuyet;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.repository.SoYeuLyLichRepository;
import sgu.hrm.module_security.jwt_utilities.JWTUtilities;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoanLogin;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoanLogin;
import sgu.hrm.module_taikhoan.repository.TaiKhoanRepository;
import sgu.hrm.module_utilities.enums.RoleTaiKhoan;


import java.time.LocalDateTime;

import java.util.List;

import static sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoan.mapToResTaiKhoan;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanService implements ITaiKhoanService {

    final TaiKhoanRepository taiKhoanRepository;

    final SoYeuLyLichRepository soYeuLyLichRepository;

    final JavaMailSender javaMailSender;

    final JWTUtilities jwtUtilities;

    final PasswordEncoder passwordEncoder;

    final AuthenticationManager authenticationManager;

    final IAuthenticationFacade facade;

    final KafkaProducers producers;

    final KafkaConsumers consumers;

    @Override
    public TaiKhoan xemThongTinTaiKhoan() {
        try {
            return facade.getTaiKhoan();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public boolean doiMatKhau(String matkhau) {
        try {
            System.out.println(facade.getTaiKhoan().getUsername());
            TaiKhoan taiKhoan = facade.getTaiKhoan();
            if (taiKhoan != null) {
                taiKhoan.setPassword(matkhau);
                taiKhoan.setUpdate_at();
                taiKhoanRepository.save(taiKhoan);
                return true;
            } else return false;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public boolean doiEmail(String email) {
        try {
            TaiKhoan taiKhoan = facade.getTaiKhoan();
            if (taiKhoan != null) {
                taiKhoan.setUpdate_at();
                taiKhoan.setEmail(email);
                return true;
            } else return false;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    /* ADMIN - ADMIN - ADMIN*/
    @Override
    public List<TaiKhoan> xemDanhSachTaiKhoan() {
        System.out.println(facade.getTaiKhoan().getUsername());
        try {
            return taiKhoanRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public TaiKhoan xemTaiKhoanTheoSoCCCDOrUsername(String number) {
        try {
            TaiKhoan taiKhoanSoCCCD = taiKhoanRepository.findBySoCCCD(number);
            TaiKhoan taiKhoanUsername = taiKhoanRepository.findByUsername(number);
            if (taiKhoanSoCCCD != null) {
                return taiKhoanSoCCCD;
            } else return taiKhoanUsername;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public TaiKhoan xemTaiKhoanTheoId(int id) {
        try {
            return taiKhoanRepository.findById(id).orElse(null);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public TaiKhoan themTaiKhoan(ReqTaiKhoan reqTaiKhoan) {
        TaiKhoan taiKhoan = null;
        SoYeuLyLich soYeuLyLich = null;
        try {
            List<TaiKhoan> listUsername = taiKhoanRepository.findAll();
            //tạo username
            String hoVaTen = reqTaiKhoan.hoVaTen();
            String newUsername = ITaiKhoanService.createUsername(hoVaTen, listUsername);
            taiKhoan = TaiKhoan.builder()
                    .hoVaTen(reqTaiKhoan.hoVaTen())
                    .soCCCD(reqTaiKhoan.soCCCD())
                    .username(newUsername)
                    .password(reqTaiKhoan.soCCCD())
                    .email(reqTaiKhoan.email())
                    .roleTaiKhoan(RoleTaiKhoan.EMPLOYEE)
                    .trangThai(true)
                    .create_at(LocalDateTime.now())
                    .build();
            if (taiKhoan != null) {
                soYeuLyLich = SoYeuLyLich.builder()
                        .hoVaTen(reqTaiKhoan.hoVaTen())
                        .soCCCD(reqTaiKhoan.soCCCD())
                        .create_at(taiKhoan.getCreate_at())
                        .pheDuyet(PheDuyet.CHUA_PHE_DUYET)
                        .build();
                soYeuLyLichRepository.save(soYeuLyLich);
                taiKhoan.setSoYeuLyLich(soYeuLyLich);
                return taiKhoanRepository.save(taiKhoan);
            } else return null;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        } finally {
//            if (taiKhoan != null) {
//                producers.sendMailProducer(reqTaiKhoan);
//            }
        }
    }

    @Override
    public ResTaiKhoanLogin dangNhap(ReqTaiKhoanLogin reqTaiKhoanLogin) {
        try {
            TaiKhoan taiKhoanLogin = taiKhoanRepository.findByUsername(reqTaiKhoanLogin.username());
            if (taiKhoanLogin != null) {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reqTaiKhoanLogin.username(), reqTaiKhoanLogin.password()));
                System.out.printf("USER IS: %s", taiKhoanLogin.getUsername());
                return new ResTaiKhoanLogin(
                        mapToResTaiKhoan(taiKhoanLogin),
                        jwtUtilities.generationToken(taiKhoanLogin)
                );
            }
            //không tạo refresh token ok
            return null;
        } catch (AuthenticationException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
