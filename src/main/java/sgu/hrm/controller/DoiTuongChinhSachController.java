package sgu.hrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.models.DoiTuongChinhSach;
import sgu.hrm.models.TinhTrangSucKhoe;
import sgu.hrm.repository.DoiTuongChinhSachRepository;
import sgu.hrm.repository.TinhTrangSucKhoeRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/doi-tuong-chinh-sach")
public class DoiTuongChinhSachController {

    private DoiTuongChinhSachRepository doiTuongChinhSachRepository;

    public DoiTuongChinhSachController(DoiTuongChinhSachRepository doiTuongChinhSachRepository) {
        this.doiTuongChinhSachRepository = doiTuongChinhSachRepository;
    }

    @GetMapping("")
    public List<DoiTuongChinhSach> getAllDoiTuongChinhSach() {
        return doiTuongChinhSachRepository.findAll();
    }

}