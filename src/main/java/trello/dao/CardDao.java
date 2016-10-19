package trello.dao;

import trello.model.Board;
import trello.model.Card;

public interface CardDao {
	public void saveCard(Card card, Long listId);
	
}
