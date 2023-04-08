package com.gs.bbs.sample.service;

import com.gs.bbs.sample.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SampleServiceImpl implements SampleService{

    @Autowired
    SampleMapper sampleMapper;

    @Override
    public Map<String, Object> getSample() {
        return sampleMapper.getSample();
    }
}
