package com.winter.app.board;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO extends CommentDTO{

    private Long boardNum;
    @NotBlank
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private LocalDate boardDate;
    private Long boardHit;
    
    private List<BoardFileDTO> fileDTOs;
}
