package com.spring.basic.servlet.web.frontcontroller.v2.controller;

import com.spring.basic.servlet.web.frontcontroller.MyViewResolver;
import com.spring.basic.servlet.web.frontcontroller.v1.ControllerV1;
import com.spring.basic.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/front-controller/v2/*")
public class FrontControllerServlet extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServlet() {
        controllerMap.put("/front-controller/v2/member/form", new MemberFormController());
        controllerMap.put("/front-controller/v2/member/join", new MemberJoinController());
        controllerMap.put("/front-controller/v2/members", new MemberListController());
    }

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        // 요청 URL에 맞는 컨트롤러를 맵에서 꺼내자.
        ControllerV2 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //컨트롤러 실행! (인터페이스의 구현체들이기 때문에 동일한 메서드로 호출 가능)
        MyViewResolver resolver = controller.process(request, response);
        resolver.render(request, response);
    }
}












