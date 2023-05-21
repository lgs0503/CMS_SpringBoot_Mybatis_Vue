package com.gs.bbs.api.code.service;

import com.gs.bbs.api.code.dto.CodeDTO;
import com.gs.bbs.api.code.mapper.CodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeServiceImpl implements CodeService{

    private final CodeMapper codeMapper;

    @Autowired
    public CodeServiceImpl(CodeMapper codeMapper) {
        this.codeMapper = codeMapper;
    }

    @Override
    public List<CodeDTO> getCodeList(CodeDTO codeDTO) {
        return codeMapper.getCodeList(codeDTO);
    }

    @Override
    public CodeDTO getCode(int codeId) {
        return codeMapper.getCode(codeId);
    }

    @Override
    public int insertCode(CodeDTO codeDTO) {
        return codeMapper.insertCode(codeDTO);
    }

    @Override
    public int updateCode(CodeDTO codeDTO) {
        return codeMapper.updateCode(codeDTO);
    }

    @Override
    public int deleteCode(List<Integer> codeIds) {
        return codeMapper.deleteCode(codeIds);
    }

    @Override
    public int deleteCodeGroupCodeId(int groupCodeId) {
        return codeMapper.deleteCodeGroupCodeId(groupCodeId);
    }
}
