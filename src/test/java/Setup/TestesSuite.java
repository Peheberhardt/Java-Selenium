package Setup;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import Main.Corporativo_ADM.Administradores;
import Main.Corporativo_ADM.AgentesPenitenciarios;
import Main.Corporativo_ADM.Antecedentes;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	Administradores.class,
	AgentesPenitenciarios.class,
	Antecedentes.class
})

public class TestesSuite {
	
}
