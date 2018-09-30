package wy.rest.modular.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wy.rest.common.exception.BizExceptionEnum;
import wy.rest.common.exception.BussinessException;
import wy.rest.modular.auth.controller.dto.AuthRequest;
import wy.rest.modular.auth.controller.dto.AuthResponse;
import wy.rest.modular.auth.util.JwtTokenUtil;
import wy.rest.modular.auth.validator.IReqValidator;

import javax.annotation.Resource;

/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Resource(name = "dbValidator")
    private IReqValidator reqValidator;

    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseEntity<?> createAuthenticationToken(AuthRequest authRequest) {
//    public ResponseEntity<?> createAuthenticationToken(HttpServletRequest authRequest) {
        System.err.println("auth："+authRequest);
        boolean validate = reqValidator.validate(authRequest);

        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getAccount(), randomKey);
            return ResponseEntity.ok(new AuthResponse(token, randomKey));
        }else {
            throw new BussinessException(BizExceptionEnum.AUTH_REQUEST_ERROR);
        }

    }
}
