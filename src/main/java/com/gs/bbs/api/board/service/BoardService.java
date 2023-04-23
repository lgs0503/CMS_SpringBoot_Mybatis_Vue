package com.gs.bbs.api.board.service;

import com.gs.bbs.api.board.dto.BoardDto;

import java.util.List;

public interface BoardService {

    List<BoardDto> getBoardList(BoardDto boardDto);

    BoardDto getBoard(int boardId);

    int insertBoard(BoardDto boardDto);

    int updateBoard(BoardDto boardDto);

    int deleteBoard(List<Integer> boardIds);

}
