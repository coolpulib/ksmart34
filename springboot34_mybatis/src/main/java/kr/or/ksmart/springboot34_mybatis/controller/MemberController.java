package kr.or.ksmart.springboot34_mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ksmart.springboot34_mybatis.domain.Member;
import kr.or.ksmart.springboot34_mybatis.service.MemberService;



@Controller
public class MemberController {
	//관계성 맺기
	@Autowired
	private MemberService memberService;
	
	
	//주소요청
	@GetMapping("/memberList")
	public String getMemberList(Model model) {
		model.addAttribute("memberList", memberService.getMemeberList());
		System.out.println(memberService.getMemeberList().toString());
		return "mlist/memberList";
	}
	
	//회원 가입 폼 불러오기
	@GetMapping("/mInsert")
	public String mInsert() {
		return"mInsert/mInsert";
	}
	
	//회원가입 진행
	 @PostMapping("/mInsert") 
	 public String mInsert(Member member) {		 
		 System.out.println(member.toString()); 
		 int result = memberService.mInsert(member);
		 if(result >0) {
			 return "redirect:/memberList";
		 }
	 return"redirect:/mInsert"; 
	 }
	 
	 @GetMapping("/mUpdate")
		 public String mUpdate(@RequestParam(value="mId") String mId, Model model) {
		 System.out.println("binding test"+ mId);
		 System.out.println("binding test2" + memberService.selectForUpdate(mId).toString());
		 model.addAttribute("Member", memberService.selectForUpdate(mId));	 
		 return "mUpdate/mUpdate";
		 }
	 
	 @PostMapping("/mUpdate")
	 	public String mUpdate(Member member) {
		 System.out.println(member.toString());
		 int result = memberService.mUpdate(member);
		 if(result>0) {
			 return "redirect:/memberList";
		 }
		 return "redirect:/memberList";
	 }
	 @GetMapping("/mDelete")
	 	public String mDelete(@RequestParam(value="mId") String mId, Model model) {
		 model.addAttribute("mId", mId);
		 return "mDelete/mDelete";
	 }
	 @PostMapping("/mDelete")
	 	public String mDelete(@RequestParam(value="mId") String mId
	 						, @RequestParam(value="mPw", required = false) String mPw
	 						,RedirectAttributes redirectA) {
		 Member member= memberService.selectForUpdate(mId);//DB에 있는 기존 pw를 꺼내오려고 쓴 명령어
		 if(mPw != null && !"".equals(mPw) && mPw.equals(member.getmPw())) {
			 memberService.mDelete(mId,mPw);
			 return "redirect:/memberList";
		 }

		 return "redirect:/memberList";
	 }
	 @PostMapping("/memberList")
	 public String memberList(@RequestParam(value="sk") String sk, @RequestParam(value="sv", required = false) String sv
			 				,Model model) {
		 
		 System.out.println("binding test sk:"+ sk);
		 System.out.println("binding test sv:"+ sv);
		 List<Member> list = memberService.getSearchMemberList(sk, sv);
		 model.addAttribute("memberList", list);
		 return "mlist/memberList";
	 }
	 @GetMapping("/login")
	public String login(@RequestParam(value = "result", required = false) String result, Model model) {
		 model.addAttribute("result", result);
		 return "login/login";
	 }
	 
	 @PostMapping("/login")
	 public String login(@RequestParam(value = "mId", required = false) String mId,
			 @RequestParam(value = "mPw", required = false) String mPw
			 ,RedirectAttributes redirectA
			 ,HttpSession session) {
		 System.out.println("binding test mId:" + mId);
		 System.out.println("binding test mPw:" + mPw);
		 Member member = memberService.selectForUpdate(mId);
		 //로그인 성공
		 if(member !=null && mPw != null && !"".equals(mPw)
			 	&& mPw.equals(member.getmPw())){
			 session.setAttribute("SID", member.getmId());//보통 세션에는 아이디변수를 대문자로 적음
			 session.setAttribute("SNAME", member.getmName());
			 session.setAttribute("SLEVEL", member.getmLevel());
			 return "redirect:/";		
			 //로그인 실패
		 }else {
			 redirectA.addAttribute("result", "등록된 회원이 아닙니다");
			 return "redirect:/login";	
		 }
		 
	 
	 }
	 @GetMapping("/logout") 
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/";
	 }
}
	 
	 

