app.controller("loginControlador", function ($scope, usuarioService) {

    // $scope.login = {};

    // Verifica que el formulario de login sea valido
    $scope.submitLogin = function (valid) {
        console.log("Formulario: ",valid);
        if (valid) {
            $scope.LoginFunction();
        } else {
            // $(function () {
            //     $("form[name='formLogin']").validate({
            //         submitHandler: function (form) {
            //             form.submit();
            //         }
            //     });
            // });
        }
    }

    // FUNCTION PARA EL LOGIN
    $scope.LoginFunction = function () {
        console.log("Login: ",$scope.login);
        usuarioService.postLogin($scope.login).then((data) => {
            console.log("data: ",data);
            if (data) {
                Swal.fire({
                    position: 'center',
                    type: 'success',
                    title: 'Inicio sesion',
                    showConfirmButton: false,
                    timer: 1500
                })
                // $scope.mostrarUsuarios();
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
            // $scope.usuario = null;
        }, (reject) => {
            console.log("reject",reject);
            Swal.fire({
                position: 'center',
                type: 'error',
                title: 'Error',
                text: reject.data.message.toString(),
                showConfirmButton: true,
                timer: 5000
            })
        });

        // Swal.fire({
        //     position: 'center',
        //     type: 'success',
        //     title: 'Guardado con exito',
        //     showConfirmButton: false,
        //     timer: 1500
        // })
    }

});