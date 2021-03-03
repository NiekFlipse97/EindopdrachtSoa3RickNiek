package export;

import export.fileTypes.IExportToFile;
import export.fileTypes.ToPDF;
import export.fileTypes.ToPNG;

public class FileExportFactory {

    public IExportToFile getFileExporter(ExportTypes exportTypes) {
        if (exportTypes == null)
            return null;

        switch (exportTypes) {
            case PDF: return new ToPDF();
            case PNG: return new ToPNG();
            default: return null;
        }
    }

}
