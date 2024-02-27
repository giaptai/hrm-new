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

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanService implements ITaiKhoanService {

    final TaiKhoanRepository taiKhoanRepository;

    final RoleTaiKhoanRepository roleTaiKhoanRepository;

    final SoYeuLyLichRepository soYeuLyLichRepository;

    // final JavaMailSender javaMailSender;

    final JWTUtilities jwtUtilities;

    final PasswordEncoder passwordEncoder;

    final AuthenticationManager authenticationManager;

    @Override
    public ResDTO<ResTaiKhoan> xemThongTinTaiKhoan() {
        try {
            ResTaiKhoan resTaiKhoan = Optional.ofNullable(crush_em_t()).map(this::mapToResTaiKhoan).orElse(null);
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    resTaiKhoan);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private ResTaiKhoan mapToResTaiKhoan(TaiKhoan taiKhoan) {
        return new ResTaiKhoan(
                taiKhoan.getId(),
                taiKhoan.getHoVaTen(),
                taiKhoan.getSoCCCD(),
                taiKhoan.getUsername(),
                Optional.ofNullable(taiKhoan).map(TaiKhoan::getEmail).orElse(null),
                Optional.ofNullable(taiKhoan.getSoYeuLyLich()).map(SoYeuLyLich::getId).orElse(null),
                (taiKhoan.getRoleTaiKhoan().getId() == 1) ? "EMPLOYEE" : "ADMIN",
                taiKhoan.isTrangThai(),
                taiKhoan.getCreate_at(),
                taiKhoan.getUpdate_at());
    }

    private TaiKhoan crush_em_t() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return (TaiKhoan) authentication.getPrincipal();
        } else
            return null;
    }

    @Override
    public ResDTO<?> doiMatKhau(String matkhau) {
        try {
            TaiKhoan taiKhoan = crush_em_t();
            if (taiKhoan != null) {
                taiKhoan.setUpdate_at();
                taiKhoan.setPassword(matkhau);
                taiKhoanRepository.save(taiKhoan);
            }
            ResTaiKhoan resTaiKhoan = Optional.ofNullable(taiKhoan).map(this::mapToResTaiKhoan).orElse(null);
            return new ResDTO<>(
                    ResEnum.DOI_MAT_KHAU_THANH_CONG.getStatusCode(),
                    ResEnum.DOI_MAT_KHAU_THANH_CONG,
                    ResEnum.DOI_MAT_KHAU_THANH_CONG.name());
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
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    khoanResponseDTOs);
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
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    resTaiKhoan);
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
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    resTaiKhoan);
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
            // tạo username
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
                // return new ResDTO<>(
                // ResEnum.TAO_THANH_CONG.getStatusCode(),
                // ResEnum.TAO_THANH_CONG,
                // Optional.of(soYeuLyLich).map(tk -> new ResDSSoYeuLyLich(
                // tk.getId(),
                // tk.getHovaten(),
                // tk.getSinhNgay() != null ? tk.getSinhNgay() : null,
                // tk.getChucVuHienTai() != null ? tk.getChucVuHienTai() : null,
                // tk.getTrinhDoChuyenMon() != null ? tk.getTrinhDoChuyenMon().getName() : null,
                // tk.getNgachNgheNghiep() != null ? tk.getNgachNgheNghiep() : null,
                // tk.getCreate_at(),
                // tk.getUpdate_at(),
                // tk.isTrangThai()
                // )).orElse(null)
                // );
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        "");
            } else
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        } finally {
            if (taiKhoan != null) {
                // create the producer
                // KafkaProducer<String, String> producer = new
                // KafkaProducer<>(KafkaTopicSendMail.properties);
                // ProducerRecord<String, String> producerRecord = new
                // ProducerRecord<>("send_mail", taiKhoan.toString());
                // // send data - asynchronous
                // producer.send(producerRecord);
                // //flush + close
                // producer.flush();
                // producer.close();
                // send mail linux
                // Properties properties = System.getProperties();
                // // Setup mail server
                // properties.setProperty("mail.smtp.host", "smtp.example.com");
                // // Get the default Session object.
                // Session session = Session.getDefaultInstance(properties, null);
                // // Create a default MimeMessage object.

                // try {
                //     // send mail lan nua
                //     Properties props = new Properties();
                //     props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
                //     props.put("mail.smtp.port", "587"); // TLS Port
                //     props.put("mail.smtp.auth", "true"); // enable authentication
                //     props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS
                //     // create Authenticator object to pass in Session.getInstance argument
                //     Authenticator auth = new Authenticator() {
                //         // override the getPasswordAuthentication method
                //         protected PasswordAuthentication getPasswordAuthentication() {
                //             return new PasswordAuthentication("hentaiktvn321@gmail.com", "kshjuungovoianlv");
                //         }
                //     };
                //     Session session = Session.getInstance(props, auth);
                //     Message message = new MimeMessage(session);
                //     // Set From: header field of the header.
                //     message.setFrom(new InternetAddress("noreplay_chinhphu@gmail.com"));
                //     message.setReplyTo(InternetAddress.parse("noreplay_chinhphu@gmail.com", false));
                //     // Set To: header field of the header.
                //     message.setSubject("CHÀO MỪNG NHÂN VIÊN CHÍNH PHỦ");
                //     // message.setText(String.format("%s\n%s\n%s\n%s",
                //     //         "THÔNG TIN TÀI KHOẢN",
                //     //         "Tên đăng nhập: " + taiKhoan.getUsername(),
                //     //         "Mật khẩu: " + taiKhoan.getPassword(),
                //     //         "Mã sơ yếu lý lịch: " + soYeuLyLich.getId()), "UTF-8");
                //     message.setText("Hello, this is sample for to check send email using JavaMailAPI ");
                //     message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reqTaiKhoan.email()));

                //     // Send message
                //     Transport.send(message);
                // } catch (AddressException e) {
                //     e.printStackTrace();
                // } catch (MessagingException e) {
                //     e.printStackTrace();
                // }

                // send email
                // SimpleMailMessage message = new SimpleMailMessage();
                // message.setFrom("noreply-chinhphu@gmail.com");
                // message.setTo(reqTaiKhoan.email());
                // message.setSubject("CHÀO MỪNG NHÂN VIÊN CHÍNH PHỦ");
                // message.setText(String.format("%s\n%s\n%s\n%s",
                // "THÔNG TIN TÀI KHOẢN",
                // "Tên đăng nhập: " + taiKhoan.getUsername(),
                // "Mật khẩu: " + taiKhoan.getPassword(),
                // "Mã sơ yếu lý lịch: " + soYeuLyLich.getId()
                // ));
                // javaMailSender.send(message);
            }
        }
    }

    @Override
    public ResDTO<?> dangNhap(ReqTaiKhoanLogin reqTaiKhoanLogin) {
        try {
            TaiKhoan taiKhoanLogin = taiKhoanRepository.findByUsername(reqTaiKhoanLogin.username());
            if (taiKhoanLogin != null) {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reqTaiKhoanLogin.username(),
                        reqTaiKhoanLogin.password()));
                System.out.printf("USER IS: %s", taiKhoanLogin.getUsername());
                return new ResDTO<>(
                        ResEnum.DANG_NHAP_THANH_CONG.getStatusCode(),
                        ResEnum.DANG_NHAP_THANH_CONG,
                        new ResTaiKhoanLogin(
                                mapToResTaiKhoan(taiKhoanLogin),
                                jwtUtilities.generationToken(taiKhoanLogin)));
            }
            // không tạo refresh token ok
            return new ResDTO<>(
                    ResEnum.HONG_TIM_THAY.getStatusCode(),
                    ResEnum.HONG_TIM_THAY,
                    ResEnum.HONG_TIM_THAY.name());
        } catch (AuthenticationException e) {
            return new ResDTO<>(
                    ResEnum.DANG_NHAP_THAT_BAI.getStatusCode(),
                    ResEnum.DANG_NHAP_THAT_BAI,
                    ResEnum.DANG_NHAP_THAT_BAI.name());
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
