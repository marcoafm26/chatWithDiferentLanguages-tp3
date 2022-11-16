const connection = require('net');
const LOCAL_HOST = '127.0.0.1'; // IP do local host
const PORT = 6345; // porta do socket

connection
  .createServer((socket) => {
    console.log(
      'Cliente conectado com sucesso: ' +
        socket.remoteAddress +
        ':' +
        socket.remotePort +
        '\n'
    );

    // executa ao servidor receber um pacote
    socket.on('data', (data) => {
      console.log('[Cliente]:' + data);

      const readline = require('readline').createInterface({
        input: process.stdin,
        output: process.stdout,
      });

      readline.question('[Enviar]: ', (message) => {
        readline.close();
        socket.setNoDelay(true);
        socket.write(message.toString() + '\r\n');
      });
    });

    // executa ao servidor fechar
    socket.on('close', (data) => {
      console.log(
        'Conexão fechada: ' + socket.remoteAddress + ' ' + socket.remotePort
      );
    });

    // executa ao servidor terminar
    socket.on('end', () => {
      console.log('Servidor finalizado');
    });

    // executa quando o server da erro
    socket.on('error', () => {
      console.log('Servidor finalizado. Cliente desconectado!');
    });
  })
  .listen(PORT, LOCAL_HOST);

console.log('Servidor iniciado com sucesso!');
