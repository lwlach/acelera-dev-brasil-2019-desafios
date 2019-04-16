package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List<Time> timeList;

	public DesafioMeuTimeApplication() {
		timeList = new ArrayList<>();
	}

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if(this.getTimeById(id) != null) {
			throw new IdentificadorUtilizadoException();
		}
		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		timeList.add(time);
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Time time = this.getTimeById(idTime);
		if(this.getJogadorById(id)!=null){
			throw new IdentificadorUtilizadoException();
		}
		if(time==null){
			throw new TimeNaoEncontradoException();
		}
		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		time.addJogador(jogador);
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		Time time = this.getTimeByIdJogador(idJogador);
		if(time == null){
			throw new JogadorNaoEncontradoException();
		}
		Jogador jogador = time.getJogador(idJogador);
		time.setCapitao(jogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		Time time = this.getTimeById(idTime);
		if(time==null){
			throw new TimeNaoEncontradoException();
		}
		if(time.getCapitao() == null){
			throw new CapitaoNaoInformadoException();
		}
		return time.getCapitao().getId();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		Jogador jogador = this.getJogadorById(idJogador);
		if(jogador != null){
			return jogador.getNome();
		}
		throw new JogadorNaoEncontradoException();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		Time time = this.getTimeById(idTime);
		if(time != null){
			return time.getNome();
		}
		throw new TimeNaoEncontradoException();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		Time time = this.getTimeById(idTime);
		if(time == null){
			throw new TimeNaoEncontradoException();
		}
		return time.getJogadorList().stream()
				.map(Jogador::getId)
				.sorted()
				.collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Time time = this.getTimeById(idTime);
		if(time == null){
			throw new TimeNaoEncontradoException();
		}
		return Collections.max(time.getJogadorList(), Comparator.comparing(Jogador::getNivelHabilidade)).getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		Time time = this.getTimeById(idTime);
		if(time == null){
			throw new TimeNaoEncontradoException();
		}
		Jogador jogador = Collections.min(time.getJogadorList(), (Jogador o1, Jogador o2) -> {
			LocalDate d1 = o1.getDataNascimento();
			LocalDate d2 = o2.getDataNascimento();
			if(d1.isAfter(d2)){ //jogador mais novo
				return 1;
			} else if(d1.isBefore(d2)){ //jogador mais velho
				return -1;
			}
			return Long.compare(o1.getId(), o2.getId());
		});
		return jogador.getId();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return timeList.stream()
				.map(Time::getId)
				.collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		Time time = this.getTimeById(idTime);
		if(time == null){
			throw new TimeNaoEncontradoException();
		}
		Jogador jogador = Collections.max(time.getJogadorList(), (Jogador o1, Jogador o2) -> {
			BigDecimal s1 = o1.getSalario();
			BigDecimal s2 = o2.getSalario();
			return s1.compareTo(s2) !=0 ? s1.compareTo(s2) : Long.compare(o2.getId(), o1.getId()); //inverti os jogadores para obter o menor id
		});
		return jogador.getId();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		Jogador jogador = this.getJogadorById(idJogador);
		if(jogador == null){
			throw new JogadorNaoEncontradoException();
		}
		return jogador.getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> idTopJogadores = new ArrayList<>();
		List<Jogador> todosJogadores = new ArrayList<>();
		timeList.forEach(time -> todosJogadores.addAll(time.getJogadorList()));
		if(!todosJogadores.isEmpty()){
			Collections.sort(todosJogadores, (Jogador o1, Jogador o2) -> {
				Integer n1 = o1.getNivelHabilidade();
				Integer n2 = o2.getNivelHabilidade();
				return !n1.equals(n2) ? Integer.compare(n2, n1) : Long.compare(o1.getId(), o2.getId()); //inverti os jogadores para ordenar decrescente
			});
			if(top > todosJogadores.size()) top = todosJogadores.size();
			List<Jogador> topJogadores = todosJogadores.subList(0, top);
			topJogadores.forEach(jogador -> idTopJogadores.add(jogador.getId()));
		}
		return idTopJogadores;
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time timeCasa = this.getTimeById(timeDaCasa);
		Time timeFora = this.getTimeById(timeDeFora);
		if(timeCasa == null || timeFora == null){
			throw new TimeNaoEncontradoException();
		}
		if(timeCasa.getCorUniformePrincipal().equals(timeFora.getCorUniformePrincipal())){
			return timeFora.getCorUniformeSecundario();
		}
		return timeFora.getCorUniformePrincipal();
	}

	private Time getTimeById(Long idTime){
		return timeList.stream()
				.filter(time -> idTime.equals(time.getId()))
				.findAny()
				.orElse(null);
	}

	private Time getTimeByIdJogador(Long idJogador){
		return timeList.stream()
				.filter(time -> time.getJogador(idJogador)!=null)
				.findAny()
				.orElse(null);
	}

	private Jogador getJogadorById(Long idJogador){
		return timeList.stream()
				.filter(time -> time.getJogador(idJogador)!=null)
				.map(time -> time.getJogador(idJogador))
				.findAny()
				.orElse(null);
	}

	public List<Time> getTimeList() {
		return Collections.unmodifiableList(timeList);
	}
}
