<%@ include file="/common/taglibs.jsp"%>
 
<head>
    <title><fmt:message key="exam.title"/></title>
    <meta name="menu" content="Home"/>
</head>
 
<div class="col-sm-3">
    <h2></h2>
</div>

<div class="col-sm-6">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <form:form commandName="examform" method="post" action="examform" cssClass="well" id="examform" modelAttribute="examform">
        <%-- <form:hidden path="id"/>
        
        <spring:bind path="question.title">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
        <appfuse:label key="question.title" styleClass="control-label"/>
        <form:input cssClass="form-control" path="title" id="title" maxlength="50"/>
        <form:errors path="title" cssClass="help-block"/>
        </div>
        <spring:bind path="question.description">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
        <appfuse:label key="question.answer" styleClass="control-label"/>
        <form:input cssClass="form-control" path="description" id="description" maxlength="50"/>
        <form:errors path="description" cssClass="help-block"/>
        </div> --%>
 

 		
       <table class="table table-condensed table-striped table-hover">
		    <tbody><tr>
		        <th><appfuse:label key="question.id" /></th>
		        <th><appfuse:label key="questionList.questions" /></th>
		        <th><appfuse:label key="question.answer" /></th>
		    </tr>
			    <c:forEach items="${examform.questionList}" var="question" varStatus="status">
			     <tr>
		            <td align="center">${status.count}</td>
		            <td>${question.description}</td>
		            <td><input name="ans${status.index}" maxlength="50"></td>
		         </tr>
		         </c:forEach>
		    </tbody>
		</table>    
 		<input type="hidden" name="counter" value="${examform.questionSize}"></input>
        <div class="form-group">
            <button type="submit" class="btn btn-primary" id="save" name="save" onclick="doSubmit(this.form);">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.done"/>
            </button>
        </div>
    </form:form>
</div>
 
<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['examform']).focus();
    });
    
</script>

<script type="text/javascript">
    
    function doSubmit(form){
    	var val = "";
    	
    	for (i = 0; i < form.counter.value; i++) {
    		var temp = document.getElementsByName("ans"+i)[0];
    		if(val == ""){
    			val = temp.value;
    		}else{
    			val = val + "|" + temp.value;
    		}
    	}
    	
    	var element = document.createElement("INPUT");
        element.setAttribute("type", "hidden");
        element.setAttribute("name", "ans");
        element.setAttribute("value", val);
        form.appendChild(element);
        form.submit();
    }
    
</script>