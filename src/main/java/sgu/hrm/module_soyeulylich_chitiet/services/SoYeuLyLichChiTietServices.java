package sgu.hrm.module_soyeulylich_chitiet.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;

import sgu.hrm.module_security.IAuthenticationFacade;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
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
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNgoaiNguNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuaTrinhCongTacNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKhenThuongNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKyLuatNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLamViecONuocNgoaiNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLyLuanChinhTriNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNghiepVuChuyenNganhNhanVien;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqTinHoc;
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

import sgu.hrm.module_utilities.enums.XacNhan;
import sgu.hrm.module_utilities.models.CoQuanToChucDonVi;
//import sgu.hrm.module_utilities.models.DonVi;
import sgu.hrm.module_utilities.models.HinhThucKhenThuong;
import sgu.hrm.module_utilities.models.LoaiPhuCap;
import sgu.hrm.module_utilities.models.MoiQuanHe;
import sgu.hrm.module_utilities.repositories.CoQuanToChucDonViRepository;
//import sgu.hrm.module_utilities.repositories.DonViRepository;
import sgu.hrm.module_utilities.repositories.HinhThucKhenThuongRepository;
import sgu.hrm.module_utilities.repositories.LoaiPhuCapRepository;
import sgu.hrm.module_utilities.repositories.MoiQuanHeRepository;

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
    final CoQuanToChucDonViRepository coQuanToChucDonViRepository;
    //    final DonViRepository donViRepository;
    final MoiQuanHeRepository moiQuanHeRepository;
    final LoaiPhuCapRepository loaiPhuCapRepository;
    final IAuthenticationFacade facadeEmployee; //lay thong tin employee hien tai

    private SoYeuLyLich syll() {
        return facadeEmployee.getSoYeuLyLich();
    }

    @Service
    public class BanThanCoLamViecChoCheDoCuService extends ISoYeuLyLichChiTietServices.IBanThanCoLamViecChoCheDoCuSefvice {
        @Override
        public List<BanThanCoLamViecChoCheDoCu> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<BanThanCoLamViecChoCheDoCu> resCu = new ArrayList<>();
            try {
                if (syll != null) {
                    resCu = banThanCoLamViecChoCheDoCuRepository.getAllBySyll(syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return resCu;
        }

        @Override
        public BanThanCoLamViecChoCheDoCu xemThongTin(int id) {
            BanThanCoLamViecChoCheDoCu cu = null;
            SoYeuLyLich syll = syll();
            try {
//                if (syll != null) {
//                    cu = banThanCoLamViecChoCheDoCuRepository.findByIdAndSyll(id, syll.getId());
                return banThanCoLamViecChoCheDoCuRepository.findById(id).filter(c ->
                        c.getSoYeuLyLich().getId().equals(syll.getId())
                ).orElse(null);
//                }
//                return cu;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public BanThanCoLamViecChoCheDoCu themThongTin(ReqBanThanCoLamViecChoCheDoCu req) {
            SoYeuLyLich syll = syll();
            try {
                return banThanCoLamViecChoCheDoCuRepository.save(new BanThanCoLamViecChoCheDoCu(req.batDau(), req.ketThuc(), req.chucDanhDonViDiaDiem(), syll));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public BanThanCoLamViecChoCheDoCu suaThongTin(int id, ReqBanThanCoLamViecChoCheDoCu req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    return banThanCoLamViecChoCheDoCuRepository.findById(id).map(c -> {
                        if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                            c.setBatDau(req.batDau() != null ? req.batDau() : c.getBatDau());
                            c.setKetThuc(req.ketThuc() != null ? req.ketThuc() : c.getKetThuc());
                            c.setChucDanhDonViDiaDiem(req.chucDanhDonViDiaDiem() != null ? req.chucDanhDonViDiaDiem() : c.getChucDanhDonViDiaDiem());
                            c.setUpdate_at();
                            return banThanCoLamViecChoCheDoCuRepository.save(c);
                        } else return null;
                    }).orElse(null);
//                    banThanCoLamViecChoCheDoCuRepository.updateByIdAndSyll(req.batDau(), req.ketThuc(), req.chucDanhDonViDiaDiem(), id, syll.getId());
                }
                return null;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<BanThanCoLamViecChoCheDoCu> suaDanhSachThongTin(List<ReqBanThanCoLamViecChoCheDoCu> listReq) {
            SoYeuLyLich syll = syll();
            List<BanThanCoLamViecChoCheDoCu> cus = new ArrayList<>();
            try {
                if (syll != null) {
                    cus = listReq.stream().map(c -> {
                        BanThanCoLamViecChoCheDoCu cu = xemThongTin(c.id());
                        if (cu != null) {
                            cu.setBatDau(c.batDau());
                            cu.setKetThuc(c.ketThuc());
                            cu.setChucDanhDonViDiaDiem(c.chucDanhDonViDiaDiem());
                            cu.setUpdate_at();
                        } else {
                            cu = new BanThanCoLamViecChoCheDoCu(c.batDau(), c.ketThuc(), c.chucDanhDonViDiaDiem(), syll);
                        }
                        return cu;
                    }).toList();
                }
                return banThanCoLamViecChoCheDoCuRepository.saveAll(cus);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    BanThanCoLamViecChoCheDoCu cu = banThanCoLamViecChoCheDoCuRepository.findByIdAndSyll(id, syll.getId());
//                    if (cu != null) {
//                        banThanCoLamViecChoCheDoCuRepository.delete(cu);
//                        return true;
//                    }
                    return banThanCoLamViecChoCheDoCuRepository.findById(id).map(c -> {
                        if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                            banThanCoLamViecChoCheDoCuRepository.deleteById(id);
                            return true;
                        }
                        return false;
                    }).orElse(false);
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<BanThanCoLamViecChoCheDoCu> xemDanhSach(String id) {
            try {
//                List<ResBanThanCoLamViecChoCheDoCu> banThanCoLamViecChoCheDoCus =
//                        banThanCoLamViecChoCheDoCuRepository.listBanThanCoLamViecChoCheDoCu(UUID.fromString(id)).stream().map(
//                                this::mapToResBanThanCoLamViecChoCheDoCu
//                        ).toList();
//                return ResDTO.response(ResEnum.THANH_CONG, banThanCoLamViecChoCheDoCus);
                return banThanCoLamViecChoCheDoCuRepository.listBanThanCoLamViecChoCheDoCu(UUID.fromString(id));
            } catch (IllegalArgumentException e) {
                return new ArrayList<>();
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<BanThanCoLamViecChoCheDoCu> xemDanhSachEmployee() {
            return banThanCoLamViecChoCheDoCuRepository.findAll();
        }
    }

    @Service
    public class KhenThuongService extends ISoYeuLyLichChiTietServices.IKhenThuongSefvice {
        private KhenThuong mapToKhenThuong(ReqKhenThuong cu) {
            return new KhenThuong(
                    cu.nam(),
                    cu.xepLoaiChuyenMon(),
                    cu.xepLoaiThiDua(),
                    hinhThucKhenThuongRepository.findById(cu.hinhThucKhenThuong()).orElse(null),
                    cu.lyDo(),
                    syll());
        }

        @Override
        public List<KhenThuong> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<KhenThuong> resKhen = new ArrayList<>();
            try {
                if (syll != null) {
                    resKhen = khenThuongRepository.getAllBySyll(syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return resKhen;
        }

        @Override
        public KhenThuong xemThongTin(int id) {
            KhenThuong khen = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    khen = khenThuongRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
                return khen;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public KhenThuong themThongTin(ReqKhenThuong req) {
            KhenThuong khen;
            try {
                khen = mapToKhenThuong(req);
                khen.setXacNhan(XacNhan.CHO_XAC_NHAN);
                return khenThuongRepository.save(khen);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public KhenThuong suaThongTin(int id, ReqKhenThuong req) {
            SoYeuLyLich syll = syll();
            try {
//                if (syll != null) {
//                    khenThuongRepository.updateByIdAndSyll(req.nam(), req.xepLoaiChuyenMon(), req.xepLoaiThiDua(), hinhThucKhenThuongRepository.findById(req.hinhThucKhenThuong()).orElse(null), req.lyDo(), id, syll.getId());
//                }
                return khenThuongRepository.findById(id).map(c -> {
                    if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                        c.setNam(req.nam());
                        c.setXepLoaiChuyenMon(req.xepLoaiChuyenMon());
                        c.setXepLoaiThiDua(req.xepLoaiThiDua());
                        c.setHinhThucKhenThuong(hinhThucKhenThuongRepository.findById(req.hinhThucKhenThuong()).orElse(null));
                        c.setLyDo(req.lyDo());
                        c.setUpdate_at();
                        return khenThuongRepository.save(c);
                    } else return null;
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    KhenThuong khen = khenThuongRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (khen != null) {
                        khenThuongRepository.delete(khen);
                        return true;
                    }
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<KhenThuong> xemDanhSach(String id) {
            try {
                return khenThuongRepository.listKhenThuong(UUID.fromString(id));
            } catch (IllegalArgumentException e) {
                return new ArrayList<>();
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<KhenThuong> xemDanhSachEmployee() {
            return khenThuongRepository.findAll();
        }

        @Override
        public List<KhenThuong> khenThuongNhanVien(List<ReqKhenThuongNhanVien> vien) {
            try {
                List<KhenThuong> khenThuongs = vien.stream().flatMap(
                        reqNV -> reqNV.danhSachMaHoSo().stream().map(
                                nvId -> {
                                    ReqKhenThuong req = reqNV.khenThuong();
                                    HinhThucKhenThuong hinhThuc = hinhThucKhenThuongRepository.findById(req.hinhThucKhenThuong()).orElse(null);
                                    SoYeuLyLich syll = soYeuLyLichRepository.findById(nvId).orElseThrow();
                                    return new KhenThuong(req.nam(), req.xepLoaiChuyenMon(), req.xepLoaiThiDua(), hinhThuc, "", syll);
                                }
                        )).toList();
                return khenThuongRepository.saveAll(khenThuongs);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class KienThucAnNinhQuocPhongService extends ISoYeuLyLichChiTietServices.IKienThucAnNinhQuocPhongSefvice {
        @Override
        public List<KienThucAnNinhQuocPhong> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            try {
                return kienThucAnNinhQuocPhongRepository.getAllBySoYeuLyLich(syll);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public KienThucAnNinhQuocPhong xemThongTin(int id) {
            KienThucAnNinhQuocPhong kien = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    kien = kienThucAnNinhQuocPhongRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
                return kien;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public KienThucAnNinhQuocPhong themThongTin(ReqKienThucAnNinhQuocPhong req) {
            try {
                CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.tenCoSoDaoTao()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                KienThucAnNinhQuocPhong kien = new KienThucAnNinhQuocPhong(req.batDau(), req.ketThuc(), donVi, req.chungChiDuocCap(), syll());
                kien.setXacNhan(XacNhan.CHO_XAC_NHAN);
                return kienThucAnNinhQuocPhongRepository.save(kien);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public KienThucAnNinhQuocPhong suaThongTin(int id, ReqKienThucAnNinhQuocPhong req) {
            SoYeuLyLich syll = syll();
            try {
                return kienThucAnNinhQuocPhongRepository.findById(id).map(c -> {
                    if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                        CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.tenCoSoDaoTao()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setTenCoSoDaoTao(donVi);
                        c.setChungChiDuocCap(req.chungChiDuocCap());
                        c.setUpdate_at();
                        return kienThucAnNinhQuocPhongRepository.save(c);
                    } else return null;
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    KienThucAnNinhQuocPhong kien = kienThucAnNinhQuocPhongRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (kien != null) {
                        kienThucAnNinhQuocPhongRepository.delete(kien);
                        return true;
                    }
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<KienThucAnNinhQuocPhong> xemDanhSach(String id) {
            try {
                return kienThucAnNinhQuocPhongRepository.listKienThucAnNinhQuocPhong(UUID.fromString(id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<KienThucAnNinhQuocPhong> xemDanhSachEmployee() {
            return kienThucAnNinhQuocPhongRepository.findAll();
        }
    }

    @Service
    public class KyLuatService extends ISoYeuLyLichChiTietServices.IKyLuatSefvice {
        @Override
        public List<KyLuat> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<KyLuat> resKy = new ArrayList<>();
            try {
                if (syll != null) {
                    resKy = kyLuatRepository.getAllBySyll(syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return resKy;
        }

        @Override
        public KyLuat xemThongTin(int id) {
            KyLuat ky = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    ky = kyLuatRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
                return ky;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public KyLuat themThongTin(ReqKyLuat req) {
            try {
                CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.coQuanQuyetDinh()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                KyLuat kyLuat = new KyLuat(req.batDau(), req.ketThuc(), req.hinhThuc(), req.hanhViViPhamChinh(), donVi, syll());
                kyLuat.setXacNhan(XacNhan.CHO_XAC_NHAN);
                return kyLuatRepository.save(kyLuat);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public KyLuat suaThongTin(int id, ReqKyLuat req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    return kyLuatRepository.findById(id).map(c -> {
                        if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                            CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.coQuanQuyetDinh()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                            c.setBatDau(req.batDau());
                            c.setKetThuc(req.ketThuc());
                            c.setHinhThuc(req.hinhThuc());
                            c.setHanhViViPhamChinh(req.hanhViViPhamChinh());
                            c.setCoQuanQuyetDinh(donVi);
                            c.setUpdate_at();
                            return kyLuatRepository.save(c);
                        } else return null;
                    }).orElse(null);
                }
                return null;
            } catch (RuntimeException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }

        @Override
        public boolean xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    KyLuat ky = kyLuatRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (ky != null) {
                        kyLuatRepository.delete(ky);
                        return true;
                    }
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<KyLuat> xemDanhSach(String id) {
            try {
                return kyLuatRepository.listKyLuat(UUID.fromString(id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<KyLuat> xemDanhSachEmployee() {
            try {
                return kyLuatRepository.findAll();
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<KyLuat> kyLuatNhanVien(List<ReqKyLuatNhanVien> ky) {
            try {
                List<KyLuat> kyLuats = ky.stream().flatMap(
                        reqNV -> reqNV.danhSachMaHoSo().stream().map(
                                nvId -> {
                                    ReqKyLuat req = reqNV.kyLuat();
                                    CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.coQuanQuyetDinh()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                                    SoYeuLyLich syll = soYeuLyLichRepository.findById(nvId).orElseThrow();
                                    return new KyLuat(req.batDau(), req.ketThuc(), req.hinhThuc(), req.hanhViViPhamChinh(), donVi, syll);
                                }
                        )).toList();
                return kyLuatRepository.saveAll(kyLuats);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class LamViecONuocNgoaiServcie extends ISoYeuLyLichChiTietServices.ILamViecONuocNgoaiSefvice {
        private LamViecONuocNgoai mapToLamViecONuocNgoai(ReqLamViecONuocNgoai cu) {
            return new LamViecONuocNgoai(
                    cu.batDau(),
                    cu.ketThuc(),
                    cu.toChucDiaChiCongViec(),
                    syll());
        }

        @Override
        public List<LamViecONuocNgoai> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<LamViecONuocNgoai> resNgoai = new ArrayList<>();
            try {
                if (syll != null) {
                    resNgoai = lamViecONuocNgoaiRepository.getAllBySyll(syll.getId());
                }
                return resNgoai;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LamViecONuocNgoai xemThongTin(int id) {
            LamViecONuocNgoai ngoai = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    ngoai = lamViecONuocNgoaiRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
                return ngoai;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LamViecONuocNgoai themThongTin(ReqLamViecONuocNgoai req) {
            LamViecONuocNgoai ngoai;
            try {
                ngoai = mapToLamViecONuocNgoai(req);
                return lamViecONuocNgoaiRepository.save(ngoai);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LamViecONuocNgoai suaThongTin(int id, ReqLamViecONuocNgoai req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    return lamViecONuocNgoaiRepository.findById(id).map(c -> {
                        if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                            c.setBatDau(req.batDau());
                            c.setKetThuc(req.ketThuc());
                            c.setToChucDiaChiCongViec(req.toChucDiaChiCongViec());
                            c.setUpdate_at();
                            return lamViecONuocNgoaiRepository.save(c);
                        } else return null;
                    }).orElse(null);
                }
                return null;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    LamViecONuocNgoai ngoai = lamViecONuocNgoaiRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (ngoai != null) {
                        lamViecONuocNgoaiRepository.delete(ngoai);
                        return true;
                    }
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<LamViecONuocNgoai> xemDanhSach(String id) {
            try {
                return lamViecONuocNgoaiRepository.listLamViecONuocNgoai(UUID.fromString(id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<LamViecONuocNgoai> xemDanhSachEmployee() {
            return lamViecONuocNgoaiRepository.findAll();
        }

        @Override
        public List<LamViecONuocNgoai> lamViecONUocNgoaiNhanVien(List<ReqLamViecONuocNgoaiNhanVien> vien) {
            List<LamViecONuocNgoai> lamViecONuocNgoais = vien.stream().flatMap(
                    reqNV -> reqNV.danhSachMaHoSo().stream().map(
                            nvId -> {
                                ReqLamViecONuocNgoai req = reqNV.lamViecONuocNgoai();
                                SoYeuLyLich syll = soYeuLyLichRepository.findById(nvId).orElseThrow();
                                return new LamViecONuocNgoai(req.batDau(), req.ketThuc(), req.toChucDiaChiCongViec(), syll);
                            }
                    )).toList();
            return lamViecONuocNgoaiRepository.saveAll(lamViecONuocNgoais);
        }
    }

    @Service
    public class LuongBanThanService extends ISoYeuLyLichChiTietServices.ILuongBanThanSefvice {
        private LuongBanThan mapToLuongBanThan(ReqLuongBanThan cu) {
            return new LuongBanThan(
                    cu.batDau(),
                    cu.ketThuc(),
                    cu.maSo(),
                    cu.bacLuong(),
                    cu.heSoLuong(),
                    cu.tienLuongTheoViTri(),
                    syll());
        }

        @Override
        public List<LuongBanThan> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<LuongBanThan> resNgoai = new ArrayList<>();
            try {
                if (syll != null) {
                    resNgoai = luongBanThanRepository.getAllBySyll(syll.getId());
                }
                return resNgoai;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LuongBanThan xemThongTin(int id) {
            LuongBanThan luong = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    luong = luongBanThanRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
                return luong;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LuongBanThan themThongTin(ReqLuongBanThan req) {
            LuongBanThan luong;
            try {
                luong = mapToLuongBanThan(req);
                return luongBanThanRepository.save(luong);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LuongBanThan suaThongTin(int id, ReqLuongBanThan req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    return luongBanThanRepository.findById(id).map(c -> {
                        if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                            c.setBatDau(req.batDau());
                            c.setKetThuc(req.ketThuc());
                            c.setMaSo(req.maSo());
                            c.setBacLuong(req.bacLuong());
                            c.setHeSoLuong(req.heSoLuong());
                            c.setTienLuongTheoViTri(req.tienLuongTheoViTri());
                            c.setUpdate_at();
                            return luongBanThanRepository.save(c);
                        } else return null;
                    }).orElse(null);
                }
                return null;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    LuongBanThan luong = luongBanThanRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (luong != null) {
                        luongBanThanRepository.delete(luong);
                        return true;
                    }
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<LuongBanThan> xemDanhSach(String id) {
            try {
                return luongBanThanRepository.listLuongBanThan(UUID.fromString(id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<LuongBanThan> xemDanhSachEmployee() {
            return luongBanThanRepository.findAll();
        }
    }

    @Service
    public class LyLuanChinhTriService extends ISoYeuLyLichChiTietServices.ILyLuanChinhTriSefvice {
        @Override
        public List<LyLuanChinhTri> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<LyLuanChinhTri> resTri = new ArrayList<>();
            try {
                if (syll != null) {
                    resTri = lyLuanChinhTriRepository.getAllBySyll(syll.getId());
                }
                return resTri;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LyLuanChinhTri xemThongTin(int id) {
            LyLuanChinhTri tri = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    tri = lyLuanChinhTriRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
                return tri;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LyLuanChinhTri themThongTin(ReqLyLuanChinhTri req) {
            try {
                CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.tenCoSoDaoTao()).orElse(null);
                LyLuanChinhTri tri = new LyLuanChinhTri(req.batDau(), req.ketThuc(), donVi, req.hinhThucDaoTao(), req.vanBangDuocCap(), syll());
                tri.setXacNhan(XacNhan.CHO_XAC_NHAN);
                return lyLuanChinhTriRepository.save(tri);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LyLuanChinhTri suaThongTin(int id, ReqLyLuanChinhTri req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    return lyLuanChinhTriRepository.findById(id).map(c -> {
                        if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                            CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.tenCoSoDaoTao()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                            c.setBatDau(req.batDau());
                            c.setKetThuc(req.ketThuc());
                            c.setTenCoSoDaoTao(donVi);
                            c.setHinhThucDaoTao(req.hinhThucDaoTao());
                            c.setVanBangDuocCap(req.vanBangDuocCap());
                            c.setUpdate_at();
                            return lyLuanChinhTriRepository.save(c);
                        } else return null;
                    }).orElse(null);
                }
                return null;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    LyLuanChinhTri tri = lyLuanChinhTriRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (tri != null) {
                        lyLuanChinhTriRepository.delete(tri);
                        return true;
                    }
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<LyLuanChinhTri> xemDanhSach(String id) {
            try {
                return lyLuanChinhTriRepository.listLyLuanChinhTri(UUID.fromString(id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<LyLuanChinhTri> xemDanhSachEmployee() {
            return lyLuanChinhTriRepository.findAll();
        }

        @Override
        public List<LyLuanChinhTri> lyLuanChinhTriNhanVien(List<ReqLyLuanChinhTriNhanVien> ly) {
            List<LyLuanChinhTri> lyLuanChinhTris = ly.stream().flatMap(
                    reqNV -> reqNV.danhSachMaHoSo().stream().map(
                            nvId -> {
                                ReqLyLuanChinhTri req = reqNV.lyLuanChinhTri();
                                SoYeuLyLich syll = soYeuLyLichRepository.findById(nvId).orElseThrow();
                                CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.tenCoSoDaoTao()).orElse(null);
                                return new LyLuanChinhTri(req.batDau(), req.ketThuc(), donVi,
                                        req.hinhThucDaoTao(), req.vanBangDuocCap(), syll);
                            }
                    )).toList();
            return lyLuanChinhTriRepository.saveAll(lyLuanChinhTris);
        }
    }

    @Service
    public class NghiepVuChuyenNganhService extends ISoYeuLyLichChiTietServices.INghiepVuChuyenNganhSefvice {
        @Override
        public List<NghiepVuChuyenNganh> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<NghiepVuChuyenNganh> resVu = new ArrayList<>();
            try {
                if (syll != null) {
                    resVu = nghiepVuChuyenNganhRepository.getAllBySyll(syll.getId());
                }
                return resVu;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public NghiepVuChuyenNganh xemThongTin(int id) {
            NghiepVuChuyenNganh vu = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    vu = nghiepVuChuyenNganhRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
                return vu;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public NghiepVuChuyenNganh themThongTin(ReqNghiepVuChuyenNganh req) {
            try {
                CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.tenCoSoDaoTao()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                NghiepVuChuyenNganh vu = new NghiepVuChuyenNganh(req.batDau(), req.ketThuc(), donVi, req.chungChiDuocCap(), syll());
                vu.setXacNhan(XacNhan.CHO_XAC_NHAN);
                return nghiepVuChuyenNganhRepository.save(vu);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public NghiepVuChuyenNganh suaThongTin(int id, ReqNghiepVuChuyenNganh req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    return nghiepVuChuyenNganhRepository.findById(id).map(c -> {
                        if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                            CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.tenCoSoDaoTao()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                            c.setBatDau(req.batDau());
                            c.setKetThuc(req.ketThuc());
                            c.setTenCoSoDaoTao(donVi);
                            c.setChungChiDuocCap(req.chungChiDuocCap());
                            c.setUpdate_at();
                            return nghiepVuChuyenNganhRepository.save(c);
                        } else return null;
                    }).orElse(null);
                }
                return null;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    NghiepVuChuyenNganh vu = nghiepVuChuyenNganhRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (vu != null) {
                        nghiepVuChuyenNganhRepository.delete(vu);
                        return true;
                    }
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<NghiepVuChuyenNganh> xemDanhSach(String id) {
            try {
                return nghiepVuChuyenNganhRepository.listNghiepVuChuyenNganh(UUID.fromString(id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<NghiepVuChuyenNganh> xemDanhSachEmployee() {
            return nghiepVuChuyenNganhRepository.findAll();
        }

        @Override
        public List<NghiepVuChuyenNganh> nghiepVuChuyenNganhNhanVien(List<ReqNghiepVuChuyenNganhNhanVien> nghiep) {
            List<NghiepVuChuyenNganh> nghiepVuChuyenNganhs = nghiep.stream().flatMap(
                    reqNV -> reqNV.danhSachMaHoSo().stream().map(
                            nvId -> {
                                ReqNghiepVuChuyenNganh req = reqNV.nghiepVuChuyenNganh();
                                SoYeuLyLich syll = soYeuLyLichRepository.findById(nvId).orElseThrow();
                                CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.tenCoSoDaoTao()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                                return new NghiepVuChuyenNganh(req.batDau(), req.ketThuc(), donVi, req.chungChiDuocCap(), syll);
                            }
                    )).toList();
            return nghiepVuChuyenNganhRepository.saveAll(nghiepVuChuyenNganhs);
        }
    }

    @Service
    public class NgoaiNguService extends ISoYeuLyLichChiTietServices.INgoaiNguSefvice {
        @Override
        public List<NgoaiNgu> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<NgoaiNgu> resNgu = new ArrayList<>();
            try {
                if (syll != null) {
                    resNgu = ngoaiNguRepository.getAllBySyll(syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return resNgu;
        }

        @Override
        public NgoaiNgu xemThongTin(int id) {
            NgoaiNgu ngu = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    ngu = ngoaiNguRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
                return ngu;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public NgoaiNgu themThongTin(ReqNgoaiNgu req) {
            try {
                CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.tenCoSoDaoTao()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                NgoaiNgu ngu = new NgoaiNgu(req.batDau(), req.ketThuc(), donVi, req.tenNgoaiNgu(), req.chungChiDuocCap(), req.diemSo(), syll());
                ngu.setXacNhan(XacNhan.CHO_XAC_NHAN);
                return ngoaiNguRepository.save(ngu);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public NgoaiNgu suaThongTin(int id, ReqNgoaiNgu req) {
            SoYeuLyLich syll = syll();
            try {
                return ngoaiNguRepository.findById(id).map(c -> {
                    if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                        CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.tenCoSoDaoTao()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setTenCoSoDaoTao(donVi);
                        c.setTenNgoaiNgu(req.tenNgoaiNgu());
                        c.setChungChiDuocCap(req.chungChiDuocCap());
                        c.setDiemSo(req.diemSo());
                        c.setUpdate_at();
                        return ngoaiNguRepository.save(c);
                    } else return null;
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    NgoaiNgu ngu = ngoaiNguRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (ngu != null) {
                        ngoaiNguRepository.delete(ngu);
                        return true;
                    }
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<NgoaiNgu> xemDanhSach(String id) {
            try {
                return ngoaiNguRepository.listNgoaiNgu(UUID.fromString(id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<NgoaiNgu> xemDanhSachEmployee() {
            return ngoaiNguRepository.findAll();
        }

        @Override
        public List<NgoaiNgu> ngoaiNguNhanVien(List<ReqNgoaiNguNhanVien> ngu) {
            List<NgoaiNgu> ngoaiNgus = ngu.stream().flatMap(
                    reqNV -> reqNV.danhSachMaHoSo().stream().map(
                            nvId -> {
                                ReqNgoaiNgu req = reqNV.ngoaiNgu();
                                SoYeuLyLich syll = soYeuLyLichRepository.findById(nvId).orElseThrow();
                                CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.tenCoSoDaoTao()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                                return new NgoaiNgu(req.batDau(), req.ketThuc(), donVi, req.tenNgoaiNgu(), req.chungChiDuocCap(), req.diemSo(), syll);
                            }
                    )).toList();
            return ngoaiNguRepository.saveAll(ngoaiNgus);
        }
    }

    @Service
    public class PhuCapKhacService extends ISoYeuLyLichChiTietServices.IPhuCapKhacSefvice {
//        private PhuCapKhac mapToPhuCapKhac(ReqPhuCapKhac cu) {
//            return new PhuCapKhac(
//                    cu.batDau(),
//                    cu.ketThuc(),
//                    cu.loaiPhuCap(),
//                    cu.phanTramHuongPhuCap(),
//                    cu.heSoPhuCap(),
//                    cu.hinhThucThuong(),
//                    cu.giaTri(),
//                    syll());
//        }

        @Override
        public List<PhuCapKhac> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<PhuCapKhac> resCap = new ArrayList<>();
            try {
                if (syll != null) {
                    resCap = phuCapKhacRepository.getAllBySyll(syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return resCap;
        }

        @Override
        public PhuCapKhac xemThongTin(int id) {
            PhuCapKhac cap = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    cap = phuCapKhacRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
                return cap;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public PhuCapKhac themThongTin(ReqPhuCapKhac req) {
//            try {
                LoaiPhuCap loaiPhuCap = loaiPhuCapRepository.findById(req.loaiPhuCap()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
//                mapToPhuCapKhac(req)
                PhuCapKhac cap = new PhuCapKhac(
                        req.batDau(),
                        req.ketThuc(),
                        loaiPhuCap,
                        req.phanTramHuongPhuCap(),
                        req.heSoPhuCap(),
                        req.hinhThucThuong(),
                        req.giaTri(),
                        syll());
                return phuCapKhacRepository.save(cap);
//            } catch (ResponseStatusException e) {
//                throw new RuntimeException(e.getCause());
//            }
        }

        @Override
        public PhuCapKhac suaThongTin(int id, ReqPhuCapKhac req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    return phuCapKhacRepository.findById(id).map(c -> {
                        if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                            LoaiPhuCap loaiPhuCap = loaiPhuCapRepository.findById(req.loaiPhuCap()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                            c.setBatDau(req.batDau());
                            c.setKetThuc(req.ketThuc());
                            c.setLoaiPhuCap(loaiPhuCap);
                            c.setPhanTramHuongPhuCap(req.phanTramHuongPhuCap());
                            c.setHeSoPhuCap(req.heSoPhuCap());
                            c.setHinhThucHuong(req.hinhThucThuong());
                            c.setGiaTri(req.giaTri());
                            c.setUpdate_at();
                            return phuCapKhacRepository.save(c);
                        } else return null;
                    }).orElse(null);
                }
                return null;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    PhuCapKhac ky = phuCapKhacRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (ky != null) {
                        phuCapKhacRepository.delete(ky);
                        return true;
                    }
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<PhuCapKhac> xemDanhSach(String id) {
            try {
                return phuCapKhacRepository.listPhuCapKhac(UUID.fromString(id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<PhuCapKhac> xemDanhSachEmployee() {
            return phuCapKhacRepository.findAll();
        }
    }

    @Service
    public class QuanHeGiaDinhService extends ISoYeuLyLichChiTietServices.IQuanHeGiaDinhSefvice {
        @Override
        public List<QuanHeGiaDinh> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<QuanHeGiaDinh> resDinh = new ArrayList<>();
            try {
                if (syll != null) {
                    resDinh = quanHeGiaDinhRepository.getAllBySyll(syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return resDinh;
        }

        @Override
        public QuanHeGiaDinh xemThongTin(int id) {
            QuanHeGiaDinh dinh = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    dinh = quanHeGiaDinhRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
                return dinh;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public QuanHeGiaDinh themThongTin(ReqQuanHeGiaDinh req) {
            try {
                MoiQuanHe he = moiQuanHeRepository.findById(req.moiQuanHe()).orElse(null);
                QuanHeGiaDinh dinh = new QuanHeGiaDinh(he, req.hoVaTen(), req.namSinh(), req.thongTinThanNhan(), syll());
                return quanHeGiaDinhRepository.save(dinh);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public QuanHeGiaDinh suaThongTin(int id, ReqQuanHeGiaDinh req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    return quanHeGiaDinhRepository.findById(id).map(c -> {
                        if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                            MoiQuanHe he = moiQuanHeRepository.findById(req.moiQuanHe()).orElse(null);
                            c.setMoiQuanHe(he);
                            c.setHoVaTen(req.hoVaTen());
                            c.setNamSinh(req.namSinh());
                            c.setThongTinThanNhan(req.thongTinThanNhan());
                            c.setUpdate_at();
                            return quanHeGiaDinhRepository.save(c);
                        } else return null;
                    }).orElse(null);
                }
                return null;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    QuanHeGiaDinh dinh = quanHeGiaDinhRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (dinh != null) {
                        quanHeGiaDinhRepository.delete(dinh);
                        return true;
                    }
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<QuanHeGiaDinh> xemDanhSach(String id) {
            try {
                return quanHeGiaDinhRepository.listQuanHeGiaDinh(UUID.fromString(id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<QuanHeGiaDinh> xemDanhSachEmployee() {
            return quanHeGiaDinhRepository.findAll();
        }
    }

    @Service
    public class QuaTrinhCongTacService extends ISoYeuLyLichChiTietServices.IQuaTrinhCongTacSefvice {


        @Override
        public List<QuaTrinhCongTac> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<QuaTrinhCongTac> resTac = new ArrayList<>();
            try {
                if (syll != null) {
                    resTac = quaTrinhCongTacRepository.getAllBySyll(syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return resTac;
        }

        @Override
        public QuaTrinhCongTac xemThongTin(int id) {
            QuaTrinhCongTac dinh = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    dinh = quaTrinhCongTacRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
                return dinh;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public QuaTrinhCongTac themThongTin(ReqQuaTrinhCongTac req) {
            try {
                CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.donViCongTac()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
                return quaTrinhCongTacRepository.save(new QuaTrinhCongTac(req.batDau(), req.ketThuc(), donVi, req.chucDanh(), syll()));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public QuaTrinhCongTac suaThongTin(int id, ReqQuaTrinhCongTac req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    return quaTrinhCongTacRepository.findById(id).map(c -> {
                        if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                            CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.donViCongTac()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
                            c.setBatDau(req.batDau());
                            c.setKetThuc(req.ketThuc());
                            c.setDonViCongTac(donVi);
                            c.setChucDanh(req.chucDanh());
                            c.setUpdate_at();
                            return quaTrinhCongTacRepository.save(c);
                        } else return null;
                    }).orElse(null);
                }
                return null;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    QuaTrinhCongTac tac = quaTrinhCongTacRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (tac != null) {
                        quaTrinhCongTacRepository.delete(tac);
                        return true;
                    }
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<QuaTrinhCongTac> xemDanhSach(String id) {
            try {
                return quaTrinhCongTacRepository.listQuaTrinhCongTac(UUID.fromString(id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<QuaTrinhCongTac> xemDanhSachEmployee() {
            return quaTrinhCongTacRepository.findAll();
        }

        @Override
        public List<QuaTrinhCongTac> chuyenCongTacNhanVien(List<ReqQuaTrinhCongTacNhanVien> congtac) {
            List<QuaTrinhCongTac> congTacs = new ArrayList<>();
            try {
                congTacs = congtac.stream().flatMap(
                        reqNV -> reqNV.danhSachMaHoSo().stream().map(
                                nvId -> {
                                    CoQuanToChucDonVi vi = coQuanToChucDonViRepository.findById(reqNV.quaTrinhCongTac().donViCongTac())
                                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found"));
//                                    soYeuLyLichRepository.upadtecoQuanToChucDonVi(vi, nvId);
//                                    return mapToQuaTrinhCongTac(reqNV.quaTrinhCongTac());
                                    return new QuaTrinhCongTac(reqNV.quaTrinhCongTac().batDau(),
                                            reqNV.quaTrinhCongTac().ketThuc(),
                                            vi,
                                            reqNV.quaTrinhCongTac().chucDanh(),
                                            soYeuLyLichRepository.findById(nvId).orElse(null)
                                    );
                                }
                        )).toList();
                return congTacs;
            } catch (RuntimeException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found");
            }
        }
    }

    @Service
    public class TinHocService extends ISoYeuLyLichChiTietServices.ITinHocSefvice {
        @Override
        public List<TinHoc> xemDanhSachThongTin() {
            SoYeuLyLich syll = syll();
            List<TinHoc> resTin = new ArrayList<>();
            try {
                if (syll != null) {
                    resTin = tinHocRepository.getAllBySyll(syll.getId());
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
            return resTin;
        }

        @Override
        public TinHoc xemThongTin(int id) {
            TinHoc tin = null;
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    tin = tinHocRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                }
                return tin;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public TinHoc themThongTin(ReqTinHoc req) {
            try {
                CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.tenCoSoDaoTao()).orElse(null);
                TinHoc tin = new TinHoc(req.batDau(), req.ketThuc(), donVi, req.chungChiDuocCap(), syll());
                return tinHocRepository.save(tin);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public TinHoc suaThongTin(int id, ReqTinHoc req) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    return tinHocRepository.findById(id).map(c -> {
                        if (c.getSoYeuLyLich().getId().equals(syll.getId())) {
                            CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(req.tenCoSoDaoTao()).orElse(null);
                            c.setBatDau(req.batDau());
                            c.setKetThuc(req.ketThuc());
                            c.setTenCoSoDaoTao(donVi);
                            c.setChungChiDuocCap(req.chungChiDuocCap());
                            c.setUpdate_at();
                            return tinHocRepository.save(c);
                        } else return null;
                    }).orElse(null);
                }
                return null;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoaThongTin(int id) {
            SoYeuLyLich syll = syll();
            try {
                if (syll != null) {
                    TinHoc tin = tinHocRepository.findByIdAndSyll(id, syll.getId()).orElse(null);
                    if (tin != null) {
                        tinHocRepository.delete(tin);
                        return true;
                    }
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<TinHoc> xemDanhSach(String id) {
            try {
                return tinHocRepository.listTinHoc(UUID.fromString(id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public List<TinHoc> xemDanhSachEmployee() {
            return tinHocRepository.findAll();
        }
    }
}
