package controleur;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Test
 */
@WebServlet("/lecture_fichier")
public class Test extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "C:\\Users\\FIS-TS\\mesProjetsJEE\\Les_fichiers\\Mes_images\\";
    public Test() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/bonjour.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// On r�cup�re le champ description comme d'habitude
        String description = request.getParameter("description");
        request.setAttribute("description", description );

        // On r�cup�re le champ du fichier
        Part part = request.getPart("fichier");
            
        // On v�rifie qu'on a bien re�u un fichier
        String nomFichier = getNomFichier(part);

        // Si on a bien un fichier
        if (nomFichier != null && !nomFichier.isEmpty()) 
        {
            String nomChamp = part.getName();
            // Corrige un bug du fonctionnement d'Internet Explorer
             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
                    .substring(nomFichier.lastIndexOf('\\') + 1);

            // On �crit d�finitivement le fichier sur le disque
            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

            request.setAttribute(nomChamp, nomFichier);
        }
		
	}
	public String getNomFichier(Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) 
        {
            if ( contentDisposition.trim().startsWith( "filename" ) )
            {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }
	void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException 
	{
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
	            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
	            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);
	
	            byte[] tampon = new byte[TAILLE_TAMPON];
	            int longueur;
	            while ((longueur = entree.read(tampon)) > 0) 
	            {
	                sortie.write(tampon, 0, longueur);
	            }
            }
        finally 
             {
               try
               {
                   sortie.close();
               } 
               catch (IOException ignore) 
               {
               }
               try
               {
                entree.close();
               }
               catch (IOException ignore)
               {
               }
             }
    }

}
