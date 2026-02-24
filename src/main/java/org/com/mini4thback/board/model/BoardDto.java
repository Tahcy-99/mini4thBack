package org.com.mini4thback.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BoardDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Post{
        private String title;
        private String content;
        private Long author;

        public Board toEntity (){
            return Board.builder()
                    .title(this.title)
                    .content(this.content)
                    .author(this.author)
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class List{
        private String title;
        private Long author;

        public static BoardDto.List toDto (Board entity){
            return List.builder().title(entity.getTitle()).author(entity.getAuthor()).build();
        }
    }
}
