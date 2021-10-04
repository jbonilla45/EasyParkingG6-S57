var app = angular.module('EasyParkingG6S57', []);

app.controller('ctlrOperador', function ($scope, $http) {

    var alertPlaceholder = document.getElementById('liveAlertPlaceholder');

    function alertBootstrap(message, type) {
        var wrapper = document.createElement('div')
        wrapper.innerHTML = '<div class="alert alert-' + type + ' alert-dismissible" role="alert">' + message + '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>'

        alertPlaceholder.append(wrapper)
    }

    $scope.guardarOperador = function () {
        let regexNumbers = /^[0-9]*$/;

        if ($scope.nombre === undefined || $scope.apellido === undefined || $scope.cargo === undefined) {
            alert('Todos los campos son obligatorios');

        } else {
            console.log('Entra a guardar Operador');
            let operador = {
                proceso: 'guardarOperador',
                nombre: $scope.nombre,
                apellido: $scope.apellido,
                cargo: $scope.cargo,
            };

            $http({
                method: 'POST',
                url: 'Peticiones.jsp',
                params: operador
            }).then(function (respuesta) {
                console.log(respuesta);
                if (respuesta.data.guardarOperador) {
                    alert('Guardado Exitoso');
                    $scope.listarOperador();
                } else {
                    alert('Error al guardar en la BD');
                }
            }).catch(function (error) {
                alert('Servicio no disponible, intente más tarde!');
                console.log(error);
            });
        }
    };

    $scope.listarOperador = function () {
        $scope.mostrarListaOperador = true;
        let params = {
            proceso: 'listarOperador'
        };

        $http({
            method: 'GET',
            url: 'Peticiones.jsp',
            params: params
        }).then(function (respuesta) {
            $scope.operadores = respuesta.data.Operador;
            console.log($scope.operadores);
        });
    };

    $scope.eliminarOperador = function () {
        let params = {
            proceso: 'eliminarOperador',
            id: $scope.id
        };
        $http({
            method: 'GET',
            url: 'Peticiones.jsp',
            params: params
        }).then(function (respuesta) {
            if (respuesta.data.eliminarOperador) {
                alertBootstrap('Operador eliminado exitosamente!', 'success');
                $scope.listarOperador();
            } else {
                alert('Error al eliminar operador');
            }
        });
    };

    $scope.actualizarOperador = function () {
        let params = {
            proceso: 'actualizarOperador',
            id: $scope.id,
            nombre: $scope.nombre,
            apellido: $scope.apellido,
            cargo:$scope.cargo,

        };

        $http({
            method: 'GET',
            url: 'Peticiones.jsp',
            params: params
        }).then(function (respuesta) {
            if (respuesta.data.actualizarOperador) {
                alert('Actualización exitosa');
                $scope.listarOperador();
            } else {
                alert('No se pudo actualizar');
            }
            console.log(respuesta);
        });
    };

    $scope.mostrarFormulario = function () {
        $scope.mostrarListaOperador = false;
    };

    $scope.mostrarFormActualizar = function (operador) {
        $scope.mostrarListaOperador = false;
        $scope.actualizar = true;
        $scope.id = operador.id;
        $scope.nombre = operador.nombre;
        $scope.apellido = operador.apellido;
        $scope.cargo = operador.cargo;
    };

    $scope.abrirModal = function (id) {
        $scope.id = id;
        var myModal = new bootstrap.Modal(document.getElementById('exampleModal'), {
            keyboard: false
        });
        myModal.show();
    };
});

