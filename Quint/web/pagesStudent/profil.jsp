<%-- 
    Document   : profile
    Created on : 11 janv. 2016, 11:58:54
    Author     : Ayyoub
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>QuInt - Profil de l'étudiant</title>

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
        String messages = "";
        HttpSession s = null;
    %>
    <%
        s = request.getSession();
        if (s != null && !s.isNew() && s.getAttribute("email") != null && s.getAttribute("password") != null) {
            email = (String) s.getAttribute("email");
            pswd = (String) s.getAttribute("password");
            messages = (String) s.getAttribute("messages");
        }
    %>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">QuInt v1.0</a>
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>Thales Alinea Space</strong>
                                    <span class="pull-right text-muted">
                                        <em>Hier</em>
                                    </span>
                                </div>
                                <div>Bonjour Mr Ayyoub, je me permets de vous contacter suite à...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>Capgemini</strong>
                                    <span class="pull-right text-muted">
                                        <em>Hier</em>
                                    </span>
                                </div>
                                <div>Bonjour Mr Ayyoub, Vous trouverez ci-joints la fiche que vous...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>IBM</strong>
                                    <span class="pull-right text-muted">
                                        <em>Aujourd'hui à 15:32</em>
                                    </span>
                                </div>
                                <div>Bonjour Mr Ayyoub, je me permets de vous contacter suite à...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="messages.jsp">
                                <strong>Consulter tous les messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="profil.jsp"><i class="fa fa-user fa-fw"></i> Mon Profil</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="SignOutStudent.do"><i class="fa fa-sign-out fa-fw"></i> Se Déconnecter</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="index.jsp"><i class="fa fa-dashboard fa-fw"></i> Accueil</a>
                        </li>
                        <li>
                            <a href="etat.jsp"><i class="fa fa-table fa-fw"></i> Etat des demandes</a>
                        </li>
                        <li>
                            <a href="messages.jsp"><i class="fa fa-table fa-fw"></i> Messages</a>
                        </li> 
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Recherche<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="entreprises.jsp">Par Entreprise</a>
                                </li>
                                <li>
                                    <a href="offres.jsp">Par offre de Stage</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Mon Profil</h1>
                        <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Mes Informations
                        </div>
                        <!-- .panel-heading -->
                        <div class="panel-body">
                            <div class="row">
                                <!--div class="col-lg-6"-->
                                    <form role="form">
                                        <div class="form-group">
                                            <label>Nom</label>
                                            <input class="form-control" placeholder="Hayou">
                                        </div>
                                        <div class="form-group">
                                            <label>Prénom</label>
                                            <input class="form-control" placeholder="Ayyoub">
                                        </div>
                                        <div class="form-group">
                                            <label>E-Mail</label>
                                            <p class="form-control-static">hayou@etud.insa-toulouse.fr</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Filière</label>
                                            <select class="form-control">
                                                <option>5ISS</option>
                                                <option>5IL</option>
                                                <option>5SEC</option>
                                                <option>4IR-RT</option>
                                                <option>4IR-I</option>
                                                <option>4AE</option>
                                                <option>4GM</option>
                                                <option>4GC</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>CV</label>
                                            <input type="file">
                                        </div>
                                        <div class="form-group">
                                            <label>Lettre de Motivation</label>
                                            <input type="file">
                                        </div>
                                        <button type="submit" class="btn btn-default col-md-4" data-toggle="modal" data-target="#enregistre">Sauvegarder</button>
                                        <button type="reset" class="btn btn-default col-md-4 col-md-offset-4">Réinitialiser</button>
                                    </form>
                                <!--/div-->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- .panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

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

