package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TLiuyanDAO;
import com.model.TAdmin;
import com.model.TLiuyan;
import com.model.TStu;
import com.model.TTea;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class liuyanAction extends ActionSupport
{
	private int liuyanId;
	private String liuyanTitle;
	private String liuyanContent;
	
	private TLiuyanDAO liuyanDAO;
	private String message;
	private String path;
	
	
	
	public String liuyanMana()
	{
		List liuyanList=liuyanDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("liuyanList", liuyanList);
		return ActionSupport.SUCCESS;
	}
	
	public String liuyanAdd()
	{
		TLiuyan liuyan=new TLiuyan();
		liuyan.setLiuyanContent(liuyanContent);
		liuyan.setLiuyanTitle(liuyanTitle);
		liuyan.setLiuyanDate(new Date().toLocaleString());
		Map session=ActionContext.getContext().getSession();
		int userType=(Integer)(session.get("userType"));
		if(userType==0)
		{
             TAdmin admin=(TAdmin)session.get("admin");
             liuyan.setLiuyanUser("ϵͳ����Ա");
		}
		if(userType==1)
		{
			 TTea tea=(TTea)session.get("tea");
             liuyan.setLiuyanUser(tea.getLoginName());
		}
		if(userType==2)
		{
			TStu stu=(TStu)session.get("stu");
             liuyan.setLiuyanUser(stu.getLoginName());
		}
		liuyanDAO.save(liuyan);
		this.setMessage("���Գɹ�");
		this.setPath("liuyanMana.action");
		return "succeed";
	}
	
	
	public String liuyanDel()
	{
		TLiuyan liuyan=liuyanDAO.findById(liuyanId);
		liuyanDAO.delete(liuyan);
		this.setMessage("����ɾ���ɹ�");
		this.setPath("liuyanMana.action");
		return "succeed";
	}
	

	public String getLiuyanContent()
	{
		return liuyanContent;
	}

	public void setLiuyanContent(String liuyanContent)
	{
		this.liuyanContent = liuyanContent;
	}

	public TLiuyanDAO getLiuyanDAO()
	{
		return liuyanDAO;
	}

	public void setLiuyanDAO(TLiuyanDAO liuyanDAO)
	{
		this.liuyanDAO = liuyanDAO;
	}

	public int getLiuyanId()
	{
		return liuyanId;
	}

	public void setLiuyanId(int liuyanId)
	{
		this.liuyanId = liuyanId;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getLiuyanTitle()
	{
		return liuyanTitle;
	}

	public void setLiuyanTitle(String liuyanTitle)
	{
		this.liuyanTitle = liuyanTitle;
	}
	

}
