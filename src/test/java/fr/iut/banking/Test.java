package fr.iut.banking;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"application.yaml"});
//		IBankingMetier metier=(IBankingMetier)context.getBean("metier");
//		metier.addClient(new Client("C1", "AD1"));
//		metier.addClient(new Client("C2", "AD2"));
//		
//		
//		// L == Long
//		metier.addEmploye(new Employe("E1"), null);
//		metier.addEmploye(new Employe("E2"), 1L);
//		metier.addEmploye(new Employe("E3"), 1L);
//		
//		metier.addGroupe(new Groupe("G1"));
//		metier.addGroupe(new Groupe("G2"));
//		
//		metier.addEmployeToGroupe(1L, 1L);
//		metier.addEmployeToGroupe(2L, 2L);
//		metier.addEmployeToGroupe(3L, 2L);
//		
//		metier.addCompte(new CompteCourant("CC1", new Date(), 9000,8000 ), 1L, 2L);
//		metier.addCompte(new CompteEpargne("CE1", new Date(), 40000,5.5), 2L, 2L);
//		
//		metier.versement("CC1", 5000, 2L);
//		metier.retrait("CC1", 6000, 2L);
//		
//		metier.virement("CC1", "CE1", 4000, 3L);
		
		
		
	}

}
