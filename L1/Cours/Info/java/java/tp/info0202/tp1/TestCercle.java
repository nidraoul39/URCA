package tp1;
import java.lang.Math;
class TestCercle {

    public static void main(String[] args){
        Cercle rond = new Cercle();
        Cercle r1 = new Cercle(1,3.6,-1.6);
        System.out.println(rond.DEC(r1));
        if(rond.getX()>0 && r1.getX()>0)
            System.out.println(rond + "\n" + r1);

        System.out.println("RIP\n"+ rond + "\n" + r1);
    }
    public static int indiceplusloin(Cercle[] t){
        Cercle o = new Cercle();
        int maxind=0;
        double distind=t[0].DEC(o);
        for(int i=1;i<t.length;i++){
            double e = t[i].DEC(o);
            if(e>distind){
                maxind = i;
                distind = e;
            }
        }
        return maxind;
    }

}
