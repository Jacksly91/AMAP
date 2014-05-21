package activite;

import java.util.concurrent.ExecutionException;

import http.LitFichier;

import activite.R;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

//on veut lire un fichier txt hébergé sur un serveur http
//   puis en afficher rudimentairement le contenu

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		LitFichier litFichier = new LitFichier();
		litFichier.execute("http://192.168.0.10/noms.txt");
		try {
			if (litFichier.get())
				Log.i("lithttp", litFichier.donneNoms());
			else
				Log.i("lithttp", "Problème lecture fichier");
		} catch (InterruptedException e) {
			Log.i("lithttp", "Interruption lecture fichier");
		} catch (ExecutionException e) {
			Log.i("lithttp", "Problème exécution");
		}
	}
}
