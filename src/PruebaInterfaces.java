import java.util.ArrayList;
import java.util.List;

public class PruebaInterfaces {

    //Abstraccion
    //Polimorfismo
    //Herencia

    public static void main(String[] args) {

       ReproductorCassete reproductorCassete= new ReproductorCassete("Iron maiden");
       ReproductorCD reproductorCD= new ReproductorCD("Iron maiden");
       ReproductorDVD reproductorDVD= new ReproductorDVD("Spiderman 2");
       ReproductorBlueray reproductorBlueray= new ReproductorBlueray("El principito");

       List<ReproductorCassete> listaReproductorCassete= new ArrayList<>();
       listaReproductorCassete.add(reproductorCassete);


       List<ReproductorCD> listaReproductorCD= new ArrayList<>();
       List<ReproductorDVD> listaReproductorDVD= new ArrayList<>();

       List<ReproductorBlueray> listaReproductorBlueray= new ArrayList<>();
       listaReproductorBlueray.add(reproductorBlueray);


       List<ReproductorMultimedia> listaGenerica = new ArrayList<>();
        listaGenerica.add(reproductorCassete);
        listaGenerica.add(reproductorCD);
        listaGenerica.add(reproductorDVD);
        listaGenerica.add(reproductorBlueray);

        for(int i=1;i<16;i++){
            listaGenerica.add(new ReproductorDVD("Greys Anatomy temporada" + i));

        }

        for(ReproductorMultimedia reproductor: listaGenerica){
            reproductor.reproducir();
        }


    }

    static class Reproductor{

        private String media;
        public Reproductor(String media) {
            this.media = media;
        }

        public String getMedia() {
            return media;
        }
    }


    static class ReproductorCassete extends Reproductor implements ReproductorMultimedia{


        public ReproductorCassete(String medio) {
            super(medio);
        }

        @Override
        public void reproducir() {
            System.out.println("Se reproduce el Cassete " + getMedia());
        }

        @Override
        public void detener() {

        }

        @Override
        public void rebobinar() {

        }

        @Override
        public void adelantar() {

        }

        public void grabar(){

        }
    }

    static class ReproductorDVD extends Reproductor implements ReproductorMultimedia{


        public ReproductorDVD(String medio) {
            super(medio);
        }

        @Override
        public void reproducir() {
            System.out.println("Se reproduce el DVD " + getMedia());
        }

        @Override
        public void detener() {

        }

        @Override
        public void rebobinar() {

        }

        @Override
        public void adelantar() {

        }
    }

    static class ReproductorCD extends Reproductor implements ReproductorMultimedia{

        public ReproductorCD(String medio) {
            super(medio);
        }

        @Override
        public void reproducir() {
            System.out.println("Se reproduce el CD " + getMedia());
        }

        @Override
        public void detener() {

        }

        @Override
        public void rebobinar() {

        }

        @Override
        public void adelantar() {

        }
    }

    static class ReproductorBlueray extends Reproductor implements  ReproductorMultimedia{


        public ReproductorBlueray(String medio) {
            super(medio);
        }

        @Override
        public void reproducir() {
            System.out.println("Se reproduce el blueray " + getMedia());
        }

        @Override
        public void detener() {

        }

        @Override
        public void rebobinar() {

        }

        @Override
        public void adelantar() {

        }
    }



}
