package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.config.annotation.Operator;
import com.niule.yunjiagong.yunjiagong.model.CurOperator;
import com.niule.yunjiagong.yunjiagong.service.GetUserService;
import com.niule.yunjiagong.yunjiagong.token.JwtHelper;
import com.niule.yunjiagong.yunjiagong.token.JwtInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author haijun
 * @create 2018 - 07 - 20 - 10:20
 */
@Controller
public class UserController {

    @Autowired
    private JwtInfo jwtInfo;
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private GetUserService getUserService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<String> login() {
        String jwt = jwtHelper.createJwt(jwtInfo.getName(), "1", "manage", "niule", "niule", Long.parseLong(jwtInfo.getExpiresSecond()), jwtInfo.getBase64Secret());
        return ResponseEntity.ok(jwt);
    }

    @RequestMapping(value = "/jwt/info", method = RequestMethod.GET)
    public ResponseEntity<JwtInfo> getJwtInfo() {
        return ResponseEntity.ok(jwtInfo);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<String> getInfo(@Operator CurOperator curOperator) {
        return ResponseEntity.ok(curOperator.getUserId() + "," + curOperator.getRole());
    }

    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    public ResponseEntity<String> parseInfo(@RequestParam("token") String token,
                                            @RequestParam("base64Secret") String base64Secret) {
        return ResponseEntity.ok(JwtHelper.parseJwt(token, base64Secret).toString());
    }

}
