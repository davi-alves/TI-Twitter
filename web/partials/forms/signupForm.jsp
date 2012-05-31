<%-- 
    Document   : signupForm
    Created on : 29/05/2012, 19:44:13
    Author     : davi
--%>

<form id="form-signup" method="post" action="signup">
    <input type="hidden" name="action" value="signup"/>
    <input type="text" name="name" id="name" class="span4" placeholder="Nome" 
           value="${userSignup.getName()}"/>
    <input type="text" name="email" id="email" class="span4" placeholder="Email" 
           value="${userSignup.getEmail()}"/>
    <select name="sex" id="sex">
        <option value="Masculino">Masculino</option>
        <option value="Feminino">Feminino</option>
    </select>
    <input type="text" name="username" id="username" class="span4" placeholder="Login"/>
    <input type="password" name="password" id="password" class="span4" placeholder="Senha" 
           value="${userSignup.getPassword()}"/>
    <button type="submit" class="btn btn-large btn-warning btn-signup">Criar minha conta</button>
</form>