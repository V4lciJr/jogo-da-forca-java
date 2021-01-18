package jogodaforca.game;

import jogodaforca.core.Word;

public class Game {
	
	public void start()
	{
		Word word = new Word("Valci");
		word.hasChar('v');
		word.hasChar('c');
		word.hasChar('l');
		word.hasChar('i');
		word.hasChar('a');
		System.out.println(word.discovered());
		System.out.println(word);
	}
}
