<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageName" value="DAYARY" />
<%@ include file="../part/head.jspf"%>

<h1 class="con">LOGIN</h1>

<form id="login__form">
	<div class="table-box con">
		<table>
			<tbody>
				<tr>
					<th>ID</th>
					<td><input type="text" name="loginId" placeholder="ID 입력해주세요"
						autofocus="autofocus" /></td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td><input type="password" name="password"
						placeholder="PASSWORD 입력해주세요" /></td>
				</tr>
				<tr>
					<th>SUBMIT</th>
					<td><button type="button" id="btn__login">로그인</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="j">
		<table>
			<tbody>
				<tr>
					<th>you wanna join?</th>
					<br />
					<td><input type="submit" value="click" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</form>

<script>
	$('#btn__login').on('click',function(){
		$.ajax({
			url:'/member/login',
			type:'post',
			dataType:'json',
			data: $('#login__form').serialize(),
			success:function(data){
				if(data.status.code=='GOOD'){
					location.href='/diary/list';
				}else{
					alert(data.status.message);
				}
			},
			error:function(err){
				console.log('/member/login');
			}
		});
	});
</script>

<%@ include file="../part/foot.jspf"%>
