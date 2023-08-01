package ren.dy;

import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ren.dy.entitiy.LoanInput;
import ren.dy.entitiy.MonthlyPayment;
import ren.dy.service.LoanCalculator;

import java.util.List;

@Singleton
@Path("/loan")
public class GreetingResource {
    @Inject
    LoanCalculator loanCalculator;

    @POST
    @Path("/calculate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<MonthlyPayment> calculateLoan(JsonObject input) {

        return loanCalculator.calculateLoan(input);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "Howdy";
    }
}

