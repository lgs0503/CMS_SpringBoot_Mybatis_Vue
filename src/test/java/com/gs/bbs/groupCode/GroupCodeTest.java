package com.gs.bbs.groupCode;

import com.gs.bbs.api.groupCode.dto.GroupCodeDTO;
import com.gs.bbs.api.groupCode.service.GroupCodeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class GroupCodeTest {

    @Autowired
    GroupCodeService groupCodeService;

    @Test
    @DisplayName("그룹코드 리스트 조회")
    public void getGroupCodeList(){

        GroupCodeDTO groupCodeDTO = new GroupCodeDTO();
        groupCodeDTO.setUseYn("Y");

        List<GroupCodeDTO> groupCodeList = groupCodeService.getGroupCodeList(groupCodeDTO);

        for (GroupCodeDTO groupCode : groupCodeList) {
            log.debug(groupCode.toString());
        }
    }

    @Test
    @DisplayName("그룹코드 추가")
    public void insertGroupCode(){

        GroupCodeDTO groupCodeDTO = new GroupCodeDTO();
        groupCodeDTO.setName("테스트그룹코드");
        groupCodeDTO.setUseYn("Y");
        groupCodeDTO.setCreateUser("JunitTest");

        int result = groupCodeService.insertGroupCode(groupCodeDTO);

        getGroupCodeList();

        log.debug("insertGroupCode Result : " + result);

    }

    @Test
    @DisplayName("그룹코드 수정")
    public void updateGroupCode(){

        GroupCodeDTO groupCodeDTO = new GroupCodeDTO();
        groupCodeDTO.setGroupCodeId(2);
        groupCodeDTO.setName("테스트그룹코드 수정 테스트");
        groupCodeDTO.setUseYn("Y");
        groupCodeDTO.setUpdateUser("JunitTest");

        int result = groupCodeService.updateGroupCode(groupCodeDTO);

        log.debug("updateGroupCode Result : " + result);

        getGroupCodeList();
    }


    @Test
    @DisplayName("그룹코드 삭제")
    public void deleteGroupCode(){

        List<Integer> groupCodeIds = new ArrayList<Integer>();

        groupCodeIds.add(2);

        groupCodeService.deleteGroupCode(groupCodeIds);

        getGroupCodeList();
    }
}
