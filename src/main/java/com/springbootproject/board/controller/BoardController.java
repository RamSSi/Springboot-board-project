package com.springbootproject.board.controller;

import com.springbootproject.board.Service.BoardService;
import com.springbootproject.board.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
//        return "redirect:/board/list";
        return "redirect:/board/view?id=" + board.getId();
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList());

        return "boardlist";
    }

    @GetMapping("/board/view") // localhost:8080/board/view?id=1
    public String boardView(Model model, Integer id) {

        model.addAttribute("article", boardService.boardView(id));

        return "boardview";
    }

    @GetMapping("board/delete")
    public String boardDelete(Integer id) {
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }
}
