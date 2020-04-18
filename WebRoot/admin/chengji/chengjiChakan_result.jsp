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
       </script>
	</head>
    <body>
		<div class="body-box">
		    <table class="pn-ltable" width="100%" cellspacing="1" cellpadding="0" border="0">
				<thead class="pn-lthead">
					<tr>
						<th>
							学生
						</th>
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
							<s:property value="#chengji.chengjiOne2"/><!-- //学生姓名 -->
						</td>
						<td align="center">
							<s:property value="#chengji.chengjiOne1"/><!-- //课程名称 -->
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
			<%--<div class="pn-lnoresult">没有相关数据！</div>--%>
			<div class="pn-sp">
				<div class="clear"></div>
			</div>
		</div>
	</body>
</html>
