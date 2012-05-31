<%-- 
    Document   : messages
    Created on : 30/05/2012, 22:36:12
    Author     : Davi
--%>
<c:if test="${message != null && message.getText() != null && !message.getText().isEmpty()}">
    <div class="alert alert-${message.getType()} span10">
        <a class="close" data-dismiss="alert" href="#">×</a>
        <c:if test="${message.getType() == 'error'}">
            <strong>ERROR!</strong>
        </c:if>
        ${message.getText()}
    </div>
</c:if>
