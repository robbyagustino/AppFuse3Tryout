<%@ include file="/common/taglibs.jsp"%>
 
<head>
    <title><fmt:message key="exam.title"/></title>
    <meta name="menu" content="UserMenu"/>
</head>


<display:table name="questionList" class="table table-condensed table-striped table-hover" requestURI=""
               id="questionList" export="false" pagesize="25">
               
    <display:column property="id" sortable="false" media="html"
        paramId="id" paramProperty="id" titleKey="question.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="question.id"/>
    <display:column property="title" sortable="false" titleKey="question.title"/>
    <display:column property="description" sortable="false" titleKey="question.description"/>
    <display:column property="answer" sortable="false" titleKey="question.answer"/>
 
    <%-- <display:setProperty name="paging.banner.item_name"><fmt:message key="questionList.question"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="questionList.questions"/></display:setProperty>
  --%>
</display:table>

<%-- <div id="actions" class="btn-group">
    <a href='<c:url value="/exams"/>'  class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
</div> --%>