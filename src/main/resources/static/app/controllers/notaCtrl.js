app.controller("NotaControlador", function ($scope, notaService) {
    $scope.sumaTest = 5 + 5;
    $scope.notas = {};
    notaService.get().then((data)=>{
        $scope.notas=data;
    },(reject)=>{
        console.log("Ctrl: ",reject);
    });
    
})