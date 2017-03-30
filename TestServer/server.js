var http = require('http'); //HTTP 서버와 클라이언트 기능을 제공하는 내장 http 모듈
var fs = require('fs'); //파일시스템 관련 기능을 제공하는 내장 fs 모듈
var path = require('path'); //파일시스템 경로 관련 기능을 제공하는 내장 path 모듈
var mime = require('mime'); //파일명 확장자 기반의 MIME 타입 추론 기증을 제공하는 외부 mime 모듈
var cache = {}; //캐시 된 파일의 내용이 저장되는 캐시 객체

function send404(response){
  response.writeHead(200, {'Content-Type' : 'text/plain'});
  response.write('Error 404 : resource not found.');
  response.end();
}

function sendFile(response, filePath, fileContents){
  response.writeHead(
    200,
    {"content-type" : mime.lookup(path.basename(filePath))}
  );
  response.end(fileContents);
}

function serveStatic(response, cache, absPath){
  if(cache[absPath]) {
    sendFile(response, absPath, cache[absPath]);
  } else {
    fs.exists(absPath, function(exists){
      if(exists){
        fs.readFile(absPath, function(err, data){
          if(err){
            send404(response);
          } else {
            cache[absPath] = data;
            sendFile(response, absPath, data);
          }
        });
      } else {
        send404(response);
      }
    });
  }
}

var server = http.createServer(function(request, response){
  var filePath = false;
  if (request.url == '/') {
    filePath = 'public/index.html';
  } else {
    filePath = 'public' + request.url;
  }
  var absPath = './' + filePath;
  serveStatic(response, cache, absPath);
});

server.listen(3000, function(){
  console.log("Server listening on port 3000.");
});

var chatServer = require('./lib/chat_server');
chatServer.listen(server);
