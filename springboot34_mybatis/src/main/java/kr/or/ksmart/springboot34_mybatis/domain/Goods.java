package kr.or.ksmart.springboot34_mybatis.domain;

public class Goods {
	private String g_code;
	private String m_id;
	private String g_name;
	private String g_cate;
	private String g_price;
	private String g_color;
	private String g_size;
	private String g_date;
	private String g_desc;
	public String getG_code() {
		return g_code;
	}
	public void setG_code(String g_code) {
		this.g_code = g_code;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getG_cate() {
		return g_cate;
	}
	public void setG_cate(String g_cate) {
		this.g_cate = g_cate;
	}
	public String getG_price() {
		return g_price;
	}
	public void setG_price(String g_price) {
		this.g_price = g_price;
	}
	public String getG_color() {
		return g_color;
	}
	public void setG_color(String g_color) {
		this.g_color = g_color;
	}
	public String getG_size() {
		return g_size;
	}
	public void setG_size(String g_size) {
		this.g_size = g_size;
	}
	public String getG_date() {
		return g_date;
	}
	public void setG_date(String g_date) {
		this.g_date = g_date;
	}
	public String getG_desc() {
		return g_desc;
	}
	public void setG_desc(String g_desc) {
		this.g_desc = g_desc;
	}
	@Override
	public String toString() {
		return "Goods [g_code=" + g_code + ", m_id=" + m_id + ", g_name=" + g_name + ", g_cate=" + g_cate + ", g_price="
				+ g_price + ", g_color=" + g_color + ", g_size=" + g_size + ", g_date=" + g_date + ", g_desc=" + g_desc
				+ "]";
	}
	

}
