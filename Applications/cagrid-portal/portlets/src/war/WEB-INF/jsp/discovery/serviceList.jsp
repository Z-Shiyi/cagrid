<%@ include file="/WEB-INF/jsp/include.jsp" %>

<h1>Services</h1>
<br/>
<p>
<c:choose>
	<c:when test="${empty gridServicesInRange}">
No grid services to display.
	</c:when>
	<c:otherwise>
<div class="scrollControls">
	<c:choose>
		<c:when test="${!empty first}">
 <a href="<portlet:renderURL>
 	<portlet:param name="action" value="listServices"/>
  	<portlet:param name="offset">
       	<jsp:attribute name="value">
           	<c:out value="${first}"/>
           </jsp:attribute>
    </portlet:param>
  		 </portlet:renderURL>"
    alt="Scroll To First">
	&lt;&lt;
 </a>
 		</c:when>
 		<c:otherwise>
 	&lt;&lt;
 		</c:otherwise>
 	</c:choose>
 |  	
<c:choose>
		<c:when test="${!empty previous}">
 <a href="<portlet:renderURL>
 	<portlet:param name="action" value="listServices"/>
  	<portlet:param name="offset">
       	<jsp:attribute name="value">
           	<c:out value="${previous}"/>
           </jsp:attribute>
    </portlet:param>
  		 </portlet:renderURL>"
    alt="Scroll To Previous">
	&lt;
 </a>
 		</c:when>
 		<c:otherwise>
 	&lt;
 		</c:otherwise>
 	</c:choose> 
 |
 <c:choose>
		<c:when test="${!empty next}">
 <a href="<portlet:renderURL>
 	<portlet:param name="action" value="listServices"/>
  	<portlet:param name="offset">
       	<jsp:attribute name="value">
           	<c:out value="${next}"/>
           </jsp:attribute>
    </portlet:param>
  		 </portlet:renderURL>"
    alt="Scroll To Next">
	&gt;
 </a>
 		</c:when>
 		<c:otherwise>
 	&gt;
 		</c:otherwise>
 	</c:choose>
 |
<c:choose>
		<c:when test="${!empty last}">
 <a href="<portlet:renderURL>
 	<portlet:param name="action" value="listServices"/>
  	<portlet:param name="offset">
       	<jsp:attribute name="value">
           	<c:out value="${last}"/>
           </jsp:attribute>
    </portlet:param>
  		 </portlet:renderURL>"
    alt="Scroll To Last">
	&gt;&gt;
 </a>
 		</c:when>
 		<c:otherwise>
 	&gt;&gt;
 		</c:otherwise>
 	</c:choose> 
</div>

<table border="0" cellpadding="4">

   <tr>
      <th>Name</th>
      <th>Status</th>
      <%--
      <th>First Seen</th>
      <th>Last Seen</th>
      --%>

   </tr>
   <c:forEach items="${gridServicesInRange}" var="gridService">
   
   	<tr>
   		<td>
             <a href="<portlet:actionURL>
                         <portlet:param name="action" value="selectService"/>
                         <portlet:param name="sgs_id">
                             <jsp:attribute name="value">
                                 <c:out value="${gridService.id}"/>
                             </jsp:attribute>
                         </portlet:param>
                      </portlet:actionURL>"
                 alt="Select Service">
                <c:out value="${gridService.serviceMetadata.serviceDescription.name}"/>
             </a>
   			
   		</td>
   		<td>
   			<c:out value="${gridService.status}"/>
   		</td>
   		<%--
   		<td>
   			<fmt:formatDate value="${gridService.firstSeen}" 
   				type="both" dateStyle="full" timeStyle="medium"/>
   		</td>
   		<td>
   			<fmt:formatDate value="${gridService.lastSeen}" 
   				type="both" dateStyle="full" timeStyle="medium"/>
   		</td>
   		--%>
   	</tr>
   
   </c:forEach>
   
</table>
	</c:otherwise>
</c:choose>
</p>