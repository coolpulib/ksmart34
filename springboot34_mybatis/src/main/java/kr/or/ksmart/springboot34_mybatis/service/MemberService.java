package kr.or.ksmart.springboot34_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.springboot34_mybatis.domain.Member;
import kr.or.ksmart.springboot34_mybatis.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	
	@Autowired	
	private MemberMapper memberMapper; 

	public List<Member> getMemeberList(){
		//List<Member> mlist = memberMapper.getMemberList();
		return memberMapper.getMemberList();
	}
	public int mInsert(Member member) {
		return memberMapper.mInsert(member);
	}
	
	public Member selectForUpdate(String mId) {
		return memberMapper.selectForUpdate(mId);
	}
	
	public int mUpdate(Member member) {
		return memberMapper.mUpdate(member);   
	}
	public int mDelete(String mId, String mPw) {
		return memberMapper.mDelete(mId, mPw);
	}
	
	public List<Member> getSearchMemberList(String sk, String sv){
		return memberMapper.getSearchMemberList(sk, sv);
	}
}
