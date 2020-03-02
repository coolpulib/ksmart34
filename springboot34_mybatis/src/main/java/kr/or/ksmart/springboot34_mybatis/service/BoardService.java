package kr.or.ksmart.springboot34_mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.springboot34_mybatis.domain.Board;
import kr.or.ksmart.springboot34_mybatis.mapper.BoardMapper;

@Service
@Transactional
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	public Map<String, Object> getBoardList(int currentPage){
		//몇 개 행을 보여줄지
		final int ROW_PER_PAGE = 10; //상수는 다 대문자로 표현
		
		//보여줄 첫번째 페이지 번호 초기화
		int startPageNum = 1;
		
		//보여줄 페이지 개수
		int endPageNum = ROW_PER_PAGE;
		 
		//페이지가 6번째 부터 startPageNum 변동
		if(currentPage>(ROW_PER_PAGE/2)) {
			startPageNum = currentPage -((endPageNum/2)-1);
			endPageNum += (startPageNum-1);
		}
		
		//limit 적용할 StartRow, 상수 ROW_PER_PAGE(몇개행)
		Map<String, Object> map = new HashMap<String,Object>();
		
		//페이지알고리즘 (DB의 행은 0부터 시작하니까 그 0을 맞추기 위해서 이런식으로 짰음)
		int startRow = (currentPage-1)*ROW_PER_PAGE;
		
		map.put("startRow", startRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		
		//전체 카운트
		double count= boardMapper.getBoardRowCount();
		
		//라스트페이지
		//(카운트)/보여줄 행의 개수 ( math클래스 안에 있는 올림메서드 사용)
		int lastPage = (int) Math.ceil((count/ROW_PER_PAGE));
		
		if(currentPage >= (lastPage-4)) {
			endPageNum = endPageNum;
		}
		
		//controller에 전달 페이지 관련 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("boardList", 	boardMapper.getBoardList(map));
		resultMap.put("currentPage", currentPage);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum",startPageNum);
		resultMap.put("endPageNum",endPageNum);
		
		return resultMap;
	}
}
