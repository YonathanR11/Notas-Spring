app.controller("NotaControlador", function ($scope, notaService) {

    $scope.notas = {};
    $scope.notaNueva = {};

    notaService.get().then((data) => {
        // console.log("Ctrl OK: ",data);
        $scope.notas = data;
    }, (reject) => {
        // console.log("Ctrl ERROR: ",reject);
        Swal.fire({
            position: 'center',
            type: 'error',
            title: 'Error',
            text: 'Ocurrio un error',
            showConfirmButton: false,
            timer: 3000
        })
    });

});

app.controller('NuevaNotaCtrl', function ($scope, notaService) {

    $scope.guardarNota = function () {
        $scope.notaNueva.titulo = $scope.tituloN;
        $scope.notaNueva.contenido = $scope.notaN;
        $scope.notaNueva.fecha = Date.now();

        notaService.post($scope.notaNueva).then((data) => {

            if (data === true) {

                $scope.tituloN = "";
                $scope.notaN = "";
                Swal.fire({
                    position: 'center',
                    type: 'success',
                    title: 'Guardada con exito',
                    showConfirmButton: false,
                    timer: 1500
                })
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
});

app.controller('EliminarNotaCtrl', function ($scope, notaService) {

    $scope.eliminarNota = function () {
        notaService.delete($scope.notaNueva).then((data) => {

            $scope.tituloN = "";
            $scope.notaN = "";
            Swal.fire({
                position: 'center',
                type: 'success',
                title: 'Guardada con exito',
                showConfirmButton: false,
                timer: 1500
            })

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
});