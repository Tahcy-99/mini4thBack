package org.com.mini4thback.board;

import lombok.RequiredArgsConstructor;
import org.com.mini4thback.board.model.BoardDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true")
@RestController
@RequestMapping
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board/post")
    public ResponseEntity post(@RequestBody BoardDto.Post dto){
        boardService.post(dto);
        return ResponseEntity.ok("작성 완료");
    }

    @PostMapping("/board/edit")
    public ResponseEntity edit(@RequestBody BoardDto.Edit dto){
        try {
            boardService.edit(dto);
            return ResponseEntity.ok("수정 완료");
        }
        catch(NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("찾으시는 페이지가 존재하지 않습니다 :("+e);
        }
    }

    @GetMapping("/board/list")
    public ResponseEntity list(@RequestParam(name="page") int page){
        List<BoardDto.List> list = boardService.list(page);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/board/detail")
    public ResponseEntity detail(@RequestParam(name="postId") Long postId){
        try {
            BoardDto.Detail detail = boardService.detail(postId);
            return ResponseEntity.ok().body(detail);
        }
        catch(NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("찾으시는 페이지가 존재하지 않습니다 :("+e);
        }
    }

}
