package com.gs.bbs.sample;

import com.gs.bbs.sample.mapper.SampleMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Slf4j
public class SampleMapperTest {

    @Autowired
    SampleMapper sampleMapper;

    @Test
    @DisplayName("SampleMapper 테스트")
    public void getSample(){
        Map<String, Object> sample =  sampleMapper.getSample();

        log.info(sample.get("col1").toString());
        log.info(sample.get("col2").toString());
    }

}
