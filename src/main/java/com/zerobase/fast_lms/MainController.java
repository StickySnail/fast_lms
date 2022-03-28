package com.zerobase.fast_lms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zerobase.fast_lms.components.MailComponents;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController { // Controller가 들어가는 클래스 이름은 Controller로 끝나게 하는게 업계 룰임.

	private final MailComponents mailComponents;


	@RequestMapping("/")
	public String index() {

		/*
		  String email = "jerryseo0306@gmail.com"; String subject =
		  "Hey this is Jeremy from Korea"; String text =
		  "<p>hi.</p><p>glad to meet you</p>";
		  
		  mailComponents.sendMail(email, subject, text);
		 */
		return "index";

	}

	// 스프링 -> MVC (View -> 템플릿엔진 / 화면에 내용을 출력(HTML)
	// .NET -> MVC (View -> 출력)
	// python django -> MTV(화면 출력)
	// View 는 (화면에 보여진 부분) -> 프론트엔드과정
	// View -> HTML ==> 웹페이지
	// View -> json ==> API

	// request -> WEB -> SERVER
	// response -> SERVER -> WEB

	@RequestMapping("/hello")
	public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter printWriter = response.getWriter();

		String msg = "<html>" + "<head>" + "<meta charset=\"UTF-8\">" + // UTF-8은 습관화 해서 사용할 것
				"</head>" + "<body>" + "<p>hello</p> <p>fastlms website!!</p>" + "<p> 안녕하세요!!! ===> </p>" + "</body>"
				+ "</html>";

		printWriter.write(msg);

	}

}
