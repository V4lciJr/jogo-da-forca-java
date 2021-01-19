package jogodaforca.ui;

import java.util.Scanner;

import jogodaforca.core.InvalidCharacterException;

public class UI {
	
	public static void print(Object object)
	{
		System.out.println(object);
	}
	
	public static void printNewLine()
	{
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	public static char readChar(String text) throws InvalidCharacterException
	{
		System.out.println(text + " ");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		if(line.trim().isEmpty())
		{
			throw new InvalidCharacterException("ERRO. Nenhuma letra foi digitada.");
		}
		if(line.length() > 1)
		{
			throw new InvalidCharacterException("ERRO. Você digitou mais de uma letra.");
		}
		
		char c = line.charAt(0);
		
		if(!Character.isLetter(c))
		{
			throw new InvalidCharacterException("ERRO. Apenas letras podem ser digitadas.");
		}
		
		return c;
	}
}
