package com.framework.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    
    @GetMapping("/login-template")
    public String loginTemplate() {
        return "login-template";
    }

    @GetMapping("/login-xhr")
    public String loginxhr() {
        return "login-xhr";
    }

    @PostMapping("/request-login")
    @ResponseBody
    public Map<String, Object> requestLogin(@RequestBody Map<String, Object> params) {

        Map<String, Object> result = new HashMap<>();

        String username = (String) params.get("username");
        String password = (String) params.get("password");  // ✅ 수정된 부분

        if ("admin".equals(username) && "1234".equals(password)) {
            result.put("REPL_MSG", "로그인 성공");
            log.info("✅ 로그인 성공: {}", username);
        } else {
            result.put("REPL_MSG", "로그인 실패");
            log.warn("❌ 로그인 실패: {}", username);
        }

        return result;
    }
}
