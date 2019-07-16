package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.TGoodsDAO;
import com.dao.TRukuDAO;
import com.model.TRuku;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagesize;
import com.util.Pagination;

public class rukuAction extends ActionSupport
{
	private Integer id;
	private Integer goods_id;
	private String danjuhao;
	
	private Integer rukushu;
	private String rukushi;
	private String beizhu;

	private TRukuDAO rukuDAO;
	private TGoodsDAO goodsDAO;
	
	
	public String rukuAdd()
	{
		TRuku ruku=new TRuku();
		
		ruku.setId(id);
		ruku.setGoods_id(goods_id);
		ruku.setDanjuhao(danjuhao);
		
		ruku.setRukushu(rukushu);
		ruku.setRukushi(rukushi);
		ruku.setBeizhu(beizhu);
		
		rukuDAO.save(ruku);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "操作成功");
		return "msg";
	}
	
	
	
	public String rukuMana()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		String sql="from TRuku order by id desc";
		List rukuList=rukuDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<rukuList.size();i++)
		{
			TRuku ruku=(TRuku)rukuList.get(i);
			ruku.setGoods(goodsDAO.findById(ruku.getGoods_id()));
		}
		
		
		session.setAttribute("rukuList", rukuList);
		return ActionSupport.SUCCESS;
	}
	
	public String rukuDel()
	{
		TRuku ruku=rukuDAO.findById(id);
		rukuDAO.delete(ruku);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "操作成功");
		return "msg";
	}
	
	public String rukuPre()
	{
		TRuku ruku=rukuDAO.findById(id);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("ruku", ruku);
		return ActionSupport.SUCCESS;
	}
	
	
	public String rukuEdit()
	{
		TRuku ruku=rukuDAO.findById(id);
		
		//ruku.setId(id);
		//ruku.setGoods_id(goods_id);
		//ruku.setGongyingshang_id(gongyingshang_id);
		ruku.setDanjuhao(danjuhao);
		
		ruku.setRukushu(rukushu);
		//ruku.setRukushi(rukushi);
		ruku.setBeizhu(beizhu);
		
		rukuDAO.attachDirty(ruku);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "操作成功");
		return "msg";
	}
	
	public String rukuRes()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		
		StringBuffer sql=new StringBuffer("from TRuku where 1=1");
		if(goods_id !=0)
		{
			sql.append(" and goods_id="+goods_id);
		}
		sql.append(" and danjuhao like '%"+danjuhao.trim()+"%'");
		
		List rukuList=rukuDAO.getHibernateTemplate().find(sql.toString());
		for(int i=0;i<rukuList.size();i++)
		{
			TRuku ruku=(TRuku)rukuList.get(i);
			ruku.setGoods(goodsDAO.findById(ruku.getGoods_id()));
		}
		
		req.setAttribute("rukuList", rukuList);
		return ActionSupport.SUCCESS;
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






	public String getDanjuhao() {
		return danjuhao;
	}



	public void setDanjuhao(String danjuhao) {
		this.danjuhao = danjuhao;
	}



	public Integer getRukushu() {
		return rukushu;
	}



	public void setRukushu(Integer rukushu) {
		this.rukushu = rukushu;
	}



	public String getRukushi() {
		return rukushi;
	}



	public void setRukushi(String rukushi) {
		this.rukushi = rukushi;
	}



	public String getBeizhu() {
		return beizhu;
	}



	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}



	public TRukuDAO getRukuDAO() {
		return rukuDAO;
	}



	public void setRukuDAO(TRukuDAO rukuDAO) {
		this.rukuDAO = rukuDAO;
	}



	public TGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}



	public void setGoodsDAO(TGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

}
