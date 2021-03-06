<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Easy Parking S57 G6</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous"/>
    <style>
        #titulo-principal {
            font-size: 57px;
        }

        #head {
            background: black;
            padding: 12px;
        }

        #imgJava{
            height: 400px;
        }
    </style>
</head>
<body>
<header class="navbar navbar-expand-md navbar-dark bd-navbar" id="head">
    <ul class="nav nav-pills ">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="paginaAplicacion.jsp">Tablero de control</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Parking.jsp">Tabla Parquedero</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Operador.jsp">Tabla Operador</a>
        </li>
    </ul>
</header>

<div class="masthead mb-3 ">
    <div class="container px-4 px-md-3 shadow p-3 mb-5 bg-body rounded">
        <div class="row align-items-lg-center">
            <div class="col-md-12">
                <a href="paginaAplicacion.jsp">
                    <img src="tablero.jpg" class="img-fluid" alt="...">
                </a>
            </div>
        </div>
        <br>
        <div class="row align-items-lg-center">
            <div class="col-md-12 text-center text-md-start">
                <h1 class="mb-3 text-center" id="titulo-principal">Easy Parking APP</h1>
                <p class="lead mb-4">Easy Parking APP es el resultado de lo aprendido durante los ciclos 1, 2 y 3 del
                    programa MISION TIC 2021.
                    Este programa a través de diferentes universidades, en nuestro caso la
                    Universidad Industrial de Santander,
                    se propone formar 100.000 jóvenes y adultos colombianos en programación, para enfrentar los desafíos
                    de la Cuarta Revolución Industrial.
                </p>
                <p class="lead mb-4">
                    Recibimos formación en lenguajes de programación tales como Python, Java, MySql y para
                    el ciclo actual en Desarrollo de Software. Como resultado, se propuso obtener un aplicativo WEB que
                    solucionara la problemática habitual de un parqueadero de vehículos.
                </p>
                <p class="lead mb-4">Apoyados en metodologías como SCRUM, control de versiones con la herramienta
                    GitHub,
                    uso de frameworks como BOOSTRAP y ANGULAR, logramos producir el aplicativo Easy Parking del cual
                    estaremos hablando a continuación.</p>
            </div>
        </div>
    </div>
</div>

<div class="container masthead-followup px-4 px-md-3">
    <section class="row mb-5 pb-md-4 align-items-center shadow p-3 mb-5 bg-body rounded">
        <div class="col-md-5">
            <svg color="" xmlns="http://www.w3.org/2000/svg" width="48" height="48" fill="currentColor"
                 class="bi bi-people-fill" viewBox="0 0 16 16">
                <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                <path fill-rule="evenodd"
                      d="M5.216 14A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216z"/>
                <path d="M4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z"/>
            </svg>
            <h2 class="display-5 fw-normal">EQUIPO DE TRABAJO</h2>
        </div>
        <div class="col-md-7">

            <div class="card-group">
                <div class="card text-center    ">
                    <img src="https://ingenieria.bogota.unal.edu.co/images/man.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">David</h5>
                        <p class="card-text"><small class="text-muted">Sanabria</small></p>
                    </div>
                </div>
                <div class="card text-center">
                    <img src="https://ingenieria.bogota.unal.edu.co/images/man.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Alex</h5>
                        <p class="card-text"><small class="text-muted">Reyes</small></p>
                    </div>
                </div>
                <div class="card text-center">
                    <img src="https://ingenieria.bogota.unal.edu.co/images/man.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Daniel </h5>
                        <p class="card-text"><small class="text-muted">González</small></p>
                    </div>
                </div>
                <div class="card text-center">
                    <img src="2019-02-10 16.53.38.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Jorge</h5>
                        <p class="card-text"><small class="text-muted">Bonilla</small></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="row mb-5 pb-md-4 align-items-center shadow p-3 mb-5 bg-body rounded">
        <div class="col-md-7">
            <svg color="" xmlns="http://www.w3.org/2000/svg" width="48" height="48" fill="currentColor"
                 class="bi bi-person-plus" viewBox="0 0 16 16">
                <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H1s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C9.516 10.68 8.289 10 6 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
                <path fill-rule="evenodd"
                      d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
            </svg>
            <h2 class="display-5 fw-normal">INSTRUCTORES</h2>
        </div>
        <div class="col-md-5">
            <p class="lead mb-4">Tatiana Albarracín</p>
            <p class="lead mb-4">Jorge Saul</p>
        </div>
    </section>
    <section class="row mb-5 pb-md-4 align-items-center shadow p-3 mb-5 bg-body rounded">
        <div class="col-md-6">
            <svg color="" xmlns="http://www.w3.org/2000/svg" width="48" height="48" fill="currentColor"
                 class="bi bi-puzzle-fill" viewBox="0 0 16 16">
                <path d="M3.112 3.645A1.5 1.5 0 0 1 4.605 2H7a.5.5 0 0 1 .5.5v.382c0 .696-.497 1.182-.872 1.469a.459.459 0 0 0-.115.118.113.113 0 0 0-.012.025L6.5 4.5v.003l.003.01c.004.01.014.028.036.053a.86.86 0 0 0 .27.194C7.09 4.9 7.51 5 8 5c.492 0 .912-.1 1.19-.24a.86.86 0 0 0 .271-.194.213.213 0 0 0 .036-.054l.003-.01v-.008a.112.112 0 0 0-.012-.025.459.459 0 0 0-.115-.118c-.375-.287-.872-.773-.872-1.469V2.5A.5.5 0 0 1 9 2h2.395a1.5 1.5 0 0 1 1.493 1.645L12.645 6.5h.237c.195 0 .42-.147.675-.48.21-.274.528-.52.943-.52.568 0 .947.447 1.154.862C15.877 6.807 16 7.387 16 8s-.123 1.193-.346 1.638c-.207.415-.586.862-1.154.862-.415 0-.733-.246-.943-.52-.255-.333-.48-.48-.675-.48h-.237l.243 2.855A1.5 1.5 0 0 1 11.395 14H9a.5.5 0 0 1-.5-.5v-.382c0-.696.497-1.182.872-1.469a.459.459 0 0 0 .115-.118.113.113 0 0 0 .012-.025L9.5 11.5v-.003l-.003-.01a.214.214 0 0 0-.036-.053.859.859 0 0 0-.27-.194C8.91 11.1 8.49 11 8 11c-.491 0-.912.1-1.19.24a.859.859 0 0 0-.271.194.214.214 0 0 0-.036.054l-.003.01v.002l.001.006a.113.113 0 0 0 .012.025c.016.027.05.068.115.118.375.287.872.773.872 1.469v.382a.5.5 0 0 1-.5.5H4.605a1.5 1.5 0 0 1-1.493-1.645L3.356 9.5h-.238c-.195 0-.42.147-.675.48-.21.274-.528.52-.943.52-.568 0-.947-.447-1.154-.862C.123 9.193 0 8.613 0 8s.123-1.193.346-1.638C.553 5.947.932 5.5 1.5 5.5c.415 0 .733.246.943.52.255.333.48.48.675.48h.238l-.244-2.855z"/>
            </svg>
            <h2 class="display-5 fw-normal">COMPONENTES</h2>
            <p class="lead fw-normal">El aplicativo ha sido modelado en lenguaje de programación <strong>JAVA y MYSQL
                para la parte del backend y HTML, JSP,
                y JAVASCRIPT para la parte del frontend.</strong> Se compone de 3 objetos que son el parqueadero, el
                operador y el vehículo.</p>

        </div>
        <div class="col-md-6 text-center">
            <img width="200px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Duke_%28Java_mascot%29_waving.svg/333px-Duke_%28Java_mascot%29_waving.svg.png" class="img-fluid">

        </div>
    </section>
    <section class="row mb-5 pb-md-4 align-items-center shadow p-3 mb-5 bg-body rounded">
        <div class="col-md-7">
            <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" fill="currentColor" class="bi bi-wrench"
                 viewBox="0 0 16 16">
                <path d="M.102 2.223A3.004 3.004 0 0 0 3.78 5.897l6.341 6.252A3.003 3.003 0 0 0 13 16a3 3 0 1 0-.851-5.878L5.897 3.781A3.004 3.004 0 0 0 2.223.1l2.141 2.142L4 4l-1.757.364L.102 2.223zm13.37 9.019.528.026.287.445.445.287.026.529L15 13l-.242.471-.026.529-.445.287-.287.445-.529.026L13 15l-.471-.242-.529-.026-.287-.445-.445-.287-.026-.529L11 13l.242-.471.026-.529.445-.287.287-.445.529-.026L13 11l.471.242z"/>
            </svg>
            <h2 class="display-5 fw-normal">FUNCIONAMIENTO</h2>
            <p class="lead fw-normal">El aplicativo cuenta con dos formularios con funciones <strong>CRUD (create, read,
                update & delete) </strong>para los objetos
                parqueadero y operador. Por último se creó un tablero de control desde el cual se registran la entrada y
                salida de vehículos</p>

        </div>
        <div class="col-md-5">
            <img src="https://images.squarespace-cdn.com/content/555dc243e4b0fa866e3e41a9/1495710943180-41DBCCE9I7ZLXLDFLEJY/?content-type=image%2Fpng" class="img-fluid">
            <p></p>
        </div>
    </section>
    <section class="row mb-5 pb-md-4 align-items-center shadow p-3 mb-5 bg-body rounded">
        <div class="col-md-5">
            <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" fill="currentColor"
                 class="bi bi-cloud-moon-fill" viewBox="0 0 16 16">
                <path d="M11.473 11a4.5 4.5 0 0 0-8.72-.99A3 3 0 0 0 3 16h8.5a2.5 2.5 0 0 0 0-5h-.027z"/>
                <path d="M11.286 1.778a.5.5 0 0 0-.565-.755 4.595 4.595 0 0 0-3.18 5.003 5.46 5.46 0 0 1 1.055.209A3.603 3.603 0 0 1 9.83 2.617a4.593 4.593 0 0 0 4.31 5.744 3.576 3.576 0 0 1-2.241.634c.162.317.295.652.394 1a4.59 4.59 0 0 0 3.624-2.04.5.5 0 0 0-.565-.755 3.593 3.593 0 0 1-4.065-5.422z"/>
            </svg>
            <h2 class="display-5 fw-normal">EN EL FUTURO</h2>
        </div>
        <div class="col-md-7">
            <p class="lead fw-normal">Incluir autenticación para los operadores y el ingreso al aplicativo</p>
        </div>
    </section>
    <section class="row mb-5 pb-md-4 align-items-center shadow p-3 mb-5 bg-body rounded">
        <div class="col-md-12">
            <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" fill="currentColor"
                 class="bi bi-hand-thumbs-up-fill" viewBox="0 0 16 16">
                <path d="M6.956 1.745C7.021.81 7.908.087 8.864.325l.261.066c.463.116.874.456 1.012.965.22.816.533 2.511.062 4.51a9.84 9.84 0 0 1 .443-.051c.713-.065 1.669-.072 2.516.21.518.173.994.681 1.2 1.273.184.532.16 1.162-.234 1.733.058.119.103.242.138.363.077.27.113.567.113.856 0 .289-.036.586-.113.856-.039.135-.09.273-.16.404.169.387.107.819-.003 1.148a3.163 3.163 0 0 1-.488.901c.054.152.076.312.076.465 0 .305-.089.625-.253.912C13.1 15.522 12.437 16 11.5 16H8c-.605 0-1.07-.081-1.466-.218a4.82 4.82 0 0 1-.97-.484l-.048-.03c-.504-.307-.999-.609-2.068-.722C2.682 14.464 2 13.846 2 13V9c0-.85.685-1.432 1.357-1.615.849-.232 1.574-.787 2.132-1.41.56-.627.914-1.28 1.039-1.639.199-.575.356-1.539.428-2.59z"/>
            </svg>
            <h2 class="display-5 fw-normal">AGRADECIMIENTOS</h2>

            <p class="lead mb-4"> a Dios por ponernos en este camino</p>
            <p class="lead mb-4">a nuestra Familia por el apoyo y la paciencia</p>
            <p class="lead mb-4">a nuestros compañeros por su compromiso dedicación</p>
            <p class="lead mb-4">a la UIS por facilitar los medios de aprendizaje y por la calidad de los mismos</p>
            <p class="lead mb-4">a el MINTIC por ofrecer esta oportunidad de formación</p>
            <p class="lead mb-4">...y al cafe Sello Rojo por acompañarnos durante estas 600 horas de esfuerzos</p>
        </div>
    </section>
</div>


</body>
</html>