package com.isamm.store;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isamm.store.entities.Categorie;
import com.isamm.store.metier.UserBoutiqueMetier;

public class TestJPA {

	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "ApplicationContext.xml" });
			UserBoutiqueMetier metier = (UserBoutiqueMetier) context.getBean("metier");
			List<Categorie> cats1 = metier.listCategories();
			metier.ajouterCategorie(new Categorie("Ordinateur", "Ordinateurs", null, ""));
			metier.ajouterCategorie(new Categorie("Imprimantes", "Imprimantes", null, ""));
			List<Categorie> cats2 = metier.listCategories();
			assertTrue(cats2.size() == cats1.size() + 2);
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}

}
