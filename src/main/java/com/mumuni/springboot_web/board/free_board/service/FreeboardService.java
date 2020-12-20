package com.mumuni.springboot_web.board.free_board.service;

import com.mumuni.springboot_web.board.BoardDefaultSingleResult;
import com.mumuni.springboot_web.board.IdResult;
import com.mumuni.springboot_web.dao.BoardMapper;
import com.mumuni.springboot_web.vo.FreeBoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@Slf4j
@Service
public class FreeboardService {
    @Autowired
    private BoardMapper boardMapper;

    public BoardDefaultSingleResult<IdResult> insertPost(FreeBoardVO boardVO) {
        int count = boardMapper.insertPost(boardVO);
        Long post_id = boardVO.getId();
        BoardDefaultSingleResult<IdResult> vo;
        if(count <= 0) {
            vo = BoardDefaultSingleResult.<IdResult>builder()
                    .resultCode(400)
                    .order("Insert Board")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .build();
        }
        else {
            vo = BoardDefaultSingleResult.<IdResult>builder()
                    .resultCode(200)
                    .order("Insert Board")
                    .requestTime(LocalDateTime.now())
                    .data(new IdResult(post_id))
                    .build();
        }
        return vo;
    }

    public BoardDefaultSingleResult<IdResult> updatePost(FreeBoardVO boardVO) {
        int count = boardMapper.updatePost(boardVO);
        Long post_id = boardVO.getId();
        BoardDefaultSingleResult<IdResult> vo;
        if(count <= 0) {
            vo = BoardDefaultSingleResult.<IdResult>builder()
                    .resultCode(400)
                    .order("Update Board")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .build();
        }
        else {
            vo = BoardDefaultSingleResult.<IdResult>builder()
                    .resultCode(200)
                    .order("Update Board")
                    .requestTime(LocalDateTime.now())
                    .data(new IdResult(post_id))
                    .build();
        }
        return vo;
    }

    public BoardDefaultSingleResult<IdResult> deletePost(FreeBoardVO boardVO) {
        int count = boardMapper.deletePost(boardVO);
        Long post_id = boardVO.getId();
        BoardDefaultSingleResult<IdResult> vo;
        if(count <= 0) {
            vo = BoardDefaultSingleResult.<IdResult>builder()
                    .resultCode(400)
                    .order("Delete Board")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .build();
        }
        else {
            vo = BoardDefaultSingleResult.<IdResult>builder()
                    .resultCode(200)
                    .order("Delete Board")
                    .requestTime(LocalDateTime.now())
                    .data(new IdResult(post_id))
                    .build();
        }
        return vo;
    }

    public BoardDefaultSingleResult<FreeBoardVO> getPost(Long id) {
        BoardDefaultSingleResult<FreeBoardVO> vo;
        try {
            FreeBoardVO data = boardMapper.selectPost(id);
            if(data == null) {
                vo = BoardDefaultSingleResult.<FreeBoardVO>builder()
                        .resultCode(404)
                        .order("Get Post")
                        .requestTime(LocalDateTime.now())
                        .data(null)
                        .build();
                log.info("fail to run getPost : none post");
            }
            else {
                vo = BoardDefaultSingleResult.<FreeBoardVO>builder()
                        .resultCode(200)
                        .order("Get Post")
                        .requestTime(LocalDateTime.now())
                        .data(data)
                        .build();
                log.info("Success to run getPost");
            }
        }catch(DateTimeParseException e) {
            vo = BoardDefaultSingleResult.<FreeBoardVO> builder()
                    .resultCode(410)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .build();
            log.error("Fail to run getPost -> ", e);
        }catch (Exception e) {
            vo = BoardDefaultSingleResult.<FreeBoardVO> builder()
                    .resultCode(444)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .build();
            log.error("Fail to run getPost -> ", e);
        }
        return vo;
    }
}
