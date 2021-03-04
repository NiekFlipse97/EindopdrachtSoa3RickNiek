package export.filetypes;

import export.Report;

public class ToPDF implements IExportToFile {
    @Override
    public void export(Report report) {
        System.out.println("----------{PDF}----------");
        System.out.println(report.toString());
        System.out.println("----------{PDF}----------");
    }
}
