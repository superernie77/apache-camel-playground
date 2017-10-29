package com.wds.example.camel.cameldemo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class NameProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().setHeader("text", exchange.getIn().getHeader("text") + " nach Prozessor"   );
	}

}
