package GetPIByMonteCarlo;

public class AlgoMain {

    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10000;
        String title = "Get PI with Monte Carlo";

        new AlgoVisualizer(sceneWidth, sceneHeight, title, N);
    }
}
