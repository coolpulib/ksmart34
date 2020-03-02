package kr.or.ksmart.springboot34_mybatis.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.springboot34_mybatis.domain.Board;
import kr.or.ksmart.springboot34_mybatis.service.BoardService;

@Controller
public class BoardController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/boardList")//클릭시 일단 1페이지  나오게.(페이지가 숫자로만 되어 있다면 int 형으로도 받을 수 있다.)
	public String getBoardList(@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,Model model) {
		logger.info("currentPage :: {}",currentPage);

		Map<String, Object> map = boardService.getBoardList(currentPage);
		model.addAttribute("boardList", map.get("boardList"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("endPageNum", map.get("endPageNum"));
		
		//System.out.println(boardService.getBoardList().toString());
		return "boardList/boardList";
	}
}
	

