package com.tedwon.cep.esper;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.tedwon.cep.esper.event.OrderEvent;

/**
 * Espert Quick Start Class.
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class EsperQuickStartMainClass {

    public void run() {



        // Configuration
        Configuration config = new Configuration();
        config.addEventTypeAutoName("com.tedwon.cep.esper.event");
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);



        // Creating a Statement
        String expression = "select Math.max(2, 3) as mymax, avg(price) from OrderEvent.win:time(30 sec)";
        EPStatement statement = epService.getEPAdministrator().createEPL(expression);



        // Adding a Listener
        MyListener listener = new MyListener();
        statement.addListener(listener);



        // Sending events
        OrderEvent event = new OrderEvent("shirt", 74.50);
        epService.getEPRuntime().sendEvent(event);
    }




    /**
     * Here are Biz codes.
     */
    public class MyListener implements UpdateListener {

        public void update(EventBean[] newEvents, EventBean[] oldEvents) {

            // Here are Biz codes
            EventBean event = newEvents[0];
            System.out.println("avg=" + event.get("avg(price)"));
            System.out.println("mymax=" + event.get("mymax"));
        }
    }

    public static void main(String[] args) {

        EsperQuickStartMainClass test = new EsperQuickStartMainClass();
        test.run();
    }
}
