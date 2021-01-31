package edu.bit.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.PagingVO;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j					// log를 사용할 수 있도록 해주는 어노테이션 = 콘솔에 출력할 때 System.out.println 대신 
@AllArgsConstructor
@Controller
public class BoardController {
	
	private BoardService boardService;
	
	// post로 받는 경우에는 @postMapping
	@GetMapping("/list")
	public String list(PagingVO vo, Model model
	 		, @RequestParam(value="nowPage", required=false)String nowPage
	 		, @RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception {									// void : list.jsp를 리턴함 = 함수명으로 리턴해줌
		log.info("list");											
		
		
		int total = boardService.countBoard();
	 	if (nowPage == null && cntPerPage == null) {
	 		nowPage = "1";
	 		cntPerPage = "5";
	 	} else if (nowPage == null) {
	 		nowPage = "1";
	 	} else if (cntPerPage == null) { 
	 		cntPerPage = "5";
	 	}
	 	vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
	 	model.addAttribute("paging", vo);
		
		
		//model.addAttribute("list", boardService.getList());		// 기존의 list 가져오는 메소드가 아니라, paging을 거쳐 가져오기 위해 아래 방법을 사용 (boardVO는 SQL에서만 처리해줌)	
		model.addAttribute("list", boardService.selectBoard(vo));
		return "list";
	}
	
	@GetMapping("/writeView")
	public void writeView() throws Exception {
		log.info("writeView");
	}
	
	@GetMapping("/write")						
	public String write(BoardVO boardVO, Model model) throws Exception {		
		log.info("write");
		
		boardService.writeBoard(boardVO);
		
		return "redirect:list";								
	}														
														
	
	
	 @GetMapping("/ContentView") 
	 public String ContentView(BoardVO boardVO, Model model) throws Exception {
		 log.info("content_view");
		
		 //boardService.addHit(boardVO);								// 구현한 히트 메소드를 여기에 넣기 → service로 이동
	     model.addAttribute("content_view", boardService.getBoard(boardVO.getbId()));
	     return "ContentView";
	 }
	 
	
	@GetMapping("/modify")													
	public String Modify(BoardVO boardVO) throws Exception {				
		boardService.modify(boardVO);										
		
		return "redirect:list";
	}
	
	
	 @GetMapping("/delete") 
	 public String Delete(BoardVO boardVO) throws Exception {
		 log.info("Delete");
		 
		 boardService.delete(boardVO.getbId());
	      
	     return "redirect:list";
	 }
	 
	 @GetMapping("/ReplyView") 
	 public void ReplyView(BoardVO boardVO, Model model) throws Exception {
		 log.info("ReplyView");
		 
		 model.addAttribute("reply_view", boardService.getContent(boardVO.getbId()));
	 }
	 
	 @GetMapping("/reply") 
	 public String Reply(BoardVO boardVO) throws Exception {
		 log.info("Reply");
		//boardService.replyShape(boardVO);									// 구현한 replyShape 여기에 넣기 → service로 이동
		boardService.addReply(boardVO);
		
		return "redirect:list";
	 }
	 
	 // 페이징 처리
//	 @GetMapping("boardList")
//	 public String boardList(PagingVO vo, Model model
//	 		, @RequestParam(value="nowPage", required=false)String nowPage
//	 		, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
//	 	
//	 	int total = boardService.countBoard();
//	 	if (nowPage == null && cntPerPage == null) {
//	 		nowPage = "1";
//	 		cntPerPage = "5";
//	 	} else if (nowPage == null) {
//	 		nowPage = "1";
//	 	} else if (cntPerPage == null) { 
//	 		cntPerPage = "5";
//	 	}
//	 	vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
//	 	model.addAttribute("paging", vo);
//	 	model.addAttribute("viewAll", boardService.selectBoard(vo));
//	 	return "board/boardPaging";
//	 }
}
