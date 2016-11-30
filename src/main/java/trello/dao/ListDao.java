package trello.dao;

import java.util.Set;

import trello.model.Board;
import trello.model.List;

public interface ListDao {
	public Set<List> getLists(Long boardId);
	public long saveList(List list);
	public void deleteList(Long listId);
	public void updateList(List list);
	
}
