package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.TChukuDAO;
import com.dao.TGoodsDAO;
import com.dao.TRukuDAO;
import com.model.TChuku;
import com.model.TGoods;
import com.model.TRuku;
import com.opensymphony.xwork2.ActionSupport;

public class tongjiAction extends ActionSupport
{
	private TRukuDAO rukuDAO;
	private TChukuDAO chukuDAO;
	private TGoodsDAO goodsDAO;
	
	public String tongjiRes()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		
		String bianhao=req.getParameter("bianhao").trim();
		String mingcheng=req.getParameter("mingcheng").trim();
		
		List goodsList=getGoodsList(bianhao, mingcheng);
		for(int i=0;i<goodsList.size();i++)
		{
			TGoods goods=(TGoods)goodsList.get(i);
			int rukuShu=get_rukuShu(goods.getId());
			int chukushu=get_chukuShu(goods.getId());
			goods.setKucun(rukuShu-chukushu);
			
		}
		
		session.setAttribute("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}


	public List getGoodsList(String bianhao,String mingcheng)
	{
		String sql="from TGoods where del='no' and bianhao like '%"+bianhao+"%'"+" and mingcheng like '%"+mingcheng+"%'";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		return goodsList;
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
	
	
	public int get_chukuShu(int goods_id)
	{
		int j=0;
		
		String sql="from TChuku where goods_id="+goods_id;
		List chukuList=chukuDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<chukuList.size();i++)
		{
			TChuku chuku=(TChuku)chukuList.get(i);
			j=j+chuku.getShuliang();
		}
		
		return j;
	}


	public TRukuDAO getRukuDAO()
	{
		return rukuDAO;
	}





	public void setRukuDAO(TRukuDAO rukuDAO)
	{
		this.rukuDAO = rukuDAO;
	}






	public TChukuDAO getChukuDAO() {
		return chukuDAO;
	}


	public void setChukuDAO(TChukuDAO chukuDAO) {
		this.chukuDAO = chukuDAO;
	}


	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}





	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}
	
}
