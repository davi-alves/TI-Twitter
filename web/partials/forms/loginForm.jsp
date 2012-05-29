<%-- 
    Document   : loginForm
    Created on : 11/05/2012, 14:42:52
    Author     : davi
--%>

<form id="form-login" method="POST" action="profile">
    <input type="hidden" name="action" value="login">
    <input type="text" id="login" name="username" class="span3" placeholder="Login">
    <input type="password" id="senha" name="password" class="span2" placeholder="Senha">
    <button type="submit" class="btn btn-primary">Entrar</button>
    <br/>
    <a href="" id="forgot-password">Esqueci a senha</a>
</form>
