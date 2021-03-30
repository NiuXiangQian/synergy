let socket;
const gid = location.href.substring(location.href.lastIndexOf('/') + 1)
if (!window.WebSocket) {
    window.WebSocket = window.MozWebSocket;
}
if (window.WebSocket) {

    socket = new WebSocket("ws://127.0.0.1:12345/ws?gid=" + gid + "&uid=" + new Date().getTime());
    socket.onmessage = function (event) {
        const ta = document.getElementById('md-area');
        // ta.value += event.data + "\r\n";
        ta.value = event.data
        //触发解析md
        mdSwitch()
    };
    socket.onopen = function (event) {
        var ta = document.getElementById('md-area');
        ta.value = "Netty-WebSocket服务器。。。。。。连接  \r\n";
    };
    socket.onclose = function (event) {
        var ta = document.getElementById('md-area');
        ta.value = "Netty-WebSocket服务器。。。。。。关闭 \r\n";
    };
} else {
    alert("您的浏览器不支持WebSocket协议！");
}

function send(message) {
    if (!window.WebSocket) {
        return;
    }
    if (socket.readyState == WebSocket.OPEN) {
        socket.send(message);
    } else {
        alert("WebSocket 连接没有建立成功！");
    }

}