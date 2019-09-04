app.controller("ChatControlador", function ($scope, sessionFactory) {
    $scope.userChat = sessionFactory.get("usuario");
    $scope.verChat = sessionFactory.get("chat");
    $scope.mensajes = {};
    const mensajesUser = [];
    let stompClient = null;

    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 4000
    })

    $scope.iniciarChat = function () {
        sessionFactory.put("chat", $scope.userChat);
        if (!$scope.verChat) {
            $scope.verChat = sessionFactory.get("chat");

            let socket = new SockJS('/websocket');
            stompClient = Stomp.over(socket);
            stompClient.debug = null;

            stompClient.connect({}, function (frame) {
                // setConnected(true);
                // console.log('CONECTADO: ' + frame);
                console.log('CONECTADO: ');
                stompClient.subscribe('/tema/saludos', function (mensajes) {
                    if ($scope.miMensaje) {
                        $scope.miMensaje = false;
                    } else {
                        $scope.VerMensajeRecibido(JSON.parse(mensajes.body).contenido);
                    }
                });
            });
        }
    }

    $scope.submitChat = function (valid) {
        if (valid) {
            $scope.enviarMensaje();
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

    $scope.VerMensajeRecibido = function (message) {
        // mensajeNew =+ mensajeNew.append('<div class="incoming_msg"> <div class="received_msg">Servidor<div class="received_withd_msg"> <p>' + message + '</p> <!-- <span class="time_date"> 11:01 AM | June 9</span> --> </div> </div> </div>');
        // console.log("mensajeNew: ",mensajeNew)
        mensajesUser.push('{ mensaje : <div class="incoming_msg"> <div class="received_msg">Servidor<div class="received_withd_msg"> <p>' + message + '</p></div> </div> </div>}');
        // $scope.mensajes = JSON.stringify(mensajesUser);
        $scope.mensajes = mensajesUser;
        console.log("RECIBIDO: ",$scope.mensajes )
    }

    $scope.VerMensajeEnviado = function (message) {
        $scope.miMensaje = true;
        let nombreUsuario = $scope.userChat.nombre;
        // $("#historialMensajes").append('<div class="outgoing_msg"> <div class="sent_msg">' + nombreUsuario + '<p>' + message + '</p> <!-- <span class="time_date"> 11:01 AM | June 9</span> --> </div> </div>');
        mensajesUser.push('{ mensaje : <div class="outgoing_msg"><div class="sent_msg">' + nombreUsuario + '<p>' + message + '</p></div></div> }');
        // $scope.mensajes= JSON.stringify(mensajesUser);
        $scope.mensajes= mensajesUser;
        console.log("ENVIADO: ",$scope.mensajes )
    }

    $scope.enviarMensaje = function () {
        // console.log("input: ", $scope.userChat.mensaje);
        stompClient.send("/app/hola", {}, JSON.stringify({
            'mensaje': $scope.userChat.mensaje
        }));
        $scope.VerMensajeEnviado($scope.userChat.mensaje);
        $scope.userChat.mensaje = null;
        // console.log("$scope.userChat: ", $scope.userChat);
    }

    $scope.desconectarChat = function () {
        if (stompClient !== null) {
            stompClient.disconnect();
        }
        console.log("=== DESCONECTADO ===");
        $scope.verChat = null;
        sessionFactory.delete("chat");
        Toast.fire({
            type: 'success',
            title: '¡Se desconecto correctamente!'
        })
    }
});