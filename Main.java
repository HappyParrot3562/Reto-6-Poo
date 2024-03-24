import java.io.*;

public class Main
{
    public static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    //Se declara función para cuando el usuario elija "A" estas las use para tener un código más ordenado
    public static String choosea(String name) throws IOException
    {
        double peso;
        double estaturacm;
        double estatura;
        System.out.print("\nDame tu peso (en Kg): ");
        while (true)
        {
            //Try catch sirve para que cuando el usuario intente poner un valor no numérico el programa no lo deje
            try
            {
                peso = Double.parseDouble(scanner.readLine());
                break;
            }catch (NumberFormatException e)
            {
                System.out.print("Ingrese un valor numérico valido: ");
            }
        }
        System.out.print("\nDame tu estatura (en cm): ");
        while (true)
        {
            try
            {
                estaturacm = Double.parseDouble(scanner.readLine());
                break;
            }catch (NumberFormatException e)
            {
                System.out.print("Ingrese un valor numérico valido: ");
            }
        }
        //Convertimos la estatura a M para no tener problemas
        estatura = estaturacm/100;
        double IMC = peso/(estatura*estatura);
        //Usamos esta pequeña formula para redondear y que el número no sea muy largo
        double redondeado = Math.round(IMC *100.0)/100.0;

        //Se imprimen los datos del paciente
        System.out.println("\nPaciente: "+name+"\nPeso: "+peso+" kg\nEstatura: "+estaturacm+" cm");

        System.out.println("\nTu indice de masa corporal (IMC) es: "+redondeado);
        //Return es para volver un valor tipo string
        if (IMC<18.9)
        {
            return "Tienes un peso bajo";
        }
        else if (IMC>=18.9 && IMC<=24.99)
        {
            return "Tu peso es normal";
        }
        else if (IMC>=25.00 && IMC<=29.99)
        {
            return "Tienes sobrepeso";
        }
        else if (IMC>=30.00 && IMC<=34.99)
        {
            return "Tienes obesidad leve";
        }
        else if (IMC>=35.00 && IMC<=39.99)
        {
            return "Tienes obesidad media";
        }
        else
        {
            return "Tienes obesidad mórbida";
        }
    }
    //en caso de que el usuario elija la opción b
    public static String chooseb(String name) throws IOException
    {
        double peso;
        double estatura;
        String sexo;
        double calculos=0;
        boolean valido=true;
        double resultados;

        System.out.print("\nDame tu peso (en Kg): ");
        while(true)
        {
            try
            {
                peso = Double.parseDouble(scanner.readLine());
                break;
            }catch (NumberFormatException e)
            {
                System.out.print("Ingrese un valor numérico valido: ");
            }
        }
        System.out.print("\nDame tu estatura (en cm): ");
        while(true)
        {
            try
            {
                estatura = Double.parseDouble(scanner.readLine());
                break;
            }catch (NumberFormatException e)
            {
                System.out.print("Ingrese un valor numérico valido: ");
            }
        }
        System.out.print("\nDame tu sexo (no género): ");
        do
        {
            /*lowercase lo utilize, ya que en ocasiones el usuario escribe la palabra mezclando mayúsculas y minúsculas
            asi facilitamos al usuario que no tiene que escribir forzosamente algo muy espécifico*/
            sexo= scanner.readLine().toLowerCase();
            switch(sexo)
            {
                case "hombre", "masculino":
                    calculos = (1.10*peso)-128*(Math.pow(peso,2)/Math.pow(estatura,2));
                    valido=false;
                    //Por fines estéticos cambiamos el valor para que se vea bonito je, je, je
                    sexo = "Masculino";
                    break;
                case "mujer", "femenino":
                    calculos = (1.07*peso)-148*(Math.pow(peso,2)/Math.pow(estatura,2));
                    valido=false;
                    sexo = "Femenino";
                    break;
                default:
                    System.out.print("Ingresa un sexo válido: ");
            }
        }while(valido);

        resultados = Math.round(calculos*100.0)/100.0;
        System.out.println("\nPaciente: "+name+"\nPeso: "+peso+" Kg"+"\nEstatura: "+estatura+" cm\nSexo: "+sexo);
        return "\nTu masa corporal magra es: "+resultados+" Kg";
    }
    public static String choosec(String name) throws IOException
    {
        double calculos=0;
        double resultados;
        double peso;
        double estatura;
        int edad;
        String sexo;
        boolean valido=true;

        System.out.print("\nDame tu peso (en kg): ");
        while (true)
        {
            try
            {
                peso = Double.parseDouble(scanner.readLine());
                break;
            }catch (NumberFormatException e)
            {
                System.out.print("Ingrese un valor numérico valido: ");
            }
        }

        System.out.print("\nDame tu estatura (en cm): ");
        while (true)
        {
            try
            {
              estatura = Double.parseDouble(scanner.readLine());
              break;
            }catch(NumberFormatException e)
            {
                System.out.print("Ingrese un valor numérico valido: ");
            }
        }

        System.out.print("\nDame tu edad: ");
        while(true)
        {
            try
            {
                edad = Integer.parseInt(scanner.readLine());
                break;
            }catch(NumberFormatException e)
            {
                System.out.print("Ingrese un valor numérico valido: ");
            }
        }

        System.out.print("\nDame tu sexo (no género): ");
        //Do-while lo usamos para que primero ejecute la instrucción y luego se quede en búcle
        do
        {
            sexo = scanner.readLine().toLowerCase();
            switch (sexo)
            {
                case "hombre", "masculino":
                    calculos=66.5+(13.75*peso)+(5.003*estatura)-(6.775*edad);
                    sexo = "Masculino";
                    valido = false;
                    break;
                case "mujer", "femenino":
                    calculos=655.1+(9.563*peso)+(1.85*estatura)-(4.676*edad);
                    sexo = "Femenino";
                    valido = false;
                    break;
                default:
                    System.out.print("Ingresa un sexo válido: ");
            }
        }while(valido);
        /*En este caso usamos válido como true en caso de que el usuario escriba algo inválido le marcamos error
         y válido sigue siendo verdadero ya cuando escribe algo que es válido se sale del búcle*/

        resultados = Math.round(calculos*100.0)/100.0;
        System.out.println("\nPaciente: "+name+"\nPeso: "+peso+" Kg"+"\nEstatura: "+estatura+" cm\nEdad: "+edad+
                " años\nSexo: "+sexo);
        return "\nTu metabolismo basal es: "+resultados+" kcal";
    }
    //Programa principal
    public static void main(String[] args) throws IOException
    {
        String resultado;
        String choose;
        String name;
        boolean valido = true;

        System.out.print("Dame tu nombre: ");
        name = scanner.readLine();
        System.out.println("Bienvenido/a "+name+", ¿que deseas hacer hoy?\n\nA. Cálculo de masa corporal " +
                "(índice de masa corporal)\nB. Cálculo de masa corporal magra\nC. Cálculo de metabolismo basal " +
                "(gasto energético basal)");

        do
        {
            choose = scanner.readLine().toUpperCase();

            switch (choose)
            {
                case"A":
                    resultado = choosea(name);
                    System.out.println(resultado);
                    valido = false;
                    break;
                case"B":
                    resultado = chooseb(name);
                    System.out.println(resultado);
                    valido = false;
                    break;
                case"C":
                    resultado = choosec(name);
                    System.out.println(resultado);
                    valido = false;
                    break;
                default:
                    System.out.print("Ingresa un valor válido: ");
            }
        }while(valido);
    }
}
//Fin del programa :)
