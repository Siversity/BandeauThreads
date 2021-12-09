package bandeau;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Stéphane
 */
public class MultiScenario extends Thread {
    
    private Bandeau bandeau;
    private List<ScenarioElement> myElements = new LinkedList<>();
    
    public MultiScenario(Bandeau bandeau, List<ScenarioElement> myElements) {
        this.bandeau = bandeau;
        this.myElements = myElements;
    }
    
    @Override
    public void run() {
        // On place notre verrou sur le bandeau car celui-ci ne peut pas être exécuté 2x en même temps
        synchronized(bandeau) {
            
            // On exécute l'affichage de nos effets
            for (ScenarioElement element : myElements) {
                for (int repeats = 0; repeats < element.repeats; repeats++) {
                    element.effect.playOn(bandeau);
                }
            }
        }
    }
    
}
