package com.hostel.fooddeliverysystem;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.Context.MODE_PRIVATE;

public class Post {

    private final String USER_AGENT = "Mozilla/5.0";


    //SendPost method to post something to server.
    public String sendPost(Context context,String url,String urlParameters) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //add reuqest header

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();

    }


    public void WriteXmlToFile(Context context,String xml_to_cache,String filename) throws Exception//Function To Save the XML received from server
    {
        try
        {
            OutputStreamWriter out= new OutputStreamWriter(context.openFileOutput(filename, 0));
            out.write(xml_to_cache);
            out.close();
            //   Toast.makeText(context, "The contents are saved in the file.", Toast.LENGTH_LONG).show();
        }

        catch (Throwable t)
        {
            Toast.makeText(context, "Exception: "+t.toString(), Toast.LENGTH_LONG).show();
        }

    }
    public String ReadXmlFromFile(Context context,String filename)   //Function To Read the xml from the file
    {
        try
        {
            InputStream in = context.openFileInput(filename);
            if (in != null)
            {
                InputStreamReader tmp = new InputStreamReader(in);
                BufferedReader reader = new BufferedReader(tmp);
                String str;
                StringBuilder buf = new StringBuilder();
                while ((str = reader.readLine()) != null)
                {
                    buf.append(str+"\n");
                }
                in.close();
                return buf.toString();
            }
        }
        catch (java.io.FileNotFoundException e)
        {
            // that's OK, we probably haven't created it yet
        }
        catch (Throwable t)
        {
            Toast.makeText(context, "Exception: "+t.toString(), Toast.LENGTH_LONG).show();
        }
        return " "; // when no data is fetched
    }

    // TODO: Rename method, update argument and hook method into UI event

}



