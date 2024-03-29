package sgu.hrm.module_cauhinh.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sgu.hrm.module_cauhinh.models.HeSoLuongCongChuc;
import sgu.hrm.module_cauhinh.models.HeSoLuongVienChuc;
import sgu.hrm.module_cauhinh.models.LoaiCongChuc;
import sgu.hrm.module_cauhinh.models.LoaiVienChuc;
import sgu.hrm.module_cauhinh.models.NgachCongChuc;
import sgu.hrm.module_cauhinh.models.NgachVienChuc;
import sgu.hrm.module_cauhinh.models.NhomCongChuc;
import sgu.hrm.module_cauhinh.models.NhomVienChuc;
import sgu.hrm.module_cauhinh.dto.request.ReqHeSoLuong;
import sgu.hrm.module_cauhinh.dto.request.ReqLoai;
import sgu.hrm.module_cauhinh.dto.request.ReqNgach;
import sgu.hrm.module_cauhinh.dto.request.ReqNhom;
import sgu.hrm.module_cauhinh.repositories.HeSoLuongCongChucRepository;
import sgu.hrm.module_cauhinh.repositories.HeSoLuongVienChucRepository;
import sgu.hrm.module_cauhinh.repositories.LoaiCongChucRepository;
import sgu.hrm.module_cauhinh.repositories.LoaiVienChucRepository;
import sgu.hrm.module_cauhinh.repositories.NgachCongChucRepository;
import sgu.hrm.module_cauhinh.repositories.NgachVienChucRepository;
import sgu.hrm.module_cauhinh.repositories.NhomCongChucRepository;
import sgu.hrm.module_cauhinh.repositories.NhomVienChucRepository;
import sgu.hrm.response.ResDTO;
import sgu.hrm.response.ResEnum;
import sgu.hrm.module_cauhinh.models.BacLuong;
import sgu.hrm.module_cauhinh.repositories.BacLuongRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoaiNhomHeSoNgachService {
    private final BacLuongRepository bacLuongRepository;
    private final LoaiCongChucRepository loaiCongChucRepository;
    private final LoaiVienChucRepository loaiVienChucRepository;
    private final NhomCongChucRepository nhomCongChucRepository;
    private final NhomVienChucRepository nhomVienChucRepository;
    private final HeSoLuongCongChucRepository heSoLuongCongChucRepository;
    private final HeSoLuongVienChucRepository heSoLuongVienChucRepository;
    private final NgachCongChucRepository ngachCongChucRepository;
    private final NgachVienChucRepository ngachVienChucRepository;

    @Service
    public class LoaiCongChucService implements ILoaiNhomHeSoNgachService.ILoaiCongChucService {

        @Override
        public List<LoaiCongChuc> xemLoaiCongChuc() {
            return loaiCongChucRepository.findAll();
        }

        @Override
        public LoaiCongChuc xemTheoId(int id) {
            return loaiCongChucRepository.findById(id).orElse(null);
        }

        @Override
        public LoaiCongChuc themLoaiCongChuc(ReqLoai loai) {
            try {
                LoaiCongChuc chuc = loaiCongChucRepository.findByLoai(loai.loai());
                if (chuc == null) {
                    return loaiCongChucRepository.save(new LoaiCongChuc(loai.loai(), loai.name()));
                } else throw ResDTO.error(ResEnum.TRUNG_DU_LIEU);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public LoaiCongChuc suaLoaiCongChuc(int id, ReqLoai loai) {
            try {
                return loaiCongChucRepository.findById(id).map(e -> {
                            e.setLoai(loai.loai());
                            e.setName(loai.name());
                            e.setUpdate_at();
                            return loaiCongChucRepository.save(e);
                        }
                ).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaLoaiCongChuc(int id) {
            try {
                return loaiCongChucRepository.findById(id).map(e -> {
                            loaiCongChucRepository.deleteById(id);
                            return true;
                        }
                ).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class LoaiVienChucService implements ILoaiNhomHeSoNgachService.ILoaiVienChucService {

        @Override
        public List<LoaiVienChuc> xemLoaiVienChuc() {
            return loaiVienChucRepository.findAll();
        }

        @Override
        public LoaiVienChuc xemTheoId(int id) {
            return loaiVienChucRepository.findById(id).orElse(null);
        }

        @Override
        public LoaiVienChuc themLoaiVienChuc(ReqLoai loai) {
            try {
                LoaiVienChuc chuc = loaiVienChucRepository.findByLoai(loai.loai());
                if (chuc == null) {
                    return loaiVienChucRepository.save(new LoaiVienChuc(loai.loai(), loai.name()));
                } else throw ResDTO.error(ResEnum.TRUNG_DU_LIEU);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public LoaiVienChuc suaLoaiVienChuc(int id, ReqLoai loai) {
            try {
                return loaiVienChucRepository.findById(id).map(e -> {
                            e.setLoai(loai.loai());
                            e.setName(loai.name());
                            e.setUpdate_at();
                            return loaiVienChucRepository.save(e);
                        }
                ).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaLoaiVienChuc(int id) {
            try {
                return loaiVienChucRepository.findById(id).map(e -> {
                            loaiVienChucRepository.deleteById(id);
                            return true;
                        }
                ).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class NhomCongChucService implements ILoaiNhomHeSoNgachService.INhomCongChucService {

        @Override
        public List<NhomCongChuc> xemNhomCongChuc() {
            return nhomCongChucRepository.findAll();
        }

        @Override
        public NhomCongChuc xemTheoId(int id) {
            return nhomCongChucRepository.findById(id).orElse(null);
        }

        @Override
        public NhomCongChuc themNhomCongChuc(ReqNhom nhom) {
            try {
                LoaiCongChuc loai = loaiCongChucRepository.findById(nhom.loai()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                NhomCongChuc chuc = nhomCongChucRepository.findByName(nhom.name());
                if (chuc == null) {
                    return nhomCongChucRepository.save(new NhomCongChuc(nhom.name(), loai));
                } else throw ResDTO.error(ResEnum.TRUNG_DU_LIEU);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public NhomCongChuc suaNhomCongChuc(int id, ReqNhom nhom) {
            try {
                LoaiCongChuc loai = loaiCongChucRepository.findById(nhom.loai()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return nhomCongChucRepository.findById(id).map(e -> {
                            e.setLoaiCongChuc(loai);
                            e.setName(nhom.name());
                            e.setUpdate_at();
                            return nhomCongChucRepository.save(e);
                        }
                ).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaNhomCongChuc(int id) {
            try {
                return nhomCongChucRepository.findById(id).map(e -> {
                            nhomCongChucRepository.deleteById(id);
                            return true;
                        }
                ).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class NhomVienChucService implements ILoaiNhomHeSoNgachService.INhomVienChucService {

        @Override
        public List<NhomVienChuc> xemNhomVienChuc() {
            return nhomVienChucRepository.findAll();
        }

        @Override
        public NhomVienChuc xemTheoId(int id) {
            return nhomVienChucRepository.findById(id).orElse(null);
        }

        @Override
        public NhomVienChuc themNhomVienChuc(ReqNhom nhom) {
            try {
                LoaiVienChuc loai = loaiVienChucRepository.findById(nhom.loai()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                NhomVienChuc vien = nhomVienChucRepository.findByName(nhom.name());
                if (vien == null) {
                    return nhomVienChucRepository.save(new NhomVienChuc(nhom.name(), loai));
                } else throw ResDTO.error(ResEnum.TRUNG_DU_LIEU);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public NhomVienChuc suaNhomVienChuc(int id, ReqNhom nhom) {
            try {
                LoaiVienChuc loai = loaiVienChucRepository.findById(nhom.loai()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return nhomVienChucRepository.findById(id).map(e -> {
                            e.setLoaiVienChuc(loai);
                            e.setName(nhom.name());
                            e.setUpdate_at();
                            return nhomVienChucRepository.save(e);
                        }
                ).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaNhomVienChuc(int id) {
            try {
                return nhomVienChucRepository.findById(id).map(e -> {
                            nhomVienChucRepository.deleteById(id);
                            return true;
                        }
                ).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class HeSoLuongCongChucService implements ILoaiNhomHeSoNgachService.IHeSoLuongCongChucService {

        @Override
        public List<HeSoLuongCongChuc> xemHeSoLuongCongChuc() {
            return heSoLuongCongChucRepository.findAll();
        }

        @Override
        public HeSoLuongCongChuc xemTheoId(int id) {
            return heSoLuongCongChucRepository.findById(id).orElse(null);
        }

        @Override
        public HeSoLuongCongChuc themHeSoLuongCongChuc(ReqHeSoLuong luong) {
            try {
                NhomCongChuc nhom = nhomCongChucRepository.findById(luong.nhom()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                BacLuong bac = bacLuongRepository.findById(luong.bacLuong()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return heSoLuongCongChucRepository.save(new HeSoLuongCongChuc(nhom, bac, luong.heSo()));
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public HeSoLuongCongChuc suaHeSoLuongCongChuc(int id, ReqHeSoLuong luong) {
            try {
                NhomCongChuc nhom = nhomCongChucRepository.findById(luong.nhom()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                BacLuong bac = bacLuongRepository.findById(luong.bacLuong()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return heSoLuongCongChucRepository.findById(id).map(e -> {
                    e.setNhomCongChuc(nhom);
                    e.setBacLuong(bac);
                    e.setHeSo(luong.heSo());
                    e.setUpdate_at();
                    return heSoLuongCongChucRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaHeSoLuongCongChuc(int id) {
            try {
                return heSoLuongCongChucRepository.findById(id).map(e -> {
                            heSoLuongCongChucRepository.deleteById(id);
                            return true;
                        }
                ).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class HeSoLuongVienChucService implements ILoaiNhomHeSoNgachService.IHeSoLuongVienChucService {

        @Override
        public List<HeSoLuongVienChuc> xemHeSoLuongVienChuc() {
            return heSoLuongVienChucRepository.findAll();
        }

        @Override
        public HeSoLuongVienChuc xemTheoId(int id) {
            return heSoLuongVienChucRepository.findById(id).orElse(null);
        }

        @Override
        public HeSoLuongVienChuc themHeSoLuongVienChuc(ReqHeSoLuong luong) {
            try {
                NhomVienChuc nhom = nhomVienChucRepository.findById(luong.nhom()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                BacLuong bac = bacLuongRepository.findById(luong.bacLuong()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return heSoLuongVienChucRepository.save(new HeSoLuongVienChuc(nhom, bac, luong.heSo()));
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public HeSoLuongVienChuc suaHeSoLuongVienChuc(int id, ReqHeSoLuong luong) {
            try {
                NhomVienChuc nhom = nhomVienChucRepository.findById(luong.nhom()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                BacLuong bac = bacLuongRepository.findById(luong.bacLuong()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return heSoLuongVienChucRepository.findById(id).map(e -> {
                    e.setNhomVienChuc(nhom);
                    e.setBacLuong(bac);
                    e.setHeSo(luong.heSo());
                    e.setUpdate_at();
                    return heSoLuongVienChucRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaHeSoLuongVienChuc(int id) {
            try {
                return heSoLuongVienChucRepository.findById(id).map(e -> {
                            heSoLuongVienChucRepository.deleteById(id);
                            return true;
                        }
                ).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class NgachCongChucService implements ILoaiNhomHeSoNgachService.INgachCongChucService {

        @Override
        public List<NgachCongChuc> xemNgachCongChuc() {
            return ngachCongChucRepository.findAll();
        }

        @Override
        public NgachCongChuc xemTheoId(String id) {
            return ngachCongChucRepository.findById(id).orElse(null);
        }

        @Override
        public NgachCongChuc themNgachCongChuc(ReqNgach req) {
            try {
                HeSoLuongCongChuc heSo = heSoLuongCongChucRepository.findById(req.heSoLuong()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                NgachCongChuc ngach = ngachCongChucRepository.findByName(req.name());
                if (ngach == null) {
                    return ngachCongChucRepository.save(new NgachCongChuc(req.ma(), req.name(), heSo));
                } else throw ResDTO.error(ResEnum.TRUNG_DU_LIEU);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public NgachCongChuc suaNgachCongChuc(String id, ReqNgach req) {
            try {
                HeSoLuongCongChuc heSo = heSoLuongCongChucRepository.findById(req.heSoLuong()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return ngachCongChucRepository.findById(id).map(e -> {
                    e.setMa(req.ma());
                    e.setName(req.name());
                    e.setHeSoLuongCongChuc(heSo);
                    e.setUpdate_at();
                    return ngachCongChucRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaNgachCongChuc(String id) {
            try {
                return ngachCongChucRepository.findById(id).map(e -> {
                    ngachCongChucRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class NgachVienChucService implements ILoaiNhomHeSoNgachService.INgachVienChucService {

        @Override
        public List<NgachVienChuc> xemNgachVienChuc() {
            return ngachVienChucRepository.findAll();
        }

        @Override
        public NgachVienChuc xemTheoId(String id) {
            return ngachVienChucRepository.findById(id).orElse(null);
        }

        @Override
        public NgachVienChuc themNgachVienChuc(ReqNgach req) {
            try {
                HeSoLuongVienChuc heSo = heSoLuongVienChucRepository.findById(req.heSoLuong()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                NgachVienChuc vien = ngachVienChucRepository.findByName(req.name());
                if (vien == null) {
                    return ngachVienChucRepository.save(new NgachVienChuc(req.ma(), req.name(), heSo));
                } else throw ResDTO.error(ResEnum.TRUNG_DU_LIEU);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public NgachVienChuc suaNgachVienChuc(String id, ReqNgach req) {
            try {
                HeSoLuongVienChuc heSo = heSoLuongVienChucRepository.findById(req.heSoLuong()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return ngachVienChucRepository.findById(id).map(e -> {
                    e.setMa(req.ma());
                    e.setName(req.name());
                    e.setHeSoLuongVienChuc(heSo);
                    e.setUpdate_at();
                    return ngachVienChucRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaNgachVienChuc(String id) {
            try {
                return ngachVienChucRepository.findById(id).map(e -> {
                    ngachVienChucRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }
}
