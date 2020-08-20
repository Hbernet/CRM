<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>编辑项目信息</title>
	<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
        $(function(){
            // 获取当前项目相关信息
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/pro/showOneInfo',
                data: {"id":${param.pid}},
                dataType:'json',
                success:function(rs){
                    var date1 = new Date(rs.starttime );
                    var starttime = date1.getFullYear() + "-" + (date1.getMonth() + 1) + "-" + date1.getDate();
                    var date2 = new Date(rs.buildtime);
                    var buildtime = date2.getFullYear() + "-" + (date2.getMonth() + 1) + "-" + date2.getDate();
                    var date3 = new Date(rs.endtime);
                    var endtime = date3.getFullYear() + "-" + (date3.getMonth() + 1) + "-" + date3.getDate();
                    $("#pna").val(rs.pname);
                    $("#cp").val(rs.customer.companyperson);
					$("#empc").val(rs.empcount);
                    $("#startt").val(starttime);
                    $("#buid").val(buildtime);
                    $("#cost").val(rs.cost);
                    $("#end").val(endtime);
                    $("#le").val(rs.level);
                    $("#rem").val(rs.remark);
                    var option1 ="<option value="+rs.customer.id+","+rs.customer.companyperson+">"+rs.customer.comname+"</option>";
                    $("#com").append(option1);
                    var option2 ="<option value="+rs.employee.eid+">"+rs.employee.ename+"</option>";
                    $("#emp").append(option2);

                }
            });

            // 获取客户可选信息
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/cus/getOtherInfo',
                data: {"id":${param.pid}},
                dataType:'json',
                success:function(rs){
                    $(rs).each(function(index,item){
                        var option ="<option value="+item.id+","+item.companyperson+">"+item.comname+"</option>";
                        $("#com").append(option);
                    });
                }
            });

            // 获取员工可选信息
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/emp/getOtherInfo',
                data: {"id":${param.pid}},
                dataType:'json',
                success:function(rs){
                    $(rs).each(function(index,item){
                        var option ="<option value="+item.eid+">"+item.ename+"</option>";
                        $("#emp").append(option);

                    });
                }
            });

        });

        function addcus(obj){
            // 给客户方负责人添加值
            $("#cp").val(obj.split(",")[1]);
        }


        function commit(){
            $("#form2").submit();
        }


	</script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>编辑项目基本信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="form2" action="${pageContext.request.contextPath}/pro/updatePro" method="POST">
	<input type="hidden" name="pid" value="${param.pid}">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;编辑项目信息&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">项目名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="pname" id="pna"/>
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">客户公司名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="com" name="newcomname"  onchange="addcus(this.value)">
			<%--第一行是当前名称 下面是其他公司名称--%>

		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">客户方负责人：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text"  id="cp" name="comper"/>
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">项目经理：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="emp"  name="empFk" >
			<%--第一行为当前负责人 下面为其他负责人--%>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">开发人数：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="empcount" id="empc"/>人
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="starttime" id="startt"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">立项时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="buildtime" id="buid"/>
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">预估成本：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="cost" id="cost"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select  name="level" id="le">
			<option value=1>紧急</option>
			<option value=2>一般</option>
			<option value=3>暂缓</option>
		</select>
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">计划完成时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="endtime" id="end"/>
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea type="text" rows=15 cols=130 name="remark" id="rem"></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<A class="coolbg" onclick="commit()" >保存</A>
	<a href="project-base.jsp" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>