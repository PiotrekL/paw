package trello.dao;

import trello.model.Board;

public interface BoardDao {
	
	public void saveBoard(Board board);
	public String getBoard(Long userId);

}
