package edu.bit.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	// ��ü�� ���������� �ʾƵ� ������ ���� ����
   	// ������ 5.0���ʹ� @Autowired,  @Inject �� ��� �����ڷ� ��� �ִ� ���� mapper�� �ڵ����� ������ ����
   	// @Autowired,  @Inject�� mapper�� �����͸� ���Խ����ִ� ����

    private BoardMapper mapper;

	@Override
    public List<BoardVO> getList(){
        return mapper.getList();
    }
	
	@Override
    public void writeBoard(BoardVO boardVO){
        mapper.insert(boardVO);
    }
}
