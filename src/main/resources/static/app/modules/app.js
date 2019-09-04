const app = angular.module("notas", ["ngRoute","ngSanitize"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/inicio", {
      templateUrl : "vistas/inicio.html"
    })
    .when("/login", {
      templateUrl : "vistas/login.html"
    })
    .when("/notas", {
      templateUrl : "vistas/notas.html"
    })
    .when("/usuarios", {
      templateUrl : "vistas/usuarios.html"
    })
    .when("/chat", {
      templateUrl : "vistas/chat.html"
    }).otherwise({
      templateUrl: "vistas/404.html"
  });
  });