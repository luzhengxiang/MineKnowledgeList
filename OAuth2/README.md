
AuthzController:获取授权码
TokenController:获得令牌
ResourceController:资源服务
ClientController:客户端

##测试 OAuth2
###获得授权码
http://localhost:8080/oauth2/authorize?client_id=fbed1d1b4b1449daa4bc49397cbe2350&response_type=code&redirect_uri=http://localhost:8080/oauth2/login
###获得令牌
        注意：需要设置HTTP头 Content-Type:application/x-www-form-urlencoded 与 请求方式 POST
http://localhost:8080/oauth2/access_token?client_id=fbed1d1b4b1449daa4bc49397cbe2350&client_secret=fbed1d1b4b1449daa4bc49397cbe2350&grant_type=authorization_code&redirect_uri=http://localhost:8080&code={code}

###使用客户端代码测试
确保程序8080端口运行后访问
http://localhost:8080/client