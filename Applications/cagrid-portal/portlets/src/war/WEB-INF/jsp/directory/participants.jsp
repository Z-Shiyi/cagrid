<c:forEach items="${directoryBean.scroller.page}" var="participant">

	<table border="0" class="contentInnerTable">
		<thead>
			<tr>
				<th class="contentTableHeader" scope="colgroup" colspan="2">
				Participant Details</th>
			</tr>
		</thead>
		<tbody>
			<tr class="dataRowLight">
				<td class="dataCellTextBold leftColumn">Name</td>
				<td class="dataCellText"><c:out value="${participant.name}"/></td>
			</tr>
			<tr class="dataRowDark">
				<td class="dataCellTextBold leftColumn">Institution</td>
				<td class="dataCellText"><c:out value="${participant.institution}"/></td>
			</tr>
			<tr class="dataRowLight">
				<td class="dataCellTextBold leftColumn">Phone</td>
				<td class="dataCellText"><c:out value="${participant.phone}"/></td>
			</tr>
			<tr class="dataRowDark">
				<td class="dataCellTextBold leftColumn">Email</td>
				<td class="dataCellText"><c:out value="${participant.emailAddress}"/></td>
			</tr>
			<tr class="dataRowLight">
				<td class="dataCellTextBold leftColumn">Homepage</td>
				<td class="dataCellText"><a target="_blank" href="<c:out value="${participant.homepageUrl}"/>"/></td>
			</tr>
			<tr class="dataRowDark">
				<td class="dataCellTextBold leftColumn">Address</td>
				<td class="dataCellTextBold">Workspaces</td>
			</tr>
			<tr class="dataRowLight">
				<td class="dataCellText leftColumn">
				<c:if test="${!empty participant.address}">
					Street 1: <c:out value="${participant.address.street1}"/><br/>
					Street 2: <c:out value="${participant.address.street2}"/><br/>
					Locality: <c:out value="${participant.address.locality}"/><br/>
					Postal Code: <c:out value="${participant.address.postalCode}"/><br/>
					State/Province: <c:out value="${participant.address.stateProvince}"/><br/>
					Country: <c:out value="${participant.address.country}"/><br/>
				</c:if>
				</td>
				<td class="dataCellText">
				<c:forEach items="${participant.participation}" var="p">
					<c:out value="${p.workspace.name}"/>: <c:out value="${p.status}"/><br/>
				</c:forEach>
				</td>
			</tr>
		</tbody>
	</table>
	<br/>
	
</c:forEach>
