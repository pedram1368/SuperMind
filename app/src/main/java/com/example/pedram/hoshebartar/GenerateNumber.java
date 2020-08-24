package com.example.pedram.hoshebartar;




import java.util.Random;

public class GenerateNumber {

    public int val_first, val_second,val_digit;
    public int sum=val_first+val_second;

    String first_number;
    String second_number;
    String digit;






    public GenerateNumber (String first_number ,String second_number){


       this.first_number=first_number;
        this.second_number=second_number;

    }
    public GenerateNumber (String digit){


        this.digit=digit;

    }







    Random rand =new Random();
    public int random_number_first (){

        if (first_number.equals("9")){
            int inti=rand.nextInt(10);
            val_first = (inti);
        }else if (first_number.equals("89")){
            int inti=rand.nextInt(90)+10;
            val_first = (inti);
        }else if (first_number.equals("899")){
            int inti=rand.nextInt(900)+100;
            val_first = (inti);
        }else if (first_number.equals("8999")){
            int inti=rand.nextInt(9000)+1000;
            val_first = (inti);
        }

        return val_first;
    }


    public int random_number_second (){

        if (second_number.equals("9")){
            int inti=rand.nextInt(10);
            val_second = (inti);
        }else if (second_number.equals("89")){
            int inti=rand.nextInt(90)+10;
            val_second = (inti);
        }else if (second_number.equals("899")){
            int inti=rand.nextInt(900)+100;
            val_second = (inti);
        }else if (second_number.equals("8999")){
            int inti=rand.nextInt(9000)+1000;
            val_second = (inti);
        }
        return val_second;
    }


    public int sum (){

        int sum =val_first+val_second;
        return sum;
    }


    public int random_number_reverse(){

        if (digit.equals("3")){
            int inti=rand.nextInt(900)+100;
            val_digit = (inti);
        }else if (digit.equals("4")){
            int inti=rand.nextInt(9000)+1000;
            val_digit = (inti);
        }else if (digit.equals("5")){
            int inti=rand.nextInt(90000)+10000;
            val_digit = (inti);
        }else if (digit.equals("6")){
            int inti=rand.nextInt(900000)+100000;
            val_digit = (inti);
        }else if (digit.equals("7")){
            int inti=rand.nextInt(9000000)+1000000;
            val_digit = (inti);
        }else if (digit.equals("8")){
            int inti=rand.nextInt(90000000)+10000000;
            val_digit = (inti);
        }else if (digit.equals("9")){
            int inti=rand.nextInt(900000000)+100000000;
            val_digit = (inti);
        }

        return val_digit;
    }


}
