package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import metier.Personne;

import android.os.AsyncTask;

public class LitFichier extends AsyncTask<String, Void, Boolean>{
	
	private List<Personne> lesPersonnes = new ArrayList<Personne>();
	
	@Override
	protected Boolean doInBackground(String... urls) {
		URL url;
		try {
			url = new URL(urls[0]);
			BufferedReader bufferedReader;
			bufferedReader = new BufferedReader(
					new InputStreamReader(url.openConnection().getInputStream()));
			String ligne;
			while ((ligne = bufferedReader.readLine())!= null)
				lesPersonnes.add(new Personne(ligne));
			bufferedReader.close();
	        return true;
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}
	
	public String donneNoms(){
		String liste = "";
		for (Personne personne : lesPersonnes)
			liste += personne.getNom()+"\n";
		return liste;
	}
}
