package jogodaforca.game;

import jogodaforca.core.Dictionary;
import jogodaforca.core.Word;

public class Game {
	
	public void start()
	{
		Dictionary d = Dictionary.getInstance();
		
		Word w = d.nextWord();
		System.out.println(w.getOriginalWord());
		
	}
}
