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

	@Override
	public BoardVO getBoard(int bno) {
		log.info("getBoard");
		
		return mapper.read(bno);
	}

	@Override
	public void modify(BoardVO boardVO) {
		mapper.modifyBoard(boardVO);			// ���� : ���� ������ ���ư��� ���� �ƴϹǷ� return�� ���� �ʴ´�
	}

	@Override
	public void delete(int getbId) {
		mapper.deleteBoard(getbId);
	}

	@Override
	public BoardVO getContent(int getbId) {
		return mapper.replyView(getbId);
		
	}

	@Override
	public void addReply(BoardVO boardVO) {
		mapper.reply(boardVO);
	}

	@Override
	public void replyShape(BoardVO boardVO) {
		mapper.replySort(boardVO);
	}

	@Override
	public void addHit(BoardVO boardVO) {
		mapper.hit(boardVO);
	}


}
