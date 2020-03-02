package kr.or.ksmart.springboot34_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.springboot34_mybatis.domain.Goods;

@Mapper
public interface GoodsMapper {
	public List<Goods> getGoodsList();
	public int gInsert(Goods goods);
	public Goods selectforgUpdate(String g_code);
}
