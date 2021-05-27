package com.company;

public class primes {
    public static void main(String[] args) {
        int i;
//этот цикл перебирает все числа от 2 до 100 включительно
        for(i=2; i <= 100; i++)
            // а тут проверяем является ли i простым числом, а затем выводим число в консоль
            if(isPrime(i))
                System.out.println(i);

    }
    // функция ниже будет возвращать истину, если число простое
    public static boolean isPrime(int n)
    { int j;
//Можно предположить, что входное значение n всегда будет больше 2
        for (j = 2;j < n;j++) {
            //тут я проверяю все числа от 2 до n делится ли n без остатка на i, в случае, если не делится, присваиваю false
            if ((n % j) == 0)
                return false;
        }

        return true;
    }
}
