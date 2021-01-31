package edu.bit.board.service;

import java.util.List;

import edu.bit.board.vo.PagingVO;
import edu.bit.board.vo.BoardVO;

public interface BoardService {			// Ŀ���� 'Service'�� �θ�
	public List<BoardVO> getList();		// list ����

	public void writeBoard(BoardVO boardVO);		// write ����

	public BoardVO getBoard(int getbId);			// contentView ����

	public void modify(BoardVO boardVO);			// modify ����

	public void delete(int getbId);					// delete ���� / ���� ����

	public BoardVO getContent(int getbId);

	public void addReply(BoardVO boardVO);

	//public void replyShape(BoardVO boardVO);		// ServicImpl���� �����ϵ��� ��

	//public void addHit(BoardVO boardVO);

	// �Խù� �� ����
	public int countBoard();

	// ����¡ ó�� �Խñ� ��ȸ
	public List<BoardVO> selectBoard(PagingVO vo);			

			
}
