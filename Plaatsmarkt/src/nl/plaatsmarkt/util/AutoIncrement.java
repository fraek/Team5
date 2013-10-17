package nl.plaatsmarkt.util;

import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Veiling;


public class AutoIncrement {
	public AutoIncrement(){
	}
	
	public int Increment(){
		return rIncrement(1);
	}
	
	public int rIncrement(int i){
		if(i <= 0){
			return rIncrement(1);
		}else{
			//1 > 2 statement aanpassen naar een has statement. (controle of het al bezet is)
			if(1 > 2){
				System.out.println("auto inc: "+i+" al bezet");
				return rIncrement(i+1);
			}else{
				System.out.println("auto inc: "+i+" niet bezet");
				return i;
			}
		}
	}
	
}
