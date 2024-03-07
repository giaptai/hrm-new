//package sgu.hrm.module_soyeulylich.controllers;
//
//import jakarta.transaction.Transactional;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import sgu.hrm.module_response.ResDTO;
//import sgu.hrm.module_response.ResEnum;
//import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
//import sgu.hrm.module_soyeulylich.models.request.ReqDSSoYeuLyLich;
//import sgu.hrm.module_soyeulylich.models.request.ReqSoYeuLyLich;
//import sgu.hrm.module_soyeulylich.models.response.ResDSSoYeuLyLich;
//import sgu.hrm.module_soyeulylich.models.response.ResSoYeuLyLich;
//import sgu.hrm.module_soyeulylich.services.ISoYeuLyLichService;
//import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqChuyenCongTacNhanVien;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping(value = "")
//public class SoYeuLyLichController {
//
//    private final ISoYeuLyLichService soYeuLyLichService;
//
//    public SoYeuLyLichController(ISoYeuLyLichService soYeuLyLichService) {
//        this.soYeuLyLichService = soYeuLyLichService;
//    }
//
//    //EMPLOYEE --- EMPLOYEE --- EMPLOYEE
//    @GetMapping("/ca-nhan/so-yeu-ly-lich")
//    public ResponseEntity<ResDTO<ResSoYeuLyLich>> so_yeu_ly_lich() {
//        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
//                ResSoYeuLyLich.mapToResSoYeuLyLich(soYeuLyLichService.xemThongTinSoYeuLyLich())), HttpStatus.OK);
//    }
//
//    @GetMapping("/ca-nhan/so-yeu-ly-lich-het")
//    public ResponseEntity<SoYeuLyLich> so_yeu_ly_lich_het() {
//        return new ResponseEntity<>(soYeuLyLichService.xemThongTinSoYeuLyLich(), HttpStatus.OK);
//    }
//
//    @PatchMapping("/ca-nhan/so-yeu-ly-lich")
//    public ResponseEntity<ResDTO<ResSoYeuLyLich>> so_yeu_ly_lich_cap_nhat(@RequestBody ReqSoYeuLyLich reqSoYeuLyLich) {
//        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
//                ResSoYeuLyLich.mapToResSoYeuLyLich(soYeuLyLichService.capNhatSoYeuLyLich(reqSoYeuLyLich))), HttpStatus.ACCEPTED);
//    }
//
//    //ADMIN --- ADMIN --- ADMIN
//    @GetMapping("/nhan-vien/so-yeu-ly-lich")
//    public ResponseEntity<ResDTO<List<ResSoYeuLyLich>>> getAllSoYeuLyLich() {
//        List<ResSoYeuLyLich> resSoYeuLyLichs = soYeuLyLichService.xemDanhSachSoYeuLyLich().stream().map(ResSoYeuLyLich::mapToResSoYeuLyLich).toList();
//        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resSoYeuLyLichs), HttpStatus.ACCEPTED);
//    }
//
//    @GetMapping("/nhan-vien/so-yeu-ly-lich/tim-kiem")
//    public ResponseEntity<ResDTO<ResSoYeuLyLich>> getSoYeuLyLichSoCCCDOrId(@RequestParam(name = "q") String q) {
//        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
//                ResSoYeuLyLich.mapToResSoYeuLyLich(soYeuLyLichService.xemSoYeuLyLichTheoSoCCCDHoacID(q))), HttpStatus.OK);
//    }
//
//    @GetMapping("/nhan-vien/so-yeu-ly-lich/{id}")
//    public ResponseEntity<ResDTO<ResSoYeuLyLich>> getSoYeuLyLichById(@PathVariable(name = "id") String id) {
//        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
//                ResSoYeuLyLich.mapToResSoYeuLyLich(soYeuLyLichService.xemSoYeuLyLichTheoId(id))), HttpStatus.OK);
//    }
//
//    @PatchMapping("/nhan-vien/so-yeu-ly-lich/phe-duyet")
//    @Transactional
//    public ResponseEntity<ResDTO<List<ResSoYeuLyLich>>> editSoYeuLyLich(@PathVariable(name = "id", required = false) String id,
//                                                                        @RequestBody List<ReqDSSoYeuLyLich> reqDSSoYeuLyLich) {
//        List<ResSoYeuLyLich> resSoYeuLyLichs = soYeuLyLichService.pheDuyetSoYeuLyLich(reqDSSoYeuLyLich).stream().map(ResSoYeuLyLich::mapToResSoYeuLyLich).toList();
//        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resSoYeuLyLichs), HttpStatus.OK);
//    }
//}