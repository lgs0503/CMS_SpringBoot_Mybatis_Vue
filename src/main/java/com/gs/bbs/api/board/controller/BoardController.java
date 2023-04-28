package com.gs.bbs.api.board.controller;

import com.gs.bbs.api.board.dto.BoardDto;
import com.gs.bbs.api.board.service.BoardService;
import com.gs.bbs.util.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@Slf4j
@Tag(name = "Board", description = "게시판 api")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @Operation(summary = "게시판 리스트 조회")
    @GetMapping
    private ResponseEntity<ResponseDTO> getBoardList(
            @RequestParam(value = "boardId", defaultValue = "0") int boardId,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "type", defaultValue = "") String type,
            @RequestParam(value = "useYn", defaultValue = "Y") String useYn
    ){

        BoardDto boardDto = new BoardDto();
        boardDto.setBoardId(boardId);
        boardDto.setName(name);
        boardDto.setType(type);
        boardDto.setUseYn(useYn);

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getBoardList Success",
                        boardService.getBoardList(boardDto)
                )
        );
    }

    @Operation(summary = "게시판 조회")
    @GetMapping("/{boardId}")
    private ResponseEntity<ResponseDTO> getBoard(@PathVariable("boardId") int boardId){
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getBoard Success",
                        boardService.getBoard(boardId)
                )
        );
    }

    @Operation(summary = "게시판 추가")
    @PostMapping
    private ResponseEntity<ResponseDTO> insertBoard(@RequestBody BoardDto boardDto){
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "insertBoard Success",
                        boardService.insertBoard(boardDto)
                )
        );
    }

    @Operation(summary = "게시판 수정")
    @PutMapping
    private ResponseEntity<ResponseDTO> updateBoard(@RequestBody BoardDto boardDto){
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "updateBoard Success",
                        boardService.updateBoard(boardDto)
                )
        );
    }

    @Operation(summary = "게시판 삭제")
    @DeleteMapping
    private ResponseEntity<ResponseDTO> deleteBoard(@RequestBody List<Integer> boardIds){
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "deleteBoard Success",
                        boardService.deleteBoard(boardIds)
                )
        );
    }
}
