<%@ include file="/WEB-INF/jsp/include/includes.jspf"%>
<div style="min-height:500px">
<c:choose>
<c:when test="${!empty confirmationMessage}">
<span style="color:green;font-size:115%"><c:out value="${confirmationMessage}"/></span><br/>
You may now <a href="/web/guest/login">log in</a>, or return to the <a href="/web/guest/home">home page</a>.
<br/>
<br/>
You provided the following information:
<br/>
<br/>
	<table>
		<tr>
			<td style="padding-right:5px; text-align:right">
				First Name:
			</td>
			<td>
				<c:out value="${application.firstName}"/>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Last Name:
			</td>
			<td>
				<c:out value="${application.lastName}"/>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Username:
			</td>
			<td>
				<c:out value="${application.userId}"/>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Email:
			</td>
			<td>
				<c:out value="${application.email}"/>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Phone:
			</td>
			<td>
				<c:out value="${application.phoneNumber}"/>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Organization:
			</td>
			<td>
				<c:out value="${application.organization}"/>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Street Address 1:
			</td>
			<td>
				<c:out value="${application.address}"/>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Street Address 2:
			</td>
			<td>
				<c:out value="${application.address2}"/>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				City:
			</td>
			<td>
				<c:out value="${application.city}"/>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				State:
			</td>
			<td>
				<c:out value="${application.state}"/>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Postal Code:
			</td>
			<td>
				<c:out value="${application.zipcode}"/>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Country:
			</td>
			<td>
				<c:out value="${application.country}"/>
			</td>
		</tr>
	</table>
</c:when>
<c:otherwise>
<b>Username Constraints:</b>
<ul>
	<li>Must be between 4 and 15 characters in length.</li>
</ul>
<br/>
<b>Password Constraints:</b><br/>
<ul>
	<li>
Must be between 10 and 20 characters and
CANNOT contain a dictionary word and MUST 
contain at least one upper case letter, at least one lower 
case letter, at least one number, and at least one symbol 
(~!@#$%^&*()_-+={}[]|:;&lt;&gt;,.?).
	</li>

</ul>
<p/>

<br/>

<c:set var="formName"><portlet:namespace/>registerForm</c:set>
<portlet:actionURL var="action"/>
<form:form name="${formName}" action="${action}" commandName="application">
	<span style="color:red">
		<form:errors path="*"/>
	</span>
	<table>
		<tr>
			<td style="padding-right:5px; text-align:right">
				First Name:
			</td>
			<td>
				<form:input path="firstName" size="50"/>&nbsp;<span style="color:red">*</span><br/>
				<span style="color:red"><form:errors path="firstName"/></span>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Last Name:
			</td>
			<td>
				<form:input path="lastName" size="50"/>&nbsp;<span style="color:red">*</span><br/>
				<span style="color:red"><form:errors path="lastName"/></span>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Username:
			</td>
			<td>
				<form:input path="userId" size="50"/>&nbsp;<span style="color:red">*</span><br/>
				<span style="color:red"><form:errors path="userId"/></span>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Password:
			</td>
			<td>
				<form:password path="password" size="50"/>&nbsp;<span style="color:red">*</span><br/>
				<span style="color:red"><form:errors path="password"/></span>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Email:
			</td>
			<td>
				<form:input path="email" size="50"/>&nbsp;<span style="color:red">*</span><br/>
				<span style="color:red"><form:errors path="email"/></span>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Phone:
			</td>
			<td>
				<form:input path="phoneNumber" size="50"/>&nbsp;<span style="color:red">*</span><br/>
				<span style="color:red"><form:errors path="phoneNumber"/></span>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Organization:
			</td>
			<td>
				<form:input path="organization" size="50"/>&nbsp;<span style="color:red">*</span><br/>
				<span style="color:red"><form:errors path="organization"/></span>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Street Address 1:
			</td>
			<td>
				<form:input path="address" size="50"/>&nbsp;<span style="color:red">*</span><br/>
				<span style="color:red"><form:errors path="address"/></span>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Street Address 2:
			</td>
			<td>
				<form:input path="address2" size="50"/><br/>
				<span style="color:red"><form:errors path="address2"/></span>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				City:
			</td>
			<td>
				<form:input path="city" size="50"/>&nbsp;<span style="color:red">*</span><br/>
				<span style="color:red"><form:errors path="city"/></span>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				State:
			</td>
			<td>
				<form:select path="state" items="${stateCodes}"/><br/>
				<span style="color:red"><form:errors path="state"/></span>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Postal Code:
			</td>
			<td>
				<form:input path="zipcode" size="50"/>&nbsp;<span style="color:red">*</span><br/>
				<span style="color:red"><form:errors path="zipcode"/></span>
			</td>
		</tr>
		<tr>
			<td style="padding-right:5px; text-align:right">
				Country:
			</td>
			<td>
				<form:select path="country" items="${countryCodes}"/>&nbsp;<span style="color:red">*</span><br/>
				<span style="color:red"><form:errors path="country"/></span>
			</td>
		</tr>
		<tr>
			<td></td>
			<td style="padding-top:5px;">
				<input type="submit" value="Submit"/>
			</td>
		</tr>
	</table>
	
</form:form>
<br/>
<span style="color:red">*</span> Indicates that a field is required.
</c:otherwise>
</c:choose>
</div>