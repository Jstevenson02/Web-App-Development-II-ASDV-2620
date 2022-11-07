/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flow;

import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

/**
 *
 * @author jacob
 */
public class Orientation implements Serializable {

    @Produces
    @FlowDefinition
    public Flow defineFlowOrientationOrAnythingYouWant(@FlowBuilderParameter FlowBuilder flowBuilder) {

        String flowId = "orientation";
        flowBuilder.id("", flowId);

        flowBuilder.viewNode(flowId, "/" + flowId + "/" + flowId + ".xhtml").markAsStartNode();

        // flowBuilder.viewNode("sucsess-id", "/" + flowId + "/success.xhtml");
        flowBuilder.returnNode("taskFlowReturnThanks").fromOutcome("/registration/thanks");

        flowBuilder.inboundParameter("firstNameParam", "#{flowScope.firstName}");
        flowBuilder.inboundParameter("lastNameParam", "#{flowScope.lastName}");
        flowBuilder.inboundParameter("studentRegistrationCode", "#{orientationBean.regCode}");

        return flowBuilder.getFlow();
    }
}
