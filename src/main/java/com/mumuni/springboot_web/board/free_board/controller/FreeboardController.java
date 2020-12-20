package com.mumuni.springboot_web.board.free_board.controller;

import com.mumuni.springboot_web.board.IdResult;
import com.mumuni.springboot_web.board.free_board.service.FreeboardService;
import com.mumuni.springboot_web.board.BoardDefaultSingleResult;
import com.mumuni.springboot_web.vo.FreeBoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board/freeboard")
public class FreeboardController {
    private final FreeboardService service;

    @GetMapping("getPost")
    public BoardDefaultSingleResult<FreeBoardVO> getPost(@RequestParam Long id) {
        return service.getPost(id);
    }

    @PostMapping("insertPost")
    public BoardDefaultSingleResult<IdResult> insertPost(@RequestBody FreeBoardVO vo) {
        return service.insertPost(vo);
    }

    @PutMapping("updatePost")
    public BoardDefaultSingleResult<IdResult> updatePost(@RequestBody FreeBoardVO vo) {
        return service.updatePost(vo);
    }

    @DeleteMapping("deletePost")
    public BoardDefaultSingleResult<IdResult> deletePost(@RequestBody FreeBoardVO vo) {
        return service.deletePost(vo);
    }
}
