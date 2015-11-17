package hipster.model;

public class Hipster
{
	private String name;
	private String [] hipsterPhrases;
	
	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[4];
		setupArray();
	}
	
	private void setupArray()
	{
		hipsterPhrases[0] = "That is so mainstream!";
		hipsterPhrases[1] = "I don't mean to sound like a hipster, but, ";
		hipsterPhrases[2] = "Insert arcastic phrase here";
		hipsterPhrases[3] = "I was into XXXX before it was cool";
			
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

	
}
