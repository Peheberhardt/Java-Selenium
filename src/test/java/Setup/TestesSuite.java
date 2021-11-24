package Setup;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import Main.Corporativo_ADM.Administradores;
import Main.Corporativo_ADM.AgentesPenitenciarios;
import Main.Corporativo_ADM.Antecedentes;
import Main.Corporativo_ADM.Clientes;
import Main.Corporativo_ADM.ClinicasDigitais;
import Main.Corporativo_ADM.Enfermeiros;
import Main.Corporativo_ADM.Medicos;
import Main.Corporativo_ADM.Parceiros;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	Administradores.class,
	AgentesPenitenciarios.class,
	Antecedentes.class,
	Clientes.class,
	ClinicasDigitais.class,
	Enfermeiros.class,
	Medicos.class,
	Parceiros.class
})

public class TestesSuite {

}
