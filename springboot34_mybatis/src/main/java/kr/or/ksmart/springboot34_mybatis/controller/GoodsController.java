/**
 * 
 */
package kr.or.ksmart.springboot34_mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.springboot34_mybatis.domain.Goods;
import kr.or.ksmart.springboot34_mybatis.service.GoodsService;
import kr.or.ksmart.springboot34_mybatis.service.MemberService;

/**
 * @author Administrator
 *
 */
@Controller
public class GoodsController {
	//관계성 맺기
	@Autowired
	private GoodsService goodsService;
	
	
	//주소요청
	//상품리스트 불러오기
	@GetMapping("/goodsList")
	public String getGoodsList(Model model) {
		model.addAttribute("goodsList", goodsService.getGoodsList());
		System.out.println(goodsService.getGoodsList().toString());
		return "gList/goodsList";
	}
	
	//상품등록 화면 불러오기
	@GetMapping("/gInsert")
	public String gInesrt() {
		return "gInsert/gInsert";
	}
	
	//상품등록 진행(상품등록 로직처리)
	@PostMapping("/gInsert")
	public String gInsert(Goods goods) {
		System.out.println(goods.toString());
		int result = goodsService.gInsert(goods);
		if(result>0) {
			return "redirect:/goodsList";
		}
		return "redirect:/gInsert";		
	}
	
	//상품 업데이트 페이지 가기 - 업데이트를 위해서는 리스트에서 수정을 눌러 해당아이디의 내용을 뽑아오게 하고 거기서 업데이트 쿼리친다
	//이 페이지는 해당 업데이트할 내용 하나만 뽑아지는 페이지로 간다.
	@GetMapping("/gUpdate")
	public String gUpdate(@RequestParam(value="g_code") String g_code, Model model) {
		System.out.println("binding test"+g_code);
		model.addAttribute("Goods", goodsService.selectforgUpdate(g_code));
		return "gUpdate/gUpdate";
	}
	//상품 업데이트 로직처리
	/*
	 * @PostMapping("/gUpdate") public String gUpdate(Goods goods) { int result =
	 * goodsService.selectforgUpdate(goods); if(result>0) { return
	 * "redirect:/goodsList"; } return "redirect:/gUpdate"; }
	 */
	
	
	
}
