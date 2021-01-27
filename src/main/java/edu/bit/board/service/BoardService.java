package edu.bit.board.service;

import java.util.List;
import edu.bit.board.vo.BoardVO;

public interface BoardService {			// Ŀ���� 'Service'�� �θ�
	public List<BoardVO> getList();		// list ����

	public void writeBoard(BoardVO boardVO);		// write ����

	public BoardVO getBoard(int getbId);			// contentView ����

	public void modify(BoardVO boardVO);				// modify ����	/ ������Ÿ�� BoardVO �ƴұ�??? ó������ void�� ������

	public void delete(int getbId);				// delete ���� / ���� ����

	public BoardVO getContent(int getbId);

	public void addReply(BoardVO boardVO);

	public void replyShape(BoardVO boardVO);

	public void addHit(BoardVO boardVO);

				

			
}
