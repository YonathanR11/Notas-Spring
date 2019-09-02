app.controller("loginControlador", function ($scope, usuarioService, sessionFactory) {

    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 4000
    })

    $scope.verificarSesion = function ($window) {
        $scope.user = sessionFactory.get("usuario");
        if (!$scope.user) {
            window.location.href = "#!/";
        }else if(window.location.pathname === "/"){
            window.location.href = "#!/notas";
            // console.log(window.location)
        }
    }

    // Verifica que el formulario de login sea valido
    $scope.submitLogin = function (valid) {
        if (valid) {
            $scope.LoginFunction();
        } else {
            $(function () {
                $("form[name='formLogin']").validate({
                    submitHandler: function (form) {
                        form.submit();
                    }
                });
            });
        }
    }

    // FUNCTION PARA EL LOGIN
    $scope.LoginFunction = function ($window) {
        usuarioService.postLogin($scope.login).then((data) => {
            if (data) {
                Toast.fire({
                    type: 'success',
                    title: 'Bienvenido ' + data.nombre
                })
                $scope.login = data;
                window.location.href = "#!/notas";
                sessionFactory.put($scope.login);
            } else {
                Swal.fire({
                    position: 'center',
                    type: 'error',
                    title: 'Error',
                    text: 'Contraseña o Usuario incorrectos',
                    showConfirmButton: false,
                    timer: 3000
                })
            }
        }, (reject) => {
            console.log("reject", reject);
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

    $scope.cerrarSesion = function ($window) {
        Swal.fire({
            title: '¿Decea cerrar sesion?',
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Cerrar'
        }).then((result) => {
            if (result.value) {
                $scope.user = null;
                sessionFactory.delete("usuario");
                window.location.href = "#!/";
                Toast.fire({
                    type: 'success',
                    title: 'Sesion cerrada'
                })
            }
        })
    }

    const INITCONTROLLERS = function () {
        $scope.verificarSesion();
    }

    angular.element(document).ready(function () {
        INITCONTROLLERS();
    });
});