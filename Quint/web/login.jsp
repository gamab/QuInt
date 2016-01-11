<%-- 
    Document   : login
    Created on : 9 déc. 2015, 16:01:11
    Author     : Ayyoub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>QuInt - Bienvenue !</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <%!
        String email = "";
        String pswd = "";
        String msgErreur = "";
        HttpSession s = null;
    %>
    <%
        s = request.getSession();
        if (s != null && !s.isNew() && s.getAttribute("email") != null && s.getAttribute("password") != null) {
            email = (String) s.getAttribute("email");
            pswd = (String) s.getAttribute("password");
        }
        if (s.getAttribute("msgErreur") != null) {
            msgErreur = (String) s.getAttribute("msgErreur");
        }
    %>
    
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Veuillez vous connecter</h3>
                    </div>
                    <div class="panel-body">
                        <%-- Si il y a un message d'erreur on l'affiche dans un encadré --%>
                        <% if (msgErreur != "") {%>
                        <div class ="alert alert-danger" role="alert">
                            <span class ="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class ="sr-only">Error</span>
                            <%=msgErreur%>
                            <%
                                s.removeAttribute("msgErreur");
                                msgErreur = "";
                            %>
                        </div>
                        <% }%>
                        
                        <form role="form" role="form" class="form-horizontal" method="post" action="/QuInt/SignInStudent.do" accept-charset="utf-8">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" value="<%=email%>" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Mot de Passe" name="password" type="password" value="<%=pswd%>">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Garder ma session ouverte
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <a type="submit" class="btn btn-lg btn-success btn-block">Se Connecter</a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
