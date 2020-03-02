package kr.or.ksmart.springboot34_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.springboot34_mybatis.domain.Goods;
import kr.or.ksmart.springboot34_mybatis.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	
	public List<Goods> getGoodsList(){
		return goodsMapper.getGoodsList();
	}
	public int gInsert(Goods goods) {
		return goodsMapper.gInsert(goods);
	}
	public Goods selectforgUpdate(String g_code) {
		return goodsMapper.selectforgUpdate(g_code);
	}
}
