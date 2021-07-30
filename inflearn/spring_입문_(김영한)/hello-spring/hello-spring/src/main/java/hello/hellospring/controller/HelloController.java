package hello.hellospring.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "hello!!");
		return "hello";
	}
	//컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버('viewResolver')가 화면을 찾아서 처리한다.
	//스프링부트 템플릿엔진 기본 viewName 매핑
	//'resources:templates/'+{viewName}+'.html'
	
	//'spring-boot-devtools'라이브러리를 추가하면, 'html' 파일을 컴파일만 해주면 서버 재시작 없이 View 파일 변경이 가능하다
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}
	
	@GetMapping("hello-string")
	@ResponseBody
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name; //"hello spring"
	}
	
	@GetMapping("hello-api")
	@ResponseBody //뷰리졸버로 가지 않고 HttpMessageConverter가 동작(기본 객체처리 'Mappingjackson2HttpmessageConverter', 기본 문자처리 'StringHttpMessageConver, ... 등등)
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		
		return hello;
		//json 방식으로 출력됨
	}
	// 클라이언트의 HTTP Accept 헤더와 서버의 컨트롤러 반환 타입 정보 둘을 조합해서 'HttpMessageConverter'가 선택된다.
	
	static class Hello{
		private String name;
		
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
	}
}
