package edu.bit.board.service;

import java.util.List;
import edu.bit.board.vo.BoardVO;

public interface BoardService {			// Ŀ���� 'Service'�� �θ�
	public List<BoardVO> getList();		// list ����

	public void writeBoard(BoardVO boardVO);		// write ����
}
