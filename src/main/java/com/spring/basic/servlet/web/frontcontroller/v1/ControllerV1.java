package com.spring.basic.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 앞으로 생성할 컨트롤러가 동일한 메서드 이름으로 내용을 구현하게끔 인터페이스 생성.
public interface ControllerV1 {

    void process(HttpServletRequest request,
                 HttpServletResponse response) throws ServletException, IOException;

}
