package org.com.mini4thback.board;

import lombok.RequiredArgsConstructor;
import org.com.mini4thback.board.model.Board;
import org.com.mini4thback.board.model.BoardDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void post(BoardDto.Post dto){
        Board entity = dto.toEntity();
        boardRepository.save(entity);
    }
}
