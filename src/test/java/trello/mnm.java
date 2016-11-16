package trello;

import trello.dao.implementation.HibernateBoardDao;
import trello.model.Board;

public class mnm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
HibernateBoardDao bf= new HibernateBoardDao();

System.out.println(bf.getBoardsByUser(1L));
	}

}
