package com.company;

import java.util.Arrays;
import java.util.Locale;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Answer 1 = " + sevenBoom(new int[] {1, 2, 3, 4, 5, 6, 97}));
        System.out.println("Answer 2 = " + cons (new int[] {5, 6, 7, 8, 9, 13}));
        System.out.println("Answer 3 = " + unmix("hTsii  s aimex dpus rtni.g"));
        System.out.println("Answer 4 = " + noYelling("Oh my goodness!!!"));
        System.out.println("Answer 5 = " + xPronounce("OMG x box unboxing video x D") );
        System.out.println("Answer 6 = " + largestGap(new int[] {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}));
        System.out.println("Answer 7 = " + raznitsa(832));
        System.out.println("Answer 8 = " + commonLastVowel("Watch the characters dance!"));
        System.out.println("Answer 9 = " + memeSum(26, 39));
        System.out.println("Answer 10 = " + unrepeated("hello"));
    }
// Метод для задачи 1 из task4
/* 1. Создайте функцию, которая принимает массив чисел и возвращает "Бум!", если в
       массиве появляется цифра 7. В противном случае верните "в массиве нет 7". */

    public static String  sevenBoom (int[] seven)
    { int a = 0;
        String s;
        for (int i: seven){
            s = Integer.toString(i); // число в строку
            if (s.contains("7"))
            { a +=1;
            }}
        if (a>0) return "BOOM!";
        else return "there is no 7 in the array";
    }

// Метод для задачи 2 из task4
/* 2. Создайте функцию, которая определяет, могут ли элементы в массиве быть
       переупорядочены, чтобы сформировать последовательный список чисел, где
       каждое число появляется ровно один раз. */

    public static boolean cons(int[] sort){
        boolean k = false;
        Arrays.sort(sort); // класс arrays, метод сорт
        for(int i =1; i < sort.length;i++){
            k = sort[i] - sort[i - 1] == 1;
        }
        return k;
    }

// Метод для задачи 3 из task4
/* 3. lPaeesh le pemu mnxit ehess rtnisg! О, извините, это должно было быть: Пожалуйста,
       помогите мне распутать эти строки!
       Каким-то образом все строки перепутались, каждая пара символов поменялась местами.
       Помоги отменить это, чтобы снова понять строки. */

    public static String unmix(String mix){
        char obm;
        char[] a = mix.toCharArray();
        for( int i = 0; i<a.length; i+=2){
            obm = a[i];
            a[i] = a[i+1];
            a[i+1]=obm;
        }
        return String.valueOf(a); //возвращает строковое представление int аргумента
    }

// Метод для задачи 4 из task4
/* 4. Создать функцию, которая преобразует предложения, заканчивающиеся
       несколькими вопросительными знаками ? или восклицательными знаками ! в
       предложение, заканчивающееся только одним, без изменения пунктуации в
       середине предложений.

       Примечание:
       - Меняйте только окончательную пунктуацию - оставляйте восклицательные или
       вопросительные знаки в середине предложения неизменными (см. Третий пример).
       - Не беспокойтесь о смешанной пунктуации (нет случаев, которые заканчиваются чем-то
       вроде ?!??!).
       - Сохраняйте предложения, в которых нет вопросительных/восклицательных знаков,
       одинаковыми. */

    public static String noYelling(String yell){
        while (yell.endsWith("!!") || yell.endsWith("??")) {
            yell = yell.substring(0, yell.length() - 1); // удаление последнего элемента строки
        }
        return yell;
    }

// Метод для задачи 5 из task4
/* 5. Создайте функцию, которая заменяет все x в строке следующими способами:

       Замените все x на "cks", ЕСЛИ ТОЛЬКО:
       Слово начинается с "x", поэтому замените его на "z".
       Слово-это просто буква "х", поэтому замените ее на " cks ".

       Примечание:
       - Все X являются строчными. */

    public static String xPronounce(String x) {
        x = x.replaceAll("\sx\s", " ecks ");
        x = x.replaceAll("\sx", " z");
        x = x.replaceAll("x", "cks");
        return x;
    }
// Метод для задачи 6 из task4
/* 6. Учитывая массив целых чисел, верните наибольший разрыв между
       отсортированными элементами массива.
       Например, рассмотрим массив:
       [9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5]
       ... в котором после сортировки массив становится:
       [0, 0, 4, 5, 5, 6, 9, 20, 25, 26, 26]
       ... так что теперь мы видим, что самый большой разрыв в массиве находится между 9 и 20,
       что равно 11. */

    public static int largestGap (int[] gap){
        Arrays.sort(gap);
        int r = 0;
        for(int i = 0; i< gap.length - 1 ;i++)
            if ((gap[i+1] - gap[i])>r)
                r = gap[i+1] - gap[i];
        return r;
    }
// Метод для задачи 7 из task4
    /* 7. Это вызов обратного кодирования. Обычно вам дают явные указания о том, как
       создать функцию. Здесь вы должны сгенерировать свою собственную функцию,
       чтобы удовлетворить соотношение между входами и выходами.
       Ваша задача состоит в том, чтобы создать функцию, которая при подаче входных данных
       ниже производит показанные примеры выходных данных. */

    public static int raznitsa(int t) {
        String k = String.valueOf(t); // int -> string
        StringBuilder result = new StringBuilder();
        char[] b = k.toCharArray();
        for (int i = b.length-1; i >= 0; i--) { //запись числа в обратном порядке
            result.append(b[i]); // перепись
        }
        int res = Integer.parseInt(result.toString().trim()); //string ->int, trim удаляет пробелы
        return t - res;
    }

// Метод для задачи 8 из task4
/* 8. Создайте функцию, которая принимает предложение в качестве входных данных и
       возвращает наиболее распространенную последнюю гласную в предложении в
       виде одной символьной строки. */

    public static String commonLastVowel (String vowel) {
        vowel = vowel.toLowerCase();
        char[] arr = vowel.toCharArray();
        int len = arr.length;
        char buf = '1';
        for(int i = 0; i< len; i++){
            if (isVowel(arr[i]))
                buf = arr[i];
        }
        return String.valueOf(buf); //valueOf возвращает строкове представление переданного аргумента
    }

    public static boolean isVowel(char c)
    {return "aeiouy".indexOf(c)!=-1;}

// Метод для задачи 9 из task4
/* 9. Для этой задачи забудьте, как сложить два числа вместе. Лучшее объяснение того,
       что нужно сделать для этой функции, - это этот мем: */

    public static int memeSum(int a1, int a2){
        int len = Math.max(String.valueOf(a1).length(),String.valueOf(a2).length());
        String w  = "";
        for (int i = len - 1; i>= 0 ; i--){
            w = (a1 % 10 + a2 % 10) + w;
            a1 /=10;
            a2 /=10;
        }
        return Integer.parseInt(w);
    }

// Метод для задачи 10 из task4
/* 10. Создайте функцию, которая удалит все повторяющиеся символы в слове,
       переданном этой функции. Не просто последовательные символы, а символы,
       повторяющиеся в любом месте строки. */

    public static String unrepeated (String str){
        int l = str.length();
        StringBuilder rez = new StringBuilder();
        for(int i=0; i< l; i++){
            if (!rez.toString().contains(String.valueOf(str.charAt(i)))) //добавление неповторяющейся буквы
                rez.append(str.charAt(i));
        }
        return rez.toString();
    }
}