package sgu.hrm.module_taikhoan.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sgu.hrm.module_kafka.KafkaTopicSendMail;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.repository.SoYeuLyLichRepository;
import sgu.hrm.module_security.jwt_utilities.JWTUtilities;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoanLogin;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoan;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoanLogin;
import sgu.hrm.module_taikhoan.repository.TaiKhoanRepository;
import sgu.hrm.module_taikhoan.repository.RoleTaiKhoanRepository;


import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanService implements ITaiKhoanService {

    final TaiKhoanRepository taiKhoanRepository;

    final RoleTaiKhoanRepository roleTaiKhoanRepository;

    final SoYeuLyLichRepository soYeuLyLichRepository;

    final JavaMailSender javaMailSender;

    final JWTUtilities jwtUtilities;

    final PasswordEncoder passwordEncoder;

    final AuthenticationManager authenticationManager;

    private ResTaiKhoan mapToResTaiKhoan(TaiKhoan taiKhoan) {
        return new ResTaiKhoan(
                taiKhoan.getId(),
                taiKhoan.getHoVaTen(),
                taiKhoan.getSoCCCD(),
                taiKhoan.getUsername(),
                taiKhoan.getEmail(),
                Optional.ofNullable(taiKhoan.getSoYeuLyLich()).map(SoYeuLyLich::getId).orElse(null),
                (taiKhoan.getRoleTaiKhoan().getId() == 1) ? "EMPLOYEE" : "ADMIN",
                taiKhoan.isTrangThai(),
                taiKhoan.getCreate_at(),
                taiKhoan.getUpdate_at()
        );
    }

    private TaiKhoan crush_em_t() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return (TaiKhoan) authentication.getPrincipal();
        } else return null;
    }

    @Override
    public ResDTO<ResTaiKhoan> xemThongTinTaiKhoan() {
        try {
            ResTaiKhoan resTaiKhoan = Optional.ofNullable(crush_em_t()).map(this::mapToResTaiKhoan).orElse(null);
            return ResDTO.response(ResEnum.THANH_CONG, resTaiKhoan);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<?> doiMatKhau(String matkhau) {
        try {
            TaiKhoan taiKhoan = crush_em_t();
            if (taiKhoan != null) {
                taiKhoan.setUpdate_at();
                taiKhoan.setPassword(matkhau);
                ResTaiKhoan resTaiKhoan = mapToResTaiKhoan(taiKhoanRepository.save(taiKhoan));
                return ResDTO.response(ResEnum.DOI_MAT_KHAU_THANH_CONG, resTaiKhoan);
            } else return ResDTO.response(ResEnum.KHONG_HOP_LE, "");
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<?> doiEmail(String email) {
        try {
            TaiKhoan taiKhoan = crush_em_t();
            if (taiKhoan != null) {
                taiKhoan.setUpdate_at();
                taiKhoan.setEmail(email);
                return ResDTO.response(ResEnum.DOI_MAT_KHAU_THANH_CONG, mapToResTaiKhoan(taiKhoanRepository.save(taiKhoan)));
            } else return ResDTO.response(ResEnum.KHONG_HOP_LE, "");
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<?> xemDanhSachTaiKhoan() {
        try {
            TaiKhoan taiKhoan = crush_em_t();
            List<ResTaiKhoan> khoanResponseDTOs = List.of();
            if (taiKhoan != null) {
                List<TaiKhoan> taiKhoans = taiKhoanRepository.findAll();
                if (!taiKhoans.isEmpty()) {
                    khoanResponseDTOs = taiKhoans.stream().map(this::mapToResTaiKhoan).toList();
                }
            }
            return ResDTO.response(ResEnum.THANH_CONG, khoanResponseDTOs);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<ResTaiKhoan> xemTaiKhoanTheoSoCCCDOrUsername(String number) {
        try {
            TaiKhoan taiKhoan = crush_em_t();
            ResTaiKhoan resTaiKhoan = null;
            if (taiKhoan != null) {
                TaiKhoan taiKhoanSoCCCD = taiKhoanRepository.findBySoCCCD(number);
                TaiKhoan taiKhoanUsername = taiKhoanRepository.findByUsername(number);
                if (taiKhoanSoCCCD != null) {
                    resTaiKhoan = mapToResTaiKhoan(taiKhoanSoCCCD);
                }
                if (taiKhoanUsername != null) {
                    resTaiKhoan = mapToResTaiKhoan(taiKhoanUsername);
                }
            }
            return ResDTO.response(ResEnum.THANH_CONG, resTaiKhoan);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<ResTaiKhoan> xemTaiKhoanTheoId(int id) {
        try {
            TaiKhoan taiKhoan = crush_em_t();
            ResTaiKhoan resTaiKhoan = null;
            if (taiKhoan != null) {
                resTaiKhoan = taiKhoanRepository.findById(id).map(tk -> mapToResTaiKhoan(tk)).orElse(null);

            }
            return ResDTO.response(ResEnum.THANH_CONG, resTaiKhoan);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<?> themTaiKhoan(ReqTaiKhoan reqTaiKhoan) {
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
                    .roleTaiKhoan(roleTaiKhoanRepository.findById(1).get())
                    .trangThai(true)
                    .create_at(LocalDateTime.now())
                    .build();
            if (taiKhoan != null) {
                soYeuLyLich = SoYeuLyLich.builder()
                        .hovaten(reqTaiKhoan.hoVaTen())
                        .soCCCD(reqTaiKhoan.soCCCD())
                        .create_at(taiKhoan.getCreate_at())
                        .build();
                soYeuLyLichRepository.save(soYeuLyLich);
                taiKhoan.setSoYeuLyLich(soYeuLyLich);
                taiKhoanRepository.save(taiKhoan);
//                return new ResDTO<>(
//                        ResEnum.TAO_THANH_CONG.getStatusCode(),
//                        ResEnum.TAO_THANH_CONG,
//                        Optional.of(soYeuLyLich).map(tk -> new ResDSSoYeuLyLich(
//                                tk.getId(),
//                                tk.getHovaten(),
//                                tk.getSinhNgay() != null ? tk.getSinhNgay() : null,
//                                tk.getChucVuHienTai() != null ? tk.getChucVuHienTai() : null,
//                                tk.getTrinhDoChuyenMon() != null ? tk.getTrinhDoChuyenMon().getName() : null,
//                                tk.getNgachNgheNghiep() != null ? tk.getNgachNgheNghiep() : null,
//                                tk.getCreate_at(),
//                                tk.getUpdate_at(),
//                                tk.isTrangThai()
//                        )).orElse(null)
//                );
                return ResDTO.response(ResEnum.TAO_THANH_CONG, "");
            } else return ResDTO.response(ResEnum.TAO_THANH_CONG, null);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        } finally {
            if (taiKhoan != null) {
                // create the producer
//                KafkaProducer<String, String> producer = new KafkaProducer<>(KafkaTopicSendMail.properties);
//                ProducerRecord<String, String> producerRecord = new ProducerRecord<>("send_mail", taiKhoan.toString());
//                // send data - asynchronous
//                producer.send(producerRecord);
//                //flush + close
//                producer.flush();
//                producer.close();
                //send email
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("noreply-chinhphu@gmail.com");
                message.setTo(reqTaiKhoan.email());
                message.setSubject("CHÀO MỪNG NHÂN VIÊN CHÍNH PHỦ");
                message.setText(String.format("%s\n%s\n%s\n%s",
                        "THÔNG TIN TÀI KHOẢN",
                        "Tên đăng nhập: " + taiKhoan.getUsername(),
                        "Mật khẩu: " + taiKhoan.getPassword(),
                        "Mã sơ yếu lý lịch: " + soYeuLyLich.getId()
                ));
                javaMailSender.send(message);
            }
        }
    }

    @Override
    public ResDTO<?> dangNhap(ReqTaiKhoanLogin reqTaiKhoanLogin) {
        try {
            TaiKhoan taiKhoanLogin = taiKhoanRepository.findByUsername(reqTaiKhoanLogin.username());
            if (taiKhoanLogin != null) {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reqTaiKhoanLogin.username(), reqTaiKhoanLogin.password()));
                System.out.printf("USER IS: %s", taiKhoanLogin.getUsername());
                return ResDTO.response(ResEnum.DANG_NHAP_THANH_CONG, new ResTaiKhoanLogin(
                        mapToResTaiKhoan(taiKhoanLogin),
                        jwtUtilities.generationToken(taiKhoanLogin)
                ));
            }
            //không tạo refresh token ok
            return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
        } catch (AuthenticationException e) {
            return ResDTO.response(ResEnum.DANG_NHAP_THAT_BAI, "");
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
