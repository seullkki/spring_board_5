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


@Log4j					// log�� ����� �� �ֵ��� ���ִ� ������̼� = �ֿܼ� ����� �� System.out.println ��� 
@AllArgsConstructor
@Controller
public class BoardController {
	
	private BoardService boardService;
	
	// post�� �޴� ��쿡�� @postMapping
	@GetMapping("/list")
	public String list(PagingVO vo, Model model
	 		, @RequestParam(value="nowPage", required=false)String nowPage
	 		, @RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception {									// void : list.jsp�� ������ = �Լ������� ��������
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
		
		
		//model.addAttribute("list", boardService.getList());		// ������ list �������� �޼ҵ尡 �ƴ϶�, paging�� ���� �������� ���� �Ʒ� ����� ��� (boardVO�� SQL������ ó������)	
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
		
		 //boardService.addHit(boardVO);								// ������ ��Ʈ �޼ҵ带 ���⿡ �ֱ� �� service�� �̵�
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
		//boardService.replyShape(boardVO);									// ������ replyShape ���⿡ �ֱ� �� service�� �̵�
		boardService.addReply(boardVO);
		
		return "redirect:list";
	 }
	 
	 // ����¡ ó��
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
