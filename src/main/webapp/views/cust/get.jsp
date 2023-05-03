<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    //   let rgs_form = {
    //   init:() => {
    //     $("#rgs_btn").click( () => {
    //       rgs_form.send();
    //     });
    //   },
    //   send:() => {
    //     $("#rgs_form").attr({
    //       'action':'/rgsimpl',
    //       'method':'get'
    //     });
    //     $("#rgs_form").submit();
    //   }
    // };
    //
    // $( () => {
    //   rgs_form.init();
    // });
</script>

<div class="col-sm-8 text-left">
    <div class="page-header">
        <h1>Detail</h1>
    </div>
    <div class="alert alert-danger alert-dismissible">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
        <strong>DANGER!</strong> Your information can be used for me.
    </div>
    <div class="well">This page is for register. Please fill in the blanks with your information.</div>
    <br/>
    <form id="update_form" class="form-horizontal">
        <div class="form-group">
            <label class="control-label col-sm-2" for="id">ID:</label>
            <div class="col-sm-10">
                <input type="id" class="form-control" name="id" id="id" value="${gcust.id}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Password:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="pwd" id="pwd" value="${gcust.pwd}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-10">
                <input type="name" class="form-control" name="name" id="name" value="${gcust.name}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" id="update_btn" class="btn btn-default">Update</button>
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" id="remove_btn" class="btn btn-default">Remove</button>
            </div>
        </div>
    </form>
</div>