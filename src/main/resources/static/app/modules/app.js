const app = angular.module("notas", ["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
      templateUrl : "vistas/inicio.html"
    })
    .when("/notas", {
      templateUrl : "vistas/notas.html"
    })
    .when("/usuarios", {
      templateUrl : "vistas/usuarios.html"
    });
  });