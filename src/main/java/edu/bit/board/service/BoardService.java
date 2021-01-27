package edu.bit.board.service;

import java.util.List;
import edu.bit.board.vo.BoardVO;

public interface BoardService {			// 커멘드는 'Service'로 부름
	public List<BoardVO> getList();		// list 서비스

	public void writeBoard(BoardVO boardVO);		// write 서비스

	public BoardVO getBoard(int getbId);			// contentView 서비스

	public void modify(BoardVO boardVO);				// modify 서비스	/ 데이터타입 BoardVO 아닐까??? 처음에는 void로 생성됨

	public void delete(int getbId);				// delete 서비스 / 위와 동일

	public BoardVO getContent(int getbId);

	public void addReply(BoardVO boardVO);

	public void replyShape(BoardVO boardVO);

	public void addHit(BoardVO boardVO);

				

			
}
