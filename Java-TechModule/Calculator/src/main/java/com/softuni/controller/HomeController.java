package com.softuni.controller;

import com.softuni.entity.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

	private List<Calculator> calcHistory;

	public HomeController() {
		this.calcHistory = new ArrayList<>();
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("operator", "operator");
		model.addAttribute("view","views/calculatorForm");
		model.addAttribute("calcHistory", calcHistory);
		return "base-layout";
	}

	@PostMapping("/")
	public String calculate(@RequestParam String leftOperand,
							@RequestParam String operator,
							@RequestParam String rightOperand,
							Model model){
		double num1;
		double num2;

		try{
			num1 = Double.parseDouble(leftOperand);
		}catch (NumberFormatException e){
			num1 = 0;
		}

		try{
			num2 = Double.parseDouble(rightOperand);
		}catch (NumberFormatException e){
			num2 = 0;
		}

		Calculator calculator = new Calculator(num1,num2,operator);
		double result = calculator.calculateResult();

		this.calcHistory.add(calculator);

		model.addAttribute("leftOperand",calculator.getLeftOperand());
		model.addAttribute("operator", calculator.getOperator());
		model.addAttribute("rightOperand", calculator.getRightOperand());

		model.addAttribute("result",result);

		model.addAttribute("view","views/calculatorForm");
		return "redirect:/";
	}
}
