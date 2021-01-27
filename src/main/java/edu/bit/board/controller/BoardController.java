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

import edu.bit.board.service.BoardService;
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
	public void list(Model model) throws Exception {									// void : list.jsp를 리턴함 = 함수명으로 리턴해줌
		log.info("list");											// public String list(Model model){ ... return "list";}와 동일
		model.addAttribute("list", boardService.getList());			// list.jsp는 views에 이전에 만들던 방법과 똑같이 생성해주면 됨 = jsp의 EL로 list를 쓰는 것도 여기서 Model에 list를 넣었기 때문에 동일
	}
	
	@GetMapping("/writeView")
	public void writeView() throws Exception {
		log.info("writeView");
	}
	
	@GetMapping("/write")						
	public String write(BoardVO boardVO, Model model) throws Exception {		// 커멘드 객체(BoardVO)로 받아오는 것이 좋음
		log.info("write");
		
		boardService.writeBoard(boardVO);
		
		return "redirect:list";								// return값을 직접 주고 싶다면 redirect + 메소드
	}														// Q. 원래 있던 페이지로 다시 돌릴 때만 redirect 쓰는 건가?
															// A.  예를 들어 게시판을 작성하는 과정이라고 할 때, 사용자가 보낸 요청 정보를 이용하여 글쓰기 기능을 수행한다고 할 때, redirect를 사용하여 응답 페이지를 부르면 사용자가 실수 혹은 고의로 글쓰기 응답 페이지에서 새로고침을 누른다고 하더라도, 처음의 요청 정보는 존재하지 않으므로 게시물이 여러 번 등록되지 않습니다. 그렇기 때문에 시스템에 변화가 생기는 요청(회원가입, 글쓰기 등)의 경우에는 redirection을 사용하는 것이 바랍직합니다.
	
	
	 @GetMapping("/ContentView") 
	 public String ContentView(BoardVO boardVO, Model model) throws Exception {
		 log.info("content_view");
		
		 boardService.addHit(boardVO);								// 구현한 히트 메소드를 여기에 넣기
	     model.addAttribute("content_view", boardService.getBoard(boardVO.getbId()));
	     return "ContentView";
	 }
	 
	
	@GetMapping("/modify")													// 미완성 / 수정은 bId, bName, bTitle, bContent 가져가야 함
	public String Modify(BoardVO boardVO) throws Exception {				// jsp에 출력할 필요가 없으니 model은 제외하겠음
		boardService.modify(boardVO);										// 이해 : /xx로 접근해서 들어온 데이터를 BoardVO에 담아서 서비스로 넘긴다	
		
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
		boardService.replyShape(boardVO);									// 구현한 replyShape 여기에 넣기
		boardService.addReply(boardVO);
		
		return "redirect:list";
	 }
}
