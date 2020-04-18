package com.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TShitiDAO;
import com.model.TShiti;
import com.model.TStu;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class shitiAction extends ActionSupport
{
	private int shitiId;
	private String shitiName;
	
	
	private static final int BUFFER_SIZE = 16 * 1024;
	private File shitiFujian;
	private String shitiFujianFileName;
	private String shitiFujianContentType;
	
	private String message;
	private String path;
	
	private TShitiDAO shitiDAO;
	
	
	public String shitiAdd()
	{
		TShiti shiti=new TShiti();
		shiti.setShitiName(shitiName);
		shiti.setShitiFaburiqi(new Date().toLocaleString());
		shiti.setShitiType("shitiByAdmin");
		
		if(shitiFujianFileName==null || shitiFujianFileName.equals(""))
		{
			System.out.println("没有上传附件");
			shiti.setShitiFujian("0");//表示没有上传附件
		}
		else
		{
			System.out.println("有过上传附件");
			String newFile1Name=new Date().getTime()+shitiFujianFileName.substring(shitiFujianFileName.indexOf("."));
			String dstPath = ServletActionContext.getServletContext().getRealPath("uploadPath")+ "\\" + newFile1Name;
			File dstFile = new File(dstPath);
			copy(this.getShitiFujian(),dstFile);
			shiti.setShitiFujian("/uploadPath/"+newFile1Name);
			shiti.setShitiFujianleixing(shitiFujianContentType);
			shiti.setShitiFujianyuanshiming(shitiFujianFileName);
		}
		shitiDAO.save(shiti);
		this.setMessage("试题发布完毕");
		this.setPath("shitiMana.action");
		return "succeed";
		
	}
	
	
	
	
	public String shitiMana()
	{
		String sql="from TShiti where shitiType='shitiByAdmin' order by shitiId desc";
		List shitiList=shitiDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shitiList", shitiList);
		return ActionSupport.SUCCESS;
	}
	
	public String shitiDel()
	{
		TShiti shiti=shitiDAO.findById(shitiId);
		shitiDAO.delete(shiti);
		this.setMessage("试题删除完毕");
		this.setPath("shitiMana.action");
		return "succeed";
	}
	
	
	public String shitiSearch()
	{
		String sql="from TShiti where shitiType='shitiByAdmin' and shitiName like '%"+shitiName.trim()+"%'";

		List shitiList=shitiDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shitiList", shitiList);
		return ActionSupport.SUCCESS;
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

	public TShitiDAO getShitiDAO()
	{
		return shitiDAO;
	}

	public void setShitiDAO(TShitiDAO shitiDAO)
	{
		this.shitiDAO = shitiDAO;
	}

	public File getShitiFujian()
	{
		return shitiFujian;
	}

	public void setShitiFujian(File shitiFujian)
	{
		this.shitiFujian = shitiFujian;
	}

	public String getShitiFujianContentType()
	{
		return shitiFujianContentType;
	}

	public void setShitiFujianContentType(String shitiFujianContentType)
	{
		this.shitiFujianContentType = shitiFujianContentType;
	}

	public String getShitiFujianFileName()
	{
		return shitiFujianFileName;
	}

	public void setShitiFujianFileName(String shitiFujianFileName)
	{
		this.shitiFujianFileName = shitiFujianFileName;
	}

	public int getShitiId()
	{
		return shitiId;
	}

	public void setShitiId(int shitiId)
	{
		this.shitiId = shitiId;
	}

	public String getShitiName()
	{
		return shitiName;
	}

	public void setShitiName(String shitiName)
	{
		this.shitiName = shitiName;
	}
	
	private static void copy(File src, File dst) 
    {
        InputStream in = null;
        OutputStream out = null;
        try 
        {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst),BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) 
            {
                out.write(buffer, 0, len);
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        } 
        finally
        {
            if (null != in) 
            {
                try 
                {
                    in.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
            if (null != out) 
            {
                try 
                {
                    out.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
