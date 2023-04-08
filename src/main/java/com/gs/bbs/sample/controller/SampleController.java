package com.gs.bbs.sample.controller;

import com.gs.bbs.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/sample")
public class SampleController {

    @Autowired
    SampleService sampleService;

    @GetMapping
    public Map<String, Object> getSample(){

        return sampleService.getSample();
    }
}
