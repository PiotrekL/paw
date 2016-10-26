package trello.dao;

import java.util.Set;

import trello.model.Board;

public interface BoardDao {
	
	public void saveBoard(Board board);
	public Set<Board> getBoardsByUser(Long userId);
	public void deleteBoard(Long boardId);
	public void updateBoard(Board board);
	

}
