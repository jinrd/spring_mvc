<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생등록화면</title>
</head>
<body>
	<h2>학생 정보 등록</h2>
	<form method="post" action="add/student.do">
		<table>
			<tr>
				<td>
					<label>id</label>
				</td>
				<td>
					<input type="text" name="id"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>이름</label>
				</td>
				<td> 
					<input type="text" name = "name"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>나이</label>
				</td>
				<td>
					<input type="text" name="age"></input>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장" />
				</td>
			</tr>
		</table>

	</form>

</body>
</html>