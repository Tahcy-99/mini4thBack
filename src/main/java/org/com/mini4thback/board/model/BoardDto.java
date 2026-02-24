package org.com.mini4thback.board.model;

import lombok.*;
import org.checkerframework.checker.units.qual.A;

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
    public static class Edit{
        @Setter
        private Long idx;
        private String title;
        private String content;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class List{
        private Long idx;
        private String title;
        private Long author;

        public static BoardDto.List toDto (Board entity){
            return List.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .author(entity.getAuthor())
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Detail{
        private Long idx;
        private String title;
        private String content;
        private Long author;

        public static BoardDto.Detail toDto (Board entity){
            return Detail.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .content(entity.getContent())
                    .author(entity.getAuthor())
                    .build();
        }
    }
}
