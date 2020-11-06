package it.unibs.pajc.reflection;
import java.lang.reflect.*;
public class Main {

    public static Object function1() {
        return new String();
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //String objString = new String();
        Object obj = function1();

        Class<?> objClass = obj.getClass();

        /*
        for(Method m: objClass.getMethods()) {
            System.out.println("-----------------");
            System.out.println(m.getName());
            System.out.println(m.getReturnType());
            for(Parameter p: m.getParameters())
                System.out.printf("\t %s [%s]\n", p.getName(), p.getType());

        }
        */

        System.out.println(" --- COSTRUTTORI --- ");
        for(Constructor c: objClass.getConstructors()) {
            System.out.println(c.getName());
        }

        // 1. determino il costruttore -> c = objClass.getConstructor(/* String */)
        // 2. creo una nuova istanza dell'oggetto -> reflectionObject = c.newInstance
        // 3. visualizzare a video tutti i metodi dell'oggetto reflectionObject
        // 4. visualizzare a video tutti i metodi dell'oggetto reflectionObject che non richiedono parametri
        // 5. invocare uno dei metodi al punto 4 e visualizzare il risultato

        // 1.
        System.out.println("\n------------\n");
        Constructor<?> c = objClass.getConstructor(String.class);
        Object myObj = c.newInstance("Testo di prova");

        Method myMethod = objClass.getMethod("charAt", int.class);

        String s = "123";
        s.charAt(1);

        // 4.
        /*
        for(Method m: objClass.getMethods()) {
            if(m.getParameterCount() == 0) {
                System.out.println(m.getName());
                System.out.println(m.getReturnType());
            }
        }
         */

    }
}
