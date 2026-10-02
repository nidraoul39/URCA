import etoilecraft.*;
import java.util.Vector;
public class TestEtoileCraft{

	public void main(String[] args){
		IUnite u1 = new Marine(100,8,5.5);
		IUnite u2 = new Cuirasse(300,5,3.2,1.5);
		
		System.out.println("puissance sol u2 "+u2.getPuissanceTirSol());
		System.out.println("puissance sol u1 "+u1.getPuissanceTirSol());
		
		while(u2.getPointsDeVie()>0 && u1.getPointsDeVie()>0){
			if(Math.random()>0.5)
				u2.attaquer(u1);
			else
				u1.attaquer(u2);
				
			System.out.println("les hp de u1 : "+u1.getPointsDeVie()+" les hp de u2 : "+u2.getPointsDeVie());
		}
		
		Vector<IUnite> unite = new Vector<IUnite>();


		
		int i;
		int j;
		int[] gagn = new int[3];
		gagn[0] = 0;
		gagn[1] = 0;
		gagn[2] = 0;
		for(int e =0; e<100;e++){
		
		
		while(unite.size()!= 1){
			unite = new Vector<IUnite>();
			for(int v =0;v<15;v++){
				unite.add(uniteAuHasard());
			}

			System.out.println("t");
			i = (int) (Math.random()*unite.size());
			
			do{
				j = (int) (Math.random()*unite.size());
				System.out.println("t");
			}while(i==j && unite.size()!=1);
			combat(i,j,unite);
		}
		System.out.println(unite.get(0) + " est le gagnant du battle royal");
		if(unite.get(0) instanceof Marine)
			gagn[0]++;
		else if(unite.get(0) instanceof Cuirasse)
			gagn[1]++;
		else
			gagn[2]++;
		}
		System.out.println("le marin gange "+gagn[0]+" le cuirasse "+gagn[1]+" et le flammeur"+gagn[2]);
		
		
	}
	public static IUnite uniteAuHasard(){
		double r = Math.random();
		IUnite u;
		if(r>0.5)
			u = new Marine(100,8.2,5);
		else if(r<0.3)
			u = new Flammeur(250,5,4);
		else
			u = new Cuirasse(100,5,3.2,1.7);
		return u; 
	
	}
	public static void combat(int i, int j,Vector<IUnite> u){
		if(u.get(i).attaquer(u.get(j))){
			u.removeElementAt(j);
			System.out.println("1 est mort");}
		else{
			System.out.println("il reste  "+u.get(j).getPointsDeVie());
			System.out.println(u.get(i) + "se bat contre" + u.get(j));
			}
	}
	
	

}
