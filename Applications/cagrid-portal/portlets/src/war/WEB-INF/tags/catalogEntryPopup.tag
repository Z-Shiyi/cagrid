<%@tag %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="id" required="true" %>
<%@attribute name="entry" required="true" type="gov.nih.nci.cagrid.portal.domain.catalog.CatalogEntry" %>
<%@attribute name="link_href" required="false"
             description="Alternate link. Will not use popup image. Requires link_text" %>
<%@attribute name="link_text" required="false" description="Alternate link text.Required when specifying link_href" %>


<a id="${id}-infoPopup-control"
   class="infoPopupLink"
   onmouseover="$('${id}-infoPopup-content').style.display='inline'"
   onmouseout="$('${id}-infoPopup-content').style.display='none'"
        <c:if test="${not empty link_href}">
            &nbsp; href='${link_href}'
        </c:if>
        >
    <c:choose>
        <c:when test="${not empty link_text}">
            ${link_text}
        </c:when>
        <c:otherwise>
            <tags:image name="information_icon.png" height="13"/>
        </c:otherwise>
    </c:choose>
</a>&nbsp;

    <span id="${id}-infoPopup-content" class="infoPopup">
    <div>

        <c:if test="${not empty entry.name}">
            <div class="row">
                <div class="label">
                    Name:
                </div>
                <div class="infoPopupValue value">
                        ${entry.name}
                </div>
            </div>
        </c:if>


        <c:if test="${not empty entry.description}">
            <div class="row">
                <div class="label">
                    Description:
                </div>
                <div class="infoPopupValue value">
                        ${entry.description}
                </div>
            </div>
        </c:if>

        <c:if test="${not empty entry.createdAt}">
            <div class="row">
                <div class="label">
                    Created on:
                </div>
                <div class="infoPopupValue value">
                        ${entry.createdAt}
                </div>
            </div>
        </c:if>


        <c:if test="${not empty entry.contributor}">
            <div class="row">
                <div class="label">
                    Contributed by:
                </div>
                <div class="infoPopupValue value">
                        ${entry.contributor.name}
                </div>
            </div>
        </c:if>


    </div>

    <span class="infoPopup-pointer">&nbsp;</span></span>
