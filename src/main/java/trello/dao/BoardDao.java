package trello.dao;

import java.util.Set;

import trello.model.Board;

public interface BoardDao {
	
	public long saveBoard(Board board);
	public Set<Board> getBoardsByUser(Long userId);
	public Board getBoard(Long id);
	public void deleteBoard(Long boardId);
	public void updateBoard(Board board);
	

}
