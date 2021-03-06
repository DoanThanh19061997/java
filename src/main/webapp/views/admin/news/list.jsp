<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul>
        </div>
        <div class="page-content">
            <c:if test="${not empty message}">
                <div class="alert alert-${alert}">
                        ${message}
                </div>
            </c:if>
            <div class="row">
                <div class="col-xs-12">
                    <div class="widget-box table-filter">
                        <div class="table-btn-controls">
                            <div class="pull-right tableTools-container">
                                <div class="dt-buttons btn-overlap btn-group">
                                    <a flag="info"
                                       class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                       data-toggle="tooltip"
                                       title='Thêm bài viết' href="/admin/news?type=create&id=${item.id}">
<span>
<i class="fa fa-plus-circle bigger-110 purple"></i>
</span>
                                    </a>
                                    <button id="btnDelete" type="button" disabled
                                            class="dt-button buttons-html5 btn btn-white btn-primary btn-bold">
<span>
<i class="fa fa-trash-o bigger-110 pink"></i>
</span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <td>Số thứ tự</td>
                                        <th>Mô tả ngắn</th>
                                        <th>nội dung</th>
                                        <td>thao tác</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${models}">
                                        <tr>
                                            <td>${item.id}</td>
                                            <th>${item.shortDescription}</th>
                                            <th>${item.content}</th>
                                            <th><a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                   title="cap nhap bai viet"
                                                   href="/admin/news?type=edit&id=${item.id}">
                                                <i class="fa fa-pencil-square-o" aria-hidden="true"></i>

                                            </a></th>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>