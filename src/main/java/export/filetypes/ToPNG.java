package export.filetypes;

import export.Report;

public class ToPNG implements IExportToFile {
    @Override
    public void export(Report report) {
        System.out.println("----------{PNG}----------");
        System.out.println(report.toString());
        System.out.println("----------{PNG}----------");
    }
}
