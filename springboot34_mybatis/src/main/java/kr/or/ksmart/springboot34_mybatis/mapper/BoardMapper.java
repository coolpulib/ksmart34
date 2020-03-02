package kr.or.ksmart.springboot34_mybatis.mapper;

import java.util.List;
import java.util.Map;

import kr.or.ksmart.springboot34_mybatis.domain.Board;

public interface BoardMapper {
	public List<Board> getBoardList(Map<String, Object> map);
	
	public int getBoardRowCount();
}
