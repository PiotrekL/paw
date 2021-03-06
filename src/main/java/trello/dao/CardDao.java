package trello.dao;

import java.util.Set;

import trello.model.Board;
import trello.model.Card;

public interface CardDao {
	public Set<Card> getCards(Long listId);
	public long saveCard(Card card);
	public void deleteCard(Long cardId);
	public void updateCard(Card card);
	
}
