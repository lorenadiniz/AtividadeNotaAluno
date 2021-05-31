package teste.model;

import org.junit.jupiter.api.Test;

import exceptions.NomeIncorretoException;
import exceptions.NotaInvalidaException;
import model.Aluno;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlunoTest {
	private Aluno al;

	@BeforeEach
	private void instanciar() {
		al = new Aluno();
	}

	public void AvaliaNomeAlunoVazio() {
		String entrada = "";

		// comparação com o resultado esperado
		assertThrows(RuntimeException.class, () -> al.setNome(entrada));

	}

	@Test
	public void naoUltrapassarLimiteNotaUmLancamento() throws NotaInvalidaException {
		al.entraNota(120.0);
		assertEquals(0, al.getNotas().size());
	}

	@Test
	public void naoUltrapassarLimiteNotaVariosLancamento() throws NotaInvalidaException {
		al.entraNota(20.0);
		al.entraNota(30.0);
		al.entraNota(20.0);
		al.entraNota(10.0);
		al.entraNota(25.0);
		assertEquals(80.0, al.retornaNotaTotal());

	}

	@Test
	public void zeroNotasLancadas() throws NotaInvalidaException {
		assertEquals(0, al.retornaNotaTotal());
	}

	@Test
	public void validarNotaVazia() throws NotaInvalidaException {
		al.entraNota();
		assertEquals(0, al.retornaNotaTotal());
	}

	@Test
	public void validarNotaAcimadeTrinta() throws NotaInvalidaException {
		al.entraNota(50.0);
		assertEquals(0, al.retornaNotaTotal());
	}

	@Test
	public void validarNotaNegativa() throws NotaInvalidaException {
		al.entraNota(-5.0);
		assertEquals(0, al.retornaNotaTotal());
	}

	@Test
	public void validarNome() throws NomeIncorretoException {
		al.setNome("   Joao    ");
		assertEquals("Joao", al.getNome());
	}

}
