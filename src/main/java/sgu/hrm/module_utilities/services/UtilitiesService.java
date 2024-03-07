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
import sgu.hrm.module_utilities.models.HinhThucKhenThuong;
import sgu.hrm.module_utilities.models.HocHam;
import sgu.hrm.module_utilities.models.LoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.NhomChucDanhDang;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
import sgu.hrm.module_utilities.models.TonGiao;
import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;
import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;

import sgu.hrm.module_utilities.models.ViTriViecLam;
import sgu.hrm.module_utilities.models.request.ReqUtilities;
import sgu.hrm.module_utilities.repositories.BacLuongRepository;
import sgu.hrm.module_utilities.repositories.CapBacLoaiQuanHamQuanDoiRepository;
import sgu.hrm.module_utilities.repositories.CapNhomChucDanhDangRepository;
import sgu.hrm.module_utilities.repositories.ChucDanhDangRepository;
import sgu.hrm.module_utilities.repositories.ChucVuRepository;
import sgu.hrm.module_utilities.repositories.CoQuanToChucDonViRepository;
import sgu.hrm.module_utilities.repositories.DanTocRepository;
import sgu.hrm.module_utilities.repositories.DanhHieuNhaNuocPhongTangRepository;
import sgu.hrm.module_utilities.repositories.DoiTuongChinhSachRepository;
import sgu.hrm.module_utilities.repositories.HinhThucKhenThuongRepository;
import sgu.hrm.module_utilities.repositories.HocHamRepository;
import sgu.hrm.module_utilities.repositories.LoaiQuanHamQuanDoiRepository;
import sgu.hrm.module_utilities.repositories.NhomChucDanhDangRepository;
import sgu.hrm.module_utilities.repositories.NhomMauRepository;
import sgu.hrm.module_utilities.repositories.ThanhPhanGiaDinhRepository;
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
    private final HinhThucKhenThuongRepository hinhThucKhenThuongRepository;
    private final HocHamRepository hocHamRepository;
    private final LoaiQuanHamQuanDoiRepository loaiQuanHamQuanDoiRepository;
    private final NhomChucDanhDangRepository nhomChucDanhDangRepository;
    private final NhomMauRepository nhomMauRepository;
    private final ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository;
    private final TonGiaoRepository tonGiaoRepository;
    private final TrinhDoChuyenMonRepository trinhDoChuyenMonRepository;
    private final TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository;
    private final ViTriViecLamRepository viTriViecLamRepository;


    @Service
    public class BacLuongService implements IUtilitiesService<BacLuong, ReqUtilities> {
        @Override
        public List<BacLuong> xemDS() {
            return bacLuongRepository.findAll();
        }

        @Override
        public Optional<BacLuong> xemTheoId(int id) {
            return bacLuongRepository.findById(id);
        }

        @Override
        public BacLuong them(ReqUtilities name) {
            try {
                BacLuong bl = bacLuongRepository.findByName(name.name()).orElse(null);
                if (bl == null) {
                    return bacLuongRepository.save(new BacLuong(name.name()));
                }
                return bl;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public BacLuong sua(int id, ReqUtilities luong) {
            try {
                return xemTheoId(id).map(e -> {
                    e.setName(luong.name());
                    e.setUpdate_at();
                    return bacLuongRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    bacLuongRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class CapBacLoaiQuanHamQuanDoiService implements IUtilitiesService<CapBacLoaiQuanHamQuanDoi, ReqUtilities> {
        @Override
        public List<CapBacLoaiQuanHamQuanDoi> xemDS() {
            return capBacLoaiQuanHamQuanDoiRepository.findAll();
        }

        @Override
        public Optional<CapBacLoaiQuanHamQuanDoi> xemTheoId(int id) {
            return capBacLoaiQuanHamQuanDoiRepository.findById(id);
        }

        @Override
        public CapBacLoaiQuanHamQuanDoi them(ReqUtilities req) {
            CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoiRepository.findByName(req.name()).orElse(null);
            LoaiQuanHamQuanDoi loaiQuanHamQuanDoi = loaiQuanHamQuanDoiRepository.findById(req.loaiQuanHamQuanDoi()).orElse(null);
            try {
                if (capBacLoaiQuanHamQuanDoi == null) {
                    return capBacLoaiQuanHamQuanDoiRepository.save(new CapBacLoaiQuanHamQuanDoi(req.name(), loaiQuanHamQuanDoi));
                }
                return capBacLoaiQuanHamQuanDoi;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        public CapBacLoaiQuanHamQuanDoi themCapBacLoaiQuanHamQuanDoi(String name, int loaiQuanHamName) {
            CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoiRepository.findByName(name).orElse(null);
            LoaiQuanHamQuanDoi loaiQuanHamQuanDoi = loaiQuanHamQuanDoiRepository.findById(loaiQuanHamName).orElse(null);
            try {
                if (capBacLoaiQuanHamQuanDoi == null) {
                    return capBacLoaiQuanHamQuanDoiRepository.save(new CapBacLoaiQuanHamQuanDoi(name, loaiQuanHamQuanDoi));
                }
                return capBacLoaiQuanHamQuanDoi;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public CapBacLoaiQuanHamQuanDoi sua(int id, ReqUtilities doi) {
            LoaiQuanHamQuanDoi loaiQuanHamQuanDoi = loaiQuanHamQuanDoiRepository.findById(doi.loaiQuanHamQuanDoi()).orElse(null);
            try {
                return capBacLoaiQuanHamQuanDoiRepository.findById(id).map(e -> {
                    e.setName(doi.name() != null ? doi.name() : e.getName());
                    e.setLoaiQuanHamQuanDoi(loaiQuanHamQuanDoi);
                    e.setUpdate_at();
                    return capBacLoaiQuanHamQuanDoiRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            return IUtilitiesService.super.xoa(id);
        }
    }

    @Service
    public class CapNhomChucDanhDangService implements IUtilitiesService<CapNhomChucDanhDang, ReqUtilities> {
        @Override
        public List<CapNhomChucDanhDang> xemDS() {
            return capNhomChucDanhDangRepository.findAll();
        }

        @Override
        public Optional<CapNhomChucDanhDang> xemTheoId(int id) {
            return capNhomChucDanhDangRepository.findById(id);
        }

        @Override
        public CapNhomChucDanhDang them(ReqUtilities req) {
            CapNhomChucDanhDang capNhomChucDanhDang = capNhomChucDanhDangRepository.findByName(req.name()).orElse(null);
            NhomChucDanhDang nhomChucDanhDang = nhomChucDanhDangRepository.findById(req.nhomChucDanhDang()).orElse(null);
            try {
                if (capNhomChucDanhDang == null) {
                    return capNhomChucDanhDangRepository.save(new CapNhomChucDanhDang(req.name(), nhomChucDanhDang));
                }
                return capNhomChucDanhDang;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public CapNhomChucDanhDang sua(int id, ReqUtilities dang) {
            NhomChucDanhDang nhomChucDanhDang = nhomChucDanhDangRepository.findById(dang.nhomChucDanhDang()).orElse(null);
            try {
                return capNhomChucDanhDangRepository.findById(id).map(e -> {
                    e.setName(dang.name() != null ? dang.name() : e.getName());
                    e.setNhomChucDanhDang(nhomChucDanhDang);
                    e.setUpdate_at();
                    return capNhomChucDanhDangRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    capNhomChucDanhDangRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class ChucDanhDangService implements IUtilitiesService<ChucDanhDang, ReqUtilities> {
        @Override
        public List<ChucDanhDang> xemDS() {
            return chucDanhDangRepository.findAll();
        }

        @Override
        public Optional<ChucDanhDang> xemTheoId(int id) {
            return chucDanhDangRepository.findById(id);
        }

        @Override
        public ChucDanhDang them(ReqUtilities req) {
            ChucDanhDang chucDanhDang = chucDanhDangRepository.findByName(req.name()).orElse(null);
            CapNhomChucDanhDang capNhomChucDanhDang = capNhomChucDanhDangRepository.findById(req.capNhomChucDanhDang()).orElse(null);
            try {
                if (chucDanhDang == null) {
                    return chucDanhDangRepository.save(new ChucDanhDang(req.name(), capNhomChucDanhDang));
                }
                return chucDanhDang;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ChucDanhDang sua(int id, ReqUtilities dang) {
            CapNhomChucDanhDang capNhomChucDanhDang = capNhomChucDanhDangRepository.findById(dang.capNhomChucDanhDang()).orElse(null);
            try {
                return chucDanhDangRepository.findById(id).map(e -> {
                    e.setName(dang.name() != null ? dang.name() : e.getName());
                    e.setCapNhomChucDanhDang(capNhomChucDanhDang);
                    e.setUpdate_at();
                    return chucDanhDangRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    chucDanhDangRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class ChucVuService implements IUtilitiesService<ChucVu, ReqUtilities> {
        @Override
        public List<ChucVu> xemDS() {
            return chucVuRepository.findAll();
        }

        @Override
        public Optional<ChucVu> xemTheoId(int id) {
            return chucVuRepository.findById(id);
        }

        @Override
        public ChucVu them(ReqUtilities req) {
            ChucVu vu = chucVuRepository.findByName(req.name()).orElse(null);
            try {
                if (vu == null) {
                    return chucVuRepository.save(new ChucVu(req.name()));
                }
                return vu;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ChucVu sua(int id, ReqUtilities vu) {
            try {
                return chucVuRepository.findById(id).map(e -> {
                    e.setName(vu.name());
                    e.setUpdate_at();
                    return chucVuRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    chucVuRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class CoQuanToChucDonViService implements IUtilitiesService<CoQuanToChucDonVi, ReqUtilities> {
        @Override
        public List<CoQuanToChucDonVi> xemDS() {
            return coQuanToChucDonViRepository.findAll();
        }

        @Override
        public Optional<CoQuanToChucDonVi> xemTheoId(int id) {
            return coQuanToChucDonViRepository.findById(id);
        }

        @Override
        public CoQuanToChucDonVi them(ReqUtilities req) {
            CoQuanToChucDonVi co = coQuanToChucDonViRepository.findByName(req.name()).orElse(null);
            try {
                if (co == null) {
                    return coQuanToChucDonViRepository.save(new CoQuanToChucDonVi(req.name()));
                }
                return co;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public CoQuanToChucDonVi sua(int id, ReqUtilities vi) {
            try {
                return coQuanToChucDonViRepository.findById(id).map(e -> {
                    e.setName(vi.name());
                    e.setUpdate_at();
                    return coQuanToChucDonViRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    coQuanToChucDonViRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class DanhHieuNhaNuocPhongTangService implements IUtilitiesService<DanhHieuNhaNuocPhongTang, ReqUtilities> {
        @Override
        public List<DanhHieuNhaNuocPhongTang> xemDS() {
            return danhHieuNhaNuocPhongTangRepository.findAll();
        }

        @Override
        public Optional<DanhHieuNhaNuocPhongTang> xemTheoId(int id) {
            return danhHieuNhaNuocPhongTangRepository.findById(id);
        }

        @Override
        public DanhHieuNhaNuocPhongTang them(ReqUtilities req) {
            DanhHieuNhaNuocPhongTang danh = danhHieuNhaNuocPhongTangRepository.findByName(req.name()).orElse(null);
            try {
                if (danh == null) {
                    return danhHieuNhaNuocPhongTangRepository.save(new DanhHieuNhaNuocPhongTang(req.name()));
                }
                return danh;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public DanhHieuNhaNuocPhongTang sua(int id, ReqUtilities danh) {
            try {
                return danhHieuNhaNuocPhongTangRepository.findById(id).map(e -> {
                    e.setName(danh.name());
                    e.setUpdate_at();
                    return danhHieuNhaNuocPhongTangRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    danhHieuNhaNuocPhongTangRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class DanTocService implements IUtilitiesService<DanToc, ReqUtilities> {
        @Override
        public List<DanToc> xemDS() {
            return danTocRepository.findAll();
        }

        @Override
        public Optional<DanToc> xemTheoId(int id) {
            return danTocRepository.findById(id);
        }

        @Override
        public DanToc them(ReqUtilities req) {
            DanToc toc = danTocRepository.findByName(req.name()).orElse(null);
            try {
                if (toc == null) {
                    return danTocRepository.save(new DanToc(req.name()));
                }
                return toc;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public DanToc sua(int id, ReqUtilities toc) {
            try {
                return danTocRepository.findById(id).map(e -> {
                    e.setName(toc.name());
                    e.setUpdate_at();
                    return danTocRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    danTocRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class DoiTuongChinhSachService implements IUtilitiesService<DoiTuongChinhSach, ReqUtilities> {
        @Override
        public List<DoiTuongChinhSach> xemDS() {
            return doiTuongChinhSachRepository.findAll();
        }

        @Override
        public Optional<DoiTuongChinhSach> xemTheoId(int id) {
            return doiTuongChinhSachRepository.findById(id);
        }

        @Override
        public DoiTuongChinhSach them(ReqUtilities req) {
            DoiTuongChinhSach sach = doiTuongChinhSachRepository.findByName(req.name()).orElse(null);
            try {
                if (sach == null) {
                    return doiTuongChinhSachRepository.save(new DoiTuongChinhSach(req.name()));
                }
                return sach;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public DoiTuongChinhSach sua(int id, ReqUtilities sach) {
            try {
                return doiTuongChinhSachRepository.findById(id).map(e -> {
                    e.setName(sach.name());
                    e.setUpdate_at();
                    return doiTuongChinhSachRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    doiTuongChinhSachRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class HinhThucKhenThuongService implements IUtilitiesService<HinhThucKhenThuong, ReqUtilities> {
        @Override
        public List<HinhThucKhenThuong> xemDS() {
            return hinhThucKhenThuongRepository.findAll();
        }

        @Override
        public Optional<HinhThucKhenThuong> xemTheoId(int id) {
            return hinhThucKhenThuongRepository.findById(id);
        }

        @Override
        public HinhThucKhenThuong them(ReqUtilities req) {
            HinhThucKhenThuong thuc = hinhThucKhenThuongRepository.findByName(req.name()).orElse(null);
            try {
                if (thuc == null) {
                    return hinhThucKhenThuongRepository.save(new HinhThucKhenThuong(req.name()));
                }
                return thuc;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public HinhThucKhenThuong sua(int id, ReqUtilities tinh) {
            try {
                return hinhThucKhenThuongRepository.findById(id).map(e -> {
                    e.setName(tinh.name());
                    e.setUpdate_at();
                    return hinhThucKhenThuongRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    hinhThucKhenThuongRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class HocHamService implements IUtilitiesService<HocHam, ReqUtilities> {

        @Override
        public List<HocHam> xemDS() {
            return hocHamRepository.findAll();
        }

        @Override
        public Optional<HocHam> xemTheoId(int id) {
            return hocHamRepository.findById(id);
        }

        @Override
        public HocHam them(ReqUtilities req) {
            HocHam ham = hocHamRepository.findByName(req.name()).orElse(null);
            try {
                if (ham == null) {
                    return hocHamRepository.save(new HocHam(req.name()));
                }
                return ham;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public HocHam sua(int id, ReqUtilities req) {
            try {
                return hocHamRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return hocHamRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    hocHamRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class LoaiQuanHamQuanDoiService implements IUtilitiesService<LoaiQuanHamQuanDoi, ReqUtilities> {

        @Override
        public List<LoaiQuanHamQuanDoi> xemDS() {
            return loaiQuanHamQuanDoiRepository.findAll();
        }

        @Override
        public Optional<LoaiQuanHamQuanDoi> xemTheoId(int id) {
            return loaiQuanHamQuanDoiRepository.findById(id);
        }

        @Override
        public LoaiQuanHamQuanDoi them(ReqUtilities req) {
            LoaiQuanHamQuanDoi ham = loaiQuanHamQuanDoiRepository.findByName(req.name()).orElse(null);
            try {
                if (ham == null) {
                    return loaiQuanHamQuanDoiRepository.save(new LoaiQuanHamQuanDoi(req.name()));
                }
                return ham;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LoaiQuanHamQuanDoi sua(int id, ReqUtilities req) {
            try {
                return loaiQuanHamQuanDoiRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return loaiQuanHamQuanDoiRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    loaiQuanHamQuanDoiRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class NhomChucDanhDangService implements IUtilitiesService<NhomChucDanhDang, ReqUtilities> {

        @Override
        public List<NhomChucDanhDang> xemDS() {
            return nhomChucDanhDangRepository.findAll();
        }

        @Override
        public Optional<NhomChucDanhDang> xemTheoId(int id) {
            return nhomChucDanhDangRepository.findById(id);
        }

        @Override
        public NhomChucDanhDang them(ReqUtilities req) {
            NhomChucDanhDang dang = nhomChucDanhDangRepository.findByName(req.name()).orElse(null);
            try {
                if (dang == null) {
                    return nhomChucDanhDangRepository.save(new NhomChucDanhDang(req.name()));
                }
                return dang;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public NhomChucDanhDang sua(int id, ReqUtilities req) {
            try {
                return nhomChucDanhDangRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return nhomChucDanhDangRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    nhomChucDanhDangRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class NhomMauService implements IUtilitiesService<NhomMau, ReqUtilities> {

        @Override
        public List<NhomMau> xemDS() {
            return nhomMauRepository.findAll();
        }

        @Override
        public Optional<NhomMau> xemTheoId(int id) {
            return nhomMauRepository.findById(id);
        }

        @Override
        public NhomMau them(ReqUtilities req) {
            NhomMau mau = nhomMauRepository.findByName(req.name()).orElse(null);
            try {
                if (mau == null) {
                    return nhomMauRepository.save(new NhomMau(req.name()));
                }
                return mau;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public NhomMau sua(int id, ReqUtilities req) {
            try {
                return nhomMauRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return nhomMauRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    nhomMauRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class ThanhPhanGiaDinhService implements IUtilitiesService<ThanhPhanGiaDinh, ReqUtilities> {

        @Override
        public List<ThanhPhanGiaDinh> xemDS() {
            return thanhPhanGiaDinhRepository.findAll();
        }

        @Override
        public Optional<ThanhPhanGiaDinh> xemTheoId(int id) {
            return thanhPhanGiaDinhRepository.findById(id);
        }

        @Override
        public ThanhPhanGiaDinh them(ReqUtilities req) {
            ThanhPhanGiaDinh gia = thanhPhanGiaDinhRepository.findByName(req.name()).orElse(null);
            try {
                if (gia == null) {
                    return thanhPhanGiaDinhRepository.save(new ThanhPhanGiaDinh(req.name()));
                }
                return gia;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ThanhPhanGiaDinh sua(int id, ReqUtilities req) {
            try {
                return thanhPhanGiaDinhRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return thanhPhanGiaDinhRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    thanhPhanGiaDinhRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class TonGiaoService implements IUtilitiesService<TonGiao, ReqUtilities> {

        @Override
        public List<TonGiao> xemDS() {
            return tonGiaoRepository.findAll();
        }

        @Override
        public Optional<TonGiao> xemTheoId(int id) {
            return tonGiaoRepository.findById(id);
        }

        @Override
        public TonGiao them(ReqUtilities req) {
            TonGiao giao = tonGiaoRepository.findByName(req.name()).orElse(null);
            try {
                if (giao == null) {
                    return tonGiaoRepository.save(new TonGiao(req.name()));
                }
                return giao;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public TonGiao sua(int id, ReqUtilities req) {
            try {
                return tonGiaoRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return tonGiaoRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    tonGiaoRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class TrinhDoChuyenMonService implements IUtilitiesService<TrinhDoChuyenMon, ReqUtilities> {

        @Override
        public List<TrinhDoChuyenMon> xemDS() {
            return trinhDoChuyenMonRepository.findAll();
        }

        @Override
        public Optional<TrinhDoChuyenMon> xemTheoId(int id) {
            return trinhDoChuyenMonRepository.findById(id);
        }

        @Override
        public TrinhDoChuyenMon them(ReqUtilities req) {
            TrinhDoChuyenMon mon = trinhDoChuyenMonRepository.findByName(req.name()).orElse(null);
            try {
                if (mon == null) {
                    return trinhDoChuyenMonRepository.save(new TrinhDoChuyenMon(req.name()));
                }
                return mon;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public TrinhDoChuyenMon sua(int id, ReqUtilities req) {
            try {
                return trinhDoChuyenMonRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return trinhDoChuyenMonRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    trinhDoChuyenMonRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class TrinhDoGiaoDucPhoThongService implements IUtilitiesService<TrinhDoGiaoDucPhoThong, ReqUtilities> {

        @Override
        public List<TrinhDoGiaoDucPhoThong> xemDS() {
            return trinhDoGiaoDucPhoThongRepository.findAll();
        }

        @Override
        public Optional<TrinhDoGiaoDucPhoThong> xemTheoId(int id) {
            return trinhDoGiaoDucPhoThongRepository.findById(id);
        }

        @Override
        public TrinhDoGiaoDucPhoThong them(ReqUtilities req) {
            TrinhDoGiaoDucPhoThong thong = trinhDoGiaoDucPhoThongRepository.findByName(req.name()).orElse(null);
            try {
                if (thong == null) {
                    return trinhDoGiaoDucPhoThongRepository.save(new TrinhDoGiaoDucPhoThong(req.name()));
                }
                return thong;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public TrinhDoGiaoDucPhoThong sua(int id, ReqUtilities req) {
            try {
                return trinhDoGiaoDucPhoThongRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return trinhDoGiaoDucPhoThongRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    trinhDoGiaoDucPhoThongRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class ViTriViecLamService implements IUtilitiesService<ViTriViecLam, ReqUtilities> {

        @Override
        public List<ViTriViecLam> xemDS() {
            return viTriViecLamRepository.findAll();
        }

        @Override
        public Optional<ViTriViecLam> xemTheoId(int id) {
            return viTriViecLamRepository.findById(id);
        }

        @Override
        public ViTriViecLam them(ReqUtilities req) {
            ViTriViecLam viec = viTriViecLamRepository.findByName(req.name());
            BacLuong bacLuong = bacLuongRepository.findById(req.bacLuong()).orElse(null);
            try {
                if (viec == null) {
                    return viTriViecLamRepository.save(new ViTriViecLam(req.name(), bacLuong, req.tienLuong()));
                }
                return viec;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ViTriViecLam sua(int id, ReqUtilities req) {
            BacLuong bacLuong = bacLuongRepository.findById(req.bacLuong()).orElse(null);
            try {
                return viTriViecLamRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setBacLuong(bacLuong);
                    e.setUpdate_at();
                    return viTriViecLamRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    viTriViecLamRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }
}

