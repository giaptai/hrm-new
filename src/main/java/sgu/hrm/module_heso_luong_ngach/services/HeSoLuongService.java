//package sgu.hrm.module_heso_luong_ngach.services;
//
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//
//import org.springframework.stereotype.Service;
//import sgu.hrm.module_heso_luong_ngach.models.HeSoLuongCongChuc;
//import sgu.hrm.module_heso_luong_ngach.models.HeSoLuongVienChuc;
//import sgu.hrm.module_heso_luong_ngach.models.LoaiCongChuc;
//import sgu.hrm.module_heso_luong_ngach.models.LoaiVienChuc;
//import sgu.hrm.module_heso_luong_ngach.models.response.ResHeSoLuongCongChuc;
//import sgu.hrm.module_heso_luong_ngach.models.response.ResHeSoLuongVienChuc;
//import sgu.hrm.module_heso_luong_ngach.repositories.HeSoLuongCongChucRepository;
//import sgu.hrm.module_heso_luong_ngach.repositories.HeSoLuongVienChucRepository;
//import sgu.hrm.module_heso_luong_ngach.repositories.LoaiCongChucRepository;
//import sgu.hrm.module_heso_luong_ngach.repositories.LoaiVienChucRepository;
//import sgu.hrm.module_heso_luong_ngach.repositories.NhomLoaiCongChucRepository;
//import sgu.hrm.module_heso_luong_ngach.repositories.NhomLoaiVienChucRepository;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor // constructor field final or @not null
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class HeSoLuongService implements
//        ILoaiNhomHeSoNgachService.ILoaiVienChucService,
//        ILoaiNhomHeSoNgachService.INhomCongChucService,
//        ILoaiNhomHeSoNgachService.INhomVienChucService,
//        ILoaiNhomHeSoNgachService.IHeSoLuongCongChucService,
//        ILoaiNhomHeSoNgachService.IHeSoLuongVienChucService {
//
//    final LoaiCongChucRepository loaiCongChucRepository;
//    final LoaiVienChucRepository loaiVienChucRepository;
//    final NhomLoaiCongChucRepository nhomLoaiCongChucRepository;
//    final NhomLoaiVienChucRepository nhomLoaiVienChucRepository;
//    final HeSoLuongCongChucRepository heSoLuongCongChucRepository;
//    final HeSoLuongVienChucRepository heSoLuongVienChucRepository;
//
//    @Service
//    public class LoaiCongChucService implements ILoaiNhomHeSoNgachService.ILoaiCongChucService{
//        @Override
//        public List<LoaiCongChuc> xemLoaiCongChuc() {
//            return null;
//        }
//
//        @Override
//        public LoaiCongChuc themLoaiCongChuc() {
//            return null;
//        }
//
//        @Override
//        public LoaiCongChuc suaLoaiCongChuc() {
//            return null;
//        }
//    }
//    @Service
//    public class LoaiVienChucService implements ILoaiNhomHeSoNgachService.ILoaiVienChucService{
//
//        @Override
//        public List<LoaiVienChuc> xemLoaiVienChuc() {
//            return null;
//        }
//
//        @Override
//        public LoaiVienChuc themLoaiVienChuc() {
//            return null;
//        }
//
//        @Override
//        public LoaiVienChuc suaLoaiVienChuc() {
//            return null;
//        }
//    }
//
//    private ResHeSoLuongCongChuc mapToResHeSoLuongCongChuc(HeSoLuongCongChuc chuc) {
//        return ResHeSoLuongCongChuc.builder()
//                .id(chuc.getId())
//                .heSo(chuc.getHeSo())
//                .bacLuong(chuc.getBacLuong().getName())
//                .nhomLoaiCongChuc(chuc.getNhomCongChuc().getName())
//                .trangThai(chuc.isTrangThai())
//                .create_at(chuc.getCreate_at())
//                .update_at(chuc.getUpdate_at())
//                .build();
//    }
//
//    private ResHeSoLuongVienChuc mapToResHeSoLuongVienChuc(HeSoLuongVienChuc vien) {
//        return ResHeSoLuongVienChuc.builder()
//                .id(vien.getId())
//                .heSo(vien.getHeSo())
//                .bacLuong(vien.getBacLuong().getName())
//                .nhomLoaiVienChuc(vien.getNhomVienChuc().getName())
//                .trangThai(vien.isTrangThai())
//                .create_at(vien.getCreate_at())
//                .update_at(vien.getUpdate_at())
//                .build();
//    }
//}
