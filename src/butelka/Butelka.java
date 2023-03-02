/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package butelka;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Butelka {
    
    private double ileLitrow;
    
    Butelka()
    {
        
    }
    
    Butelka(double ileLitrow)
    {
        this.ileLitrow = ileLitrow;
    }
    
    double getIleLitrow()
    {
        return ileLitrow;
    }
    
    void wlej(double ilosc)
    {
        this.ileLitrow += ilosc;
    }
    
    void wylej(double ilosc) throws Exception
    {
        if(ilosc < ileLitrow)
            this.ileLitrow -= ilosc;
        else
            throw new Exception("Za mało wody");
    }
    
    void przelej(double ilosc, Butelka gdziePrzelac) throws Exception
    {
        this.wylej(ilosc);
        gdziePrzelac.wlej(ilosc);
    }
    

    public static void main(String[] args) {
        Butelka[] butelka = new Butelka[5];
        
        for(int i = 0; i < 5; i++)
            butelka[i] = new Butelka(4);
        
        butelka[0].wlej(3);
        
        try {
            butelka[0].przelej(5,butelka[2]);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        for(int i = 0; i < 5; i++)
            System.out.println(butelka[i].getIleLitrow());
        
        
        try
        {
            System.out.println(5/0);
        }
        catch(Exception e)
        {
            System.out.println("Powstał wyjątek: " + e.getMessage());
        }
        finally
        {
            System.out.println("Finally to coś co zostanie wywołane mimo wszystko");
        }
        
        
        int a = 10;
        try{
            if(a == 10)
                throw new naszWyjatek("a jest rowne 10, tak nie wolno");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}

class naszWyjatek extends Exception
{

    public naszWyjatek(String string) 
    {
        super(string);
    }
    
}