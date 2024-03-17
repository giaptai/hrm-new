//package sgu.hrm.module_soyeulylich.controllers;
//
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import sgu.hrm.module_soyeulylich.dto.request.ReqSoYeuLyLich;
//import sgu.hrm.response.ResDTO;
//import sgu.hrm.response.ResEnum;
//
//import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
//import sgu.hrm.module_soyeulylich.dto.request.ReqDSSoYeuLyLich;
//import sgu.hrm.module_soyeulylich.dto.response.ResSoYeuLyLich;
//
//import sgu.hrm.module_soyeulylich.services.ISoYeuLyLichService;
//
//import java.util.List;
//import java.util.UUID;
//
//
//@RestController
//@RequestMapping(value = "/nhan-vien")
//@Tag(name = "Admin so-yeu-ly-lich", description = "Quản lý")
//@SecurityRequirement(name = "Bearer Authentication")
//@RequiredArgsConstructor
//public class AdminSoYeuLyLichController {
//    private final ISoYeuLyLichService soYeuLyLichService;
//
//    @GetMapping("/so-yeu-ly-lich")
//    public ResponseEntity<ResDTO<List<ResSoYeuLyLich>>> getAll() {
//        List<ResSoYeuLyLich> resSoYeuLyLichs = soYeuLyLichService.xemDanhSachSoYeuLyLich().stream().map(ResSoYeuLyLich::mapToResSoYeuLyLich).toList();
//        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resSoYeuLyLichs), ResEnum.THANH_CONG.getStatusCode());
//    }
//
//    @GetMapping("/so-yeu-ly-lich/tim-kiem")
//    public ResponseEntity<ResDTO<SoYeuLyLich>> getBySoCCCDOrId(@RequestParam(name = "q") String q) {
//        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, soYeuLyLichService.xemSoYeuLyLichTheoSoCCCDHoacID(q)), ResEnum.THANH_CONG.getStatusCode());
//    }
//
//    @GetMapping("/so-yeu-ly-lich/{id}")
//    public ResponseEntity<ResDTO<ResSoYeuLyLich>> getById(@PathVariable(name = "id") UUID id) {
//        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
//                ResSoYeuLyLich.mapToResSoYeuLyLich(soYeuLyLichService.xemSoYeuLyLichTheoId(id))), ResEnum.THANH_CONG.getStatusCode());
//    }
//
//    @Transactional
//    @PatchMapping("/so-yeu-ly-lich/{id}")
//    public ResponseEntity<ResDTO<ResSoYeuLyLich>> editById(@PathVariable(name = "id") UUID id, @RequestBody ReqSoYeuLyLich lyLich) {
//        return new ResponseEntity<>(ResDTO.response(ResEnum.CAP_NHAT_THANH_CONG,
//                ResSoYeuLyLich.mapToResSoYeuLyLich(soYeuLyLichService.capNhatTheoId(id, lyLich))), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
//    }
//
//    @Transactional
//    @PatchMapping("/so-yeu-ly-lich/phe-duyet")
//    public ResponseEntity<ResDTO<List<ResSoYeuLyLich>>> edit(@PathVariable(name = "id", required = false) String id,
//                                                             @RequestBody List<ReqDSSoYeuLyLich> reqDSSoYeuLyLich) {
//        List<ResSoYeuLyLich> resSoYeuLyLichs = soYeuLyLichService.pheDuyetSoYeuLyLich(reqDSSoYeuLyLich).stream().map(ResSoYeuLyLich::mapToResSoYeuLyLich).toList();
//        return new ResponseEntity<>(ResDTO.response(ResEnum.PHE_DUYET_THANH_CONG, resSoYeuLyLichs), ResEnum.PHE_DUYET_THANH_CONG.getStatusCode());
//    }
//}