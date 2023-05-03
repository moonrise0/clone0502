<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let cinfo_form = {
        init:() => {
            $("#cinfo_btn").click( () => {
                cinfo_form.send();
            });
        },
        send:() => {
            let id = $('#id').val();
            let pwd = $('#pwd').val();
            let name = $('#name').val();
            if(id.length<=3) {
                $('#check_id').text('4자리 이상이어야 합니다.');
                $('#id').focus();
                return;
            }
            if(pwd == ''){
                $('#pwd').focus();
                return;
            }
            if(name == ''){
                $('#name').focus();
                return;
            }
            $("#cinfo_form").attr({
                'action':'/custinfoimpl',
                'method':'post'
            });
            $("#cinfo_form").submit();
        }
    };
    $( () => {
        cinfo_form.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="page-header">
        <h1>Customer Information</h1>
    </div>
    <div class="well">This page is for confirming and modifying your information.</div>
    <br/>
    <form id="cinfo_form" class="form-horizontal">
        <div class="form-group">
            <label class="control-label col-sm-2" for="id">ID:</label>
            <div class="col-sm-10">
                <input type="id" class="form-control" name="id" id="id" value="${custinfo.id}" readonly>
            </div>
            <div class="col-sm-10">
                <span id="check_id" class="bg-danger"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Password:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="pwd" id="pwd">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-10">
                <input type="name" class="form-control" name="name" id="name" value="${custinfo.name}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" id="cinfo_btn" class="btn btn-default">Modify</button>
            </div>
        </div>
    </form>
</div>