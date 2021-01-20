package jogodaforca.game;

import java.util.HashSet;
import java.util.Set;

import jogodaforca.core.Config;
import jogodaforca.core.Dictionary;
import jogodaforca.core.InvalidCharacterException;
import jogodaforca.core.Word;
import jogodaforca.ui.UI;

public class Game {
	
	public void start()
	{
		UI.print("Bem vindo ao jogo da forca!!");
		
		Dictionary d = Dictionary.getInstance();
		Word word = d.nextWord();
		int errorCount = 0;
		int maxErrors = Integer.parseInt(Config.get("maxErrors"));
		
		UI.print("A palavra tem " + word.size() + " letras.");
		UI.print("Você pode errar no máximo " + maxErrors + " vez(es).");
		
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
					 throw new InvalidCharacterException("Esta letra já foi digitada.");
				 }
				 
				 usedChars.add(c);
				 
				 if(word.hasChar(c))
				 {
					 UI.print("Você acertou uma letra!");
				 }
				 else
				 {
					 errorCount++;
					 
					 if(errorCount < maxErrors)
					 {
						 UI.print("Você errou! Você ainda possui " +(maxErrors - errorCount) + " tentativa(s).");
					 }
				 }
				 
				 UI.printNewLine();
				 
				 if(word.discovered())
				 {
					 UI.print("PARABÉNS! Você acertou a palavra completa: " + word.getOriginalWord());
					 UI.print("FIM DO JOGO");
					 break;
				 }
				 
				 if(errorCount == maxErrors)
				 {
					 UI.print("Você perdeu o jogo. A palavra correta era: " + word.getOriginalWord());
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
