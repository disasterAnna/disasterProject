package javaSimple;

public class Program {

    public static void main(String[] args) {
        //Это точка входа в программу - она начинает с него работать. Указываем, что этот метод ГЛАВНЫЙ. Начало начал. Идём с него. Метод-главнюк короче.
        //public - модификатор доступа
        //static - обозначает, что метод инициализируется в процессе компиляции
        //void - метод НИЧЕГО не возвращает
        //mail - имя метода; именя Классов - с большой, имена методов, переМенных - с мелкой

        int num1 = 3;
        int num2 = 8;

        System.out.println("Мама, я программист!");
        System.out.println(HelpedMethods.name("Садись!", 2));
        //System.out.println(HelpedMethods.parametr);
        System.out.println("Сумма " + num1 + " и " + num2 + ": " + HelpedMethods.sum(num1, num2));

        //String qweForCompare = new String("qwe"); //переменная qwe - это ссылка на объект
        String qweForCompare = "qwe";
        boolean result = qweForCompare == HelpedMethods.parametr;
        System.out.println(result);

        boolean result2 = qweForCompare.equalsIgnoreCase(HelpedMethods.parametr);
        //внутри объекта qweForCompare вызывается метод equalsIgnoreCase, кот.сравнивает "эту строку" (значение qwe переменной qweForCompare) с параметрами функции (HelpedMethods.parametr)
        System.out.println(result2);


        //Ветвление через if
        num1 =5;
        boolean result3 = num1 == 5;

        if (result3){
            System.out.println("Мы сделали это!");
        }
        else if (num1==4){
            System.out.println("Мы почти сделали это");
        }
        else {
            System.out.println("Ничего не сделано =(");
        }

        //Ветвление через switch
        HelpedMethods hp = new HelpedMethods();
        String asd = hp.switchRadio("Dacha");
        System.out.println("Сегодня в эфире: " + asd);
        //System.out.println(hp.switchRadio("Dacha"));

        //Ветвление через switch 2
        System.out.println("Сегодня в эфире также: " + hp.switchRadioNewWave("Afro"));

        //Цикл через for
        int index = 100;
        for (int x=0; x<=index; x++){
            System.out.println(x);
        }

        //while
        int value =0;
        /* while (index<110){
            value = 1+index;
            index=value+index;
            System.out.printLn(value);
        }*/


        //Простой while - сперва проверить, потом сделать
        while (index<110){
            value++;
            System.out.println("Нужно БОООЛЬШЕ текста"); ///нет стопора, поэтому будет херачить бесконесно
            if (value==4){
                //break; //А теперь есть стопор - останавливает цикл
                return; //Или так - выход из метода (в данном случае - main)
            }

            //через do while - сперва сделать, потом проверить
            do {
                System.out.println("Привет");
                index=1000;
            } while (index <110);



            System.out.println("Мы закончили!");
        }

    }
}
