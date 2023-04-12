package com.gs.bbs.api.code.mapper;

import com.gs.bbs.api.code.dto.CodeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CodeMapper {

    List<CodeDTO> getCodeList(CodeDTO codeDTO);

    CodeDTO getCode(int codeId);

    int insertCode(CodeDTO codeDTO);

    int updateCode(CodeDTO codeDTO);

    int deleteCode(List<Integer> codeIds);

}
