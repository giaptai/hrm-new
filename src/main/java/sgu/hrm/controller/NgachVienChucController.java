package sgu.hrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgu.hrm.models.NgachVienChuc;
import sgu.hrm.repository.NgachVienChucRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/ngach-vien-chuc")
public class NgachVienChucController {

    private NgachVienChucRepository ngachVienChucRepository;

    public NgachVienChucController(NgachVienChucRepository ngachVienChucRepository) {
        this.ngachVienChucRepository = ngachVienChucRepository;
    }

    @GetMapping("")
    public List<NgachVienChuc> getAllNgachVienChuc() {
        return ngachVienChucRepository.findAll();
    }

}