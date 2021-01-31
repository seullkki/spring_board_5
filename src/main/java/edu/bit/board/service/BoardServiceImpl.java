package edu.bit.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.PagingVO;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	// 객체를 생성해주지 않아도 데이터 주입 가능
   	// 스프링 5.0부터는 @Autowired,  @Inject 가 없어도 생성자로 담고 있는 것을 mapper에 자동으로 들어가도록 해줌
   	// @Autowired,  @Inject는 mapper에 데이터를 주입시켜주는 역할

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
		mapper.hit(bno);				// hit								
		return mapper.read(bno);
	}

	@Override
	public void modify(BoardVO boardVO) {
		mapper.modifyBoard(boardVO);			
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
		mapper.replySort(boardVO);			// replyShape				
		mapper.reply(boardVO);
	}

//	@Override
//	public void replyShape(BoardVO boardVO) {
//		mapper.replySort(boardVO);
//	}
//
//	@Override
//	public void addHit(BoardVO boardVO) {
//		mapper.hit(boardVO);
//	}

	// 게시물 총 갯수
	@Override
	public int countBoard() {
		return mapper.countBoard();
	}
	
	// 페이징 처리 게시글 조회
	@Override
	public List<BoardVO> selectBoard(PagingVO vo) {
		return mapper.selectBoard(vo);
	}
}
