package trello.dao;

import java.util.Set;

import trello.model.Card;
import trello.model.Label;

public interface LabelDao {

	Set<Label> getLabel(Long boardId);
	public void saveLabel(Label label);
	public void deleteLabel(Long labelId);
	
	
}
