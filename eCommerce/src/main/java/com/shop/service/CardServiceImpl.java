package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.*;
import com.shop.model.*;
import com.shop.repository.*;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CurrentUserRepository currentUserRepositroy;

	@Autowired
	CardRepository cardRepositroy;

	@Override
	public CardDetails addcard(CardDetails card, String key, Integer customerId)
			throws CardException, LoginException, CustomerException {

		Customer customer = checkLogin(key, customerId);
		CardDetails savedCard = cardRepositroy.save(card);
		customer.getCard().add(savedCard);
		customerRepository.save(customer);
		return savedCard;
	}

	@Override
	public String deleteCard(Integer cardId, String key, Integer customerId)
			throws CardException, LoginException, CustomerException {

		Customer customer = checkLogin(key, customerId);
		Optional<CardDetails> opt = cardRepositroy.findById(cardId);
		if (opt.isEmpty()) {
			throw new CardException("No card Found with Id:- " + cardId);
		}
		CardDetails card = opt.get();

		boolean flag = customer.getCard().removeIf((c) -> card.getCardId() == c.getCardId());
		if (flag) {
			customerRepository.save(customer);
			cardRepositroy.delete(card);
		} else {
			throw new CardException("No Card found for Customer with Id:- " + cardId);
		}
		return "Card Removed Sucessfully";
	}

	@Override
	public CardDetails getCardByCardId(Integer cardId, String key, Integer customerId)
			throws CardException, LoginException, CustomerException {

		Customer customer = checkLogin(key, customerId);
		List<CardDetails> list = customer.getCard();
		for (CardDetails card : list) {
			if (card.getCardId() == cardId) {
				return card;
			}
		}
		throw new CardException("No Card found with this Id " + cardId);
	}

	@Override
	public List<CardDetails> getAllCardByCustomerId(String key, Integer customerId)
			throws CardException, LoginException, CustomerException {

		Customer customer = checkLogin(key, customerId);
		List<CardDetails> cardlist = customer.getCard();
		if (cardlist.size() == 0 || cardlist == null) {
			throw new CardException("No card is Added By " + customer.getFirstName());
		}
		return cardlist;
	}

	public Customer checkLogin(String key, Integer customerId) throws LoginException, CustomerException {

		Optional<Customer> opt = customerRepository.findById(customerId);
		if (opt.isEmpty()) {
			throw new CustomerException("No customer Found with id:- " + customerId);
		}
		Customer customer = opt.get();
		CurrentUserSession cus = currentUserRepositroy.findByUuid(key);

		if (cus == null) {
			throw new LoginException("Invalid Current Key");

		}
		if (cus.getUserId() != customer.getCustomerId()) {
			throw new LoginException("Please Login first.....");
		}

		return customer;

	}

}
