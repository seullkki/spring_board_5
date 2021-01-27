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


@Log4j					// log�� ����� �� �ֵ��� ���ִ� ������̼� = �ֿܼ� ����� �� System.out.println ��� 
@AllArgsConstructor
@Controller
public class BoardController {
	
	private BoardService boardService;
	
	// post�� �޴� ��쿡�� @postMapping
	@GetMapping("/list")
	public void list(Model model) {									// void : list.jsp�� ������ = �Լ������� ��������
		log.info("list");											// public String list(Model model){ ... return "list";}�� ����
		model.addAttribute("list", boardService.getList());			// list.jsp�� views�� ������ ����� ����� �Ȱ��� �������ָ� �� = jsp�� EL�� list�� ���� �͵� ���⼭ Model�� list�� �־��� ������ ����
	}
	
	@GetMapping("/writeView")
	public void writeView() {
		log.info("writeView");
	}
	
	@GetMapping("/write")						
	public String write(BoardVO boardVO, Model model) {		// Ŀ��� ��ü(BoardVO)�� �޾ƿ��� ���� ����
		log.info("write");
		
		boardService.writeBoard(boardVO);
		
		return "redirect:list";
	}
	
	@GetMapping("/ContentView")				// �̿ϼ� - NumberFormatException: For input string: "bId" ���� �߻�
	public void ContentView(Model model) {
		model.addAttribute("content_view", boardService.getList());
		
	}
	
}
