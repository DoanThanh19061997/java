<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api/admin/user"/>

<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}">
                                ${message}
                        </div>
                    </c:if>
                    <form id="formUpdateOrCreate">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                            <div class="col-sm-9">
                                <select class="form-control" id="code" name="roleId">
                                    <option value="">Phân loại quyền truy cập</option>
                                    <c:forEach items="${roles}" var="roles">
                                        <option
                                                <c:if test="${roles.roleId == user.roleId}">
                                                    selected = 'selected'
                                                </c:if>
                                                value="${roles.roleId}"
                                        >
                                                ${roles.roleName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">user name</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="username" name="userName" value="${user.userName}"/>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">password</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="password" name="password"
                                       value="${user.password}"/>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">firs tname</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="firstname" name="firstName"
                                       value="${user.firstName}"/>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">last name</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="lastname" name="lastName"
                                       value="${user.lastName}"/>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">email</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="email" name="email"
                                       value="${user.email}"/>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">gioi tính</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="sex" name="sex"
                                       value="${user.sex}"/>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">

                            <input type="hidden" class="form-control" id="id" name="id" value="${user.userId}"/>

                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <c:if test="${not empty user.userId}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                           value="Cập nhật bài viết"
                                           id="btnAddOrUpdate"/>
                                </c:if>
                                <c:if test="${empty user.userId}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                           value="Thêm mới bài viết"
                                           id="btnAddOrUpdate"/>
                                </c:if>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $('#btnAddOrUpdate').click(function (e) {
        e.preventDefault();
        var  data ={};
        var formData = $('#formUpdateOrCreate').serializeArray();
        $.each(formData,function (i,v) {
            data[""+v.name+""] = v.value;
        });
        var id=$('#id').val();
        if (id==""){
            addNews(data);
        } else {
            updateNews(data);
        }

    });

    function addNews(data) {
        $.ajax({
            url:'${APIurl}',
            type:'POST',
            contentType:'application/json',
            data: JSON.stringify(data),
            dataType:'html',
            success:function () {
                window.location.replace("http://localhost:8080/admin/user")
            }
        })

    };
    function updateNews(data) {
        $.ajax({
            url:'${APIurl}',
            type:'PUT',
            contentType:'application/json',
            data: JSON.stringify(data),
            dataType:'html',
            success: function () {
                window.location.replace("http://localhost:8080/admin/user")
            }
        })
    };
</script>
</body>
</html>