package trello.dao;

import trello.model.Board;

public interface BoardDao {
	
	public void saveBoard(Board board);
	public Board getBoard(Long userId);

}
