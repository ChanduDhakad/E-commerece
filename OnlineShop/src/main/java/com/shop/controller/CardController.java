package com.shop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shop.exception.*;
import com.shop.model.CardDetails;
import com.shop.model.Category;
import com.shop.service.CardService;

import com.shop.exception.*;
import com.shop.model.*;


@RestController
public class CardController {

	@Autowired
	private CardService cService;
	
	@PostMapping("/AddCard")
	public ResponseEntity<CardDetails> AddCardHandler(@Valid @RequestBody CardDetails card,@RequestParam String key,@RequestParam Integer customerId)
			throws CardException, LoginException, CustomerException{
		
		CardDetails savedCard = cService.addcard(card, key, customerId);
		
		return new ResponseEntity<CardDetails>(savedCard,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteCard")
	public ResponseEntity<String> deleteCardHandler(@RequestParam Integer cardId,@RequestParam String key,@RequestParam Integer customerId) 
			throws CardException, LoginException, CustomerException{
		
		String message= cService.deleteCard(cardId, key, customerId);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getCardById")
	public ResponseEntity<CardDetails> getCardByIdHandler(@RequestParam Integer cardId,@RequestParam String key,@RequestParam Integer customerId)
			throws CardException, LoginException, CustomerException{
		
		CardDetails card= cService.getCardByCardId(cardId, key, customerId);
		
		return  new ResponseEntity<CardDetails>(card,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAllCard")
	public ResponseEntity<List<CardDetails>> getAllCardByCustomerIdHandler(@RequestParam String key,@RequestParam Integer customerId)
			throws CardException, LoginException, CustomerException{
		
		List<CardDetails> cardlist= cService.getAllCardByCustomerId(key, customerId);
		
		return new ResponseEntity<List<CardDetails>>(cardlist,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	

}
