package javaSimple;

public class HelpedMethods {

    final static String parametr = "qwe";
    final static String parametr2 = "qwe";
    //final - указывает, что переменную НЕЛЬЗЯ изменить или переопределить
    //static - инициализируется (создаётся) в памяти виртуальной машины, т.е. занимает оперативную память в момент компиляции проги. На момент копмиляции она уже существует
    //String - возвращаемый тип

    //Опишем поля класа
    public int ind = 2;
    public int ind2 = 2;

    //Опишем первый метод
    public static String name(String word, Integer value) {
        String nameForReturn = word;
        return nameForReturn + value.toString();
    }
    //Мы передаём на вход стрингу - переменную word
    //Это слово сохраняем внутри метода в переменную nameForReturn (свежеобъявленную): присваиваем этой переменной значение, которое мы передали (word)
    //Выводим значение переменной nameForReturn
    //Тип String с большой буквы, так как это ссылочный тип (объект), int с маленькой, так как это примитивный тип
    //Примитивный тип всегда создаётся внутри памяти, каждый раз - новое значение.
    //Если создадим 2 переменные с типом int с одинаковыми значениями - это будет 2 РАЗНЫЕ ячейки памяти
    //Если создадим 2 переменные с типом String с одинаковыми значениями - будет ссылка на ОДНУ ячейку памяти (пока значения не отличаются)

    //Метод с модификатором доступа public (метод видно во ВСЁМ проекте)
    public String bobik(String command) {
        String heyBobik = "Hey Bobik ," + command;
        return heyBobik;
    }

    //Метод с модификатором доступа private (метод видно только внутри этого класса(HelpedMethods))
    private String prefix(String pref){
        return pref;
    }

    //Метод с модификатором доступа protected (метод видно только внутри этого класса(HelpedMethods) и внутри пакета (package))
    protected String sufix(String suf){
        return suf;
    }

    //Метод БЕЗ модификатора доступа ВАЩПЕ (видно только внутри пакета (package))
    String lost(){
        return "lost";
    }

    //Метод, считающий сумму
    static int sum(int a, int b){
        return a+b;
    }

    //Метод для switch
    public String switchRadio(String radioName){
        String radio;
        switch (radioName){
            case "Afro":
                radio="100.2";
                break;
            case "Auto":
                radio="106.1";
                break;
            default:
                radio="Ми не знать этот радиоволна!";
        }
        return radio;
    }

    //Модный-молодёжный switch
    public String switchRadioNewWave(String radioName){
        String radio;
        radio = switch (radioName){
            case "Afro" -> "100.2";
            case "Auto" -> "106.1";
            default -> "Ми не знать этот радиоволна!";
        };
        return radio;
    }

}
