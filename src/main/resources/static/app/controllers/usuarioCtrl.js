app.controller("usuarioControlador", function ($scope, usuarioService) {

    // Function PARA MOSTRAR LOS USUARIOS AL INICIO
    $scope.mostrarUsuarios = function () {
        usuarioService.get().then((data) => {
            $scope.usuarios = data;
        }, (reject) => {
            Swal.fire({
                position: 'center',
                type: 'error',
                title: 'Error',
                text: 'Ocurrio un error',
                showConfirmButton: false,
                timer: 3000
            })
        });
    }

    // Function PARA MOSTRAR EL DIV NUEVANOTA
    $scope.btnNuevoUsuario = function () {
        $scope.usuario = {
            estatus : 1
        };
    }

    // Boton de cancelar para agregar o actualizar usuario
    $scope.cancelarU = function () {
        $scope.usuario = null;
        $scope.mostrarUsuarios();
    }

    // Verifica que el formulario sea valido
    $scope.submitUsuario = function (valid) {
        if (valid) {
            if ($scope.usuario.id) {
                //    actualizar nota
                $scope.editarUsuario();
            } else {
                //    guardar nota
                $scope.guardarUsuario();
            }

        }
    }

    // Function PARA GUARDAR UN usuario NUEVo
    $scope.guardarUsuario = function () {
        usuarioService.post($scope.usuario).then((data) => {
            if (data === true) {
                Swal.fire({
                    position: 'center',
                    type: 'success',
                    title: 'Guardado con exito',
                    showConfirmButton: false,
                    timer: 1500
                })
                $scope.mostrarUsuarios();
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
            $scope.usuario = null;
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

    $scope.editarUser = function (usuario) {
        $scope.usuario = usuario;
        $scope.usuario.estatus = 1;
    }

    // Function PARA ACTUALIZAR UNA NOTA ESPECIFICA
    $scope.editarUsuario = function () {
        usuarioService.put($scope.usuario).then((data) => {
            if (data === true) {
                Swal.fire({
                    position: 'center',
                    type: 'success',
                    title: 'Actualizado con exito',
                    showConfirmButton: false,
                    timer: 1500
                })
                $scope.mostrarUsuarios();
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
            $scope.usuario = null;
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
    $scope.eliminarUsuario = function (usuario) {
        $scope.usuarioE = usuario;
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
                usuarioService.delete($scope.usuarioE).then((data) => {
                    if (data === true) {
                        Swal.fire({
                            position: 'center',
                            type: 'success',
                            title: 'Eliminado',
                            text: '¡El usuario se elimino correctamente!',
                            showConfirmButton: false,
                            timer: 1000
                        })
                        $scope.mostrarUsuarios();
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
                    $scope.usuarioE = null;
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




    const INITCONTROLLERU = function () {
        $scope.mostrarUsuarios();
    }

    angular.element(document).ready(function () {
        INITCONTROLLERU();
    });
});