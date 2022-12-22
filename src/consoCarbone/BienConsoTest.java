package consoCarbone;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

//import org.junit.Before;
//import org.junit.BeforeClass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BienConsoTest {
	
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
	}
	
	@ParameterizedTest
	@CsvSource(value ={"3000-Essayez de faire moins d'achats si cela ne vous est pas utile. Essayer d'acheter des objets reconditionnés, des vêtements dans des friperies,...", "12-Essayez de faire moins d'achats si cela ne vous est pas nécéssaire."}, delimiter='-')
	void testConseil(double m, String rep) {
		// Act
		ByteArrayOutputStream out = new ByteArrayOutputStream();    
		System.setOut(new PrintStream(out));
		this.bien.setmontant(m);
		this.bien.conseil();
		// Assert
		String s=out.toString();
		assertEquals(rep,s.substring(0,s.lastIndexOf("\n")-1 ));
	}

}
