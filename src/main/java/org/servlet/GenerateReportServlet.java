package org.servlet;

import java.io.IOException;

public class GenerateReportServlet extends HttpServlet {
    private ReportService reportService;

    @Override
    public void init() throws ServletException {
        this.reportService = new ReportService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reportType = request.getParameter("report_type"); // e.g., "work_hours", "time_off", etc.

        try {
            String report = reportService.generateReport(reportType);
            response.getWriter().println(report);
        } catch (Exception e) {
            response.getWriter().println("Error generating report: " + e.getMessage());
        }
    }
}
