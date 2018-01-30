package Oving9;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class klient {
    public static void main(String[] args) {
        String[] asdasd= {"asd","dsa","wsx"};
        Tribune[] tribune= {new Staa("asd",25,2000, 5),new Sitte("asd",25,2000, 5),new VIP("das",25,20000,5)};
        Billett[] billetter=tribune[0].kjopBillet(5);
        Billett[] billetterr=tribune[1].kjopBillet(asdasd);
        Billett[] bill3 =tribune[2].kjopBillet(asdasd);
        Billett[] bill4 =tribune[2].kjopBillet(asdasd);

        for (Billett a:
             billetter) {

            System.out.println(a);
        }
       for (Billett a:billetterr) {

            System.out.println(a);
        }
        for (Billett a:
             bill3) {

            System.out.println(a);
        }
        for (Tribune trib :
                tribune) {
            System.out.println(trib.finnInntekt()+" "+trib+" ");
        }
        Arrays.sort(tribune);
        System.out.println();

        for (Tribune trib :
                tribune) {
            System.out.println(trib.finnInntekt()+" "+trib+" ");
        }

        try {
            FileOutputStream fo = new FileOutputStream("test");
            ObjectOutputStream oo= new ObjectOutputStream(fo);
            oo.writeObject(tribune);
        }catch (Exception e) {
            System.out.println("fuk");
        }

    }
}
