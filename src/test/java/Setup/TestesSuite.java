package Setup;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import Main.Corporativo_ADM.Administradores;
import Main.Corporativo_ADM.AgentesPenitenciarios;
import Main.Corporativo_ADM.Antecedentes;
import Main.Corporativo_ADM.Clientes;
import Main.Corporativo_ADM.ClinicasDigitais;
import Main.Corporativo_ADM.Enfermeiros;
import Main.Corporativo_ADM.Especialidades;
import Main.Corporativo_ADM.HipótesesDiagnósticas;
import Main.Corporativo_ADM.Medicos;
import Main.Corporativo_ADM.Ocorrencias;
import Main.Corporativo_ADM.Operadores;
import Main.Corporativo_ADM.Parceiros;
import Main.Corporativo_ADM.Perfis;
import Main.Corporativo_ADM.PrescricoesMedicas;
import Main.Corporativo_ADM.TecnicoEmEnfermagem;
import Main.Corporativo_ADM.Turnos;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	Administradores.class,
	AgentesPenitenciarios.class,
	Antecedentes.class,
	Clientes.class,
	ClinicasDigitais.class,
	Enfermeiros.class,
	Medicos.class,
	Parceiros.class,
	TecnicoEmEnfermagem.class,
	Perfis.class,
	Operadores.class,
	PrescricoesMedicas.class,
	HipótesesDiagnósticas.class,
	Turnos.class,
	Especialidades.class,
	Ocorrencias.class
})

public class TestesSuite {

}
