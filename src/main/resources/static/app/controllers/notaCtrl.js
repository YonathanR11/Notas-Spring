app.controller("NotaControlador", function ($scope, notaService, sessionFactory) {

    // Function PARA MOSTRAR LAS NOTAS AL INICIO
    $scope.obtenerNotas = function ($window) {
        $scope.user = sessionFactory.get("usuario");
        if ($scope.user) {
            notaService.getById($scope.user.id).then((data) => {
                $scope.notas = data;
            }, (reject) => {
                Swal.fire({
                    position: 'center',
                    type: 'error',
                    title: 'Error',
                    text: 'Ocurrio un error al ver las notas',
                    showConfirmButton: false,
                    timer: 3000
                })
            });
        } else {
            window.location.href = "#!/login";
        }
    }

    // Function PARA MOSTRAR EL DIV NUEVANOTA
    $scope.btnNuevaNota = function () {
        $scope.nota = {
            // status : 1
            fecha: new Date()
        };
    }

    $scope.editar = function (nota) {
        $scope.nota = nota;
        $scope.nota.fecha = new Date(nota.fecha);
    }

    $scope.cancelar = function () {
        $scope.nota = null;
        $scope.obtenerNotas();
    }
    $scope.submitNota = function (valid) {
        if (valid) {
            if ($scope.nota.id) {
                //    actualizar nota
                $scope.editarNota();
            } else {
                //    guardar nota
                $scope.nota.usuario = $scope.user;
                $scope.guardarNota();
            }

        }
    }
    // Function PARA GUARDAR UNA NOTA NUEVA
    $scope.guardarNota = function () {
        notaService.post($scope.nota).then((data) => {
            if (data === true) {
                Swal.fire({
                    position: 'center',
                    type: 'success',
                    title: 'Guardada con exito',
                    showConfirmButton: false,
                    timer: 1500
                })
                $scope.obtenerNotas();
            } else {
                Swal.fire({
                    position: 'center',
                    type: 'error',
                    title: 'Error',
                    text: 'Algo salio mal...',
                    showConfirmButton: false,
                    timer: 3000
                })
            }
            $scope.nota = null;
        }, (reject) => {
            Swal.fire({
                position: 'center',
                type: 'error',
                title: 'Error',
                text: 'Ocurrio un error al guardar',
                showConfirmButton: false,
                timer: 3000
            })
        });
    }

    // Function PARA ACTUALIZAR UNA NOTA ESPECIFICA
    $scope.editarNota = function () {
        notaService.put($scope.nota).then((data) => {
            if (data === true) {
                Swal.fire({
                    position: 'center',
                    type: 'success',
                    title: 'Actualizada con exito',
                    showConfirmButton: false,
                    timer: 1500
                })
                $scope.obtenerNotas();
            } else {
                Swal.fire({
                    position: 'center',
                    type: 'error',
                    title: 'Error',
                    text: 'Rellene los campos',
                    showConfirmButton: false,
                    timer: 3000
                })
            }
            $scope.nota = null;
        }, (reject) => {
            Swal.fire({
                position: 'center',
                type: 'error',
                title: 'Error',
                text: 'Ocurrio un error al actualizar',
                showConfirmButton: false,
                timer: 3000
            })
        });
    }

    // Function PARA ELIMINAR UNA NOTA ESPECIFICA
    $scope.eliminar = function (nota) {
        $scope.notaE = nota;
        Swal.fire({
            title: '¿Esta seguro?',
            text: "Esta accion no se puede revertir!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Eliminar'
        }).then((result) => {
            if (result.value) {
                notaService.delete($scope.notaE).then((data) => {
                    if (data === true) {
                        Swal.fire({
                            position: 'center',
                            type: 'success',
                            title: 'Eliminado',
                            text: '¡La nota se elimino correctamente!',
                            showConfirmButton: false,
                            timer: 1000
                        })
                        $scope.obtenerNotas();
                    } else {
                        Swal.fire({
                            position: 'center',
                            type: 'error',
                            title: 'Error',
                            text: 'Ocurrio un error al eliminar',
                            showConfirmButton: false,
                            timer: 3000
                        })
                    }
                    $scope.notaE = null;
                }, (reject) => {
                    Swal.fire({
                        position: 'center',
                        type: 'error',
                        title: 'Error',
                        text: reject.data.message.toString(),
                        showConfirmButton: true,
                        timer: 5000
                    })
                });
            }
        })
    }

    const INITCONTROLLER = function () {
        $scope.obtenerNotas()
    }

    angular.element(document).ready(function () {
        INITCONTROLLER();
    });
});
