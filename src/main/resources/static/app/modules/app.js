const app = angular.module("notas", ["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "/vistas/inicio.html"
    })
    .when("/nueva", {
        templateUrl : "/vistas/nuevaNota.html"
    })
    .when("/editar", {
        templateUrl : "/vistas/editarNota.html"
    });
});

