package edu.bit.board.service;

import java.util.List;
import edu.bit.board.vo.BoardVO;

public interface BoardService {			// 커멘드는 'Service'로 부름
	public List<BoardVO> getList();		// list 서비스

	public void writeBoard(BoardVO boardVO);		// write 서비스
}
