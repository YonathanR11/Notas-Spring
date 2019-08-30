const app = angular.module("notas", ["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
    // .when("/", {
    //   templateUrl : "vistas/inicio.html"
    // })
    .when("/", {
      templateUrl : "vistas/login.html"
    })
    .when("/notas", {
      templateUrl : "vistas/notas.html"
    })
    .when("/usuarios", {
      templateUrl : "vistas/usuarios.html"
    }).otherwise({
      templateUrl: "vistas/404.html"
  });
  });