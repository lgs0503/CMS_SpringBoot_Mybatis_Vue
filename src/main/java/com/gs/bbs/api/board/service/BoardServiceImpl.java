package com.gs.bbs.api.board.service;

import com.gs.bbs.api.board.dto.BoardDto;
import com.gs.bbs.api.board.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public List<BoardDto> getBoardList(BoardDto boardDto) {
        return boardMapper.getBoardList(boardDto);
    }

    @Override
    public BoardDto getBoard(int boardId) {
        return boardMapper.getBoard(boardId);
    }

    @Override
    public int insertBoard(BoardDto boardDto) {
        return boardMapper.insertBoard(boardDto);
    }

    @Override
    public int updateBoard(BoardDto boardDto) {
        return boardMapper.updateBoard(boardDto);
    }

    @Override
    public int deleteBoard(List<Integer> boardIds) {
        return boardMapper.deleteBoard(boardIds);
    }
}
