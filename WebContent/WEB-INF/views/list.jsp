<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Static Tables | Nifty - Admin Template</title>


    <!--STYLESHEET-->
    <!--=================================================-->

    <!--Open Sans Font [ OPTIONAL ]-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>


    <!--Bootstrap Stylesheet [ REQUIRED ]-->
    <spring:url value="/resources/css/bootstrap.css" var="boostrap" />
    <link href="${boostrap}" rel="stylesheet">


    <!--Nifty Stylesheet [ REQUIRED ]-->
    <spring:url value="/resources/css/nifty.css" var="nifty" />
    <link href="${nifty}" rel="stylesheet">
</head>
<body>

  <div class="panel">
    <div class="panel-heading">
        <h3 class="panel-title">Sample 리스트</h3>
    </div>
	<c:out value="${memberList}"></c:out>
    <!--Data Table-->
    <!--===================================================-->
    <div class="panel-body">
        <div class="pad-btm form-inline">
            <div class="row">
                <div class="col-sm-6 table-toolbar-left">
                    <button id="demo-btn-addrow" class="btn btn-purple"><i class="demo-pli-add"></i> Add</button>
                </div>
                <div class="col-sm-6 table-toolbar-right">
                    <div class="form-group">
                        <input id="demo-input-search2" type="text" placeholder="Search" class="form-control" autocomplete="off">
                        <button id="demo-btn-addrow" class="btn btn-purple"><i class="demo-pli-add"></i> Search</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th class="text-center">Invoice</th>
                        <th>User</th>
                        <th>Order date</th>
                        <th>Amount</th>
                        <th>Status</th>
                        <th>Tracking Number</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><a class="btn-link" href="#"> Order #53431</a></td>
                        <td>Steve N. Horton</td>
                        <td><span class="text-muted"><i class="demo-pli-clock"></i> Oct 22, 2014</span></td>
                        <td>$45.00</td>
                        <td>
                            <div class="label label-table label-success">Paid</div>
                        </td>
                        <td>-</td>
                    </tr>
                </tbody>
            </table>
        </div>
         <!--Pagination-->
         <div class="text-center">
          <ul class="pagination mar-no">
              <li class="disabled"><a href="#">이전</a></li>
              <li class="active"><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li><a href="#">3</a></li>
              <li><a href="#">4</a></li>
              <li><span>...</span></li>
              <li><a href="#">20</a></li>
              <li><a href="#">다음</a></li>
          </ul>
      </div>
    </div>
    <!--===================================================-->
    <!--End Data Table-->

  </div>
</body>