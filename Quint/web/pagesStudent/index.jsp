<%-- 
    Document   : index
    Created on : 11 janv. 2016, 11:56:59
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

    <title>QuInt - Page d'Accueil</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="../dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../bower_components/morrisjs/morris.css" rel="stylesheet">

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
        String attente = "";
        String refuse = "";
        String validee = "";
        HttpSession s = null;
    %>
    <%
        s = request.getSession();
        if (s != null && !s.isNew() && s.getAttribute("email") != null && s.getAttribute("password") != null) {
            email = (String) s.getAttribute("email");
            pswd = (String) s.getAttribute("password");
            messages = (String) s.getAttribute("messages");
            attente = (String) s.getAttribute("attente");
            refuse = (String) s.getAttribute("refuse");
            validee = (String) s.getAttribute("validee");
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
                            <a href="AfficherEtat.do"><i class="fa fa-table fa-fw"></i> Etat des demandes</a>
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
                                    <a href="AfficherOffresStudent.do">Par offre de Stage</a>
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

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Bonjour, <%=email%> ! </h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><%=messages%></div>
                                    <div>Nouveaux Messages!</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left" href="messages.jsp">Consulter Vos Messages</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><%=validee%></div>
                                    <div>Demande(s) Validée(s)!</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left" href="etat.jsp">Plus d'Information</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><%=attente%></div>
                                    <div>Demande(s) En Attente!</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left" href="etat.jsp">Plus d'Information</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><%=refuse%></div>
                                    <div>Demande(s) Refusée(s)!</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left" href="etat.jsp">Plus d'Information</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-8">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-clock-o fa-fw"></i> Vos Démarches
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <ul class="timeline">
                                <!-- POUR AFFICHER LES MESSAGES -->
                                <c:forEach var="msg" items="${Msgs}" varStatus="loop">
                                    <li>
                                        <div class="timeline-badge"><i class="fa fa-comments"></i>
                                        </div>
                                        <div class="timeline-panel">
                                            <div class="timeline-heading">
                                                <h4 class="timeline-title">${msg.split(":")[0]}</h4>
                                                <p><small class="text-muted"><i class="fa fa-clock-o"></i> Il y a 1 jour</small>
                                                </p>
                                            </div>
                                            <div class="timeline-body">
                                                <p>${msg.split(":")[1]}</p>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                                    
                                <!-- POUR AFFICHER LES DEMANDES EN ATTENTE -->
                                    <c:forEach var="attente" items="${Attente}" varStatus="loop">
                                    <li class="timeline-inverted">
                                            <div class="timeline-badge warning"><i class="fa fa-clock-o"></i></div>
                                        <div class="timeline-panel">
                                            <div class="timeline-heading">
                                                <h4 class="timeline-title">${attente.split(":")[0]}</h4>
                                                <p><small class="text-muted"><i class="fa fa-clock-o"></i> Il y a 1 jour</small>
                                                </p>
                                            </div>
                                            <div class="timeline-body">
                                                <p>${attente.split(":")[1]}</p>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                                    
                                <!-- POUR AFFICHER LES DEMANDES REFUSEES -->
                                <c:forEach var="refuse" items="${Refusees}" varStatus="loop">
                                    <li>
                                        <div class="timeline-badge danger"><i class="fa fa-bomb"></i>
                                        </div>
                                        <div class="timeline-panel">
                                            <div class="timeline-heading">
                                                <h4 class="timeline-title">${refuse.split("/")[0]}</h4>
                                                <p><small class="text-muted"><i class="fa fa-clock-o"></i> Il y a 2 jour</small>
                                                </p>
                                            </div>
                                            <div class="timeline-body">
                                                <p>${refuse.split("/")[1]}</p>
                                                <p>${refuse.split("/")[2]}</p>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                                    
                                <!-- POUR AFFICHER LES DEMANDES VALIDEES -->
                                <c:forEach var="val" items="${Validees}" varStatus="loop">
                                    <li>
                                        <div class="timeline-badge success"><i class="fa fa-check"></i>
                                        </div>
                                        <div class="timeline-panel">
                                            <div class="timeline-heading">
                                                <h4 class="timeline-title">${val.split(":")[0]}</h4>
                                                <p><small class="text-muted"><i class="fa fa-clock-o"></i> Il y a 3 jour</small>
                                                </p>
                                            </div>
                                            <div class="timeline-body">
                                                <p>${val.split(":")[1]}</p>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                                    
                                    
<!--                                <li>
                                    <div class="timeline-badge"><i class="fa fa-comments"></i>
                                    </div>
                                    <div class="timeline-panel">
                                        <div class="timeline-heading">
                                            <h4 class="timeline-title">Thales Aleniea Space</h4>
                                            <p><small class="text-muted"><i class="fa fa-clock-o"></i> Il y a 1 jour</small>
                                            </p>
                                        </div>
                                        <div class="timeline-body">
                                            <p>Bonjour Mr Ayyoub, Je me permet de vous contacter suite à notre entretien téléphonique. Je vous confirme notre intérêt et nous
                                                souhaitons vous faire une proposition de stage. J'aimerai avoir votre réponse dans un délai inférieur à une semaine...</p>
                                        </div>
                                    </div>
                                </li>
                                <li class="timeline-inverted">
                                    <div class="timeline-badge warning"><i class="fa fa-clock-o"></i>
                                    </div>
                                    <div class="timeline-panel">
                                        <div class="timeline-heading">
                                            <h4 class="timeline-title">IBM</h4>
                                            <p><small class="text-muted"><i class="fa fa-clock-o"></i> Il y a 1 jour</small>
                                            </p>
                                        </div>
                                        <div class="timeline-body">
                                            <p>Votre demande de validation de stage est mise en attente. Elle sera soit validée soit refusée par les responsables d'études dans 
                                                les plus brefs délais.</p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="timeline-badge danger"><i class="fa fa-bomb"></i>
                                    </div>
                                    <div class="timeline-panel">
                                        <div class="timeline-heading">
                                            <h4 class="timeline-title">Nuclear Bungladish</h4>
                                            <p><small class="text-muted"><i class="fa fa-clock-o"></i> Il y a 2 jour</small>
                                            </p>
                                        </div>
                                        <div class="timeline-body">
                                            <p>Votre demande de stage a été refusée par le responsable de sécurité.</p>
                                            <p>Motif: Localisation du stage dangereuse pour l'étudiant.</p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="timeline-badge success"><i class="fa fa-check"></i>
                                    </div>
                                    <div class="timeline-panel">
                                        <div class="timeline-heading">
                                            <h4 class="timeline-title">Capgemini</h4>
                                            <p><small class="text-muted"><i class="fa fa-clock-o"></i> Il y a 3 jour</small>
                                            </p>
                                        </div>
                                        <div class="timeline-body">
                                            <p>Votre demande de stage a été validée par les responsables d'études.</p>
                                        </div>
                                    </div>
                                </li>-->



                            </ul>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-8 -->
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bell fa-fw"></i> Nouvelles Offres sur le Site
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="list-group">
                                <c:forEach var="offre" items="${Offres}" varStatus="loop">
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-briefcase fa-fw"></i> ${offre}
                                        <span class="pull-right text-muted small"><em>4 minutes ago</em>
                                        </span>
                                    </a>
                                </c:forEach>
                            </div>
                            <!-- /.list-group -->
                            <a href="AfficherOffresStudent.do" class="btn btn-default btn-block">Voir Toutes les Offres</a>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                </div>
                <!-- /.col-lg-4 -->
            </div>
            <!-- /.row -->
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

    <!-- Morris Charts JavaScript -->
    <script src="../bower_components/raphael/raphael-min.js"></script>
    <script src="../bower_components/morrisjs/morris.min.js"></script>
    <script src="../js/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>

