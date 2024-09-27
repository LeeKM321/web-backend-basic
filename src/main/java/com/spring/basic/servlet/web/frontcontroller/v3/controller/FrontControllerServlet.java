package com.spring.basic.servlet.web.frontcontroller.v3.controller;

import com.spring.basic.servlet.web.frontcontroller.ModelView;
import com.spring.basic.servlet.web.frontcontroller.MyViewResolver;
import com.spring.basic.servlet.web.frontcontroller.v3.ControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/front-controller/v3/*")
public class FrontControllerServlet extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServlet() {
        controllerMap.put("/front-controller/v3/member/form", new MemberFormController());
        controllerMap.put("/front-controller/v3/member/join", new MemberJoinController());
        controllerMap.put("/front-controller/v3/members", new MemberListController());
        controllerMap.put("/front-controller/v3/member/delete", new MemberDeleteController());
    }

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        // 요청 URL에 맞는 컨트롤러를 맵에서 꺼내자.
        ControllerV3 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 요청과 함께 전달된 데이터(요청 파라미터)를 전부 읽어서 맵에 담아 리턴하는 로직.
        // ?name=kim&age=30....
        Map<String, String> paramMap = createParamMap(request);

        ModelView mv = controller.process(paramMap);

        // jsp 쪽에서 좀 더 쉽게 데이터를 꺼낼 수 있게끔
        // Model이 가진 맵을 순회해서 request 객체에 데이터를 세팅.
        Map<String, Object> modelMap = mv.getModel().getModelMap();
        for (String key : modelMap.keySet()) {
            request.setAttribute(key, modelMap.get(key));
        }

        // view 렌더링
        mv.render(request, response);

    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        // 요청과 함께 전달된 모든 파라미터를 리턴.
        Enumeration<String> parameterNames = request.getParameterNames();

        // 각각의 컨트롤러에게 전달할 파라미터를 담을 맵
        Map<String, String> paramMap = new HashMap<>();

        // 파라미터 요소가 더 이상 조회가 되지 않을 때까지 반복문을 순회
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement(); // key를 얻자.
            String value = request.getParameter(key); // key를 통해 value를 얻자
            paramMap.put(key, value); // 맵에 담자.
        }

        return paramMap;
    }
}












