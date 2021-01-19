package jogodaforca.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jogodaforca.game.GameException;
import jogodaforca.utils.RandomUtils;


public class Dictionary {
	
	private static final String FILE_NAME = "dicionario.txt";
	private List<String> words = new ArrayList<>();
	
	private void load()
	{
		try(Scanner sc = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME)))
		{
			while(sc.hasNextLine())
			{
				String word = sc.nextLine().trim();
				words.add(word);
			}
			
			if(words.size() == 0)
			{
				throw new GameException("A lista de palavras não pode ser vazia.");
			}
		}
	}
	
	public Word nextWord()
	{
		return new Word(words.get(RandomUtils.newRandomNumber(0, words.size())));
	}
}
