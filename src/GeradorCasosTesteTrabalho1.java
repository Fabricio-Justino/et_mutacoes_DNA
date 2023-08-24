import java.util.Random;

public class GeradorCasosTesteTrabalho1 {
   
    public static void main(String[] args) {
        if(args.length==0) {
            System.out.println("java GeradorCasosTesteTrabalho1 [total]");
            System.exit(1);
        }
        Random r = new Random();
        int total = Integer.parseInt(args[0]);
        char[] letras = { 'D', 'N', 'A' };
        for(int i=0; i<total; i++)
            System.out.print(letras[r.nextInt(3)]);
        System.out.println();
    }
}
