package tech.cluee.helloworld;

import java.lang.Thread.State;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.activation.MailcapCommandMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/hellojava")
	public String helloJava() {
		return "Hello, Java!";
	}

	private static final Map<Character, Character> brackets = new HashMap<Character, Character>();
	static {
		brackets.put(')', '(');
		brackets.put('}', '{');
		brackets.put(']', '[');
	}

	public static boolean isMatch(String str) {

		if (str == null) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();

		for (Character ch : str.toCharArray()) {
			if (brackets.containsValue(ch)) {
				stack.push(ch);
			} else if (brackets.containsKey(ch)) {
				if (stack.isEmpty() || stack.pop() != brackets.get(ch)) {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
}
