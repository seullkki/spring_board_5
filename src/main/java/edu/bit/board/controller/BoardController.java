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
	public void list(Model model) throws Exception {									// void : list.jsp�� ������ = �Լ������� ��������
		log.info("list");											// public String list(Model model){ ... return "list";}�� ����
		model.addAttribute("list", boardService.getList());			// list.jsp�� views�� ������ ����� ����� �Ȱ��� �������ָ� �� = jsp�� EL�� list�� ���� �͵� ���⼭ Model�� list�� �־��� ������ ����
	}
	
	@GetMapping("/writeView")
	public void writeView() throws Exception {
		log.info("writeView");
	}
	
	@GetMapping("/write")						
	public String write(BoardVO boardVO, Model model) throws Exception {		// Ŀ��� ��ü(BoardVO)�� �޾ƿ��� ���� ����
		log.info("write");
		
		boardService.writeBoard(boardVO);
		
		return "redirect:list";								// return���� ���� �ְ� �ʹٸ� redirect + �޼ҵ�
	}														// Q. ���� �ִ� �������� �ٽ� ���� ���� redirect ���� �ǰ�?
															// A.  ���� ��� �Խ����� �ۼ��ϴ� �����̶�� �� ��, ����ڰ� ���� ��û ������ �̿��Ͽ� �۾��� ����� �����Ѵٰ� �� ��, redirect�� ����Ͽ� ���� �������� �θ��� ����ڰ� �Ǽ� Ȥ�� ���Ƿ� �۾��� ���� ���������� ���ΰ�ħ�� �����ٰ� �ϴ���, ó���� ��û ������ �������� �����Ƿ� �Խù��� ���� �� ��ϵ��� �ʽ��ϴ�. �׷��� ������ �ý��ۿ� ��ȭ�� ����� ��û(ȸ������, �۾��� ��)�� ��쿡�� redirection�� ����ϴ� ���� �ٶ����մϴ�.
	
	
	 @GetMapping("/ContentView") 
	 public String ContentView(BoardVO boardVO, Model model) throws Exception {
		 log.info("content_view");
		
		 boardService.addHit(boardVO);								// ������ ��Ʈ �޼ҵ带 ���⿡ �ֱ�
	     model.addAttribute("content_view", boardService.getBoard(boardVO.getbId()));
	     return "ContentView";
	 }
	 
	
	@GetMapping("/modify")													// �̿ϼ� / ������ bId, bName, bTitle, bContent �������� ��
	public String Modify(BoardVO boardVO) throws Exception {				// jsp�� ����� �ʿ䰡 ������ model�� �����ϰ���
		boardService.modify(boardVO);										// ���� : /xx�� �����ؼ� ���� �����͸� BoardVO�� ��Ƽ� ���񽺷� �ѱ��	
		
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
		boardService.replyShape(boardVO);									// ������ replyShape ���⿡ �ֱ�
		boardService.addReply(boardVO);
		
		return "redirect:list";
	 }
}
