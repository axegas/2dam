/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

/**
 *
 * @author peixe
 */
public class PrincipalVideojuegosSeries {

    public static void main(String[] args) {
        Videojuego videojuegos[] = new Videojuego[5];
        Serie series[] = new Serie[5];

        videojuegos[0] = new Videojuego("Worms", 5, "Lucha", "EA");
        videojuegos[1] = new Videojuego("Fifa",4);
        videojuegos[2] = new Videojuego();
        videojuegos[3] = new Videojuego("Among Us", 12, "Espionaje", "Unity");
        videojuegos[4] = new Videojuego("NBA Live", 11);

        series[0] = new Serie("Fringe", 7, "Ciencia ficción", "J.J. Abrams");
        series[1] = new Serie("Friends", "Marta Kauffman");
        series[2] = new Serie();
        series[3] = new Serie("Perdidos", 6, "Ciencia ficción", "J.J. Abrams");
        series[4] = new Serie("Dare Devil", "Marvel");
        
        videojuegos[0].entregar();
        videojuegos[2].entregar();
        videojuegos[4].entregar();
        
        series[1].entregar();
        series[3].entregar();

        int videojuegosEntregados = 0;
        int seriesEntregadas = 0;
        int masHoras = 0;
        int videojuegoMasHoras = 0;
        int serieMasTemporadas = 0;
        int masTemporadas = 0;
        for(int i = 0;i<5;i++){
            videojuegosEntregados = videojuegos[i].isEntregado() ? (videojuegosEntregados + 1) : videojuegosEntregados;
            seriesEntregadas = series[i].isEntregado() ? (seriesEntregadas + 1) : seriesEntregadas;
            if(videojuegos[i].getHorasEstimadas() > masHoras){
                videojuegoMasHoras = i;
                masHoras = videojuegos[i].getHorasEstimadas();
            }
            if(series[i].getTemporadas() > masTemporadas){
                serieMasTemporadas = i;
                masTemporadas = series[i].getTemporadas();
            }            
        }
        System.out.println("Videojuegos entregados: " + videojuegosEntregados + "\tSeries entregadas: " + seriesEntregadas);
        System.out.println("Videojuego con más horas: " + videojuegos[videojuegoMasHoras] + "\nSerie con más temporadas: " + series[serieMasTemporadas]);
    }

}
