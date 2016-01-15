<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>QuInt - Etat des Demandes</title>

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
                        <h1 class="page-header">Candidatures en cours</h1>
                        <div class="row">
                        <div class="panel-body">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title" style="display:inline-block;">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Consultant Java/J2EE</a>
                                        </h4>
                                             > 
                                            <a href="offres.jsp" style="display:inline-block;"> Aller vers l'offre</a>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <div class="dataTable_wrapper">
                                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                                    <tbody>
                                                        <tr>
                                                            <td>
                                                                <div>
                                                                    <h4><a href="etudiants.jsp"><strong>Alexandre Demeyer</strong></a></h4>
                                                                    <h4>Motivations</h4> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                                                    <h4>DisponibilitÃ©s</h4> 15/02/2016 au 29/07/2016
                                                                    <h4>Ãcole</h4> <a href="#">INSA de Toulouse</a>
                                                                </div>
                                                                <div>
                                                                
                                                                    <p>
                                                                        <button type="button" class="btn btn-info col-md-2">Curriculum</button>
                                                                        <button type="button" class="btn btn-success btn-circle btn-lg col-md-1 col-md-offset-7"><i class="fa fa-check"></i></button>
                                                                        <a href="refuser.jsp"><button type="button" class="btn btn-danger btn-circle btn-lg col-md-1 col-md-offset-1"><i class="fa fa-times"></i></button></a>
                                                                        <!--<button type="button" class="btn btn-success col-md-2 col-md-offset-3">Accepter</button>
                                                                        <button type="button" class="btn btn-danger col-md-2 col-md-offset-3">Refuser</button>-->
                                                                    </p> 
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <div>
                                                                    <h4><a href="etudiants.jsp"><strong>Marcel Pagnol</strong></a></h4>
                                                                    <h4>Motivations</h4> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                                                    <h4>DisponibilitÃ©s</h4> 15/02/2016 au 29/07/2016
                                                                    <h4>Ãcole</h4> <a href="#">INSA de Toulouse</a>
                                                                </div>
                                                                <div>
                                                                    <p>
                                                                        <button type="button" class="btn btn-info col-md-2">Curriculum</button>
                                                                        <a href="accepter.jsp"><button type="button" class="btn btn-primary btn-circle btn-lg col-md-1 col-md-offset-7"><i class="fa fa-list"></i></button></a>
                                                                        <a href="refuser.jsp"><button type="button" class="btn btn-danger btn-circle btn-lg col-md-1 col-md-offset-1"><i class="fa fa-times"></i></button></a>
                                                                        <!--<button type="button" class="btn btn-success col-md-2 col-md-offset-3">Accepter</button>
                                                                        <button type="button" class="btn btn-danger col-md-2 col-md-offset-3">Refuser</button>-->
                                                                    </p> 
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <div>
                                                                    <h4><a href="etudiants.jsp"><strong>AmÃ©lie Poulin</strong></a></h4>
                                                                    <h4>Motivations</h4> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                                                    <h4>DisponibilitÃ©s</h4> 15/02/2016 au 29/07/2016
                                                                    <h4>Ãcole</h4> <a href="#">INSA de Toulouse</a>
                                                                </div>
                                                                <div>
                                                                    <p>
                                                                        <button type="button" class="btn btn-info col-md-2">Curriculum</button>
                                                                        <button type="button" class="btn btn-success btn-circle btn-lg col-md-1 col-md-offset-7"><i class="fa fa-check"></i></button>
                                                                        <a href="refuser.jsp"><button type="button" class="btn btn-danger btn-circle btn-lg col-md-1 col-md-offset-1"><i class="fa fa-times"></i></button></a>
                                                                        <!--<button type="button" class="btn btn-success col-md-2 col-md-offset-3">Accepter</button>
                                                                        <button type="button" class="btn btn-danger col-md-2 col-md-offset-3">Refuser</button>-->
                                                                    </p> 
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>                                       
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title" style="display:inline-block;">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Stage Cloud Computing</a>
                                        </h4>
                                             > 
                                            <a href="offres.jsp" style="display:inline-block;"> Aller vers l'offre</a>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <div class="dataTable_wrapper">
                                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                                    <tbody>
                                                        <tr>
                                                            <td>
                                                                <div>
                                                                    <h4><a href="etudiants.jsp"><strong>Alexandre Demeyer</strong></a></h4>
                                                                    <h4>Motivations</h4> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                                                    <h4>DisponibilitÃ©s</h4> 15/02/2016 au 29/07/2016
                                                                    <h4>Ãcole</h4> <a href="#">INSA de Toulouse</a>
                                                                </div>
                                                                <div>
                                                                    <p>
                                                                        <button type="button" class="btn btn-info col-md-2">Curriculum</button>
                                                                        <button type="button" class="btn btn-success btn-circle btn-lg col-md-1 col-md-offset-7"><i class="fa fa-check"></i></button>
                                                                        <a href="refuser.jsp"><button type="button" class="btn btn-danger btn-circle btn-lg col-md-1 col-md-offset-1"><i class="fa fa-times"></i></button></a>
                                                                        <!--<button type="button" class="btn btn-success col-md-2 col-md-offset-3">Accepter</button>
                                                                        <button type="button" class="btn btn-danger col-md-2 col-md-offset-3">Refuser</button>-->
                                                                    </p> 
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <div>
                                                                    <h4><a href="etudiants.jsp"><strong>Marcel Pagnol</strong></a></h4>
                                                                    <h4>Motivations</h4> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                                                    <h4>DisponibilitÃ©s</h4> 15/02/2016 au 29/07/2016
                                                                    <h4>Ãcole</h4> <a href="#">INSA de Toulouse</a>
                                                                </div>
                                                                <div>
                                                                    <p>
                                                                        <button type="button" class="btn btn-info col-md-2">Curriculum</button>
                                                                        <button type="button" class="btn btn-success btn-circle btn-lg col-md-1 col-md-offset-7"><i class="fa fa-check"></i></button>
                                                                        <a href="refuser.jsp"><button type="button" class="btn btn-danger btn-circle btn-lg col-md-1 col-md-offset-1"><i class="fa fa-times"></i></button></a>
                                                                        <!--<button type="button" class="btn btn-success col-md-2 col-md-offset-3">Accepter</button>
                                                                        <button type="button" class="btn btn-danger col-md-2 col-md-offset-3">Refuser</button>-->
                                                                    </p> 
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <div>
                                                                    <h4><a href="etudiants.jsp"><strong>AmÃ©lie Poulin</strong></a></h4>
                                                                    <h4>Motivations</h4> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                                                    <h4>DisponibilitÃ©s</h4> 15/02/2016 au 29/07/2016
                                                                    <h4>Ãcole</h4> <a href="#">INSA de Toulouse</a>
                                                                </div>
                                                                <div>
                                                                    <p>
                                                                        <button type="button" class="btn btn-info col-md-2">Curriculum</button>
                                                                        <button type="button" class="btn btn-success btn-circle btn-lg col-md-1 col-md-offset-7"><i class="fa fa-check"></i></button>
                                                                        <a href="refuser.jsp"><button type="button" class="btn btn-danger btn-circle btn-lg col-md-1 col-md-offset-1"><i class="fa fa-times"></i></button></a>
                                                                        <!--<button type="button" class="btn btn-success col-md-2 col-md-offset-3">Accepter</button>
                                                                        <button type="button" class="btn btn-danger col-md-2 col-md-offset-3">Refuser</button>-->
                                                                    </p> 
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>                                       
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title" style="display:inline-block;">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Stage DÃ©veloppement JAVA/Android</a>
                                        </h4>
                                             > 
                                            <a href="offres.jsp" style="display:inline-block;"> Aller vers l'offre</a>
                                    </div>
                                    <div id="collapseThree" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <div class="dataTable_wrapper">
                                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                                    <tbody>
                                                        <tr>
                                                            <td>
                                                                <div>
                                                                    <h4><a href="etudiants.jsp"><strong>Alexandre Demeyer</strong></a></h4>
                                                                    <h4>Motivations</h4> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                                                    <h4>DisponibilitÃ©s</h4> 15/02/2016 au 29/07/2016
                                                                    <h4>Ãcole</h4> <a href="#">INSA de Toulouse</a>
                                                                </div>
                                                                <div>
                                                                    <p>
                                                                        <button type="button" class="btn btn-info col-md-2">Curriculum</button>
                                                                        <button type="button" class="btn btn-success btn-circle btn-lg col-md-1 col-md-offset-7"><i class="fa fa-check"></i></button>
                                                                        <a href="refuser.jsp"><button type="button" class="btn btn-danger btn-circle btn-lg col-md-1 col-md-offset-1"><i class="fa fa-times"></i></button></a>
                                                                        <!--<button type="button" class="btn btn-success col-md-2 col-md-offset-3">Accepter</button>
                                                                        <button type="button" class="btn btn-danger col-md-2 col-md-offset-3">Refuser</button>-->
                                                                    </p> 
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>                                       
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title" style="display:inline-block;">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">Stage DÃ©veloppement C++</a>
                                        </h4>
                                             > 
                                            <a href="offres.jsp" style="display:inline-block;"> Aller vers l'offre</a>
                                    </div>
                                    <div id="collapseFour" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <div class="dataTable_wrapper">
                                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                                    <tbody>
                                                        <tr>
                                                            <td>
                                                                <div>
                                                                    <h4><a href="etudiants.jsp"><strong>Alexandre Demeyer</strong></a></h4>
                                                                    <h4>Motivations</h4> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                                                    <h4>DisponibilitÃ©s</h4> 15/02/2016 au 29/07/2016
                                                                    <h4>Ãcole</h4> <a href="#">INSA de Toulouse</a>
                                                                </div>
                                                                <div>
                                                                    <p>
                                                                        <button type="button" class="btn btn-info col-md-2">Curriculum</button>
                                                                        <button type="button" class="btn btn-success btn-circle btn-lg col-md-1 col-md-offset-7"><i class="fa fa-check"></i></button>
                                                                        <a href="refuser.jsp"><button type="button" class="btn btn-danger btn-circle btn-lg col-md-1 col-md-offset-1"><i class="fa fa-times"></i></button></a>
                                                                        <!--<button type="button" class="btn btn-success col-md-2 col-md-offset-3">Accepter</button>
                                                                        <button type="button" class="btn btn-danger col-md-2 col-md-offset-3">Refuser</button>-->
                                                                    </p> 
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <div>
                                                                    <h4><a href="etudiants.jsp"><strong>Marcel Pagnol</strong></a></h4>
                                                                    <h4>Motivations</h4> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                                                    <h4>DisponibilitÃ©s</h4> 15/02/2016 au 29/07/2016
                                                                    <h4>Ãcole</h4> <a href="#">INSA de Toulouse</a>
                                                                </div>
                                                                <div>
                                                                    <p>
                                                                        <button type="button" class="btn btn-info col-md-2">Curriculum</button>
                                                                        <button type="button" class="btn btn-success btn-circle btn-lg col-md-1 col-md-offset-7"><i class="fa fa-check"></i></button>
                                                                        <a href="refuser.jsp"><button type="button" class="btn btn-danger btn-circle btn-lg col-md-1 col-md-offset-1"><i class="fa fa-times"></i></button></a>
                                                                        <!--<button type="button" class="btn btn-success col-md-2 col-md-offset-3">Accepter</button>
                                                                        <button type="button" class="btn btn-danger col-md-2 col-md-offset-3">Refuser</button>-->
                                                                    </p> 
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>                                       
                                    </div>
                                </div>
                            </div>
                        </div>
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
