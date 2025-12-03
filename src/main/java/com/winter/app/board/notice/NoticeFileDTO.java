package com.winter.app.board.notice;

import com.winter.app.board.BoardFileDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeFileDTO extends BoardFileDTO{

	private Long boardNum;
}
