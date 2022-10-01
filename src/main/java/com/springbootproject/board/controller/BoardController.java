package com.springbootproject.board.controller;

import com.springbootproject.board.Service.BoardService;
import com.springbootproject.board.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") // localhost:8080/board/write
    public String boardWriteForm() {

        return "boardwrite";    // 요청에 대한 응답으로 html 문서를 반환
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) {

        boardService.write(board);
        System.out.println(board.getTitle());

        return "";
    }

}
