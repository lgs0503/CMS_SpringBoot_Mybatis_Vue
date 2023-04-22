package com.gs.bbs.code;

import com.gs.bbs.api.code.service.CodeService;
import com.gs.bbs.api.code.dto.CodeDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class CodeTest {

    private final CodeService codeService;

    @Autowired
    public CodeTest(CodeService codeService) {
        this.codeService = codeService;
    }

    @Test
    @DisplayName("코드 리스트 조회")
    public void getCodeList(){

        CodeDTO codeDTO = new CodeDTO();
        codeDTO.setUseYn("Y");

        codeService.getCodeList(codeDTO);
    }

    @Test
    @DisplayName("코드  조회")
    public void getCode(){
        codeService.getCode(1);
    }

    @Test
    @DisplayName("코드 추가")
    public void insertCode(){

        CodeDTO codeDTO = new CodeDTO();
        codeDTO.setGroupCodeId(2);
        codeDTO.setName("테스트코드추가");
        codeDTO.setValue1("test");
        codeDTO.setUseYn("Y");
        codeDTO.setSort(1);
        codeDTO.setCreateUser("JunitTest");

        codeService.insertCode(codeDTO);

        getCodeList();

    }

    @Test
    @DisplayName("코드 수정")
    public void updateCode(){

        CodeDTO codeDTO = new CodeDTO();
        codeDTO.setCodeId(3);
        codeDTO.setName("테스트코드 수정 테스트");
        codeDTO.setValue1("test 수정 테스트");
        codeDTO.setUseYn("Y");
        codeDTO.setUpdateUser("JunitTest");

        codeService.updateCode(codeDTO);

        getCodeList();
    }


    @Test
    @DisplayName("코드 삭제")
    public void deleteCode(){

        List<Integer> codeIds = new ArrayList<Integer>();

        codeIds.add(3);

        codeService.deleteCode(codeIds);

        getCodeList();
    }
}
