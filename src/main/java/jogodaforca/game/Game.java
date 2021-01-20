package jogodaforca.game;

import java.util.HashSet;
import java.util.Set;

import jogodaforca.core.Dictionary;
import jogodaforca.core.InvalidCharacterException;
import jogodaforca.core.Word;
import jogodaforca.ui.UI;

public class Game {
	
	private static final int MAX_ERRORS = 5;
	public void start()
	{
		UI.print("Bem vindo ao jogo da forca!!");
		
		Dictionary d = Dictionary.getInstance();
		Word word = d.nextWord();
		int errorCount = 0;
		
		UI.print("A palavra tem " + word.size() + " letras.");
		
		Set<Character> usedChars = new HashSet<>();
		
		while(true)
		{
			UI.print(word);
			UI.printNewLine();
			char c;
			
			try 
			{
				 c = UI.readChar("Digite uma letra: ");
				 
				 if(usedChars.contains(c))
				 {
					 throw new InvalidCharacterException("Esta letra j� foi digitada.");
				 }
				 
				 usedChars.add(c);
				 
				 if(word.hasChar(c))
				 {
					 UI.print("Voc� acertou uma letra!");
				 }
				 else
				 {
					 errorCount++;
					 
					 if(errorCount < MAX_ERRORS)
					 {
						 UI.print("Voc� errou! Voc� ainda possui " +(MAX_ERRORS - errorCount) + " tentativa(s).");
					 }
				 }
				 
				 UI.printNewLine();
				 
				 if(word.discovered())
				 {
					 UI.print("PARAB�NS! Voc� acertou a palavra completa: " + word.getOriginalWord());
					 UI.print("FIM DO JOGO");
					 break;
				 }
				 
				 if(errorCount == MAX_ERRORS)
				 {
					 UI.print("Voc� perdeu o jogo. A palavra correta era: " + word.getOriginalWord());
					 UI.print("FIM DO JOGO");
					 break;
				 }
			} 
			catch (InvalidCharacterException e) 
			{
				UI.print(e.getMessage());
				UI.printNewLine();
			}
			
		}		
	}
}
