package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TCatelogDAO;
import com.dao.TGoodsDAO;
import com.model.TCatelog;
import com.model.TGoods;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagesize;
import com.util.Pagination;

public class goodsAction extends ActionSupport
{
	private Integer id;
	private Integer catelog_id;
	private String bianhao;
	private String mingcheng;

	private String danwei;
	private String beizhu;
	private String fujian;
	private String del;
	
	private TGoodsDAO goodsDAO;
	private TCatelogDAO catelogDAO;
	
	public String goodsAdd()
	{
		
		String sql="from TGoods where del='no' and bianhao=?";
		Object[] c={bianhao.trim()};
		List list=goodsDAO.getHibernateTemplate().find(sql,c);
		if(list.size()>0)
		{
			HttpServletRequest req=ServletActionContext.getRequest();
			req.setAttribute("msg", "编号重复");
			return "msg";
		}
		
		TGoods goods=new TGoods();
		
		//goods.setId(id);
		goods.setCatelog_id(catelog_id);
		goods.setBianhao(bianhao);
		goods.setMingcheng(mingcheng);
		
		goods.setDanwei(danwei);
		goods.setBeizhu(beizhu);
		goods.setFujian(fujian);
		goods.setDel("no");
		
		goodsDAO.save(goods);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "操作成功");
		return "msg";
	}
	
	
	
	public String goodsMana()
	{
		
        HttpServletRequest request=ServletActionContext.getRequest();
		
		String sql="from TGoods where del='no' order by catelog_id";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<goodsList.size();i++)
		{
			TGoods goods=(TGoods)goodsList.get(i);
			goods.setCatelog(catelogDAO.findById(goods.getCatelog_id()));
		}
		
		
		
		request.setAttribute("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsDel()
	{
		TGoods goods=goodsDAO.findById(id);
		goods.setDel("yes");
		goodsDAO.attachDirty(goods);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "操作成功");
		return "msg";
	}
	
	
	public String goodsPre()
	{
		TGoods goods=goodsDAO.findById(id);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsEdit()
	{
		TGoods goods=goodsDAO.findById(id);
		
		//goods.setId(id);
		goods.setCatelog_id(catelog_id);
		goods.setBianhao(bianhao);
		goods.setMingcheng(mingcheng);
		
		goods.setDanwei(danwei);
		goods.setBeizhu(beizhu);
		goods.setFujian(fujian);
		goods.setDel("no");
		
		goodsDAO.attachDirty(goods);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "操作成功");
		return "msg";
	}

	
	public String goodsAll()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		
		String sql="from TGoods where del='no' order by catelog_id";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<goodsList.size();i++)
		{
			TGoods goods=(TGoods)goodsList.get(i);
			goods.setCatelog(catelogDAO.findById(goods.getCatelog_id()));
		}
		req.setAttribute("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getCatelog_id() {
		return catelog_id;
	}



	public void setCatelog_id(Integer catelog_id) {
		this.catelog_id = catelog_id;
	}



	public TCatelogDAO getCatelogDAO() {
		return catelogDAO;
	}



	public void setCatelogDAO(TCatelogDAO catelogDAO) {
		this.catelogDAO = catelogDAO;
	}



	public String getBianhao() {
		return bianhao;
	}



	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}



	public String getMingcheng() {
		return mingcheng;
	}



	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}



	public String getDanwei() {
		return danwei;
	}



	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}



	public String getBeizhu() {
		return beizhu;
	}



	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}



	public String getFujian() {
		return fujian;
	}



	public void setFujian(String fujian) {
		this.fujian = fujian;
	}



	public String getDel() {
		return del;
	}



	public void setDel(String del) {
		this.del = del;
	}



	public TGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}



	public void setGoodsDAO(TGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}
	
}
