package sgu.hrm.module_utilities.services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;

import sgu.hrm.module_utilities.models.BacLuong;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.CapNhomChucDanhDang;
import sgu.hrm.module_utilities.models.ChucDanhDang;
import sgu.hrm.module_utilities.models.ChucVu;
import sgu.hrm.module_utilities.models.CoQuanToChucDonVi;
import sgu.hrm.module_utilities.models.DanToc;
import sgu.hrm.module_utilities.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.module_utilities.models.DoiTuongChinhSach;
import sgu.hrm.module_utilities.models.GioiTinh;
import sgu.hrm.module_utilities.models.HinhThucKhenThuong;
import sgu.hrm.module_utilities.models.HocHam;
import sgu.hrm.module_utilities.models.LoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.NhomChucDanhDang;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
import sgu.hrm.module_utilities.models.TinhTrangSucKhoe;
import sgu.hrm.module_utilities.models.TonGiao;
import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;
import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;

import sgu.hrm.module_utilities.models.ViTriViecLam;
import sgu.hrm.module_utilities.repositories.BacLuongRepository;
import sgu.hrm.module_utilities.repositories.CapBacLoaiQuanHamQuanDoiRepository;
import sgu.hrm.module_utilities.repositories.CapNhomChucDanhDangRepository;
import sgu.hrm.module_utilities.repositories.ChucDanhDangRepository;
import sgu.hrm.module_utilities.repositories.ChucVuRepository;
import sgu.hrm.module_utilities.repositories.CoQuanToChucDonViRepository;
import sgu.hrm.module_utilities.repositories.DanTocRepository;
import sgu.hrm.module_utilities.repositories.DanhHieuNhaNuocPhongTangRepository;
import sgu.hrm.module_utilities.repositories.DoiTuongChinhSachRepository;
import sgu.hrm.module_utilities.repositories.GioiTinhRepository;
import sgu.hrm.module_utilities.repositories.HinhThucKhenThuongRepository;
import sgu.hrm.module_utilities.repositories.HocHamRepository;
import sgu.hrm.module_utilities.repositories.LoaiQuanHamQuanDoiRepository;
import sgu.hrm.module_utilities.repositories.NhomChucDanhDangRepository;
import sgu.hrm.module_utilities.repositories.NhomMauRepository;
import sgu.hrm.module_utilities.repositories.ThanhPhanGiaDinhRepository;
import sgu.hrm.module_utilities.repositories.TinhTrangSucKhoeRepository;
import sgu.hrm.module_utilities.repositories.TonGiaoRepository;
import sgu.hrm.module_utilities.repositories.TrinhDoChuyenMonRepository;
import sgu.hrm.module_utilities.repositories.TrinhDoGiaoDucPhoThongRepository;
import sgu.hrm.module_utilities.repositories.ViTriViecLamRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // if field is set final or @not null
public class UtilitiesService {
    private final BacLuongRepository bacLuongRepository;
    private final CapBacLoaiQuanHamQuanDoiRepository capBacLoaiQuanHamQuanDoiRepository;
    private final CapNhomChucDanhDangRepository capNhomChucDanhDangRepository;
    private final ChucDanhDangRepository chucDanhDangRepository;
    private final ChucVuRepository chucVuRepository;
    private final CoQuanToChucDonViRepository coQuanToChucDonViRepository;
    private final DanhHieuNhaNuocPhongTangRepository danhHieuNhaNuocPhongTangRepository;
    private final DanTocRepository danTocRepository;
    private final DoiTuongChinhSachRepository doiTuongChinhSachRepository;
    private final GioiTinhRepository gioiTinhRepository;
    private final HinhThucKhenThuongRepository hinhThucKhenThuongRepository;
    private final HocHamRepository hocHamRepository;
    private final LoaiQuanHamQuanDoiRepository loaiQuanHamQuanDoiRepository;
    private final NhomChucDanhDangRepository nhomChucDanhDangRepository;
    private final NhomMauRepository nhomMauRepository;
    private final ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository;
    private final TinhTrangSucKhoeRepository tinhTrangSucKhoeRepository;
    private final TonGiaoRepository tonGiaoRepository;
    private final TrinhDoChuyenMonRepository trinhDoChuyenMonRepository;
    private final TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository;
    private final ViTriViecLamRepository viTriViecLamRepository;


    @Service
    public class BacLuongService implements IUtilitiesService<BacLuong> {
        public ResDTO<List<BacLuong>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    bacLuongRepository.findAll()
            );
        }

        @Override
        public ResDTO<BacLuong> them(String name) {
            BacLuong bacLuong = new BacLuong(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        bacLuongRepository.save(bacLuong)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<BacLuong> sua(BacLuong luong) {
            Optional<BacLuong> bacLuong = bacLuongRepository.findById(luong.getId());
            try {
                if (bacLuong.isPresent()) {
                    luong.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            bacLuongRepository.save(luong));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class CapBacLoaiQuanHamQuanDoiService implements IUtilitiesService<CapBacLoaiQuanHamQuanDoi> {
        @Override
        public ResDTO<List<CapBacLoaiQuanHamQuanDoi>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    capBacLoaiQuanHamQuanDoiRepository.findAll()
            );
        }

        @Override
        public ResDTO<CapBacLoaiQuanHamQuanDoi> themCapBacLoaiQuanHamQuanDoi(String name, String loaiQuanHamName) {
            LoaiQuanHamQuanDoi loaiQuanHamQuanDoi = loaiQuanHamQuanDoiRepository.findByName(loaiQuanHamName);
            CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = new CapBacLoaiQuanHamQuanDoi(name, loaiQuanHamQuanDoi);
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        capBacLoaiQuanHamQuanDoiRepository.save(capBacLoaiQuanHamQuanDoi)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        null
                );
            }
        }

        @Override
        public ResDTO<CapBacLoaiQuanHamQuanDoi> sua(CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi) {
            Optional<CapBacLoaiQuanHamQuanDoi> optional = capBacLoaiQuanHamQuanDoiRepository.findById(capBacLoaiQuanHamQuanDoi.getId());
            try {
                if (optional.isPresent()) {
                    capBacLoaiQuanHamQuanDoi.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            capBacLoaiQuanHamQuanDoiRepository.save(capBacLoaiQuanHamQuanDoi));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class CapNhomChucDanhDangService implements IUtilitiesService<CapNhomChucDanhDang> {
        @Override
        public ResDTO<List<CapNhomChucDanhDang>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    capNhomChucDanhDangRepository.findAll()
            );
        }

        @Override
        public ResDTO<CapNhomChucDanhDang> them(String name) {
            CapNhomChucDanhDang capNhomChucDanhDang = new CapNhomChucDanhDang(name);
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        capNhomChucDanhDangRepository.save(capNhomChucDanhDang)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        null
                );
            }
        }

        @Override
        public ResDTO<CapNhomChucDanhDang> sua(CapNhomChucDanhDang dang) {
            CapNhomChucDanhDang capNhomChucDanhDang = capNhomChucDanhDangRepository.findById(dang.getId()).orElse(null);
            try {
                if (capNhomChucDanhDang != null) {
                    dang.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            capNhomChucDanhDangRepository.save(dang));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class ChucDanhDangService implements IUtilitiesService<ChucDanhDang> {
        @Override
        public ResDTO<List<ChucDanhDang>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    chucDanhDangRepository.findAll()
            );
        }

        @Override
        public ResDTO<ChucDanhDang> them(String name) {
            ChucDanhDang chucDanhDang = new ChucDanhDang(name);
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        chucDanhDangRepository.save(chucDanhDang)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        null
                );
            }
        }

        @Override
        public ResDTO<ChucDanhDang> sua(ChucDanhDang chuc) {
            ChucDanhDang chucDanhDang = chucDanhDangRepository.findById(chuc.getId()).orElse(null);
            try {
                if (chucDanhDang != null) {
                    chuc.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            chucDanhDangRepository.save(chuc));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class ChucVuService implements IUtilitiesService<ChucVu> {
        @Override
        public ResDTO<List<ChucVu>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    chucVuRepository.findAll()
            );
        }

        @Override
        public ResDTO<ChucVu> them(String name) {
            ChucVu vu = new ChucVu(name);
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        chucVuRepository.save(vu)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        null
                );
            }
        }

        @Override
        public ResDTO<ChucVu> sua(ChucVu vu) {
            ChucVu chucVu = chucVuRepository.findById(vu.getId()).orElse(null);
            try {
                if (chucVu != null) {
                    vu.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            chucVuRepository.save(vu));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class CoQuanToChucDonViService implements IUtilitiesService<CoQuanToChucDonVi> {
        @Override
        public ResDTO<List<CoQuanToChucDonVi>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    coQuanToChucDonViRepository.findAll()
            );
        }

        @Override
        public ResDTO<CoQuanToChucDonVi> them(String name) {
            CoQuanToChucDonVi vu = new CoQuanToChucDonVi(name);
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        coQuanToChucDonViRepository.save(vu)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        null
                );
            }
        }

        @Override
        public ResDTO<CoQuanToChucDonVi> sua(CoQuanToChucDonVi vu) {
            CoQuanToChucDonVi co = coQuanToChucDonViRepository.findById(vu.getId()).orElse(null);
            try {
                if (co != null) {
                    vu.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            coQuanToChucDonViRepository.save(vu));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class DanhHieuNhaNuocPhongTangService implements IUtilitiesService<DanhHieuNhaNuocPhongTang> {
        @Override
        public ResDTO<List<DanhHieuNhaNuocPhongTang>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    danhHieuNhaNuocPhongTangRepository.findAll()
            );
        }

        @Override
        public ResDTO<DanhHieuNhaNuocPhongTang> them(String name) {
            DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang = new DanhHieuNhaNuocPhongTang(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        danhHieuNhaNuocPhongTangRepository.save(danhHieuNhaNuocPhongTang)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<DanhHieuNhaNuocPhongTang> sua(DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang) {
            Optional<DanhHieuNhaNuocPhongTang> optional = danhHieuNhaNuocPhongTangRepository.findById(danhHieuNhaNuocPhongTang.getId());
            try {
                if (optional.isPresent()) {
                    danhHieuNhaNuocPhongTang.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            danhHieuNhaNuocPhongTangRepository.save(danhHieuNhaNuocPhongTang));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class DanTocService implements IUtilitiesService<DanToc> {
        @Override
        public ResDTO<List<DanToc>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    danTocRepository.findAll()
            );
        }

        @Override
        public ResDTO<DanToc> them(String name) {
            DanToc danToc = new DanToc();
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        danTocRepository.save(danToc)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<DanToc> sua(DanToc toc) {
            Optional<DanToc> danToc = danTocRepository.findById(toc.getId());
            try {
                if (danToc.isPresent()) {
                    toc.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            danTocRepository.save(toc));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class DoiTuongChinhSachService implements IUtilitiesService<DoiTuongChinhSach> {
        @Override
        public ResDTO<List<DoiTuongChinhSach>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    doiTuongChinhSachRepository.findAll()
            );
        }

        @Override
        public ResDTO<DoiTuongChinhSach> them(String name) {
            DoiTuongChinhSach doiTuongChinhSach = new DoiTuongChinhSach(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        doiTuongChinhSachRepository.save(doiTuongChinhSach)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<DoiTuongChinhSach> sua(DoiTuongChinhSach doiTuongChinhSach) {
            Optional<DoiTuongChinhSach> optional = doiTuongChinhSachRepository.findById(doiTuongChinhSach.getId());
            try {
                if (optional.isPresent()) {
                    doiTuongChinhSach.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            doiTuongChinhSachRepository.save(doiTuongChinhSach));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class GioiTinhService implements IUtilitiesService<GioiTinh> {
        @Override
        public ResDTO<List<GioiTinh>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    gioiTinhRepository.findAll()
            );
        }

        @Override
        public ResDTO<?> them(String name) {
            return null;
        }

        @Override
        public ResDTO<?> sua(GioiTinh object) {
            return null;
        }
    }

    @Service
    public class HinhThucKhenThuongService implements IUtilitiesService<HinhThucKhenThuong> {
        @Override
        public ResDTO<List<HinhThucKhenThuong>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    hinhThucKhenThuongRepository.findAll()
            );
        }

        @Override
        public ResDTO<HinhThucKhenThuong> them(String name) {
            HinhThucKhenThuong thuc = new HinhThucKhenThuong(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        hinhThucKhenThuongRepository.save(thuc)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<HinhThucKhenThuong> sua(HinhThucKhenThuong thuc) {
            Optional<HinhThucKhenThuong> optional = hinhThucKhenThuongRepository.findById(thuc.getId());
            try {
                if (optional.isPresent()) {
                    thuc.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            hinhThucKhenThuongRepository.save(thuc));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class HocHamService implements IUtilitiesService<HocHam> {
        @Override
        public ResDTO<List<HocHam>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    hocHamRepository.findAll()
            );
        }

        @Override
        public ResDTO<HocHam> them(String name) {
            HocHam hocHam = new HocHam(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        hocHamRepository.save(hocHam)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<HocHam> sua(HocHam hocHam) {
            Optional<HocHam> optionalHocHam = hocHamRepository.findById(hocHam.getId());
            try {
                if (optionalHocHam.isPresent()) {
                    hocHam.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            hocHamRepository.save(hocHam));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class LoaiQuanHamQuanDoiService implements IUtilitiesService<LoaiQuanHamQuanDoi> {
        @Override
        public ResDTO<List<LoaiQuanHamQuanDoi>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    loaiQuanHamQuanDoiRepository.findAll()
            );
        }

        @Override
        public ResDTO<LoaiQuanHamQuanDoi> them(String name) {
            LoaiQuanHamQuanDoi loaiQuanHamQuanDoi = new LoaiQuanHamQuanDoi(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        loaiQuanHamQuanDoiRepository.save(loaiQuanHamQuanDoi)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<LoaiQuanHamQuanDoi> sua(LoaiQuanHamQuanDoi loaiQuanHamQuanDoi) {
            Optional<LoaiQuanHamQuanDoi> optionalLoaiQuanHamQuanDoi = loaiQuanHamQuanDoiRepository.findById(loaiQuanHamQuanDoi.getId());
            try {
                if (optionalLoaiQuanHamQuanDoi.isPresent()) {
                    loaiQuanHamQuanDoi.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            loaiQuanHamQuanDoiRepository.save(loaiQuanHamQuanDoi));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class NhomChucDanhDangService implements IUtilitiesService<NhomChucDanhDang> {
        @Override
        public ResDTO<List<NhomChucDanhDang>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    nhomChucDanhDangRepository.findAll()
            );
        }

        @Override
        public ResDTO<NhomChucDanhDang> them(String name) {
            NhomChucDanhDang dang = new NhomChucDanhDang(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        nhomChucDanhDangRepository.save(dang)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<NhomChucDanhDang> sua(NhomChucDanhDang dang) {
            Optional<NhomChucDanhDang> nhomChucDanhDang = nhomChucDanhDangRepository.findById(dang.getId());
            try {
                if (nhomChucDanhDang.isPresent()) {
                    dang.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            nhomChucDanhDangRepository.save(dang));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class NhomMauService implements IUtilitiesService<NhomMau> {
        @Override
        public ResDTO<List<NhomMau>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    nhomMauRepository.findAll()
            );
        }

        @Override
        public ResDTO<NhomMau> them(String name) {
            NhomMau nhomMau = new NhomMau();
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        nhomMauRepository.save(nhomMau)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<NhomMau> sua(NhomMau nhomMau) {
            Optional<NhomMau> optionalNhomMau = nhomMauRepository.findById(nhomMau.getId());
            try {
                if (optionalNhomMau.isPresent()) {
                    nhomMau.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            nhomMauRepository.save(nhomMau));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class ThanhPhanGiaDinhService implements IUtilitiesService<ThanhPhanGiaDinh> {
        @Override
        public ResDTO<List<ThanhPhanGiaDinh>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    thanhPhanGiaDinhRepository.findAll()
            );
        }

        @Override
        public ResDTO<ThanhPhanGiaDinh> them(String name) {
            ThanhPhanGiaDinh thanhPhanGiaDinh = new ThanhPhanGiaDinh(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        thanhPhanGiaDinhRepository.save(thanhPhanGiaDinh)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<ThanhPhanGiaDinh> sua(ThanhPhanGiaDinh thanhPhanGiaDinh) {
            Optional<ThanhPhanGiaDinh> optionalThanhPhanGiaDinh = thanhPhanGiaDinhRepository.findById(thanhPhanGiaDinh.getId());
            try {
                if (optionalThanhPhanGiaDinh.isPresent()) {
                    thanhPhanGiaDinh.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            thanhPhanGiaDinhRepository.save(thanhPhanGiaDinh));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class TinhTrangSucKhoeService implements IUtilitiesService<TinhTrangSucKhoe> {
        @Override
        public ResDTO<List<TinhTrangSucKhoe>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    tinhTrangSucKhoeRepository.findAll()
            );
        }

        @Override
        public ResDTO<TinhTrangSucKhoe> them(String name) {
            TinhTrangSucKhoe tinhTrangSucKhoe = new TinhTrangSucKhoe(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        tinhTrangSucKhoeRepository.save(tinhTrangSucKhoe)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<TinhTrangSucKhoe> sua(TinhTrangSucKhoe tinhTrangSucKhoe) {
            Optional<TinhTrangSucKhoe> optionalTinhTrangSucKhoe = tinhTrangSucKhoeRepository.findById(tinhTrangSucKhoe.getId());
            try {
                if (optionalTinhTrangSucKhoe.isPresent()) {
                    tinhTrangSucKhoe.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            tinhTrangSucKhoeRepository.save(tinhTrangSucKhoe));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class TonGiaoService implements IUtilitiesService<TonGiao> {
        @Override
        public ResDTO<List<TonGiao>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    tonGiaoRepository.findAll()
            );
        }

        @Override
        public ResDTO<TonGiao> them(String name) {
            TonGiao tonGiao = new TonGiao(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        tonGiaoRepository.save(tonGiao)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<TonGiao> sua(TonGiao tonGiao) {
            Optional<TonGiao> optionalTonGiao = tonGiaoRepository.findById(tonGiao.getId());
            try {
                if (optionalTonGiao.isPresent()) {
                    tonGiao.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            tonGiaoRepository.save(tonGiao));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class TrinhDoChuyenMonService implements IUtilitiesService<TrinhDoChuyenMon> {
        @Override
        public ResDTO<List<TrinhDoChuyenMon>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    trinhDoChuyenMonRepository.findAll()
            );
        }

        @Override
        public ResDTO<TrinhDoChuyenMon> them(String name) {
            TrinhDoChuyenMon trinhDoChuyenMon = new TrinhDoChuyenMon(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        trinhDoChuyenMonRepository.save(trinhDoChuyenMon)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<TrinhDoChuyenMon> sua(TrinhDoChuyenMon trinhDoChuyenMon) {
            Optional<TrinhDoChuyenMon> optionalTrinhDoChuyenMon = trinhDoChuyenMonRepository.findById(trinhDoChuyenMon.getId());
            try {
                if (optionalTrinhDoChuyenMon.isPresent()) {
                    trinhDoChuyenMon.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            trinhDoChuyenMonRepository.save(trinhDoChuyenMon));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class TrinhDoGiaoDucPhoThongService implements IUtilitiesService<TrinhDoGiaoDucPhoThong> {
        @Override
        public ResDTO<List<TrinhDoGiaoDucPhoThong>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    trinhDoGiaoDucPhoThongRepository.findAll()
            );
        }

        @Override
        public ResDTO<TrinhDoGiaoDucPhoThong> them(String name) {
            TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong = new TrinhDoGiaoDucPhoThong(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        trinhDoGiaoDucPhoThongRepository.save(trinhDoGiaoDucPhoThong)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<TrinhDoGiaoDucPhoThong> sua(TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong) {
            Optional<TrinhDoGiaoDucPhoThong> optional = trinhDoGiaoDucPhoThongRepository.findById(trinhDoGiaoDucPhoThong.getId());
            try {
                if (optional.isPresent()) {
                    trinhDoGiaoDucPhoThong.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            trinhDoGiaoDucPhoThongRepository.save(trinhDoGiaoDucPhoThong));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }

    @Service
    public class ViTriViecLamService implements IUtilitiesService<ViTriViecLam> {
        @Override
        public ResDTO<List<ViTriViecLam>> xemDS() {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    viTriViecLamRepository.findAll()
            );
        }

        @Override
        public ResDTO<ViTriViecLam> them(String name) {
            ViTriViecLam lam = new ViTriViecLam(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        viTriViecLamRepository.save(lam)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<ViTriViecLam> sua(ViTriViecLam lam) {
            Optional<ViTriViecLam> viTriViecLam = viTriViecLamRepository.findById(lam.getId());
            try {
                if (viTriViecLam.isPresent()) {
                    lam.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            viTriViecLamRepository.save(lam));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }
    }
}

