package com.gs.bbs.api.board.mapper;

import com.gs.bbs.api.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto> getBoardList(BoardDto boardDto);

    BoardDto getBoard(int boardId);

    int insertBoard(BoardDto boardDto);

    int updateBoard(BoardDto boardDto);

    int deleteBoard(List<Integer> boardIds);

}
