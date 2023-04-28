package com.gs.bbs.sample.controller;

import com.gs.bbs.sample.service.SampleService;
import com.gs.bbs.util.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/sample")
@Tag(name = "Sample", description = "샘플 api")
public class SampleController {

    @Autowired
    SampleService sampleService;

    @Operation(summary = "샘플조회", description = "샘플조회 메서드입니다.")
    @GetMapping
    public ResponseEntity<ResponseDTO> getSample(){

        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, "getSampleSuccess", sampleService.getSample()));
    }
}
