package calejo.sorpresauvm;

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

/**
 * Created by alexi on 11/21/2016.
 */
public class PreguntasWebService {

    public int id;
    public String preguntaM;
    public String respuesta1;
    public String respuesta2;
    public String respuesta3;
    public String respuesta4;
    public String respuesta_correcta;
    public String categoria;
    static String pregunta = "";
    StringTokenizer str = new StringTokenizer(pregunta, "|");

    public PreguntasWebService() {
        /*
        JavaHttpUrlConnectionReader();
        int cont = 0;
        while (str.hasMoreTokens()) {
            switch(cont){
                case 0:
                    this.id=Integer.parseInt(str.nextToken());
                    break;
                case 1:
                    this.preguntaM=str.nextToken();
                    break;
                case 2:
                    this.respuesta1=str.nextToken();
                    break;
                case 3:
                    this.respuesta2=str.nextToken();
                    break;
                case 4:
                    this.respuesta3=str.nextToken();
                    break;
                case 5:
                    this.respuesta4=str.nextToken();
                    break;
                case 6:
                    this.respuesta_correcta=str.nextToken();
                    break;
                case 7:this.categoria=str.nextToken();
                    break;
            }
            cont++;
        }
*/
    }


    public void obtenerPregunta(){
        JavaHttpUrlConnectionReader();
        int cont = 0;
        while (str.hasMoreTokens()) {
            switch(cont){
                case 0:
                    this.id=Integer.parseInt(str.nextToken());
                    break;
                case 1:
                    this.preguntaM=str.nextToken();
                    break;
                case 2:
                    this.respuesta1=str.nextToken();
                    break;
                case 3:
                    this.respuesta2=str.nextToken();
                    break;
                case 4:
                    this.respuesta3=str.nextToken();
                    break;
                case 5:
                    this.respuesta4=str.nextToken();
                    break;
                case 6:
                    this.respuesta_correcta=str.nextToken();
                    break;
                case 7:this.categoria=str.nextToken();
                    break;
            }
            cont++;
        }

    }

    /*
    private static class StringTokenizerExample {
=======
    static String pregunta = "";

    public static class StringTokenizerExample {
>>>>>>> origin/master
        public static void main(String args[]) { // creating TestStringTokenizer
            // object.
            JavaHttpUrlConnectionReader();
            PreguntasWebService obj = new PreguntasWebService();
            // method call
            obj.displayTokens();

        }

    }

*/


    public static void JavaHttpUrlConnectionReader() {

        try {
            String myUrl = "http://ec2-54-86-71-49.compute-1.amazonaws.com/Pipes.php?sql=SELECT%20*%20FROM%20preguntas%20order%20by%20rand()%20limit%201;&server=alexis.c2g7lahthau8.us-east-1.rds.amazonaws.com&user=preparate&password=Pr3p4r4t3!&dataBase=preparate";
            // if your url can contain weird characters you will want to
            // encode it here, something like this:
            // myUrl = URLEncoder.encode(myUrl, "UTF-8");

            pregunta = doHttpUrlConnectionAction(myUrl);
            //System.out.println(pregunta);
        } catch (Exception e) {
        }
    }

    private static String doHttpUrlConnectionAction(String desiredUrl) throws Exception {
        URL url = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder;

        try {
            // create the HttpURLConnection
            url = new URL(desiredUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // just want to do an HTTP GET here
            connection.setRequestMethod("GET");

            // uncomment this if you want to write output to this url
            // connection.setDoOutput(true);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            // give it 15 seconds to respond
            connection.setReadTimeout(15 * 1000);
            connection.connect();

            // read the output from the server

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            // close the reader; this can throw an exception too, so
            // wrap it in another try/catch block.
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }


}
