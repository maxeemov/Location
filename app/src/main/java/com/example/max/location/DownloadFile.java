package com.example.max.location;


import android.os.AsyncTask;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* Here using AsyncTask fore getting the file by HTTP and writing him to file to path 'storage/emulated/0/Download'
 */

class DownloadFile extends AsyncTask<String, Integer, String> {

    @Override
    protected String doInBackground(String... sUrl) {

        InputStream input = null;
        OutputStream output = null;
        HttpURLConnection connection = null;

        try {
            //set connection
            URL url = new URL(sUrl[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return "Server returned HTTP " + connection.getResponseCode()
                        + " " + connection.getResponseMessage();
            }


            // download the file
            input = connection.getInputStream();
            output = new FileOutputStream("/storage/emulated/0/Download/route.txt");

            byte data[] = new byte[4096];
            int count;
            while ((count = input.read(data)) != -1) {

                output.write(data, 0, count);

            }
        } catch (Exception e) {
            return e.toString();
        } finally { //closing the stream
            try {
                if (output != null)
                    output.close();
                System.out.println("OUTPUT_IS_CLOSE");
                if (input != null)
                    input.close();
                System.out.println("INPUT_IS_CLOSE");
            } catch (IOException ignored) {
            }

            if (connection != null)
                connection.disconnect();
            System.out.println("CONNECT_IS_DISCONNECT");
        }
        return null;
    }
}
