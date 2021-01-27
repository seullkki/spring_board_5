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
	public void list(Model model) {									// void : list.jsp를 리턴함 = 함수명으로 리턴해줌
		log.info("list");											// public String list(Model model){ ... return "list";}와 동일
		model.addAttribute("list", boardService.getList());			// list.jsp는 views에 이전에 만들던 방법과 똑같이 생성해주면 됨 = jsp의 EL로 list를 쓰는 것도 여기서 Model에 list를 넣었기 때문에 동일
	}
	
	@GetMapping("/writeView")
	public void writeView() {
		log.info("writeView");
	}
	
	@GetMapping("/write")						
	public String write(BoardVO boardVO, Model model) {		// 커멘드 객체(BoardVO)로 받아오는 것이 좋음
		log.info("write");
		
		boardService.writeBoard(boardVO);
		
		return "redirect:list";
	}
	
	@GetMapping("/ContentView")				// 미완성 - NumberFormatException: For input string: "bId" 에러 발생
	public void ContentView(Model model) {
		model.addAttribute("content_view", boardService.getList());
		
	}
	
}
