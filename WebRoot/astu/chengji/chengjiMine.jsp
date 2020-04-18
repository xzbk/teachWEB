<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link rel="stylesheet" href="<%=path%>/css/front.css" type="text/css"></link>
		<link rel="stylesheet" href="<%=path%>/css/ww.css" type="text/css"></link>
		<link rel="stylesheet" href="<%=path%>/css/theme.css" type="text/css"></link>
		
		<script type='text/javascript' src='<%=path %>/dwr/interface/kechengService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
        
        <script type="text/javascript" src="<%=path %>/My97DatePicker/WdatePicker.js"></script> 
		
		<style type="text/css">
	       .lbody{background:url(<%=path%>/img/lbg.jpg) right repeat-y #F4F7FB;color:#666666;margin-right:6px;}
	       .lmenu a{display:block;padding:7px 0px 7px 30px;; background:url(<%=path%>/img/circle.gif) no-repeat 15px -1px;}
	       .rpos{float:left;padding:3px 0px 3px 20px;background:url(<%=path%>/img/arrow.gif) center left no-repeat;}
	       .pn-lthead th{height:27px;background-image:url(<%=path%>/img/msg_bg.jpg);}
        </style>

       <script language="javascript">
           function init()
		   {
		       kechengService.findAllKecheng(callBackKecheng)
		   }
		   
		   function callBackKecheng(data)
		   {
		        DWRUtil.addOptions("kechengId",data,"kechengId","kechengName");
		   } 
		   
		   function check()
		   {
		       if(document.form1.kechengId.value==0)
		       {
		           alert("请选择课程");
		           return false;
		       }
		       
		       document.form1.submit();
		   }
       </script>
	</head>
    <body onload="init()">
		<div class="body-box">
		    <table class="pn-ltable" width="100%" cellspacing="1" cellpadding="0" border="0">
				<thead class="pn-lthead">
					<tr>
						<th>
							课程
						</th>
						<th>
							分数
						</th>
						<th>
						   考试时间
						</th>
						<th>
						   考试类型
						</th>
					</tr>
				</thead>
				<tbody class="pn-ltbody" id="tbody">
					<s:iterator value="#request.chengjiList" id="chengji">
					<tr>
						<td align="center">
							<s:property value="#chengji.chengjiOne1"/>
						</td>
						<td align="center">
							<s:property value="#chengji.kaoshifenshu"/>
						</td>
						<td align="center">
						    <s:property value="#chengji.kaoshishijian"/>
						</td>
						<td align="center">
						    <s:property value="#chengji.kaoshileixing"/>
						</td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
			<br/><br/>
			<div class="pn-sp">
				<div class="clear">
				    <form action="<%=path %>/chengjiSearch_stu.action" name="form1" method="post">
				    <table>
		                <tr>
		                    <td>
		                        课程：
		                    </td>
		                    <td>
		                        <select name="kechengId" id="kechengId">
		                            <option value="0">---请选择课程---</option>
		                        </select>
		                        &nbsp;&nbsp;&nbsp;&nbsp;
		                           分数:
		                       <input type="text" name="fenshu1" id="fenshu1" size="10" value="0" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
		                       -
		                       <input type="text" name="fenshu2" id="fenshu2" size="10" value="100" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
		                    
		                       <input type="button" value="查询" onclick="check()"/>
		                    </td>
		                </tr>
		            </table>
		            </form>
                </div>
			</div>
		</div>
	</body>
</html>
