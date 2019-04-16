package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainTeste {


    public static List<Jogador> jogadores = new ArrayList<>();

    public static void main(String[] args) {
        jogadores.add(new Jogador(1L, 1L, "jogador1", LocalDate.of(1995, 6, 11), 30, BigDecimal.valueOf(2000)));
        jogadores.add(new Jogador(2L, 1L, "jogador2", LocalDate.of(1995, 6, 22), 10, BigDecimal.valueOf(2000)));
        jogadores.add(new Jogador(3L, 1L, "jogador3", LocalDate.of(1995, 6, 20), 30, BigDecimal.valueOf(1500)));
        jogadores.add(new Jogador(4L, 1L, "jogador4", LocalDate.of(1995, 6, 11), 10, BigDecimal.valueOf(1000)));
        Long idJogador = 5L;

        Jogador jogador = Collections.max(jogadores, Comparator.comparing(Jogador::getNivelHabilidade));
        System.out.println(jogador);
//        Jogador j = jogadores.stream()
//                .filter(jogador -> idJogador.equals(jogador.getId()))
//                .findAny()
//                .orElse(null);
//        System.out.println(j);

//        Jogador jogador = getJogador(2L);
//        jogador.setNome("leonardo");
//        System.out.println(jogadores);

//        List<Long> idJogadores = jogadores.stream().map(Jogador::getId).collect(Collectors.toList());
//        System.out.println(idJogadores);
//
//        Jogador jogador = Collections.max(jogadores, (Jogador o1, Jogador o2) -> {
//            BigDecimal s1 = o1.getSalario();
//            BigDecimal s2 = o2.getSalario();
//            return s1.compareTo(s2) !=0 ? s1.compareTo(s2) : Long.compare(o2.getId(), o1.getId()); //inverti os jogadores para obter o menor id
//        });

//        System.out.println(jogador);

//        List<Time> times = new ArrayList<>();
//        times.add(new Time(1L, "time1", null, null, null));
//
//        Time time = times.get(0);
//        time.addJogador(jogador);
//
//        List<Jogador> jList = time.getJogadorList();
//        jList.get(0).setNome("novo nome");
//        jogadores.forEach(j -> System.out.println(j.getNome()));
//        j1 = jList.get(0);
//        time.setCapitao(j1);
//        times.forEach(t -> System.out.println(t.getCapitao().getNome()));
    }

    public static Jogador getJogador(Long idJogador){
        for(Jogador jogador : jogadores){
            if(jogador.getId().equals(idJogador)){
                return jogador;
            }
        }
        return null;
    }
}
