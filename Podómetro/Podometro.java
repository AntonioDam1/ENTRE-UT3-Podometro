/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - Antonio Aguilera - 
 */
public class Podometro {
    private final char Hombre='H';
    private final char Mujer='M';
    private final double ZANCADA_HOMBRE=0.45;
    private final double ZANCADA_MUJER=0.41;
    
    private final int SABADO=6;
    private final int DOMINGO=7;
    
    private String marca;
    private double altura;
    private char sexo;
    private double longitudZancada;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinSemana;
    private int totalPasosLaborables;
    private int caminataNoche;
    private String diaMayorPasos;
    private int tiempo;
    
    
    /**
     * Inicializa el podómetro con la marca indicada por el parámetro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca){
        marca=queMarca;
        sexo='M';
        
    }
    
    /**
     * accesor para la marca
     *  
     */
    public String getMarca(){
        return marca;       
    }

    /**
     * Simula la configuración del podómetro.
     * Recibe como parámetros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna además el valor adecuado al atributo longitudZancada
     * 
     * 
     *  
     */
    public void configurar(double queAltura, char queSexo) {
        altura = queAltura;
        sexo = queSexo;
        
        if (sexo=='H'){
               longitudZancada= Math.ceil(altura * 0.45);
        }
        else{ 
            longitudZancada= Math.floor(altura * 0.41);
        }        

       
    }

     /**
     *  Recibe cuatro parámetros que supondremos correctos:
     *    pasos - el nº de pasos caminados
     *    dia - nº de día de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - Sábado, 7 - Domingo)
     *    horaInicio – hora de inicio de la caminata
     *    horaFin – hora de fin de la caminata
     *    
     *    A partir de estos parámetros el método debe realizar ciertos cálculos
     *    y  actualizará el podómetro adecuadamente  
     *   
     *   
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio,
    int horaFin) {
           int hora1;
           int hora2;
           hora1 = horaInicio;
           hora2 = horaFin;
           switch(dia){
            case 1:
            totalPasosLaborables += pasos;
            case 2:
            totalPasosLaborables += pasos;
            case 3:
            totalPasosLaborables += pasos;
            case 4:
            totalPasosLaborables += pasos;
            case 5:
            totalPasosLaborables += pasos; 
                 break;
            case 6:
            totalPasosLaborables += pasos;
            case 7:
            totalPasosLaborables += pasos;
                 break;
           }
           double hora;
           double minutos;
           hora = (((hora2-hora1)/100));
           minutos = (((hora2-hora1)/100)-hora)*100;
           if(minutos>=60){
               minutos= (minutos=60);
               hora = hora1;
            
           }
           int tiempoDiario;
           tiempoDiario= (hora2-hora1);
           tiempo = tiempo+tiempoDiario;
           if (tiempoDiario>2100){
               caminataNoche= caminataNoche;
           }

    }
    
     /**
     * Muestra en pantalla la configuración del podómetro
     * (altura, sexo y longitud de la zancada)
     * 
     * 
     *  
     */
    public void printConfiguracion(){
        System.out.println( "Configuracion del podometro");
        System.out.println( "***************************");
        System.out.println( "Altura =" + altura/100 + "metros");
        System.out.println( "sexo=" + sexo);
        System.out.println( "Longitud Zancada" + longitudZancada/100 + "metros");
    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * 
     *  
     */
    public void printEstadísticas() {
        System.out.println( " Estadisticas ");
        System.out.println( "***************************");
        System.out.println( " N°Pasos dados toda la semana ");
        System.out.println( " N°Pasos SABADO " + totalPasosSabado);
        System.out.println( " N°Pasos DOMINGO " + totalPasosDomingo);
        System.out.println( " Distancia recorrida toda la semana "+ totalDistanciaSemana);
        System.out.println( " Distancia recorrida toda la fin de semana "+ totalDistanciaFinSemana);
        System.out.println( "***************************");
        System.out.println( "N° caminatas realizadas a partir de las 21h" + caminataNoche);
        System.out.println( " Dias con mas pasos caminados" + diaMayorPasos);
        System.out.println( " Tiempo total caminado en la semana" + tiempo);

        

    }

    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos(){
        String Dias = "";
        if(totalPasosLaborables > totalPasosSabado){
             diaMayorPasos = "Dias con mas pasos caminados: Laborables";
   
        }
        else{
            diaMayorPasos = "Dias con mas pasos caminados: Sabado";
        
        }
    
        if(totalPasosLaborables > totalPasosDomingo){
            diaMayorPasos = "Dias con mas pasos caminados: Laborables";
            
        }
        else{
            diaMayorPasos = "Dias con mas pasos caminados: Domingo";
        
        }
        return Dias;
    } 
    
    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
     *  
     */    
    public void reset() {
        altura=0;
        sexo=Mujer;
        longitudZancada=0;
        totalPasosSabado=0;
        totalPasosDomingo=0;
        totalDistanciaSemana=0;
        totalDistanciaFinSemana=0;
        totalPasosLaborables=0;
        caminataNoche=0;
        tiempo=0;

        

    }

}
