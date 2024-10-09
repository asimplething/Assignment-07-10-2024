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
					<form class="form-group"
						action="<c:url value="/admin/category/insert"/>" method="post"
						enctype="multipart/form-data">
						<label class="form-label" for="fname">Category name:</label><br>
						<input class="form-input" type="text" id="fname"
							name="categoryname"><br> <label class="form-label"
							for="lname">Link Images:</label><br> <input
							class="form-input" type="text" id="lname" name="images">
						<label class="form-label" for="lname">Upload Images:</label><br>
						<input class="form-input" type="file" id="lname1" name="images1">
						<label class="form-label" for="lname">Status: </label>
							<div class="div-radio"><input
							class="form-radio" type="radio" id="ston" name="status" value="1"><label class="form-label" for="ston">Active </label><br> <input
							class="form-input" type="radio" id="stoff" name="status"
							value="0"> <label class="form-label" for="stoff">Lock
						</label></div>
						<input class="form-submit" type="submit" value="Insert">
					</form>
				</div>
				<!-- END EXAMPLE TABLE PORTLET-->
			</div>
		</div>
		<!-- END PAGE CONTENT -->
	</div>
</div>