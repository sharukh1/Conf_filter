/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internationalization;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Inspiron
 */
public class Internationalization {

    public void date(Locale l, Locale l2) {
        date2(l2);
        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, l);
        System.out.println(">" + df);
        Date d = new Date();
        System.out.println("date fr: " + d);
        String date = df.format(d);
        System.out.println(">" + date);
        Currency c = Currency.getInstance(l);
        System.out.println("currency fr" + c);
        NumberFormat nf = NumberFormat.getNumberInstance(l);
      
        System.out.println("number "+ nf.format(150000000));

    }

    public void date2(Locale l) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, l);
        System.out.println(">" + df);
        Date d = new Date();
        System.out.println("date us: " + d);
        String date = df.format(d);
        System.out.println(">" + date);
        Currency c = Currency.getInstance(l);
        System.out.println("currency us" + c);
        NumberFormat nf=NumberFormat.getNumberInstance(l);
        System.out.println(nf.format(200000000));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Locale locale1 = Locale.getDefault();
        Locale locale2 = new Locale("fr", "fr");
        
       
        System.out.println("dflt>" + Locale.getDefault());
        System.out.println("set: " + locale1.getDisplayLanguage(locale2));
        ResourceBundle bundle = ResourceBundle.getBundle("internationalization.MyMessage");
        System.out.println("Message in " + Locale.US + ":" + bundle.getString("greeting"));

      
               Locale.setDefault(new Locale("in", "ID"));
       
        bundle = ResourceBundle.getBundle("internationalization.MyMessage");
        System.out.println("Message in " + Locale.getDefault() + ":" + bundle.getString("greeting"));

        new internationalization.Internationalization().date(locale2, locale1);

    }

}
