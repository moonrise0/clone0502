<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let login_form = {
        init:function() {
            $("#login_btn").click( () => {
                login_form.send();
            });
        },
        send:function() {
            $("#login_form").attr({
                'action':'/loginimpl',
                'method':'post'
            });
            $("#login_form").submit();
        }
    };
    $(function() {
        login_form.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="page-header">
        <h1>Login</h1>
    </div>
    <div class="alert alert-danger alert-dismissible">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
        <strong>DANGER!</strong> You can be hacked by me.
    </div>
    <div class="well">This page is for login. Please fill in the blanks with your ID and password.</div>
    <br/>
    <form id="login_form">
        <div class="form-group">
            <label for="id">ID :</label>
            <input type="id" class="form-control" name="id" id="id">
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" name="pwd" id="pwd">
        </div>
        <button type="button" id="login_btn" class="btn btn-default">login</button>
    </form>
</div>