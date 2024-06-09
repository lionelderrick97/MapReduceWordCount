package hadoop.mapreduce.tp1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ConvertPdftoTxt {

    public static void main(String[] args) {
        // Chemin du fichier PDF d'entrée
        String inputFilePath = "../ressources/Rapportdinformation2207.pdf";
        // Chemin du dossier de sortie pour le fichier texte
        String outputFolderPath = "../ressources/input";

        try {
            // Chargement du document PDF
            PDDocument document = PDDocument.load(new File(inputFilePath));

            // Initialisation de PDFTextStripper
            PDFTextStripper pdfStripper = new PDFTextStripper();

            // Obtenir le texte du document PDF
            String text = pdfStripper.getText(document);

            // Fermer le document PDF
            document.close();

            // Créer le dossier de sortie s'il n'existe pas
            File outputFolder = new File(outputFolderPath);
            if (!outputFolder.exists()) {
                outputFolder.mkdirs();
            }

            // Chemin complet du fichier texte de sortie
            String outputFilePath = outputFolderPath + "output.txt";

            // Enregistrer le texte extrait dans un fichier texte de sortie
            try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
                fos.write(text.getBytes());
            }

            System.out.println("Conversion du fichier PDF en texte terminée. Le fichier texte a été enregistré à : "
                    + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
