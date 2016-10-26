package trello.dao;

import java.util.Set;

import trello.model.Board;
import trello.model.Card;

public interface CardDao {
	public void saveCard(Card card);
	public void deleteCard(Long cardId);
	public void updateCard(Card card);
	
}
