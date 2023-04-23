package com.gs.bbs.board;

import com.gs.bbs.api.board.dto.BoardDto;
import com.gs.bbs.api.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class BoardTest {

    private final BoardService boardService;

    @Autowired
    public BoardTest(BoardService boardService) {
        this.boardService = boardService;
    }

    @DisplayName("게시판 리스트 조회")
    @Test
    public void getBoardList() {

        BoardDto boardDto = new BoardDto();
        boardDto.setUseYn("Y");

        boardService.getBoardList(boardDto);

    }

    @DisplayName("게시판 조회")
    @Test
    public void getBoard() {
        boardService.getBoard(1);
    }

    @DisplayName("게시판 추가")
    @Test
    public void insertBoard() {

        BoardDto boardDto = new BoardDto();
        boardDto.setName("테스트 게시판");
        boardDto.setType("BT001");
        boardDto.setCreateUser("Junit_Test");

        boardService.insertBoard(boardDto);

        getBoardList();
    }

    @DisplayName("게시판 수정")
    @Test
    public void updateBoard() {

        BoardDto boardDto = new BoardDto();
        boardDto.setBoardId(2);
        boardDto.setName("테스트 게시판 수정");
        boardDto.setType("BT002");
        boardDto.setUpdateUser("Junit_Test");

        boardService.updateBoard(boardDto);

        getBoardList();
    }

    @DisplayName("게시판 삭제")
    @Test
    public void deleteBoard() {

        List<Integer> boardIds = new ArrayList<Integer>();

        boardIds.add(2);

        boardService.deleteBoard(boardIds);

        getBoardList();
    }
}
