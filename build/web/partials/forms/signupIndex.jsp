<%-- 
    Document   : signupIndex
    Created on : 11/05/2012, 14:50:41
    Author     : davi
--%>

<form id="form-signup" method="POST" action="signup">
    <input type="hidden" name="action" value="form"/>
    <input type="text" id="name" name="name" class="span3" placeholder="Nome">
    <input type="text" id="email" name="email" class="span3" placeholder="Email">
    <input type="password" id="password" name="password" class="span3" placeholder="Senha">
    <button type="submit" class="btn btn-warning btn-signup">Cadastra-se no Twitter</button>
</form>