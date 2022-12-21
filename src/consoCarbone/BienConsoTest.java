package consoCarbone;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BienConsoTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private PrintStream stdOut = System.out ;
	private BienConso bien;

	@BeforeEach
	void setUp() throws Exception {
		
		this.bien = new BienConso();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.bien = null;
	}

	@ParameterizedTest
	@CsvSource({ "123,123", "-34,0"})
	void testSetmontant_positif(double m,double res) {
		//Act
		this.bien.setmontant(m);
		//Assert
		assertEquals(this.bien.getMontant(),res);
		// fail("Not yet implemented");
	}
	
	@ParameterizedTest
	@CsvSource({ "3000,Essayez de faire moins d'achats si cela ne vous est pas utile. Essayer d'acheter des objets reconditionnés, des vêtements dans des friperies,...", "12,Essayez de faire moins d'achats si cela ne vous est pas nécéssaire."})
	void testConseil(double m, String rep) {
		// Act
		this.bien.setmontant(m);
		this.bien.conseil();
		// Assert
		assertEquals(rep,outContent.toString());
		//fail("Not yet implemented"); // TODO
	}

}
