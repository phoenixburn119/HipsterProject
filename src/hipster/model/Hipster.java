package hipster.model;

public class Hipster
{
	private String name;
	private String [] hipsterPhrases;
	private Book [] hipsterBooks;

	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[4];
		this.hipsterBooks = new Book[3];
		setupArray();
		setupBooks();
	}
	
	private void setupArray()
	{
		hipsterPhrases[0] = "That is so mainstream!";
		hipsterPhrases[1] = "I don't mean to sound like a hipster, but, ";
		hipsterPhrases[2] = "Insert arcastic phrase here";
		hipsterPhrases[3] = "I was into XXXX before it was cool";
			
	}
	
	private void setupBooks()
	{
		Book firstBook, secondBook, thirdBook;
		
		firstBook = new Book();
		firstBook.setAuthor("Robert McCrum");
		firstBook.setTitle("Pilgrim's Progress John Bunyan");
		firstBook.setSubject("Death");
		firstBook.setPageCount(123);
		firstBook.setPrice(20.00);
		
		secondBook = new Book();
		secondBook.setAuthor("Trevor Sucks");
		secondBook.setTitle("Your mum");
		secondBook.setSubject("Rekting");
		secondBook.setPageCount(235);
		secondBook.setPrice(25.00);
		
		thirdBook = new Book();
		thirdBook.setAuthor("Love");
		thirdBook.setTitle("Thomas A.");
		thirdBook.setSubject("Love Story");
		thirdBook.setPageCount(1254);
		thirdBook.setPrice(1000.00);
		
		hipsterBooks[0] = firstBook;
		hipsterBooks[1] = secondBook;
		hipsterBooks[2] = thirdBook;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String[] getHipsterPhrase()
	{
		return hipsterPhrases;
	}
	public void setHipsterPhrase(String[] hipsterPhrase)
	{
		this.hipsterPhrases = hipsterPhrase;
	}

	public String[] getHipsterPhrases()
	{
		return hipsterPhrases;
	}

	public void setHipsterPhrases(String[] hipsterPhrases)
	{
		this.hipsterPhrases = hipsterPhrases;
	}

	public Book[] getHipsterBooks()
	{
		return hipsterBooks;
	}

	public void setHipsterBooks(Book[] hipsterBooks)
	{
		this.hipsterBooks = hipsterBooks;
	}
	
}
