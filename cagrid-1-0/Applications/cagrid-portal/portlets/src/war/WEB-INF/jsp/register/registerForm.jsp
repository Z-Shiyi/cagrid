<%@ include file="/WEB-INF/jsp/include/includes.jspf"%>

<b>Username Constraints:</b>
<ul>
	<li>Must be between 4 and 10 characters in length.</li>
</ul>
<br/>
<b>Password Constraints:</b><br/>
<ul>
	<li>
Must be between 6 and 10 characters and
CANNOT contain a dictionary word and MUST 
contain at least one upper case letter, at least one lower 
case letter, at least one number, and at least one symbol 
(~!@#$%^&*()_-+={}[]|:;&lt;&gt;,.?).
	</li>

</ul>
<p/>
<span style="color:green"><c:out value="${confirmationMessage}"/></span>
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