package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.TChukuDAO;
import com.dao.TGoodsDAO;
import com.dao.TRukuDAO;
import com.model.TChuku;
import com.model.TRuku;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagesize;
import com.util.Pagination;

public class chukuAction extends ActionSupport
{
	private Integer id;
	private Integer goods_id;
	private Integer shuliang;
	private String shijian;
	
	private String beizhu;

	private TGoodsDAO goodsDAO;
	private TRukuDAO rukuDAO;
	private TChukuDAO chukuDAO;
	
	public String chukuAdd()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		
		int rukuShu=get_rukuShu(goods_id);
		if(shuliang>rukuShu)
		{
			req.setAttribute("msg", "库存不足");
			return "msg";
		}
		
		else
		{
			TChuku chuku=new TChuku();
            
			//chuku.setId(id);
	        chuku.setGoods_id(goods_id);
	        chuku.setShuliang(shuliang);
	        chuku.setShijian(shijian);
	        
	        chuku.setBeizhu(beizhu);
			
			chukuDAO.save(chuku);
			
			
			req.setAttribute("msg", "操作成功");
			return "msg";
		}
		
		
	}
	
	
	
	public String chukuMana()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		String sql="from TChuku order by id desc";
		List chukuList=chukuDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<chukuList.size();i++)
		{
			TChuku chuku=(TChuku)chukuList.get(i);
			chuku.setGoods(goodsDAO.findById(chuku.getGoods_id()));
		}
		
		
		session.setAttribute("chukuList", chukuList);
		return ActionSupport.SUCCESS;
	}
	
	public String chukuDel()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		int id=Integer.parseInt(req.getParameter("id"));
		
		TChuku chuku=chukuDAO.findById(id);
		
		chukuDAO.delete(chuku);
		
		req.setAttribute("msg", "操作成功");
		return "msg";
	}
	
	

	
	public int get_rukuShu(int goods_id)
	{
		int j=0;
		
		String sql="from TRuku where goods_id="+goods_id;
		List rukuList=rukuDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<rukuList.size();i++)
		{
			TRuku ruku=(TRuku)rukuList.get(i);
			j=j+ruku.getRukushu();
		}
		
		return j;
	}



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



	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}





	public TGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}



	public void setGoodsDAO(TGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}



	public TRukuDAO getRukuDAO() {
		return rukuDAO;
	}



	public void setRukuDAO(TRukuDAO rukuDAO) {
		this.rukuDAO = rukuDAO;
	}



	public TChukuDAO getChukuDAO() {
		return chukuDAO;
	}



	public void setChukuDAO(TChukuDAO chukuDAO) {
		this.chukuDAO = chukuDAO;
	}



}
