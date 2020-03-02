package kr.or.ksmart.springboot34_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import kr.or.ksmart.springboot34_mybatis.domain.Member;

@Mapper
public interface MemberMapper {
	// db Member table 모든 행을 가져오는 메서드(쿼리문 xml에 구현)
	public List<Member> getMemberList();
	
	
	public int mInsert(Member member);
	
	
	public Member selectForUpdate(String mId);
	
	public int mUpdate(Member member);
	
	public int mDelete(String mId, String mPw);
	
	public List<Member> getSearchMemberList(String sk, String sv);
	
	
}
