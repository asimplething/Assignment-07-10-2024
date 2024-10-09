<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
		<div class="modal fade" id="portlet-config" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title">Modal title</h4>
					</div>
					<div class="modal-body">Widget settings form goes here</div>
					<div class="modal-footer">
						<button type="button" class="btn blue">Save changes</button>
						<button type="button" class="btn default" data-dismiss="modal">Close</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

		<!-- BEGIN PAGE HEADER-->
		<h3 class="page-title">
			Editable Datatables <small>editable datatable samples</small>
		</h3>
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
					class="fa fa-angle-right"></i></li>
				<li><a href="#">Data Tables</a> <i class="fa fa-angle-right"></i>
				</li>
				<li><a href="#">Editable Datatables</a></li>
			</ul>
			<div class="page-toolbar">
				<div class="btn-group pull-right">
					<button type="button"
						class="btn btn-fit-height grey-salt dropdown-toggle"
						data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
						data-close-others="true">
						Actions <i class="fa fa-angle-down"></i>
					</button>
					<ul class="dropdown-menu pull-right" role="menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN EXAMPLE TABLE PORTLET-->
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-edit"></i>Editable Table
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse"> </a> <a
								href="#portlet-config" data-toggle="modal" class="config"> </a>
							<a href="javascript:;" class="reload"> </a> <a
								href="javascript:;" class="remove"> </a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="row">
								<div class="col-md-6">
									<div class="btn-group">
										<button id="sample_editable_1_new" class="btn green" onclick="window.location.href='<c:url value='/admin/category/add'/>';">
											Add New <i
												class="fa fa-plus"></i>
										</button>
									</div>
								</div>
								<div class="col-md-6">
									<div class="btn-group pull-right">
										<button class="btn dropdown-toggle" data-toggle="dropdown">
											Tools <i class="fa fa-angle-down"></i>
										</button>
										<ul class="dropdown-menu pull-right">
											<li><a href="#"> Print </a></li>
											<li><a href="#"> Save as PDF </a></li>
											<li><a href="#"> Export to Excel </a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<table class="table table-striped table-hover table-bordered"
							id="sample_editable_1">
							<thead>
								<tr>
									<th>STT</th>
									<th>Images</th>
									<th>Category Name</th>
									<th>Status</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listcate}" var="cate" varStatus="STT">
									<tr>
										<td>${STT.index+1 }</td>
										<c:if test="${cate.images.substring(0,5)=='https'}">
											<c:url value="${cate.images}" var="imgUrl"></c:url>
										</c:if>
										<c:if test="${cate.images.substring(0,5)!='https'}">
											<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
										</c:if>
										<td><img height="90" width="120" src="${imgUrl}" /></td>
										<td>${cate.categoryname }</td>
										<td><a
											href="<c:url value='/admin/category/status?id=${cate.categoryid}&status=${cate.status}'/>">${cate.status }</a></td>
										<td><a
											href="<c:url value='/admin/category/edit?id=${cate.categoryid}'/>">Edit</a>
										</td>
										<td><a
											href="<c:url value='/admin/category/delete?id=${cate.categoryid}'/>">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<!-- END EXAMPLE TABLE PORTLET-->
			</div>
		</div>
		<!-- END PAGE CONTENT -->
	</div>
</div>