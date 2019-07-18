/*
 * Este software en su totalidad tiene licencia GPL v2.0.
 */

/*
 * Esta clase sirve para calcular la fase de la Luna
 * para culquier fecha tiene por base el dia 09/01/2012
 * anno bisiesto en el cual comensaba la Luna Llena,
 * la idea es convertir todo a diferencia de dias teniendo
 * en cuenta los bisiestos, luego hallar el resto de la
 * divicion entre 29.53 esto se hace para llevarlo al mes lunar
 * base y por ultimo se determina la fase de la luna y dia
 * de fase.
 */

package jclunar;

/**
 *
 * @author Francisco Perdigon Romero
 */
public class CLunar {
    public static String CalcLuna(int diabuscar, int mesbuscar, int annobuscar){
        String Luna="";

        String Luna1="Luna Llena";
        String Luna2="Cuarto Menguante";
        String Luna3="Luna Nueva";
        String Luna4="Cuarto Creciente";

        int [] dm = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        boolean pass = true;
        
        // dia base 09/01/2012 inicio Luna Llena
        int ddiff; //dias de difeencia con respecto al dia base



        if(annobuscar >= 2012){
            int TMP = 0;
            for (int i =0; i<mesbuscar; i++){
                TMP = TMP + dm[i];
            }

            ddiff=(annobuscar - 2012)*365 + (int)((annobuscar-2012)/4)+1 +
            TMP + diabuscar - 9 ;
            double Lx = ddiff % 29.53;
            int Dx = Math.round((float)(Lx % 7.38))  ;
            if (Dx == 0) Dx=1; if (Dx == 8) Dx=7;
            

            if (Lx>=0 && Lx <= 7.38) Luna = Luna1;
            if (Lx>7.38 && Lx <= 14.76) Luna = Luna2;
            if (Lx>14.76 && Lx <= 22.14) Luna = Luna3;
            if (Lx>22.14 && Lx <= 29.53) Luna = Luna4;

            Luna = Luna +" dia " + Dx;
        }

        if(diabuscar < 1 || diabuscar > 31) Luna="Dia fuera de rango";
        if(diabuscar > 30 && (mesbuscar == 2 || mesbuscar == 4 || mesbuscar == 6 || mesbuscar ==9 || mesbuscar ==11)) Luna="Dia fuera de rango";
        if(mesbuscar < 1 || mesbuscar >12) Luna="Mes fuera de rango";
        if((diabuscar < 1 || diabuscar > 31)&&(mesbuscar < 1 || mesbuscar >12)) Luna="Dia y Mes fuera de rango";

        return Luna;
    }

}
