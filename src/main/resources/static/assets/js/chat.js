(function () {
    var Message;
    Message = function (arg) {
        this.text = arg.text, this.message_side = arg.message_side;
        this.draw = function (_this) {
            return function () {
                var $message;
                $message = $($('.message_template').clone().html());
                $message.addClass(_this.message_side).find('.text').html(_this.text);
                $('.messages').append($message);
                return setTimeout(function () {
                    return $message.addClass('appeared');
                }, 0);
            };
        }(this);
        return this;
    };
    $(function () {
        var getMessageText, message_side, sendMessage;
        message_side = 'right';
        getMessageText = function () {
            var $message_input;
            $message_input = $('.message_input');
            return $message_input.val();
        };
        sendMessage = function (text) {
            var $messages, message;
            if (text.trim() === '') {
                return;
            }
            $('.message_input').val('');
            $messages = $('.messages');
            message_side = message_side === 'left' ? 'right' : 'left';
            message = new Message({
                text: text,
                message_side: message_side
            });
            message.draw();
            return $messages.animate({ scrollTop: $messages.prop('scrollHeight') }, 300);
        };
        $('.send_message').click(function (e) {
            return sendMessage(getMessageText());
        });
        $('.message_input').keyup(function (e) {
            if (e.which === 13) {
                return sendMessage(getMessageText());
            }
        });
        setTimeout(function () {
            return sendMessage('Mensaje #1');
        }, 100);
        setTimeout(function () {
            return sendMessage('Mensaje #2');
        }, 200);
        setTimeout(function () {
            return sendMessage('Mensaje #3');
        }, 300);
        setTimeout(function () {
            return sendMessage('Mensaje #4');
        }, 400);
        setTimeout(function () {
            return sendMessage('Mensaje #5');
        }, 500);
        setTimeout(function () {
            return sendMessage('Mensaje #6');
        }, 600);
        setTimeout(function () {
            return sendMessage('Mensaje #7');
        }, 700);
        setTimeout(function () {
            return sendMessage('Mensaje #8');
        }, 800);
        setTimeout(function () {
            return sendMessage('Mensaje #9');
        }, 900);
        setTimeout(function () {
            return sendMessage('Mensaje #10');
        }, 1000);
        setTimeout(function () {
            return sendMessage('Mensaje #11');
        }, 1100);
        setTimeout(function () {
            return sendMessage('Mensaje #12');
        }, 1200);
        setTimeout(function () {
            return sendMessage('M\ne\nn\ns\na\nj\ne\n\n #\n1\n3');
        }, 1300);
    setTimeout(function () {
            return sendMessage('Mensaje #14 \nLorem ipsum dolor sit amet consectetur, adipisicing elit. \nMolestias ullam facilis at esse veniam ex vero delectus minima dicta asperiores, porro quo! \nCommodi porro culpa earum saepe impedit consequuntur incidunt!');
        }, 1400);

        // sendMessage('Hola Philip! :)');
        // sendMessage('Hello Philip! :)');
    });
}.call(this));