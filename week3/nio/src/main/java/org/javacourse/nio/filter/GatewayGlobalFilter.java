package org.javacourse.nio.filter;

import net.minidev.json.JSONObject;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.Payload;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.text.ParseException;

/**
 * @description: Gateway全局过滤器
 * @author: zyb
 **/
@Component
public class GatewayGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (token==null || "".equals(token)) {
            return chain.filter(exchange);
        }
        try {
            //从token中解析用户信息并设置到Header中去
            String realToken = token.replace("Bearer ", "");
            JWSObject jwsObject = JWSObject.parse(realToken);
            Payload payload = jwsObject.getPayload();
            JSONObject jsonObject = payload.toJSONObject();
            String userName = (String)jsonObject.get("user_name");
            String userId = (String)jsonObject.get("user_id");
            ServerHttpRequest request = exchange.getRequest().mutate().header("username", userName).header("userId", userId).build();
            exchange = exchange.mutate().request(request).build();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return 0;
    }

}
