package com.model;

/**
 * TGoods generated by MyEclipse Persistence Tools
 */

public class TGoods implements java.io.Serializable
{

	private Integer id;
	private Integer catelog_id;
	private String bianhao;
	private String mingcheng;

	private String danwei;
	private String beizhu;
	private String fujian;
	private String del;
	
	private TCatelog catelog;
	private int kucun;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getCatelog_id()
	{
		return catelog_id;
	}

	public void setCatelog_id(Integer catelog_id)
	{
		this.catelog_id = catelog_id;
	}

	public String getBianhao()
	{
		return bianhao;
	}

	public void setBianhao(String bianhao)
	{
		this.bianhao = bianhao;
	}

	public String getMingcheng()
	{
		return mingcheng;
	}

	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}

	public String getDanwei()
	{
		return danwei;
	}

	public TCatelog getCatelog() {
		return catelog;
	}

	public void setCatelog(TCatelog catelog) {
		this.catelog = catelog;
	}

	public void setDanwei(String danwei)
	{
		this.danwei = danwei;
	}

	public String getFujian()
	{
		return fujian;
	}

	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}

	public String getBeizhu()
	{
		return beizhu;
	}

	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}

	public String getDel()
	{
		return del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

	public int getKucun()
	{
		return kucun;
	}

	public void setKucun(int kucun)
	{
		this.kucun = kucun;
	}
	
}