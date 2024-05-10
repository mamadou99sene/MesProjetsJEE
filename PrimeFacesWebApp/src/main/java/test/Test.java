package test;

import bdbeans.Personnes;
import bdbeans.PersonnesHome;

public class Test {

	public static void main(String[] args) {
		Personnes p=new PersonnesHome().connexion("123", "line@gmail.com");
		if(p!=null)
		{
			System.out.print(p.getPrenom());
		}
		else
		{
			System.out.print("Login ou password incorrect");
		}

	}

}
