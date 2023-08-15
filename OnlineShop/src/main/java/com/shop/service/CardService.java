package com.shop.service;

import java.util.List;

import com.shop.exception.*;
import com.shop.model.CardDetails;



public interface CardService {

//	Cart addNewCart(Cart cart,String userKey) throws CustomerException,CartException,LoginException ;
//	Cart addNewProductIntoCart(Integer cartID,Integer productID,String userKey) throws CartException,ProductException,LoginException,CustomerException ;
//	
	
	public CardDetails addcard(CardDetails card,String key,Integer customerId) 
			throws CardException,LoginException,CustomerException;
	
	public String deleteCard(Integer cardId,String Key,Integer customerId)
			throws CardException,LoginException,CustomerException;
	
	public CardDetails getCardByCardId(Integer cardId,String key, Integer customerId)
			throws CardException,LoginException,CustomerException;
	
	public List<CardDetails> getAllCardByCustomerId(String key, Integer customerId)
			throws CardException,LoginException,CustomerException;
}
