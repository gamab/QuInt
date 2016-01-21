<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>QuInt - Consulter une offre</title>

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
                                    <div>Bonjour Mr Ayyoub, je me permets de vous contacter suite Ã ...</div>
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
                                            <em>Aujourd'hui Ã  15:32</em>
                                        </span>
                                    </div>
                                    <div>Bonjour Mr Ayyoub, je me permets de vous contacter suite Ã ...</div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="text-center" href="#">
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
                            <li><a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i> Se DÃ©connecter</a>
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
                                <a href="offres.jsp"><i class="fa fa-table fa-fw"></i> Mes offres</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-sitemap fa-fw"></i> Recherche<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="etudiants.jsp">Par étudiant</a>
                                    </li>
                                    <li>
                                        <a href="candidatures.jsp">Par candidatures</a>
                                    </li>
                                    <li>
                                        <a href="offres.jsp">Par offre de stage</a>
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
                            <h1 class="page-header">Votre offre de stage</h1>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            Nom de l'offre
                                        </div>
                                        <!-- .panel-heading -->
                                        <div class="panel-body">
                                            <div class="panel-body">
                                                <%
                                                    String title = (String) request.getAttribute('internships').getTitle();
                                                    String description = (String) request.getAttribute('internships').getDescription();
                                                    String salary = (String) request.getAttribute('internships').getSalary();
                                                    String personInCharge = (String) request.getAttribute('internships').getPersonInCharge();
                                                    String phoneNumber = (String) request.getAttribute('internships').getPhoneNumber();
                                                    String department = (String) request.getAttribute('internships').getDepartment();
                                                    String location = (String) request.getAttribute('internships').getLocation();
                                                    String provided = (String) request.getAttribute('internships').getProvided();
                                                    String postDate = (String) request.getAttribute('internships').getPostDate();
                                                    String id = (String) request.getAttribute('internships').getId();
                                                %>
                                                <h3>Titre :</h3><% out.print(title); %>
                                                    <h4>Description :</h4><% out.print(description); %>
                                                    <h4>Indemnité :</h4><% out.print(salary); %>
                                                    <h4>Responsable :</h4><% out.print(personInCharge); %>
                                                    <h4>Téléphone :</h4><% out.print(phoneNumber); %>
                                                    <h4>Departement :</h4><% out.print(department); %>
                                                    <h4>Localisation :</h4><% out.print(location); %>
                                                    <h4>Disponibilité :</h4><% out.print(provided); %>
                                                    <h5>Posté le :</h5><% out.print(postDate); %>
                                                <div>
                                                    <a role="button" class="btn btn-success col-md-2 col-md-offset-0" href="modifier.jsp">Éditer</a>
                                                    <a role="button" class="btn btn-danger col-md-2 col-md-offset-8" href="supprimeroffre.do?id=<% out.print(id); %>">Supprimer</button>
                                                </div>                             
                                            </div>
                                        </div>
                                        <!-- .panel-body -->
                                    </div>
                                    <!-- /.panel -->
                                </div>
                                <!-- /.col-lg-12 -->
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <h1 class="page-header">Les candidatures</h1>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="panel panel-default">
                                        <!-- .panel-heading -->
                                        <div class="panel-body">
                                            <div class="panel-group" id="accordion">
                                                <% cp = 0; %>
                                                <c:forEach var="internship" items="${interships}" varStatus="loop">
                                                    <c:set var="number" value="${['One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten']}" scope="application" />
                                                    <% cp++; %>
                                                    <div class="panel panel-default">
                                                        <div class="panel-heading">
                                                            <h4 class="panel-title">
                                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse${number}">Candidature n°<% out.print(cp); %> : ${internship.getNom}</a>
                                                            </h4>
                                                        </div>
                                                        <div id="collapse${number}" class="panel-collapse collapse in">
                                                            <div class="panel-body">
                                                                <h3>Motivation :</h3>${internship.getLM}
                                                                <h4>Département : </h4>${internship.getDepartement}
                                                                <h4>Niveau : </h4>${internship.getNiveau}
                                                                <h4>Stage : </h4>${internship.getStatut}
                                                                <h4>Disponibilités : </h4>${internship.getDisponibilite}
                                                                <br><br>
                                                                <div>
                                                                    <a href="${internship.getCV}" target="_blank"><button type="button" class="btn btn-primary col-md-2 col-md-offset-0">CV</button></a>
                                                                    <a type="button" class="btn btn-success col-md-2 col-md-offset-5" href="pagesCompany/acceptercandidat.do">Accepter</a>
                                                                    <a type="button" class="btn btn-danger col-md-2 col-md-offset-1" href="pagesCompany/refusercandidat.do?email=${internship.getEmail}&id=<% out.print(id); %>">Refuser</a>
                                                                </div> 
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:foreach>
                                            </div>
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