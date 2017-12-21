package com.oauth.code.controller;

import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.apache.oltu.oauth2.rs.response.OAuthRSResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OAuth2 资源服务
 */
@RestController
@RequestMapping("/oauth2")
public class ResourceController {
    private static Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @RequestMapping("/get_resource")
    public String get_resource(HttpServletRequest request, HttpServletResponse response)
            throws IOException, OAuthSystemException {
        String userName = "Irving";
        try {
            //构建oauth2资源请求
            OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.QUERY);
            //获取验证accesstoken
            String accessToken = oauthRequest.getAccessToken();
            //验证accesstoken是否存在或过期
//            if (accessToken.isEmpty()||cache.get(accessToken)== null) {
//                OAuthResponse oauthResponse = OAuthRSResponse
//                                              .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
//                                              .setRealm("RESOURCE_SERVER_NAME")
//                                              .setError(OAuthError.ResourceResponse.INVALID_TOKEN)
//                                              .setErrorDescription(OAuthError.ResourceResponse.EXPIRED_TOKEN)
//                                              .buildHeaderMessage();
//                response.addDateHeader(OAuth.HeaderType.WWW_AUTHENTICATE, Long.parseLong(oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE)));
//            }
            //获得用户名
            userName = "Irving"; //oAuthService.getNameByAccessToken(accessToken);
        } catch (OAuthProblemException ex) {
            logger.error("ResourceController OAuthProblemException : "+ex.getMessage());
            OAuthResponse oauthResponse = OAuthRSResponse
                                          .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
                                          .setRealm("get_resource exception")
                                          .buildHeaderMessage();
            response.addDateHeader(OAuth.HeaderType.WWW_AUTHENTICATE, Long.parseLong(oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE)));
        }
        return userName;
    }
}