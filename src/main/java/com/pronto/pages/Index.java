package com.pronto.pages;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.HttpError;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.slf4j.Logger;

import com.pronto.services.EmailService;

/**
 * Start page of application pronto.
 */
public class Index {
	@Inject
	private Logger logger;

	@Inject
	private AjaxResponseRenderer ajaxResponseRenderer;
	
	@Inject
	private ComponentResources componentResources;
	
	@Inject
	private EmailService emailService;

	@Property
	@Inject
	@Symbol(SymbolConstants.TAPESTRY_VERSION)
	private String tapestryVersion;

	@Inject
	private Block block;

	// Handle call with an unwanted context
	Object onActivate(EventContext eventContext) {
		System.out.println(componentResources.createEventLink("call").toAbsoluteURI());
		return eventContext.getCount() > 0 ? new HttpError(404, "Resource not found") : null;
	}

	@Log
	void onComplete() {
//		try {
//			// http://developers.itextpdf.com/examples/xml-worker/basic-html-examples
//			// http://xmlgraphics.apache.org/fop/
//			// http://pdfcrowd.com/web-html-to-pdf-java/
//			// http://demo.itextsupport.com/xmlworker/
//			FileOutputStream out = new FileOutputStream("index.pdf");
//			Document doc = new Document(PageSize.A4);
//			PdfWriter.getInstance(doc, out);
//			doc.open();
//			StringBuilder sb = new StringBuilder();
//			sb.append("<div>\n<p align=\"center\">");
//			sb.append("<font size=\"5\">");
//			sb.append("<b>&nbsp;<font color=\"#32cd32\">Параграф</font></b>");
//			sb.append("</font>");
//			sb.append("<font color=\"#32cd32\">&nbsp;</font>");
//			sb.append("</p>\n</div>");
//			ElementList list = XMLWorkerHelper.parseToElementList(sb.toString(), null);
//			for (Element element : list) {
//				doc.add(element);
//			}
//			doc.close();
//			System.err.println("complete");
//			logger.info("Complete call on Index page");
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("url", componentResources.createEventLink("call").toAbsoluteURI());
		data.put("user", "Yondonsuren");
		String html = emailService.getTemplate("test.ftl", data);
		System.err.println(emailService.sendEmail("tuguldur.j@itzone.mn,n.yondoo@gmail.com,n_yondoo@yahoo.com", "test", html));
	}

	@Log
	void onAjax() {
		logger.info("Ajax call on Index page");

		ajaxResponseRenderer.addRender("middlezone", block);
	}
	
	void onCall() {
		System.err.println("on image load");
	}

	public Date getCurrentTime() {
		return new Date();
	}
}
