package org.com.mini4thback.board;

import lombok.RequiredArgsConstructor;
import org.com.mini4thback.board.model.Board;
import org.com.mini4thback.board.model.BoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void post(BoardDto.Post dto){
        Board entity = dto.toEntity();
        boardRepository.save(entity);
    }

    public List<BoardDto.List> list(int pageNumber){
        Pageable listPerPage = PageRequest.of(pageNumber-1, 10, Sort.by("idx").ascending());
        Page<Board> resultEntity = boardRepository.findAll(listPerPage);
        Page<BoardDto.List> resultPage = resultEntity.map(BoardDto.List::toDto);
        return resultPage.getContent();
    }

}
