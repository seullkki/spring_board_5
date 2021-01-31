package edu.bit.board.service;

import java.util.List;

import edu.bit.board.vo.PagingVO;
import edu.bit.board.vo.BoardVO;

public interface BoardService {			// 커멘드는 'Service'로 부름
	public List<BoardVO> getList();		// list 서비스

	public void writeBoard(BoardVO boardVO);		// write 서비스

	public BoardVO getBoard(int getbId);			// contentView 서비스

	public void modify(BoardVO boardVO);			// modify 서비스

	public void delete(int getbId);					// delete 서비스 / 위와 동일

	public BoardVO getContent(int getbId);

	public void addReply(BoardVO boardVO);

	//public void replyShape(BoardVO boardVO);		// ServicImpl에서 구현하도록 함

	//public void addHit(BoardVO boardVO);

	// 게시물 총 갯수
	public int countBoard();

	// 페이징 처리 게시글 조회
	public List<BoardVO> selectBoard(PagingVO vo);			

			
}
