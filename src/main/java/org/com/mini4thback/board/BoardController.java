package org.com.mini4thback.board;

import lombok.RequiredArgsConstructor;
import org.com.mini4thback.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true")
@RestController
@RequestMapping
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board/post")
    public ResponseEntity post(@RequestBody BoardDto.Post dto){
        boardService.post(dto);
        return ResponseEntity.ok("성공");
    }

    @GetMapping("/board/list")
    public ResponseEntity post(@RequestParam(name="page") int page){
        List<BoardDto.List> list = boardService.list(page);
        return ResponseEntity.ok().body(list);
    }

}
