package export;

import export.filetypes.IExportToFile;
import export.filetypes.ToPDF;
import export.filetypes.ToPNG;

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
