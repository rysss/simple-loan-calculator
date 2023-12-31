package ren.dy;

import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ren.dy.entitiy.MonthlyPayment;
import ren.dy.service.LoanCalculator;

import java.util.List;

@Path("/loan")
public class LoanResource {
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

