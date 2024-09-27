package com.spring.basic.servlet.web.frontcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

// 화면 처리와, 화면에 전달할 데이터 처리를 일괄 전담.
@Getter @Setter
public class ModelView {

    private MyViewResolver resolver; // 화면 처리
    private Model model; // 화면에 필요한 데이터 처리

    // model을 사용하지 않는 컨트롤러도 있으니까 viewName만 받자.
    public ModelView(String viewName) {
        this.resolver = new MyViewResolver(viewName);
        this.model = new Model();
    }

    // 화면 렌더링 기능
    public void render(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        this.resolver.render(request, response);
    }

    //모델에 JSP가 필요한 데이터를 담는 메서드
    public void addAttribute(String key, Object value) {
        this.model.addAttribute(key, value);
    }

}














