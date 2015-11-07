package co.com.touresbalon.foundation.oms.webclient;

import co.com.touresbalon.foundation.oms.domain.customers.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by harcalejo on 2/11/15.
 */
@Path("/")
public interface CustomerWebClient {

    @GET
    @Path("/customer/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    CustomerResponseType getCustomerById(@PathParam("id") String customerId);

    @GET
    @Path("/customer/count/id={id};email={email}")
    @Consumes(MediaType.APPLICATION_XML)
    CountCustomersResponseType getCustomerCount(@PathParam("id") String customerId, @PathParam("email") String email);


    @GET
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    GeneralResponseType delete(@PathParam("id") String id);

    @GET
    @Path("/customerByEmail/{email}")
    @Consumes(MediaType.APPLICATION_XML)
    CustomerResponseType getCustomerByEmail(@PathParam("email")String email);

    @GET
    @Path("/customers/pag={pag}/regPag={regPag}")
    @Consumes(MediaType.APPLICATION_XML)
    CustomersResponseType getCustomers(@PathParam("pag")int pag, @PathParam("regPag")int regPag);

    @POST
    @Path("/customer/update")
    UpdateCustomerResponseType updateCustomer(UpdateCustomerType customer);
}
