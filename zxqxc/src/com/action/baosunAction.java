package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TBaosunDAO;
import com.dao.TGoodsDAO;
import com.dao.TRukuDAO;
import com.model.TBaosun;
import com.model.TRuku;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagesize;
import com.util.Pagination;

public class baosunAction extends ActionSupport
{
	private Integer id;
	private Integer goods_id;
	private Integer shuliang;
	private String shijian;
	
	private String beizhu;

	private TGoodsDAO goodsDAO;
	private TRukuDAO rukuDAO;
	private TBaosunDAO baosunDAO;
	
	public String baosunAdd()
	{
		/*HttpServletRequest req=ServletActionContext.getRequest();
		
		int rukuShu=get_rukuShu(goods_id);
		if(shuliang>rukuShu)
		{
			req.setAttribute("msg", "库存不足");
			return "msg";
		}
		
		else
		{*/
			TBaosun baosun=new TBaosun();
            
			//baosun.setId(id);
	        baosun.setGoods_id(goods_id);
	        baosun.setShuliang(shuliang);
	        baosun.setShijian(shijian);
	        
	        baosun.setBeizhu(beizhu);
			
			baosunDAO.save(baosun);
			
			HttpServletRequest req=ServletActionContext.getRequest();
			req.setAttribute("msg", "操作成功");
			return "msg";
		/*}*/
		
		
	}
	
	
	
	public String baosunMana()
	{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String sql="from TBaosun order by id desc";
		List baosunList=baosunDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<baosunList.size();i++)
		{
			TBaosun baosun=(TBaosun)baosunList.get(i);
			baosun.setGoods(goodsDAO.findById(baosun.getGoods_id()));
		}
		
		
		request.setAttribute("baosunList", baosunList);
		return ActionSupport.SUCCESS;
	}
	
	public String baosunDel()
	{
		TBaosun baosun=baosunDAO.findById(id);
		
		baosunDAO.delete(baosun);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "操作成功");
		return "msg";
	}
	
	
	public String baosunPre()
	{
		TBaosun baosun=baosunDAO.findById(id);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("baosun", baosun);
		return ActionSupport.SUCCESS;
	}
	
	public String baosunEdit()
	{
		TBaosun baosun=baosunDAO.findById(id);
		
		//baosun.setId(id);
        //baosun.setGoods_id(goods_id);
        baosun.setShuliang(shuliang);
        baosun.setShijian(shijian);
        
        baosun.setBeizhu(beizhu);
		
		baosunDAO.attachDirty(baosun);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "操作成功");
		return "msg";
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



	public TBaosunDAO getBaosunDAO() {
		return baosunDAO;
	}



	public void setBaosunDAO(TBaosunDAO baosunDAO) {
		this.baosunDAO = baosunDAO;
	}

}
