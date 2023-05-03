<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let rgs_form = {
        init:() => {
            $('#rgs_btn').attr('disabled',true);
            $("#rgs_btn").click( () => {
                rgs_form.send();
            });
            $('#name').keyup( () => {
                let id = $('#id').val();
                let pwd = $('#pwd').val();
                let name = $('#name').val();
                if(id!=''&&pwd!=''&&name!=''){
                    $('#rgs_btn').attr('disabled', false);
                };
            });
            $("#id").keyup( () => {
                let txt_id = $('#id').val();
                if(txt_id.length<=3) {
                    return;
                } else {
                    $.ajax({
                        url:'/checkid',
                        data:{'id':txt_id},
                        success: function(result){
                            if(result == 0){
                                $('#check_id').text('사용 가능한 ID입니다');
                                $('#pwd').focus();
                            } else {
                                $('#check_id').text('사용 불가능한 ID입니다');
                            }
                        },
                    });
                }
            })
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
            $("#rgs_form").attr({
                'action':'/rgsimpl',
                'method':'post'
            });
            $("#rgs_form").submit();
        }
    };
    $( () => {
        rgs_form.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="page-header">
        <h1>Register</h1>
    </div>
    <div class="alert alert-danger alert-dismissible">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
        <strong>DANGER!</strong> Your information can be used for me.
    </div>
    <div class="well">This page is for register. Please fill in the blanks with your information.</div>
    <br/>
    <form id="rgs_form" class="form-horizontal">
        <div class="form-group">
            <label class="control-label col-sm-2" for="id">ID:</label>
            <div class="col-sm-10">
                <input type="id" class="form-control" name="id" id="id" placeholder="Enter ID">
            </div>
            <div class="col-sm-10">
                <span id="check_id" class="bg-danger"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Password:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="pwd" id="pwd" placeholder="Enter password">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-10">
                <input type="name" class="form-control" name="name" id="name" placeholder="Enter name">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" id="rgs_btn" class="btn btn-default">register</button>
            </div>
        </div>
    </form>
</div>