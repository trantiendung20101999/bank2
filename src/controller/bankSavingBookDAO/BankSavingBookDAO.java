package controller.bankSavingBookDAO;

import model.BankSavingBook;

public interface BankSavingBookDAO {

	// tim kiem so tiet kiem theo ma so
	public BankSavingBook searchBook(int id);
	// mo so tiet kiem
	public boolean	insertBook(BankSavingBook bsb);
	// rut so
	public boolean rutSo(BankSavingBook bsb);
}
