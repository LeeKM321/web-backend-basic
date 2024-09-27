package com.spring.basic.servlet.web.frontcontroller.v3;

import com.spring.basic.servlet.web.frontcontroller.ModelView;
import com.spring.basic.servlet.web.frontcontroller.MyViewResolver;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

/*
    이 인터페이스를 구현하는 다양한 하위 컨트롤러들이
    항상 request, response를 사용하는 것이 아니기 때문에
    요청, 응답 정보 처리를 FrontController에게 위임.
 */
public interface ControllerV3 {

    /**
     * 요청이 들어오면 적절한 처리를 수행
     * @param paramMap: 요청 정보(쿼리 파라미터)를 모두 읽어서 맵에 담음. (FrontController가 해줌)
     * @return - 응답 시 보여줄 화면 처리 객체(ViewResolver)와
     *           화면 처리를 위해 사용할 데이터(Model)을
     *           일괄적으로 처리하는 객체 ModelView
     */
    ModelView process(Map<String, String> paramMap);

}









