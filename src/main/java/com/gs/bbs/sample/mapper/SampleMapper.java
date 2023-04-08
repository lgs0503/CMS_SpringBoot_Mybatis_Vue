package com.gs.bbs.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface SampleMapper {

    Map<String, Object> getSample();
}
