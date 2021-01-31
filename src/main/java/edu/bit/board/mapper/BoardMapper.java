package edu.bit.board.mapper;

import java.util.List;

import edu.bit.board.vo.PagingVO;
import edu.bit.board.vo.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getList();
	
	public void insert(BoardVO boardVO);			// write ��

	public BoardVO read(int bno);

	public void modifyBoard(BoardVO boardVO);

	public void deleteBoard(int getbId);

	public BoardVO replyView(int getbId);

	public void reply(BoardVO boardVO);

	public void replySort(BoardVO boardVO);

	public void hit(int bId);

	// �Խù� �� ����
	public int countBoard();

	// ����¡ ó�� �Խñ� ��ȸ
	public List<BoardVO> selectBoard(PagingVO vo);

}
