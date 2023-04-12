package com.gs.bbs.api.code.service;

import com.gs.bbs.api.code.dto.CodeDTO;

import java.util.List;

public interface CodeService {

    List<CodeDTO> getCodeList(CodeDTO codeDTO);

    CodeDTO getCode(int codeId);

    int insertCode(CodeDTO codeDTO);

    int updateCode(CodeDTO codeDTO);

    int deleteCode(List<Integer> codeIds);
}
