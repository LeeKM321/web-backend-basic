package com.spring.basic.servlet.web.frontcontroller.v4;

import com.spring.basic.servlet.web.frontcontroller.Model;
import com.spring.basic.servlet.web.frontcontroller.ModelView;

import java.util.Map;

/*
    이 인터페이스를 구현하는 다양한 하위 컨트롤러들이
    항상 request, response를 사용하는 것이 아니기 때문에
    요청, 응답 정보 처리를 FrontController에게 위임.
 */
public interface ControllerV4 {

    /**
     * 요청이 들어오면 적절한 처리를 수행
     * @param1 paramMap: 요청 정보(쿼리 파라미터)를 모두 읽어서 맵에 담음. (FrontController가 해줌)
     * @param2 model: 응답 시 보여줄 jsp에 데이터를 전달하는 수송객체.
     * @return - 응답 시 포워딩하거나 리다이렉트할 경로문자열
     */
    String process(Map<String, String> paramMap, Model model);

}









