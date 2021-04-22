package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projetSynthese.Cavalier;
import projetSynthese.Deplacement;
import projetSynthese.Echiquier;
import projetSynthese.Fou;
import projetSynthese.Pion;
import projetSynthese.Position;
import projetSynthese.Reine;
import projetSynthese.Roi;
import projetSynthese.Tour;

public class TestEchecsPartie2 {

	// présentation de variables, d'objets
	Echiquier e;

	@Before
	public void setUp() {

		// création d'objets, initialisation de variables
		e = new Echiquier();
		e.getCase(0, 2).setPiece(new Reine("Noir"));
		e.getCase(0, 4).setPiece(new Pion("Blanc"));
		e.getCase(0, 5).setPiece(new Tour("Blanc"));
		e.getCase(1, 0).setPiece(new Tour("Noir"));
		e.getCase(1, 1).setPiece(new Pion("Noir"));
		e.getCase(2, 5).setPiece(new Fou("Noir"));
		e.getCase(3, 3).setPiece(new Cavalier("Noir"));
		e.getCase(4, 1).setPiece(new Pion("Blanc"));
		e.getCase(4, 4).setPiece(new Roi("Blanc"));
		e.getCase(4, 7).setPiece(new Cavalier("Noir"));
		e.getCase(5, 2).setPiece(new Pion("Noir"));
		e.getCase(6, 1).setPiece(new Pion("Blanc"));
		e.getCase(6, 3).setPiece(new Pion("Blanc"));
		e.getCase(6, 4).setPiece(new Pion("Noir"));
		e.getCase(6, 5).setPiece(new Reine("Blanc"));
		e.getCase(7, 7).setPiece(new Tour("Blanc"));
	}

	// test vérifiant qu'un Pion peut se déplacer en ligne droite
	@Test
	public void test1() {
		Position depart = new Position(0, 4);
		Position arrivee = new Position(0, 3);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérifiant qu'une Reine peut capturer une pièce ennemie en ligne
	// droite
	@Test
	public void test2() {
		Position depart = new Position(0, 4);
		Position arrivee = new Position(0, 3);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérifiant qu'une Reine ne peut passer au-dessus d'une autre Pièce
	@Test
	public void test3() {
		Position depart = new Position(0, 2);
		Position arrivee = new Position(0, 5);
		assertEquals(false, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérifiant qu'une Tour peut capturer une Pi�ce ennemie
	@Test
	public void test4() {
		Position depart = new Position(0, 5);
		Position arrivee = new Position(2, 5);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'un Fou peut se déplacer en diagonale vers une case
	// libre
	@Test
	public void test5() {
		Position depart = new Position(2, 5);
		Position arrivee = new Position(0, 3);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'un Fou ne peut capturer une pièce de même couleur
	@Test
	public void test6() {
		Position depart = new Position(2, 5);
		Position arrivee = new Position(4, 7);
		assertEquals(false, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'un Pion peut se déplacer en ligne droite
	@Test
	public void test7() {
		Position depart = new Position(1, 1);
		Position arrivee = new Position(1, 2);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'un Cavalier ne peut capturer une pièce de même couleur
	@Test
	public void test8() {
		Position depart = new Position(3, 3);
		Position arrivee = new Position(2, 5);
		assertEquals(false, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'un Cavalier peut se déplacer vers une case vide
	@Test
	public void test9() {
		Position depart = new Position(3, 3);
		Position arrivee = new Position(1, 2);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'un Cavalier peut capturer une pièce ennemie
	@Test
	public void test10() {
		Position depart = new Position(3, 3);
		Position arrivee = new Position(4, 1);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'un Roi peut capturer une Pièce ennemie
	@Test
	public void test11() {
		Position depart = new Position(4, 4);
		Position arrivee = new Position(3, 3);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'un Roi peut se déplacer vers une case vide
	@Test
	public void test12() {
		Position depart = new Position(4, 4);
		Position arrivee = new Position(5, 4);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'une Reine peut capturer une autre Piece en diagonale
	@Test
	public void test13() {
		Position depart = new Position(6, 5);
		Position arrivee = new Position(1, 0);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'une Reine ne peut pas passer au-dessus d'une autre
	// Piece
	@Test
	public void test14() {
		Position depart = new Position(6, 5);
		Position arrivee = new Position(1, 5);
		assertEquals(false, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'une Reine peut capturer une Piece ennemie à
	// l'horizontale
	@Test
	public void test15() {
		Position depart = new Position(6, 5);
		Position arrivee = new Position(2, 5);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'une Reine peut se déplacer vers une case libre
	@Test
	public void test16() {
		Position depart = new Position(6, 5);
		Position arrivee = new Position(3, 5);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'un Pion ne peut pas capturer une Piece en ligne droite
	@Test
	public void test17() {
		Position depart = new Position(6, 4);
		Position arrivee = new Position(6, 5);
		assertEquals(false, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'une Tour peut se déplacer vers une case vide
	@Test
	public void test18() {
		Position depart = new Position(7, 7);
		Position arrivee = new Position(7, 0);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'une Tour peut se déplacer vers une case vide
	@Test
	public void test19() {
		Position depart = new Position(7, 7);
		Position arrivee = new Position(7, 5);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'une Piece peut ne pas bouger
	@Test
	public void test20() {
		Position depart = new Position(0, 2);
		Position arrivee = new Position(0, 2);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	// test vérfiiant qu'une Pion ne peut pas se déplacer diagonalement vers une
	// Case libre
	@Test
	public void testUn() {
		Position depart = new Position(4, 1);
		Position arrivee = new Position(5, 0);
		assertEquals(false, e.captureParUnPionPossible(new Deplacement(depart,
				arrivee)));
	}

	// test vérfiiant qu'une Pion ne peut pas se déplacer diagonalement en
	// reculant
	@Test
	public void testDeux() {
		Position depart = new Position(4, 1);
		Position arrivee = new Position(5, 2);
		assertEquals(false, e.captureParUnPionPossible(new Deplacement(depart,
				arrivee)));
	}

	// test vérfiiant qu'une Pion ne peut pas se déplacer diagonalement en
	// reculant
	@Test
	public void testTrois() {
		Position depart = new Position(2, 5);
		Position arrivee = new Position(6, 1);
		assertEquals(false, e.captureParUnPionPossible(new Deplacement(depart,
				arrivee)));
	}

	// test vérfiiant qu'une Pion ne peut pas se déplacer diagonalement en
	// reculant
	@Test
	public void testQuatre() {
		Position depart = new Position(6, 1);
		Position arrivee = new Position(5, 2);
		assertEquals(false, e.captureParUnPionPossible(new Deplacement(depart,
				arrivee)));
	}

	// test vérfiiant qu'une Pion ne peut pas se déplacer diagonalement en
	// reculant
	@Test
	public void testCinq() {
		Position depart = new Position(6, 1);
		Position arrivee = new Position(7, 2);
		assertEquals(false, e.captureParUnPionPossible(new Deplacement(depart,
				arrivee)));
	}

	// test vŽrifiant qu'une Pion peut capturer une piece ennemie en diagonale
	@Test
	public void testSix() {
		Position depart = new Position(5, 2);
		Position arrivee = new Position(6, 3);
		assertEquals(true, e.captureParUnPionPossible(new Deplacement(depart,
				arrivee)));
	}

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("projetSynthese.TestEchecsPartie2");
	}

}