package sgu.hrm.module_heso_luong_ngach.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_heso_luong_ngach.models.HeSoLuongCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.HeSoLuongVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.LoaiCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.LoaiVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.NgachCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.NgachVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.NhomCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.NhomVienChuc;
import sgu.hrm.module_heso_luong_ngach.models.request.ReqHeSoLuong;
import sgu.hrm.module_heso_luong_ngach.models.request.ReqLoai;
import sgu.hrm.module_heso_luong_ngach.models.request.ReqNgach;
import sgu.hrm.module_heso_luong_ngach.models.request.ReqNhom;
import sgu.hrm.module_heso_luong_ngach.services.ILoaiNhomHeSoNgachService;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoaiNhomHeSoNgachController {
    private final ILoaiNhomHeSoNgachService.ILoaiCongChucService congChucService;
    private final ILoaiNhomHeSoNgachService.ILoaiVienChucService vienChucService;
    private final ILoaiNhomHeSoNgachService.INhomCongChucService nhomCongChucService;
    private final ILoaiNhomHeSoNgachService.INhomVienChucService nhomVienChucService;
    private final ILoaiNhomHeSoNgachService.IHeSoLuongCongChucService heSoLuongCongChucService;
    private final ILoaiNhomHeSoNgachService.IHeSoLuongVienChucService heSoLuongVienChucService;
    private final ILoaiNhomHeSoNgachService.INgachCongChucService ngachCongChucService;
    private final ILoaiNhomHeSoNgachService.INgachVienChucService ngachVienChucService;

    @RestController
    class LoaiCongChucController {
        @GetMapping("/loai-cong-chuc")
        public ResponseEntity<ResDTO<List<LoaiCongChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, congChucService.xemLoaiCongChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/loai-cong-chuc")
        public ResponseEntity<ResDTO<LoaiCongChuc>> add(@RequestBody ReqLoai loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, congChucService.themLoaiCongChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/loai-cong-chuc/{id}")
        public ResponseEntity<ResDTO<LoaiCongChuc>> edit(@PathVariable int id, @RequestBody ReqLoai loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, congChucService.suaLoaiCongChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/loai-cong-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, congChucService.xoaLoaiCongChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    class LoaiVienChucController {
        @GetMapping("/loai-vien-chuc")
        public ResponseEntity<ResDTO<List<LoaiVienChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, vienChucService.xemLoaiVienChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/loai-vien-chuc")
        public ResponseEntity<ResDTO<LoaiVienChuc>> add(@RequestBody ReqLoai loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, vienChucService.themLoaiVienChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/loai-vien-chuc/{id}")
        public ResponseEntity<ResDTO<LoaiVienChuc>> edit(@PathVariable int id, @RequestBody ReqLoai loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, vienChucService.suaLoaiVienChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/loai-vien-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, vienChucService.xoaLoaiVienChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    class NhomCongChucController {
        @GetMapping("/nhom-cong-chuc")
        public ResponseEntity<ResDTO<List<NhomCongChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomCongChucService.xemNhomCongChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/nhom-cong-chuc")
        public ResponseEntity<ResDTO<NhomCongChuc>> add(@RequestBody ReqNhom loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, nhomCongChucService.themNhomCongChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/nhom-cong-chuc/{id}")
        public ResponseEntity<ResDTO<NhomCongChuc>> edit(@PathVariable int id, @RequestBody ReqNhom loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, nhomCongChucService.suaNhomCongChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/nhom-cong-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, nhomCongChucService.xoaNhomCongChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    class NhomVienChucController {
        @GetMapping("/nhom-vien-chuc")
        public ResponseEntity<ResDTO<List<NhomVienChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, nhomVienChucService.xemNhomVienChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/nhom-vien-chuc")
        public ResponseEntity<ResDTO<NhomVienChuc>> add(@RequestBody ReqNhom loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, nhomVienChucService.themNhomVienChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/nhom-vien-chuc/{id}")
        public ResponseEntity<ResDTO<NhomVienChuc>> edit(@PathVariable int id, @RequestBody ReqNhom loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, nhomVienChucService.suaNhomVienChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/nhom-vien-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, nhomVienChucService.xoaNhomVienChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    class HeSoLuongCongChucController {
        @GetMapping("/he-so-luong-cong-chuc")
        public ResponseEntity<ResDTO<List<HeSoLuongCongChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, heSoLuongCongChucService.xemHeSoLuongCongChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/he-so-luong-cong-chuc")
        public ResponseEntity<ResDTO<HeSoLuongCongChuc>> add(@RequestBody ReqHeSoLuong loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, heSoLuongCongChucService.themHeSoLuongCongChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/he-so-luong-cong-chuc/{id}")
        public ResponseEntity<ResDTO<HeSoLuongCongChuc>> edit(@PathVariable int id, @RequestBody ReqHeSoLuong loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, heSoLuongCongChucService.suaHeSoLuongCongChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/he-so-luong-cong-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, heSoLuongCongChucService.xoaHeSoLuongCongChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    class HeSoLuongVienChucController {
        @GetMapping("/he-so-luong-vien-chuc")
        public ResponseEntity<ResDTO<List<HeSoLuongVienChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, heSoLuongVienChucService.xemHeSoLuongVienChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/he-so-luong-vien-chuc")
        public ResponseEntity<ResDTO<HeSoLuongVienChuc>> add(@RequestBody ReqHeSoLuong loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, heSoLuongVienChucService.themHeSoLuongVienChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/he-so-luong-vien-chuc/{id}")
        public ResponseEntity<ResDTO<HeSoLuongVienChuc>> edit(@PathVariable int id, @RequestBody ReqHeSoLuong loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, heSoLuongVienChucService.suaHeSoLuongVienChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/he-so-luong-vien-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, heSoLuongVienChucService.xoaHeSoLuongVienChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    class NgachCongChucController {
        @GetMapping("/ngach-cong-chuc")
        public ResponseEntity<ResDTO<List<NgachCongChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ngachCongChucService.xemNgachCongChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/ngach-cong-chuc")
        public ResponseEntity<ResDTO<NgachCongChuc>> add(@RequestBody ReqNgach loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, ngachCongChucService.themNgachCongChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/ngach-cong-chuc/{id}")
        public ResponseEntity<ResDTO<NgachCongChuc>> edit(@PathVariable String id, @RequestBody ReqNgach loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, ngachCongChucService.suaNgachCongChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/ngach-cong-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable String id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, ngachCongChucService.xoaNgachCongChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    class NgachVienChucController {
        @GetMapping("/ngach-vien-chuc")
        public ResponseEntity<ResDTO<List<NgachVienChuc>>> getAll() {
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, ngachVienChucService.xemNgachVienChuc()), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/ngach-vien-chuc")
        public ResponseEntity<ResDTO<NgachVienChuc>> add(@RequestBody ReqNgach loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_THANH_CONG, ngachVienChucService.themNgachVienChuc(loai)), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/ngach-vien-chuc/{id}")
        public ResponseEntity<ResDTO<NgachVienChuc>> edit(@PathVariable String id, @RequestBody ReqNgach loai) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG, ngachVienChucService.suaNgachVienChuc(id, loai)), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/ngach-vien-chuc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable String id) {
            return new ResponseEntity<>(ResDTO.response(ResEnum.XOA_THANH_CONG, ngachVienChucService.xoaNgachVienChuc(id)), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }
}
