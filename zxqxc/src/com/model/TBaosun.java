package com.model;

/**
 * TBaosun entity. @author MyEclipse Persistence Tools
 */

public class TBaosun implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer goods_id;
	private Integer shuliang;
	private String shijian;
	
	private String beizhu;
	
	private TGoods goods;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public Integer getShuliang() {
		return shuliang;
	}

	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}

	public String getShijian() {
		return shijian;
	}

	public void setShijian(String shijian) {
		this.shijian = shijian;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public TGoods getGoods() {
		return goods;
	}

	public void setGoods(TGoods goods) {
		this.goods = goods;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

}