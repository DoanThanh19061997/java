<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api/admin/category"/>

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
                            <label class="col-sm-3 control-label no-padding-right">Ten</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="name" name="name"
                                       value="${category.name}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="hidden" class="form-control" id="id" name="id" value="${category.id}">
                        </div>
                                                <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <c:if test="${not empty category.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                           value="Cập nhật bài viết"
                                           id="btnAddOrUpdate"/>
                                </c:if>
                                <c:if test="${empty model.id}">
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
        // đọc giá trị nằm trong from
        var formData = $('#formUpdateOrCreate').serializeArray();
        $.each(formData,function (i,v) {
            data[""+v.name+""] = v.value;
        });
        var id=$('#id').val();
        if (id==""){
            addCategory(data);
        } else {
            updateCategory(data);
        }

    });

    function addCategory(data) {
        $.ajax({
            url:'${APIurl}',
            //type = method trong from
            type:'POST',
            contentType:'application/json',
            data: JSON.stringify(data),
            dataType:'html',
            success:function () {
                window.location.replace("http://localhost:8080/admin/category")
            }
        })

    };
    function updateCategory(data) {
        $.ajax({
            url:'${APIurl}',
            type:'PUT',
            contentType:'application/json',
            data: JSON.stringify(data),
            dataType:'html',
            success: function () {
                window.location.replace("http://localhost:8080/admin/category")
            }

        })

    };
</script>
</body>
</html>