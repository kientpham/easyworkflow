package com.kienp.sampleworkflow;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

	@Autowired
	private TestFactory testFactory;
	
	@RequestMapping("/")
	public String index() {
		
		List<String> inputValues=Arrays.asList("test 1","Test 3");		
		List<TransactionModel> transactionList=testFactory.processRequest(inputValues);
		StringBuilder sb=new StringBuilder();
		for (TransactionModel transaction:transactionList) {
			sb.append(" " + transaction.getTransactionId());
		}		
		return "Process Successfully transactionId:" + sb.toString();
	}
}
