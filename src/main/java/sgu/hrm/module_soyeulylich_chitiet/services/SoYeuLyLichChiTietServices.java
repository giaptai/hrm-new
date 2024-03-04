package sgu.hrm.module_soyeulylich_chitiet.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;

import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.repository.SoYeuLyLichRepository;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.KhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.KienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.KyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.LamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.LoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.LuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.LyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.NghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.NgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.PhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.QuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.QuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.TinHoc;

import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKhenThuongNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKyLuatNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqTinHoc;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResTinHoc;
import sgu.hrm.module_soyeulylich_chitiet.repositories.BanThanCoLamViecChoCheDoCuRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.KhenThuongRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.KienThucAnNinhQuocPhongRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.KyLuatRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.LamViecONuocNgoaiRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.LoaiSoYeuLyLichChiTietRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.LuongBanThanRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.LyLuanChinhTriRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.NghiepVuChuyenNganhRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.NgoaiNguRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.PhuCapKhacRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.QuaTrinhCongTacRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.QuanHeGiaDinhRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.TinHocRepository;

import sgu.hrm.module_taikhoan.models.TaiKhoan;

import sgu.hrm.module_utilities.models.HinhThucKhenThuong;
import sgu.hrm.module_utilities.repositories.HinhThucKhenThuongRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor // create constructor if field is set final or @notnull
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoYeuLyLichChiTietServices {
    //DI
    final SoYeuLyLichRepository soYeuLyLichRepository;
    final LoaiSoYeuLyLichChiTietRepository loaiSoYeuLyLichChiTietRepository;
    final BanThanCoLamViecChoCheDoCuRepository banThanCoLamViecChoCheDoCuRepository;
    final KhenThuongRepository khenThuongRepository;
    final HinhThucKhenThuongRepository hinhThucKhenThuongRepository;
    final KienThucAnNinhQuocPhongRepository kienThucAnNinhQuocPhongRepository;
    final KyLuatRepository kyLuatRepository;
    final LamViecONuocNgoaiRepository lamViecONuocNgoaiRepository;
    final LuongBanThanRepository luongBanThanRepository;
    final LyLuanChinhTriRepository lyLuanChinhTriRepository;
    final NghiepVuChuyenNganhRepository nghiepVuChuyenNganhRepository;
    final NgoaiNguRepository ngoaiNguRepository;
    final PhuCapKhacRepository phuCapKhacRepository;
    final QuanHeGiaDinhRepository quanHeGiaDinhRepository;
    final QuaTrinhCongTacRepository quaTrinhCongTacRepository;
    final TinHocRepository tinHocRepository;

    private TaiKhoan crush_em_T() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return ((TaiKhoan) auth.getPrincipal());
        } else return null;
    }

    private SoYeuLyLich syll() {
        return crush_em_T() != null ? crush_em_T().getSoYeuLyLich() : null;
    }

    @Service
    class LoaiSoYeuLyLichChiTietService implements ISoYeuLyLichChiTietServices.ILoaiSoYeuLyLichChiTietSefvice {
        @Override
        public ResDTO<List<LoaiSoYeuLyLichChiTiet>> xemLoaiSoYeuLyLichChiTiet() {
            try {
                return ResDTO.response(ResEnum.THANH_CONG, loaiSoYeuLyLichChiTietRepository.findAll());
            } catch (RuntimeException e) {
                return ResDTO.response(ResEnum.KHONG_HOP_LE, null);
            }
        }

        @Override
        public ResDTO<LoaiSoYeuLyLichChiTiet> themLoaiSoYeuLyLichChiTiet(ReqLoaiSoYeuLyLichChiTiet name) {
            LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet = new LoaiSoYeuLyLichChiTiet(name.name());
            try {
                return ResDTO.response(ResEnum.THANH_CONG, loaiSoYeuLyLichChiTietRepository.save(loaiSoYeuLyLichChiTiet));
            } catch (RuntimeException e) {
                return ResDTO.response(ResEnum.KHONG_HOP_LE, null);
            }
        }

        @Override
        public ResDTO<LoaiSoYeuLyLichChiTiet> suaLoaiSoYeuLyLichChiTiet(LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet) {
            Optional<LoaiSoYeuLyLichChiTiet> loaiSoYeuLyLichChiTiet1 = loaiSoYeuLyLichChiTietRepository.findById(loaiSoYeuLyLichChiTiet.getId());
            if (loaiSoYeuLyLichChiTiet1.isPresent()) {
                loaiSoYeuLyLichChiTiet.setUpdate_at(); //update thoi gian sua entity nay, ok
                return ResDTO.response(ResEnum.THANH_CONG, loaiSoYeuLyLichChiTietRepository.save(loaiSoYeuLyLichChiTiet));
            }
            return ResDTO.response(ResEnum.KHONG_HOP_LE, null);
        }
    }

    @Service
    public class BanThanCoLamViecChoCheDoCuService extends ISoYeuLyLichChiTietServices.IBanThanCoLamViecChoCheDoCuSefvice {
        private ResBanThanCoLamViecChoCheDoCu mapToResBanThanCoLamViecChoCheDoCu(BanThanCoLamViecChoCheDoCu cu) {
            return cu != null ? new ResBanThanCoLamViecChoCheDoCu(
                    cu.getId(),
                    cu.getBatDau(),
                    cu.getKetThuc(),
                    cu.getChucDanhDonViDiaDiem(),
                    cu.getCreate_at(),
                    cu.getUpdate_at()
            ) : null;
        }

        private BanThanCoLamViecChoCheDoCu mapToBanThanCoLamViecChoCheDoCu(ReqBanThanCoLamViecChoCheDoCu cu) {
            return new BanThanCoLamViecChoCheDoCu(
                    cu.batDau(),
                    cu.ketThuc(),
                    cu.chucDanhDonViDiaDiem(),
                    null,
                    syll());
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<ResBanThanCoLamViecChoCheDoCu> resCu = new ArrayList<>();
            try {
                if (syll != null) {
                    resCu = banThanCoLamViecChoCheDoCuRepository.getAllBySyll(syll.getId()).stream().map(this::mapToResBanThanCoLamViecChoCheDoCu).toList();
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, resCu);
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            BanThanCoLamViecChoCheDoCu cu = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    cu = banThanCoLamViecChoCheDoCuRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, mapToResBanThanCoLamViecChoCheDoCu(cu));
        }

        @Override
        public ResDTO<?> themThongTin(ReqBanThanCoLamViecChoCheDoCu req) {
            BanThanCoLamViecChoCheDoCu banThanCoLamViecChoCheDoCu;
            try {
                banThanCoLamViecChoCheDoCu = mapToBanThanCoLamViecChoCheDoCu(req);
                banThanCoLamViecChoCheDoCuRepository.save(banThanCoLamViecChoCheDoCu);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, mapToResBanThanCoLamViecChoCheDoCu(banThanCoLamViecChoCheDoCu));
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqBanThanCoLamViecChoCheDoCu req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    banThanCoLamViecChoCheDoCuRepository.updateByIdAndSyll(req.batDau(), req.ketThuc(), req.chucDanhDonViDiaDiem(), id, syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, "");
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    BanThanCoLamViecChoCheDoCu cu = banThanCoLamViecChoCheDoCuRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (cu != null) {
                        banThanCoLamViecChoCheDoCuRepository.delete(cu);
                    } else return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
                }
                return ResDTO.response(ResEnum.XOA_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemDanhSach(String id) {
            try {
                List<ResBanThanCoLamViecChoCheDoCu> banThanCoLamViecChoCheDoCus =
                        banThanCoLamViecChoCheDoCuRepository.listBanThanCoLamViecChoCheDoCu(UUID.fromString(id)).stream().map(
                                this::mapToResBanThanCoLamViecChoCheDoCu
                        ).toList();
                return ResDTO.response(ResEnum.THANH_CONG, banThanCoLamViecChoCheDoCus);
            } catch (IllegalArgumentException e) {
                return ResDTO.response(ResEnum.HONG_TIM_THAY, null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class KhenThuongService extends ISoYeuLyLichChiTietServices.IKhenThuongSefvice {
        private ResKhenThuong mapToResKhenThuong(KhenThuong thuong) {
            return thuong != null ? new ResKhenThuong(
                    thuong.getId(),
                    thuong.getNam(),
                    thuong.getXepLoaiChuyenMon(),
                    thuong.getXepLoaiThiDua(),
                    Optional.ofNullable(thuong.getHinhThucKhenThuong()).map(HinhThucKhenThuong::getName).orElse(null),
                    thuong.getCreate_at(),
                    thuong.getUpdate_at()
            ) : null;
        }

        private KhenThuong mapToKhenThuong(ReqKhenThuong cu) {
            return new KhenThuong(
                    cu.nam(),
                    cu.xepLoaiChuyenMon(),
                    cu.xepLoaiThiDua(),
                    hinhThucKhenThuongRepository.findById(cu.hinhThucKhenThuong()).orElse(null),
                    cu.lyDo(),
                    null,
                    syll());
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<ResKhenThuong> resKhen = new ArrayList<>();
            try {
                if (syll != null) {
                    resKhen = khenThuongRepository.getAllBySyll(syll.getId()).stream().map(this::mapToResKhenThuong).toList();
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, resKhen);
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            KhenThuong khen = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    khen = khenThuongRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, mapToResKhenThuong(khen));
        }

        @Override
        public ResDTO<?> themThongTin(ReqKhenThuong req) {
            KhenThuong khen;
            try {
                khen = mapToKhenThuong(req);
                khenThuongRepository.save(khen);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, mapToResKhenThuong(khen));
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqKhenThuong req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    khenThuongRepository.updateByIdAndSyll(req.nam(), req.xepLoaiChuyenMon(), req.xepLoaiThiDua(), hinhThucKhenThuongRepository.findById(req.hinhThucKhenThuong()).orElse(null), req.lyDo(), id, syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, "");
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    KhenThuong khen = khenThuongRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (khen != null) {
                        khenThuongRepository.delete(khen);
                    } else return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
                }
                return ResDTO.response(ResEnum.XOA_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemDanhSach(String id) {
            try {
                List<ResKhenThuong> resKhenThuongs =
                        khenThuongRepository.listKhenThuong(UUID.fromString(id)).stream().map(
                                this::mapToResKhenThuong
                        ).toList();
                return ResDTO.response(ResEnum.THANH_CONG, resKhenThuongs);
            } catch (IllegalArgumentException e) {
                return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> khenThuongNhanVien(List<ReqKhenThuongNhanVien> vien) {
            try {
                List<KhenThuong> khenThuongs = vien.stream().flatMap(
                        reqNV -> reqNV.nhanVienUUIDs().stream().map(
                                nvId -> mapToKhenThuong(reqNV.khenThuong())
                        )).toList();
                khenThuongRepository.saveAll(khenThuongs);
                List<ResKhenThuong> resKT = khenThuongs.stream().map(this::mapToResKhenThuong).toList();
                return ResDTO.response(ResEnum.KHEN_THUONG_THANH_CONG, khenThuongs.stream().map(this::mapToResKhenThuong).toList());
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class KienThucAnNinhQuocPhongService extends ISoYeuLyLichChiTietServices.IKienThucAnNinhQuocPhongSefvice {
        private ResKienThucAnNinhQuocPhong mapToResKienThucAnNinhQuocPhong(KienThucAnNinhQuocPhong phong) {
            return phong != null ? new ResKienThucAnNinhQuocPhong(
                    phong.getId(),
                    phong.getBatDau(),
                    phong.getKetThuc(),
                    phong.getTenCoSoDaoTao(),
                    phong.getChungChiDuocCap(),
                    phong.getCreate_at(),
                    phong.getUpdate_at()
            ) : null;
        }

        private KienThucAnNinhQuocPhong mapToKienThucAnNinhQuocPhong(ReqKienThucAnNinhQuocPhong cu) {
            return new KienThucAnNinhQuocPhong(
                    cu.batDau(),
                    cu.ketThuc(),
                    cu.tenCoSoDaoTao(),
                    cu.chungChiDuocCap(),
                    null,
                    syll());
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<ResKienThucAnNinhQuocPhong> resKien = new ArrayList<>();
            try {
                if (syll != null) {
                    resKien = kienThucAnNinhQuocPhongRepository.getAllBySyll(syll.getId()).stream().map(this::mapToResKienThucAnNinhQuocPhong).toList();
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, resKien);
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            KienThucAnNinhQuocPhong kien = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    kien = kienThucAnNinhQuocPhongRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, mapToResKienThucAnNinhQuocPhong(kien));
        }

        @Override
        public ResDTO<?> themThongTin(ReqKienThucAnNinhQuocPhong req) {
            KienThucAnNinhQuocPhong kien;
            try {
                kien = mapToKienThucAnNinhQuocPhong(req);
                kienThucAnNinhQuocPhongRepository.save(kien);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, mapToResKienThucAnNinhQuocPhong(kien));
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqKienThucAnNinhQuocPhong req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    kienThucAnNinhQuocPhongRepository.updateByIdAndSyll(req.batDau(), req.ketThuc(), req.tenCoSoDaoTao(), req.chungChiDuocCap(), id, syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, "");
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    KienThucAnNinhQuocPhong kien = kienThucAnNinhQuocPhongRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (kien != null) {
                        kienThucAnNinhQuocPhongRepository.delete(kien);
                    } else return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
                }
                return ResDTO.response(ResEnum.XOA_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemDanhSach(String id) {
            try {
                List<ResKienThucAnNinhQuocPhong> resKienThucAnNinhQuocPhongs =
                        kienThucAnNinhQuocPhongRepository.listKienThucAnNinhQuocPhong(UUID.fromString(id)).stream().map(
                                this::mapToResKienThucAnNinhQuocPhong
                        ).toList();
                return ResDTO.response(ResEnum.THANH_CONG, resKienThucAnNinhQuocPhongs);
            } catch (IllegalArgumentException e) {
                return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class KyLuatService extends ISoYeuLyLichChiTietServices.IKyLuatSefvice {
        private ResKyLuat mapToResKyLuat(KyLuat luat) {
            return luat != null ? new ResKyLuat(
                    luat.getId(),
                    luat.getBatDau(),
                    luat.getKetThuc(),
                    luat.getHinhThuc(),
                    luat.getHanhViViPhamChinh(),
                    luat.getCoQuanQuyetDinh(),
                    luat.getCreate_at(),
                    luat.getUpdate_at()
            ) : null;
        }

        private KyLuat mapToKyLuat(ReqKyLuat cu) {
            return new KyLuat(
                    cu.batDau(),
                    cu.ketThuc(),
                    cu.hinhThuc(),
                    cu.hanhViViPhamChinh(),
                    cu.coQuanQuyetDinh(),
                    null,
                    syll());
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<ResKyLuat> resKy = new ArrayList<>();
            try {
                if (syll != null) {
                    resKy = kyLuatRepository.getAllBySyll(syll.getId()).stream().map(this::mapToResKyLuat).toList();
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, resKy);
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            KyLuat ky = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    ky = kyLuatRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, mapToResKyLuat(ky));
        }

        @Override
        public ResDTO<?> themThongTin(ReqKyLuat req) {
            KyLuat ky;
            try {
                ky = mapToKyLuat(req);
                kyLuatRepository.save(ky);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, mapToResKyLuat(ky));
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqKyLuat req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    kyLuatRepository.updateByIdAndSyll(req.batDau(), req.ketThuc(), req.hinhThuc(), req.hanhViViPhamChinh(), req.coQuanQuyetDinh(), id, syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, "");
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    KyLuat ky = kyLuatRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (ky != null) {
                        kyLuatRepository.delete(ky);
                    } else return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
                }
                return ResDTO.response(ResEnum.XOA_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemDanhSach(String id) {
            try {
                List<ResKyLuat> resKyLuats =
                        kyLuatRepository.listKyLuat(UUID.fromString(id)).stream().map(
                                this::mapToResKyLuat
                        ).toList();
                return ResDTO.response(ResEnum.THANH_CONG, resKyLuats);
            } catch (IllegalArgumentException e) {
                return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> kyLuatNhanVien(List<ReqKyLuatNhanVien> ky) {
            try {
//                List<KyLuat> kyLuats = ky.stream().flatMap(
//                        reqNV -> reqNV.nhanVienUUIDs().stream().map(
//                                nvId -> mapToKyLuat(reqNV.kyLuat())
//                        )).toList();
//                kyLuatRepository.saveAll(kyLuats);
                return ResDTO.response(ResEnum.KY_LUAT_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class LamViecONuocNgoaiServcie extends ISoYeuLyLichChiTietServices.ILamViecONuocNgoaiSefvice {
        private ResLamViecONuocNgoai mapToResLamViecONuocNgoai(LamViecONuocNgoai ngoai) {
            return ngoai != null ? new ResLamViecONuocNgoai(
                    ngoai.getId(),
                    ngoai.getBatDau(),
                    ngoai.getKetThuc(),
                    ngoai.getToChucDiaChiCongViec(),
                    ngoai.getCreate_at(),
                    ngoai.getUpdate_at()
            ) : null;
        }

        private LamViecONuocNgoai mapToLamViecONuocNgoai(ReqLamViecONuocNgoai cu) {
            return new LamViecONuocNgoai(
                    cu.batDau(),
                    cu.ketThuc(),
                    cu.toChucDiaChiCongViec(),
                    null,
                    syll());
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<ResLamViecONuocNgoai> resNgoai = new ArrayList<>();
            try {
                if (syll != null) {
                    resNgoai = lamViecONuocNgoaiRepository.getAllBySyll(syll.getId()).stream().map(this::mapToResLamViecONuocNgoai).toList();
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, resNgoai);
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            LamViecONuocNgoai ngoai = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    ngoai = lamViecONuocNgoaiRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, mapToResLamViecONuocNgoai(ngoai));
        }

        @Override
        public ResDTO<?> themThongTin(ReqLamViecONuocNgoai req) {
            LamViecONuocNgoai ngoai;
            try {
                ngoai = mapToLamViecONuocNgoai(req);
                lamViecONuocNgoaiRepository.save(ngoai);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, mapToResLamViecONuocNgoai(ngoai));
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqLamViecONuocNgoai req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    lamViecONuocNgoaiRepository.updateByIdAndSyll(req.batDau(), req.ketThuc(), req.toChucDiaChiCongViec(), id, syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, "");
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    LamViecONuocNgoai ngoai = lamViecONuocNgoaiRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (ngoai != null) {
                        lamViecONuocNgoaiRepository.delete(ngoai);
                    } else return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
                }
                return ResDTO.response(ResEnum.XOA_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemDanhSach(String id) {
            try {
                List<ResLamViecONuocNgoai> resLamViecONuocNgoais =
                        lamViecONuocNgoaiRepository.listLamViecONuocNgoai(UUID.fromString(id)).stream().map(
                                this::mapToResLamViecONuocNgoai
                        ).toList();
                return ResDTO.response(ResEnum.THANH_CONG, resLamViecONuocNgoais);
            } catch (IllegalArgumentException e) {
                return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class LuongBanThanService extends ISoYeuLyLichChiTietServices.ILuongBanThanSefvice {
        private ResLuongBanThan mapToResLuongBanThan(LuongBanThan than) {
            return than != null ? new ResLuongBanThan(
                    than.getId(),
                    than.getBatDau(),
                    than.getKetThuc(),
                    than.getMaSo(),
                    than.getBacLuong(),
                    than.getHeSoLuong(),
                    than.getTienLuongTheoViTri(),
                    than.getCreate_at(),
                    than.getUpdate_at()
            ) : null;
        }

        private LuongBanThan mapToLuongBanThan(ReqLuongBanThan cu) {
            return new LuongBanThan(
                    cu.batDau(),
                    cu.ketThuc(),
                    cu.maSo(),
                    cu.bacLuong(),
                    cu.heSoLuong(),
                    cu.tienLuongTheoViTri(),
                    null,
                    syll());
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<ResLuongBanThan> resNgoai = new ArrayList<>();
            try {
                if (syll != null) {
                    resNgoai = luongBanThanRepository.getAllBySyll(syll.getId()).stream().map(this::mapToResLuongBanThan).toList();
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, resNgoai);
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            LuongBanThan luong = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    luong = luongBanThanRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, mapToResLuongBanThan(luong));
        }

        @Override
        public ResDTO<?> themThongTin(ReqLuongBanThan req) {
            LuongBanThan luong;
            try {
                luong = mapToLuongBanThan(req);
                luongBanThanRepository.save(luong);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, mapToResLuongBanThan(luong));
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqLuongBanThan req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    luongBanThanRepository.updateByIdAndSyll(req.batDau(), req.ketThuc(), req.maSo(), req.bacLuong(), req.heSoLuong(), req.tienLuongTheoViTri(), id, syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, "");
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    LuongBanThan luong = luongBanThanRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (luong != null) {
                        luongBanThanRepository.delete(luong);
                    } else return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
                }
                return ResDTO.response(ResEnum.XOA_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemDanhSach(String id) {
            try {
                List<ResLuongBanThan> resLuongBanThans =
                        luongBanThanRepository.listLuongBanThan(UUID.fromString(id)).stream().map(
                                this::mapToResLuongBanThan
                        ).toList();
                return ResDTO.response(ResEnum.THANH_CONG, resLuongBanThans);
            } catch (IllegalArgumentException e) {
                return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class LyLuanChinhTriService extends ISoYeuLyLichChiTietServices.ILyLuanChinhTriSefvice {
        private ResLyLuanChinhTri mapToResLyLuanChinhTri(LyLuanChinhTri tri) {
            return tri != null ? new ResLyLuanChinhTri(
                    tri.getId(),
                    tri.getBatDau(),
                    tri.getKetThuc(),
                    tri.getTenCoSoDaoTao(),
                    tri.getHinhThucDaoTao(),
                    tri.getVanBangDuocCap(),
                    tri.getCreate_at(),
                    tri.getUpdate_at()
            ) : null;
        }

        private LyLuanChinhTri mapToLyLuanChinhTri(ReqLyLuanChinhTri cu) {
            return new LyLuanChinhTri(
                    cu.batDau(),
                    cu.ketThuc(),
                    cu.tenCoSoDaoTao(),
                    cu.hinhThucDaoTao(),
                    cu.vanBangDuocCap(),
                    null,
                    syll());
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<ResLyLuanChinhTri> resTri = new ArrayList<>();
            try {
                if (syll != null) {
                    resTri = lyLuanChinhTriRepository.getAllBySyll(syll.getId()).stream().map(this::mapToResLyLuanChinhTri).toList();
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, resTri);
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            LyLuanChinhTri tri = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    tri = lyLuanChinhTriRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.THANH_CONG, mapToResLyLuanChinhTri(tri));
        }

        @Override
        public ResDTO<?> themThongTin(ReqLyLuanChinhTri req) {
            LyLuanChinhTri tri;
            try {
                tri = mapToLyLuanChinhTri(req);
                lyLuanChinhTriRepository.save(tri);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, mapToResLyLuanChinhTri(tri));
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqLyLuanChinhTri req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    lyLuanChinhTriRepository.updateByIdAndSyll(req.batDau(), req.ketThuc(), req.tenCoSoDaoTao(), req.hinhThucDaoTao(), req.vanBangDuocCap(), id, syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, "");
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    LyLuanChinhTri tri = lyLuanChinhTriRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (tri != null) {
                        lyLuanChinhTriRepository.delete(tri);
                    } else return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
                }
                return ResDTO.response(ResEnum.XOA_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemDanhSach(String id) {
            try {
                List<ResLyLuanChinhTri> resLyLuanChinhTris =
                        lyLuanChinhTriRepository.listLyLuanChinhTri(UUID.fromString(id)).stream().map(
                                this::mapToResLyLuanChinhTri
                        ).toList();
                return ResDTO.response(ResEnum.THANH_CONG, resLyLuanChinhTris);
            } catch (IllegalArgumentException e) {
                return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class NghiepVuChuyenNganhService extends ISoYeuLyLichChiTietServices.INghiepVuChuyenNganhSefvice {
        private ResNghiepVuChuyenNganh mapToResNghiepVuChuyenNganh(NghiepVuChuyenNganh nganh) {
            return new ResNghiepVuChuyenNganh(
                    nganh.getId(),
                    nganh.getBatDau(),
                    nganh.getKetThuc(),
                    nganh.getTenCoSoDaoTao(),
                    nganh.getChungChiDuocCap(),
                    nganh.getCreate_at(),
                    nganh.getUpdate_at()
            );
        }

        private NghiepVuChuyenNganh mapToNghiepVuChuyenNganh(int check, SoYeuLyLich syll, ReqNghiepVuChuyenNganh cu) {
            return check == 1 ? NghiepVuChuyenNganh.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .tenCoSoDaoTao(cu.tenCoSoDaoTao())
                    .chungChiDuocCap(cu.chungChiDuocCap())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .build() :
                    new NghiepVuChuyenNganh(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.tenCoSoDaoTao(),
                            cu.chungChiDuocCap(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResNghiepVuChuyenNganh> nghiepVuChuyenNganhs = new ArrayList<>();
                if (taiKhoan != null) {
                    nghiepVuChuyenNganhs = taiKhoan.getSoYeuLyLich().getNghiepVuChuyenNganhs().stream().map(
                            this::mapToResNghiepVuChuyenNganh
                    ).toList();
                }
                return ResDTO.response(ResEnum.THANH_CONG, nghiepVuChuyenNganhs);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResNghiepVuChuyenNganh nghiepVuChuyenNganh = null;
                if (taiKhoan != null) {
                    nghiepVuChuyenNganh = taiKhoan.getSoYeuLyLich().getNghiepVuChuyenNganhs().stream().map(
                            this::mapToResNghiepVuChuyenNganh
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return ResDTO.response(ResEnum.THANH_CONG, nghiepVuChuyenNganh);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqNghiepVuChuyenNganh cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                NghiepVuChuyenNganh nghiepVuChuyenNganh = null;
                if (taiKhoan != null) {
                    nghiepVuChuyenNganh = mapToNghiepVuChuyenNganh(-1, taiKhoan.getSoYeuLyLich(), cu);
                    nghiepVuChuyenNganhRepository.save(nghiepVuChuyenNganh);
                }
                return ResDTO.response(ResEnum.THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqNghiepVuChuyenNganh cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                NghiepVuChuyenNganh nghiepVuChuyenNganh = null;
                if (taiKhoan != null) {
                    nghiepVuChuyenNganh = mapToNghiepVuChuyenNganh(1, taiKhoan.getSoYeuLyLich(), cu);
                    nghiepVuChuyenNganh.setId(id);
                    nghiepVuChuyenNganh.setUpdate_at();
                    nghiepVuChuyenNganhRepository.save(nghiepVuChuyenNganh);
                }
                return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, nghiepVuChuyenNganh != null ? mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganh) : null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                NghiepVuChuyenNganh nghiepVuChuyenNganh = null;
                if (taiKhoan != null) {
                    nghiepVuChuyenNganh = taiKhoan.getSoYeuLyLich().getNghiepVuChuyenNganhs().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    nghiepVuChuyenNganhRepository.delete(nghiepVuChuyenNganh);
                }
                return ResDTO.response(ResEnum.XOA_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemDanhSach(String id) {
            try {
                List<ResNghiepVuChuyenNganh> resNghiepVuChuyenNganhs =
                        nghiepVuChuyenNganhRepository.listNghiepVuChuyenNganh(UUID.fromString(id)).stream().map(
                                this::mapToResNghiepVuChuyenNganh
                        ).toList();
                return ResDTO.response(ResEnum.THANH_CONG, resNghiepVuChuyenNganhs);
            } catch (IllegalArgumentException e) {
                return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class NgoaiNguService extends ISoYeuLyLichChiTietServices.INgoaiNguSefvice {
        private ResNgoaiNgu mapToResNgoaiNgu(NgoaiNgu ngu) {
            return new ResNgoaiNgu(
                    ngu.getId(),
                    ngu.getBatDau(),
                    ngu.getKetThuc(),
                    ngu.getTenCoSoDaoTao(),
                    ngu.getTenNgoaiNgu(),
                    ngu.getChungChiDuocCap(),
                    ngu.getDiemSo(),
                    ngu.getCreate_at(),
                    ngu.getUpdate_at()
            );
        }

        private NgoaiNgu mapToNgoaiNgu(int check, SoYeuLyLich syll, ReqNgoaiNgu cu) {
            return check == 1 ? NgoaiNgu.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .tenCoSoDaoTao(cu.tenCoSoDaoTao())
                    .tenNgoaiNgu(cu.tenNgoaiNgu())
                    .chungChiDuocCap(cu.chungChiDuocCap())
                    .diemSo(cu.diemSo())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .build() :
                    new NgoaiNgu(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.tenCoSoDaoTao(),
                            cu.tenNgoaiNgu(),
                            cu.chungChiDuocCap(),
                            cu.diemSo(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResNgoaiNgu> ngoaiNgus = new ArrayList<>();
                if (taiKhoan != null) {
                    ngoaiNgus = taiKhoan.getSoYeuLyLich().getNgoaiNgus().stream().map(
                            this::mapToResNgoaiNgu
                    ).toList();
                }
                return ResDTO.response(ResEnum.THANH_CONG, ngoaiNgus);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResNgoaiNgu ngoaiNgu = null;
                if (taiKhoan != null) {
                    ngoaiNgu = taiKhoan.getSoYeuLyLich().getNgoaiNgus().stream().map(
                            this::mapToResNgoaiNgu
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return ResDTO.response(ResEnum.THANH_CONG, ngoaiNgu);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqNgoaiNgu cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                NgoaiNgu ngoaiNgu = null;
                if (taiKhoan != null) {
                    ngoaiNgu = mapToNgoaiNgu(-1, taiKhoan.getSoYeuLyLich(), cu);
                    ngoaiNguRepository.save(ngoaiNgu);
                }
                return ResDTO.response(ResEnum.THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqNgoaiNgu cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                NgoaiNgu ngoaiNgu = null;
                if (taiKhoan != null) {
                    ngoaiNgu = mapToNgoaiNgu(1, taiKhoan.getSoYeuLyLich(), cu);
                    ngoaiNgu.setId(id);
                    ngoaiNgu.setUpdate_at();
                    ngoaiNguRepository.save(ngoaiNgu);
                }
                return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, ngoaiNgu != null ? mapToResNgoaiNgu(ngoaiNgu) : null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                NgoaiNgu ngoaiNgu = null;
                if (taiKhoan != null) {
                    ngoaiNgu = taiKhoan.getSoYeuLyLich().getNgoaiNgus().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    ngoaiNguRepository.delete(ngoaiNgu);
                }
                return ResDTO.response(ResEnum.XOA_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemDanhSach(String id) {
            try {
                List<ResNgoaiNgu> resNgoaiNgus =
                        ngoaiNguRepository.listNgoaiNgu(UUID.fromString(id)).stream().map(
                                this::mapToResNgoaiNgu
                        ).toList();
                return ResDTO.response(ResEnum.THANH_CONG, resNgoaiNgus);
            } catch (IllegalArgumentException e) {
                return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class PhuCapKhacService extends ISoYeuLyLichChiTietServices.IPhuCapKhacSefvice {
        private ResPhuCapKhac mapToResPhuCapKhac(PhuCapKhac khac) {
            return new ResPhuCapKhac(
                    khac.getId(),
                    khac.getBatDau(),
                    khac.getKetThuc(),
                    khac.getLoaiPhuCap(),
                    khac.getPhanTramHuongPhuCap(),
                    khac.getHeSoPhuCap(),
                    khac.getHinhThucThuong(),
                    khac.getGiaTri(),
                    khac.getCreate_at(),
                    khac.getUpdate_at()
            );
        }

        private PhuCapKhac mapToPhuCapKhac(int check, SoYeuLyLich syll, ReqPhuCapKhac cu) {
            return check == 1 ? PhuCapKhac.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .loaiPhuCap(cu.loaiPhuCap())
                    .phanTramHuongPhuCap(cu.phanTramHuongPhuCap())
                    .heSoPhuCap(cu.heSoPhuCap())
                    .hinhThucThuong(cu.hinhThucThuong())
                    .giaTri(cu.giaTri())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .build() :
                    new PhuCapKhac(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.loaiPhuCap(),
                            cu.phanTramHuongPhuCap(),
                            cu.heSoPhuCap(),
                            cu.hinhThucThuong(),
                            cu.giaTri(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResPhuCapKhac> phuCapKhacs = new ArrayList<>();
                if (taiKhoan != null) {
                    phuCapKhacs = taiKhoan.getSoYeuLyLich().getPhuCapKhacs().stream().map(
                            this::mapToResPhuCapKhac
                    ).toList();
                }
                return ResDTO.response(ResEnum.THANH_CONG, phuCapKhacs);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResPhuCapKhac phuCapKhac = null;
                if (taiKhoan != null) {
                    phuCapKhac = taiKhoan.getSoYeuLyLich().getPhuCapKhacs().stream().map(
                            this::mapToResPhuCapKhac
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return ResDTO.response(ResEnum.THANH_CONG, phuCapKhac);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqPhuCapKhac cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                PhuCapKhac phuCapKhac = null;
                if (taiKhoan != null) {
                    phuCapKhac = mapToPhuCapKhac(-1, taiKhoan.getSoYeuLyLich(), cu);
                    phuCapKhacRepository.save(phuCapKhac);
                }
                return ResDTO.response(ResEnum.THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqPhuCapKhac cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                PhuCapKhac phuCapKhac = null;
                if (taiKhoan != null) {
                    phuCapKhac = mapToPhuCapKhac(1, taiKhoan.getSoYeuLyLich(), cu);
                    phuCapKhac.setId(id);
                    phuCapKhac.setUpdate_at();
                    phuCapKhacRepository.save(phuCapKhac);
                }
                return ResDTO.response(ResEnum.THANH_CONG, phuCapKhac != null ? mapToResPhuCapKhac(phuCapKhac) : null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                PhuCapKhac phuCapKhac = null;
                if (taiKhoan != null) {
                    phuCapKhac = taiKhoan.getSoYeuLyLich().getPhuCapKhacs().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    phuCapKhacRepository.delete(phuCapKhac);
                }
                return ResDTO.response(ResEnum.XOA_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemDanhSach(String id) {
            try {
                List<ResPhuCapKhac> resPhuCapKhacs =
                        phuCapKhacRepository.listPhuCapKhac(UUID.fromString(id)).stream().map(
                                this::mapToResPhuCapKhac
                        ).toList();
                return ResDTO.response(ResEnum.XOA_THANH_CONG, resPhuCapKhacs);
            } catch (IllegalArgumentException e) {
                return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class QuanHeGiaDinhService extends ISoYeuLyLichChiTietServices.IQuanHeGiaDinhSefvice {
        private ResQuanHeGiaDinh mapToResQuanHeGiaDinh(QuanHeGiaDinh dinh) {
            return new ResQuanHeGiaDinh(
                    dinh.getId(),
                    dinh.getMoiQuanHe(),
                    dinh.getHoVaTen(),
                    dinh.getNamSinh(),
                    dinh.getThongTinThanNhan(),
                    dinh.getCreate_at(),
                    dinh.getUpdate_at()
            );
        }

        private QuanHeGiaDinh mapToQuanHeGiaDinh(int check, SoYeuLyLich syll, ReqQuanHeGiaDinh cu) {
            return check == 1 ? QuanHeGiaDinh.builder()
                    .moiQuanHe(cu.moiQuanHe())
                    .hoVaTen(cu.hoVaTen())
                    .namSinh(cu.namSinh())
                    .thongTinThanNhan(cu.thongTinThanNhan())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .build() :
                    new QuanHeGiaDinh(
                            cu.moiQuanHe(),
                            cu.hoVaTen(),
                            cu.namSinh(),
                            cu.thongTinThanNhan(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResQuanHeGiaDinh> quanHeGiaDinhs = new ArrayList<>();
                if (taiKhoan != null) {
                    quanHeGiaDinhs = taiKhoan.getSoYeuLyLich().getQuanHeGiaDinhs().stream().map(
                            this::mapToResQuanHeGiaDinh
                    ).toList();
                }
                return ResDTO.response(ResEnum.THANH_CONG, quanHeGiaDinhs);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResQuanHeGiaDinh quanHeGiaDinh = null;
                if (taiKhoan != null) {
                    quanHeGiaDinh = taiKhoan.getSoYeuLyLich().getQuanHeGiaDinhs().stream().map(
                            this::mapToResQuanHeGiaDinh
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return ResDTO.response(ResEnum.THANH_CONG, quanHeGiaDinh);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqQuanHeGiaDinh cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                QuanHeGiaDinh quanHeGiaDinh = null;
                if (taiKhoan != null) {
                    quanHeGiaDinh = mapToQuanHeGiaDinh(-1, taiKhoan.getSoYeuLyLich(), cu);
                    quanHeGiaDinhRepository.save(quanHeGiaDinh);
                }
                return ResDTO.response(ResEnum.THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqQuanHeGiaDinh cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                QuanHeGiaDinh quanHeGiaDinh = null;
                if (taiKhoan != null) {
                    quanHeGiaDinh = mapToQuanHeGiaDinh(1, taiKhoan.getSoYeuLyLich(), cu);
                    quanHeGiaDinh.setId(id);
                    quanHeGiaDinh.setUpdate_at();
                    quanHeGiaDinhRepository.save(quanHeGiaDinh);
                }
                return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, quanHeGiaDinh != null ? mapToResQuanHeGiaDinh(quanHeGiaDinh) : null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                QuanHeGiaDinh quanHeGiaDinh = null;
                if (taiKhoan != null) {
                    quanHeGiaDinh = taiKhoan.getSoYeuLyLich().getQuanHeGiaDinhs().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    quanHeGiaDinhRepository.delete(quanHeGiaDinh);
                }
                return ResDTO.response(ResEnum.XOA_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemDanhSach(String id) {
            try {
                List<ResQuanHeGiaDinh> resQuanHeGiaDinhs =
                        quanHeGiaDinhRepository.listQuanHeGiaDinh(UUID.fromString(id)).stream().map(
                                this::mapToResQuanHeGiaDinh
                        ).toList();
                return ResDTO.response(ResEnum.THANH_CONG, resQuanHeGiaDinhs);
            } catch (IllegalArgumentException e) {
                return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class QuaTrinhCongTacService extends ISoYeuLyLichChiTietServices.IQuaTrinhCongTacSefvice {
        private ResQuaTrinhCongTac mapToResQuaTrinhCongTac(QuaTrinhCongTac tac) {
            return new ResQuaTrinhCongTac(
                    tac.getId(),
                    tac.getBatDau(),
                    tac.getKetThuc(),
                    tac.getDonViCongTac(),
                    tac.getChucDanh(),
                    tac.getCreate_at(),
                    tac.getUpdate_at()
            );
        }

        private QuaTrinhCongTac mapToQuaTrinhCongTac(int check, SoYeuLyLich syll, ReqQuaTrinhCongTac cu) {
            return check == 1 ? QuaTrinhCongTac.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .donViCongTac(cu.donViCongTac())
                    .chucDanh(cu.chucDanh())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .build() :
                    new QuaTrinhCongTac(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.donViCongTac(),
                            cu.chucDanh(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResQuaTrinhCongTac> quaTrinhCongTacs = new ArrayList<>();
                if (taiKhoan != null) {
                    quaTrinhCongTacs = taiKhoan.getSoYeuLyLich().getQuaTrinhCongTacs().stream().map(
                            this::mapToResQuaTrinhCongTac
                    ).toList();
                }
                return ResDTO.response(ResEnum.THANH_CONG, quaTrinhCongTacs);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResQuaTrinhCongTac quaTrinhCongTac = null;
                if (taiKhoan != null) {
                    quaTrinhCongTac = taiKhoan.getSoYeuLyLich().getQuaTrinhCongTacs().stream().map(
                            this::mapToResQuaTrinhCongTac
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return ResDTO.response(ResEnum.THANH_CONG, quaTrinhCongTac);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqQuaTrinhCongTac cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                QuaTrinhCongTac quaTrinhCongTac = null;
                if (taiKhoan != null) {
                    quaTrinhCongTac = mapToQuaTrinhCongTac(-1, taiKhoan.getSoYeuLyLich(), cu);
                    quaTrinhCongTacRepository.save(quaTrinhCongTac);
                }
                return ResDTO.response(ResEnum.THANH_CONG, quaTrinhCongTac);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqQuaTrinhCongTac cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                QuaTrinhCongTac quaTrinhCongTac = null;
                if (taiKhoan != null) {
                    quaTrinhCongTac = mapToQuaTrinhCongTac(1, taiKhoan.getSoYeuLyLich(), cu);
                    quaTrinhCongTac.setId(id);
                    quaTrinhCongTac.setUpdate_at();
                    quaTrinhCongTacRepository.save(quaTrinhCongTac);
                }
                return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, quaTrinhCongTac != null ? mapToResQuaTrinhCongTac(quaTrinhCongTac) : null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                QuaTrinhCongTac quaTrinhCongTac = null;
                if (taiKhoan != null) {
                    quaTrinhCongTac = taiKhoan.getSoYeuLyLich().getQuaTrinhCongTacs().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    quaTrinhCongTacRepository.delete(quaTrinhCongTac);
                }
                return ResDTO.response(ResEnum.XOA_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemDanhSach(String id) {
            try {
                List<ResQuaTrinhCongTac> resQuaTrinhCongTacs =
                        quaTrinhCongTacRepository.listQuaTrinhCongTac(UUID.fromString(id)).stream().map(
                                this::mapToResQuaTrinhCongTac
                        ).toList();
                return ResDTO.response(ResEnum.THANH_CONG, resQuaTrinhCongTacs);
            } catch (IllegalArgumentException e) {
                return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class TinHocService extends ISoYeuLyLichChiTietServices.ITinHocSefvice {
        private ResTinHoc mapToResTinHoc(TinHoc hoc) {
            return new ResTinHoc(
                    hoc.getId(),
                    hoc.getBatDau(),
                    hoc.getKetThuc(),
                    hoc.getTenCoSoDaoTao(),
                    hoc.getChungChiDuocCap(),
                    hoc.getCreate_at(),
                    hoc.getUpdate_at()
            );
        }

        private TinHoc mapToTinHoc(int check, SoYeuLyLich syll, ReqTinHoc cu) {
            return check == 1 ? TinHoc.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .tenCoSoDaoTao(cu.tenCoSoDaoTao())
                    .chungChiDuocCap(cu.chungChiDuocCap())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .build() :
                    new TinHoc(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.tenCoSoDaoTao(),
                            cu.chungChiDuocCap(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResTinHoc> tinHocs = new ArrayList<>();
                if (taiKhoan != null) {
                    tinHocs = taiKhoan.getSoYeuLyLich().getTinHocs().stream().map(
                            this::mapToResTinHoc
                    ).toList();
                }
                return ResDTO.response(ResEnum.THANH_CONG, tinHocs);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResTinHoc tinHoc = null;
                if (taiKhoan != null) {
                    tinHoc = taiKhoan.getSoYeuLyLich().getTinHocs().stream().map(
                            this::mapToResTinHoc
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return ResDTO.response(ResEnum.THANH_CONG, tinHoc);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqTinHoc cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                TinHoc tinHoc = null;
                if (taiKhoan != null) {
                    tinHoc = mapToTinHoc(-1, taiKhoan.getSoYeuLyLich(), cu);
                    tinHocRepository.save(tinHoc);
                }
                return ResDTO.response(ResEnum.THANH_CONG, tinHoc);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqTinHoc cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                TinHoc tinHoc = null;
                if (taiKhoan != null) {
                    tinHoc = mapToTinHoc(1, taiKhoan.getSoYeuLyLich(), cu);
                    tinHoc.setId(id);
                    tinHoc.setUpdate_at();
                    tinHocRepository.save(tinHoc);
                }
                return ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, tinHoc != null ? mapToResTinHoc(tinHoc) : null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                TinHoc tinHoc = null;
                if (taiKhoan != null) {
                    tinHoc = taiKhoan.getSoYeuLyLich().getTinHocs().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    tinHocRepository.delete(tinHoc);
                }
                return ResDTO.response(ResEnum.XOA_THANH_CONG, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemDanhSach(String id) {
            try {
                List<ResTinHoc> resTinHocs =
                        tinHocRepository.listTinHoc(UUID.fromString(id)).stream().map(
                                this::mapToResTinHoc
                        ).toList();
                return ResDTO.response(ResEnum.THANH_CONG, resTinHocs);
            } catch (IllegalArgumentException e) {
                return ResDTO.response(ResEnum.HONG_TIM_THAY, "");
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }
}
