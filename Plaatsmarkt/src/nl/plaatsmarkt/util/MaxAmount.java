package nl.plaatsmarkt.util;

import java.util.List;

import nl.plaatsmarkt.domain.Bod;

public class MaxAmount {

	public double bedrag(int veilingID, List<Bod> alleBiedingen){
		double max = 0.0;
		if(alleBiedingen != null){
			for(Bod b : alleBiedingen){
				if(b.getDeVeiling().getID() == veilingID){
					if(b.getBedrag() > max) max = b.getBedrag();
				}
			}
		}
		return max;
	}
}
