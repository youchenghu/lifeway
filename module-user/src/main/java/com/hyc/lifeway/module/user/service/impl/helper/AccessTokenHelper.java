package com.hyc.lifeway.module.user.service.impl.helper;

import com.hyc.cs.core.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ：胡友成
 * @Date ：2020/4/15 8:48 下午
 * @Description：
 */
@Component
public class AccessTokenHelper {
    private static final String LIFEWAY_SECRET = "lifeway_jwt";
    private static final String PAYLOAD_KEY = "store_account";

    public String generate(Integer accountId) {
        Map<String, Object> payload = new HashMap<>();
        payload.put(PAYLOAD_KEY, accountId);
        return JwtUtil.sign(LIFEWAY_SECRET, payload, null);
    }

    public Integer verify(String token)  {
        try {
            Map<String, Object> payload = JwtUtil.verify(LIFEWAY_SECRET, token);
            return (Integer) payload.get(PAYLOAD_KEY);
        }catch (JwtException e){
            return null;
        }
    }

    public Object verify(String token, String payloadKey)  {
        try {
            Map<String, Object> payload = JwtUtil.verify(LIFEWAY_SECRET, token);
            return payload.get(payloadKey);
        }catch (JwtException e){
            return null;
        }
    }
}
