package java_S;

import java.util.Scanner;


public class Learn{

    public static void main(String[] args){
        
        Customer c1 = new Customer("Abu", 7777, 21);
        c1.print_customer();

        Scanner s = new Scanner(System.in);
        System.out.println("Please write a number: ");

        int user_input = Integer.parseInt(s.nextLine());
        System.out.println("U wrote: " + user_input);
        if(args.length < 2){
            System.out.println("NeNeNe");
            return;
        }

        if(!isDigit(args[0]) || !isDigit(args[1])){
            System.out.println("Problem !!! we need only digits :)");
        }
        else{
            Calculator c = new Calculator();
            System.out.println(args[0] + " / " + args[1] + " = " + c.div(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
        }

        System.out.println(spread_love());
    }

    static String spread_love(){
        return "love love love";
    }

    public static boolean isDigit(String s){
        for(int i = 0; i < s.length(); ++i){
            if(!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}


class Calculator{

    public double div(double x, double y){
        if(y == 0){
            throw new ArithmeticException("Error !!, Div by zero");
        }
        else{
            return x / y;
        }
    }
}



class Customer{

    private String name;
    private int id;
    private int age;

    public Customer(String name, int id, int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void print_customer(){
        System.out.println("Customer name: " + name);
        System.out.println("Customer id: " + id);
        System.out.println("Customer age: " + name);

    }

    public String get_name(){
        return name;
    }

    public int get_id(){
        return id;
    }

    public int get_age(){
        return age;
    }

    public void set_name(String new_name){
        this.name = new_name;
    }

    public void set_age(int new_age){
        this.age = new_age;
    }

    public void set_id(int new_id){
        this.id = new_id;
    }
}