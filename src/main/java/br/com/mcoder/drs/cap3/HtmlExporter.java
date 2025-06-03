package br.com.mcoder.drs.cap3;

public class HtmlExporter implements Exporter{

	@Override
	public String export(final SummaryStatistics statistics) {
		String result = "<!doctype html>";
		result += "html lang='en'>";
		result += "<body>";
		result += "<ul>";
		result += "<li><strong>The sum is</strong>: " + statistics.getSum() + "</li>";
		result += "<li><strong>The average is</strong>: " + statistics.getAverage() + "</li>";
		result += "<li><strong>The max is</strong>: " + statistics.getMax() + "</li>";
		result += "<li><strong>The min is</strong>: " + statistics.getMin() + "</li>";
		result += "</ul>";
		result += "</body>";
		result += "</html>";
				
		return result;
	}

}
