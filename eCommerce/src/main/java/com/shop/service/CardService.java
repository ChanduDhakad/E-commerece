package com.shop.service;

import java.util.*;

import com.shop.exception.*;
import com.shop.model.*;

public interface CardService {

	public CardDetails addcard(CardDetails card, String key, Integer customerId)throws CardException, LoginException, CustomerException;

	public String deleteCard(Integer cardId, String Key, Integer customerId)throws CardException, LoginException, CustomerException;

	public CardDetails getCardByCardId(Integer cardId, String key, Integer customerId)throws CardException, LoginException, CustomerException;

	public List<CardDetails> getAllCardByCustomerId(String key, Integer customerId)throws CardException, LoginException, CustomerException;
}
