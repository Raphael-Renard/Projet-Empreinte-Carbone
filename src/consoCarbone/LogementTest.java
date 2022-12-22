package consoCarbone;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// import org.junit.Before;
// import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LogementTest {
	private Logement log;

	@BeforeEach
	void setUp() throws Exception {
		this.log = new Logement();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.log = null;
	}

	@ParameterizedTest
	@CsvSource(value ={"E-200-Songez à renover votre logement pour qu'il ait une meilleure classe énergétique.\nSi vous n'avez pas besoin d'un logement aussi grand, songez à déménager pour réduire les dépenses énergétiques.", "A-150-Si vous n'avez pas besoin d'un logement aussi grand, songez à déménager pour réduire les dépenses énergétiques."}, delimiter='-')
	void testConseil(CE ce, int s, String rep) {
		// Act
		ByteArrayOutputStream out = new ByteArrayOutputStream();    
		System.setOut(new PrintStream(out));
		this.log.setce(ce);
		this.log.setsuperficie(s);
		this.log.conseil();
		// Assert
		String str=out.toString();
		assertEquals(rep,str.substring(0,str.lastIndexOf("\n")-1 ));
	}

	@ParameterizedTest
	@CsvSource({"134,134", "-25,0"})
	void testSetsuperficie(int s, int res) {
		//Act
		this.log.setsuperficie(s);
		//Assert
		assertEquals(this.log.getsuperficie(),res);
	}

	@ParameterizedTest
	@CsvSource({"A,A", "Q,G"})
	void testSetce(CE ce, CE res) {
		//Act
		this.log.setce(ce);
		//Assert
		assertEquals(this.log.getce(),res);
	}

}
