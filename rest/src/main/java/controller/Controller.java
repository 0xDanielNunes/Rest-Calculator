package controller;

import model.Result;
import service.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "service")
@RestController
public class Controller {

	private final Operations operationsService;

	@Autowired
	public Controller(Operations operationsService) {

		this.operationsService = operationsService;

	}

	@GetMapping(value = "/sum")
	public ResponseEntity<Result> sum(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b){
		return ResponseEntity
				.ok()
				.body(operationsService.sum(a,b));
	}

	@GetMapping(value = "/sub")
	public ResponseEntity<Result> sub(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b){
		return ResponseEntity
				.ok()
				.body(operationsService.sub(a,b));
	}

	@GetMapping(value = "/mul")
	public ResponseEntity<Result> mul(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b){
		return ResponseEntity
				.ok()
				.body(operationsService.mul(a,b));
	}

	@GetMapping(value = "/div")
	public ResponseEntity<Result> div(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b){
		return ResponseEntity
				.ok()
				.body(operationsService.div(a,b));
	}

	public static void main(String[] args) {
		SpringApplication.run(Controller.class, args);
	}
}
