<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>模块管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            search(1);
        });
        function search(obj) {
            $.ajax({
                type: 'GET',
                url: '${pageContext.request.contextPath}/mod/showAllModInfo',
                data: {
                    "currentpage": obj,
                    "keyindex": $("#mt").val(),
                    "keyCode": "%" + $("#info").val() + "%",
                    "num": $("#mtime").val()
                },
                dataType: 'json',
                success: function (rs) {
                    $(".datatr").remove();
                    $(rs.list).each(function (index, item) {
                        var date1 = new Date(item.analysis.addtime);
                        var addtime = date1.getFullYear() + "-" + (date1.getMonth() + 1) + "-" + date1.getDate();
                        var date2 = new Date(item.analysis.updatetime);
                        var updatetime = date2.getFullYear() + "-" + (date2.getMonth() + 1) + "-" + date2.getDate();
                        var tr = "<tr  class='datatr' align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#a9c3fd';\" onMouseOut=\"javascript:this.bgColor='#c9ffc7';\" height=\"22\" >\n" +
                            "\t<td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"101\" class=\"np\"></td>\n" +
                            "\t<td>" + item.id + "</td>\n" +
                            "\t<td align=\"left\"><a href=''><u>" + item.modname + "</u></a></td>\n" +
                            "\t<td>" + item.analysis.title + "</td>\n" +
                            "\t<td>" + item.analysis.project.pname + "</td>\n" +
                            "\t<td>" + item.level + "</td>\n" +
                            "\t<td>" + addtime + "</td>\n" +
                            "\t<td>" + updatetime + "</td>\n" +
                            "\t<td><a href=\"project-need-edit.jsp\">编辑</a> | <a href=\"project-need-look.jsp\">查看详情</a></td>\n" +
                            "</tr>";
                        $("#ttr").after(tr);

                    });

                    $("#mm").each(function () {
                        $(this).find("td").remove();   //通过循环每一个tr，得到各自下的td
                    });
                    var td = "<td height=\"28\" colspan=\"12\">&nbsp;\n" +
                        " <a href=\"javascript:zheng()\" class=\"coolbg\">全选</a>\n" +
                        "<a href=\"javascript:fan()\" class=\"coolbg\">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "<a href=\"javascript:batchDelete()\" class=\"coolbg\">&nbsp;删除&nbsp;</a>\n" +
                        "<a href=\"\" class=\"coolbg\">&nbsp;导出Excel&nbsp;</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "当前是第" + rs.pageNum + "页\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "<a href=\"javascript:search(1)\" class=\"coolbg\">首页</a>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "<a href=\"javascript:search(" + rs.prePage + ")\" class=\"coolbg\">上一页</a>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "<a href=\"javascript:search(" + rs.nextPage + ")\" class=\"coolbg\">下一页</a>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "<a href=\"javascript:search(" + rs.pages + ")\" class=\"coolbg\">尾页</a>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "共有" + rs.pages + "页";
                    $("#mm").append(td);
                },
                error: function () {
                    alert("查询出现异常");
                }
            });
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
                    <td>
                        当前位置:项目管理>>模块管理
                    </td>
                    <td>
                        <input type='button' class="coolbg np" onClick="location='project-model-add.jsp';"
                               value='添加新模块'/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='' method='get'>
    <input type='hidden' name='dopost' value=''/>
    <table width='98%' border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center"
           style="margin-top:8px">
        <tr bgcolor='#EEF4EA'>
            <td background='skin/images/wbg.gif' align='center'>
                <table border='0' cellpadding='0' cellspacing='0'>
                    <tr>
                        <td width='90' align='center'>搜索条件：</td>
                        <td width='160'>
                            <select name='cid' id="mt" style='width:150'>
                                <option value='0'>选择类型...</option>
                                <option value='1'>项目名称</option>
                                <option value='2'>需求名称</option>
                                <option value='3'>模块名称</option>
                            </select>
                        </td>
                        <td width='70'>
                            关键字：
                        </td>
                        <td width='160'>
                            <input type='text' name='keyword' id="info" value='' style='width:120px'/>
                        </td>
                        <td width='110'>
                            <select name='orderby' id="mtime" style='width:120px'>
                                <option value='0'>排序...</option>
                                <option value='1'>添加时间</option>
                                <option value='2'>修改时间</option>
                            </select>
                        </td>
                        <td>
                            &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="skin/images/frame/search.gif"
                                                     width="45" height="20" border="0" class="np"/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
<!--  内容列表   -->
<form name="form2">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;模块列表&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22" id="ttr">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">模块名称</td>
            <td width="10%">需求名称</td>
            <td width="10%">项目名称</td>
            <td width="10%">优先级</td>
            <td width="8%">添加时间</td>
            <td width="8%">修改时间</td>
            <td width="10%">操作</td>
        </tr>

        <tr bgcolor="#FAFAF1" id="mm">

        </tr>

    </table>

</form>


</body>
</html>