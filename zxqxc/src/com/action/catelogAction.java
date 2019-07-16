package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.dao.TCatelogDAO;
import com.model.TAdmin;
import com.model.TCatelog;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagesize;
import com.util.Pagination;

public class catelogAction extends ActionSupport
{
	private Integer id;
	private String name;
	private String del;

	private TCatelogDAO catelogDAO;
	
	public String catelogAdd()
	{
		TCatelog catelog=new TCatelog();
		
		//catelog.setId(id);
		catelog.setName(name);
		catelog.setDel("no");
		
		catelogDAO.save(catelog);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "操作成功");
		return "msg";
	}
	
	
	
	public String catelogMana()
	{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		String sql="from TCatelog where del='no'";
		List catelogList=catelogDAO.getHibernateTemplate().find(sql);
		
		
		
		request.setAttribute("catelogList", catelogList);
		return ActionSupport.SUCCESS;
	}
	
	public String catelogDel()
	{
		TCatelog catelog=catelogDAO.findById(id);
		catelog.setDel("yes");
		catelogDAO.attachDirty(catelog);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "操作成功");
		return "msg";
	}
	
	
	public String catelogPre()
	{
		
		TCatelog catelog=catelogDAO.findById(id);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("catelog", catelog);
		return ActionSupport.SUCCESS;
	}
	
	
	public String catelogEdit()
	{
		TCatelog catelog=catelogDAO.findById(id);
		
		//catelog.setId(id);
		catelog.setName(name);
		//catelog.setDel(del);
		
		catelogDAO.attachDirty(catelog);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "操作成功");
		return "msg";
	}



	public String catelogAll()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		
		String sql="from TCatelog where del='no'";
		List catelogList=catelogDAO.getHibernateTemplate().find(sql);
		
		req.setAttribute("catelogList", catelogList);
		return ActionSupport.SUCCESS;
	}

	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDel() {
		return del;
	}



	public void setDel(String del) {
		this.del = del;
	}



	public void setCatelogDAO(TCatelogDAO catelogDAO) {
		this.catelogDAO = catelogDAO;
	}

}
